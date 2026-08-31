#include <bits/stdc++.h>
using namespace std;
template <typename C>
class fenwick {
  vector<C> t;
  int n;

 public:
  fenwick(int _n) : n(_n) { t.resize(n); }
  fenwick(const vector<C>& a) : n(a.size()) {
    t.resize(n);
    for (int i = 0; i < n; ++i) {
      upd(i, a[i]);
    }
  }
  C get(int k) {
    C res = 0;
    for (k; k >= 0; k = (k & (k + 1)) - 1) {
      res += t[k];
    }
    return res;
  }
  void upd(int k, C x) {
    for (k; k < n; k |= k + 1) {
      t[k] += x;
    }
  }
  C get(int l, int r) { return get(r) - get(l - 1); }
};
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0), cout.tie(0);
  int n;
  cin >> n;
  vector<int> x(n), v(n);
  for (int i = 0; i < n; ++i) {
    cin >> x[i];
  }
  map<int, int> mapchik;
  for (int i = 0; i < n; ++i) {
    cin >> v[i];
    mapchik[v[i]] = 1;
  }
  int sz = 0;
  for (auto& [a, b] : mapchik) {
    b = sz++;
  }
  for (int i = 0; i < n; ++i) {
    v[i] = mapchik[v[i]];
  }
  vector<int> ord(n);
  iota(ord.begin(), ord.end(), 0);
  sort(ord.begin(), ord.end(), [&](int i, int j) { return x[i] < x[j]; });
  long long ans = 0;
  fenwick<int> cnt(sz);
  fenwick<long long> sum(sz);
  for (int i : ord) {
    ans += 1ll * cnt.get(0, v[i]) * x[i] - sum.get(0, v[i]);
    cnt.upd(v[i], 1);
    sum.upd(v[i], x[i]);
  }
  cout << ans;
  return 0;
}
