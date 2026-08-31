#include <bits/stdc++.h>
using namespace std;
int main() {
  double a, b, c, x, y, r1, r2, m, n;
  cin >> a >> b >> c;
  if (a == 0) {
    if (b == 0) {
      if (c == 0)
        printf("-1");
      else
        printf("0");
    } else {
      x = -1 * (c / b);
      printf("1\n%.5lf", x);
    }
  } else {
    y = b * b - 4 * a * c;
    if (y < 0) printf("0"), exit(0);
    r1 = (-b + sqrt(y)) / 2 / a, r2 = (-b - sqrt(y)) / 2 / a;
    if (r1 == r2) {
      printf("1\n%.5lf", r1);
    } else {
      m = min(r1, r2);
      n = max(r1, r2);
      printf("2\n%.5lf\n%.5lf", m, n);
    }
  }
  return 0;
}
