#include <bits/stdc++.h>
using namespace std;
void roots(double a, double b, double c) {
  double x1, x2;
  double p = b * b - 4 * a * c;
  if (a == 0 && b == 0 && c == 0)
    cout << -1 << endl;
  else if (p < 0 || a == 0 && b == 0)
    cout << 0 << endl;
  else if (a == 0) {
    cout << 1 << endl;
    cout << fixed << setprecision(6) << -1 * (c / b) << endl;
  } else {
    x1 = (-b + sqrt(p)) / (2 * a);
    x2 = (-b - sqrt(p)) / (2 * a);
    if (x1 > x2) {
      cout << 2 << endl;
      cout << fixed << setprecision(6) << x2 << endl << x1 << endl;
    } else if (x2 > x1) {
      cout << 2 << endl;
      cout << fixed << setprecision(6) << x1 << endl << x2 << endl;
    } else {
      cout << 1 << endl;
      cout << fixed << setprecision(6) << x1 << endl;
    }
  }
}
int main() {
  double a, b, c;
  cin >> a >> b >> c;
  roots(a, b, c);
  return 0;
}
