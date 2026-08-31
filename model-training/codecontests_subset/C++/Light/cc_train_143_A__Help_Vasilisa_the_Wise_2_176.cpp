#include <bits/stdc++.h>
int main() {
  int r1, r2, c1, c2, d1, d2;
  scanf("%d %d\n", &r1, &r2);
  scanf("%d %d\n", &c1, &c2);
  scanf("%d %d", &d1, &d2);
  int a, b, c, d;
  b = (r1 - c1 + d2) / 2;
  c = d2 - b;
  a = c1 - c;
  d = c2 - b;
  if (a != b && b != c && c != d && d != a && a != c && b != d && a > 0 &&
      a < 10 && b < 10 && b > 0 && c < 10 && c > 0 && d < 10 && d > 0) {
    if (a + b == r1 && c + d == r2 && a + c == c1 && b + d == c2 &&
        a + d == d1 && b + c == d2)
      printf("%d %d\n%d %d", a, b, c, d);
    else
      printf("-1");
  } else
    printf("-1");
}
