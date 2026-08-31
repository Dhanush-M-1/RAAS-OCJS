#include <bits/stdc++.h>
using namespace std;
template <class T>
inline T bigmod(T b, T p, T M) {
  long long ret = 1;
  for (; p > 0; p >>= 1) {
    if (p & 1) ret = (ret * b) % M;
    b = (b * b) % M;
  }
  return (T)ret;
}
int dx4[] = {-1, 0, 1, 0};
int dy4[] = {0, 1, 0, -1};
int dx8[] = {0, 0, 1, 1, 1, -1, -1, -1};
int dy8[] = {1, -1, -1, 0, 1, -1, 0, 1};
int kx8[] = {1, 1, 2, 2, -1, -1, -2, -2};
int ky8[] = {2, -2, 1, -1, 2, -2, 1, -1};
const double PI = acos(-1.0), EPS = 1e-7;
const long long INF = (long long)1e18 + 7;
const int N = 2e5 + 5, M = 1e9 + 7;
int n, k, a, b, q;
int seg[2][4 * N];
void update(int c, int s, int e, int p, int v) {
  if (s == e) {
    seg[0][c] = min(b, seg[0][c] + v);
    seg[1][c] = min(a, seg[1][c] + v);
    return;
  }
  int m = (s + e) / 2;
  if (p <= m)
    update(2 * c + 1, s, m, p, v);
  else
    update(2 * c + 2, m + 1, e, p, v);
  seg[0][c] = seg[0][2 * c + 1] + seg[0][2 * c + 2];
  seg[1][c] = seg[1][2 * c + 1] + seg[1][2 * c + 2];
}
int query(int id, int c, int s, int e, int qs, int qe) {
  if (qe < qs) return 0;
  if (s == qs && e == qe) return seg[id][c];
  int m = (s + e) / 2;
  if (qe <= m)
    return query(id, 2 * c + 1, s, m, qs, qe);
  else if (qs > m)
    return query(id, 2 * c + 2, m + 1, e, qs, qe);
  else {
    int x = query(id, 2 * c + 1, s, m, qs, m);
    int y = query(id, 2 * c + 2, m + 1, e, m + 1, qe);
    return x + y;
  }
}
int main() {
  cin >> n >> k >> a >> b >> q;
  for (int i = 0; i < q; i++) {
    int d, x, y;
    scanf("%d %d", &d, &x);
    if (d == 1) {
      scanf("%d", &y);
      update(0, 0, n - 1, x - 1, y);
    } else {
      int ans = query(0, 0, 0, n - 1, 0, x - 2);
      ans += query(1, 0, 0, n - 1, x + k - 1, n - 1);
      printf("%d\n", ans);
    }
  }
  return 0;
}
