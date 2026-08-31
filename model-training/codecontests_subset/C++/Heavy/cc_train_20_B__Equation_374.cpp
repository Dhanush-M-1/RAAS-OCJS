#include <bits/stdc++.h>
using namespace std;
double a, b, c;
int main() {
  while (scanf("%lf%lf%lf", &a, &b, &c) != EOF) {
    double jd = b * b - 4 * a * c;
    if (a == 0) {
      if (b == 0)
        printf("%d\n", c == 0 ? -1 : 0);
      else
        printf("1\n%.10lf\n", (double)-c / (double)b);
    } else if (jd < 0)
      printf("0\n");
    else if (jd == 0)
      printf("1\n%.10lf\n", (double)-b / (double)(2 * a));
    else {
      double sq = sqrt(jd);
      double f1 = (-b - sq) / (2 * a);
      double f2 = (-b + sq) / (2 * a);
      if (f1 > f2)
        printf("2\n%.10lf\n%.10lf\n", f2, f1);
      else
        printf("2\n%.10lf\n%.10lf\n", f1, f2);
    }
  }
  return 0;
}
