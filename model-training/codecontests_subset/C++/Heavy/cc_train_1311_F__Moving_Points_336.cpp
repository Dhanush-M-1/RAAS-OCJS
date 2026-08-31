#include <bits/stdc++.h>
using namespace std;
template <typename Monoid>
struct SegmentTree {
  typedef function<Monoid(Monoid, Monoid)> F;
  int n;
  F f;
  Monoid id;
  vector<Monoid> dat;
  SegmentTree(int n_, F f, Monoid id) : f(f), id(id) { init(n_); }
  void init(int n_) {
    n = 1;
    while (n < n_) n <<= 1;
    dat.assign(n << 1, id);
  }
  void build(const vector<Monoid> &v) {
    for (int i = 0; i < v.size(); ++i) dat[i + n] = v[i];
    for (int i = n - 1; i; --i) dat[i] = f(dat[i << 1 | 0], dat[i << 1 | 1]);
  }
  void update(int k, Monoid x) {
    dat[k += n] = x;
    while (k >>= 1) dat[k] = f(dat[k << 1 | 0], dat[k << 1 | 1]);
  }
  Monoid query(int a, int b) {
    if (a >= b) return id;
    Monoid vl = id, vr = id;
    for (int l = a + n, r = b + n; l < r; l >>= 1, r >>= 1) {
      if (l & 1) vl = f(vl, dat[l++]);
      if (r & 1) vr = f(dat[--r], vr);
    }
    return f(vl, vr);
  }
  Monoid operator[](int i) { return dat[i + n]; }
};
int main() {
  cin.tie(0);
  ios::sync_with_stdio(false);
  int n;
  cin >> n;
  vector<long long> x(n), v(n);
  for (int i = 0; i < n; ++i) cin >> x[i];
  for (int i = 0; i < n; ++i) cin >> v[i];
  vector<vector<pair<long long, long long>>> ps(2);
  for (int i = 0; i < n; ++i) {
    if (0 <= v[i])
      ps[0].emplace_back(v[i], x[i]);
    else
      ps[1].emplace_back(-v[i], -x[i]);
  }
  vector<long long> vs;
  vector<pair<long long, int>> xs;
  auto f = [](pair<long long, int> a, pair<long long, int> b) {
    return pair<long long, int>{a.first + b.first, a.second + b.second};
  };
  SegmentTree<pair<long long, int>> seg(n, f, {0, 0});
  vector<pair<long long, int>> initializer(n, {0, 0});
  long long ans = 0;
  for (int i = 1; i >= 0; --i) {
    sort(ps[i].begin(), ps[i].end());
    int m = ps[i].size();
    vs.clear();
    xs.clear();
    for (int j = 0; j < m; ++j) {
      vs.emplace_back(ps[i][j].first);
      xs.emplace_back(ps[i][j].second, j);
    }
    if (!i) seg.build(initializer);
    sort(xs.begin(), xs.end());
    for (int j = 0; j < m; ++j) seg.update(xs[j].second, {xs[j].first, 1});
    for (int j = 0; j < m; ++j) {
      int s = lower_bound(vs.begin(), vs.end(), ps[i][xs[j].second].first) -
              vs.begin();
      auto p = seg.query(s, m);
      ans += p.first - xs[j].first * p.second;
      seg.update(xs[j].second, {0, 0});
    }
  }
  int t = ps[0].size();
  vector<long long> sum(t + 1, 0);
  for (int i = 0; i < t; ++i) {
    sum[i + 1] = sum[i] + xs[i].first;
    vs[i] = xs[i].first;
  }
  for (int i = 0; i < ps[1].size(); ++i) {
    int b = upper_bound(vs.begin(), vs.end(), -ps[1][i].second) - vs.begin();
    ans += sum[t] - sum[b] + ps[1][i].second * (t - b);
  }
  cout << ans << '\n';
}
