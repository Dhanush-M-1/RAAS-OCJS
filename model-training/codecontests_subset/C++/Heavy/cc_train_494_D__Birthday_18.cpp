#include <bits/stdc++.h>
using namespace std;
const int MOD = 1000 * 1000 * 1000 + 7;
const int MAX_N = 100 * 1000 + 10;
const int LOG = 20 + 5;
vector<pair<int, int>> adj[MAX_N];
int dp1[MAX_N], dp2[MAX_N];
int dp3[MAX_N], dp4[MAX_N];
int par[MAX_N][LOG];
int cmp[MAX_N], n;
int dis[MAX_N];
int h[MAX_N];
long long mul(long long a, long long b) {
  a %= MOD, b %= MOD;
  return a * b % MOD;
}
long long change(long long n) { return (n % MOD + MOD) % MOD; }
void dfs1(int u = 0, int dad = 0) {
  par[u][0] = dad, cmp[u] = 1;
  for (int i = 1; i < LOG; i++) par[u][i] = par[par[u][i - 1]][i - 1];
  for (auto x : adj[u])
    if (x.first != dad) {
      int v = x.first, w = x.second;
      h[v] = h[u] + 1, dis[v] = change(dis[u] + w), dfs1(v, u);
      cmp[u] += cmp[v];
      dp1[u] = change(dp1[u] + dp1[v] + mul(cmp[v], w));
      dp2[u] =
          change(dp2[u] + dp2[v] + mul(cmp[v], mul(w, w)) + mul(2 * dp1[v], w));
    }
}
void dfs2(int u = 0, int dad = 0, int w = 0) {
  dp3[u] = change(dp3[dad] + mul(n - 2 * cmp[u], w));
  dp4[u] = change(dp4[dad] + mul(n, mul(w, w)) +
                  mul(dp3[dad] - 2 * (dp1[u] + mul(cmp[u], w)), 2 * w));
  for (auto x : adj[u])
    if (x.first != dad) dfs2(x.first, u, x.second);
}
int get_par(int u, int k) {
  for (int i = 0; i < LOG; i++)
    if (k >> i & 1) u = par[u][i];
  return u;
}
int lca(int u, int v) {
  if (h[u] > h[v]) swap(u, v);
  v = get_par(v, h[v] - h[u]);
  if (u == v) return u;
  for (int i = LOG - 1; ~i; i--)
    if (par[u][i] != par[v][i]) u = par[u][i], v = par[v][i];
  return par[u][0];
}
int F(int u, int v) {
  int x = lca(u, v);
  int d = change(dis[u] + dis[v] - 2 * dis[x]);
  if (x != v)
    return change(2 * (dp2[v] + mul(cmp[v], mul(d, d)) + mul(dp1[v], 2 * d)) -
                  dp4[u]);
  return change(dp4[u] - 2 * (dp4[v] - dp2[v] + mul(n - cmp[v], mul(d, d)) +
                              mul(dp3[v] - dp1[v], 2 * d)));
}
int main() {
  ios_base ::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL);
  cin >> n;
  for (int i = 1; i < n; i++) {
    int u, v, w;
    cin >> u >> v >> w;
    u--, v--;
    adj[u].push_back({v, w});
    adj[v].push_back({u, w});
  }
  dfs1(), dp3[0] = dp1[0], dp4[0] = dp2[0], dfs2();
  int q;
  cin >> q;
  while (q--) {
    int u, v;
    cin >> u >> v;
    u--, v--;
    cout << F(u, v) << endl;
  }
  return 0;
}
