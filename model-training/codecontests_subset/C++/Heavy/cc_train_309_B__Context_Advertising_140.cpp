#include <bits/stdc++.h>
using namespace std;
template <class T>
inline bool chmax(T& a, T b) {
  if (a < b) {
    a = b;
    return 1;
  }
  return 0;
}
struct Doubling {
  int sz, n;
  vector<vector<int>> table;
  Doubling(int n, long long ma = 1LL << 62) : sz(0), n(n) {
    while ((1LL << sz) <= ma) ++sz;
    table.assign(sz, vector<int>(n + 1, -1));
  }
  void set_next(int i, int x) { table[0][i] = x; }
  void build() {
    for (int k = 0; k < sz - 1; k++)
      for (int i = 0; i < n; i++) {
        if (~table[k][i]) table[k + 1][i] = table[k][table[k][i]];
      }
  }
  int query(int i, long long t) {
    for (int k = sz - 1; k >= 0; k--)
      if (~i) {
        if (t >> k & 1) i = table[k][i];
      }
    return i;
  }
  long long lower_bound(int s, int t) {
    long long ret = s != t;
    if (s > t) swap(s, t);
    for (int k = sz - 1; k >= 0; k--) {
      if (table[k][s] < t) ret += 1LL << k, s = table[k][s];
    }
    return ret;
  }
};
int main() {
  int n;
  cin >> n;
  int h, w;
  cin >> h >> w;
  w++;
  vector<string> s(n);
  for (auto& si : s) cin >> si;
  vector<int> acc(n + 1);
  for (int i = 0; i < n; i++) acc[i + 1] = acc[i] + (s[i].size() + 1);
  Doubling dbl(n, h);
  for (int left = 0, right = 0; left < n; left++) {
    while (right <= n && acc[right] - acc[left] <= w) right++;
    dbl.set_next(left, right - 1);
  }
  dbl.build();
  pair<int, int> ma{-1, 0};
  for (int i = 0; i < n; i++) chmax(ma, {dbl.query(i, h) - i + 1, i});
  int p = ma.second;
  while (h--) {
    int to = dbl.query(p, 1);
    while (p < to) cout << s[p] << " \n"[p == to - 1], p++;
  }
  return 0;
}
