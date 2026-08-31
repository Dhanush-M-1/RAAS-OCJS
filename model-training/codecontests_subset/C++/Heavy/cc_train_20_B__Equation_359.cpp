#include <bits/stdc++.h>
using namespace std;
int main() {
  long long a, b, c;
  scanf("%lld%lld%lld", &a, &b, &c);
  if (a == 0 && b == 0 && c == 0)
    printf("%d", -1);
  else if (a == 0 && b == 0 && c != 0)
    printf("%d", 0);
  else if (a == 0 && b != 0)
    printf("1\n%.10lf", -double(c) / b);
  else {
    if (b * b - 4 * a * c < 0)
      printf("0");
    else if (b * b - 4 * a * c == 0) {
      printf("1\n");
      double x = double(-b) / 2 / a;
      printf("%.10lf", x);
    } else {
      printf("2\n");
      double x1 = double(-b + sqrt(b * b - 4 * a * c)) / 2 / a;
      double x2 = double(-b - sqrt(b * b - 4 * a * c)) / 2 / a;
      double t;
      if (x1 > x2) t = x1, x1 = x2, x2 = t;
      printf("%.10lf\n%.10lf", x1, x2);
    }
  }
  return 0;
}
