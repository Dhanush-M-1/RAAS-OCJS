#include <bits/stdc++.h>
using namespace std;
int main() {
  double a, b, c;
  cin >> a >> b >> c;
  if (a == 0) {
    if (b == 0) {
      if (c == 0)
        cout << -1;
      else
        cout << 0;
    } else
      cout << fixed << setprecision(5) << "1\n" << -c / b;
  } else {
    double denta = b * b - 4 * a * c;
    if (denta < 0)
      cout << 0;
    else if (denta == 0)
      cout << "1\n" << fixed << setprecision(5) << -b / 2 / a;
    else {
      double x1 = (-b - sqrt(denta)) / 2 / a, x2 = (-b + sqrt(denta)) / 2 / a;
      if (x1 > x2) {
        double temp = x1;
        x1 = x2;
        x2 = temp;
      }
      cout << "2\n"
           << fixed << setprecision(5) << x1 << "\n"
           << fixed << setprecision(5) << x2;
    }
  }
  return 0;
}
