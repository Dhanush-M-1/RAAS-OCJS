#include <bits/stdc++.h>
using namespace std;
const int MAXn = 1e5 + 10, MAXx = 4 * MAXn, MOD = 1e9 + 7;
long long n, q, st[MAXn], ft[MAXn], now, h[MAXn], ans[MAXn];
vector<pair<long long, long long> > g[MAXn], query[MAXn];
struct node {
  int l, r, lc, rc;
  long long lazy;
  pair<long long, long long> val;
  node() {
    lazy = l = r = lc = rc = 0;
    val = pair<long long, long long>(0, 0);
  }
  void id(int v) {
    lc = 2 * v;
    rc = 2 * v + 1;
  }
  int size() { return r - l; }
  bool leaf() { return size() == 1; }
  bool unity(int lq, int rq) { return max(l, lq) < min(r, rq); }
  int unitys(int lq, int rq) { return min(r, rq) - max(l, lq); }
  bool init(int lq, int rq) { return lq <= l && r <= rq; }
};
node seg[MAXx];
inline pair<long long, long long> merge(pair<long long, long long> p1,
                                        long long k, long long cnt) {
  k %= MOD;
  p1.first %= MOD;
  p1.second %= MOD;
  return pair<long long, long long>(
      (((p1.first + ((((k * k) % MOD) * cnt) % MOD)) % MOD) +
       ((((2 * k) % MOD) * p1.second) % MOD) + MOD) %
          MOD,
      (p1.second + ((k * cnt) % MOD) + MOD) % MOD);
}
void build(int v, int l, int r) {
  seg[v].id(v);
  seg[v].l = l;
  seg[v].r = r;
  if (seg[v].leaf()) {
    seg[v].val.first = (h[seg[v].l] * h[seg[v].l]) % MOD;
    seg[v].val.second = h[seg[v].l];
    return;
  }
  int med = (l + r) / 2;
  build(seg[v].lc, l, med);
  build(seg[v].rc, med, r);
  seg[v].val.first = seg[seg[v].lc].val.first + seg[seg[v].rc].val.first;
  seg[v].val.second = seg[seg[v].lc].val.second + seg[seg[v].rc].val.second;
}
void add(int v, int l, int r, long long k) {
  if (!seg[v].unity(l, r)) return;
  if (seg[v].init(l, r)) {
    seg[v].lazy += k + MOD;
    seg[v].lazy %= MOD;
    seg[v].val = merge(seg[v].val, k, seg[v].size());
    return;
  }
  add(seg[v].lc, l, r, k);
  add(seg[v].rc, l, r, k);
  seg[v].val.first = seg[seg[v].lc].val.first + seg[seg[v].rc].val.first;
  seg[v].val.second = seg[seg[v].lc].val.second + seg[seg[v].rc].val.second;
  seg[v].val = merge(seg[v].val, seg[v].lazy, seg[v].size());
}
pair<long long, long long> get(int v, int l, int r) {
  if (!seg[v].unity(l, r)) return pair<long long, long long>(0, 0);
  if (seg[v].init(l, r)) {
    return seg[v].val;
  }
  pair<long long, long long> hp1 = get(seg[v].lc, l, r),
                             hp2 = get(seg[v].rc, l, r);
  pair<long long, long long> res = pair<long long, long long>(
      (hp1.first + hp2.first) % MOD, (hp1.second + hp2.second) % MOD);
  res = merge(res, seg[v].lazy, seg[v].unitys(l, r));
  return res;
}
void dfs(int v, int par, long long hi) {
  st[v] = now++;
  h[st[v]] = hi;
  for (int i = 0; i < g[v].size(); i++)
    if (g[v][i].first != par)
      dfs(g[v][i].first, v, (hi + g[v][i].second) % MOD);
  ft[v] = now;
}
void dfsans(int v, int par) {
  for (int i = 0; i < query[v].size(); i++) {
    int ind = query[v][i].second, node = query[v][i].first;
    ans[ind] -= (get(1, 0, now).first + MOD) % MOD;
    ans[ind] = (ans[ind] + MOD) % MOD;
    ans[ind] += (2 * get(1, st[node], ft[node]).first) % MOD;
    ans[ind] = (ans[ind] + MOD) % MOD;
  }
  for (int i = 0; i < g[v].size(); i++) {
    long long node = g[v][i].first, weight = g[v][i].second;
    if (node != par) {
      add(1, 0, st[node], weight);
      add(1, st[node], ft[node], (MOD - weight));
      add(1, ft[node], now, weight);
      dfsans(node, v);
      add(1, ft[node], now, (MOD - weight));
      add(1, st[node], ft[node], weight);
      add(1, 0, st[node], (MOD - weight));
    }
  }
}
int main() {
  ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  cin >> n;
  for (int i = 0; i < n - 1; i++) {
    int u, v, c;
    cin >> u >> v >> c;
    g[u].push_back(pair<long long, long long>(v, c));
    g[v].push_back(pair<long long, long long>(u, c));
  }
  cin >> q;
  for (int i = 0; i < q; i++) {
    int u, v;
    cin >> u >> v;
    query[u].push_back(pair<long long, long long>(v, i));
  }
  dfs(1, 0, 0);
  build(1, 0, now);
  dfsans(1, 0);
  for (int i = 0; i < q; i++) cout << ans[i] << '\n';
}
