#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  long long a, b, c, d;
  long double k, x1, x2;
  cin >> a >> b >> c;
  if (a == 0) {
    if (b == 0)
      c == 0 ? cout << -1 : cout << 0;
    else
      cout << "1\n" << fixed << setprecision(10) << (double)(-c) / b;
  } else {
    d = b * b - 4 * a * c;
    if (d > 0) {
      k = sqrt(d);
      x1 = (double)(-b - k) / (2 * a);
      x2 = (double)(k - b) / (2 * a);
      cout << "2\n"
           << fixed << setprecision(10) << min(x1, x2) << "\n"
           << max(x1, x2);
    } else
      d < 0 ? cout << 0
            : cout << "1\n"
                   << fixed << setprecision(10) << (double)(-b) / (2 * a);
  }
  return 0;
}
