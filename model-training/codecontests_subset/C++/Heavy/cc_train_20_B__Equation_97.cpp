#include <bits/stdc++.h>
int main() {
  double a, b, c;
  int i, j, k, m, n;
  scanf("%lf%lf%lf", &a, &b, &c);
  if (a == 0) {
    if (b == 0) {
      if (c == 0)
        printf("-1\n");
      else
        printf("0\n");
    } else
      printf("1\n%0.10f\n", -c / b);
  } else {
    if (b * b - 4 * a * c < 0)
      printf("0\n");
    else if (b * b - 4 * a * c == 0)
      printf("1\n%0.10f\n", -b / (2 * a));
    else {
      printf("2\n");
      if ((-b - sqrt(b * b - 4 * a * c)) / (2 * a) <
          (-b + sqrt(b * b - 4 * a * c)) / (2 * a)) {
        printf("%.10lf\n", (-b - sqrt(b * b - 4 * a * c)) / (2 * a));
        printf("%.10lf\n", (-b + sqrt(b * b - 4 * a * c)) / (2 * a));
      } else {
        printf("%.10lf\n", (-b + sqrt(b * b - 4 * a * c)) / (2 * a));
        printf("%.10lf\n", (-b - sqrt(b * b - 4 * a * c)) / (2 * a));
      }
    }
  }
  return 0;
}
