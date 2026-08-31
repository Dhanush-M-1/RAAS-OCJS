#include <bits/stdc++.h>
using namespace std;
int a, b, c;
int main() {
  while (cin >> a >> b >> c) {
    if (a == 0) {
      if (b == 0) {
        if (c == 0)
          puts("-1");
        else
          puts("0");
      } else {
        double ans = -(double)c / (double)b;
        printf("1\n%.5lf\n", ans);
      }
    } else {
      double det = (double)b * (double)b * 1.0 - 4.0 * (double)a * (double)c;
      if (det < 0)
        puts("0");
      else if (det == 0) {
        double ans = -1.0 * b / (double)(2.0 * a);
        printf("1\n%.5lf\n", ans);
      } else {
        double x1, x2;
        x1 = -1.0 * b + sqrt(det);
        x2 = -1.0 * b - sqrt(det);
        x1 = x1 / (2.0 * a);
        x2 = x2 / (2.0 * a);
        if (x1 > x2) swap(x1, x2);
        printf("2\n%.5lf\n%.5lf\n", x1, x2);
      }
    }
  }
  return 0;
}
