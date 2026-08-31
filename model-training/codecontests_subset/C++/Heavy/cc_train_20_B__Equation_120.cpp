#include <bits/stdc++.h>
using namespace std;
const int INF = 0x3f3f3f3f;
const int MOD = 1e6 + 10;
int main() {
  double a, b, c;
  while (~scanf("%lf%lf%lf", &a, &b, &c)) {
    if (a == b && b == c && c == 0) {
      printf("-1\n");
      continue;
    }
    double x = b * b - a * 4 * c;
    if (((a == 0 && b == 0) && c != 0) || x < 0) {
      printf("0\n");
      continue;
    }
    if (x == 0) {
      double xx = -b / (2.0 * a);
      printf("1\n%.5f\n", xx);
      continue;
    }
    if (a == 0) {
      double xx = -c / b;
      printf("1\n%.5f\n", xx);
      continue;
    }
    double x1 = (-b + sqrt(x)) / (2.0 * a);
    double x2 = (-b - sqrt(x)) / (2.0 * a);
    if (x1 > x2) swap(x1, x2);
    if (x1 == x2)
      printf("1\n%.5f\n", x1);
    else
      printf("2\n%.5f\n%.5f\n", x1, x2);
  }
  return 0;
}
