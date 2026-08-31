#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 10, Q = 3e5 + 10, M = 3e5 + 10;
const long long inf = 1e15 + 42;
struct edge_t {
  int u, v;
  long long w;
  bool operator<(const edge_t &o) const { return w < o.w; }
};
vector<pair<long long, long long>> g[N];
vector<pair<int, int>> queries[N];
edge_t e[M];
long long dist[N], ans[Q];
int back[N], par[N];
int get_root(int u);
void merge(int u, int v, long long w);
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n, m, k, q;
  cin >> n >> m >> k >> q;
  for (int i = 1; i <= m; ++i) {
    cin >> e[i].u >> e[i].v >> e[i].w;
    g[e[i].u].push_back({e[i].v, e[i].w});
    g[e[i].v].push_back({e[i].u, e[i].w});
  }
  priority_queue<pair<long long, long long>, vector<pair<long long, long long>>,
                 greater<pair<long long, long long>>>
      pq;
  for (int i = 1; i <= k; ++i) {
    pq.push({0, i});
    back[i] = i;
    par[i] = i;
  }
  for (int i = k + 1; i <= n; ++i) {
    dist[i] = inf;
  }
  while (!pq.empty()) {
    auto cur = pq.top();
    pq.pop();
    int u = cur.second;
    if (dist[u] < cur.first) {
      continue;
    }
    for (auto &edge : g[u]) {
      int v = edge.first, w = edge.second;
      if (dist[u] + w < dist[v]) {
        dist[v] = dist[u] + w;
        back[v] = back[u];
        pq.push({dist[v], v});
      }
    }
  }
  vector<edge_t> edges;
  for (int i = 1; i <= m; ++i) {
    int u = back[e[i].u], v = back[e[i].v];
    long long w = dist[e[i].u] + dist[e[i].v] + e[i].w;
    if (u != v) {
      edges.push_back({u, v, w});
    }
  }
  sort(edges.begin(), edges.end());
  for (int i = 1; i <= q; ++i) {
    int a, b;
    cin >> a >> b;
    queries[a].push_back({b, i});
    queries[b].push_back({a, i});
    ans[i] = inf;
  }
  for (auto &edge : edges) {
    merge(edge.u, edge.v, edge.w);
  }
  for (int i = 1; i <= q; ++i) {
    cout << ans[i] << '\n';
  }
}
int get_root(int u) {
  if (u != par[u]) {
    par[u] = get_root(par[u]);
  }
  return par[u];
}
void merge(int u, int v, long long w) {
  u = get_root(u);
  v = get_root(v);
  if (u == v) {
    return;
  } else if (queries[u].size() < queries[v].size()) {
    swap(u, v);
  }
  for (auto &q : queries[v]) {
    if (get_root(q.first) == u) {
      ans[q.second] = min(ans[q.second], w);
    } else {
      queries[u].push_back(q);
    }
  }
  par[v] = u;
}
