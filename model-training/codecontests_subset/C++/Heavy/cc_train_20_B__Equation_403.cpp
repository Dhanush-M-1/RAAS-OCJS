#include <bits/stdc++.h>
using namespace std;
int main() {
  double a, b, c;
  cin >> a >> b >> c;
  double f;
  if (a == 0 && b == 0) {
    if (c == 0)
      cout << "-1" << endl;
    else
      cout << "0" << endl;
  } else if (a == 0 && c == 0) {
    cout << "1" << endl;
    cout << fixed << setprecision(8) << 0.0 << endl;
  } else if (a == 0) {
    cout << "1" << endl;
    cout << fixed << setprecision(8) << -c / b << endl;
  } else {
    double delta = (b * b) - (4 * a * c);
    double r = sqrt(delta);
    if (delta < 0)
      cout << "0" << endl;
    else if (delta == 0) {
      cout << "1" << endl;
      cout << fixed << setprecision(8) << -b / (2 * a) << endl;
    } else {
      cout << "2" << endl;
      double x = (double)(-b - r) / (2 * a), y = (-b + r) / (2 * a);
      if (x > y) {
        cout << fixed << setprecision(8) << y << endl;
        cout << setprecision(8) << x << endl;
      } else {
        cout << fixed << setprecision(8) << x << endl;
        cout << setprecision(8) << y << endl;
      }
    }
  }
}
