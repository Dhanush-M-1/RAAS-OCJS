#include <bits/stdc++.h>
using namespace std;
const long long MN = 101234, MOD = 1000 * 1000 * 1000 + 7;
long long st[MN], fn[MN], h[MN], res[MN], n;
vector<pair<long long, long long> > adj[MN], qwr[MN];
long long se1[MN * 4], se2[MN * 4], lz[MN * 4];
void boom(long long v, long long val, long long sz) {
  (se2[v] += val * val % MOD * sz % MOD + 2 * se1[v] * val % MOD) %= MOD;
  (se1[v] += val * sz % MOD) %= MOD;
  (lz[v] += val) %= MOD;
}
void add(long long l, long long r, long long val, long long s = 0,
         long long e = n, long long v = 1) {
  if (r <= s || e <= l) return;
  if (l <= s && e <= r) {
    boom(v, val, e - s);
    return;
  }
  long long mid = (s + e) / 2;
  boom(v * 2, lz[v], mid - s);
  boom(v * 2 + 1, lz[v], e - mid);
  lz[v] = 0;
  add(l, r, val, s, mid, v * 2);
  add(l, r, val, mid, e, v * 2 + 1);
  se1[v] = (se1[v * 2] + se1[v * 2 + 1]) % MOD;
  se2[v] = (se2[v * 2] + se2[v * 2 + 1]) % MOD;
}
long long get(long long l, long long r, long long s = 0, long long e = n,
              long long v = 1) {
  if (r <= s || e <= l) return 0;
  if (l <= s && e <= r) return se2[v];
  long long mid = (s + e) / 2;
  boom(v * 2, lz[v], mid - s);
  boom(v * 2 + 1, lz[v], e - mid);
  lz[v] = 0;
  long long x = get(l, r, s, mid, v * 2);
  long long y = get(l, r, mid, e, v * 2 + 1);
  return (x + y) % MOD;
}
void dfs(long long v, long long p = 0) {
  static long long t = 0;
  st[v] = t++;
  for (auto [u, w] : adj[v]) {
    if (u == p) continue;
    h[u] = (h[v] + w) % MOD;
    dfs(u, v);
  }
  fn[v] = t;
}
void sar(long long v, long long p = 0) {
  for (auto [u, w] : adj[v]) {
    if (u == p) continue;
    add(0, n, w);
    add(st[u], fn[u], ((-2 * w) % MOD + MOD) % MOD);
    sar(u, v);
    add(0, n, (-w + MOD) % MOD);
    add(st[u], fn[u], 2 * w % MOD);
  }
  for (auto [u, i] : qwr[v]) {
    res[i] = (get(st[u], fn[u]) * 2 % MOD - get(0, n) + MOD) % MOD;
  }
}
int32_t main() {
  cin >> n;
  for (long long i = 1; i < n; i++) {
    long long u, v, w;
    cin >> u >> v >> w;
    adj[--u].push_back({--v, w});
    adj[v].push_back({u, w});
  }
  dfs(0);
  long long q;
  cin >> q;
  for (long long i = 0; i < q; i++) {
    long long u, v;
    cin >> u >> v;
    qwr[--u].push_back({--v, i});
  }
  for (long long i = 0; i < n; i++) add(st[i], st[i] + 1, h[i]);
  sar(0);
  for (long long i = 0; i < q; i++) cout << res[i] << endl;
}
