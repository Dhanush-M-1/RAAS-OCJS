#include <bits/stdc++.h>
using namespace std;
int main() {
  int i, j, k;
  double a, b, c, t, x1, x2;
  scanf("%lf%lf%lf", &a, &b, &c);
  t = b * b - a * c * 4;
  if (a == 0 && b == 0 && c == 0) {
    printf("-1\n");
    return 0;
  }
  if (a == 0) {
    if (b == 0) {
      printf("0\n");
      return 0;
    } else {
      b = c * (-1) / b;
      printf("1\n%.9lf\n", b);
      return 0;
    }
  }
  if (t < 0) {
    printf("0\n");
    return 0;
  }
  if (t == 0) {
    printf("1\n");
    x1 = b * (-1.0) / (a * 2.0);
    printf("%.9lf\n", x1);
  } else {
    printf("2\n");
    x1 = (b * (-1.0) - sqrt(t)) / (a * 2.0);
    x2 = (b * (-1.0) + sqrt(t)) / (a * 2.0);
    t = min(x1, x2);
    x2 = max(x1, x2);
    x1 = t;
    printf("%.9lf\n%.9lf\n", x1, x2);
  }
  return 0;
}
