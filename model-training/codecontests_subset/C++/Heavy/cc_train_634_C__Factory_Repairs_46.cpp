#include <bits/stdc++.h>
using namespace std;
int n, k, q, ta, tb, tc;
long long x[19][100005 * 2], y[19][100005 * 2], oz, z[100005 * 2], ans, aa, bb;
long long f1(int a, int b, int c, int d) {
  if (((1 << (c)) * (d)) == a && ((1 << (c)) * (d + 1)) == b) return x[c][d];
  c--;
  d = d * 2 + 1;
  if (b <= ((1 << (c)) * (d))) return f1(a, b, c, d - 1);
  if (a >= ((1 << (c)) * (d))) return f1(a, b, c, d);
  return f1(a, ((1 << (c)) * (d)), c, d - 1) + f1(((1 << (c)) * (d)), b, c, d);
}
long long f2(int a, int b, int c, int d) {
  if (((1 << (c)) * (d)) == a && ((1 << (c)) * (d + 1)) == b) return y[c][d];
  c--;
  d = d * 2 + 1;
  if (b <= ((1 << (c)) * (d))) return f2(a, b, c, d - 1);
  if (a >= ((1 << (c)) * (d))) return f2(a, b, c, d);
  return f2(a, ((1 << (c)) * (d)), c, d - 1) + f2(((1 << (c)) * (d)), b, c, d);
}
int main() {
  scanf("%d%d%I64d%I64d%d", &n, &k, &aa, &bb, &q);
  while (q--) {
    scanf("%d%d", &ta, &tb);
    if (ta == 1) {
      scanf("%d", &ta);
      oz = z[--tb];
      z[tb] += ta;
      tc = tb;
      for (int a = 0; a < 19; a++) {
        x[a][tc] += min(bb, z[tb]) - min(bb, oz);
        y[a][tc] += min(aa, z[tb]) - min(aa, oz);
        tc >>= 1;
      }
    } else {
      ans = 0;
      tb--;
      if (tb) ans += f1(0, tb, 18, 0);
      if (tb + k < n) ans += f2(tb + k, n, 18, 0);
      printf("%I64d\n", ans);
    }
  }
}
