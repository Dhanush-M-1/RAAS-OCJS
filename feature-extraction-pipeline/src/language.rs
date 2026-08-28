//! Language abstraction for the feature-extraction pipeline.
//!
//! Parser selection is driven by the language **folder** name (authoritative for
//! this dataset), never by file extension. The extension is only used as a
//! sanity check downstream.

use std::fmt;

/// The four programming languages present in the dataset.
#[derive(Debug, Clone, Copy, PartialEq, Eq, Hash)]
pub enum Language {
    C,
    Cpp,
    Java,
    Python,
}

impl Language {
    /// Map a language folder name ("C", "C++", "Java", "Python") to a [`Language`].
    pub fn from_folder_name(name: &str) -> Option<Language> {
        match name {
            "C" => Some(Language::C),
            "C++" => Some(Language::Cpp),
            "Java" => Some(Language::Java),
            "Python" => Some(Language::Python),
            _ => None,
        }
    }

    /// Canonical name as used in the CSV `language` column.
    pub fn as_str(&self) -> &'static str {
        match self {
            Language::C => "C",
            Language::Cpp => "C++",
            Language::Java => "Java",
            Language::Python => "Python",
        }
    }

    /// Expected file extension for this language. Used only for a sanity check;
    /// the parser is always selected from the folder name.
    pub fn expected_extension(&self) -> &'static str {
        match self {
            Language::C => "c",
            Language::Cpp => "cpp",
            Language::Java => "java",
            Language::Python => "py",
        }
    }

    /// The tree-sitter grammar used to parse source in this language.
    pub fn tree_sitter_language(&self) -> tree_sitter::Language {
        match self {
            Language::C => tree_sitter_c::language(),
            Language::Cpp => tree_sitter_cpp::language(),
            Language::Java => tree_sitter_java::language(),
            Language::Python => tree_sitter_python::language(),
        }
    }
}

impl fmt::Display for Language {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        f.write_str(self.as_str())
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    const ALL: [Language; 4] = [Language::C, Language::Cpp, Language::Java, Language::Python];

    #[test]
    fn folder_names_map_to_languages() {
        assert_eq!(Language::from_folder_name("C"), Some(Language::C));
        assert_eq!(Language::from_folder_name("C++"), Some(Language::Cpp));
        assert_eq!(Language::from_folder_name("Java"), Some(Language::Java));
        assert_eq!(Language::from_folder_name("Python"), Some(Language::Python));
        assert_eq!(Language::from_folder_name("Rust"), None);
        assert_eq!(Language::from_folder_name("c"), None, "matching is case-sensitive");
        assert_eq!(Language::from_folder_name(""), None);
    }

    #[test]
    fn as_str_round_trips_through_folder_name() {
        for lang in ALL {
            assert_eq!(Language::from_folder_name(lang.as_str()), Some(lang));
        }
    }

    #[test]
    fn expected_extensions() {
        assert_eq!(Language::C.expected_extension(), "c");
        assert_eq!(Language::Cpp.expected_extension(), "cpp");
        assert_eq!(Language::Java.expected_extension(), "java");
        assert_eq!(Language::Python.expected_extension(), "py");
    }

    #[test]
    fn display_matches_as_str() {
        for lang in ALL {
            assert_eq!(lang.to_string(), lang.as_str());
        }
    }

    #[test]
    fn tree_sitter_grammars_load_without_panicking() {
        // Every grammar must be a compile-time constant that loads cleanly.
        for lang in ALL {
            let _ = lang.tree_sitter_language();
        }
    }
}
