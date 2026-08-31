#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using ld = long double;
using ii = pair<ll, ll>;
using vi = vector<ll>;
using vb = vector<bool>;
using vvi = vector<vi>;
using vii = vector<ii>;
using vvii = vector<vii>;
const int INF = 2000000000;
const ll LLINF = 9000000000000000000;
constexpr size_t NMAX = 1000;
constexpr size_t MMAX = 1000000;
constexpr size_t TMAX = 2000000;
template <class T>
struct res_vector {
  vector<T> v, d;
  int time = 0;
  vi t;
  res_vector(int n, T _d) {
    v.assign(n, _d);
    d.assign(n, _d);
    t.assign(n, 0);
  }
  T get(int i) { return t[i] == time ? v[i] : d[i]; }
  void set(int i, T _v) {
    t[i] = time;
    v[i] = _v;
  }
  void setdef(int i, T _v) { d[i] = _v; }
  void reset() { ++time; }
};
struct UnionFind {
  bool consistent = true;
  int n, c;
  res_vector<int> par, rank, size;
  res_vector<bool> sign;
  UnionFind(int _n)
      : n(_n), c(n), par(n, 0), rank(n, 0), size(n, 1), sign(n, false) {
    for (int i = 0; i < n; ++i) par.set(i, i), par.setdef(i, i);
  }
  int find(int i) {
    if (par.get(i) == i) return i;
    int p = find(par.get(i));
    if (par.get(i) != p && sign.get(par.get(i))) {
      sign.set(i, !sign.get(i));
    }
    par.set(i, p);
    return p;
  }
  bool same(int i, int j) { return find(i) == find(j); }
  bool sign_of(int u, int pu) {
    bool su = sign.get(u);
    if (u != pu && sign.get(pu)) su = !su;
    return su;
  }
  void reset() {
    par.reset();
    rank.reset();
    size.reset();
    sign.reset();
    c = n;
  }
  void merge(int i, int j, bool diff = true) {
    int pi = find(i), pj = find(j);
    if (pi == pj) {
      bool si = sign_of(i, pi), sj = sign_of(j, pj);
      if (si == sj && diff) consistent = false;
      if (si != sj && !diff) consistent = false;
    }
    c--;
    if (rank.get(pi) > rank.get(pj)) swap(i, j), swap(pi, pj);
    bool si = sign_of(i, pi), sj = sign_of(j, pj);
    if ((si == sj && diff) || (si != sj && !diff)) {
      sign.set(pi, !sign.get(pi));
    }
    par.set(pi, pj);
    size.set(pj, size.get(pj) + size.get(pi));
    if (rank.get(pi) == rank.get(pj)) rank.set(pj, rank.get(pj) + 1);
  }
};
int n, m, q;
vector<pair<ii, ll>> E;
constexpr int SZ = 1e6;
vb sign;
UnionFind uf(NMAX);
vector<pair<ll, vi>> ans(SZ, {-2LL, vi()});
map<ii, int> cache;
void combine_into(pair<ll, vi> &lv, pair<ll, vi> &rv, pair<ll, vi> &o) {
  uf.reset();
  size_t lx = 0, rx = 0;
  while (lx < lv.second.size() || rx < rv.second.size()) {
    int i = (lx < lv.second.size() ? lv.second[lx] : rv.second[rx]);
    if (rx < rv.second.size() && E[i].second <= E[rv.second[rx]].second) {
      i = rv.second[rx];
      ++rx;
    } else
      ++lx;
    int u = E[i].first.first, v = E[i].first.second;
    int pu = uf.find(u), pv = uf.find(v);
    if (pu == pv && uf.sign_of(u, pu) != uf.sign_of(v, pv)) continue;
    o.second.push_back(i);
    if (pu != pv)
      uf.merge(u, v);
    else {
      o.first = E[i].second;
      break;
    }
  }
}
void ptup(pair<ll, vi> &v) {
  cerr << "{" << v.first << ",";
  for (ll w : v.second)
    cerr << " ((" << E[w].first.first << "," << E[w].first.second << "),"
         << E[w].second << ")";
  cerr << "}";
}
int solve(int l, int r) {
  auto it = cache.find({l, r});
  if (it != cache.end()) return it->second;
  cache.insert({{l, r}, cache.size()});
  int id = cache.size() - 1;
  ans[id].first = -1LL;
  int lid = solve(l, (l + r) / 2), rid = solve((l + r) / 2 + 1, r);
  combine_into(ans[lid], ans[rid], ans[id]);
  return id;
}
void accumulate(int l, int r, int L, int R, vi &res) {
  if (r < L || R < l) return;
  if (l <= L && R <= r)
    res.push_back(solve(L, R));
  else {
    accumulate(l, r, L, (L + R) / 2, res);
    accumulate(l, r, (L + R) / 2 + 1, R, res);
  }
}
ll query(int l, int r) {
  vi res;
  accumulate(l, r, 0, m - 1, res);
  vector<pair<ll, vi>> resa(2, {-1LL, vi()});
  for (size_t i = 0; i < res.size(); ++i) {
    resa[i & 1].second.clear();
    combine_into(resa[(i & 1) ^ 1], ans[res[i]], resa[i & 1]);
  }
  return resa[(1 & res.size()) ^ 1].first;
}
int main() {
  scanf("%d %d %d", &n, &m, &q);
  E.assign(m, {{-1, -1}, 0LL});
  for (int i = 0; i < m; ++i) {
    int u, v, w;
    scanf("%d %d %d", &u, &v, &w);
    E[i] = {{u - 1, v - 1}, ll(w)};
    ans[cache.size()] = {-1LL, vi{i}};
    cache.insert({{i, i}, cache.size()});
  }
  while (q--) {
    int l, r;
    scanf("%d %d", &l, &r);
    cout << query(l - 1, r - 1) << '\n';
  }
  return 0;
}
