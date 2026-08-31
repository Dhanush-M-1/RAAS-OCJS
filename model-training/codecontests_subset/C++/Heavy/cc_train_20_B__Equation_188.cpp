#include <bits/stdc++.h>
using namespace std;
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long tt = 1;
  while (tt--) {
    long long a, b, c;
    cin >> a >> b >> c;
    if (a == 0 && b == 0 && c == 0) {
      cout << -1 << endl;
    } else if (a == 0 && b == 0) {
      cout << 0 << endl;
    } else if (a == 0) {
      cout << 1 << endl;
      cout << fixed << setprecision(12) << ((-1.0 * c) / b) << endl;
    } else {
      long long d = b * b - 4 * a * c;
      if (d < 0)
        cout << 0 << endl;
      else if (d == 0) {
        cout << 1 << endl;
        cout << fixed << setprecision(12) << ((-1.0 * b) / (2.0 * a)) << endl;
      } else {
        long double rt = sqrt(d);
        cout << 2 << endl;
        if (a > 0) {
          cout << fixed << setprecision(12) << ((-1.0 * b - rt) / (2.0 * a))
               << endl;
          cout << fixed << setprecision(12) << ((-1.0 * b + rt) / (2.0 * a))
               << endl;
        } else {
          cout << fixed << setprecision(12) << ((-1.0 * b + rt) / (2.0 * a))
               << endl;
          cout << fixed << setprecision(12) << ((-1.0 * b - rt) / (2.0 * a))
               << endl;
        }
      }
    }
  }
  return 0;
}
