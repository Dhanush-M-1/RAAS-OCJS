#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c;
  cin >> a >> b >> c;
  if (a == 0) {
    if (b == 0)
      printf(c == 0 ? "-1\n" : "0\n");
    else
      printf("1\n%f\n", (double)-c / b);
    return 0;
  }
  long long d = (long long)b * b - 4LL * a * c;
  if (d < 0)
    printf("0\n");
  else if (d == 0)
    printf("1\n%f\n", -b / 2.0 / a);
  else {
    double r = sqrt(d);
    double x1 = (-b - r) / 2 / a;
    double x2 = (-b + r) / 2 / a;
    if (x1 > x2) swap(x1, x2);
    printf("2\n%f\n%f\n", x1, x2);
  }
  return 0;
}
