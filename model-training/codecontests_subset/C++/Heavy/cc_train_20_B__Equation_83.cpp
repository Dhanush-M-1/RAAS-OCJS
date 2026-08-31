#include <bits/stdc++.h>
using namespace std;
double sqrtt(double x) {
  if (x < 0)
    return -sqrt(-x);
  else
    return sqrt(x);
}
int main() {
  double a, b, c;
  double x1, x2;
  while (cin >> a >> b >> c) {
    if (a == 0 && b == 0) {
      if (c == 0)
        printf("-1\n");
      else
        printf("0\n");
    } else if (a == 0 && c == 0) {
      printf("1\n0\n");
    } else if (b == 0 && c == 0) {
      printf("1\n0\n");
    } else if (a == 0) {
      printf("1\n");
      printf("%.6lf\n", -c / b);
    } else {
      double tem = b * b - 4 * a * c;
      if (tem < 0)
        printf("0\n");
      else if (tem == 0) {
        printf("1\n");
        printf("%.6lf\n", (-b / (2 * a)));
      } else {
        printf("2\n");
        x1 = (-b - sqrtt(tem)) / (2 * a);
        x2 = (-b + sqrtt(tem)) / (2 * a);
        if (x1 > x2) swap(x1, x2);
        printf("%.6lf\n%.6f\n", x1, x2);
      }
    }
  }
  return 0;
}
