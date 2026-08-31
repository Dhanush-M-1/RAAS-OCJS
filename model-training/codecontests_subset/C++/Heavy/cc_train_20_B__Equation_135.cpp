#include <bits/stdc++.h>
using namespace std;
double r1, r2, a, b, c, delta;
int main() {
  cin >> a >> b >> c;
  cout << fixed << setprecision(5);
  if (a == b && b == c && c == 0) {
    cout << -1;
    return 0;
  }
  if (a != 0) {
    delta = b * b - 4 * a * c;
    if (delta == 0) {
      cout << 1 << endl << ((-1) * b) / (2 * a);
      return 0;
    }
    if (delta > 0) {
      r1 = (-1 * b + sqrt(delta)) / (2 * a);
      r2 = (-1 * b - sqrt(delta)) / (2 * a);
      cout << 2 << endl << min(r1, r2) << endl << max(r1, r2);
      return 0;
    }
    if (delta < 0) {
      cout << 0;
      return 0;
    }
  }
  if (a == 0 && b != 0) {
    cout << 1 << endl << c / b * -1;
    return 0;
  }
  if (a == 0 && b == 0) {
    cout << 0;
    return 0;
  }
  cout << -1;
  return 0;
}
