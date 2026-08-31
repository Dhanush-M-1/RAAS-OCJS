#include <bits/stdc++.h>
int main() {
  bool f = false;
  int r1, r2, c1, c2, d1, d2, a, b, c, d;
  scanf("%d%d%d%d%d%d", &r1, &r2, &c1, &c2, &d1, &d2);
  for (a = 1; a < 10; ++a) {
    for (b = 1; b < 10; ++b) {
      if (a == b) continue;
      for (c = 1; c < 10; ++c) {
        if (a == c || b == c) continue;
        for (d = 1; d < 10; ++d) {
          if (a == d || b == d || c == d) continue;
          if (a + b == r1 && c + d == r2 && a + c == c1 && b + d == c2 &&
              a + d == d1 && b + c == d2) {
            f = true;
            printf("%d %d\n%d %d\n", a, b, c, d);
          }
        }
      }
    }
  }
  if (!f) puts("-1");
  return 0;
}
