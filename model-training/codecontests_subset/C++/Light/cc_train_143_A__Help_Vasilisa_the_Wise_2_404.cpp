#include <bits/stdc++.h>
int main(void) {
  int r1, r2, c1, c2, d1, d2;
  int a, b, c, d;
  scanf("%d%d%d%d%d%d", &r1, &r2, &c1, &c2, &d1, &d2);
  a = (r1 - c2 + d1) / 2;
  b = (c2 - r2 + d2) / 2;
  c = (c1 - r1 + d2) / 2;
  d = (c2 - r1 + d1) / 2;
  if (a + b != r1 || a + c != c1 || a + d != d1 || b + c != d2 || b + d != c2 ||
      c + d != r2 || a == b || a == c || a == d || b == c || b == d || c == d ||
      a < 1 || b < 1 || c < 1 || d < 1 || a > 9 || b > 9 || c > 9 || d > 9)
    printf("-1\n");
  else
    printf("%d %d\n%d %d\n", a, b, c, d);
  return 0;
}
