//! Library crate for the OJ feature-extraction pipeline.
//!
//! Exposes the pipeline modules so that both the CLI binary
//! ([`main.rs`](main.rs)) and the integration tests in [`tests/`](tests)
//! reuse exactly the same code paths:
//!
//! - [`features`] — pure source-string → feature-value computation.
//! - [`language`] — language abstraction and tree-sitter parser selection.
//! - [`walker`] — dataset directory walking.
//! - [`output`] — row assembly (dedup + feature application) and CSV writing.
//!
//! Keeping the pipeline logic in a library (rather than inside the binary's
//! `main`) is what makes end-to-end integration testing with mock source files
//! possible without spawning a subprocess.

pub mod features;
pub mod language;
pub mod output;
pub mod walker;
