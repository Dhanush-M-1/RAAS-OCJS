#include <bits/stdc++.h>
int main() {
  int r1, r2, c1, c2, d1, d2, x1, x2, x3, x4;
  scanf("%d %d", &r1, &r2);
  scanf("%d %d", &c1, &c2);
  scanf("%d %d", &d1, &d2);
  x1 = r1 + c1 - d2;
  x2 = r1 + c2 - d1;
  x3 = r2 + c1 - d1;
  x4 = r2 + c2 - d2;
  if (x1 % 2 != 0)
    printf("-1");
  else if (x2 % 2 != 0)
    printf("-1");
  else if (x3 % 2 != 0)
    printf("-1");
  else if (x4 % 2 != 0)
    printf("-1");
  else if (x1 == x2)
    printf("-1");
  else if (x1 == x3)
    printf("-1");
  else if (x1 == x4)
    printf("-1");
  else if (x3 == x2)
    printf("-1");
  else if (x4 == x2)
    printf("-1");
  else if (x4 == x3)
    printf("-1");
  else if (((x1 < 1) || (x1 > 18)) || ((x2 < 1) || (x2 > 18)) ||
           ((x3 < 1) || (x3 > 18)) || ((x4 < 1) || (x4 > 18)))
    printf("-1");
  else {
    printf("%d %d\n", x1 / 2, x2 / 2);
    printf("%d %d\n", x3 / 2, x4 / 2);
  }
}
