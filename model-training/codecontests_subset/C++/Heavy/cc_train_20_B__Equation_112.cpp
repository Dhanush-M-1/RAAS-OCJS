#include <bits/stdc++.h>
using namespace std;
int main() {
  cin.sync_with_stdio(false);
  cin.tie(0);
  long double a, b, c;
  cin >> a >> b >> c;
  if (a == 0 and b == 0 and c == 0)
    cout << -1;
  else if ((a == 0 and b == 0) or b * b - 4 * a * c < 0)
    cout << 0;
  else if (a == 0)
    cout << fixed << setprecision(10) << "1\n" << (-1) * (c / b);
  else {
    long double q = ((-1) * b + sqrt(b * b - 4 * a * c)) / (2 * a);
    long double p = ((-1) * b - sqrt(b * b - 4 * a * c)) / (2 * a);
    if (q == p)
      cout << fixed << setprecision(10) << "1\n" << q;
    else
      cout << fixed << setprecision(10) << "2\n"
           << min(q, p) << "\n"
           << max(q, p);
  }
  return 0;
}
