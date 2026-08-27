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
