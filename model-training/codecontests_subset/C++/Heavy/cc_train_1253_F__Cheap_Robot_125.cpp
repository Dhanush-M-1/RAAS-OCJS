#include <bits/stdc++.h>
using namespace std;
using ll = long long;
constexpr int kMaxN = 1e5 + 3;
constexpr ll inf = 1e18 + 7;
vector<pair<int, int>> edges[kMaxN];
int parent[kMaxN];
int r[kMaxN];
unordered_set<int> tokens[kMaxN];
int find_parent(int u) {
  if (u == parent[u]) {
    return u;
  }
  return parent[u] = find_parent(parent[u]);
}
vector<int> unite(int u, int v) {
  u = find_parent(u), v = find_parent(v);
  if (u == v) {
    return {};
  }
  if (r[u] < r[v]) {
    swap(u, v);
  }
  if (r[u] == r[v]) {
    ++r[u];
  }
  parent[v] = u;
  vector<int> connected;
  for (int token : tokens[v]) {
    if (tokens[u].count(token)) {
      connected.emplace_back(token);
    } else {
      tokens[u].emplace(token);
    }
  }
  return connected;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int n, m, k, q;
  cin >> n >> m >> k >> q;
  for (int i = 0; i < m; ++i) {
    int u, v, w;
    cin >> u >> v >> w;
    --u, --v;
    edges[u].emplace_back(v, w);
    edges[v].emplace_back(u, w);
  }
  vector<ll> d(n, inf);
  priority_queue<pair<ll, int>, vector<pair<ll, int>>, greater<pair<ll, int>>>
      pq;
  for (int i = 0; i < k; ++i) {
    d[i] = 0;
    pq.emplace(0, i);
  }
  while (!pq.empty()) {
    auto [du, u] = pq.top();
    pq.pop();
    if (du != d[u]) {
      continue;
    }
    for (auto [v, w] : edges[u]) {
      if (du + w < d[v]) {
        d[v] = du + w;
        pq.emplace(d[v], v);
      }
    }
  }
  vector<tuple<ll, int, int>> all_edges;
  all_edges.reserve(m);
  for (int u = 0; u < n; ++u) {
    for (auto& [v, w] : edges[u]) {
      if (u < v) {
        all_edges.emplace_back(w + d[u] + d[v], u, v);
      }
    }
    parent[u] = u;
  }
  sort(all_edges.begin(), all_edges.end());
  for (int i = 0; i < q; ++i) {
    int u, v;
    cin >> u >> v;
    --u, --v;
    tokens[u].emplace(i);
    tokens[v].emplace(i);
  }
  vector<ll> queries(q);
  for (auto [w, u, v] : all_edges) {
    for (int query : unite(u, v)) {
      queries[query] = w;
    }
  }
  for (ll query : queries) {
    cout << query << '\n';
  }
  return 0;
}
