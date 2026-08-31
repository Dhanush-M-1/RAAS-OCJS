#include <bits/stdc++.h>
using namespace std;
const long long INF = 1e18;
const int inf = 2e9;
const long double eps = 1e-7;
const long double pi = acos(-1);
const int dx[4] = {0, 0, 1, -1};
const int dy[4] = {1, -1, 0, 0};
const int N = 2e5 + 11;
const int M = 2750132;
const int mod = 1e9 + 7;
int c[N], t[3][4 * N];
void upd(int v, int tl, int tr, int pos, int val, int type) {
  if (tl == tr) {
    t[type][v] = val;
    return;
  }
  int tm = (tl + tr) / 2;
  if (pos <= tm)
    upd(v * 2, tl, tm, pos, val, type);
  else
    upd(v * 2 + 1, tm + 1, tr, pos, val, type);
  t[type][v] = t[type][v * 2] + t[type][v * 2 + 1];
}
int get(int v, int tl, int tr, int l, int r, int type) {
  if (tl > r || l > tr) return 0;
  if (l <= tl && tr <= r) return t[type][v];
  int tm = (tl + tr) / 2;
  return get(v * 2, tl, tm, l, r, type) +
         get(v * 2 + 1, tm + 1, tr, l, r, type);
}
int main() {
  int n, k, a, b, q;
  cin >> n >> k >> a >> b >> q;
  for (int i = 1; i <= q; i++) {
    int t, first, second;
    cin >> t >> first;
    if (t == 1) {
      cin >> second;
      c[first] += second;
      upd(1, 1, n, first, min(c[first], b), 1);
      upd(1, 1, n, first, min(c[first], a), 2);
    } else {
      cout << get(1, 1, n, 1, first - 1, 1) + get(1, 1, n, first + k, n, 2)
           << "\n";
    }
  }
}
