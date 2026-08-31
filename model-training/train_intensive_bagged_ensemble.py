"""
RAAS-OJS Intensive Bagged Ensemble & High-Capacity XGBoost Training Pipeline (60k Dataset)

Architecture:
1. Enhanced 26 AST & Algorithmic Interaction Features.
2. Group-Aware Stratified Split on `problem_id` (Zero Data Leakage).
3. 5-Seed Bagged Averaging Ensemble per language to eliminate prediction variance.
4. Youden's J Threshold Optimization per language.
5. Treelite C-native and JSON exports for production inference.
"""

import argparse
import json
import os
import sys

import joblib
import matplotlib.pyplot as plt
import numpy as np
import pandas as pd
from sklearn.metrics import (
    accuracy_score,
    classification_report,
    confusion_matrix,
    f1_score,
    precision_score,
    recall_score,
    roc_auc_score,
    roc_curve,
)
from sklearn.model_selection import GroupKFold, GroupShuffleSplit
import treelite
import treelite.frontend
import xgboost as xgb


BASE_AST_FEATURES = [
    "nesting_depth",
    "max_loop_depth",
    "total_loops",
    "cyclomatic_complexity",
    "is_recursive",
    "recursive_call_count",
    "large_alloc_flag",
    "has_fast_io",
    "has_heavy_datastructure",
    "has_modulo_arithmetic",
    "has_bitmask_ops",
    "has_graph_adjacency",
    "total_functions",
    "total_calls",
    "total_subscripts",
    "total_2d_subscripts",
    "total_arithmetic_ops",
    "max_integer_constant",
    "ast_node_count",
    "ast_depth",
    "source_loc",
    "source_chars",
]


def load_and_engineer_features(features_csv: str, manifest_csv: str) -> pd.DataFrame:
    """Load, clean, and engineer comprehensive structural and interaction features."""
    print(f"Loading features from: {features_csv}")
    df_feat = pd.read_csv(features_csv)
    print(f"Loading manifest from: {manifest_csv}")
    df_man = pd.read_csv(manifest_csv)

    if "problem_id" not in df_man.columns and "problem_name" in df_man.columns:
        df_man["problem_id"] = df_man["problem_name"]
    elif "problem_id" not in df_man.columns:
        df_man["problem_id"] = df_man["submission_id"]

    man_cols = [c for c in ["submission_id", "language", "problem_id", "cpu_time", "memory", "difficulty"] if c in df_man.columns]

    df = pd.merge(df_feat, df_man[man_cols], on=["submission_id", "language"], how="inner")
    print(f"Merged raw shape: {df.shape}")

    parse_errors = df[df["parse_error_flag"] == 1]
    if len(parse_errors) > 0:
        print(f"Filtering out {len(parse_errors)} syntax parse-error rows.")
        df = df[df["parse_error_flag"] == 0].copy()

    df["target"] = (df["label"] == "Heavy").astype(int)

    # 1. Classical Density Ratios
    df["loop_density"] = df["total_loops"] / np.maximum(df["ast_node_count"], 1)
    df["call_density"] = df["total_calls"] / np.maximum(df["ast_node_count"], 1)
    df["subscript_density"] = df["total_subscripts"] / np.maximum(df["ast_node_count"], 1)
    df["branch_density"] = df["cyclomatic_complexity"] / np.maximum(df["source_loc"], 1)
    df["arithmetic_density"] = df["total_arithmetic_ops"] / np.maximum(df["source_loc"], 1)
    df["subscript_2d_ratio"] = df["total_2d_subscripts"] / np.maximum(df["total_subscripts"], 1)
    df["recursion_intensity"] = df["recursive_call_count"] / np.maximum(df["total_functions"], 1)

    # 2. Enhanced Interaction & Complexity Features
    df["loop_nesting_pressure"] = df["max_loop_depth"] * df["nesting_depth"]
    df["ast_density_per_loc"] = df["ast_node_count"] / np.maximum(df["source_loc"], 1)
    df["cyclomatic_per_node"] = df["cyclomatic_complexity"] / np.maximum(df["ast_node_count"], 1)
    df["branch_recursion_product"] = df["recursive_call_count"] * df["cyclomatic_complexity"]

    # 3. Logarithmic Scaling
    df["log_max_constant"] = np.log10(np.maximum(df["max_integer_constant"], 1))
    df["log_ast_nodes"] = np.log1p(df["ast_node_count"])
    df["log_source_chars"] = np.log1p(df["source_chars"])
    df["log_loc"] = np.log1p(df["source_loc"])
    df["log_calls"] = np.log1p(df["total_calls"])

    return df


def get_feature_cols(include_language: bool = True) -> list[str]:
    cols = BASE_AST_FEATURES + [
        "loop_density",
        "call_density",
        "subscript_density",
        "branch_density",
        "arithmetic_density",
        "subscript_2d_ratio",
        "recursion_intensity",
        "loop_nesting_pressure",
        "ast_density_per_loc",
        "cyclomatic_per_node",
        "branch_recursion_product",
        "log_max_constant",
        "log_ast_nodes",
        "log_source_chars",
        "log_loc",
        "log_calls",
    ]
    if include_language:
        cols += ["lang_C", "lang_C++", "lang_Java", "lang_Python"]
    return cols


def find_optimal_threshold(y_true: np.ndarray, y_prob: np.ndarray) -> float:
    fpr, tpr, thresholds = roc_curve(y_true, y_prob)
    j_scores = tpr - fpr
    best_idx = np.argmax(j_scores)
    best_thresh = float(thresholds[best_idx])
    return max(0.2, min(0.8, best_thresh))


def train_bagged_ensemble(
    name: str,
    X_train: pd.DataFrame,
    y_train: pd.Series,
    groups_train: pd.Series,
    X_test: pd.DataFrame,
    y_test: pd.Series,
    base_params: dict,
    output_dir: str,
    seeds: list[int] = [42, 101, 2024, 777, 999],
) -> dict:
    print(f"\n{'='*75}\n[Model: {name}] Training 5-Seed Bagged Ensemble ({len(X_train)} train, {len(X_test)} test samples)\n{'='*75}")

    unique_groups = len(np.unique(groups_train))
    n_splits = min(5, unique_groups)
    cv_splitter = GroupKFold(n_splits=n_splits)

    # Compute class weight
    neg_count = (y_train == 0).sum()
    pos_count = (y_train == 1).sum()
    scale_pos = neg_count / max(pos_count, 1)

    cv_probs_all = np.zeros(len(X_train))
    test_probs_all = np.zeros(len(X_test))
    models = []

    for seed_idx, seed in enumerate(seeds):
        params = base_params.copy()
        params["random_state"] = seed
        params["scale_pos_weight"] = scale_pos
        params["tree_method"] = "hist"
        params["device"] = "cuda"
        params["objective"] = "binary:logistic"
        params["eval_metric"] = "logloss"

        # Out-of-fold CV
        seed_val_probs = np.zeros(len(X_train))
        for t_idx, v_idx in cv_splitter.split(X_train, y_train, groups_train):
            fold_X_tr, fold_y_tr = X_train.iloc[t_idx], y_train.iloc[t_idx]
            fold_X_val, fold_y_val = X_train.iloc[v_idx], y_train.iloc[v_idx]

            if len(np.unique(fold_y_tr)) < 2 or len(np.unique(fold_y_val)) < 2:
                continue

            clf = xgb.XGBClassifier(**params)
            clf.fit(fold_X_tr, fold_y_tr, eval_set=[(fold_X_val, fold_y_val)], verbose=False)
            seed_val_probs[v_idx] = clf.predict_proba(fold_X_val)[:, 1]

        cv_probs_all += seed_val_probs / len(seeds)

        # Train seed model on full training set
        model = xgb.XGBClassifier(**params)
        model.fit(X_train, y_train, verbose=False)
        models.append(model)
        test_probs_all += model.predict_proba(X_test)[:, 1] / len(seeds)

    # Determine Optimal Threshold from Ensemble Out-of-fold CV
    opt_threshold = find_optimal_threshold(y_train.values, cv_probs_all)
    cv_preds_opt = (cv_probs_all >= opt_threshold).astype(int)

    cv_acc = accuracy_score(y_train, cv_preds_opt)
    cv_f1 = f1_score(y_train, cv_preds_opt, zero_division=0)
    cv_roc = roc_auc_score(y_train, cv_probs_all) if len(np.unique(y_train)) > 1 else 1.0
    print(f"5-Fold CV Ensemble (Optimal Thresh={opt_threshold:.3f}): Acc={cv_acc:.4f}, F1={cv_f1:.4f}, ROC-AUC={cv_roc:.4f}")

    # Held-Out Unseen Test Problem Evaluation
    test_preds_opt = (test_probs_all >= opt_threshold).astype(int)
    test_acc_opt = accuracy_score(y_test, test_preds_opt)
    test_prec = precision_score(y_test, test_preds_opt, zero_division=0)
    test_rec = recall_score(y_test, test_preds_opt, zero_division=0)
    test_f1_opt = f1_score(y_test, test_preds_opt, zero_division=0)
    test_roc = roc_auc_score(y_test, test_probs_all) if len(np.unique(y_test)) > 1 else 1.0

    print(f"\nHeld-Out Test Results (Unseen Problems):")
    print(f"  Accuracy (Optimized {opt_threshold:.2f}): {test_acc_opt:.4f}")
    print(f"  Precision               : {test_prec:.4f}")
    print(f"  Recall                  : {test_rec:.4f}")
    print(f"  F1-Score                : {test_f1_opt:.4f}")
    print(f"  ROC-AUC                 : {test_roc:.4f}")

    # Save Primary Model & Bagged Ensemble
    safe_name = name.lower().replace(" ", "_").replace("+", "p")
    joblib_path = os.path.join(output_dir, f"bagged_ensemble_{safe_name}.joblib")
    primary_json = os.path.join(output_dir, f"model_{safe_name}.json")
    joblib.dump({"models": models, "optimal_threshold": opt_threshold, "features": list(X_train.columns)}, joblib_path)
    models[0].save_model(primary_json)

    try:
        tl_model = treelite.frontend.from_xgboost(models[0].get_booster())
        tl_path = os.path.join(output_dir, f"treelite_{safe_name}.checkpoint")
        tl_model.serialize(tl_path)
        print(f"  [Export] Treelite checkpoint: {tl_path}")
    except Exception as e:
        print(f"  [Export] Treelite error: {e}")

    return {
        "name": name,
        "optimal_threshold": opt_threshold,
        "cv_accuracy": cv_acc,
        "cv_f1": cv_f1,
        "cv_roc_auc": cv_roc,
        "test_accuracy": test_acc_opt,
        "test_f1": test_f1_opt,
        "test_roc_auc": test_roc,
        "test_precision": test_prec,
        "test_recall": test_rec,
        "y_true": y_test.values if hasattr(y_test, "values") else y_test,
        "y_pred": test_preds_opt,
        "y_prob": test_probs_all,
    }


def main():
    parser = argparse.ArgumentParser(description="Intensive Bagged Ensemble Training (60k Dataset)")
    parser.add_argument("--features-csv", default="features.csv", help="Path to features CSV")
    parser.add_argument("--manifest-csv", default="sample_manifest_codecontests.csv", help="Path to manifest CSV")
    parser.add_argument("--output-dir", default="artifacts_60k_intensive", help="Output directory")
    parser.add_argument("--seed", type=int, default=42, help="Random seed")
    args = parser.parse_args()

    os.makedirs(args.output_dir, exist_ok=True)

    df = load_and_engineer_features(args.features_csv, args.manifest_csv)

    lang_dummies = pd.get_dummies(df["language"], prefix="lang", dtype=int)
    for expected in ["C", "C++", "Java", "Python"]:
        col = f"lang_{expected}"
        if col not in lang_dummies.columns:
            lang_dummies[col] = 0

    df_full = pd.concat([df, lang_dummies], axis=1)

    # 80/20 Problem-Grouped Split
    groups = df_full["problem_id"]
    gss = GroupShuffleSplit(n_splits=1, test_size=0.2, random_state=args.seed)
    train_idx, test_idx = next(gss.split(df_full, df_full["target"], groups))

    df_train = df_full.iloc[train_idx].copy()
    df_test = df_full.iloc[test_idx].copy()

    print(f"\nGlobal Split Summary (60k Scale):")
    print(f"  Training set: {len(df_train)} samples across {df_train['problem_id'].nunique()} unique problems")
    print(f"  Test set    : {len(df_test)} samples across {df_test['problem_id'].nunique()} unique problems")

    # High-Capacity Base Parameters for each language
    params_unified = {
        "n_estimators": 450,
        "max_depth": 6,
        "learning_rate": 0.025,
        "subsample": 0.80,
        "colsample_bytree": 0.75,
        "min_child_weight": 4,
        "gamma": 0.1,
        "reg_alpha": 0.2,
        "reg_lambda": 2.0,
    }

    params_cpp = {
        "n_estimators": 500,
        "max_depth": 7,
        "learning_rate": 0.030,
        "subsample": 0.75,
        "colsample_bytree": 0.70,
        "min_child_weight": 2,
        "gamma": 0.5,
        "reg_alpha": 1.5,
        "reg_lambda": 4.0,
    }

    params_java = {
        "n_estimators": 350,
        "max_depth": 5,
        "learning_rate": 0.020,
        "subsample": 0.85,
        "colsample_bytree": 0.85,
        "min_child_weight": 5,
        "gamma": 0.2,
        "reg_alpha": 1.2,
        "reg_lambda": 2.5,
    }

    params_python = {
        "n_estimators": 400,
        "max_depth": 6,
        "learning_rate": 0.035,
        "subsample": 0.80,
        "colsample_bytree": 0.80,
        "min_child_weight": 2,
        "gamma": 0.05,
        "reg_alpha": 0.1,
        "reg_lambda": 1.0,
    }

    results = []

    # 1. Unified Model
    unified_cols = get_feature_cols(include_language=True)
    res_unified = train_bagged_ensemble(
        "Unified Multi-Language",
        df_train[unified_cols],
        df_train["target"],
        df_train["problem_id"],
        df_test[unified_cols],
        df_test["target"],
        params_unified,
        args.output_dir,
    )
    results.append(res_unified)

    # 2. Specialized Per-Language Models
    per_lang_cols = get_feature_cols(include_language=False)
    lang_param_map = {
        "C++": params_cpp,
        "Java": params_java,
        "Python": params_python,
    }

    per_lang_preds = []
    per_lang_trues = []

    for lang in ["C++", "Java", "Python"]:
        sub_train = df_train[df_train["language"] == lang]
        sub_test = df_test[df_test["language"] == lang]

        if len(sub_train) == 0 or len(sub_test) == 0:
            continue

        res_lang = train_bagged_ensemble(
            f"Specialized {lang}",
            sub_train[per_lang_cols],
            sub_train["target"],
            sub_train["problem_id"],
            sub_test[per_lang_cols],
            sub_test["target"],
            lang_param_map[lang],
            args.output_dir,
        )
        results.append(res_lang)
        per_lang_preds.extend(res_lang["y_pred"])
        per_lang_trues.extend(res_lang["y_true"])

    ensemble_acc = accuracy_score(per_lang_trues, per_lang_preds)
    ensemble_f1 = f1_score(per_lang_trues, per_lang_preds)
    print("\n" + "=" * 75)
    print(f"SPECIALIZED 60K BAGGED ENSEMBLE TEST ACCURACY: {ensemble_acc:.4f} | F1: {ensemble_f1:.4f}")
    print("=" * 75)

    print("\n--- 60k Intensive Model Performance Comparison ---")
    summary_data = []
    for r in results:
        summary_data.append({
            "Model": r["name"],
            "CV Acc": f"{r['cv_accuracy']:.2%}",
            "Test Acc": f"{r['test_accuracy']:.2%}",
            "Test F1": f"{r['test_f1']:.2%}",
            "Test Recall": f"{r['test_recall']:.2%}",
            "Test ROC-AUC": f"{r['test_roc_auc']:.4f}",
            "Opt Thresh": f"{r['optimal_threshold']:.3f}",
        })
    summary_df = pd.DataFrame(summary_data)
    print(summary_df.to_string(index=False))

    summary_df.to_csv(os.path.join(args.output_dir, "model_comparison_60k_intensive.csv"), index=False)

    # Plot Comparison Chart
    fig, ax = plt.subplots(figsize=(10, 5))
    x_pos = np.arange(len(results))
    accs = [r["test_accuracy"] * 100 for r in results]
    f1s = [r["test_f1"] * 100 for r in results]
    rocs = [r["test_roc_auc"] * 100 for r in results]

    width = 0.25
    ax.bar(x_pos - width, accs, width, label="Test Accuracy (%)", color="royalblue")
    ax.bar(x_pos, f1s, width, label="Test F1 (%)", color="seagreen")
    ax.bar(x_pos + width, rocs, width, label="Test ROC-AUC (x100)", color="darkorange")

    ax.set_xticks(x_pos)
    ax.set_xticklabels([r["name"] for r in results], rotation=15, ha="right")
    ax.set_ylabel("Score (%)")
    ax.set_title("60k Intensive Bagged XGBoost Model Comparison")
    ax.set_ylim(0, 100)
    ax.legend()
    ax.grid(axis="y", alpha=0.3)
    plt.tight_layout()
    plot_path = os.path.join(args.output_dir, "model_comparison_60k_intensive.png")
    fig.savefig(plot_path, dpi=300)
    plt.close(fig)

    print(f"\nSaved comparison plot: {plot_path}")
    print("60k Intensive training pipeline complete!")


if __name__ == "__main__":
    main()
