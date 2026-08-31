#include <bits/stdc++.h>
using namespace std;
struct min_cost_flow {
  static const int64_t INF = numeric_limits<int64_t>::max() >> 1;
  int64_t n, s, t;
  struct edge {
    int64_t u, v, c, f, cost;
  };
  vector<edge> E;
  vector<vector<int64_t>> graph;
  vector<int64_t> dist, head;
  vector<bool> inq;
  min_cost_flow(int64_t n = 0, int64_t s = 0, int64_t t = 0)
      : n(n), s(s), t(t) {
    E.clear();
    graph.assign(n + 1, vector<int64_t>());
  }
  int64_t add_edge(int64_t u, int64_t v, int64_t c, int64_t cost) {
    int64_t res = E.size();
    graph[u].push_back(E.size());
    E.push_back({u, v, c, 0, cost});
    graph[v].push_back(E.size());
    E.push_back({v, u, 0, 0, -cost});
    return res;
  }
  bool SPFA() {
    head.assign(n + 1, -1);
    dist.assign(n + 1, 1e9);
    dist[s] = 0;
    queue<pair<int64_t, int64_t>> wl;
    wl.push({0, s});
    while (not wl.empty()) {
      int64_t d = wl.front().first, u = wl.front().second;
      wl.pop();
      if (d > dist[u]) continue;
      for (int64_t i : graph[u]) {
        if (dist[E[i].v] > d + E[i].cost && E[i].f < E[i].c) {
          dist[E[i].v] = d + E[i].cost, head[E[i].v] = i;
          wl.push({dist[E[i].v], E[i].v});
        }
      }
    }
    return (head[t] != -1);
  }
  int64_t dfs() {
    int64_t delta = INF;
    for (int64_t u = t; u != s; u = E[head[u]].u) {
      int64_t i = head[u];
      delta = min(delta, E[i].c - E[i].f);
    }
    for (int64_t u = t; u != s; u = E[head[u]].u) {
      int64_t i = head[u];
      E[i].f += delta, E[i ^ 1].f -= delta;
    }
    return delta;
  }
  int64_t max_flow() {
    int64_t ans = 0, flow = 0;
    while (SPFA()) {
      int64_t det = dfs();
      ans += dist[t] * det;
      flow += det;
    }
    return ans;
  }
};
void solve() {
  int64_t n, k;
  cin >> n >> k;
  vector<int64_t> a(n), b(n);
  for (int64_t i = 0; i < n; i++) cin >> a[i] >> b[i];
  int64_t s = n * 2, t = n * 2 + 1;
  min_cost_flow mcf(n * 2 + 2, s, t);
  for (int64_t i = 0; i < n; i++) mcf.add_edge(s, i, 1, 0);
  for (int64_t i = 0; i < n; i++) mcf.add_edge(i + n, t, 1, 0);
  vector<vector<int64_t>> slot_to_minion(n, vector<int64_t>(n));
  for (int64_t i = 0; i < n; i++)
    for (int64_t j = 0; j < n; j++) {
      if (j < k)
        slot_to_minion[i][j] = mcf.add_edge(i, n + j, 1, -(a[i] + j * b[i]));
      else
        slot_to_minion[i][j] = mcf.add_edge(i, n + j, 1, -(k - 1) * b[i]);
    }
  mcf.max_flow();
  cout << n + n - k << endl;
  for (int64_t i = 0; i < k - 1; i++) {
    for (int64_t j = 0; j < n; j++)
      if (mcf.E[slot_to_minion[j][i]].f > 0) {
        cout << (j + 1) << " ";
        break;
      }
  }
  for (int64_t i = k; i < n; i++) {
    for (int64_t j = 0; j < n; j++)
      if (mcf.E[slot_to_minion[j][i]].f > 0) {
        cout << (j + 1) << " " << -(j + 1) << " ";
        break;
      }
  }
  for (int64_t j = 0; j < n; j++)
    if (mcf.E[slot_to_minion[j][k - 1]].f > 0) {
      cout << (j + 1) << "\n";
      break;
    }
}
signed main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int64_t tc;
  cin >> tc;
  while (tc--) solve();
  return 0;
}
