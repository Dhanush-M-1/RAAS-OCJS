use axum::Json;
use axum::extract::State;
use tokio::sync::{mpsc, oneshot};

use crate::{
    judge,
    models::{JudgeResult, Submission, policy_for},
};

pub struct Job {
    submission: Submission,
    approach: String,
    respond_to: oneshot::Sender<JudgeResult>,
}

async fn worker(mut rx: mpsc::Receiver<Job>) {
    while let Some(job) = rx.recv().await {
        let policy = policy_for(&job.approach);
        let result = judge(job.submission, policy.as_ref()).await;
        let _ = job.respond_to.send(result);
    }
}

pub async fn submit(
    State(tx): State<mpsc::Sender<Job>>,
    Json(submission): Json<Submission>,
) -> Json<JudgeResult> {
    let (resp_tx, resp_rx) = oneshot::channel();
    let job = Job {
        approach: "baseline".to_string(), // TODO: pick per submission / query param
        submission,
        respond_to: resp_tx,
    };
    tx.send(job).await.expect("worker task died");
    let result = resp_rx.await.expect("worker dropped result");
    Json(result)
}

pub fn start() -> mpsc::Sender<Job> {
    let (tx, rx) = mpsc::channel(100);
    tokio::spawn(worker(rx));
    tx
}
