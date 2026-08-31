#include <bits/stdc++.h>
using namespace std;
int main() {
  long double a, b, c;
  cin >> a >> b >> c;
  if (a == 0 && b == 0 && c == 0) {
    cout << "-1" << endl;
    return 0;
  } else {
    if (a == 0 && b == 0 && c != 0) {
      cout << "0" << endl;
      return 0;
    } else {
      if (a == 0 && b != 0) {
        cout << "1" << endl;
        cout << fixed << setprecision(12) << -(c / b) << endl;
        return 0;
      } else {
        if (a != 0) {
          long double d = (b * b) - (4 * (a * c));
          long double r1, r2;
          if (d > 0) {
            cout << "2" << endl;
            d = sqrtl(d);
            r1 = ((d - b) / 2) / a;
            r2 = -(((d + b) / 2)) / a;
            if (r1 > r2) {
              cout << fixed << setprecision(12) << r2 << endl;
              cout << fixed << setprecision(12) << r1 << endl;
            } else {
              cout << fixed << setprecision(12) << r1 << endl;
              cout << fixed << setprecision(12) << r2 << endl;
            }
            return 0;
          }
          if (d == 0) {
            cout << "1" << endl;
            cout << fixed << setprecision(12) << -((b / 2) / a) << endl;
            return 0;
          }
          if (d < 0) {
            cout << "0" << endl;
          }
        }
      }
    }
  }
}
