#include <bits/stdc++.h>
using namespace std;
int main() {
  double a, b, c;
  cin >> a >> b >> c;
  double d = b * b - 4 * a * c;
  if (a == 0) {
    if (b == 0) {
      if (c == 0)
        cout << -1 << endl;
      else
        cout << 0 << endl;
    } else
      cout << 1 << endl << fixed << setprecision(10) << (double)-c / b << endl;
  } else {
    if (d == 0) {
      cout << 1 << endl;
      cout << fixed << setprecision(10) << (double)(-b / (2 * a)) << endl;
    } else {
      if (d < 0)
        cout << 0 << endl;
      else {
        cout << 2 << endl;
        d = sqrt(d);
        double x = (-b - d) / (2 * a);
        double xx[2];
        xx[0] = x;
        xx[1] = (double)(-b + d) / (2 * a);
        sort(xx, xx + 2);
        cout << fixed << setprecision(10) << xx[0] << endl;
        cout << fixed << setprecision(10) << xx[1] << endl;
      }
    }
  }
}
