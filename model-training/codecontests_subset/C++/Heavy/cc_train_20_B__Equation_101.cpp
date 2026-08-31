#include <bits/stdc++.h>
using namespace std;
long long a, b, c;
int main() {
  scanf("%lld%lld%lld", &a, &b, &c);
  if (a == 0 && b == 0 && c == 0)
    printf("-1\n");
  else if (a == 0 && b == 0 && c != 0)
    printf("0\n");
  else if (a == 0 && b != 0)
    printf("1\n%.10lf\n", -(double)(c) / b);
  else {
    int num = b * b - 4 * a * c;
    if (num < 0)
      printf("0\n");
    else if (num == 0) {
      printf("1\n");
      double ans = double(-b) / (2 * a);
      printf("%.10lf\n", ans);
    } else {
      printf("2\n");
      double s = sqrt(b * b - 4 * a * c);
      double x1 = double(-b + s) / (a * 2);
      double x2 = double(-b - s) / (a * 2);
      if (x1 > x2) swap(x1, x2);
      printf("%.10lf\n%.10lf\n", x1, x2);
    }
  }
  return 0;
}
