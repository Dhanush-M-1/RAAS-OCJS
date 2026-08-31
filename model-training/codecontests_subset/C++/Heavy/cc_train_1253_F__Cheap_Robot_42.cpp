#include <bits/stdc++.h>
using namespace std;
const int N = 123456;
const int LN = 19;
const long long INF = 1LL << 60LL;
int n, m, k, q;
int parent[N];
int depth[N];
int anc[LN][N];
long long dp[LN][N];
long long dist[N];
vector<pair<int, int>> adj[N];
vector<tuple<long long, int, int>> edges;
vector<pair<int, long long>> tree[N];
void dijkstra() {
  priority_queue<pair<long long, int>> states;
  for (int i = 1; i <= n; i++) {
    dist[i] = INF;
  }
  for (int i = 1; i <= k; i++) {
    dist[i] = 0;
    states.push({-dist[i], i});
  }
  while (!states.empty()) {
    auto [cur_dist, u] = states.top();
    cur_dist = -cur_dist;
    states.pop();
    if (cur_dist > dist[u]) continue;
    for (auto [v, w] : adj[u]) {
      if (cur_dist + w < dist[v]) {
        dist[v] = cur_dist + w;
        states.push({-dist[v], v});
      }
    }
  }
}
inline int root(int x) {
  if (parent[x] == x) {
    return x;
  } else {
    return parent[x] = root(parent[x]);
  }
}
inline bool join(int u, int v) {
  u = root(u);
  v = root(v);
  if (u == v) return false;
  parent[v] = u;
  return true;
}
void dfs(int u, int p, long long pe = -1) {
  anc[0][u] = p;
  dp[0][u] = pe;
  for (int i = 1; i < LN; i++) {
    anc[i][u] = anc[i - 1][anc[i - 1][u]];
    dp[i][u] = max(dp[i - 1][u], dp[i - 1][anc[i - 1][u]]);
  }
  for (auto [v, w] : tree[u]) {
    if (v != p) {
      depth[v] = depth[u] + 1;
      dfs(v, u, w);
    }
  }
}
inline long long solve(int u, int v) {
  if (depth[u] < depth[v]) swap(u, v);
  long long ans = 0;
  for (int i = LN - 1; i >= 0; i--) {
    if (depth[u] - (1 << i) >= depth[v]) {
      ans = max(ans, dp[i][u]);
      u = anc[i][u];
    }
  }
  if (u == v) return ans;
  for (int i = LN - 1; i >= 0; i--) {
    if (anc[i][u] != anc[i][v]) {
      ans = max(ans, max(dp[i][u], dp[i][v]));
      u = anc[i][u];
      v = anc[i][v];
    }
  }
  return max(ans, max(dp[0][u], dp[0][v]));
}
int main() {
  ios ::sync_with_stdio(false);
  cin >> n >> m >> k >> q;
  for (int i = 1; i <= m; i++) {
    int u, v, w;
    cin >> u >> v >> w;
    adj[u].push_back({v, w});
    adj[v].push_back({u, w});
  }
  dijkstra();
  for (int i = 1; i <= n; i++) {
    parent[i] = i;
    for (auto [j, w] : adj[i]) {
      if (i > j) continue;
      edges.push_back(make_tuple(dist[i] + dist[j] + w, i, j));
    }
  }
  sort(edges.begin(), edges.end());
  for (auto [w, u, v] : edges) {
    if (join(u, v)) {
      tree[u].push_back({v, w});
      tree[v].push_back({u, w});
    }
  }
  dfs(1, 1);
  while (q--) {
    int u, v;
    cin >> u >> v;
    cout << solve(u, v) << endl;
  }
}
