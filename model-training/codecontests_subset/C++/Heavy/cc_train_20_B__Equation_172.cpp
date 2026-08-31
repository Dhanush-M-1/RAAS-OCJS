#include <bits/stdc++.h>
using namespace std;
int main() {
  long double a, b, c, delta, x1, x2;
  cin >> a >> b >> c;
  if (a == 0 && b == 0 && c == 0) {
    cout << -1;
    return 0;
  }
  if (a == 0 && b == 0 && c != 0) {
    cout << 0;
    return 0;
  }
  if (a == 0 && b != 0) {
    cout << "1\n" << fixed << setprecision(10) << -c / b;
    return 0;
  }
  delta = b * b - 4 * a * c;
  if (delta < 0) {
    cout << 0;
    return 0;
  }
  if (delta == 0) {
    cout << "1\n" << fixed << setprecision(10) << -b / (2 * a);
    return 0;
  }
  if (delta > 0) {
    cout << "2\n";
    x1 = (-b + sqrt(b * b - 4 * a * c)) / (2 * a);
    x2 = (-b - sqrt(b * b - 4 * a * c)) / (2 * a);
    cout << fixed << setprecision(10) << min(x1, x2) << endl
         << fixed << setprecision(10) << max(x1, x2);
    return 0;
  }
  return 0;
}
