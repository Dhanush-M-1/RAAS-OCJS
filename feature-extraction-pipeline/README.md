# OJ Feature-Extraction Pipeline

A Rust tool that walks a pre-organized code-judge dataset, parses every source
file with [tree-sitter](https://tree-sitter.github.io/), computes four source
features per file, and writes a single labeled CSV suitable for training an
XGBoost classifier.

## Prerequisites

- **Rust toolchain ≥ 1.85** — the crate uses `edition = "2024"`
  ([`Cargo.toml`](Cargo.toml)). Check with `rustc --version`; update with
  `rustup update stable` if needed.
- A dataset directory laid out as described under
  [Dataset layout](#dataset-layout).

## Building

```bash
cd feature-extraction-pipeline
cargo build --release
```

The first build compiles the pinned dependencies from
[`Cargo.lock`](Cargo.lock) (tree-sitter plus the C, C++, Java, and Python
grammars), which takes a little while.

## Running the pipeline

> **Note on the two binaries.** This crate ships two binaries, so a bare
> `cargo run` cannot guess which one you mean:
>
> - `OJ-feature-extraction-spike` — the pipeline itself (from
>   [`src/main.rs`](src/main.rs))
> - `probe` — a dev/debug tool (from [`src/bin/probe.rs`](src/bin/probe.rs))
>
> Always select the binary explicitly with `--bin`.

### Main pipeline

```bash
cargo run --bin OJ-feature-extraction-spike -- <dataset_root> [output.csv]
```

- `<dataset_root>` — **required**. Root directory containing the `C/`, `C++/`,
  `Java/`, and `Python/` subfolders.
- `output.csv` — **optional**. Output path; defaults to `features.csv` in the
  current directory.

Example:

```bash
cargo run --bin OJ-feature-extraction-spike -- "/path/to/dataset"
cargo run --bin OJ-feature-extraction-spike -- "/path/to/dataset" my_features.csv
```

The pipeline reports progress to stderr and prints a summary at the end (total
files, per-language/tier counts, parse-error count, duplicate rows skipped).
See [`main()`](src/main.rs).

### Probe (dev tool, not part of the pipeline)

Dumps real tree-sitter parse trees for hand-written snippets per language. It
exists purely to verify node type names and chain structure, and is not needed
to run the pipeline:

```bash
cargo run --bin probe
```

## Dataset layout

The walker expects this exact structure (see
[`walker.rs`](src/walker.rs)):

```text
<dataset_root>/
├── C/       ├── Light/*.c       └── Heavy/*.c
├── C++/     ├── Light/*.cpp     └── Heavy/*.cpp
├── Java/    ├── Light/*.java    └── Heavy/*.java
└── Python/  ├── Light/*.py      └── Heavy/*.py
```

Rules:

- **Language is taken from the folder name**, not the file extension. The
  extension is only sanity-checked; a mismatch logs a warning but does not
  change the parser (see [`language.rs`](src/language.rs)).
- **Label (`Light` / `Heavy`) comes from the tier folder name.** There is no
  metadata CSV and no cpu_time/memory data in this dataset, so none is
  computed or referenced.
- **`submission_id`** = the filename without its extension (e.g.
  `s00000001.c` → `s00000001`). IDs repeat across languages, so the unique row
  key is the `(submission_id, language)` pair; duplicates of that pair are
  skipped with a warning.

## Output

A UTF-8 CSV with a header row and one row per file:

```csv
submission_id,language,nesting_depth,cyclomatic_complexity,is_recursive,large_alloc_flag,parse_error_flag,label
s00000001,C,3,4,0,1,0,Light
...
```

| Column                   | Type | Meaning                                                                                                            |
| ------------------------ | ---- | ------------------------------------------------------------------------------------------------------------------ |
| `submission_id`          | text | File stem (filename without extension).                                                                             |
| `language`               | text | `C`, `C++`, `Java`, or `Python`.                                                                                   |
| `nesting_depth`          | uint | Deepest nesting of `for`/`while`/`if` constructs. `else if` / `elif` chains do **not** add extra depth.            |
| `cyclomatic_complexity`  | uint | McCabe complexity = `1 +` decision points (`if`, `for`, `while`, `case`, `&&`, `||`, ternary, `elif`).              |
| `is_recursive`           | 0/1   | `1` if any function directly calls itself by name inside its own body.                                              |
| `large_alloc_flag`       | 0/1   | `1` if a static allocation has a literal size above the threshold (see below).                                      |
| `parse_error_flag`       | 0/1   | `1` if the parse tree contains any ERROR node; such rows should be inspected/filtered rather than silently trusted.  |
| `label`                  | text  | `Light` or `Heavy`, from the tier folder.                                                                           |

### Large-allocation threshold

The threshold is a single named constant in
[`features.rs`](src/features.rs), `LARGE_ALLOC_THRESHOLD` (default `1_000_000`).
It applies to statically-known sizes only — allocations sized by a variable
are undetectable and never flagged. What is detected per language:

| Language | Detected patterns                                                                                                   |
| -------- | ------------------------------------------------------------------------------------------------------------------ |
| C        | `malloc`, `realloc` (bytes), `calloc` (count × size), `aligned_alloc` (bytes).                                     |
| C++      | `v.reserve(n)` / `v.resize(n)`, `new T[n]`.                                                                        |
| Java     | `new int[n]` arrays, `new ArrayList<>(n)` / `new HashMap<>(n)` etc. on a known list of capacity-taking collections. |
| Python   | Container repetition `[x] * n` (list/tuple/set/dict/str), `bytearray(n)`.                                          |

Literal arithmetic is evaluated statically (`5 * 1024 * 1024` works), including
hex and underscore-separated literals.

## Known limitations

- **Recursion** detects direct self-calls only; mutual recursion (A calls B,
  B calls A) is out of scope.
- **Large allocations** must be fully static (literal sizes). Variable-sized
  allocations are never flagged.
- `parse_error_flag` is set best-effort; when a file fails to parse, the other
  four features are still computed but the row may be unreliable.

## Running the tests

```bash
cargo test
```

Two layers of tests run against mock source code:

- **Unit tests** (inline `#[cfg(test)]` modules):
  - [`features.rs`](src/features.rs) — per-language feature logic (nesting
    depth, complexity, recursion, large allocations) against hand-written
    snippets, including documented edge cases (`do-while`, range-`for`,
    `try/except`, variable-sized allocs).
  - [`walker.rs`](src/walker.rs) — dataset walking against a mock directory
    tree created in a temp dir (order determinism, skipping non-language /
    non-tier dirs, extension-mismatch tolerance).
  - [`language.rs`](src/language.rs) — folder-name mapping, extensions,
    grammar loading.
  - [`output.rs`](src/output.rs) — CSV escaping, header/row serialization,
    row assembly + dedup.

- **Integration tests** ([`tests/`](tests)):
  - [`tests/pipeline.rs`](tests/pipeline.rs) — end-to-end: writes a mock
    CodeNet-style dataset to a temp dir, runs walker → feature extraction →
    row assembly → CSV, and asserts hand-computed values per row, dedup, and
    parse-error handling.
  - [`tests/cli.rs`](tests/cli.rs) — black-box: runs the compiled CLI binary
    against a mock dataset and checks the CSV it writes plus its summary.
  - [`tests/common/mod.rs`](tests/common/mod.rs) — shared temp-dir / file
    writer helpers (no external dev-dependencies).

## Project layout

```text
feature-extraction-pipeline/
├── Cargo.toml
├── Cargo.lock
├── src/
│   ├── lib.rs       # library crate: re-exports the pipeline modules
│   ├── main.rs      # CLI entry point (thin wrapper over the library)
│   ├── output.rs    # row assembly (dedup + features) and CSV writing (+ tests)
│   ├── walker.rs    # dataset directory walking (+ tests)
│   ├── language.rs  # language abstraction + parser selection (+ tests)
│   ├── features.rs  # pure feature-extraction logic (+ tests)
│   └── bin/
│       └── probe.rs # dev tool: dump tree-sitter parse trees
└── tests/
    ├── common/mod.rs # shared mock-dataset helpers
    ├── pipeline.rs   # end-to-end integration tests (mock dataset)
    └── cli.rs        # black-box CLI integration tests
```
