//! CLI entry point for the feature-extraction pipeline.
//!
//! All pipeline logic lives in the `feature_extraction` library crate
//! ([`lib.rs`](lib.rs)); this binary only parses arguments, wires the walker
//! to the CSV writer, and prints a summary. Keeping the logic in the library
//! lets integration tests exercise the same code without a subprocess.

use std::env;
use std::path::PathBuf;

use feature_extraction::{output, walker};

fn main() {
    let args: Vec<String> = env::args().collect();
    let Some(dataset_root) = args.get(1) else {
        eprintln!("usage: {} <dataset_root> [output.csv]", args[0]);
        eprintln!("  dataset_root : root containing C/, C++/, Java/, Python/ subfolders");
        eprintln!("  output.csv   : optional output path (default: features.csv)");
        std::process::exit(2);
    };
    let dataset_root = PathBuf::from(dataset_root);
    let output_path = args
        .get(2)
        .map(PathBuf::from)
        .unwrap_or_else(|| PathBuf::from("features.csv"));

    if !dataset_root.is_dir() {
        eprintln!(
            "error: dataset root is not a directory: {}",
            dataset_root.display()
        );
        std::process::exit(1);
    }

    // Step 2: walk language -> tier -> file.
    let samples = walker::walk_dataset(&dataset_root);
    eprintln!("[pipeline] collected {} source files", samples.len());

    // Steps 3-6: per-file feature extraction + row assembly + dedup.
    let (rows, summary) = output::build_rows(&samples);

    // Step 6: write CSV.
    if let Err(e) = output::write_csv(&output_path, &rows) {
        eprintln!(
            "error: failed to write CSV {}: {}",
            output_path.display(),
            e
        );
        std::process::exit(1);
    }
    eprintln!(
        "[pipeline] wrote {} rows to {}",
        rows.len(),
        output_path.display()
    );

    print_summary(rows.len(), &summary);
}

/// Final summary: total files, counts per language/tier, parse-error count.
fn print_summary(total: usize, summary: &output::Summary) {
    println!();
    println!("=== Summary ===");
    println!("Total files processed         : {total}");
    println!("Duplicate rows skipped        : {}", summary.dup_skipped);
    println!(
        "Files with parse_error_flag=1 : {}",
        summary.parse_error_count
    );
    println!();
    println!("Per language / tier:");
    for lang in ["C", "C++", "Java", "Python"] {
        for tier in ["Light", "Heavy"] {
            let count = summary
                .per_lang_tier
                .get(&(lang.to_string(), tier.to_string()))
                .copied()
                .unwrap_or(0);
            println!("  {lang:<7} / {tier:<5} : {count}");
        }
    }
}
