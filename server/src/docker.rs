use crate::models::{CaseResult, Submission, TestCase};
use crate::policy::Tier;
use std::process::Stdio;
use std::time::Instant;
use tokio::io::{self, AsyncWriteExt};
use tokio::process::Command;

fn image_for(language: &str) -> &'static str {
    match language {
        "python" => "python-judge-runtime",
        "java" => "java-judge-runtime",
        "c" | "cpp" | "c++" => "cpp-judge-runtime",
        _ => "python-judge-runtime",
    }
}

fn source_filename(language: &str) -> &'static str {
    match language {
        "python" => "main.py",
        "cpp" | "c++" => "main.cpp",
        "c" => "main.c",
        "java" => "Main.java",
        _ => "main.py",
    }
}

fn write_source(submission: &Submission) -> std::io::Result<std::path::PathBuf> {
    let dir = std::env::temp_dir().join(format!("oj_{}", submission.id));
    let _ = std::fs::remove_dir_all(&dir);
    std::fs::create_dir(&dir)?;
    std::fs::write(
        dir.join(source_filename(&submission.language)),
        &submission.source,
    )?;
    Ok(dir)
}

fn get_tier_limits(tier: &Tier) -> Vec<String> {
    match tier {
        Tier::Low => vec!["--cpus=1".to_string(), "--memory=256m".to_string()],
        _ => vec![],
    }
}

async fn run_case(
    container: &str,
    run_cmd: &Vec<String>,
    test: &TestCase,
) -> io::Result<CaseResult> {
    let start = Instant::now();
    let mut args = vec!["exec".to_string(), "-i".to_string(), container.to_string()];
    args.extend(run_cmd.iter().cloned());
    let mut child = Command::new("docker")
        .args(args)
        .stdin(Stdio::piped())
        .stdout(Stdio::piped())
        .stderr(Stdio::piped())
        .spawn()
        .expect("docker exec failed");
    if let Some(mut stdin) = child.stdin.take() {
        stdin.write_all(test.input.as_bytes()).await?;
        drop(stdin); // close → program sees EOF
    }
    let output = child.wait_with_output().await.expect("child failed");
    let wall_ms = start.elapsed().as_millis() as u64;
    let stdout = String::from_utf8_lossy(&output.stdout).trim().to_string();
    let expected = test.expected.trim().to_string();
    let verdict = if !output.status.success() {
        "RE"
    } else if stdout == expected {
        "AC"
    } else {
        "WA"
    };
    Ok(CaseResult {
        verdict: verdict.to_string(),
        cpu_time_ms: wall_ms,
        peak_memory_bytes: 0,
    })
}

pub async fn run_submission(submission: &Submission, tier: &Tier) -> io::Result<Vec<CaseResult>> {
    let host_dir = write_source(submission)?;
    let (container, run_cmd) =
        start_and_compile(&submission.language, &submission.id, &host_dir, tier).await?;

    let mut results = Vec::new();
    for test in &submission.test_cases {
        results.push(run_case(&container, &run_cmd, test).await?);
    }
    let _ = Command::new("docker")
        .args(["rm", "-f", &container])
        .output()
        .await;
    let _ = std::fs::remove_dir_all(&host_dir);
    Ok(results)
}

async fn start_and_compile(
    language: &str,
    submission_id: &String,
    host_dir: &std::path::PathBuf,
    tier: &Tier,
) -> std::io::Result<(String, Vec<String>)> {
    let image = image_for(language);
    let cname = format!("oj_{}", submission_id);

    let _ = Command::new("docker")
        .args(["rm", "-f", &cname])
        .output()
        .await;

    let run_cmd = match language {
        "python" => vec!["python3".to_string(), "/app/main.py".to_string()],
        "java" => vec![
            "java".to_string(),
            "-cp".to_string(),
            "/app".to_string(),
            "Main".to_string(),
        ],
        "c" | "cpp" | "c++" => vec!["/app/run".to_string()],
        _ => vec![],
    };
    let tier_limits = get_tier_limits(tier);
    let mut start_args = vec![
        "run".to_string(),
        "-d".to_string(),
        "--name".to_string(),
        cname.to_string(),
        "--network=none".to_string(),
    ];
    start_args.extend(tier_limits);
    start_args.extend([
        image.to_string(),
        "sh".to_string(),
        "-c".to_string(),
        "sleep infinity".to_string(),
    ]);
    let start = Command::new("docker").args(start_args).output().await;
    if !start?.status.success() {
        return Err(std::io::Error::other("Error in starting containers"));
    }
    let source_file = source_filename(language);
    let cp = Command::new("docker")
        .args([
            "cp",
            &format!("{}/{}", host_dir.display(), source_file),
            &format!("{}:/app/{}", cname, source_file),
        ])
        .output()
        .await?;
    if !cp.status.success() {
        let _ = Command::new("docker")
            .args(["rm", "-f", &cname])
            .output()
            .await?;
        return Err(std::io::Error::other(
            String::from_utf8_lossy(&cp.stderr).to_string(),
        ));
    }

    let compile_cmd: &[&str] = match language {
        "java" => &["sh", "-c", "javac /app/Main.java -d /app"],
        "c" => &["sh", "-c", "gcc -o /app/run /app/main.c"],
        "cpp" | "c++" => &["sh", "-c", "g++ -o /app/run /app/main.cpp"],
        _ => &[],
    };
    if !compile_cmd.is_empty() {
        let comp = Command::new("docker")
            .args(["exec", &cname])
            .args(compile_cmd)
            .output()
            .await?;
        if !comp.status.success() {
            let _ = Command::new("docker")
                .args(["rm", "-f", &cname])
                .output()
                .await?;
            return Err(std::io::Error::other(
                String::from_utf8_lossy(&comp.stderr).to_string(),
            ));
        }
    }

    Ok((cname.clone(), run_cmd))
}
