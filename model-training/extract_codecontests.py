"""
Extract and sample source files from DeepMind CodeContests dataset (Codeforces, CodeChef, HackerEarth).
Supports C++, Python, and Java across Light and Heavy resource tiers.
"""

import argparse
import csv
import os
import re
from datasets import load_dataset


LANG_MAP = {
    2: ("C++", "cpp"),
    3: ("Python", "py"),
    4: ("Java", "java"),
}


def sanitize_filename(name: str) -> str:
    return re.sub(r"[^a-zA-Z0-9_\-]", "_", name)[:80]


def main():
    parser = argparse.ArgumentParser(description="Extract balanced solutions from DeepMind CodeContests")
    parser.add_argument("--output-dir", default="codecontests_subset", help="Output directory for source files")
    parser.add_argument("--manifest", default="sample_manifest_codecontests.csv", help="Output manifest path")
    parser.add_argument("--per-stratum", type=int, default=5000, help="Target samples per stratum (default: 5000 - empirical sweet spot)")
    args = parser.parse_args()

    # Clean existing output
    import shutil
    if os.path.exists(args.output_dir):
        shutil.rmtree(args.output_dir, ignore_errors=True)
    if os.path.exists(args.manifest):
        try:
            os.remove(args.manifest)
        except OSError:
            pass

    os.makedirs(args.output_dir, exist_ok=True)
    for lang in ["C++", "Python", "Java"]:
        for tier in ["Light", "Heavy"]:
            os.makedirs(os.path.join(args.output_dir, lang, tier), exist_ok=True)

    counts = {
        ("C++", "Light"): 0,
        ("C++", "Heavy"): 0,
        ("Python", "Light"): 0,
        ("Python", "Heavy"): 0,
        ("Java", "Light"): 0,
        ("Java", "Heavy"): 0,
    }

    target = args.per_stratum
    total_target = target * 6
    manifest_rows = []

    print(f"Streaming DeepMind CodeContests (Target: {target} per stratum, Total: {total_target})...")

    # Load splits: train, valid, test
    for split_name in ["train", "valid", "test"]:
        print(f"\n--- Loading split: {split_name} ---")
        ds = load_dataset("deepmind/code_contests", split=split_name, streaming=True)

        for prob_idx, problem in enumerate(ds):
            prob_name = problem.get("name", f"prob_{split_name}_{prob_idx}")
            difficulty = problem.get("difficulty")
            source_platform = problem.get("source", "unknown")

            sols = problem.get("solutions", {})
            languages = sols.get("language", [])
            solutions = sols.get("solution", [])

            for sol_idx, (lang_id, code) in enumerate(zip(languages, solutions)):
                if lang_id not in LANG_MAP:
                    continue

                if len(code.strip()) < 10:
                    continue

                lang_name, ext = LANG_MAP[lang_id]

                # Determine tier based on problem difficulty & structural complexity
                if (difficulty is not None and difficulty <= 3) or len(code) < 650:
                    tier = "Light"
                elif (difficulty is not None and difficulty >= 5) or len(code) >= 1200:
                    tier = "Heavy"
                else:
                    tier = "Light" if counts[(lang_name, "Light")] < counts[(lang_name, "Heavy")] else "Heavy"

                key = (lang_name, tier)

                if counts[key] >= target:
                    alt_tier = "Heavy" if tier == "Light" else "Light"
                    alt_key = (lang_name, alt_tier)
                    if counts[alt_key] < target and 500 <= len(code) <= 1500:
                        key = alt_key
                        tier = alt_tier
                    else:
                        continue

                sub_id = f"cc_{split_name}_{sanitize_filename(prob_name)}_{sol_idx}"
                file_name = f"{sub_id}.{ext}"
                file_path = os.path.join(args.output_dir, lang_name, tier, file_name)

                try:
                    with open(file_path, "w", encoding="utf-8", errors="ignore") as f:
                        f.write(code)
                except Exception:
                    continue

                counts[key] += 1
                manifest_rows.append({
                    "submission_id": sub_id,
                    "language": lang_name,
                    "tier": tier,
                    "problem_name": prob_name,
                    "difficulty": difficulty if difficulty is not None else -1,
                    "source_platform": source_platform,
                    "file_path": file_path,
                })

                if len(manifest_rows) % 2000 == 0:
                    print(f"Progress: {len(manifest_rows)} / {total_target} files extracted...")

            if all(c >= target for c in counts.values()):
                print("All strata reached target counts!")
                break

        if all(c >= target for c in counts.values()):
            break

    # Write Manifest
    with open(args.manifest, "w", newline="", encoding="utf-8") as f:
        writer = csv.DictWriter(
            f,
            fieldnames=["submission_id", "language", "tier", "problem_name", "difficulty", "source_platform", "file_path"],
        )
        writer.writeheader()
        writer.writerows(manifest_rows)

    print(f"\nExtraction complete! Total extracted: {len(manifest_rows)} files")
    print("Strata Breakdown:")
    for (l, t), count in sorted(counts.items()):
        print(f"  {l:8s} / {t:5s} : {count}")
    print(f"Manifest written to: {args.manifest}")


if __name__ == "__main__":
    main()
