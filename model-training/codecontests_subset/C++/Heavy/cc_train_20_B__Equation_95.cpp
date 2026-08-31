#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  long long A, B, C;
  cin >> A >> B >> C;
  if (A == 0) {
    if (B == 0) {
      cout << (C == 0 ? -1 : 0) << '\n';
    } else {
      cout << 1 << '\n';
      cout << fixed << setprecision(10) << -1. * C / B << '\n';
    }
  } else {
    long long det = B * B - 4 * A * C;
    if (det > 0) {
      cout << 2 << '\n';
      cout << fixed << setprecision(10);
      double a[2] = {(-B - sqrt(det)) / 2 / A, (-B + sqrt(det)) / 2 / A};
      sort(a, a + 2);
      cout << a[0] << '\n' << a[1] << '\n';
    } else if (det == 0) {
      cout << 1 << '\n';
      cout << fixed << setprecision(10);
      cout << -B / 2. / A << '\n';
    } else
      cout << 0 << '\n';
  }
}
