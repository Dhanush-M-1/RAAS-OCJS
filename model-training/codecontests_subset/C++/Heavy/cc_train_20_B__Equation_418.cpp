#include <bits/stdc++.h>
using namespace std;
int main() {
  double A, B, C;
  double d, x1, x2;
  cin >> A >> B >> C;
  cout << fixed << setprecision(10);
  if (A == 0) {
    if (B == 0) {
      if (C == 0) {
        cout << -1;
      } else {
        cout << 0;
      }
    } else {
      cout << 1 << endl;
      cout << -C / B;
    }
  } else {
    d = B * B - 4 * A * C;
    if (d == 0) {
      cout << 1 << endl << -B / (2 * A);
    } else if (d < 0)
      cout << 0;
    else {
      cout << 2 << endl;
      x1 = (-B - sqrt(d)) / (2 * A);
      x2 = (-B + sqrt(d)) / (2 * A);
      cout << min(x1, x2) << endl;
      cout << max(x1, x2);
    }
  }
  return 0;
}
