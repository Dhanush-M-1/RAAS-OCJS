#include <bits/stdc++.h>
using namespace std;
const long long MAX = LLONG_MAX, mod = 1000000007, MODA = 1e9 - 1;
const long long MIN = LLONG_MIN;
const long double PI = 3.1415926535;
const long long N = 100009;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long double a, b, c;
  cin >> a >> b >> c;
  if (a == 0 && b == 0) {
    if (c == 0)
      cout << -1;
    else
      cout << 0;
  } else if (a == 0) {
    cout << fixed << setprecision(8) << "1" << endl << -c / b;
  } else {
    long double d = b * b - 4 * a * c;
    if (d < 0)
      cout << 0;
    else {
      if (d == 0) {
        cout << 1 << endl;
        long double r = (-b) / (2 * a);
        cout << fixed << setprecision(8) << r << endl;
      } else if (d > 0) {
        cout << 2 << endl;
        long double r1 = (-b - sqrt(d)) / (2 * a);
        long double r2 = (-b + sqrt(d)) / (2 * a);
        cout << fixed << setprecision(8) << min(r1, r2) << endl << max(r1, r2);
      }
    }
  }
  return 0;
}
