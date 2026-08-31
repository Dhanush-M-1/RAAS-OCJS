#include <bits/stdc++.h>
using namespace std;
int mx, mn, w, ans1, ans2, x, y, c;
map<double, int> m1, m2;
double qwq;
inline int f(int x) {
  int s = 0;
  while (x) {
    s = s * 10 + x % 10;
    x /= 10;
  }
  return s;
}
signed main() {
  scanf("%d%d%d", &mx, &mn, &w);
  x = mx;
  for (int i = 1; i <= mx; ++i) {
    qwq = 1.0 * i / f(i);
    ++m1[qwq];
  }
  while (x > 0 && y <= mn) {
    if (c < w && y < mn) {
      qwq = 1.0 * f(++y) / y;
      c += m1[qwq];
      ++m2[qwq];
    } else if (c >= w) {
      if (ans1 * ans2 > x * y || !ans1) ans1 = x, ans2 = y;
      qwq = 1.0 * x / f(x);
      c -= m2[qwq];
      --m1[qwq];
      --x;
    } else
      y = mn + 1;
  }
  if (ans1)
    printf("%d %d", ans1, ans2);
  else
    printf("-1");
  return 0;
}
