#include <bits/stdc++.h>
using namespace std;
template <class T>
struct rge {
  T b, e;
};
template <class T>
rge<T> range(T i, T j) {
  return rge<T>{i, j};
}
struct debug {
  template <class T>
  debug& operator<<(const T&) {
    return *this;
  }
};
using ll = long long;
template <typename T>
void min_self(T& a, T b) {
  a = min(a, b);
}
template <typename T>
void max_self(T& a, T b) {
  a = max(a, b);
}
int k;
template <typename flow_t, typename cost_t>
class MinCostFlow {
 public:
  MinCostFlow(int _n, int _source, int _sink)
      : n(_n), source(_source), sink(_sink) {
    g.resize(n);
    cost.resize(n, vector<cost_t>(n));
    cap.resize(n, vector<flow_t>(n));
  }
  void add_edge(int from, int to, cost_t weight, flow_t c) {
    g[from].push_back(to);
    g[to].push_back(from);
    cost[to][from] = -weight;
    cost[from][to] = weight;
    cap[from][to] = c;
  }
  struct State {
    cost_t dist;
    int node;
    bool operator<(const State& rhs) const { return dist > rhs.dist; }
  };
  void shortest_paths(vector<cost_t>& dist, vector<int>& par) {
    dist.assign(n, COST_INF);
    par.assign(n, -1);
    dist[source] = 0;
    priority_queue<State> pq;
    pq.push({0LL, source});
    while (!pq.empty()) {
      State u = pq.top();
      pq.pop();
      if (u.dist > dist[u.node]) continue;
      for (int v : g[u.node]) {
        if (dist[v] > u.dist + cost[u.node][v] && cap[u.node][v] > 0) {
          dist[v] = u.dist + cost[u.node][v];
          par[v] = u.node;
          pq.push({dist[v], v});
        }
      }
    }
  }
  cost_t min_cost_flow() {
    flow_t mf = 0;
    cost_t total_cost = 0;
    vector<cost_t> dist(n);
    vector<int> par(n);
    while (true) {
      shortest_paths(dist, par);
      if (dist[sink] == COST_INF) {
        break;
      }
      flow_t f = FLOW_INF;
      int cur = sink;
      while (cur != source) {
        f = min(f, cap[par[cur]][cur]);
        cur = par[cur];
      }
      mf += f;
      total_cost += dist[sink];
      cur = sink;
      while (cur != source) {
        cap[par[cur]][cur] -= f;
        cap[cur][par[cur]] += f;
        cur = par[cur];
      }
    }
    int m = (sink - 1) / 2;
    cout << k + 2 * (m - k) << endl;
    for (int i = 0; i < int(m); i++) {
      int pos = i + m;
      for (int j = 0; j < int(m); j++) {
        if (cap[j][pos] == 0) {
          if (i < k - 1 || i == m - 1) {
            cout << j + 1 << ' ';
          } else {
            cout << (j + 1) << ' ' << -(j + 1) << ' ';
          }
        }
      }
    }
    cout << endl;
    return total_cost;
  }

 private:
  const flow_t FLOW_INF = numeric_limits<flow_t>::max() / 2;
  const cost_t COST_INF = numeric_limits<cost_t>::max() / 2;
  vector<vector<int>> g;
  vector<vector<flow_t>> cap;
  vector<vector<cost_t>> cost;
  int n, source, sink;
};
void test_case() {
  int n;
  cin >> n >> k;
  vector<int> a(n), b(n);
  for (int i = 0; i < int(n); i++) {
    cin >> a[i] >> b[i];
  }
  int source = 2 * n, sink = 2 * n + 1;
  MinCostFlow<int, int> graph(2 * n + 2, source, sink);
  for (int i = 0; i < n; i++) {
    graph.add_edge(source, i, 0, 1);
    graph.add_edge(i + n, sink, 0, 1);
  }
  for (int i = 0; i < n; i++) {
    for (int pos = 0; pos < n; pos++) {
      int w = 0;
      if (pos < k - 1) {
        w = -(a[i] + pos * b[i]);
      } else if (pos < n - 1) {
        w = -(k - 1) * b[i];
      } else {
        w = -(a[i] + (k - 1) * b[i]);
      }
      graph.add_edge(i, pos + n, w, 1);
    }
  }
  graph.min_cost_flow();
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  int tc;
  cin >> tc;
  while (tc--) {
    test_case();
  }
}
