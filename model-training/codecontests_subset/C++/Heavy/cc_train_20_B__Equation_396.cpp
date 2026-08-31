#include <bits/stdc++.h>
using namespace std;
int main() {
  double a, b, c;
  double x[3];
  cin >> a >> b >> c;
  if (a == 0 && b == 0 && c == 0) {
    cout << "-1" << endl;
    return 0;
  }
  if (a == 0 && b == 0) {
    cout << "0" << endl;
    return 0;
  }
  if (a == 0) {
    cout << "1" << endl;
    cout << fixed << setprecision(10) << double(-c / b) << endl;
    return 0;
  }
  if (b * b - 4 * a * c < 0) {
    cout << "0" << endl;
    return 0;
  }
  x[0] = double(-b + sqrt(b * b - 4 * a * c)) / double(2 * a);
  x[1] = double(-b - sqrt(b * b - 4 * a * c)) / double(2 * a);
  if (x[0] == x[1]) {
    cout << "1" << endl;
    cout << fixed << setprecision(10) << x[0] << endl;
    return 0;
  } else {
    cout << "2" << endl;
    cout << fixed << setprecision(10) << min(x[0], x[1]) << endl;
    cout << fixed << setprecision(10) << max(x[0], x[1]) << endl;
    return 0;
  }
  return 0;
}
