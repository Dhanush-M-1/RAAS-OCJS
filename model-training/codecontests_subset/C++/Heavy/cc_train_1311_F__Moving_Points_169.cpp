#include <bits/stdc++.h>
using namespace std;
const int64_t INF = (int64_t)(2e18);
const int64_t inf = (int64_t)(1e9 + 7);
struct stree {
  vector<int64_t> t;
  int64_t n = 1;
  stree() {}
  stree(int64_t nn) {
    while (n < nn) n *= 2;
    t.assign(2 * n, 0);
  }
  void set(int64_t i, int64_t x) {
    t[i += n] += x;
    for (i /= 2; i; i /= 2) t[i] = t[i + i] + t[i + i + 1];
  }
  int64_t get(int64_t l, int64_t r) {
    int64_t res = 0;
    for (l += n, r += n; l <= r; l /= 2, r /= 2) {
      if (l & 1) res += t[l++];
      if (~r & 1) res += t[r--];
    }
    return res;
  }
};
int32_t main() {
  ios_base::sync_with_stdio(false);
  cout << fixed << setprecision(10);
  cin.tie(nullptr);
  int64_t n;
  cin >> n;
  vector<int64_t> x(n);
  for (auto& it : x) cin >> it;
  vector<int64_t> v(n);
  for (auto& it : v) cin >> it;
  vector<int64_t> vs;
  for (auto& it : v) vs.push_back(it);
  sort((vs).begin(), (vs).end());
  vs.resize(unique((vs).begin(), (vs).end()) - begin(vs));
  for (auto& it : v) it = lower_bound((vs).begin(), (vs).end(), it) - begin(vs);
  vector<pair<int64_t, int64_t>> pts(n);
  for (int64_t i = 0; i < n; ++i) {
    pts[i].first = x[i];
    pts[i].second = v[i];
  }
  sort((pts).begin(), (pts).end());
  stree ls(vs.size());
  stree lc(vs.size());
  stree rs(vs.size());
  stree rc(vs.size());
  for (auto& p : pts) {
    rs.set(p.second, p.first);
    rc.set(p.second, 1);
  }
  int64_t res = 0;
  for (auto& p : pts) {
    rs.set(p.second, -p.first);
    rc.set(p.second, -1);
    res += lc.get(0, p.second) * p.first;
    res -= ls.get(0, p.second);
    res -= rc.get(p.second, vs.size() - 1) * p.first;
    res += rs.get(p.second, vs.size() - 1);
    ls.set(p.second, p.first);
    lc.set(p.second, 1);
  }
  cout << res / 2;
  return 0;
}
