//! Directory walking: `dataset_root / LANGUAGE / TIER / source files`.
//!
//! The language **folder** name is the authoritative source for parser choice;
//! the file extension is only sanity-checked (a mismatch logs a warning, it
//! does not crash or change the parser).

use std::fs;
use std::path::Path;

use crate::language::Language;

/// A single source file found on disk, with its derived metadata.
#[derive(Debug)]
pub struct Sample {
    /// Filename without extension (e.g. "s00000001").
    pub submission_id: String,
    /// Derived from the parent-parent folder name (e.g. "C++").
    pub language: Language,
    /// "Light" or "Heavy", derived from the parent folder name.
    pub label: String,
    /// The file's source code (UTF-8).
    pub source: String,
}

/// Walk the dataset root and load every source file.
///
/// Layout walked:
/// ```text
/// root/
/// ├── C/       ├── Light/*.c       └── Heavy/*.c
/// ├── C++/     ├── Light/*.cpp     └── Heavy/*.cpp
/// ├── Java/    ├── Light/*.java    └── Heavy/*.java
/// └── Python/  ├── Light/*.py      └── Heavy/*.py
/// ```
pub fn walk_dataset(root: &Path) -> Vec<Sample> {
    let mut samples = Vec::new();

    for lang_dir in sorted_entries(root) {
        let Some(lang) = Language::from_folder_name(&lang_dir) else {
            eprintln!("[walker] skipping non-language directory: {lang_dir}");
            continue;
        };
        let lang_path = root.join(&lang_dir);

        for tier_dir in sorted_entries(&lang_path) {
            if tier_dir != "Light" && tier_dir != "Heavy" {
                eprintln!("[walker] skipping non-tier directory: {tier_dir}");
                continue;
            }
            let tier_path = lang_path.join(&tier_dir);

            for file_name in sorted_entries(&tier_path) {
                let file_path = tier_path.join(&file_name);
                if !file_path.is_file() {
                    continue;
                }

                // submission_id = filename without extension
                let Some(stem) = file_path.file_stem().and_then(|s| s.to_str()) else {
                    eprintln!("[walker] skipping file with non-UTF8 name: {:?}", file_path);
                    continue;
                };

                // Extension is a sanity check ONLY; parser selection uses the
                // language folder name.
                match file_path.extension().and_then(|s| s.to_str()) {
                    Some(ext) if ext == lang.expected_extension() => {}
                    Some(ext) => eprintln!(
                        "[walker] WARNING: {} has extension '.{ext}' but folder expects '.{}'; parsing as {} anyway",
                        file_path.display(),
                        lang.expected_extension(),
                        lang
                    ),
                    None => {
                        eprintln!(
                            "[walker] WARNING: {} has no extension; parsing as {} anyway",
                            file_path.display(),
                            lang
                        );
                    }
                }

                let source = match fs::read_to_string(&file_path) {
                    Ok(s) => s,
                    Err(e) => {
                        eprintln!(
                            "[walker] skipping unreadable file {:?}: {}",
                            file_path, e
                        );
                        continue;
                    }
                };

                samples.push(Sample {
                    submission_id: stem.to_string(),
                    language: lang,
                    label: tier_dir.clone(),
                    source,
                });
            }
        }
    }

    samples
}

/// List directory entry names sorted lexicographically (deterministic order).
fn sorted_entries(dir: &Path) -> Vec<String> {
    let mut names: Vec<String> = Vec::new();
    if let Ok(entries) = fs::read_dir(dir) {
        for entry in entries.flatten() {
            if let Some(name) = entry.file_name().to_str() {
                names.push(name.to_string());
            }
        }
    }
    names.sort();
    names
}

#[cfg(test)]
mod tests {
    use super::*;
    use std::fs;
    use std::path::PathBuf;
    use std::sync::atomic::{AtomicU64, Ordering};

    static COUNTER: AtomicU64 = AtomicU64::new(0);

    /// Self-contained temp-directory helper (no external dev-dependencies).
    /// Removed from disk on drop.
    struct TempDir(PathBuf);

    impl TempDir {
        fn new() -> Self {
            let n = COUNTER.fetch_add(1, Ordering::SeqCst);
            let dir = std::env::temp_dir().join(format!(
                "walker_test_{}_{}_{}",
                std::process::id(),
                n,
                std::time::SystemTime::now()
                    .duration_since(std::time::UNIX_EPOCH)
                    .unwrap()
                    .as_nanos()
            ));
            fs::create_dir_all(&dir).unwrap();
            TempDir(dir)
        }

        fn path(&self) -> &Path {
            &self.0
        }
    }

    impl Drop for TempDir {
        fn drop(&mut self) {
            let _ = fs::remove_dir_all(&self.0);
        }
    }

    /// Write a mock source file at `root/rel`, creating parent directories.
    fn write(root: &Path, rel: &str, contents: &str) {
        let p = root.join(rel);
        fs::create_dir_all(p.parent().unwrap()).unwrap();
        fs::write(&p, contents).unwrap();
    }

    #[test]
    fn walks_all_language_tier_files_in_deterministic_order() {
        let tmp = TempDir::new();
        write(tmp.path(), "C/Light/a.c", "int main(void){return 0;}");
        write(tmp.path(), "C/Heavy/b.c", "int main(void){return 1;}");
        write(tmp.path(), "C++/Light/c.cpp", "int main(){return 0;}");
        write(tmp.path(), "Java/Heavy/d.java", "class D{}");
        write(tmp.path(), "Python/Light/e.py", "print(1)");

        let samples = walk_dataset(tmp.path());

        assert_eq!(samples.len(), 5);
        // Language dirs sort C < C++ < Java < Python; tiers sort Heavy < Light;
        // files within a tier sort a < b. The walker order is deterministic.
        let ids: Vec<(&str, &str, &str)> = samples
            .iter()
            .map(|s| (s.submission_id.as_str(), s.language.as_str(), s.label.as_str()))
            .collect();
        assert_eq!(
            ids,
            vec![
                ("b", "C", "Heavy"),
                ("a", "C", "Light"),
                ("c", "C++", "Light"),
                ("d", "Java", "Heavy"),
                ("e", "Python", "Light"),
            ]
        );

        // Source content is preserved verbatim.
        assert_eq!(samples[0].source, "int main(void){return 1;}");
    }

    #[test]
    fn skips_non_language_and_non_tier_directories() {
        let tmp = TempDir::new();
        write(tmp.path(), "C/Light/a.c", "int main(void){return 0;}");
        write(tmp.path(), "Rust/Heavy/r.rs", "fn main(){}"); // non-language dir
        write(tmp.path(), "C/Other/x.c", "int main(void){return 0;}"); // non-tier dir
        write(tmp.path(), "notes.txt", "not a folder"); // stray root file

        let samples = walk_dataset(tmp.path());
        assert_eq!(samples.len(), 1, "only C/Light/a.c is a valid sample");
        assert_eq!(samples[0].submission_id, "a");
    }

    #[test]
    fn extension_mismatch_is_tolerated() {
        // The language folder is authoritative; a .txt file in C/Light is
        // still parsed as C (a warning is logged but no crash/change).
        let tmp = TempDir::new();
        write(tmp.path(), "C/Light/a.txt", "int main(void){return 0;}");
        let samples = walk_dataset(tmp.path());
        assert_eq!(samples.len(), 1);
        assert_eq!(samples[0].language, Language::C);
        assert_eq!(samples[0].submission_id, "a");
    }

    #[test]
    fn empty_or_missing_directory_yields_no_samples() {
        let tmp = TempDir::new();
        write(tmp.path(), "C/Light/a.c", "int main(void){return 0;}");
        // A second, empty root directory must walk to zero samples.
        let empty = TempDir::new();
        let samples = walk_dataset(empty.path());
        assert!(samples.is_empty());
        assert_eq!(walk_dataset(tmp.path()).len(), 1);
    }
}
