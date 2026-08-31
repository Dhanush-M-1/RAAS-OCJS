#include <bits/stdc++.h>
using namespace std;
const long long MODN = 1000000007;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  double a, b, c;
  cin >> a >> b >> c;
  cout << fixed << setprecision(5);
  if (a == 0) {
    if (b == 0) {
      if (c == 0)
        cout << -1 << endl;
      else
        cout << 0 << endl;
    } else {
      cout << 1 << endl;
      cout << -c / b << endl;
    }
  } else {
    double d = b * b - 4 * a * c;
    if (d < 0) {
      cout << 0 << endl;
    } else if (d < 1e-7) {
      cout << 1 << endl;
      cout << -b / (2 * a) << endl;
    } else {
      cout << 2 << endl;
      double r1 = (-b - sqrt(d)) / (2 * a);
      double r2 = (-b + sqrt(d)) / (2 * a);
      if (r1 > r2) swap(r1, r2);
      cout << r1 << endl << r2 << endl;
    }
  }
  return 0;
}
