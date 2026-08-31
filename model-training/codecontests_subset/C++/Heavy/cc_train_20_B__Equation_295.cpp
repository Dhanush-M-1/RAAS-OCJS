#include <bits/stdc++.h>
using namespace std;
double min(double a, double b) { return a < b ? a : b; }
double max(double a, double b) { return a > b ? a : b; }
int main() {
  double a, b, c;
  scanf("%lf%lf%lf", &a, &b, &c);
  double t = b * b - 4 * a * c;
  if (t < -1e-9) {
    puts("0");
    return 0;
  } else if (t < 1e-9) {
    if (a == 0 && b == 0 && c == 0) {
      printf("-1\n");
      return 0;
    } else if (a == 0 && b == 0 && (c != 0)) {
      puts("0");
      return 0;
    } else {
      puts("1");
      printf("%.10lf\n", -b / (2 * a));
      return 0;
    }
  }
  double s = sqrt(b * b - 4 * a * c);
  if (a == 0) {
    puts("1");
    printf("%.10lf\n", -c / b);
    return 0;
  }
  puts("2");
  double aa = (-b - s) / (2 * a);
  double bb = (-b + s) / (2 * a);
  printf("%.10lf\n%.10lf\n", min(aa, bb), (max(aa, bb)));
}
