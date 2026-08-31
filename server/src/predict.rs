//! Predictive tier selection: source -> AST features -> XGBoost (m2cgen) -> Tier.
//!
//! The model weights are compiled into Rust by m2cgen (see `src/generated/`).
//! Feature order must match `get_feature_cols()` in `model-training/train_advanced_xgboost.py`:
//!   22 base AST features, then 10 engineered features, then (unified only) 4 language one-hots.

use crate::policy::Tier;
use feature_extraction::features::{compute_features, Features};
use feature_extraction::language::Language;

// Isolated modules so each generated `pub fn score` has its own namespace.
#[path = "generated/specialized_python.rs"]
mod model_python;
#[path = "generated/specialized_cpp.rs"]
mod model_cpp;
#[path = "generated/specialized_java.rs"]
mod model_java;
#[path = "generated/unified_multi_language.rs"]
mod model_unified;

/// Per-language optimal decision thresholds from `model-training/artifacts/model_comparison.csv`.
const THRESHOLD_UNIFIED: f64 = 0.319;
const THRESHOLD_CPP: f64 = 0.346;
const THRESHOLD_JAVA: f64 = 0.257;
const THRESHOLD_PYTHON: f64 = 0.200;

/// Map the judge's lowercase language string to the pipeline's `Language`.
fn to_language(language: &str) -> Option<Language> {
    match language {
        "python" => Some(Language::Python),
        "cpp" | "c++" => Some(Language::Cpp),
        "java" => Some(Language::Java),
        "c" => Some(Language::C),
        _ => None,
    }
}

/// Map `bool` to float for the model.
fn b(x: bool) -> f64 {
    if x { 1.0 } else { 0.0 }
}
fn u32(x: u32) -> f64 {
    x as f64
}
fn u64(x: u64) -> f64 {
    x as f64
}

/// Build the 32-feature vector for the specialized (per-language) models.
/// Order: 22 base AST + 10 engineered. Matches `get_feature_cols(include_language=False)`.
fn specialized_features(f: &Features) -> Vec<f64> {
    let max_nodes = f.ast_node_count.max(1) as f64;
    let max_loc = f.source_loc.max(1) as f64;
    let max_subscripts = f.total_subscripts.max(1) as f64;
    let max_fns = f.total_functions.max(1) as f64;

    vec![
        u32(f.nesting_depth),               // 1 nesting_depth
        u32(f.max_loop_depth),              // 2 max_loop_depth
        u32(f.total_loops),                 // 3 total_loops
        u32(f.cyclomatic_complexity),       // 4 cyclomatic_complexity
        b(f.is_recursive),                  // 5 is_recursive
        u32(f.recursive_call_count),        // 6 recursive_call_count
        b(f.large_alloc_flag),              // 7 large_alloc_flag
        b(f.has_fast_io),                   // 8 has_fast_io
        b(f.has_heavy_datastructure),       // 9 has_heavy_datastructure
        b(f.has_modulo_arithmetic),         // 10 has_modulo_arithmetic
        b(f.has_bitmask_ops),               // 11 has_bitmask_ops
        b(f.has_graph_adjacency),           // 12 has_graph_adjacency
        u32(f.total_functions),             // 13 total_functions
        u32(f.total_calls),                 // 14 total_calls
        u32(f.total_subscripts),            // 15 total_subscripts
        u32(f.total_2d_subscripts),         // 16 total_2d_subscripts
        u32(f.total_arithmetic_ops),        // 17 total_arithmetic_ops
        u64(f.max_integer_constant),        // 18 max_integer_constant
        u32(f.ast_node_count),              // 19 ast_node_count
        u32(f.ast_depth),                   // 20 ast_depth
        u32(f.source_loc),                  // 21 source_loc
        u32(f.source_chars),                // 22 source_chars
        // 10 engineered
        u32(f.total_loops) / max_nodes,             // loop_density
        u32(f.total_calls) / max_nodes,             // call_density
        u32(f.total_subscripts) / max_nodes,        // subscript_density
        u32(f.cyclomatic_complexity) / max_loc,     // branch_density
        u32(f.total_arithmetic_ops) / max_loc,      // arithmetic_density
        u32(f.total_2d_subscripts) / max_subscripts,// subscript_2d_ratio
        u32(f.recursive_call_count) / max_fns,      // recursion_intensity
        (f.max_integer_constant.max(1) as f64).log10(), // log_max_constant
        (1.0 + f.ast_node_count as f64).ln(),       // log_ast_nodes
        (1.0 + f.source_chars as f64).ln(),         // log_source_chars
    ]
}

/// Build the 36-feature vector for the unified multi-language model.
/// Order: 32 features + 4 language one-hots (lang_C, lang_C++, lang_Java, lang_Python).
fn unified_features(f: &Features, lang: Language) -> Vec<f64> {
    let mut v = specialized_features(f);
    let (c, cpp, java, python) = match lang {
        Language::C => (1.0, 0.0, 0.0, 0.0),
        Language::Cpp => (0.0, 1.0, 0.0, 0.0),
        Language::Java => (0.0, 0.0, 1.0, 0.0),
        Language::Python => (0.0, 0.0, 0.0, 1.0),
    };
    v.extend([c, cpp, java, python]);
    v
}

/// Predict whether a submission is Heavy (true) or Light (false), returning the proposed Tier.
/// Uses the per-language specialized model when available, falling back to the unified model.
pub fn predict_tier(source: &str, language: &str) -> Tier {
    let Some(lang) = to_language(language) else {
        // Unsupported language: default to High to be safe (never underestimate).
        return Tier::High;
    };
    let f = compute_features(source, lang);

    // Heavy probability from the appropriate model + threshold.
    let (prob, threshold) = match lang {
        Language::Python => (model_python::score(specialized_features(&f))[1], THRESHOLD_PYTHON),
        Language::Cpp => (model_cpp::score(specialized_features(&f))[1], THRESHOLD_CPP),
        Language::Java => (model_java::score(specialized_features(&f))[1], THRESHOLD_JAVA),
        Language::C => (model_unified::score(unified_features(&f, lang))[1], THRESHOLD_UNIFIED),
    };

    if prob >= threshold {
        Tier::High
    } else {
        Tier::Low
    }
}
