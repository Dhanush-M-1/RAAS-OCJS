#include <bits/stdc++.h>
using namespace std;
int main() {
  long double a, b, c, x1, x2, d;
  cin >> a >> b >> c;
  if (a == 0) {
    if (b != 0) {
      x1 = -c / b;
      cout << 1 << endl;
      cout.precision(10);
      cout << fixed << x1 << endl;
    } else if (c == 0)
      cout << -1 << endl;
    else
      cout << 0;
  } else {
    d = b * b - 4 * a * c;
    if (d < 0)
      cout << 0 << endl;
    else if (d == 0) {
      x1 = -b / (2 * a);
      cout << 1 << endl;
      cout.precision(10);
      cout << fixed << x1 << endl;
    } else {
      x1 = (-b + sqrt(d)) / (2 * a);
      x2 = (-b - sqrt(d)) / (2 * a);
      cout << 2 << endl;
      cout.precision(10);
      cout << fixed << min(x1, x2) << endl;
      cout << fixed << max(x1, x2) << endl;
    }
  }
  return 0;
}
