#include <bits/stdc++.h>
using namespace std;
int main() {
  double a, b, c;
  scanf("%lf %lf %lf", &a, &b, &c);
  if (a == 0) {
    if (b == 0) {
      if (c == 0)
        printf("-1\n");
      else
        printf("0\n");
    } else {
      printf("1\n");
      printf("%.6lf\n", -c / b);
    }
  } else {
    double tt = b * b - 4 * a * c, aa, bb;
    if (tt < 0)
      printf("0\n");
    else if (tt == 0)
      printf("1\n%.6lf\n", -b / 2 / a);
    else {
      aa = (-b - sqrt(tt)) / 2 / a, bb = (-b + sqrt(tt)) / 2 / a;
      if (aa > bb) swap(aa, bb);
      printf("2\n%.6lf\n%.6lf\n", aa, bb);
    }
  }
  return 0;
}
