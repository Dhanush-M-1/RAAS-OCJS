use crate::models::Submission;

pub type BoxedPolicy = Box<dyn TierPolicy + Send + Sync + 'static>;
#[derive(Clone, Copy, PartialEq, Eq, Debug)]
pub enum Tier {
    Low,
    High,
}
impl Tier {
    pub fn name(&self) -> &'static str {
        match self {
            Tier::Low => "low",
            Tier::High => "high",
        }
    }
}

#[derive(Clone, Copy)]
struct MonitorSignal {
    mem_current: u64,
    mem_high: u64,
    crossed_high: bool,
}

pub trait TierPolicy {
    fn name(&self) -> &str;
    fn initial_tier(&self, sub: &Submission) -> Tier;
    fn should_promote(&self, signal: &MonitorSignal) -> bool;
}

struct BaselinePolicy;
impl TierPolicy for BaselinePolicy {
    fn name(&self) -> &str {
        "baseline"
    }
    fn initial_tier(&self, _sub: &Submission) -> Tier {
        Tier::High
    }
    fn should_promote(&self, _signal: &MonitorSignal) -> bool {
        false
    }
}

struct PredictivePolicy;
impl TierPolicy for PredictivePolicy {
    fn name(&self) -> &str {
        "Predictive"
    }
    fn initial_tier(&self, sub: &Submission) -> Tier {
        super::predict::predict_tier(&sub.source, &sub.language)
    }
    fn should_promote(&self, _signal: &MonitorSignal) -> bool {
        false
    }
}

struct ReactivePolicy;
impl TierPolicy for ReactivePolicy {
    fn name(&self) -> &str {
        "Reactive"
    }
    fn initial_tier(&self, _sub: &Submission) -> Tier {
        Tier::Low
    }
    fn should_promote(&self, signal: &MonitorSignal) -> bool {
        signal.crossed_high
    }
}

struct HybridPolicy;
impl TierPolicy for HybridPolicy {
    fn name(&self) -> &str {
        "Hybrid"
    }
    fn initial_tier(&self, sub: &Submission) -> Tier {
        if sub.source.len() > 2000 {
            Tier::High
        } else {
            Tier::Low
        }
    }
    fn should_promote(&self, signal: &MonitorSignal) -> bool {
        signal.crossed_high
    }
}

pub fn policy_for(name: &str) -> BoxedPolicy {
    match name {
        "predictive" => Box::new(PredictivePolicy),
        "reactive" => Box::new(ReactivePolicy),
        "hybrid" => Box::new(HybridPolicy),
        _ => Box::new(BaselinePolicy),
    }
}
