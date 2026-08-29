//! Analysis tool: quantify how much OOP-style / in-class self-recursion the
//! pipeline's conservative `is_recursive` detector misses.
//!
//! The pipeline only flags **bare-name** direct self-calls in C/C++/Python and
//! `this.`/bare calls in Java. This tool counts submissions that contain a
//! self-recursion the pipeline does NOT flag:
//!
//! - Python: `self.<name>(...)` / `cls.<name>(...)` inside a function named
//!   `<name>`.
//! - C++:    in-class methods. The tree-sitter grammar names these with a
//!   `field_identifier` (not `identifier`), so the pipeline cannot even extract
//!   the method name — hence BOTH `this-><name>()` AND bare `<name>()` inside a
//!   method are missed.
//! - Java:   nothing is missed (`this.<name>()` is already caught); counted for
//!   completeness only.
//!
//! Usage:
//! ```text
//! cargo run --bin missed_recursion -- <dataset_root>
//! cargo run --bin missed_recursion -- --dump <file> <C|C++|Java|Python>
//! ```

use std::collections::{HashMap, HashSet};
use std::path::PathBuf;

use feature_extraction::language::Language;
use feature_extraction::{features, walker};
use tree_sitter::{Node, Parser};

/// Iterative DFS over the whole tree (safe on deep trees).
fn for_each_node<'tree>(root: Node<'tree>, mut f: impl FnMut(Node<'tree>)) {
    let mut stack = vec![root];
    while let Some(node) = stack.pop() {
        f(node);
        let mut cursor = node.walk();
        for child in node.children(&mut cursor) {
            stack.push(child);
        }
    }
}

/// Unwrap declarator wrappers down to the base identifier.
/// Handles BOTH `identifier` (free functions) and `field_identifier`
/// (in-class C++ methods) — the pipeline only handles `identifier`, which is
/// exactly the gap this tool is measuring.
fn base_identifier(mut node: Node) -> Option<Node> {
    loop {
        match node.kind() {
            "identifier" | "field_identifier" => return Some(node),
            "pointer_declarator" | "parenthesized_declarator" | "reference_declarator" => {
                node = node.named_child(0)?;
            }
            _ => return None,
        }
    }
}

/// Extract a C/C++ function/method name from a `function_definition`.
/// Returns `(name, is_in_class_method)` — `is_in_class_method` is true when
/// the name is a `field_identifier` (i.e. the pipeline cannot see it).
fn cpp_function_name(fn_node: Node, bytes: &[u8]) -> Option<(String, bool)> {
    let declarator = fn_node.child_by_field_name("declarator")?;
    if declarator.kind() != "function_declarator" {
        return None;
    }
    let inner = declarator.child_by_field_name("declarator")?;
    let ident = base_identifier(inner)?;
    let is_method = ident.kind() == "field_identifier";
    Some((ident.utf8_text(bytes).ok()?.to_string(), is_method))
}

/// Java: does the source contain `this.<name>()` inside a method named `<name>`?
/// These ARE caught by the pipeline (reported, not missed).
fn detect_java_this(source: &str) -> bool {
    let mut parser = Parser::new();
    parser
        .set_language(Language::Java.tree_sitter_language())
        .expect("grammar");
    let tree = parser.parse(source, None).expect("parse");
    let root = tree.root_node();
    let bytes = source.as_bytes();

    let mut methods: Vec<(String, Node)> = Vec::new();
    for_each_node(root, |n| {
        if n.kind() == "method_declaration" {
            if let Some(name) = n
                .child_by_field_name("name")
                .and_then(|c| c.utf8_text(bytes).ok())
                .map(|s| s.to_string())
            {
                methods.push((name, n));
            }
        }
    });
    for (name, method) in methods {
        let Some(body) = method.child_by_field_name("body") else {
            continue;
        };
        let mut found = false;
        for_each_node(body, |m| {
            if found {
                return;
            }
            if m.kind() == "method_invocation" {
                let is_this = m
                    .child_by_field_name("object")
                    .and_then(|o| o.utf8_text(bytes).ok())
                    .map(|t| t == "this")
                    .unwrap_or(false);
                let invoked = m
                    .child_by_field_name("name")
                    .and_then(|c| c.utf8_text(bytes).ok())
                    .unwrap_or("");
                if is_this && invoked == name {
                    found = true;
                }
            }
        });
        if found {
            return true;
        }
    }
    false
}

/// Python: does the source contain `self.<name>()` / `cls.<name>()` inside a
/// function named `<name>`? (Missed by the pipeline.)
fn detect_python_self(source: &str) -> bool {
    let mut parser = Parser::new();
    parser
        .set_language(Language::Python.tree_sitter_language())
        .expect("grammar");
    let tree = parser.parse(source, None).expect("parse");
    let root = tree.root_node();
    let bytes = source.as_bytes();

    let mut functions: Vec<(String, Node)> = Vec::new();
    for_each_node(root, |n| {
        if n.kind() == "function_definition" {
            if let Some(name) = n
                .child_by_field_name("name")
                .and_then(|c| c.utf8_text(bytes).ok())
                .map(|s| s.to_string())
            {
                functions.push((name, n));
            }
        }
    });
    for (name, fn_node) in functions {
        let Some(body) = fn_node.child_by_field_name("body") else {
            continue;
        };
        let mut found = false;
        for_each_node(body, |m| {
            if found {
                return;
            }
            if m.kind() == "call" {
                if let Some(c) = m.child_by_field_name("function") {
                    if c.kind() == "attribute" {
                        let obj = c
                            .child_by_field_name("object")
                            .and_then(|o| o.utf8_text(bytes).ok())
                            .unwrap_or("");
                        let attr = c
                            .child_by_field_name("attribute")
                            .and_then(|a| a.utf8_text(bytes).ok())
                            .unwrap_or("");
                        if (obj == "self" || obj == "cls") && attr == name {
                            found = true;
                        }
                    }
                }
            }
        });
        if found {
            return true;
        }
    }
    false
}

/// C++: does the source contain self-recursion the pipeline cannot see?
/// Returns `(has_this_arrow, is_missed)`.
/// - `has_this_arrow`: a `this-><name>()` self-call exists (user's exact ask).
/// - `is_missed`: an in-class method (field_identifier name) calls its own
///   name, either via `this-><name>()` OR bare `<name>()`. Both are missed by
///   the pipeline because it cannot extract `field_identifier` method names.
fn detect_cpp_missed(source: &str) -> (bool, bool) {
    let mut parser = Parser::new();
    parser
        .set_language(Language::Cpp.tree_sitter_language())
        .expect("grammar");
    let tree = parser.parse(source, None).expect("parse");
    let root = tree.root_node();
    let bytes = source.as_bytes();

    let mut functions: Vec<(String, bool, Node)> = Vec::new();
    for_each_node(root, |n| {
        if n.kind() == "function_definition" {
            if let Some((name, is_method)) = cpp_function_name(n, bytes) {
                functions.push((name, is_method, n));
            }
        }
    });

    let mut has_this_arrow = false;
    let mut missed = false;
    for (name, is_method, fn_node) in functions {
        let Some(body) = fn_node.child_by_field_name("body") else {
            continue;
        };
        let mut has_bare = false;
        let mut has_this = false;
        // Search for call sites inside this body.
        for_each_node(body, |m| {
            if m.kind() != "call_expression" {
                return;
            }
            let callee = match m.child_by_field_name("function") {
                Some(c) => c,
                None => return,
            };
            match callee.kind() {
                "identifier" => {
                    if callee.utf8_text(bytes).ok() == Some(name.as_str()) {
                        has_bare = true;
                    }
                }
                "field_expression" => {
                    let arg_is_this = callee
                        .child_by_field_name("argument")
                        .and_then(|a| a.utf8_text(bytes).ok())
                        .map(|t| t == "this")
                        .unwrap_or(false);
                    let field_is_name = callee
                        .child_by_field_name("field")
                        .and_then(|f| f.utf8_text(bytes).ok())
                        .map(|f| f == name.as_str())
                        .unwrap_or(false);
                    if arg_is_this && field_is_name {
                        has_this = true;
                    }
                }
                _ => {}
            }
        });
        if has_this {
            has_this_arrow = true;
        }
        if is_method && (has_bare || has_this) {
            missed = true;
        }
    }
    (has_this_arrow, missed)
}

/// Debug helper: print a parse tree with field annotations (like `probe`).
fn print_tree(node: Node, source: &[u8], depth: usize) {
    let indent = "  ".repeat(depth);
    let preview: String = node
        .utf8_text(source)
        .unwrap_or("")
        .chars()
        .take(40)
        .collect();
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

fn main() {
    let args: Vec<String> = std::env::args().collect();

    // `--dump <file> <lang>`: print the parse tree for one file.
    if args.get(1).map(|s| s.as_str()) == Some("--dump") {
        let path = args.get(2).expect("usage: --dump <file> <C|C++|Java|Python>");
        let lang = match args.get(3).map(|s| s.as_str()) {
            Some("C") => Language::C,
            Some("C++") => Language::Cpp,
            Some("Java") => Language::Java,
            Some("Python") => Language::Python,
            _ => panic!("bad language; expected C, C++, Java, or Python"),
        };
        let source = std::fs::read_to_string(path).expect("read file");
        let mut parser = Parser::new();
        parser
            .set_language(lang.tree_sitter_language())
            .expect("grammar load");
        let tree = parser.parse(&source, None).expect("parse");
        println!("=== {} ({}) ===", path, lang);
        print_tree(tree.root_node(), source.as_bytes(), 0);
        return;
    }

    let Some(dataset_root) = args.get(1) else {
        eprintln!("usage: {} <dataset_root>", args[0]);
        std::process::exit(2);
    };
    let root = PathBuf::from(dataset_root);

    let samples = walker::walk_dataset(&root);
    eprintln!("[analysis] collected {} raw samples", samples.len());

    // Mirror the pipeline exactly: de-duplicate on (submission_id, language).
    let mut seen: HashSet<(String, String)> = HashSet::with_capacity(samples.len());
    let mut total = 0usize;
    let mut reported_recursive = 0usize;
    let mut oop_self = 0usize; // self./cls./this-> self-call (user's ask)
    let mut missed = 0usize; // self-call the pipeline fails to flag AND is_recursive=0
    let mut parse_errors = 0usize;

    let mut per_lang_total: HashMap<String, usize> = HashMap::new();
    let mut per_lang_reported: HashMap<String, usize> = HashMap::new();
    let mut per_lang_oop: HashMap<String, usize> = HashMap::new();
    let mut per_lang_missed: HashMap<String, usize> = HashMap::new();

    for s in &samples {
        let key = (s.submission_id.clone(), s.language.as_str().to_string());
        if !seen.insert(key) {
            continue;
        }
        total += 1;
        *per_lang_total.entry(s.language.as_str().to_string()).or_insert(0) += 1;

        let feats = features::compute_features(&s.source, s.language);
        if feats.parse_error_flag {
            parse_errors += 1;
        }
        if feats.is_recursive {
            reported_recursive += 1;
            *per_lang_reported.entry(s.language.as_str().to_string()).or_insert(0) += 1;
        }

        let (has_oop, this_missed) = match s.language {
            Language::C => (false, false),
            Language::Cpp => detect_cpp_missed(&s.source),
            Language::Java => (detect_java_this(&s.source), false),
            Language::Python => {
                let s_ = detect_python_self(&s.source);
                (s_, s_)
            }
        };

        if has_oop {
            oop_self += 1;
            *per_lang_oop.entry(s.language.as_str().to_string()).or_insert(0) += 1;
        }
        if this_missed && !feats.is_recursive {
            missed += 1;
            *per_lang_missed.entry(s.language.as_str().to_string()).or_insert(0) += 1;
        }
    }

    println!("\n=== Missed OOP self-recursion analysis ===");
    println!("Dataset root            : {}", root.display());
    println!("Total submissions       : {}", total);
    println!("Parse-error submissions : {}", parse_errors);
    println!();
    println!("Reported is_recursive=1 : {}", reported_recursive);
    println!("With OOP self-call (self./cls./this->) : {}", oop_self);
    println!("MISSED (self-call unseen by pipeline, is_recursive=0) : {}", missed);
    println!();

    println!("Per language:");
    println!(
        "  {:<7} {:>8} {:>10} {:>12} {:>8}",
        "lang", "total", "reported", "oop_self", "missed"
    );
    for lang in ["C", "C++", "Java", "Python"] {
        let t = per_lang_total.get(lang).copied().unwrap_or(0);
        let r = per_lang_reported.get(lang).copied().unwrap_or(0);
        let o = per_lang_oop.get(lang).copied().unwrap_or(0);
        let m = per_lang_missed.get(lang).copied().unwrap_or(0);
        println!("  {lang:<7} {t:>8} {r:>10} {o:>12} {m:>8}");
    }

    println!("\nDecision guide:");
    let total_rec = reported_recursive + missed;
    let miss_frac = if total_rec > 0 {
        missed as f64 / total_rec as f64
    } else {
        0.0
    };
    println!(
        "  missed / (reported + missed) = {} / {} = {:.1}% of all recursion",
        missed,
        total_rec,
        miss_frac * 100.0
    );
    println!(
        "  missed as fraction of all submissions = {:.2}%",
        (missed as f64 / total as f64) * 100.0
    );
}
