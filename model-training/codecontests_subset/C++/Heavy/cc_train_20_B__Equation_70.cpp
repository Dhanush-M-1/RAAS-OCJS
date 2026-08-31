#include <bits/stdc++.h>
using namespace std;
int main() {
  long long a, b, c;
  double x1, x2;
  cin >> a >> b >> c;
  if (a == 0) {
    if (b == 0) {
      if (c == 0) {
        cout << "-1";
        return 0;
      }
      if (c != 0) {
        cout << "0";
        return 0;
      }
    } else {
      cout << "1" << endl;
      double wt = (-c) / (double)b;
      cout << fixed << setprecision(10) << wt << endl;
      return 0;
    }
  }
  double delta = b * b - 4 * a * c;
  if (delta < 0) {
    cout << "0";
    return 0;
  }
  if (delta == 0) {
    x1 = double((-b) / (2 * a));
    cout << "1" << endl;
    cout << fixed << setprecision(10) << x1 << endl;
    return 0;
  }
  if (delta > 0) {
    cout << "2" << endl;
    x1 = double((-b - sqrt(delta)) / (2 * a));
    x2 = double((-b + sqrt(delta)) / (2 * a));
    cout << fixed << setprecision(10) << min(x1, x2) << endl;
    cout << fixed << setprecision(10) << max(x1, x2) << endl;
    return 0;
  }
  return 0;
}
