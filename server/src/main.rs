mod docker;
mod models;
mod policy;
mod queue;

use axum::{Json, Router, routing::post};
use models::{CaseResult, JudgeResult, Submission, TestCase};
use policy::TierPolicy;
use queue::{start, submit};

async fn judge(submission: Submission, policy: &(dyn TierPolicy + Send + Sync)) -> JudgeResult {
    JudgeResult {
        submission_id: submission.id,
        approach: policy.name().to_string(),
        verdict: "AC".to_string(),
        cpu_time_ms: 0,
        peak_memory_bytes: 0,
        wall_time_ms: 0,
        tier_started: "high".to_string(),
        tier_promoted: false,
        promotion_time_ms: 0,
        cases: vec![],
    }
}

#[tokio::main]
async fn main() {
    let app = Router::new()
        .route("/submit", post(submit))
        .with_state(start());
    let listener = tokio::net::TcpListener::bind("0.0.0.0:3000").await.unwrap();
    println!("Judge is online and listening on :3000");
    axum::serve(listener, app).await.unwrap();
}
