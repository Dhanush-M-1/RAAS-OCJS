#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 10;
const int MOD = 1e9 + 7;
struct segment {
  int l, r, to_add;
  pair<int, int> sum;
  int size() { return r - l; }
  int unity(int _l, int _r) { return max(0 * l, min(_r, r) - max(_l, l)); }
  segment(int _l = 0, int _r = 0) {
    l = _l;
    r = _r;
    sum = pair<int, int>(0, 0);
    to_add = 0;
  }
} seg[N << 2];
int n, h[N], lp[N], rp[N], ans[N];
vector<pair<int, int> > que[N], g[N];
vector<int> st;
int dfs(int, int = 0, int = 0, int = 0);
void build(int, int, int = 1);
void add(int, int, int = 1);
pair<int, int> get(int, int, int = 0, int = 1);
void update(int);
pair<int, int> get(int);
void answer(int, int = 0);
pair<int, int> calc(pair<int, int>, int, int);
pair<int, int> _pair_sum(pair<int, int>, pair<int, int>);
int _sum(int, int);
int _mul(int, int);
int _neg(int);
int32_t main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n;
  for (int i = 1; i < n; i++) {
    int v, u, w;
    cin >> v >> u >> w;
    v--;
    u--;
    g[v].push_back({u, w});
    g[u].push_back({v, w});
  }
  dfs(0);
  build(0, n);
  int q;
  cin >> q;
  for (int i = 0; i < q; i++) {
    int v, u;
    cin >> v >> u;
    v--;
    u--;
    que[v].push_back({u, i});
  }
  answer(0);
  for (int i = 0; i < q; i++) cout << ans[i] << endl;
}
int dfs(int v, int pv, int d, int cur_pos) {
  h[v] = d;
  lp[v] = cur_pos;
  rp[v] = cur_pos + 1;
  st.push_back(v);
  for (auto [u, w] : g[v])
    if (u != pv) rp[v] = dfs(u, v, _sum(d, w), rp[v]);
  return rp[v];
}
void answer(int v, int pv) {
  int sigma_t = _neg(get(0).second);
  for (auto [u, query] : que[v])
    ans[query] = _sum(sigma_t, _mul(2, get(u).second));
  for (auto [u, w] : g[v])
    if (u != pv) {
      add(0, w);
      add(u, _mul(_neg(2), w));
      answer(u, v);
      add(u, _mul(2, w));
      add(0, _mul(_neg(1), w));
    }
}
void build(int l, int r, int v) {
  seg[v] = segment(l, r);
  if (r - l == 1) {
    seg[v].sum = {h[st[l]], _mul(h[st[l]], h[st[l]])};
    return;
  }
  int med = (l + r) / 2;
  build(l, med, v << 1);
  build(med, r, v << 1 | 1);
  update(v);
}
void add(int ver, int val, int v) {
  int l = lp[ver];
  int r = rp[ver];
  if (seg[v].unity(l, r) == 0) return;
  if (seg[v].unity(l, r) == seg[v].size()) {
    seg[v].to_add = _sum(seg[v].to_add, val);
    seg[v].sum = calc(seg[v].sum, seg[v].size(), val);
    return;
  }
  add(ver, val, v << 1);
  add(ver, val, v << 1 | 1);
  update(v);
  seg[v].sum = calc(seg[v].sum, seg[v].size(), seg[v].to_add);
}
pair<int, int> get(int ver) { return get(lp[ver], rp[ver]); }
pair<int, int> get(int l, int r, int par_sum, int v) {
  if (seg[v].unity(l, r) == 0) return pair<int, int>(0, 0);
  if (seg[v].unity(l, r) == seg[v].size())
    return calc(seg[v].sum, seg[v].size(), par_sum);
  pair<int, int> lc = get(l, r, _sum(par_sum, seg[v].to_add), v << 1);
  pair<int, int> rc = get(l, r, _sum(par_sum, seg[v].to_add), v << 1 | 1);
  return _pair_sum(lc, rc);
}
void update(int v) {
  seg[v].sum = _pair_sum(seg[v << 1].sum, seg[v << 1 | 1].sum);
}
pair<int, int> calc(pair<int, int> v, int cnt, int d) {
  auto [A, B] = v;
  int C = _mul(d, cnt);
  int sum_1 = _sum(A, C);
  int sum_2 = _sum(_sum(B, _mul(d, C)), _mul(_mul(2, d), A));
  return pair<int, int>(sum_1, sum_2);
}
int _sum(int a, int b) {
  a += b;
  if (a >= MOD) a -= MOD;
  return a;
}
int _mul(int a, int b) { return 1LL * a * b % MOD; }
int _neg(int x) {
  return MOD - x;
  x = -x;
  while (x < 0) x += MOD;
  return x;
}
pair<int, int> _pair_sum(pair<int, int> a, pair<int, int> b) {
  return pair<int, int>(_sum(a.first, b.first), _sum(a.second, b.second));
}
