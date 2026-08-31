#include <bits/stdc++.h>
using namespace std;
const long long N = 1e5 + 10, MOD = 1e9 + 7, L = 20;
long long n, dp_down[N], dp_up[N], ch[N], dist_down[N], dist_up[N], dp[N][L],
    dpw[N][L], h[N], st[N], ft[N], now = 0;
vector<pair<long long, long long> > g[N];
void dfs_down(long long u, long long p) {
  st[u] = now++;
  ch[u]++;
  for (pair<long long, long long> a : g[u]) {
    long long v = a.first, w = a.second;
    if (v != p) {
      dfs_down(v, u);
      (dist_down[u] += (dist_down[v] + ((1ll * ch[v] * w) % MOD)) % MOD) %= MOD;
      ch[u] += ch[v];
      (dp_down[u] +=
       (dp_down[v] + ((1ll * ch[v] * ((1ll * w * w) % MOD)) % MOD)) % MOD) %=
          MOD;
      (dp_down[u] += (1ll * 2 * w * dist_down[v]) % MOD) %= MOD;
    }
  }
  ft[u] = now;
}
void dfs_up(long long u, long long p) {
  for (pair<long long, long long> a : g[u]) {
    long long v = a.first, w = a.second;
    if (v != p) {
      dist_up[v] = (dist_up[u] + dist_down[u] -
                    (dist_down[v] + ((1ll * w * ch[v]) % MOD))) %
                   MOD;
      if (dist_up[v] < 0) dist_up[v] += MOD;
      (dp_up[v] += (1ll * 2 * w * dist_up[v]) % MOD) %= MOD;
      dist_up[v] += (1ll * w * (n - ch[v])) % MOD;
      (dp_up[v] += (1ll * (n - ch[v]) * ((1ll * w * w) % MOD))) %= MOD;
      (dp_up[v] += dp_up[u]) %= MOD;
      (dp_up[v] += dp_down[u] -
                   ((dp_down[v] + ((1ll * ch[v] * ((1ll * w * w) % MOD)) % MOD +
                                   ((1ll * 2 * dist_down[v] * w) % MOD))) %
                    MOD)) %= MOD;
      while (dp_up[v] < 0) dp_up[v] += MOD;
      dfs_up(v, u);
    }
  }
}
void fill_dp(long long u, long long p, long long W, long long hei) {
  h[u] = hei;
  dp[u][0] = p;
  dpw[u][0] = W;
  for (long long i = 1; i < 20; i++) {
    dp[u][i] = dp[dp[u][i - 1]][i - 1];
    dpw[u][i] = (dpw[dp[u][i - 1]][i - 1] + dpw[u][i - 1]) % MOD;
  }
  for (pair<long long, long long> a : g[u]) {
    long long v = a.first, w = a.second;
    if (v != p) fill_dp(v, u, w, hei + 1);
  }
}
inline pair<long long, long long> par(long long u, long long x) {
  long long sum = 0;
  for (long long i = 19; i >= 0; i--)
    if ((1 << i) & x) {
      (sum += dpw[u][i]) %= MOD;
      u = dp[u][i];
    }
  return {u, sum};
}
inline long long dis(long long u, long long v) {
  if (h[u] > h[v]) swap(u, v);
  pair<long long, long long> a = par(v, h[v] - h[u]);
  long long sum = a.second;
  v = a.first;
  for (long long i = 19; i >= 0; i--)
    if (dp[u][i] != dp[v][i]) {
      (sum += (dpw[u][i] + dpw[v][i]) % MOD) %= MOD;
      u = dp[u][i];
      v = dp[v][i];
    }
  if (u != v) (sum += (dpw[u][0] + dpw[v][0]) % MOD) %= MOD;
  return sum;
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long u, v, q, w;
  cin >> n;
  for (long long i = 0; i < n - 1; i++) {
    cin >> u >> v >> w;
    u--, v--;
    g[u].push_back({v, w});
    g[v].push_back({u, w});
  }
  dfs_down(0, 0);
  dfs_up(0, 0);
  fill_dp(0, 0, 0, 0);
  cin >> q;
  for (long long i = 0; i < q; i++) {
    cin >> u >> v;
    u--, v--;
    if (st[u] < st[v] || st[u] >= ft[v]) {
      long long x = dis(u, v);
      long long res = 2 * ((1ll * 2 * x * dist_down[v]) % MOD) % MOD;
      x = (1ll * x * x) % MOD;
      res += (2 * (dp_down[v] + (1ll * ch[v] * x) % MOD)) -
             (dp_down[u] + dp_up[u]);
      while (res < 0) res += MOD;
      cout << res % MOD << "\n";
    } else {
      long long x = dis(u, v);
      long long res = (1ll * 2 * x * dist_up[v]) % MOD;
      x = (1ll * x * x) % MOD;
      res += (1ll * x * (n - ch[v])) % MOD;
      (res += dp_up[v]) %= MOD;
      res = (dp_down[u] + dp_up[u] - res) - res;
      while (res < 0) res += MOD;
      cout << res % MOD << "\n";
    }
  }
  return 0;
}
