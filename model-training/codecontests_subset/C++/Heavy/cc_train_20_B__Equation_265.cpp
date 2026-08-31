#include <bits/stdc++.h>
using namespace std;
int main() {
  long double a, b, c;
  cin >> a >> b >> c;
  if (a == 0 && b == 0 && c == 0) cout << -1;
  if (a == 0 && b == 0 && c != 0) cout << 0;
  if (a != 0 && b != 0) {
    long long int d = b * b - 4 * a * c;
    if (d < 0) cout << 0;
    if (d > 0) {
      cout << 2 << "\n";
      int p = -b - sqrt(d);
      int q = -b + sqrt(d);
      if (a > 0) {
        cout << fixed << setprecision(5) << (-b - sqrt(d)) / (2 * a) << "\n";
        cout << fixed << setprecision(5) << (-b + sqrt(d)) / (2 * a);
      } else {
        cout << fixed << setprecision(5) << (-b + sqrt(d)) / (2 * a) << "\n";
        cout << fixed << setprecision(5) << (-b - sqrt(d)) / (2 * a);
      }
    }
    if (d == 0) {
      cout << 1 << "\n";
      cout << fixed << setprecision(5) << -b / (2 * a);
    }
  }
  if (a == 0 && b != 0) {
    cout << 1 << "\n";
    cout << fixed << setprecision(5) << -c / b;
  }
  if (a != 0 && b == 0) {
    if (c > 0) cout << 0;
    if (c == 0)
      cout << 1 << "\n"
           << "0.000000000";
    if (c < 0) {
      cout << 2 << "\n";
      cout << fixed << setprecision(5) << -sqrt(c / a) << "\n" << sqrt(c / a);
    }
  }
}
