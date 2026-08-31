#include <bits/stdc++.h>
using namespace std;
int main() {
  double a, b, c;
  cin >> a >> b >> c;
  double d = b * b - a * c * 4;
  double x1 = (-b + sqrt(d)) / (2 * a);
  double x2 = (-b - sqrt(d)) / (2 * a);
  if (d < 0) {
    cout << 0;
  } else if (a == 0 && b == 0 && c != 0) {
    cout << 0;
  } else if (a == 0 && b == 0 && c == 0) {
    cout << -1;
  } else if (a == 0) {
    cout << 1 << "\n" << fixed << setprecision(7) << -(double)c / b;
  } else if (x1 > x2) {
    cout << 2 << "\n";
    cout << fixed;
    cout << setprecision(7) << x2 << "\n";
    cout << setprecision(7) << x1;
  } else if (x1 < x2) {
    cout << 2 << "\n";
    cout << fixed;
    cout << setprecision(7) << x1 << "\n";
    cout << setprecision(7) << x2;
  } else if (x1 == x2) {
    cout << 1 << "\n";
    cout << fixed;
    cout << setprecision(7) << x1;
  }
  return 0;
}
