#include <bits/stdc++.h>
int main() {
  long long w, x, y, z;
  double a, b;
  scanf("%lld %lld %lld", &w, &x, &y);
  if (w) {
    z = x * x - (4 * w * y);
    if (z > 0) {
      a = (-x - sqrt(z)) / (2 * w);
      b = (-x + sqrt(z)) / (2 * w);
      if (w > 0)
        printf("2\n%lf\n%lf\n", a, b);
      else
        printf("2\n%lf\n%lf\n", b, a);
    } else if (z == 0) {
      printf("1\n%lf\n", -1. * x / 2 / w);
    } else
      printf("0\n");
  } else if (x)
    printf("1\n%lf\n", -1. * y / x);
  else if (y)
    printf("0\n");
  else
    printf("-1\n");
  return 0;
}
