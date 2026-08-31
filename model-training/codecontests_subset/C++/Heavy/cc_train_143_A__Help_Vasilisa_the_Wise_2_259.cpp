#include <bits/stdc++.h>
int main() {
  int x1, x2, x3, x4, r1, r2, c1, c2, d1, d2;
  scanf("%d%d%d%d%d%d", &r1, &r2, &c1, &c2, &d1, &d2);
  x1 = (r1 + c1 - d2) / 2;
  x2 = r1 - x1;
  x3 = (c1 + d2 - r1) / 2;
  x4 = r2 - x3;
  if ((x1 >= 1 && x1 <= 9) && (x2 >= 1 && x2 <= 9) && (x3 >= 1 && x3 <= 9) &&
      (x4 >= 1 && x4 <= 9)) {
    if (x1 != x2 && x3 != x4 && x1 != x3 && x1 != x4 && x2 != x3 && x2 != x4) {
      if ((x1 + x2 == r1) && (x3 + x4 == r2) && (x1 + x3 == c1) &&
          (x2 + x4 == c2) && (x1 + x4 == d1) && (x2 + x3 == d2))
        printf("%d %d\n%d %d\n", x1, x2, x3, x4);
      else
        printf("-1\n");
    } else
      printf("-1\n");
  } else
    printf("-1\n");
  return 0;
}
