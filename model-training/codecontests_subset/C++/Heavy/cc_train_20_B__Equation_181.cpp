#include <bits/stdc++.h>
using namespace std;
int main() {
  double A, B, C;
  cin >> A >> B >> C;
  double a, b, d;
  if (A == 0 && B == 0 && C == 0)
    cout << -1;
  else if (A > 0 || A < 0) {
    if (B * B > 4 * A * C) {
      d = B * B - (4 * A * C);
      a = (-B + sqrt(d)) / (2 * A);
      b = (-B - sqrt(d)) / (2 * A);
      cout << 2 << endl;
      printf("%.7lf\n", min(a, b));
      printf("%.7lf\n", max(a, b));
    } else if (B * B == 4 * A * C) {
      b = (-B) / (2 * A);
      printf("1\n%.7lf\n", b);
    } else
      cout << 0;
  } else {
    if (B > 0 || B < 0) {
      a = -C / B;
      printf("1\n%.7lf\n", a);
    } else
      cout << 0;
  }
}
