#include <bits/stdc++.h>
using namespace std;
double a, b, c;
double min(double a, double b) {
  if (a > b) return b;
  return a;
}
double max(double a, double b) {
  if (a < b) return b;
  return a;
}
int main() {
  double t, x1, x2;
  while (scanf("%lf %lf %lf", &a, &b, &c) != EOF) {
    if (a == 0 && b == 0 && c == 0) puts("-1");
    if (a == 0 && b == 0 && c != 0) puts("0");
    if (a == 0 && b != 0) {
      puts("1");
      printf("%.10lf\n", -c / b);
    }
    if (a != 0) {
      t = b * b - 4 * a * c;
      if (t == 0) {
        puts("1");
        x1 = (-b / (2 * a));
        printf("%.10lf\n", x1);
      } else if (t > 0) {
        puts("2");
        x1 = min((-b - sqrt(t)) / (2 * a), (-b + sqrt(t)) / (2 * a));
        x2 = max((-b - sqrt(t)) / (2 * a), (-b + sqrt(t)) / (2 * a));
        printf("%.10lf\n%.10lf\n", x1, x2);
      } else if (t < 0) {
        puts("0");
      }
    }
  }
  return 0;
}
