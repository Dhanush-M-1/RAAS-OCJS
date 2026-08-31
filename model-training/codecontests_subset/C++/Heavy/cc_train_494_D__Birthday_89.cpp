#include <bits/stdc++.h>
using namespace std;
const int MAXN = 1e6 + 100;
const int MOD = 1e9 + 7;
long long T = 0;
long long st[MAXN], fn[MAXN];
vector<pair<long long, long long>> ver[MAXN];
pair<long long, long long> q[MAXN];
vector<long long> query[MAXN];
long long d[MAXN];
long long s[MAXN];
long long sum[MAXN * 4], lazy[MAXN * 4], seg[MAXN * 4];
long long res[MAXN], n;
inline void calc(long long id, long long xl, long long xr, long long qv) {
  long long sqr = qv * qv % MOD;
  seg[id] = (2 * sum[id] * qv + sqr * (xr - xl) + seg[id]) % MOD;
  sum[id] = (sum[id] + qv * (xr - xl)) % MOD;
  lazy[id] = (lazy[id] + qv) % MOD;
}
inline void shift(long long id, long long xl, long long xr) {
  if (!lazy[id]) return;
  long long mid = (xl + xr) / 2;
  calc(2 * id + 1, xl, mid, lazy[id]);
  calc(2 * id + 2, mid, xr, lazy[id]);
  lazy[id] = 0;
}
void upd(long long ql, long long qr, long long qv, long long xl = 0,
         long long xr = MAXN, long long id = 0) {
  if (ql <= xl && xr <= qr) return calc(id, xl, xr, qv);
  if (qr <= xl || xr <= ql) return;
  shift(id, xl, xr);
  long long mid = (xl + xr) / 2;
  upd(ql, qr, qv, xl, mid, 2 * id + 1);
  upd(ql, qr, qv, mid, xr, 2 * id + 2);
  seg[id] = (seg[2 * id + 1] + seg[2 * id + 2]) % MOD;
  sum[id] = (sum[2 * id + 1] + sum[2 * id + 2]) % MOD;
}
long long get(long long ql, long long qr, long long xl = 0, long long xr = MAXN,
              long long id = 0) {
  if (ql >= qr) return 0;
  if (ql <= xl && xr <= qr) return seg[id];
  if (qr <= xl || xr <= ql) return 0;
  shift(id, xl, xr);
  long long mid = (xl + xr) / 2;
  return (get(ql, qr, xl, mid, 2 * id + 1) + get(ql, qr, mid, xr, 2 * id + 2)) %
         MOD;
}
void build(long long xl = 0, long long xr = MAXN, long long id = 0) {
  if (xr - xl == 1) {
    sum[id] = s[xl];
    seg[id] = s[xl] * s[xl] % MOD;
    return;
  }
  long long mid = (xl + xr) / 2;
  build(xl, mid, 2 * id + 1);
  build(mid, xr, 2 * id + 2);
  sum[id] = (sum[2 * id + 1] + sum[2 * id + 2]) % MOD;
  seg[id] = (seg[2 * id + 1] + seg[2 * id + 2]) % MOD;
}
void pre_dfs(long long v, long long par = 0) {
  st[v] = T++;
  for (auto e : ver[v]) {
    long long u = e.first;
    long long w = e.second;
    if (u == par) continue;
    d[u] = (d[v] + w) % MOD;
    pre_dfs(u, v);
  }
  fn[v] = T;
}
void dfs(long long v, long long w = 0, long long par = 0) {
  for (auto u : query[v]) {
    long long k = q[u].second;
    res[u] = (2 * get(st[k], fn[k]) - seg[0] + MOD) % MOD;
  }
  for (auto e : ver[v]) {
    long long u = e.first;
    long long z = e.second;
    if (u == par) continue;
    upd(0, n, +z);
    upd(st[u], fn[u], (2 * MOD - 2 * z) % MOD);
    dfs(u, z, v);
  }
  upd(0, n, MOD - w);
  upd(st[v], fn[v], 2 * w % MOD);
}
int32_t main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0), cout.tie(0);
  cin >> n;
  for (long long i = 1; i < n; i++) {
    long long x, y, z;
    cin >> x >> y >> z;
    ver[x].push_back({y, z});
    ver[y].push_back({x, z});
  }
  pre_dfs(1);
  for (long long i = 1; i <= n; i++) s[st[i]] = d[i];
  build();
  long long nq;
  cin >> nq;
  for (long long i = 0; i < nq; i++) {
    cin >> q[i].first >> q[i].second;
    query[q[i].first].push_back(i);
  }
  dfs(1);
  for (long long i = 0; i < nq; i++) cout << res[i] << '\n';
}
