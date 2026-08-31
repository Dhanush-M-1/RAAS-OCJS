#include <bits/stdc++.h>
using namespace std;
int const uu[4] = {1, -1, 0, 0};
int const vv[4] = {0, 0, 1, -1};
int const inf = 0x3f3f3f3f;
long long const INF = 0x7fffffffffffffffll;
double eps = 1e-10;
double pi = acos(-1.0);
double a, b, c;
int main() {
  cin >> a >> b >> c;
  if (a == 0) {
    if (b == 0) {
      if (c == 0) {
        puts("-1");
        return 0;
      } else {
        puts("0");
        return 0;
      }
    } else {
      printf("1\n%.10lf\n", (-c) / b);
      return 0;
    }
  }
  double delta = b * b - 4 * a * c;
  if (delta < 0.0) {
    puts("0");
    return 0;
  }
  delta = sqrt(delta);
  double x1 = (-b - delta) / (2 * a);
  double x2 = (-b + delta) / (2 * a);
  if (fabs(x1 - x2) < eps) {
    puts("1");
    printf("%.10lf\n", x1);
    return 0;
  }
  if (x1 > x2) swap(x1, x2);
  puts("2");
  printf("%.10lf\n", x1);
  printf("%.10lf\n", x2);
  return 0;
}
