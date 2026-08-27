//! Feature-extraction pipeline for a code-judge dataset.
//!
//! Reads a pre-organized dataset
//! (`<root>/{C,C++,Java,Python}/{Light,Heavy}/*.ext`), computes four source
//! features per file with tree-sitter, and writes a single labeled CSV for
//! training an XGBoost classifier.
//!
//! Usage:
//! ```text
//! cargo run -- <dataset_root> [output.csv]
//! ```
//!
//! The label (Light/Heavy) comes purely from the folder the file sits in; there
//! is no metadata CSV and no cpu_time/memory data in this dataset, so none is
//! computed or referenced.

mod features;
mod language;
mod walker;

use std::collections::{HashMap, HashSet};
use std::env;
use std::fs::File;
use std::io::{BufWriter, Write};
use std::path::{Path, PathBuf};

/// One output CSV row.
struct Row {
    submission_id: String,
    language: String,
    nesting_depth: u32,
    cyclomatic_complexity: u32,
    is_recursive: u32,
    large_alloc_flag: u32,
    parse_error_flag: u32,
    label: String,
}

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

    // Steps 3-6: per-file pure feature extraction + row assembly.
    let mut rows: Vec<Row> = Vec::with_capacity(samples.len());
    let mut seen: HashSet<(String, String)> = HashSet::with_capacity(samples.len());
    let mut per_lang_tier: HashMap<(String, String), usize> = HashMap::new();
    let mut parse_error_count: usize = 0;
    let mut dup_skipped: usize = 0;

    for sample in &samples {
        // One row per (submission_id, language). submission_ids repeat across
        // languages in this dataset layout (e.g. C/Light/s00000001.c and
        // C++/Light/s00000001.cpp both yield id "s00000001"), so the pair
        // (submission_id, language) is the unique file key.
        let key = (
            sample.submission_id.clone(),
            sample.language.as_str().to_string(),
        );
        if !seen.insert(key) {
            eprintln!(
                "[pipeline] skipping duplicate (submission_id, language): {} / {}",
                sample.submission_id, sample.language
            );
            dup_skipped += 1;
            continue;
        }

        // Pure, reusable logic: source + language in, features out.
        let feats = features::compute_features(&sample.source, sample.language);

        if feats.parse_error_flag {
            parse_error_count += 1;
        }
        *per_lang_tier
            .entry((sample.language.as_str().to_string(), sample.label.clone()))
            .or_insert(0) += 1;

        rows.push(Row {
            submission_id: sample.submission_id.clone(),
            language: sample.language.as_str().to_string(),
            nesting_depth: feats.nesting_depth,
            cyclomatic_complexity: feats.cyclomatic_complexity,
            is_recursive: feats.is_recursive as u32,
            large_alloc_flag: feats.large_alloc_flag as u32,
            parse_error_flag: feats.parse_error_flag as u32,
            label: sample.label.clone(),
        });
    }

    // Step 6: write CSV.
    if let Err(e) = write_csv(&output_path, &rows) {
        eprintln!("error: failed to write CSV {}: {}", output_path.display(), e);
        std::process::exit(1);
    }
    eprintln!(
        "[pipeline] wrote {} rows to {}",
        rows.len(),
        output_path.display()
    );

    print_summary(rows.len(), &per_lang_tier, parse_error_count, dup_skipped);
}

/// Write the CSV, UTF-8, header included, one row per file.
fn write_csv(path: &Path, rows: &[Row]) -> std::io::Result<()> {
    let file = File::create(path)?;
    let mut w = BufWriter::new(file);
    w.write_all(
        b"submission_id,language,nesting_depth,cyclomatic_complexity,is_recursive,large_alloc_flag,parse_error_flag,label\n",
    )?;
    for r in rows {
        writeln!(
            w,
            "{},{},{},{},{},{},{},{}",
            csv_escape(&r.submission_id),
            csv_escape(&r.language),
            r.nesting_depth,
            r.cyclomatic_complexity,
            r.is_recursive,
            r.large_alloc_flag,
            r.parse_error_flag,
            csv_escape(&r.label)
        )?;
    }
    w.flush()
}

/// Minimal CSV field escaping (only needed if a field ever contains a comma,
/// quote, or newline — the dataset identifiers do not, but be safe).
fn csv_escape(field: &str) -> String {
    if field.contains(',') || field.contains('"') || field.contains('\n') {
        format!("\"{}\"", field.replace('"', "\"\""))
    } else {
        field.to_string()
    }
}

/// Final summary: total files, counts per language/tier, parse-error count.
fn print_summary(
    total: usize,
    per_lang_tier: &HashMap<(String, String), usize>,
    parse_error_count: usize,
    dup_skipped: usize,
) {
    println!();
    println!("=== Summary ===");
    println!("Total files processed         : {total}");
    println!("Duplicate rows skipped        : {dup_skipped}");
    println!("Files with parse_error_flag=1 : {parse_error_count}");
    println!();
    println!("Per language / tier:");
    for lang in ["C", "C++", "Java", "Python"] {
        for tier in ["Light", "Heavy"] {
            let count = per_lang_tier
                .get(&(lang.to_string(), tier.to_string()))
                .copied()
                .unwrap_or(0);
            println!("  {lang:<7} / {tier:<5} : {count}");
        }
    }
}
