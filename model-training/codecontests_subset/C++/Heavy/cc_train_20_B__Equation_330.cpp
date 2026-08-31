#include <bits/stdc++.h>
using namespace std;
int main() {
  long long a, b, c, d;
  cin >> a >> b >> c;
  if (a == 0 && b == 0 && c == 0) {
    cout << "-1" << endl;
  } else {
    if (a == 0) {
      if (b != 0) {
        cout << "1" << endl;
        cout << fixed << setprecision(5) << (0 - c) / (1.0 * b) << endl;
      } else
        cout << "0" << endl;
    } else {
      d = b * b - 4 * a * c;
      if (d > 0) {
        double x1, x2;
        cout << "2" << endl;
        x1 = (0 - b + sqrt(d)) / (2.0 * a);
        x2 = (0 - b - sqrt(d)) / (2.0 * a);
        if (x1 > x2) swap(x1, x2);
        cout << fixed << setprecision(5) << x1 << endl;
        cout << fixed << setprecision(5) << x2 << endl;
      } else if (d == 0) {
        cout << "1" << endl;
        cout << fixed << setprecision(5) << (0 - b) / (2.0 * a) << endl;
      } else
        cout << "0" << endl;
    }
  }
  return 0;
}
