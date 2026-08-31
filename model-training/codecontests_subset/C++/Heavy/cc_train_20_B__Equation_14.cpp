#include <bits/stdc++.h>
int Delta(long a, long b, long c) {
  double delta;
  delta = (double)(b * b - 4 * a * c);
  if (delta > 0)
    return 2;
  else if (delta < 0)
    return 0;
  else
    return 1;
}
int main() {
  long a, b, c;
  double x1 = 0, x2 = 0, d, k, n = 0;
  scanf("%d%d%d", &a, &b, &c);
  d = (double)b * b - 4 * a * c;
  k = sqrt(d);
  x1 = (double)(-b - k) / (2 * a);
  x2 = (double)(-b + k) / (2 * a);
  if (Delta(a, b, c) == 2) {
    if (a != 0) {
      printf("%d\n", 2);
      if (x1 < x2) {
        printf("%.10f\n", (double)x1);
        printf("%.10f\n", (double)x2);
      } else {
        printf("%.10f\n", (double)x2);
        printf("%.10f\n", (double)x1);
      }
    } else if (a == 0) {
      printf("%d\n", 1);
      printf("%.10f\n", (double)-c / b);
    }
  } else if (Delta(a, b, c) == 1) {
    if (a != 0 && b != 0 && c != 0) {
      printf("%d\n", 1);
      printf("%.10f\n", (double)-b / (2 * a));
    } else if (a == 0 && b == 0 && c == 0)
      printf("%d\n", -1);
    else if (a != 0 && b == 0 && c == 0) {
      printf("%d\n", 1);
      printf("%.10f\n", 0);
    } else
      printf("%d\n", 0);
  } else
    printf("%d\n", 0);
  return 0;
}
