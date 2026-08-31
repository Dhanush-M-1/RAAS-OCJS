#include <bits/stdc++.h>
using namespace std;
int main() {
  double a, b, c;
  double x1, x2;
  cin >> a >> b >> c;
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
    printf("%.10lf\n", -c / b);
  } else {
    double tem = b * b - 4 * a * c;
    if (tem < 0)
      printf("0\n");
    else if (tem == 0) {
      printf("1\n");
      printf("%.6lf\n", (-b / (2 * a)));
    } else {
      printf("2\n");
      x1 = (-b + (sqrt(b * b - 4 * a * c))) / (2 * a);
      x2 = (-b - (sqrt(b * b - 4 * a * c))) / (2 * a);
      if (x1 < x2) {
        printf("%.10lf\n%.10lf\n", x1, x2);
      } else {
        printf("%.10lf\n%.10lf\n", x2, x1);
      }
    }
  }
  return 0;
}
