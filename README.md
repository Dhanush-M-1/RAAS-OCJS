# RAAS-OJS

**Resource-Aware Adaptive Scheduling for Online Judge Systems**

A minimal online code judge with a resource-aware scheduling layer at its core, combining predictive AST-based classification with reactive, event-driven cgroup monitoring to enable true mid-execution isolation-tier migration on fixed, non-elastic hardware.

Final-year project, Department of Computer Science and Engineering, Easwari Engineering College. Guided by Mrs. Indumathy P, Assistant Professor / CSE.

---

## 01. Problem

Online judges apply identical sandbox isolation and resource limits to every submission regardless of its actual computational profile. A trivial submission and a resource-heavy one cost the platform the same to evaluate. This is absorbable on elastic cloud infrastructure, but not on fixed, self-hosted hardware, where a single heavy submission can degrade response time for every other user in the queue.

RAAS-OJS optimizes the infrastructure layer beneath judging — how a submission is isolated and scheduled while it runs — without touching the problem-specific correctness criteria (time/memory limits set by the problem author) that determine a verdict.

## 02. What This Is

A judge built from scratch, evaluated under four scheduling strategies against a common execution substrate:

| Strategy | Timing | Mechanism |
|---|---|---|
| Baseline | — | Every submission gets one fixed isolation tier (current standard practice) |
| Predictive | Before execution | tree-sitter → Rust feature extraction → XGBoost sets the initial tier |
| Reactive | During execution | Event-driven cgroup monitoring detects real usage → migrates the running process mid-run |
| Hybrid | Both | Predictive sets the starting tier, Reactive corrects it live |

## 03. Architecture

```
Submission → tree-sitter parse → Rust feature extraction → XGBoost →
Initial Tier (Light/Heavy) → cgroup assignment → Execution begins →
Event-driven monitor (memory.events) watches live →
  [if threshold breached] → PID migrated to new cgroup (cgroup.procs write) →
Execution completes → Result + Metrics logged
```

**Hot path (Rust, runs once per submission, no Python dependency):**
tree-sitter parsing, feature extraction, XGBoost inference (compiled to Rust via m2cgen — no model file loaded at runtime), isolation manager (cgroups v2), reactive monitor, judge core (intake, compile, execute, compare).

**Offline (Python, batch/one-time only):**
CodeNet/CodeContests loading → sampling → **Rust feature extraction** → XGBoost training → model artifacts (`.joblib`/`.json`/`.checkpoint`) → **`regenerate_models.sh` compiles the model into Rust (`server/src/generated/*.rs`) for the judge**.

Full sequence with copy-paste commands: see [`model-training/README.md`](model-training/README.md) (training) and [`server/README.md`](server/README.md) (run/judge).

The Baseline strategy skips the classifier and monitor entirely; Predictive skips the monitor; Reactive skips the classifier and assigns a default tier.

## 04. Tech Stack

| Component | Choice | Why |
|---|---|---|
| Parsing | tree-sitter (Rust bindings) | Multi-language AST parsing, no hand-rolled parser per language |
| Feature extraction | Custom Rust logic on tree-sitter's tree | 21 AST & structural features: nesting depth, loop topology (depth & count), cyclomatic complexity, recursion branching count, static BSS/global array allocations, fast I/O detection, heavy STL/collection structures, 2D matrix indexing, code volume, and interaction ratios |
| Predictive model | XGBoost → compiled to Rust (`m2cgen`) | Specialized per-language + unified multi-language XGBoost models trained on CodeNet (83–89% accuracy on unseen problems); compiled to Rust via `m2cgen` so the judge runs microsecond, Python-free inference with no model file loaded at runtime |
| Isolation | Raw Linux namespaces + cgroups v2 (no Docker) | Lower overhead; supports true mid-run migration, which container abstractions don't |
| Monitoring | Direct reads of `memory.events`/`memory.pressure`, event-driven (`poll`/`inotify`) | Near-instant detection, no missed spikes between polls |
| Dataset | IBM Project CodeNet | 13.9M real submissions, 55 languages, labeled with actual CPU time + memory |

Languages initially scoped: **C++, Python, Java, C** — ~95% of CodeNet's submission distribution.

## 05. Isolation Design Notes

Two separate limits are kept within each tier's cgroup:
- **`memory.max`** — hard kill boundary, always fixed at or above the problem's own judging limit. Never a source of false Memory-Limit-Exceeded verdicts caused by the scheduling infrastructure itself.
- **`memory.high`** — soft monitoring boundary, differs per tier, used purely for tier-adaptation signaling without terminating the process.

This separation exists to prevent the kernel OOM-killer from firing before the reactive monitor gets a chance to detect and migrate a submission (see competitive-programmer pre-allocation edge case below).

**Known edge case:** a submission may allocate far more memory upfront than its tier's limit (e.g., heap pre-allocation for speed). Mitigated by: the hard/soft boundary split above, event-driven (not polling) monitoring, and a predictive static check that routes large literal/constant allocations (`malloc(N)`, `new T[N]`, `reserve(N)`) straight to the Heavy tier before execution starts.

## 06. Evaluation Plan

Metrics: throughput at varying concurrency, p50/p95/p99 latency, maximum sustainable concurrency, predictive misclassification rate, reactive reclassification overhead, and fairness via Jain's fairness index.

Workloads replayed from IBM Project CodeNet. Two acknowledged threats to validity: CodeNet's labels were recorded on IBM's own execution environment and may not transfer exactly to local hardware; reactive monitoring's own overhead is tracked as a first-class metric rather than assumed free.

## 07. Base Paper & Related Work

**Base paper:** Song, Han, Guo, Cai (2025), *IDL-LTSOJ*, High-Confidence Computing, Elsevier — solves OJ concurrency via Kafka task distribution; does not address resource prediction, tier adaptation, or reactive correction.

**Related work:** Pan, Liu, Wu (2022) — cloud-native OJ, horizontal auto-scaling, explicitly leaves FIFO+instance-spawning integration as unsolved future work. Zhang, Wu, Lu (2024) — DNN-based runtime prediction for queue reordering only, no tier adaptation or reactive correction. Wasik et al. (2018) — foundational OJ systems survey. Wang, Han, Chen (2021), MetaOJ — massive distributed OJ, uniform resource treatment.

No existing system combines predictive and reactive resource-tier classification with true mid-run cgroup migration.

## 08. Team

| Person | Responsibility |
| --- | --- |
| Bharath Aashish R | UI & Code Editor |
| Dhanush M | XGBoost Model training |
| Iniyaa P | tree-sitter + feature extraction |
| Hemanthkumar K | Server + Isolation Manager |

## 09. License

TBD.
