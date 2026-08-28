//! Row assembly and CSV output for the feature-extraction pipeline.
//!
//! This module turns walked [`Sample`]s into labeled [`Row`]s (applying the
//! feature extraction) and serializes them to CSV. It lives in the library so
//! the end-to-end pipeline can be exercised by integration tests without
//! spawning the CLI binary.

use std::collections::{HashMap, HashSet};
use std::fs::File;
use std::io::{BufWriter, Write};
use std::path::Path;

use crate::features;
use crate::walker::Sample;

/// One output CSV row.
#[derive(Debug, Clone, PartialEq, Eq)]
pub struct Row {
    pub submission_id: String,
    pub language: String,
    pub nesting_depth: u32,
    pub cyclomatic_complexity: u32,
    pub is_recursive: u32,
    pub large_alloc_flag: u32,
    pub parse_error_flag: u32,
    pub label: String,
}

/// Diagnostics accumulated while assembling rows.
#[derive(Debug, Clone, Default)]
pub struct Summary {
    pub parse_error_count: usize,
    pub dup_skipped: usize,
    pub per_lang_tier: HashMap<(String, String), usize>,
}

/// Build one [`Row`] per sample, de-duplicating on `(submission_id, language)`.
///
/// `submission_id`s repeat across languages in this dataset layout (e.g.
/// `C/Light/s00000001.c` and `C++/Light/s00000001.cpp` both yield id
/// `s00000001`), so the pair `(submission_id, language)` is the unique file
/// key. A repeated pair is skipped and counted in [`Summary::dup_skipped`].
pub fn build_rows(samples: &[Sample]) -> (Vec<Row>, Summary) {
    let mut rows = Vec::with_capacity(samples.len());
    let mut seen: HashSet<(String, String)> = HashSet::with_capacity(samples.len());
    let mut summary = Summary::default();

    for sample in samples {
        let key = (
            sample.submission_id.clone(),
            sample.language.as_str().to_string(),
        );
        if !seen.insert(key) {
            summary.dup_skipped += 1;
            continue;
        }

        // Pure, reusable logic: source + language in, features out.
        let feats = features::compute_features(&sample.source, sample.language);

        if feats.parse_error_flag {
            summary.parse_error_count += 1;
        }
        *summary
            .per_lang_tier
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

    (rows, summary)
}

/// Write the CSV, UTF-8, header included, one row per entry.
pub fn write_csv(path: &Path, rows: &[Row]) -> std::io::Result<()> {
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

/// Minimal CSV field escaping: quote any field containing a comma, quote, or
/// newline, doubling embedded quotes.
pub fn csv_escape(field: &str) -> String {
    if field.contains(',') || field.contains('"') || field.contains('\n') {
        format!("\"{}\"", field.replace('"', "\"\""))
    } else {
        field.to_string()
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use crate::language::Language;

    fn sample(id: &str, lang: Language, label: &str, src: &str) -> Sample {
        Sample {
            submission_id: id.to_string(),
            language: lang,
            label: label.to_string(),
            source: src.to_string(),
        }
    }

    #[test]
    fn csv_escape_plain_field_unchanged() {
        assert_eq!(csv_escape("s00000001"), "s00000001");
        assert_eq!(csv_escape("C++"), "C++");
        assert_eq!(csv_escape("Heavy"), "Heavy");
    }

    #[test]
    fn csv_escape_quotes_comma_and_newline() {
        assert_eq!(csv_escape("a,b"), "\"a,b\"");
        assert_eq!(csv_escape("say \"hi\""), "\"say \"\"hi\"\"\"");
        assert_eq!(csv_escape("line1\nline2"), "\"line1\nline2\"");
    }

    #[test]
    fn build_rows_computes_features_and_dedups() {
        let samples = vec![
            sample("a", Language::C, "Light", "int main(void){return 0;}"),
            // Same (submission_id, language) in a second tier -> duplicate.
            sample("a", Language::C, "Heavy", "int main(void){return 0;}"),
            sample(
                "b",
                Language::Python,
                "Heavy",
                "def f(n):\n    if n <= 1:\n        return 1\n    return n * f(n - 1)\n",
            ),
            sample(
                "b",
                Language::Cpp,
                "Heavy",
                "int main(){int *p = new int[3000000];}",
            ),
        ];
        let (rows, summary) = build_rows(&samples);

        assert_eq!(rows.len(), 3, "one of the two 'a'/C samples must be deduped");
        assert_eq!(summary.dup_skipped, 1);

        // The surviving 'a'/C row is the first one seen (order preserved).
        let a_row = rows.iter().find(|r| r.submission_id == "a").unwrap();
        assert_eq!(a_row.language, "C");
        assert_eq!(a_row.label, "Light");
        assert_eq!(a_row.nesting_depth, 0);
        assert_eq!(a_row.cyclomatic_complexity, 1);

        let py_row = rows
            .iter()
            .find(|r| r.submission_id == "b" && r.language == "Python")
            .unwrap();
        assert_eq!(py_row.nesting_depth, 1);
        assert_eq!(py_row.cyclomatic_complexity, 2);
        assert_eq!(py_row.is_recursive, 1);

        let cpp_row = rows.iter().find(|r| r.language == "C++").unwrap();
        assert_eq!(cpp_row.large_alloc_flag, 1);

        assert_eq!(
            summary.per_lang_tier.get(&("C".to_string(), "Light".to_string())),
            Some(&1)
        );
        assert_eq!(
            summary
                .per_lang_tier
                .get(&("Python".to_string(), "Heavy".to_string())),
            Some(&1)
        );
    }

    #[test]
    fn build_rows_flags_parse_errors() {
        let samples = vec![sample(
            "broken",
            Language::Python,
            "Light",
            "def f(:\n    x = (\n    return x",
        )];
        let (rows, summary) = build_rows(&samples);
        assert_eq!(summary.parse_error_count, 1);
        assert_eq!(rows[0].parse_error_flag, 1);
    }

    #[test]
    fn write_csv_produces_header_and_rows() {
        let tmp = std::env::temp_dir().join(format!(
            "output_test_{}_{}",
            std::process::id(),
            std::time::SystemTime::now()
                .duration_since(std::time::UNIX_EPOCH)
                .unwrap()
                .as_nanos()
        ));
        let rows = vec![Row {
            submission_id: "s001".into(),
            language: "C".into(),
            nesting_depth: 2,
            cyclomatic_complexity: 4,
            is_recursive: 1,
            large_alloc_flag: 0,
            parse_error_flag: 0,
            label: "Light".into(),
        }];
        write_csv(&tmp, &rows).unwrap();
        let text = std::fs::read_to_string(&tmp).unwrap();
        let _ = std::fs::remove_file(&tmp);
        let mut lines = text.lines();
        assert_eq!(
            lines.next().unwrap(),
            "submission_id,language,nesting_depth,cyclomatic_complexity,is_recursive,large_alloc_flag,parse_error_flag,label"
        );
        assert_eq!(lines.next().unwrap(), "s001,C,2,4,1,0,0,Light");
        assert_eq!(lines.next(), None);
    }
}
