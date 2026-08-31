#include <bits/stdc++.h>
const double eps = 1e-6;
int main() {
  double a, b, c;
  while (std::cin >> a >> b >> c) {
    if (fabs(a) < eps) {
      if (fabs(b) < eps) {
        if (fabs(c) > eps) {
          puts("0");
        } else {
          puts("-1");
        }
      } else {
        double ans = -c / b;
        puts("1");
        printf("%.6lf\n", ans);
      }
    } else {
      double delta = b * b - 4 * a * c;
      if (delta < 0) {
        puts("0");
      } else if (fabs(delta) == 0) {
        double ans = -b / (2 * a);
        puts("1");
        printf("%.6lf\n", ans);
      } else {
        double ans1 = (-b - sqrt(delta)) / (2 * a);
        double ans2 = (-b + sqrt(delta)) / (2 * a);
        if (ans1 > ans2) {
          std::swap(ans1, ans2);
        }
        puts("2");
        printf("%.6lf %.6lf\n", ans1, ans2);
      }
    }
  }
  return 0;
}
