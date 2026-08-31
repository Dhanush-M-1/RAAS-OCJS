#include <bits/stdc++.h>
int main() {
  int r1, r2, d1, d2, c1, c2, a, b, c, d;
  scanf("%d %d %d %d %d %d", &r1, &r2, &c1, &c2, &d1, &d2);
  a = (c1 + d1 - r2) / 2;
  b = c1 - a;
  c = r1 - a;
  d = r2 - b;
  if (a != b && a != c && a != d && b != c && b != d && c != d && a && b && c &&
      d && a <= 9 && b <= 9 && c <= 9 && d <= 9)
    printf("%d %d\n%d %d", a, c, b, d);
  else
    printf("-1");
}
