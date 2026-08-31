# RAAS-OCJS — Judge Server

Resource-aware judge: takes a submission, decides an isolation tier (Light/Heavy),
runs it in a Docker container, grades it, and reports resource metrics.

Built with **axum** + **tokio**, feature extraction via tree-sitter, and a
compiled-into-Rust **XGBoost** model for the Predictive tier policy.

---

## Prerequisites

- Rust (edition 2024) — `rustc` / `cargo`
- **Docker Desktop** (or any Docker daemon)
  - The runtime images and the judge use `docker` from the CLI.

---

## 1. Build the Docker runtime images

The judge launches one container per submission from a per-language image.
These must exist before grading. Run from the **repo root** (`RAAS-OCJS/`):

```bash
docker build -t python-judge-runtime server/runtimes/python
docker build -t cpp-judge-runtime    server/runtimes/cpp
docker build -t java-judge-runtime   server/runtimes/java
```

> `c` / `c++` / `cpp` submissions all use `cpp-judge-runtime`.

---

## 2. Build the judge

Run from the **`server/`** directory:

```bash
cd server
cargo build
```

This compiles the XGBoost model (already generated in `src/generated/`) into the binary —
there is **no Python dependency at runtime**.

### Rebuild the model after retraining (optional)

Retraining happens entirely in `model-training/` (dataset extraction → Rust
feature extraction → XGBoost training → model artifacts). See
[`../model-training/README.md`](../model-training/README.md) for the full sequence.

To push a freshly trained model into the judge:

```bash
cd ../model-training
./regenerate_models.sh     # compiles artifacts/*.joblib -> src/generated/*.rs
cd ../server
cargo build                # bakes the new weights into the binary
```

> `regenerate_models.sh` needs `m2cgen` + `joblib` in a Python venv at
> `model-training/.venv`. If the venv doesn't exist (e.g. after a clean checkout),
> set it up first:
>
> ```bash
> cd model-training
> python3 -m venv .venv
> ./.venv/bin/python -m ensurepip
> ./.venv/bin/python -m pip install -r requirements.txt
> ```

---

## 3. Run the server

```bash
cd server
cargo run
# or run the built binary directly:
./target/debug/server
```

Expected output:

```
Judge is online and listening on :3000
```

---

## 4. Submit code

`POST /submit` with JSON. The `approach` field selects the scheduling strategy.

**Baseline** (always Heavy):

```bash
curl -X POST localhost:3000/submit -H 'content-type: application/json' -d '{
  "id": "s1",
  "language": "python",
  "approach": "baseline",
  "source": "print(1 + 1)",
  "test_cases": [{ "input": "", "expected": "2" }]
}'
```

**Predictive** (XGBoost picks Light/Heavy from AST features):

```bash
curl -X POST localhost:3000/submit -H 'content-type: application/json' -d '{
  "id": "s2",
  "language": "cpp",
  "approach": "predictive",
  "source": "#include <iostream>\nusing namespace std;\nint main(){long long n, s = 0; cin >> n; for (long long i = 1; i <= n; i++) s += i; cout << s << \"\\n\"; return 0;}",
  "test_cases": [{ "input": "10", "expected": "55" }]
}'
```

**Reactive** (starts Light, promotes mid-run on cgroup pressure):

```bash
curl -X POST localhost:3000/submit -H 'content-type: application/json' -d '{
  "id": "s3",
  "language": "python",
  "approach": "reactive",
  "source": "print(2 + 2)",
  "test_cases": [{ "input": "", "expected": "4" }]
}'
```

**Hybrid** (Predictive start, Reactive corrects):

```bash
curl -X POST localhost:3000/submit -H 'content-type: application/json' -d '{
  "id": "s4",
  "language": "java",
  "approach": "hybrid",
  "source": "public class Main{public static void main(String[]a){System.out.println(3);}}",
  "test_cases": [{ "input": "", "expected": "3" }]
}'
```

---

## 5. Response shape

```json
{
  "submission_id": "s1",
  "approach": "Predictive",
  "verdict": "AC",
  "cpu_time_ms": 92,
  "peak_memory_bytes": 0,
  "wall_time_ms": 2671,
  "tier_started": "high",
  "tier_promoted": false,
  "promotion_time_ms": 0,
  "cases": [{ "verdict": "AC", "cpu_time_ms": 92, "peak_memory_bytes": 0 }]
}
```

| Field | Meaning |
|---|---|
| `verdict` | `AC` (ok), `WA` (wrong answer), `TLE`, `MLE`, `RE`, `CE`, `SE` (server exec error) |
| `tier_started` | `low` / `high` — the tier the submission began in |
| `tier_promoted` | `true` if the reactive path migrated it mid-run |
| `peak_memory_bytes` | max memory read from cgroup (currently `0` until cgroup wiring lands) |
| `cpu_time_ms` | sum of per-case CPU time |

---

## Layout

```
server/
├── Cargo.toml
├── runtimes/            # Docker images (python / cpp / java judge runtime)
└── src/
    ├── main.rs          # axum router + judge fn
    ├── models.rs        # Submission / TestCase / CaseResult / JudgeResult
    ├── queue.rs         # mpsc queue + dispatcher (semaphore-capped tokio.spawn)
    ├── policy.rs        # TierPolicy trait + 4 strategies
    ├── predict.rs       # features -> XGBoost -> Tier (predictive policy)
    ├── docker.rs        # per-submission Docker container lifecycle
    └── generated/       # XGBoost compiled to Rust by m2cgen (do not edit)
```
