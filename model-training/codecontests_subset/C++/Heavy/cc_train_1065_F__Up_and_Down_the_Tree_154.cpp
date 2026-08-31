#include <bits/stdc++.h>
using namespace std;
int n, K;
const int nax = 1000005;
const int lgnax = 22;
int lca[nax][lgnax] = {{0}}, depth[nax];
vector<int> g[nax];
int dsu[nax], size[nax], leaf[nax], head[nax];
int dp[nax] = {0};
int findSet(int x) {
  if (dsu[x] != x) dsu[x] = findSet(dsu[x]);
  return dsu[x];
}
void mergeSet(int u, int v) {
  u = findSet(u);
  v = findSet(v);
  if (u == v) return;
  if (size[u] < size[v]) swap(u, v);
  dsu[v] = u;
  size[u] += size[v];
  leaf[u] += leaf[v];
  head[u] = (depth[head[u]] < depth[head[v]]) ? head[u] : head[v];
}
int climb(int u, int d) {
  d = min(d, depth[u]);
  for (int i = lgnax; i >= 0; i--)
    if ((1 << i) <= d) {
      d -= (1 << i);
      u = lca[u][i];
    }
  return u;
}
int dfs1(int u = 1, int p = 0, int d = 0) {
  depth[u] = d;
  lca[u][0] = p;
  for (int i = 1; i < lgnax; i++) lca[u][i] = lca[lca[u][i - 1]][i - 1];
  int mx = 0;
  for (auto &k : g[u])
    if (k != p) {
      int r = dfs1(k, u, d + 1);
      if (mx == 0 || depth[r] < depth[mx]) mx = r;
    }
  if (mx == 0) mx = climb(u, K), leaf[u] = 1;
  if (depth[mx] < depth[u]) mergeSet(u, mx);
  return mx;
}
int dfs2(int u = 1, int p = 0) {
  int mx = 0;
  for (auto &k : g[u])
    if (k != p) mx = max(mx, dfs2(k, u));
  if (head[findSet(u)] == u) {
    dp[u] = leaf[findSet(u)] + mx;
    mx = dp[u];
  }
  return mx;
}
int32_t main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  for (int i = 1; i < nax; i++) {
    dsu[i] = i;
    size[i] = 1;
    leaf[i] = 0;
    head[i] = i;
  }
  cin >> n >> K;
  for (int i = 2; i <= n; i++) {
    int p;
    cin >> p;
    g[p].push_back(i);
  }
  dfs1();
  dfs2();
  cout << dp[1] << "\n";
}
