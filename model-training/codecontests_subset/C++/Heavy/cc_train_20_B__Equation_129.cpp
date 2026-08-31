#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cout << fixed << setprecision(10);
  double a, b, c;
  cin >> a >> b >> c;
  if (a == 0 && b == 0 && c == 0)
    cout << "-1";
  else if (a == 0 && b == 0)
    cout << "0";
  else if (a == 0) {
    cout << "1"
         << "\n";
    cout << -1 * (c / b);
    return 0;
  } else if (b * b < 4 * a * c)
    cout << "0";
  else {
    double x, y, z;
    x = (b * b) - (4 * a * c);
    x = sqrt(x);
    y = -1 * b;
    double zz;
    z = (y - x) / (2 * a);
    zz = (y + x) / (2 * a);
    if (z == zz) {
      cout << "1"
           << "\n";
      cout << z;
      return 0;
    }
    cout << "2"
         << "\n";
    cout << min(z, zz) << "\n";
    cout << max(z, zz) << "\n";
  }
  return 0;
}
