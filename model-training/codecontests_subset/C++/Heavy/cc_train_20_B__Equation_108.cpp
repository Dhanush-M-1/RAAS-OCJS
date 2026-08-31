#include <bits/stdc++.h>
using namespace std;
int main() {
  long long a, b, c, d;
  cout.precision(10);
  cin >> a >> b >> c;
  if (a == 0) {
    if (b == 0) {
      if (c == 0)
        cout << -1;
      else
        cout << 0;
    } else {
      long double cc = -c + 0.0;
      cout << 1 << endl << cc / b;
    }
  } else {
    d = b * b - 4 * a * c;
    if (d < 0) {
      cout << 0;
    } else if (d > 0) {
      long double sq = sqrt(d);
      cout << 2 << endl;
      if (a > 0) {
        cout << (-b - sq) / (2 * a) << endl;
        cout << (-b + sq) / (2 * a);
      } else {
        cout << (-b + sq) / (2 * a) << endl;
        cout << (-b - sq) / (2 * a);
      }
    } else {
      cout << 1 << endl << -b / (2 * a);
    }
  }
  return 0;
}
