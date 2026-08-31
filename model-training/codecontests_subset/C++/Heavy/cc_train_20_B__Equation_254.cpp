#include <bits/stdc++.h>
using namespace std;
int main() {
  long long a, b, c;
  scanf("%lld%lld%lld", &a, &b, &c);
  if (a == 0 && b == 0 && c == 0)
    printf("-1\n");
  else if (a == 0 && b == 0)
    printf("0\n");
  else if (a == 0) {
    printf("1\n");
    printf("%.6lf\n", -1.0 * c / b);
  } else if (b * b > 4 * a * c) {
    printf("2\n");
    double x1 = 1.0 * (-b + sqrt(1.0 * (b * b - 4 * a * c))) / (2 * a);
    double x2 = 1.0 * (-b - sqrt(1.0 * (b * b - 4 * a * c))) / (2 * a);
    printf("%.6lf\n%.6lf", min(x1, x2), max(x1, x2));
  } else if (b * b == 4 * a * c) {
    printf("1\n");
    double x1 = 1.0 * (-b) / (2 * a);
    printf("%.6lf", x1);
  } else
    printf("0\n");
  return 0;
}
