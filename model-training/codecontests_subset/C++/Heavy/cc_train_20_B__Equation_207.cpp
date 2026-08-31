#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  double a, b, c, d, e, f;
  cin >> a >> b >> c;
  d = pow(b, 2) - (4 * a * c);
  if (d < 0) {
    cout << 0;
  } else if (a == 0 and b == 0 and c == 0) {
    cout << -1 << endl;
  } else if (a == 0 and b == 0 and c != 0) {
    cout << 0 << endl;
  } else if (a == 0 and b != 0) {
    cout << 1 << endl;
    cout << setprecision(25) << double((-1 * c) / b) << endl;
  } else {
    e = ((-1 * b) + pow(d, 0.5)) / (2 * a);
    f = ((-1 * b) - pow(d, 0.5)) / (2 * a);
    if (d == 0) {
      cout << 1 << endl;
      cout << setprecision(25) << e << endl;
    } else {
      cout << 2 << endl;
      if (e < f) {
        cout << setprecision(25) << e << endl;
        cout << setprecision(25) << f << endl;
      } else {
        cout << setprecision(25) << f << endl;
        cout << setprecision(25) << e << endl;
      }
    }
  }
}
