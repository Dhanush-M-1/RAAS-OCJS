#include <bits/stdc++.h>
using namespace std;
int main() {
  double a, b, c;
  cin >> a >> b >> c;
  a = double(a);
  b = double(b);
  c = double(c);
  double d = pow(b, 2.0) - 4.0 * a * c;
  if (d < 0 || a == 0 && b == 0 && c != 0) {
    cout << 0 << "\n";
    return 0;
  } else if (a == 0 && b == 0 && c == 0) {
    cout << -1 << "\n";
    return 0;
  } else if (a == 0) {
    cout << 1 << "\n";
    cout << fixed << double(-c / b);
  } else if (d == 0) {
    cout << 1 << "\n";
    cout << fixed << double((-b + double(sqrt(d))) / (2.0 * a));
  } else if (d > 0) {
    cout << 2 << '\n';
    cout << fixed
         << min(double((-b - double(sqrt(d))) / (2.0 * a)),
                double((-b + double(sqrt(d))) / (2.0 * a)))
         << "\n";
    cout << fixed
         << max(double((-b - double(sqrt(d))) / (2.0 * a)),
                double((-b + double(sqrt(d))) / (2.0 * a)))
         << "\n";
  }
}
