#include <bits/stdc++.h>
using namespace std;
long long const M = 1e5 + 10, mod = 1e9 + 7, inf = 1e9 + 10;
long long par[M][30], dp[M], zt[M], sum[M], val[M][30], sum2[M], n, dp2[M],
    len = 0, h[M];
vector<long long> adj[M], edg[M], inc[M];
long long mrg(long long x, long long y, long long sm, long long cnt) {
  long long ans = (x + ((y * y) % mod) * cnt + ((sm * y) % mod) * 2) % mod;
  return ans;
}
void dfs_down(long long v, long long l, long long c) {
  zt[v] = 1;
  val[v][0] = c;
  h[v] = h[l] + 1;
  par[v][0] = l;
  for (long long i = 1; i <= 20; i++) {
    par[v][i] = par[par[v][i - 1]][i - 1];
    val[v][i] = val[par[v][i - 1]][i - 1] + val[v][i - 1];
    val[v][i] %= mod;
  }
  for (long long i = 0; i < adj[v].size(); i++) {
    long long u = adj[v][i];
    if (u != l) dfs_down(u, v, edg[v][i]);
    if (u == l) {
      inc[v].push_back(0);
      continue;
    }
    zt[v] += zt[u];
    sum[v] += sum[u];
    sum[v] %= mod;
    sum[v] += edg[v][i] * zt[u];
    sum[v] %= mod;
    long long res = mrg(dp[u], edg[v][i], sum[u], zt[u]);
    inc[v].push_back(res);
    dp[v] += res;
    dp[v] %= mod;
  }
  dp2[v] = dp[v];
}
void dfs_up(long long v, long long l, long long c, long long cc) {
  if (v == 1) sum2[v] = sum[v];
  if (v != 1) {
    sum2[v] += (sum2[l] - ((cc * zt[v] + sum[v]) % mod) + mod) % mod;
    sum2[v] %= mod;
    long long res = dp[l] - c;
    res += mod;
    res %= mod;
    dp[v] += mrg(res, cc, sum2[v], n - zt[v]);
    dp[v] %= mod;
    sum2[v] += sum[v];
    sum2[v] %= mod;
    sum2[v] += cc * (n - zt[v]);
    sum2[v] %= mod;
  }
  for (long long i = 0; i < adj[v].size(); i++) {
    long long u = adj[v][i];
    if (u != l) dfs_up(u, v, inc[v][i], edg[v][i]);
  }
}
long long lca(long long v, long long u) {
  if (h[v] < h[u]) swap(v, u);
  for (long long i = 20; i >= 0; i--) {
    if (h[v] - (1 << i) >= h[u]) len += val[v][i], v = par[v][i];
  }
  len %= mod;
  if (v == u) return v;
  for (long long i = 20; i >= 0; i--) {
    if (par[v][i] != par[u][i])
      len += val[v][i], len += val[u][i], v = par[v][i], u = par[u][i];
  }
  len += val[v][0];
  len += val[u][0];
  len %= mod;
  v = par[v][0];
  return v;
}
int32_t main() {
  cin >> n;
  for (long long i = 1; i <= n - 1; i++) {
    long long a, b, c;
    cin >> a >> b >> c;
    adj[a].push_back(b);
    adj[b].push_back(a);
    edg[a].push_back(c);
    edg[b].push_back(c);
  }
  dfs_down(1, 0, 0);
  dfs_up(1, 0, 0, 0);
  long long q;
  cin >> q;
  while (q--) {
    long long v, u;
    cin >> u >> v;
    len = 0;
    long long lc = lca(u, v);
    len %= mod;
    long long all = 0;
    if (lc != v) {
      all = -dp[u];
      all += mod;
      all %= mod;
      long long res = mrg(dp2[v], len, sum[v], zt[v]);
      all += res * 2;
      all %= mod;
    } else {
      all = dp[u];
      long long res = sum2[v] - sum[v];
      long long bad = dp[v] - dp2[v];
      bad += mod;
      bad %= mod;
      res += mod;
      res %= mod;
      long long hlp = mrg(bad, len, res, n - zt[v]);
      all -= 2 * hlp;
      all += 3 * mod;
      all %= mod;
    }
    cout << all << "\n";
  }
}
