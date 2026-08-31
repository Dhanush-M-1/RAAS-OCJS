#include <bits/stdc++.h>
using namespace std;
double a, b, c;
int main() {
  cin >> a >> b >> c;
  if (a == 0 && b == 0 && c == 0) {
    cout << "-1" << endl;
    return 0;
  }
  if (a == 0) {
    if (b == 0)
      cout << "0" << endl;
    else {
      cout << "1" << endl;
      double x = -c / b;
      cout.precision(6);
      cout << fixed << x << endl;
    }
  } else {
    double d = b * b - 4 * a * c;
    if (d < 0)
      cout << '0';
    else if (d == 0) {
      cout << '1' << endl;
      double x11 = -b / (2 * a);
      cout.precision(6);
      cout << fixed << x11 << endl;
    } else {
      cout << '2' << endl;
      double x11 = (-sqrt(d) - b) / (2 * a);
      double x22 = (sqrt(d) - b) / (2 * a);
      cout.precision(6);
      cout << fixed << min(x11, x22) << endl;
      cout.precision(6);
      cout << fixed << max(x11, x22) << endl;
    }
  }
  return 0;
}
