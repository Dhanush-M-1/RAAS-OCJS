#include <bits/stdc++.h>
using namespace std;
const int MAXN = 100 * 1000 + 17, mod = 1e9 + 7, lg = 20;
int sum(int a, int b) { return (1LL * a + b + mod) % mod; }
int mul(int a, int b) { return (1LL * a * b) % mod; }
int n, dp[MAXN][5], q, sz[MAXN], up[MAXN][lg], tin[MAXN], tout[MAXN], timer,
    sm[MAXN][lg];
vector<pair<int, int> > adj[MAXN];
int addEDGE(int x, int y, int sz, int e) {
  return sum(x, sum(mul(e, mul(e, sz)), mul(mul(2, e), y)));
}
void dfs_down(int v = 1, int par = 0) {
  tin[v] = ++timer;
  up[v][0] = par;
  for (int i = 1; i < lg; i++) up[v][i] = up[up[v][i - 1]][i - 1];
  for (auto i : adj[v])
    if (i.first != par) {
      int u = i.first;
      dfs_down(u, v);
      sz[v] += sz[u];
      dp[v][2] = sum(dp[v][2], addEDGE(dp[u][2], dp[u][3], sz[u], i.second));
      dp[v][3] = sum(dp[v][3], sum(dp[u][3], mul(i.second, sz[u])));
    }
  tout[v] = ++timer;
  sz[v]++;
}
void dfs_up(int v = 1, int par = 0, int e = 0) {
  if (v == 1)
    ;
  else {
    dp[v][4] = sum(sum(dp[par][3], -sum(dp[v][3], mul(e, sz[v]))),
                   sum(dp[par][4], mul(e, n - sz[v])));
    int tmp1 = sum(sum(dp[par][2], dp[par][1]),
                   -addEDGE(dp[v][2], dp[v][3], sz[v], e));
    int tmp2 =
        mul(2, mul(e, sum(dp[par][4],
                          sum(dp[par][3], -sum(dp[v][3], mul(e, sz[v]))))));
    int tmp3 = mul(n - sz[v], mul(e, e));
    dp[v][1] = sum(tmp1, sum(tmp2, tmp3));
  }
  sm[v][0] = e;
  for (int i = 1; i < lg; i++)
    sm[v][i] = sum(sm[v][i - 1], sm[up[v][i - 1]][i - 1]);
  for (auto i : adj[v])
    if (i.first != par) dfs_up(i.first, v, i.second);
}
bool is_anc(int v, int u) { return tin[v] <= tin[u] && tout[u] <= tout[v]; }
int lca(int v, int u) {
  if (is_anc(u, v)) return u;
  for (int i = lg - 1; i >= 0; i--)
    if (!is_anc(up[u][i], v)) u = up[u][i];
  return up[u][0];
}
int getPAR(int v, int u) {
  if (v == u) return 0;
  int res = 0;
  for (int i = lg - 1; i >= 0; i--)
    if (!is_anc(up[u][i], v)) res = sum(res, sm[u][i]), u = up[u][i];
  return sum(res, sm[u][0]);
}
int get(int v, int u) {
  if (v == u) return 0;
  int res = 0, lc = lca(v, u);
  res = sum(getPAR(lc, v), getPAR(lc, u));
  return res;
}
int main() {
  ios_base::sync_with_stdio(false), cin.tie(0), cout.tie(0);
  tout[0] = MAXN * 4;
  cin >> n;
  for (int i = 1; i < n; i++) {
    int v, u, w;
    cin >> v >> u >> w;
    adj[v].push_back({u, w});
    adj[u].push_back({v, w});
  }
  dfs_down();
  dfs_up();
  cin >> q;
  while (q--) {
    int v, u;
    cin >> u >> v;
    if (is_anc(v, u)) {
      int e = get(v, u);
      int tmp = addEDGE(dp[v][1], dp[v][4], n - sz[v], e);
      cout << sum(sum(dp[u][1], dp[u][2]), -mul(2, tmp)) << '\n';
    } else {
      int e = get(v, u);
      cout << sum(mul(2, addEDGE(dp[v][2], dp[v][3], sz[v], e)),
                  -sum(dp[u][1], dp[u][2]))
           << '\n';
    }
  }
  return 0;
}
