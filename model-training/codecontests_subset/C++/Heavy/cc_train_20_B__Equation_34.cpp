#include <bits/stdc++.h>
using namespace std;
int main() {
  double a, b, c;
  while (cin >> a >> b >> c) {
    if (a == 0 && b == 0) {
      if (c == 0)
        cout << -1 << endl;
      else
        cout << 0 << endl;
    } else if (a == 0 && c == 0)
      cout << 1 << endl << 0 << endl;
    else if (b == 0 && c == 0)
      cout << 1 << endl << 0 << endl;
    else if (a == 0)
      printf("1\n%.6lf\n", -c * 1.0 / b);
    else {
      double tmp = b * b - 4 * a * c;
      if (tmp < 0)
        cout << 0 << endl;
      else if (tmp == 0) {
        cout << 1 << endl;
        printf("%.6lf\n", -b * 1.0 / (2 * a));
      } else {
        cout << 2 << endl;
        double ans = sqrt(tmp);
        double x = (-b + ans) / (2 * a);
        double y = (-b - ans) / (2 * a);
        if (x > y)
          printf("%.6lf\n%.6lf\n", y, x);
        else
          printf("%.6lf\n%.6lf\n", x, y);
      }
    }
  }
  return 0;
}
