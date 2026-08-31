#include <bits/stdc++.h>
using namespace std;
inline long long getint() {
  long long _x = 0, _tmp = 1;
  char _tc = getchar();
  while ((_tc < '0' || _tc > '9') && _tc != '-') _tc = getchar();
  if (_tc == '-') _tc = getchar(), _tmp = -1;
  while (_tc >= '0' && _tc <= '9') _x *= 10, _x += (_tc - '0'), _tc = getchar();
  return _x * _tmp;
}
inline long long add(long long _x, long long _y,
                     long long _mod = 1000000007ll) {
  long long _ = _x + _y;
  if (_ >= _mod) _ -= _mod;
  return _;
}
inline long long sub(long long _x, long long _y,
                     long long _mod = 1000000007ll) {
  long long _ = _x - _y;
  if (_ < 0) _ += _mod;
  return _;
}
inline long long mul(long long _x, long long _y,
                     long long _mod = 1000000007ll) {
  long long _ = _x * _y;
  if (_ >= _mod) _ %= _mod;
  return _;
}
long long mypow(long long _a, long long _x, long long _mod) {
  if (_x == 0) return 1ll;
  long long _tmp = mypow(_a, _x / 2, _mod);
  _tmp = mul(_tmp, _tmp, _mod);
  if (_x & 1) _tmp = mul(_tmp, _a, _mod);
  return _tmp;
}
long long mymul(long long _a, long long _x, long long _mod) {
  if (_x == 0) return 0ll;
  long long _tmp = mymul(_a, _x / 2, _mod);
  _tmp = add(_tmp, _tmp, _mod);
  if (_x & 1) _tmp = add(_tmp, _a, _mod);
  return _tmp;
}
inline bool equal(double _x, double _y) {
  return _x > _y - 1e-9 && _x < _y + 1e-9;
}
int __ = 1, _cs;
void build() {}
int n, m, q, p[1021 * 2];
int find_p(int x) { return x == p[x] ? x : p[x] = find_p(p[x]); }
void Union(int x, int y) { p[find_p(x)] = find_p(y); }
vector<pair<pair<int, int>, pair<int, int> > > v;
void init() {
  n = getint();
  m = getint();
  q = getint();
  for (int i = 1; i <= m; i++) {
    int ui = getint();
    int vi = getint();
    int wi = getint();
    v.push_back({{wi, i}, {ui, vi}});
  }
  sort((v).begin(), (v).end());
  reverse((v).begin(), (v).end());
}
void solve() {
  while (q--) {
    int li = getint();
    int ri = getint();
    int ans = -1;
    for (int i = 1; i <= n + n; i++) p[i] = i;
    for (size_t i = 0; i < v.size(); i++) {
      if (v[i].first.second < li || v[i].first.second > ri) continue;
      int ui = v[i].second.first, vi = v[i].second.second;
      if (find_p(ui) == find_p(vi)) {
        ans = v[i].first.first;
        break;
      }
      Union(ui, vi + n);
      Union(vi, ui + n);
    }
    printf("%d\n", ans);
  }
}
int main() {
  build();
  while (__--) {
    init();
    solve();
  }
}
