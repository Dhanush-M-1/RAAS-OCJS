//! Black-box integration test: run the compiled CLI binary against a mock
//! dataset and check its CSV output and printed summary.

mod common;

use common::{write, TempDir};
use std::process::Command;

/// Locate the compiled pipeline binary. Cargo sets `CARGO_BIN_EXE_<name>`
/// while building integration tests (dashes in the binary name are normalized
/// to underscores). If it is absent (e.g. a non-Cargo test runner), the test
/// is skipped rather than failing.
fn pipeline_binary() -> Option<std::ffi::OsString> {
    std::env::var_os("CARGO_BIN_EXE_OJ_feature_extraction_spike")
        .or_else(|| std::env::var_os("CARGO_BIN_EXE_OJ-feature-extraction-spike"))
}

#[test]
fn cli_binary_produces_csv_for_mock_dataset() {
    let Some(bin) = pipeline_binary() else {
        eprintln!("CARGO_BIN_EXE for the pipeline binary is not set; skipping CLI test");
        return;
    };

    let tmp = TempDir::new("cli");
    let root = tmp.path();

    // C / Light: nested for > while > if -> depth 3, complexity 4.
    write(
        root,
        "C/Light/s001.c",
        "int f(int a,int b){ for(int i=0;i<a;i++){ while(b>0){ if(i%2==0){ b--; } } } return b; }",
    );
    // C / Heavy: recursion + large malloc.
    write(
        root,
        "C/Heavy/s002.c",
        "#include <stdlib.h>\nlong fact(long n){ if(n<=1) return 1; char*p=malloc(5*1024*1024); return n*fact(n-1); }",
    );
    // Python / Heavy: recursion + large list repetition.
    write(
        root,
        "Python/Heavy/s003.py",
        "def fact(n):\n    if n <= 1:\n        return 1\n    a = [0] * 5000000\n    return n * fact(n - 1)\n",
    );

    let out_csv = tmp.path().join("out.csv");
    let output = Command::new(&bin)
        .arg(root.as_os_str())
        .arg(&out_csv)
        .output()
        .expect("failed to run the pipeline binary");
    assert!(
        output.status.success(),
        "binary exited non-zero:\n{}",
        String::from_utf8_lossy(&output.stderr)
    );

    // The printed summary reflects the 3 files.
    let stdout = String::from_utf8_lossy(&output.stdout);
    assert!(
        stdout.contains("Total files processed         : 3"),
        "unexpected summary:\n{stdout}"
    );

    // The CSV contains the header plus exactly one row per file.
    let csv_text = std::fs::read_to_string(&out_csv).unwrap();
    let lines: Vec<&str> = csv_text.lines().collect();
    assert_eq!(lines.len(), 4, "header + 3 rows");
    assert_eq!(
        lines[0],
        "submission_id,language,nesting_depth,cyclomatic_complexity,is_recursive,large_alloc_flag,parse_error_flag,label"
    );
    assert!(csv_text.contains("s001,C,3,4,0,0,0,Light"));
    assert!(csv_text.contains("s002,C,1,2,1,1,0,Heavy"));
    assert!(csv_text.contains("s003,Python,1,2,1,1,0,Heavy"));
}

#[test]
fn cli_usage_error_exits_nonzero_without_dataset() {
    let Some(bin) = pipeline_binary() else {
        eprintln!("CARGO_BIN_EXE for the pipeline binary is not set; skipping CLI test");
        return;
    };
    let output = Command::new(&bin).output().expect("failed to run binary");
    assert!(!output.status.success(), "missing args must exit non-zero");
    let stderr = String::from_utf8_lossy(&output.stderr);
    assert!(stderr.contains("usage:"), "expected usage text, got: {stderr}");
}
