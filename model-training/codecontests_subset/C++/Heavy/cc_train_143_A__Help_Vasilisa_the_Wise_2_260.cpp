#include <bits/stdc++.h>
int main() {
  int r1, r2, c1, c2, d1, d2, x;
  scanf("%d %d %d %d %d %d", &r1, &r2, &c1, &c2, &d1, &d2);
  if ((r1 + r2) == (c1 + c2) && (c1 + c2) == (d1 + d2) &&
      (r1 + r2) == (d1 + d2)) {
    x = (d1 + r1 - c2) / 2;
    if (x) {
      int a, b, c, d;
      a = x;
      b = r1 - x;
      c = c1 - x;
      d = c2 - r1 + x;
      if (a != b && b != c && c != d && a != d && b != d && c != a && a <= 9 &&
          b <= 9 && c <= 9 && d <= 9 && a >= 1 && b >= 1 && c >= 1 && d >= 1)
        printf("%d %d\n%d %d", a, b, c, d);
      else
        printf("-1\n");
    } else
      printf("-1\n");
  } else
    printf("-1\n");
  return 0;
}
