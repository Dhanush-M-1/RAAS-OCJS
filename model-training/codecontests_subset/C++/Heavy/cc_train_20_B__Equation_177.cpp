#include <bits/stdc++.h>
using namespace std;
const int N = 1e5;
const long long INT = 1e9;
const long long LONG = 1e18;
const long long mod = 1e9 + 7;
int main() {
  double a, b, c;
  cin >> a >> b >> c;
  double d = b * b - 4 * a * c;
  if (a == 0) {
    if (b == 0) {
      if (c == 0)
        cout << -1;
      else
        cout << 0;
    } else {
      cout << 1 << '\n';
      cout << setprecision(9) << fixed << -c / b;
    }
    return 0;
  }
  if (d < 0) cout << 0;
  if (d == 0) {
    cout << 1 << '\n';
    cout << setprecision(9) << fixed << -b / (2 * a);
  }
  if (d > 0) {
    cout << 2 << '\n';
    double x1 = (-b - sqrt(d)) / (2 * a), x2 = (-b + sqrt(d)) / (2 * a);
    cout << setprecision(9) << fixed << min(x1, x2) << '\n';
    cout << setprecision(9) << fixed << max(x1, x2) << '\n';
  }
}
