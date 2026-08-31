#include <bits/stdc++.h>
using namespace std;
int main() {
  double a, b, c;
  double res1, res2;
  cin >> a >> b >> c;
  if (a == 0) {
    if (b == 0) {
      if (c == 0)
        cout << "-1\n";
      else
        cout << "0\n";
    } else {
      cout << "1\n";
      cout << fixed << setprecision(10) << (-c / b) << endl;
    }
  } else {
    if (b * b - 4 * a * c < 0)
      cout << "0\n";
    else if (b * b - 4 * a * c == 0) {
      res1 = (-b) * 1.0 / (2 * a);
      cout << "1\n";
      cout << fixed << setprecision(10) << res1 << endl;
    } else {
      res1 = (-b + sqrt(b * b - 4 * a * c)) * 1.0 / (2 * a);
      res2 = (-b - sqrt(b * b - 4 * a * c)) * 1.0 / (2 * a);
      cout << "2\n";
      if (res1 > res2) {
        cout << fixed << setprecision(10) << res2 << endl;
        cout << fixed << setprecision(10) << res1 << endl;
      } else {
        cout << fixed << setprecision(10) << res1 << endl;
        cout << fixed << setprecision(10) << res2 << endl;
      }
    }
  }
  return 0;
}
