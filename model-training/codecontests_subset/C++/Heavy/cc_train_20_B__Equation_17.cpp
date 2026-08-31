#include <bits/stdc++.h>
using namespace std;
int main() {
  long long delta, a, b, c;
  cin >> a >> b >> c;
  delta = b * b - 4 * a * c;
  if ((a == 0) && (b == 0) && (c == 0)) {
    cout << -1 << endl;
  } else if ((a == 0) && (b == 0) && (c != 0)) {
    cout << 0 << endl;
  } else if ((a == 0) && (b != 0)) {
    cout << 1 << endl;
    cout << fixed << setprecision(10);
    cout << -c / (b * 1.0) << endl;
  } else if (delta > 0) {
    cout << 2 << endl;
    cout << fixed << setprecision(10);
    if (a > 0) {
      cout << (-b - sqrt(delta)) / (2 * a * 1.0) << endl;
      cout << (-b + sqrt(delta)) / (2 * a * 1.0) << endl;
    } else {
      cout << (-b + sqrt(delta)) / (2 * a * 1.0) << endl;
      cout << (-b - sqrt(delta)) / (2 * a * 1.0) << endl;
    }
  } else if (delta == 0) {
    cout << 1 << endl;
    cout << fixed << setprecision(10);
    cout << -b / (2 * a * 1.0) << endl;
  } else {
    cout << 0 << endl;
  }
  return 0;
}
