#include <bits/stdc++.h>
int main() {
  int n, p, q, r, b, c, s = 0, a, i, j, k;
  double u, m, w, l, t;
  scanf("%d %d %d %d", &n, &p, &q, &r);
  for (i = 0; i <= p; i++) {
    for (j = 0; j <= q; j++) {
      m = 0.5 * i + j;
      if (m == n) {
        s = s + 1;
      } else if (m > n) {
        break;
      } else {
        t = n - m;
        a = (int)t;
        if (t - a == 0) {
          if (a % 2 == 0 && (a / 2) <= r) {
            s = s + 1;
          }
        }
      }
    }
  }
  printf("%d", s);
  return 0;
}
