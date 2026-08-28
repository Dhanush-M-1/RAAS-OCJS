//! Shared helpers for integration tests.
//!
//! A tiny self-contained temp-directory helper (no external dev-dependencies)
//! plus a convenience writer for mock source files.

use std::fs;
use std::path::{Path, PathBuf};
use std::sync::atomic::{AtomicU64, Ordering};

static COUNTER: AtomicU64 = AtomicU64::new(0);

/// A unique temporary directory that deletes itself on drop.
pub struct TempDir(PathBuf);

impl TempDir {
    /// Create a fresh, uniquely-named temp directory under the OS temp dir.
    pub fn new(label: &str) -> Self {
        let n = COUNTER.fetch_add(1, Ordering::SeqCst);
        let dir = std::env::temp_dir().join(format!(
            "featpipe_{}_{}_{}_{}",
            label,
            std::process::id(),
            n,
            std::time::SystemTime::now()
                .duration_since(std::time::UNIX_EPOCH)
                .unwrap()
                .as_nanos()
        ));
        fs::create_dir_all(&dir).expect("create temp dir");
        TempDir(dir)
    }

    /// The root path of the temp directory.
    pub fn path(&self) -> &Path {
        &self.0
    }
}

impl Drop for TempDir {
    fn drop(&mut self) {
        let _ = fs::remove_dir_all(&self.0);
    }
}

/// Write `contents` to `root/rel`, creating parent directories as needed.
pub fn write(root: &Path, rel: &str, contents: &str) {
    let p = root.join(rel);
    fs::create_dir_all(p.parent().expect("path has a parent")).expect("create parent dirs");
    fs::write(&p, contents).expect("write mock source file");
}
