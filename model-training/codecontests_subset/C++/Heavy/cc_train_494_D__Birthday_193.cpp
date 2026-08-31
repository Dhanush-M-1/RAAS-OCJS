#include <bits/stdc++.h>
using namespace std;
long long const N = 1e5 + 20, mod = 1e9 + 7;
long long n, q, ans[N], h[N], st[N], ft[N], tme;
long long sum1[N << 2], sum2[N << 2], lazy[N << 2];
vector<pair<long long, long long> > g[N], vec[N];
inline void add(long long& a, const long long& b) {
  a = (a + b % mod + mod) % mod;
}
void dfs1(long long v, long long par = -1) {
  st[v] = tme++;
  for (auto ed : g[v]) {
    long long u, w;
    tie(u, w) = ed;
    if (u != par) h[u] = (h[v] + w) % mod, dfs1(u, v);
  }
  ft[v] = tme;
}
inline void add(long long v, long long s, long long e, long long val) {
  add(lazy[v], val);
  add(sum2[v], val * val % mod * (e - s) + 2 * val * sum1[v]);
  add(sum1[v], (e - s) * val);
}
inline void shift(long long v, long long s, long long e, long long mid,
                  long long lc, long long rc) {
  add(lc, s, mid, lazy[v]);
  add(rc, mid, e, lazy[v]);
  lazy[v] = 0;
}
void upd(long long l, long long r, long long val, long long v = 1,
         long long s = 0, long long e = n) {
  if (s >= r || e <= l) return;
  if (s >= l && e <= r) {
    add(v, s, e, val);
    return;
  }
  long long mid = (s + e) >> 1, lc = v << 1, rc = lc | 1;
  shift(v, s, e, mid, lc, rc);
  upd(l, r, val, lc, s, mid), upd(l, r, val, rc, mid, e);
  sum1[v] = (sum1[lc] + sum1[rc]) % mod, sum2[v] = (sum2[lc] + sum2[rc]) % mod;
}
long long get(long long l, long long r, long long v = 1, long long s = 0,
              long long e = n) {
  if (s >= r || e <= l) return 0;
  if (s >= l && e <= r) return sum2[v];
  long long mid = (s + e) >> 1, lc = v << 1, rc = lc | 1;
  shift(v, s, e, mid, lc, rc);
  return (get(l, r, lc, s, mid) + get(l, r, rc, mid, e)) % mod;
}
void dfs2(long long v, long long par = -1, long long wtopar = -1) {
  if (v) upd(0, n, wtopar), upd(st[v], ft[v], -2 * wtopar);
  for (auto x : vec[v])
    ans[x.second] = -get(0, n) + 2 * get(st[x.first], ft[x.first]);
  for (auto ed : g[v]) {
    long long u, w;
    tie(u, w) = ed;
    if (u != par) dfs2(u, v, w);
  }
  if (v) upd(0, n, -wtopar), upd(st[v], ft[v], 2 * wtopar);
}
int32_t main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n;
  for (long long i = 0, u, v, w; i < n - 1; i++) {
    cin >> u >> v >> w;
    u--, v--;
    g[u].push_back({v, w}), g[v].push_back({u, w});
  }
  cin >> q;
  for (long long i = 0, u, v; i < q; i++) {
    cin >> u >> v;
    u--, v--;
    vec[u].push_back({v, i});
  }
  dfs1(0);
  for (long long i = 0; i < n; i++) upd(st[i], st[i] + 1, h[i]);
  dfs2(0);
  for (long long i = 0; i < q; i++) cout << (ans[i] + mod) % mod << '\n';
}
