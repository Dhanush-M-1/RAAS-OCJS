#include <bits/stdc++.h>
using namespace std;
int main() {
  double a, b, c;
  while (~scanf("%lf%lf%lf", &a, &b, &c)) {
    if (a == 0 && b == 0)
      if (c == 0)
        puts("-1");
      else
        puts("0");
    else if (a == 0 && c == 0)
      puts("1\n0");
    else if (b == 0 && c == 0)
      puts("1\n0");
    else if (a == 0)
      printf("1\n%.10lf\n", -c / b);
    else {
      double tem = b * b - 4 * a * c;
      if (tem < 0)
        printf("0\n");
      else if (tem == 0)
        printf("1\n%.10lf\n", -b / (a * 2));
      else {
        double x1, x2;
        x1 = (-b - sqrt(tem)) / (a * 2);
        x2 = (-b + sqrt(tem)) / (a * 2);
        if (x1 > x2) swap(x1, x2);
        printf("2\n%.10lf\n%.10lf\n", x1, x2);
      }
    }
  }
  return 0;
}
