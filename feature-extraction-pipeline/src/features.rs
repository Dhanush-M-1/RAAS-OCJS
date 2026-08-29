//! Pure feature-extraction logic (pipeline steps 3-4).
//!
//! Everything in this module takes a source string + a [`Language`] and returns
//! feature values. It performs **no file I/O and no directory walking**, so the
//! same code can be reused later inside a live judge on a single incoming
//! submission, not only in this offline batch context.
//!
//! All tree-sitter node type names used below were verified against real parse
//! trees (see `src/bin/probe.rs`), not guessed.

use tree_sitter::{Node, Parser};

use crate::language::Language;

/// Allocations whose statically-known size is strictly **above** this threshold
/// are flagged as "large". This is a named constant (not a magic number) so it
/// can be tuned in one place. Units are intentionally uniform even though APIs
/// size in bytes (malloc/calloc) vs. element counts (`new T[n]`, `.reserve(n)`,
/// Java collection initial capacities, Python container repetition).
pub const LARGE_ALLOC_THRESHOLD: u64 = 1_000_000;

/// Computed features for a single submission.
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub struct Features {
    /// Deepest nesting of for/while/if constructs. else-if / elif chains do NOT
    /// add extra depth (see `compute_nesting_depth` for the verified rationale).
    pub nesting_depth: u32,
    /// McCabe cyclomatic complexity = 1 + decision points (if, for, while,
    /// case, &&, ||, ternary).
    pub cyclomatic_complexity: u32,
    /// `true` if any function calls itself by name within its own body.
    /// Direct recursion only — mutual recursion is a documented limitation.
    pub is_recursive: bool,
    /// `true` if a static allocation (malloc, `new T[]`, `.reserve()`,
    /// collection-with-initial-capacity, container repetition, ...) is found
    /// with a literal size above [`LARGE_ALLOC_THRESHOLD`]. Sizes given by a
    /// variable are undetectable statically and are never flagged (documented
    /// limitation).
    pub large_alloc_flag: bool,
    /// `true` if the parse tree contains any ERROR node. When set, the four
    /// features are still computed best-effort, but the row should be
    /// inspected/filtered rather than silently trusted.
    pub parse_error_flag: bool,
    /// Count of ERROR nodes in the tree (informational / diagnostics).
    pub error_node_count: usize,
}

/// Pure entry point: source code + language in, feature values out.
pub fn compute_features(source: &str, lang: Language) -> Features {
    let mut parser = Parser::new();
    parser
        .set_language(lang.tree_sitter_language())
        .expect("grammar is a compile-time constant; loading cannot fail");
    let tree = parser
        .parse(source, None)
        .expect("tree-sitter parse unexpectedly returned None");

    let root = tree.root_node();
    let error_node_count = count_error_nodes(root);
    let parse_error_flag = error_node_count > 0;

    let nesting_depth = compute_nesting_depth(root, lang);
    let cyclomatic_complexity = 1 + count_decision_points(root, source);
    let is_recursive = detect_recursion(root, lang, source);
    let large_alloc_flag = detect_large_allocation(root, lang, source);

    Features {
        nesting_depth,
        cyclomatic_complexity,
        is_recursive,
        large_alloc_flag,
        parse_error_flag,
        error_node_count,
    }
}

/// Visit every node in the subtree exactly once (iterative DFS; no recursion so
/// it is safe even on deep trees).
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

fn count_error_nodes(root: Node) -> usize {
    let mut count = 0;
    for_each_node(root, |n| {
        if n.is_error() {
            count += 1;
        }
    });
    count
}

// ---------------------------------------------------------------------------
// nesting_depth
// ---------------------------------------------------------------------------

/// Deepest nesting of loop/conditional constructs (for/while/if).
///
/// else-if chain structure, **verified from real parse trees** (probe output):
/// - C/C++: `if ... else if ...` nests the next `if_statement` inside an
///   `else_clause`. Naively descending would overcount depth, so those
///   continuation `if_statement`s are collapsed (kept at the same depth).
/// - Java: the continuation `if_statement` is the `alternative` field of the
///   parent `if_statement`, directly after `else`. Same collapsing applies.
/// - Python: `elif` clauses are FLAT siblings of the same `if_statement`
///   (multiple `elif_clause` nodes at one level), so there is nothing to
///   collapse there.
fn compute_nesting_depth(root: Node, lang: Language) -> u32 {
    let mut max = 0u32;
    walk_nesting(root, 0, lang, &mut max);
    max
}

fn walk_nesting(node: Node, depth: u32, lang: Language, max: &mut u32) {
    let is_control =
        matches!(node.kind(), "if_statement" | "for_statement" | "while_statement");
    let is_continuation = is_else_if_continuation(node, lang);

    let child_depth = if is_control && !is_continuation {
        *max = (*max).max(depth + 1);
        depth + 1
    } else {
        depth
    };

    let mut cursor = node.walk();
    for child in node.children(&mut cursor) {
        walk_nesting(child, child_depth, lang, max);
    }
}

/// True when `node` is an `if_statement` that continues an `else if` chain and
/// therefore must NOT add extra nesting depth.
fn is_else_if_continuation(node: Node, lang: Language) -> bool {
    if node.kind() != "if_statement" {
        return false;
    }
    match lang {
        // C/C++: an else-if continuation lives directly inside an `else_clause`.
        Language::C | Language::Cpp => match node.parent() {
            Some(p) => p.kind() == "else_clause",
            None => false,
        },
        // Java: the continuation is the `alternative` field of a parent
        // `if_statement`.
        Language::Java => match node.parent() {
            Some(p) => {
                p.kind() == "if_statement"
                    && p.child_by_field_name("alternative")
                        .map(|a| a == node)
                        .unwrap_or(false)
            }
            None => false,
        },
        // Python elif is a flat sibling; no nested if continuation exists.
        Language::Python => false,
    }
}

// ---------------------------------------------------------------------------
// cyclomatic_complexity
// ---------------------------------------------------------------------------

/// Count decision points: if, for, while, case, &&, ||, ternary.
/// Cyclomatic complexity = 1 + this count (the +1 is applied by the caller).
fn count_decision_points(root: Node, source: &str) -> u32 {
    let bytes = source.as_bytes();
    let mut count = 0u32;
    for_each_node(root, |n| {
        count += match n.kind() {
            // if / for / while are decisions in every language. Note that
            // else-if continuations ARE counted here (each `else if` is its own
            // decision point per McCabe), unlike nesting_depth where they do
            // not add depth. Python `elif_clause`s are separate node kinds that
            // each represent one more decision in the chain.
            "if_statement" | "elif_clause" | "for_statement" | "while_statement" => 1,
            // case labels: C/C++ `case_statement`, Java `switch_label`,
            // Python `case_clause` (all verified).
            "case_statement" | "case_clause" | "switch_label" => 1,
            // ternary: C/C++/Python `conditional_expression`, Java
            // `ternary_expression` (all verified).
            "conditional_expression" | "ternary_expression" => 1,
            // Python boolean operators (and/or).
            "boolean_operator" => 1,
            // C/C++/Java: binary expressions whose operator is && or ||.
            "binary_expression" => {
                let is_bool_op = n
                    .child_by_field_name("operator")
                    .and_then(|op| op.utf8_text(bytes).ok())
                    .map(|op| op == "&&" || op == "||")
                    .unwrap_or(false);
                if is_bool_op {
                    1
                } else {
                    0
                }
            }
            _ => 0,
        };
    });
    count
}

// ---------------------------------------------------------------------------
// is_recursive
// ---------------------------------------------------------------------------

/// Detect direct recursion: any function calling ITSELF by name inside its own
/// body.
///
/// KNOWN LIMITATION: mutual recursion (A calls B, B calls A) is intentionally
/// out of scope for this version. Indirect/self-calls through pointers,
/// function objects, or `obj.method()` on another object are also not flagged.
fn detect_recursion(root: Node, lang: Language, source: &str) -> bool {
    match lang {
        Language::C | Language::Cpp => detect_recursion_c_like(root, source),
        Language::Java => detect_recursion_java(root, source),
        Language::Python => detect_recursion_python(root, source),
    }
}

fn detect_recursion_c_like(root: Node, source: &str) -> bool {
    let bytes = source.as_bytes();
    let mut functions: Vec<(String, Node)> = Vec::new();
    for_each_node(root, |n| {
        if n.kind() == "function_definition" {
            if let Some(name) = c_like_function_name(n, bytes) {
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
            if m.kind() == "call_expression" {
                let callee = m.child_by_field_name("function");
                let is_direct = callee.map(|c| c.kind() == "identifier").unwrap_or(false);
                if is_direct {
                    let callee_text = callee.and_then(|c| c.utf8_text(bytes).ok()).unwrap_or("");
                    if callee_text == name {
                        found = true;
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

/// Extract the name of a C/C++ function definition. The name is the base
/// identifier of the `declarator` field of the `function_declarator`, possibly
/// wrapped in pointer/parenthesized declarators.
fn c_like_function_name(fn_node: Node, bytes: &[u8]) -> Option<String> {
    let declarator = fn_node.child_by_field_name("declarator")?;
    if declarator.kind() != "function_declarator" {
        return None;
    }
    let inner = declarator.child_by_field_name("declarator")?;
    let ident = base_identifier(inner)?;
    ident.utf8_text(bytes).ok().map(|s| s.to_string())
}

/// Walk through declarator wrappers down to the base identifier.
///
/// Accepts both `identifier` (free functions, and method names that happen to
/// parse as plain identifiers) and `field_identifier` (in-class C++ methods:
/// the tree-sitter-cpp grammar names `void rec(int n) {}` inside a class with
/// a `field_identifier`, not an `identifier`). Without this, in-class method
/// names were never extracted, so a method calling itself by bare name was
/// never flagged as recursive.
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

fn detect_recursion_java(root: Node, source: &str) -> bool {
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
                let invoked = m
                    .child_by_field_name("name")
                    .and_then(|c| c.utf8_text(bytes).ok())
                    .unwrap_or("");
                if invoked == name {
                    // Direct self-call: no explicit receiver, or receiver is
                    // `this`. Calling the same method name on some other object
                    // is NOT self-recursion and is excluded (mutual / indirect
                    // calls are out of scope).
                    let external_receiver = m
                        .child_by_field_name("object")
                        .map(|o| o.utf8_text(bytes).map(|t| t != "this").unwrap_or(true))
                        .unwrap_or(false);
                    if !external_receiver {
                        found = true;
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

fn detect_recursion_python(root: Node, source: &str) -> bool {
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
                let callee = m.child_by_field_name("function");
                let is_direct = callee.map(|c| c.kind() == "identifier").unwrap_or(false);
                if is_direct {
                    let callee_text = callee.and_then(|c| c.utf8_text(bytes).ok()).unwrap_or("");
                    if callee_text == name {
                        found = true;
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

// ---------------------------------------------------------------------------
// large_alloc_flag
// ---------------------------------------------------------------------------

fn detect_large_allocation(root: Node, lang: Language, source: &str) -> bool {
    match lang {
        Language::C => detect_large_alloc_c(root, source),
        Language::Cpp => detect_large_alloc_cpp(root, source),
        Language::Java => detect_large_alloc_java(root, source),
        Language::Python => detect_large_alloc_python(root, source),
    }
}

/// Is the statically-known size (if any) above the threshold?
fn above_threshold(size: Option<u64>) -> bool {
    size.map(|s| s > LARGE_ALLOC_THRESHOLD).unwrap_or(false)
}

/// Read the `index`-th argument of an `argument_list` and evaluate it as a
/// constant. Returns `None` when the argument is not a compile-time constant
/// (e.g. a variable name).
fn arg_const(args: Node, index: usize, bytes: &[u8]) -> Option<u64> {
    let arg = args.named_child(index)?;
    const_eval(arg, bytes)
}

fn detect_large_alloc_c(root: Node, source: &str) -> bool {
    let bytes = source.as_bytes();
    let mut flagged = false;
    for_each_node(root, |n| {
        if flagged {
            return;
        }
        if n.kind() != "call_expression" {
            return;
        }
        let callee = match n.child_by_field_name("function") {
            Some(c) if c.kind() == "identifier" => c,
            _ => return,
        };
        let name = callee.utf8_text(bytes).unwrap_or("");
        let args = match n.child_by_field_name("arguments") {
            Some(a) => a,
            None => return,
        };
        let size = c_alloc_size(name, args, bytes);
        if above_threshold(size) {
            flagged = true;
        }
    });
    flagged
}

/// Total allocation size for a C allocator call, when fully static:
/// - malloc / realloc : first argument (bytes)
/// - calloc           : count * element size (both must be literal)
/// - aligned_alloc    : second argument (bytes; first is alignment)
fn c_alloc_size(name: &str, args: Node, bytes: &[u8]) -> Option<u64> {
    match name {
        "malloc" | "realloc" => arg_const(args, 0, bytes),
        "calloc" => {
            let count = arg_const(args, 0, bytes)?;
            let elem = arg_const(args, 1, bytes)?;
            count.checked_mul(elem)
        }
        "aligned_alloc" => arg_const(args, 1, bytes),
        _ => None,
    }
}

fn detect_large_alloc_cpp(root: Node, source: &str) -> bool {
    let bytes = source.as_bytes();
    let mut flagged = false;
    for_each_node(root, |n| {
        if flagged {
            return;
        }
        match n.kind() {
            // v.reserve(n) / v.resize(n)
            "call_expression" => {
                let callee = match n.child_by_field_name("function") {
                    Some(c) if c.kind() == "field_expression" => c,
                    _ => return,
                };
                // field_expression children: object, '.', field_identifier
                let member = callee.named_child(1);
                let Some(member) = member else {
                    return;
                };
                if member.kind() != "field_identifier" {
                    return;
                }
                let member_name = member.utf8_text(bytes).unwrap_or("");
                if member_name != "reserve" && member_name != "resize" {
                    return;
                }
                let args = match n.child_by_field_name("arguments") {
                    Some(a) => a,
                    None => return,
                };
                if above_threshold(arg_const(args, 0, bytes)) {
                    flagged = true;
                }
            }
            // new T[n]
            "new_expression" => {
                let mut cursor = n.walk();
                for child in n.children(&mut cursor) {
                    if child.kind() == "new_declarator" {
                        // the size expression is the named child inside brackets
                        if let Some(size_node) = child.named_child(0) {
                            if above_threshold(const_eval(size_node, bytes)) {
                                flagged = true;
                            }
                        }
                    }
                }
            }
            _ => {}
        }
    });
    flagged
}

fn detect_large_alloc_java(root: Node, source: &str) -> bool {
    let bytes = source.as_bytes();
    let mut flagged = false;
    for_each_node(root, |n| {
        if flagged {
            return;
        }
        match n.kind() {
            // new int[10000]
            "array_creation_expression" => {
                let mut cursor = n.walk();
                for child in n.children(&mut cursor) {
                    if child.kind() == "dimensions_expr" {
                        if let Some(size_node) = child.named_child(0) {
                            if above_threshold(const_eval(size_node, bytes)) {
                                flagged = true;
                            }
                        }
                    }
                }
            }
            // new ArrayList<>(5000) / new HashMap<>(n) / ...
            "object_creation_expression" => {
                let Some(type_name) = object_creation_type(n, bytes) else {
                    return;
                };
                if !is_capacity_collection(&type_name) {
                    return;
                }
                let args = match n.child_by_field_name("arguments") {
                    Some(a) => a,
                    None => return,
                };
                // first constructor argument is the initial capacity
                if above_threshold(arg_const(args, 0, bytes)) {
                    flagged = true;
                }
            }
            _ => {}
        }
    });
    flagged
}

/// The created type name inside an `object_creation_expression` (e.g. "ArrayList").
fn object_creation_type(node: Node, bytes: &[u8]) -> Option<String> {
    let mut cursor = node.walk();
    for child in node.children(&mut cursor) {
        match child.kind() {
            "type_identifier" => return child.utf8_text(bytes).ok().map(|s| s.to_string()),
            "generic_type" => {
                let mut c = child.walk();
                for gc in child.children(&mut c) {
                    if gc.kind() == "type_identifier" {
                        return gc.utf8_text(bytes).ok().map(|s| s.to_string());
                    }
                }
            }
            _ => {}
        }
    }
    None
}

/// Standard-library collection types whose constructor takes an initial capacity.
fn is_capacity_collection(name: &str) -> bool {
    matches!(
        name,
        "ArrayList"
            | "Vector"
            | "HashMap"
            | "HashSet"
            | "LinkedHashMap"
            | "LinkedHashSet"
            | "TreeMap"
            | "TreeSet"
            | "ArrayDeque"
            | "PriorityQueue"
            | "StringBuilder"
            | "StringBuffer"
            | "ArrayBlockingQueue"
            | "LinkedBlockingQueue"
    )
}

fn detect_large_alloc_python(root: Node, source: &str) -> bool {
    let bytes = source.as_bytes();
    let mut flagged = false;
    for_each_node(root, |n| {
        if flagged {
            return;
        }
        match n.kind() {
            // [0] * 1000000  (container repetition with a literal count)
            "binary_operator" => {
                let op_is_star = n
                    .child_by_field_name("operator")
                    .and_then(|o| o.utf8_text(bytes).ok())
                    .map(|op| op == "*")
                    .unwrap_or(false);
                if !op_is_star {
                    return;
                }
                let left = n.child_by_field_name("left");
                let left_is_container = left
                    .map(|l| {
                        matches!(l.kind(), "list" | "tuple" | "set" | "dictionary" | "string")
                    })
                    .unwrap_or(false);
                if !left_is_container {
                    return;
                }
                if let Some(right) = n.child_by_field_name("right") {
                    if above_threshold(const_eval(right, bytes)) {
                        flagged = true;
                    }
                }
            }
            // bytearray(2000000)
            "call" => {
                let callee = match n.child_by_field_name("function") {
                    Some(c) if c.kind() == "identifier" => c,
                    _ => return,
                };
                let name = callee.utf8_text(bytes).unwrap_or("");
                if name != "bytearray" {
                    return;
                }
                let args = match n.child_by_field_name("arguments") {
                    Some(a) => a,
                    None => return,
                };
                if above_threshold(arg_const(args, 0, bytes)) {
                    flagged = true;
                }
            }
            _ => {}
        }
    });
    flagged
}

// ---------------------------------------------------------------------------
// constant evaluation (literal-only arithmetic)
// ---------------------------------------------------------------------------

/// Statically evaluate a numeric expression built ONLY from number literals and
/// arithmetic operators. Returns `None` when the expression is not a
/// compile-time constant — e.g. `malloc(n * 4)` — which is intentional:
/// allocations sized by a variable are undetectable statically and are never
/// flagged (known, accepted limitation).
fn const_eval(node: Node, bytes: &[u8]) -> Option<u64> {
    match node.kind() {
        // number literals per language (verified node names)
        "number_literal" | "decimal_integer_literal" | "integer" | "decimal_float_literal"
        | "hex_integer_literal" => parse_num(node.utf8_text(bytes).ok()?),
        "parenthesized_expression" => const_eval(node.named_child(0)?, bytes),
        "binary_expression" | "binary_operator" => {
            let left = node.child_by_field_name("left")?;
            let right = node.child_by_field_name("right")?;
            let op = node.child_by_field_name("operator")?;
            let op_text = op.utf8_text(bytes).ok()?;
            let l = const_eval(left, bytes)?;
            let r = const_eval(right, bytes)?;
            match op_text {
                "*" => l.checked_mul(r),
                "+" => l.checked_add(r),
                "-" => l.checked_sub(r),
                "<<" => l.checked_shl(r as u32),
                ">>" => l.checked_shr(r as u32),
                "/" => (r != 0).then(|| l / r),
                "%" => (r != 0).then(|| l % r),
                "&" => Some(l & r),
                "|" => Some(l | r),
                "^" => Some(l ^ r),
                _ => None,
            }
        }
        _ => None,
    }
}

/// Parse a decimal or hex integer literal, ignoring C/C++/Java numeric suffixes
/// (`L`, `U`, `F`, ...) and Python underscore separators (`1_000_000`).
fn parse_num(text: &str) -> Option<u64> {
    let t = text
        .trim()
        .trim_end_matches(|c: char| matches!(c, 'u' | 'U' | 'l' | 'L' | 'f' | 'F'));
    if let Some(hex) = t.strip_prefix("0x").or_else(|| t.strip_prefix("0X")) {
        u64::from_str_radix(&hex.replace('_', ""), 16).ok()
    } else {
        t.replace('_', "").parse::<u64>().ok()
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    fn feats(src: &str, lang: Language) -> Features {
        compute_features(src, lang)
    }

    // ---- C -----------------------------------------------------------------

    #[test]
    fn c_else_if_chain_does_not_inflate_depth() {
        let f = feats(
            r#"
            int f(int x) {
                if (x < 0) return -1;
                else if (x == 0) return 0;
                else if (x < 100) return 1;
                else return 2;
            }
            "#,
            Language::C,
        );
        assert_eq!(f.nesting_depth, 1, "else-if chain must not add depth");
        assert_eq!(f.cyclomatic_complexity, 4, "3 ifs => 1 + 3");
        assert!(!f.is_recursive);
        assert!(!f.large_alloc_flag);
        assert!(!f.parse_error_flag);
    }

    #[test]
    fn c_nested_for_while_if() {
        let f = feats(
            r#"
            int f(int a, int b) {
                for (int i = 0; i < a; i++) {
                    while (b > 0) {
                        if (i % 2 == 0) {
                            b--;
                        }
                    }
                }
                return b;
            }
            "#,
            Language::C,
        );
        assert_eq!(f.nesting_depth, 3);
        assert_eq!(f.cyclomatic_complexity, 4, "for + while + if => 1 + 3");
    }

    #[test]
    fn c_recursive_with_large_literal_alloc() {
        let f = feats(
            r#"
            #include <stdlib.h>
            long fact(long n) {
                if (n <= 1) return 1;
                char *tmp = malloc(5 * 1024 * 1024);
                return n * fact(n - 1);
            }
            "#,
            Language::C,
        );
        assert_eq!(f.nesting_depth, 1);
        assert_eq!(f.cyclomatic_complexity, 2, "1 if => 1 + 1");
        assert!(f.is_recursive, "fact() calls fact()");
        assert!(f.large_alloc_flag, "malloc(5*1024*1024) = 5MB > threshold");
    }

    #[test]
    fn c_variable_sized_alloc_not_flagged() {
        let f = feats(
            r#"
            #include <stdlib.h>
            void f(int n) {
                int *a = malloc(n * 4);
                int *b = malloc(1000);
            }
            "#,
            Language::C,
        );
        assert!(
            !f.large_alloc_flag,
            "variable size not statically detectable; 1000 < threshold"
        );
    }

    #[test]
    fn c_boolean_ops_and_ternary_count_as_decisions() {
        let f = feats(
            r#"
            int f(int a, int b, int c) {
                int r = (a && b) || (a > c ? 1 : 2);
                return r;
            }
            "#,
            Language::C,
        );
        assert_eq!(f.cyclomatic_complexity, 4, "&& + || + ternary => 1 + 3");
        assert_eq!(f.nesting_depth, 0, "no if/for/while");
    }

    #[test]
    fn c_switch_cases_count_as_decisions() {
        let f = feats(
            r#"
            int f(int x) {
                switch (x) {
                    case 1: return 10;
                    case 2: return 20;
                    default: return 0;
                }
            }
            "#,
            Language::C,
        );
        assert_eq!(f.cyclomatic_complexity, 4, "3 case labels => 1 + 3");
        assert_eq!(f.nesting_depth, 0);
    }

    // ---- C++ ---------------------------------------------------------------

    #[test]
    fn cpp_else_if_chain() {
        let f = feats(
            r#"
            int f(int x) {
                if (x < 0) return -1;
                else if (x == 0) return 0;
                else return 2;
            }
            "#,
            Language::Cpp,
        );
        assert_eq!(f.nesting_depth, 1, "else-if chain must not add depth");
        assert_eq!(f.cyclomatic_complexity, 3, "2 ifs => 1 + 2");
    }

    #[test]
    fn cpp_reserve_and_new_array_large() {
        let f = feats(
            r#"
            #include <vector>
            int main() {
                std::vector<int> v;
                v.reserve(2000000);
                int *arr = new int[5000];
                int *big = new int[3000000];
                int m = 5;
                int *var = new int[m];
                return 0;
            }
            "#,
            Language::Cpp,
        );
        assert!(f.large_alloc_flag, "reserve(2M) and new int[3M] both large");
    }

    #[test]
    fn cpp_in_class_method_bare_self_call_is_detected() {
        // In-class C++ methods are named with a `field_identifier` in the
        // tree-sitter-cpp tree, which `base_identifier` previously ignored —
        // so a method calling ITSELF by bare name was never flagged. With the
        // fix, the method name is extracted and the bare self-call is seen.
        let f = feats(
            r#"
            class Node {
            public:
                void rec(int n) {
                    if (n <= 0) return;
                    rec(n - 1);
                }
            };
            "#,
            Language::Cpp,
        );
        assert!(f.is_recursive, "bare self-call inside an in-class method");
        assert_eq!(f.nesting_depth, 1);
        assert_eq!(f.cyclomatic_complexity, 2);
    }

    // ---- Java --------------------------------------------------------------

    #[test]
    fn java_else_if_chain() {
        let f = feats(
            r#"
            class F {
                int f(int x) {
                    if (x < 0) return -1;
                    else if (x == 0) return 0;
                    else if (x < 100) return 1;
                    else return 2;
                }
            }
            "#,
            Language::Java,
        );
        assert_eq!(f.nesting_depth, 1, "else-if chain must not add depth");
        assert_eq!(f.cyclomatic_complexity, 4, "3 ifs => 1 + 3");
        assert!(!f.is_recursive);
    }

    #[test]
    fn java_recursive_with_this_and_large_collection() {
        let f = feats(
            r#"
            import java.util.*;
            class F {
                long fact(int n) {
                    if (n <= 1) return 1;
                    ArrayList<Integer> list = new ArrayList<>(2000000);
                    return n * this.fact(n - 1);
                }
            }
            "#,
            Language::Java,
        );
        assert_eq!(f.nesting_depth, 1);
        assert_eq!(f.cyclomatic_complexity, 2);
        assert!(f.is_recursive, "this.fact(...) is a direct self-call");
        assert!(f.large_alloc_flag, "ArrayList<>(2M) is large");
    }

    #[test]
    fn java_array_alloc_literal_but_variable_not() {
        let f = feats(
            r#"
            class F {
                void g(int n) {
                    int[] a = new int[10000];
                    int[] b = new int[n];
                    int[] c = new int[5000000];
                }
            }
            "#,
            Language::Java,
        );
        assert!(f.large_alloc_flag, "new int[5M] is large");
    }

    #[test]
    fn java_object_call_is_not_self_recursion() {
        let f = feats(
            r#"
            class F {
                int fact(int n) {
                    if (n <= 1) return 1;
                    F other = new F();
                    return other.fact(n - 1);
                }
            }
            "#,
            Language::Java,
        );
        assert!(
            !f.is_recursive,
            "other.fact() has an external receiver => not self-recursion"
        );
    }

    #[test]
    fn java_boolean_and_ternary_count_as_decisions() {
        let f = feats(
            r#"
            class F {
                int f(int a, int b, int c) {
                    int r = (a && b) || (a > c ? 1 : 2);
                    return r;
                }
            }
            "#,
            Language::Java,
        );
        assert_eq!(f.cyclomatic_complexity, 4, "&& + || + ternary => 1 + 3");
    }

    #[test]
    fn java_switch_cases_count_as_decisions() {
        let f = feats(
            r#"
            class F {
                int f(int x) {
                    switch (x) {
                        case 1: return 10;
                        case 2: return 20;
                        default: return 0;
                    }
                }
            }
            "#,
            Language::Java,
        );
        assert_eq!(f.cyclomatic_complexity, 4, "3 switch labels => 1 + 3");
        assert_eq!(f.nesting_depth, 0);
    }

    // ---- Python ------------------------------------------------------------

    #[test]
    fn py_elif_chain_is_flat() {
        let f = feats(
            r#"
            def f(x):
                if x < 0:
                    return -1
                elif x == 0:
                    return 0
                elif x < 100:
                    return 1
                else:
                    return 2
            "#,
            Language::Python,
        );
        // KEY edge case: Python elif clauses are flat siblings of the same
        // if_statement, so the whole chain stays at depth 1.
        assert_eq!(f.nesting_depth, 1, "elif must not add depth");
        assert_eq!(f.cyclomatic_complexity, 4, "if + 2 elif => 1 + 3");
        assert!(!f.is_recursive);
        assert!(!f.large_alloc_flag);
    }

    #[test]
    fn py_nested_for_while_if() {
        let f = feats(
            r#"
            def f(a, b):
                for i in range(a):
                    while b > 0:
                        if i % 2 == 0:
                            b -= 1
                return b
            "#,
            Language::Python,
        );
        assert_eq!(f.nesting_depth, 3);
        assert_eq!(f.cyclomatic_complexity, 4);
    }

    #[test]
    fn py_recursive_with_large_list_repetition() {
        let f = feats(
            r#"
            def fact(n):
                if n <= 1:
                    return 1
                a = [0] * 5000000
                return n * fact(n - 1)
            "#,
            Language::Python,
        );
        assert_eq!(f.nesting_depth, 1);
        assert_eq!(f.cyclomatic_complexity, 2);
        assert!(f.is_recursive, "fact() calls fact()");
        assert!(f.large_alloc_flag, "[0] * 5M is large");
    }

    #[test]
    fn py_variable_sized_alloc_not_flagged() {
        let f = feats(
            r#"
            def f(n):
                a = [0] * n
                b = bytearray(1000)
                return a
            "#,
            Language::Python,
        );
        assert!(
            !f.large_alloc_flag,
            "variable-size repetition undetectable; bytearray(1000) < threshold"
        );
    }

    #[test]
    fn py_mutual_recursion_is_out_of_scope() {
        let f = feats(
            r#"
            def is_even(n):
                if n == 0:
                    return True
                return is_odd(n - 1)

            def is_odd(n):
                if n == 0:
                    return False
                return is_even(n - 1)
            "#,
            Language::Python,
        );
        assert!(
            !f.is_recursive,
            "mutual recursion is intentionally out of scope; each fn calls the other, not itself"
        );
    }

    #[test]
    fn py_boolean_and_ternary_count_as_decisions() {
        let f = feats(
            r#"
            def f(a, b, c):
                r = (a and b) or (c if a else b)
                return r
            "#,
            Language::Python,
        );
        assert_eq!(f.cyclomatic_complexity, 4, "and + or + ternary => 1 + 3");
    }

    #[test]
    fn py_match_cases_count_as_decisions() {
        let f = feats(
            r#"
            def f(x):
                match x:
                    case 1:
                        return 10
                    case 2:
                        return 20
                    case _:
                        return 0
            "#,
            Language::Python,
        );
        assert_eq!(f.cyclomatic_complexity, 4, "3 case clauses => 1 + 3");
        assert_eq!(f.nesting_depth, 0);
    }

    // ---- parse errors ------------------------------------------------------

    #[test]
    fn parse_error_is_flagged_but_features_still_computed() {
        let f = feats("def f(:\n    x = (\n    return x", Language::Python);
        assert!(f.parse_error_flag, "broken Python must set the flag");
        assert!(f.error_node_count >= 1);
        // best-effort features are still produced (here: nothing decision-like)
        assert_eq!(f.cyclomatic_complexity, 1);
    }

    #[test]
    fn clean_c_file_has_no_parse_error() {
        let f = feats("int main(void) { return 0; }", Language::C);
        assert!(!f.parse_error_flag);
        assert_eq!(f.error_node_count, 0);
    }

    // ---- additional edge cases (documented metric definitions) -------------

    #[test]
    fn c_do_while_adds_no_depth_or_complexity() {
        // `do { } while (...)` parses as `do_statement`, which is not in the
        // counted set (only if/for/while are). Lock in that behavior.
        let f = feats(
            r#"
            int f(int x) {
                do { x--; } while (x > 0);
                return x;
            }
            "#,
            Language::C,
        );
        assert_eq!(f.nesting_depth, 0, "do/while is not a counted construct");
        assert_eq!(f.cyclomatic_complexity, 1);
    }

    #[test]
    fn c_switch_inside_loop_adds_complexity_not_depth() {
        let f = feats(
            r#"
            int f(int n) {
                for (int i = 0; i < n; i++) {
                    switch (i) {
                        case 0: return 1;
                        case 1: return 2;
                        default: break;
                    }
                }
                return 0;
            }
            "#,
            Language::C,
        );
        assert_eq!(f.nesting_depth, 1, "switch is not a nesting construct");
        assert_eq!(f.cyclomatic_complexity, 1 + 1 + 3, "for + 3 case labels");
    }

    #[test]
    fn cpp_range_for_is_not_counted_as_nesting() {
        // Range-based for parses as `range_based_for_statement`, which is not
        // in the counted node set. This documents current behavior.
        let f = feats(
            r#"
            #include <vector>
            int f() {
                std::vector<int> v;
                int total = 0;
                for (int x : v) {
                    total += x;
                }
                return total;
            }
            "#,
            Language::Cpp,
        );
        assert_eq!(f.nesting_depth, 0);
        assert_eq!(f.cyclomatic_complexity, 1);
    }

    #[test]
    fn java_deep_nesting() {
        let f = feats(
            r#"
            class F {
                int f(int a, int b, int c) {
                    for (int i = 0; i < a; i++) {
                        for (int j = 0; j < b; j++) {
                            if (i + j < c) {
                                c--;
                            }
                        }
                    }
                    return c;
                }
            }
            "#,
            Language::Java,
        );
        assert_eq!(f.nesting_depth, 3);
        assert_eq!(f.cyclomatic_complexity, 4, "for + for + if => 1 + 3");
    }

    #[test]
    fn py_try_except_adds_no_depth() {
        let f = feats(
            r#"
            def f(x):
                try:
                    if x > 0:
                        return 1
                except Exception:
                    return 2
            "#,
            Language::Python,
        );
        assert_eq!(f.nesting_depth, 1, "try/except is not counted");
        assert_eq!(f.cyclomatic_complexity, 2, "only the inner if is a decision");
    }

    #[test]
    fn c_variable_sized_new_array_not_flagged() {
        let f = feats(
            r#"
            #include <stdlib.h>
            int main() {
                int n = 5;
                int *a = malloc(2000000 * sizeof(int));
                return 0;
            }
            "#,
            Language::C,
        );
        // `2000000 * sizeof(int)` is not fully static (sizeof is not handled),
        // so it is never flagged. Documented limitation.
        assert!(!f.large_alloc_flag);
    }
}
