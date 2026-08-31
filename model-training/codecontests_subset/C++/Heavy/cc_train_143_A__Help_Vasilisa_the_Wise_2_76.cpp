#include <bits/stdc++.h>
int main() {
  int r1, r2, c1, c2, d1, d2, x1, x2, y1, y2, flag = 0;
  scanf("%d %d %d %d %d %d", &r1, &r2, &c1, &c2, &d1, &d2);
  for (x1 = 1; x1 <= 9; ++x1)
    for (x2 = 1; x2 <= 9; ++x2)
      for (y1 = 1; y1 <= 9; ++y1)
        for (y2 = 1; y2 <= 9; ++y2) {
          if (x1 + x2 == c1 && x2 + y2 == r2 && x1 + y1 == r1 &&
              y1 + y2 == c2 && x1 + y2 == d1 && y1 + x2 == d2 && x1 != y1 &&
              y1 != x2 && x2 != y2 && x1 != x2 && x1 != y2 && y1 != y2) {
            flag = 1;
            printf("%d %d\n%d %d\n", x1, y1, x2, y2);
            break;
          }
        }
  if (!flag) puts("-1");
  return 0;
}
