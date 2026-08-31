#include <bits/stdc++.h>
using namespace std;
const long long N = 100 * 1000 + 5, LG = 19, mod = 1000 * 1000 * 1000 + 7;
long long n, q;
long long sz[N], h[N];
long long sumd[N], sumu[N], dpd[N], dpu[N];
pair<long long, long long> par[N][LG];
vector<pair<long long, long long> > adj[N];
void dfs1(long long v) {
  sz[v] = 1;
  for (auto p : adj[v]) {
    long long u = p.first;
    long long w = p.second;
    if (u != par[v][0].first) {
      h[u] = h[v] + 1;
      par[u][0] = {v, w};
      dfs1(u);
      sz[v] += sz[u];
      sumd[v] += sumd[u] + 1ll * w * sz[u];
      sumd[v] %= mod;
      long long t = 1ll * w * w;
      t %= mod;
      t *= sz[u];
      t %= mod;
      dpd[v] += 2ll * sumd[u] * w;
      dpd[v] %= mod;
      dpd[v] += t;
      dpd[v] += dpd[u];
      dpd[v] %= mod;
    }
  }
}
void dfs2(long long v) {
  for (auto p : adj[v]) {
    long long u = p.first;
    long long w = p.second;
    if (u != par[v][0].first) {
      long long q = dpd[v] + dpu[v];
      long long t = 1ll * w * w;
      t %= mod;
      t *= sz[u];
      t %= mod;
      q -= t - mod;
      q -= (2ll * sumd[u] * w) % mod - mod;
      q -= dpd[u] - mod;
      q %= mod;
      dpu[u] = q;
      long long t2 = 1ll * w * w;
      t2 %= mod;
      t2 *= (n - sz[u]);
      t2 %= mod;
      dpu[u] += t2;
      dpu[u] %= mod;
      dpu[u] += 1ll * (mod + 1) * mod;
      dpu[u] %= mod;
      long long kft =
          sumd[v] + sumu[v] - sumd[u] - 1ll * w * sz[u] + 1ll * mod * mod;
      kft %= mod;
      kft *= 2 * w;
      kft %= mod;
      dpu[u] += kft;
      dpu[u] %= mod;
      sumu[u] =
          sumd[v] + sumu[v] - 1ll * sz[u] * w - sumd[u] + 1ll * (n - sz[u]) * w;
      sumu[u] += 1ll * mod * mod;
      sumu[u] %= mod;
      dfs2(u);
    }
  }
}
pair<long long, long long> lcad(long long u, long long v) {
  long long ans = 0;
  if (h[u] > h[v]) {
    swap(u, v);
  }
  for (long long i = LG - 1; i >= 0; i--) {
    if (h[u] + (1 << i) <= h[v]) {
      ans += par[v][i].second;
      v = par[v][i].first;
    }
  }
  if (u == v) {
    return {ans, u};
  }
  for (long long i = LG - 1; i >= 0; i--) {
    if (par[v][i].first != par[u][i].first) {
      ans += par[v][i].second;
      ans += par[u][i].second;
      v = par[v][i].first;
      u = par[u][i].first;
    }
  }
  ans += par[v][0].second + par[u][0].second;
  return {ans, par[v][0].first};
}
int32_t main() {
  cin >> n;
  for (long long i = 1; i < n; i++) {
    long long u, v, w;
    cin >> u >> v >> w;
    adj[u].push_back({v, w});
    adj[v].push_back({u, w});
  }
  par[1][0].first = 1;
  dfs1(1);
  dfs2(1);
  cin >> q;
  for (long long j = 1; j < LG; j++) {
    for (long long i = 1; i <= n; i++) {
      long long u = par[i][j - 1].first;
      par[i][j].first = par[u][j - 1].first;
      par[i][j].second = (par[i][j - 1].second + par[u][j - 1].second) % mod;
    }
  }
  for (long long i = 0; i < q; i++) {
    long long u, v;
    cin >> u >> v;
    pair<long long, long long> p = lcad(u, v);
    long long x = p.first;
    long long r = p.second;
    x %= mod;
    if (r == v) {
      long long ans = dpd[u] + dpu[u];
      long long e = 2ll * sumu[v];
      e %= mod;
      e *= x;
      e %= mod;
      ans -= 2ll * (e + dpu[v]) - 4ll * mod;
      ans %= mod;
      long long kft = 1ll * ((2ll * x * x) % mod) * (n - sz[v]);
      kft %= mod;
      ans -= kft - mod;
      ans += mod;
      ans %= mod;
      cout << ans << endl;
    } else {
      long long ans = 2ll * mod - dpd[u] - dpu[u];
      long long e = 2ll * sumd[v];
      e %= mod;
      e *= x;
      e %= mod;
      ans += 2ll * (e + dpd[v]);
      ans %= mod;
      ans += ((2ll * x * x) % mod) * sz[v];
      ans %= mod;
      cout << ans << endl;
    }
  }
  return 0;
}
