#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int a, b, c;
  double x, s, x1, x2;
  long long int l;
  while (~scanf("%lld%lld%lld", &a, &b, &c)) {
    if (a == 0 && b == 0 && c == 0)
      printf("-1\n");
    else if (a == 0 && b == 0)
      printf("0\n");
    else if (b == 0 && c == 0)
      printf("1\n0\n");
    else if (a == 0 && c == 0)
      printf("1\n0\n");
    else if (a == 0) {
      x = -1.0 * c / b;
      printf("1\n%.10lf\n", x);
    } else if (b == 0) {
      s = -1.0 * c / a;
      if (s < 0)
        printf("0\n");
      else {
        x = sqrt(s);
        printf("2\n%.10lf\n%.10lf\n", -x, x);
      }
    } else if (c == 0) {
      x = -1.0 * b / a;
      if (x > 0)
        printf("2\n0\n%.10lf\n", x);
      else
        printf("2\n%.10lf\n0\n", x);
    } else {
      l = b * b - 4 * a * c;
      if (l < 0)
        printf("0\n");
      else if (l == 0)
        printf("1\n%.10lf\n", -1.0 * b / 2 / a);
      else {
        x1 = 1.0 * (-b - sqrt(l)) / 2 / a;
        x2 = 1.0 * (-b + sqrt(l)) / 2 / a;
        if (x2 - x1 > 1e-10)
          printf("2\n%.10lf\n%.10lf\n", x1, x2);
        else
          printf("2\n%.10lf\n%.10lf\n", x2, x1);
      }
    }
  }
  return 0;
}
