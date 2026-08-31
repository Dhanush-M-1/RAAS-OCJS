#include <bits/stdc++.h>
using namespace std;
int main() {
  long long A, B, C;
  cin >> A >> B >> C;
  if (A == 0) {
    if (B == 0) {
      if (C == 0) {
        cout << -1 << endl;
      } else {
        cout << 0 << endl;
      }
    } else {
      double x = -1.0 * C / B;
      cout << 1 << endl;
      cout << fixed << setprecision(5) << x << endl;
    }
  } else {
    long long disc = B * B - 4 * A * C;
    if (disc < 0) {
      cout << 0 << endl;
    } else {
      if (disc == 0) {
        cout << 1 << endl;
        double x = -1.0 * B / (2 * A);
        cout << fixed << setprecision(5) << x << endl;
      } else {
        cout << 2 << endl;
        double x1 = (-B + sqrt(disc)) / (2.0 * A);
        double x2 = (-B - sqrt(disc)) / (2.0 * A);
        if (x1 > x2) {
          swap(x1, x2);
        }
        cout << fixed << setprecision(5) << x1 << endl << x2 << endl;
      }
    }
  }
  return 0;
}
