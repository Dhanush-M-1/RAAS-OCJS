#include <bits/stdc++.h>
using namespace std;
double a, b, c;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  scanf("%lf%lf%lf", &a, &b, &c);
  if (a == 0) {
    if (b == 0 && c == 0)
      cout << -1;
    else if (b == 0)
      cout << 0 << endl;
    else
      printf("1\n%.10lf", -c / b);
  } else {
    double d = b * b - 4 * a * c;
    if (d < 0)
      cout << 0;
    else if (d > 0) {
      double d1 = (-b + sqrt(d)) / (2 * a);
      double d2 = (-b - sqrt(d)) / (2 * a);
      cout << 2 << endl;
      if (d1 > d2)
        printf("%.10lf\n%.10lf", d2, d1);
      else
        printf("%.10lf\n%.10lf", d1, d2);
    } else {
      printf("1\n%.10lf", -b / (2 * a));
    }
  }
  return 0;
}
