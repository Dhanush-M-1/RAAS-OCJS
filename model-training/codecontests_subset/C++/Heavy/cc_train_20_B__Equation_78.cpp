#include <bits/stdc++.h>
using namespace std;
double a, b, c, x1, x2;
int main() {
  int i, j, k, m, n, ans, len;
  while (scanf("%lf%lf%lf", &a, &b, &c) != EOF) {
    if (fabs(a) < 1e-8) {
      if (fabs(b) < 1e-8) {
        if (fabs(c) < 1e-8)
          printf("-1\n");
        else
          printf("0\n");
      } else {
        if (fabs(c) < 1e-8)
          printf("1\n0.000000000000\n");
        else
          printf("1\n%.10f\n", -c / b);
      }
    } else {
      double det = b * b - 4 * a * c;
      if (fabs(det) < 1e-8) {
        double x = (-b + sqrt(det)) / 2 / a;
        if (fabs(x) < 1e-8)
          printf("1\n%.10f\n", fabs(x));
        else
          printf("1\n%.10f\n", x);
      } else if (det < 0)
        printf("0\n");
      else {
        x1 = (-b + sqrt(det)) / 2 / a;
        x2 = (-b - sqrt(det)) / 2 / a;
        if (fabs(x1) < 1e-8) x1 = 0;
        if (fabs(x2) < 1e-8) x2 = 0;
        if (fabs(x1 - x2) < 1e-8) {
          printf("1\n%.10f\n", x1);
        } else {
          printf("2\n");
          if (x1 < x2)
            printf("%.10f\n%.10f\n", x1, x2);
          else
            printf("%.10f\n%.10f\n", x2, x1);
        }
      }
    }
  }
  return 0;
}
