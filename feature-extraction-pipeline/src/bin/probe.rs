//! Probe: dump real tree-sitter parse trees for hand-written snippets per language.
//! This exists purely to *verify node type names and chain structure* before
//! implementing feature extraction. It is not part of the pipeline itself.
//! The `(field=...)` annotations show tree-sitter field names, useful for
//! `child_by_field_name` lookups.

use tree_sitter::{Node, Parser};

fn print_tree(node: Node, source: &[u8], depth: usize) {
    let indent = "  ".repeat(depth);
    let node_text = node.utf8_text(source).unwrap_or("");
    // truncate long text so output stays readable
    let preview: String = node_text.chars().take(30).collect();
    println!(
        "{}{}{}  [{}]",
        indent,
        node.kind(),
        if node.is_error() { "  <-- ERROR" } else { "" },
        preview.replace('\n', "\\n")
    );

    let mut cursor = node.walk();
    let mut i = 0;
    for child in node.children(&mut cursor) {
        if let Some(field) = node.field_name_for_child(i) {
            println!("{}(field={})", indent, field);
        }
        print_tree(child, source, depth + 1);
        i += 1;
    }
}

fn dump(label: &str, lang: tree_sitter::Language, source: &str) {
    println!("\n========== {} ==========", label);
    let mut parser = Parser::new();
    parser.set_language(lang).expect("Error loading grammar");
    let tree = parser.parse(source, None).unwrap();
    println!("root has_error = {}", tree.root_node().has_error());
    print_tree(tree.root_node(), source.as_bytes(), 0);
}

fn main() {
    let java_switch = r#"
class F {
    int f(int x) {
        switch (x) {
            case 1: return 10;
            case 2: return 20;
            default: return 0;
        }
    }
}
"#;
    dump("Java switch/case", tree_sitter_java::language(), java_switch);

    let java_ternary = r#"
class F {
    int f(int a, int b, int c) {
        int r = (a && b) || (a > c ? 1 : 2);
        return r;
    }
}
"#;
    dump("Java ternary + && ||", tree_sitter_java::language(), java_ternary);

    let java_invocation = r#"
class F {
    int fact(int n) {
        if (n <= 1) return 1;
        int a = this.fact(n - 1);
        F other = new F();
        int b = other.fact(n - 2);
        return a + b;
    }
}
"#;
    dump(
        "Java method_invocation receivers (this. vs obj.)",
        tree_sitter_java::language(),
        java_invocation,
    );

    let java_obj_creation = r#"
class F {
    void g(int n) {
        ArrayList<Integer> c = new ArrayList<Integer>(5000);
        HashMap<String,Integer> d = new HashMap<String,Integer>(n);
        int[] a = new int[10000];
        int[] b = new int[n];
    }
}
"#;
    dump(
        "Java object_creation_expression type/argument fields",
        tree_sitter_java::language(),
        java_obj_creation,
    );

    let cpp_if_chain = r#"
int f(int x) {
    if (x < 0) return -1;
    else if (x == 0) return 0;
    else if (x < 100) return 1;
    else return 2;
}
"#;
    dump("C++ if/else-if chain", tree_sitter_cpp::language(), cpp_if_chain);

    let cpp_ternary = r#"
int f(int a, int b, int c) {
    int r = (a && b) || (a > c ? 1 : 2);
    return r;
}
"#;
    dump("C++ ternary + && ||", tree_sitter_cpp::language(), cpp_ternary);

    let py_while_for = r#"
def f(a, b):
    while a < 10:
        for i in range(b):
            if i > 3:
                break
    return a
"#;
    dump("Python while/for/if (loop node names)", tree_sitter_python::language(), py_while_for);

    let c_hex_size = r#"
#include <stdlib.h>
int main() {
    char *a = malloc(0x100000);
    char *b = malloc(1024 * 1024 + 16);
    return 0;
}
"#;
    dump("C hex and compound literal sizes", tree_sitter_c::language(), c_hex_size);

    let broken_py = r#"
def f(:
    x = (
    return x
"#;
    dump("Broken Python (ERROR nodes)", tree_sitter_python::language(), broken_py);

    // ---- child_by_field_name sanity checks ----
    let jv = r#"
class F {
    int fact(int n) {
        if (n <= 1) return 1;
        return this.fact(n - 1) + fact(n - 2);
    }
}
"#;
    let mut parser = Parser::new();
    parser.set_language(tree_sitter_java::language()).unwrap();
    let tree = parser.parse(jv, None).unwrap();
    let src = jv.as_bytes();
    let mut stack: Vec<Node> = vec![tree.root_node()];
    let mut invocations = 0;
    while let Some(n) = stack.pop() {
        if n.kind() == "method_invocation" {
            let name = n
                .child_by_field_name("name")
                .and_then(|c| c.utf8_text(src).ok())
                .unwrap_or("<none>");
            let obj = n
                .child_by_field_name("object")
                .and_then(|c| c.utf8_text(src).ok())
                .unwrap_or("<none>");
            println!("child_by_field_name: method_invocation name={} object={}", name, obj);
            invocations += 1;
        }
        let mut c = n.walk();
        for ch in n.children(&mut c) {
            stack.push(ch);
        }
    }
    println!("method_invocation count = {}", invocations);

    let mut p2 = Parser::new();
    p2.set_language(tree_sitter_java::language()).unwrap();
    let t2 = p2.parse(jv, None).unwrap();
    let mut st2: Vec<Node> = vec![t2.root_node()];
    while let Some(n) = st2.pop() {
        if n.kind() == "method_declaration" {
            let name = n
                .child_by_field_name("name")
                .and_then(|c| c.utf8_text(src).ok())
                .unwrap_or("<none>");
            println!("child_by_field_name: method_declaration name={}", name);
        }
        let mut c = n.walk();
        for ch in n.children(&mut c) {
            st2.push(ch);
        }
    }
}
