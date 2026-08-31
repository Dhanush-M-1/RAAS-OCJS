#include <bits/stdc++.h>
using namespace std;
int main() {
  double a, b, c;
  scanf("%lf%lf%lf", &a, &b, &c);
  if (a == 0 && b == 0 && c == 0)
    printf("-1\n");
  else if (a == 0 && b == 0 && c)
    printf("0\n");
  else if (a == 0)
    printf("1\n%.10lf\n", -c / b);
  else if (b == 0) {
    if (c < 0) printf("2\n%.10lf\n%.10lf\n", -sqrt(c / a), sqrt(c / a));
    if (c == 0)
      printf("1\n%.10lf\n", 0);
    else
      printf("0\n");
  } else {
    if (1ll * b * b - 4 * a * c < 0)
      printf("0\n");
    else {
      double x, y;
      x = (-b - sqrt(1ll * b * b - 4 * a * c)) / (2 * a);
      y = (-b + sqrt(1ll * b * b - 4 * a * c)) / (2 * a);
      if (y + 1e-9 < x)
        printf("2\n%.10lf\n%.10lf\n", y, x);
      else if (x + 1e-9 < y)
        printf("2\n%.10lf\n%.10lf\n", x, y);
      else
        printf("1\n%.10lf\n", x);
    }
  }
}
