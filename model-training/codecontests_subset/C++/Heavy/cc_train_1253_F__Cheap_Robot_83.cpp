#include <bits/stdc++.h>
using namespace std;
const long long N = 1e5 + 5, oo = 1e18, LG = 22;
long long n, m, k, q, P[N][LG], dep[N], mx[N][LG];
vector<array<long long, 2>> adj[N], tree[N];
array<long long, 2> dist[N];
vector<array<long long, 3>> Edges;
void dfs(long long u, long long pre) {
  for (auto D : tree[u]) {
    long long v = D[0], w = D[1];
    if (v == pre) continue;
    P[v][0] = u;
    mx[v][0] = w;
    dep[v] = dep[u] + 1;
    dfs(v, u);
  }
}
long long query(long long u, long long v) {
  long long ret = 0;
  if (dep[u] < dep[v]) swap(u, v);
  for (long long i = LG - 1; i >= 0; --i)
    if ((1 << i) <= dep[u] - dep[v]) {
      ret = max(ret, mx[u][i]);
      u = P[u][i];
    }
  if (u == v) return ret;
  for (long long i = LG - 1; i >= 0; --i)
    if ((1 << i) <= dep[u] && P[u][i] != P[v][i]) {
      ret = max(ret, mx[u][i]);
      ret = max(ret, mx[v][i]);
      u = P[u][i];
      v = P[v][i];
    }
  ret = max(ret, mx[u][0]);
  ret = max(ret, mx[v][0]);
  return ret;
}
struct dsu_t {
  long long n;
  vector<long long> lab, Rank;
  dsu_t() {}
  dsu_t(long long _n) {
    this->n = _n;
    lab.assign(n + 5, -1);
    Rank.assign(n + 5, 1);
  }
  long long root(long long x) {
    return lab[x] == -1 ? x : lab[x] = root(lab[x]);
  }
  bool merge(long long u, long long v) {
    long long x = root(u), y = root(v);
    if (x == y) return false;
    if (Rank[x] < Rank[y]) swap(x, y);
    lab[y] = x;
    Rank[x] += Rank[y];
    return true;
  }
};
signed main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin >> n >> m >> k >> q;
  for (long long i = 1; i <= m; ++i) {
    long long u, v, w;
    cin >> u >> v >> w;
    adj[u].push_back({v, w});
    adj[v].push_back({u, w});
  }
  priority_queue<array<long long, 3>, vector<array<long long, 3>>,
                 greater<array<long long, 3>>>
      pq;
  while (!pq.empty()) pq.pop();
  for (long long i = 1; i <= k; ++i) {
    pq.push({0, i, i});
    dist[i] = {0, i};
  }
  for (long long i = k + 1; i <= n; ++i) {
    dist[i] = {oo, -1};
  }
  while (!pq.empty()) {
    array<long long, 3> cur = pq.top();
    pq.pop();
    long long D = cur[0], u = cur[1], beg = cur[2];
    if (D > dist[u][0]) continue;
    for (auto vv : adj[u]) {
      long long v = vv[0], w = vv[1];
      if (D + w < dist[v][0]) {
        dist[v][0] = D + w;
        dist[v][1] = beg;
        pq.push({D + w, v, beg});
      }
    }
  }
  for (long long u = 1; u <= n; ++u) {
    for (auto vv : adj[u]) {
      long long v = vv[0];
      if (dist[v][1] == dist[u][1] || u > v) continue;
      Edges.push_back(
          {dist[v][0] + dist[u][0] + vv[1], dist[v][1], dist[u][1]});
    }
  }
  sort(Edges.begin(), Edges.end());
  dsu_t dsu = dsu_t(k);
  for (auto D : Edges) {
    long long u = D[1], v = D[2], w = D[0];
    if (dsu.merge(u, v)) {
      tree[u].push_back({v, w});
      tree[v].push_back({u, w});
    }
  }
  dfs(1, -1);
  for (long long i = 1; i < LG; ++i) {
    for (long long u = 1; u <= n; ++u) {
      P[u][i] = P[P[u][i - 1]][i - 1];
      mx[u][i] = max(mx[u][i - 1], mx[P[u][i - 1]][i - 1]);
    }
  }
  for (long long i = 1; i <= q; ++i) {
    long long u, v;
    cin >> u >> v;
    cout << query(u, v) << endl;
  }
  return 0;
}
