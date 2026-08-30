use crate::{
    judge,
    models::{JudgeResult, Submission},
    policy::policy_for,
};
use axum::{Json, extract::State};
use std::{sync::Arc, time::Instant};
use tokio::sync::{Semaphore, mpsc, oneshot};

const MAX_CONCURRENT: usize = 16;
const QUEUE_BUFFER: usize = 100;

pub struct Job {
    submission: Submission,
    approach: String,
    respond_to: oneshot::Sender<JudgeResult>,
}

async fn dispatcher(mut rx: mpsc::Receiver<Job>, sem: Arc<Semaphore>) {
    let mut dequeued = 0;
    loop {
        let permit = sem.clone().acquire_owned().await.expect("Semaphore closed");
        let job = match rx.recv().await {
            Some(j) => j,
            None => break,
        };
        dequeued += 1;
        let submission_id = job.submission.id.clone();
        eprintln!(
            "[DISPATCHER] Dequeued job {} (total dequeued: {})",
            submission_id, dequeued
        );
        tokio::spawn(async move {
            let start = Instant::now();
            let policy = policy_for(&job.approach);
            let result = judge(job.submission, policy.as_ref()).await;
            let elapsed = start.elapsed();
            eprintln!("[JOB] {} completed in {:?}", submission_id, elapsed);
            let _ = job.respond_to.send(result);
            drop(permit);
        });
    }
}

pub async fn submit(
    State(tx): State<mpsc::Sender<Job>>,
    Json(submission): Json<Submission>,
) -> Json<JudgeResult> {
    let submission_id = submission.id.clone();
    eprintln!("[SUBMIT] Received request for {}", submission_id);
    let (resp_tx, resp_rx) = oneshot::channel();
    let job = Job {
        submission,
        approach: "baseline".to_string(),
        respond_to: resp_tx,
    };
    tx.send(job).await.expect("dispatcher failed");
    let result = resp_rx.await.expect("job dropped result");
    eprintln!("[SUBMIT] Returned result for {}", submission_id);
    Json(result)
}

pub fn start() -> mpsc::Sender<Job> {
    let (tx, rx) = mpsc::channel(QUEUE_BUFFER);
    let sem = Arc::new(Semaphore::new(MAX_CONCURRENT));
    tokio::spawn(dispatcher(rx, sem));
    tx
}
