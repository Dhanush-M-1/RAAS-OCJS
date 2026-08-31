#include <bits/stdc++.h>
using namespace std;
const int N = 10005;
int main() {
  int n, a, b, c, d, t, mi, ma;
  int i, j, k, x, y, z;
  long ans;
  while (scanf("%d%d%d%d", &n, &a, &b, &c) != EOF) {
    ans = 0;
    a = a / 2;
    c = c * 2;
    mi = n - a - b;
    if (mi < 0) mi = 0;
    if (mi % 2 != 0) mi = mi / 2 * 2 + 2;
    ma = min(n, c);
    for (i = mi; i <= ma; i += 2) {
      t = n - i;
      x = t - b;
      if (x < 0) x = 0;
      y = min(t, a);
      ans += y - x + 1;
    }
    printf("%ld\n", ans);
  }
  return 0;
}
