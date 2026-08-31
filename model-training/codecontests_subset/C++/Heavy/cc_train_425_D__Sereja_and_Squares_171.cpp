#include <bits/stdc++.h>
#pragma GCC optimize("O3")
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
                     long long _mod = 1000000007LL) {
  _x += _y;
  return _x >= _mod ? _x - _mod : _x;
}
inline long long sub(long long _x, long long _y,
                     long long _mod = 1000000007LL) {
  _x -= _y;
  return _x < 0 ? _x + _mod : _x;
}
inline long long mul(long long _x, long long _y,
                     long long _mod = 1000000007LL) {
  _x *= _y;
  return _x >= _mod ? _x % _mod : _x;
}
long long mypow(long long _a, long long _x, long long _mod) {
  if (_x == 0) return 1LL;
  long long _ret = mypow(mul(_a, _a, _mod), _x >> 1, _mod);
  if (_x & 1) _ret = mul(_ret, _a, _mod);
  return _ret;
}
long long mymul(long long _a, long long _x, long long _mod) {
  if (_x == 0) return 0LL;
  long long _ret = mymul(add(_a, _a, _mod), _x >> 1, _mod);
  if (_x & 1) _ret = add(_ret, _a, _mod);
  return _ret;
}
inline bool equal(double _x, double _y) {
  return _x > _y - 1e-9 && _x < _y + 1e-9;
}
void sleep(double sec = 1021) {
  clock_t s = clock();
  while (clock() - s < CLOCKS_PER_SEC * sec)
    ;
}
int __ = 1, _cs;
void build() {}
int n;
vector<int> vx[100001], vy[100001];
void init() {
  n = getint();
  for (int i = 0, x, y; i < n; i++) {
    x = getint();
    y = getint();
    vx[x].push_back(y);
    vy[y].push_back(x);
  }
  for (int i = 0; i < 100001; i++) {
    sort(vx[i].begin(), vx[i].end());
    sort(vy[i].begin(), vy[i].end());
  }
}
int ans;
vector<int> cand[100001];
void solve() {
  for (int x = 0; x < 100001; x++)
    for (int y : vx[x]) {
      size_t xptr = upper_bound(vx[x].begin(), vx[x].end(), y) - vx[x].begin();
      size_t yptr = upper_bound(vy[y].begin(), vy[y].end(), x) - vy[y].begin();
      while (xptr < vx[x].size() and yptr < vy[y].size()) {
        if (vx[x][xptr] - y == vy[y][yptr] - x) {
          if (not vx[vy[y][yptr]].empty())
            cand[vy[y][yptr]].push_back(vx[x][xptr]);
          xptr++;
          yptr++;
        } else if (vx[x][xptr] - y < vy[y][yptr] - x)
          xptr =
              lower_bound(vx[x].begin(), vx[x].end(), y + (vy[y][yptr] - x)) -
              vx[x].begin();
        else
          yptr =
              lower_bound(vy[y].begin(), vy[y].end(), x + (vx[x][xptr] - y)) -
              vy[y].begin();
      }
    }
  for (int x = 0; x < 100001; x++) {
    sort(cand[x].begin(), cand[x].end());
    size_t ptr = 0;
    for (int y : cand[x]) {
      while (ptr < vx[x].size() and vx[x][ptr] < y) ptr++;
      if (ptr == vx[x].size()) break;
      ans += (vx[x][ptr] == y);
    }
  }
  cout << ans << endl;
}
int main() {
  build();
  while (__--) {
    init();
    solve();
  }
}
