#include <bits/stdc++.h>
using namespace std;
int main() {
  double a, b, c, det, x1, x2;
  while (scanf("%lf%lf%lf", &a, &b, &c) != EOF) {
    if (a == 0 && b == 0) {
      if (c == 0)
        puts("-1");
      else
        puts("0");
      continue;
    }
    if (a == 0) {
      x1 = -1.0 * c / b;
      if (x1 == -0.0) x1 = 0.0;
      printf("1\n%lf\n", x1);
      continue;
    }
    det = b * b - 4.0 * a * c;
    if (det < 0) {
      puts("0");
      continue;
    }
    if (det == 0) {
      x1 = -0.5 * b / a;
      printf("1\n%lf\n", x1);
      continue;
    }
    if (det > 0) {
      x1 = 0.5 * (-b + sqrt(det)) / a;
      x2 = 0.5 * (-b - sqrt(det)) / a;
      if (x1 > x2) swap(x1, x2);
      printf("2\n%lf\n%lf\n", x1, x2);
    }
  }
}
