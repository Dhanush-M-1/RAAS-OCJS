"""
CodeNet Stratified Dataset Extractor for RAAS-OJS (High Performance Multi-Threaded)

Extracts a balanced, high-quality subset from IBM Project CodeNet
without loading the full 13.9M metadata or copying the entire 75GB archive.

Features:
- Streaming metadata scan across all problem CSVs (p00000.csv - p04052.csv).
- Stratified Reservoir Sampling across 8 strata (4 languages x 2 tiers).
- Filters for Accepted submissions with valid non-negative CPU & memory metrics.
- High-concurrency multi-threaded file copying (ThreadPoolExecutor) with pre-created directories.
- Emits a comprehensive manifest.csv with ground truth metrics and problem groupings.
"""

import argparse
import concurrent.futures
import csv
import glob
import os
import random
import shutil
import sys
import time

TARGET_LANGUAGES = ["C++", "Python", "Java", "C"]
TIERS = ["Light", "Heavy"]

MEMORY_THRESHOLD_KB = 65536  # 64 MB (65,536 KB)
CPU_THRESHOLD_MS = 2000      # 2000 ms (2.0 s)


def classify_tier(cpu_time: int, memory: int) -> str:
    """Classify a submission into Light vs Heavy tier based on thresholds."""
    if memory >= MEMORY_THRESHOLD_KB or cpu_time >= CPU_THRESHOLD_MS:
        return "Heavy"
    return "Light"


def reservoir_sample(
    meta_files: list[str],
    per_stratum: int,
    seed: int = 42,
) -> tuple[dict[tuple[str, str], list[dict]], dict[tuple[str, str], int]]:
    """Stream all problem metadata CSVs and perform stratified reservoir sampling."""
    random.seed(seed)
    reservoirs = {(lang, tier): [] for lang in TARGET_LANGUAGES for tier in TIERS}
    seen_counts = {k: 0 for k in reservoirs}

    start_time = time.time()
    total_files = len(meta_files)

    for i, meta_path in enumerate(meta_files):
        problem_id = os.path.basename(meta_path).replace(".csv", "")

        with open(meta_path, "r", newline="", encoding="utf-8", errors="ignore") as f:
            reader = csv.DictReader(f)
            for row in reader:
                lang = row.get("language")
                if lang not in TARGET_LANGUAGES:
                    continue
                if row.get("status") != "Accepted":
                    continue

                try:
                    cpu_time = int(row["cpu_time"])
                    memory = int(row["memory"])
                except (ValueError, TypeError, KeyError):
                    continue

                if cpu_time < 0 or memory < 0:
                    continue

                tier = classify_tier(cpu_time, memory)
                key = (lang, tier)
                seen_counts[key] += 1

                record = {
                    "problem_id": problem_id,
                    "submission_id": row["submission_id"],
                    "language": lang,
                    "filename_ext": row.get("filename_ext", ""),
                    "cpu_time": cpu_time,
                    "memory": memory,
                    "tier": tier,
                }

                bucket = reservoirs[key]
                if len(bucket) < per_stratum:
                    bucket.append(record)
                else:
                    j = random.randint(0, seen_counts[key] - 1)
                    if j < per_stratum:
                        bucket[j] = record

        if (i + 1) % 500 == 0 or (i + 1) == total_files:
            elapsed = time.time() - start_time
            print(f"  Processed {i + 1}/{total_files} metadata files ({elapsed:.1f}s)...")

    return reservoirs, seen_counts


def _copy_single_file(args: tuple[str, str, dict]) -> tuple[bool, dict]:
    """Worker function for concurrent file copy."""
    codenet_root, output_data_dir, rec = args
    ext = rec["filename_ext"]
    sub_id = rec["submission_id"]
    lang = rec["language"]
    tier = rec["tier"]
    prob = rec["problem_id"]

    src_path = os.path.join(codenet_root, "data", prob, lang, f"{sub_id}.{ext}")
    dest_path = os.path.join(output_data_dir, lang, tier, f"{sub_id}.{ext}")

    if not os.path.exists(src_path):
        rec["source_path"] = None
        return False, rec

    try:
        shutil.copyfile(src_path, dest_path)
        rec["source_path"] = dest_path
        return True, rec
    except Exception:
        rec["source_path"] = None
        return False, rec


def copy_samples_parallel(
    codenet_root: str,
    output_data_dir: str,
    all_records: list[dict],
    workers: int = 32,
) -> tuple[int, int]:
    """Copy the sampled source files concurrently in parallel."""
    # Pre-create all destination directories
    for lang in TARGET_LANGUAGES:
        for tier in TIERS:
            os.makedirs(os.path.join(output_data_dir, lang, tier), exist_ok=True)

    copied = 0
    missing = 0
    total = len(all_records)
    tasks = [(codenet_root, output_data_dir, rec) for rec in all_records]

    start_time = time.time()
    with concurrent.futures.ThreadPoolExecutor(max_workers=workers) as executor:
        for i, (success, _) in enumerate(executor.map(_copy_single_file, tasks)):
            if success:
                copied += 1
            else:
                missing += 1

            if (i + 1) % 2000 == 0 or (i + 1) == total:
                elapsed = time.time() - start_time
                rate = (i + 1) / max(elapsed, 0.001)
                print(f"  Copied {i + 1}/{total} files ({rate:.1f} files/sec, {elapsed:.1f}s)...")

    return copied, missing


def write_manifest(output_csv: str, records: list[dict]):
    """Write the manifest CSV with problem IDs, labels, and execution stats."""
    fieldnames = [
        "problem_id",
        "submission_id",
        "language",
        "filename_ext",
        "cpu_time",
        "memory",
        "tier",
        "source_path",
    ]
    with open(output_csv, "w", newline="", encoding="utf-8") as f:
        writer = csv.DictWriter(f, fieldnames=fieldnames)
        writer.writeheader()
        for r in records:
            if r.get("source_path"):
                writer.writerow(r)


def main():
    parser = argparse.ArgumentParser(description="Sample CodeNet dataset for RAAS-OJS")
    parser.add_argument(
        "--codenet-root",
        default="/media/cypher/Fedora-harddrive/Project_CodeNet",
        help="Path to Project_CodeNet root directory",
    )
    parser.add_argument(
        "--output-dir",
        default="codenet_subset",
        help="Directory to output the sampled source files",
    )
    parser.add_argument(
        "--manifest",
        default="sample_manifest.csv",
        help="Path to output manifest CSV",
    )
    parser.add_argument(
        "--per-stratum",
        type=int,
        default=2500,
        help="Number of samples per (Language, Tier) pair (default: 2500 -> 20,000 total)",
    )
    parser.add_argument("--workers", type=int, default=32, help="Parallel copy workers")
    parser.add_argument("--seed", type=int, default=42, help="Random seed")

    args = parser.parse_args()

    meta_pattern = os.path.join(args.codenet_root, "metadata", "p[0-9][0-9][0-9][0-9][0-9].csv")
    meta_files = sorted(glob.glob(meta_pattern))

    if not meta_files:
        print(f"Error: No metadata files matching {meta_pattern}", file=sys.stderr)
        sys.exit(1)

    print(f"Found {len(meta_files)} problem metadata files in {args.codenet_root}/metadata")
    print(f"Starting stratified reservoir sampling (per_stratum={args.per_stratum})...")

    reservoirs, seen_counts = reservoir_sample(meta_files, args.per_stratum, args.seed)

    all_records = [rec for bucket in reservoirs.values() for rec in bucket]
    print(f"\nSampling complete. Collected {len(all_records)} candidate submissions.")
    print("Strata Breakdown:")
    for (lang, tier), bucket in reservoirs.items():
        print(f"  {lang:<8} / {tier:<6}: {len(bucket):>5} sampled (from {seen_counts[(lang, tier)]:>7} eligible)")

    print(f"\nCopying source files to {args.output_dir} using {args.workers} workers...")
    copied, missing = copy_samples_parallel(args.codenet_root, args.output_dir, all_records, args.workers)
    print(f"Successfully copied: {copied} files (Missing: {missing})")

    print(f"Writing manifest to {args.manifest}...")
    write_manifest(args.manifest, all_records)
    print(f"Manifest created with {copied} rows.")
    print("\nDone!")


if __name__ == "__main__":
    main()
