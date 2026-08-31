#include <bits/stdc++.h>
struct lx {
  int x, y;
} a[105];
bool cmp(lx a, lx b) { return a.y > b.y; }
inline int min(int a, int b) {
  a -= b;
  return b + (a & (a >> 31));
}
int n, m, v, sum, ans, f[105][10005];
inline int read() {
  int c = getchar(), t = 0;
  for (; c < 48 || c > 57; c = getchar())
    ;
  do {
    t = (t << 1) + (t << 3) + c - 48;
    c = getchar();
  } while (48 <= c && c <= 57);
  return t;
}
int main() {
  n = read();
  memset(f, 127, sizeof f);
  for (int i = 1; i <= n; ++i) sum += a[i].x = read();
  for (int i = 1; i <= n; ++i) a[i].y = read();
  std::sort(a + 1, a + n + 1, cmp);
  ans = f[0][0] = sum;
  for (int i = 1; i <= n && v < sum; ++i) v += a[i].y, ++m;
  for (int i = 1; i <= n; ++i)
    for (int j = min(i, m); j; --j)
      for (int k = a[i].y; k <= v; ++k)
        f[j][k] = min(f[j][k], f[j - 1][k - a[i].y] - a[i].x);
  for (int i = sum; i <= v; ++i) ans = min(ans, f[m][i]);
  printf("%d %d", m, ans);
}
