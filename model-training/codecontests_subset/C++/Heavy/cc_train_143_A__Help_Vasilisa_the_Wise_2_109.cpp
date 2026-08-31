#include <bits/stdc++.h>
using namespace std;
long long t, n;
signed main() {
  long long r1, r2, c1, c2, d1, d2, x1, x2, x3, x4;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  if (r1 == 1 || r2 == 1 || c1 == 1 || c2 == 1 || d1 == 1 || d2 == 1) {
    cout << -1 << endl;
    return 0;
  }
  if (r1 > 17 || r2 > 17 || c1 > 17 || c2 > 17 || d1 > 17 || d2 > 17) {
    cout << -1 << endl;
    return 0;
  }
  if (r1 + r2 != c1 + c2 || r1 + r2 != d1 + d2 || c1 + c2 != d1 + d2) {
    cout << -1 << endl;
    return 0;
  }
  x2 = (r1 - c1 + d2) / 2;
  x1 = (r1 - c2 + d1) / 2;
  x3 = (r2 - c2 + d2) / 2;
  x4 = (r2 - c1 + d1) / 2;
  if (x1 == x2 || x1 == x3 || x1 == x4 || x2 == x3 || x2 == x4 || x3 == x4) {
    cout << -1 << endl;
    return 0;
  }
  long long m = min(x1, x2);
  m = min(m, x3), m = min(m, x4);
  long long mx = max(x1, x2);
  mx = max(mx, x3), mx = max(x4, mx);
  if (m < 1 || mx > 9) {
    cout << -1 << endl;
    return 0;
  }
  cout << x1 << " " << x2 << endl;
  cout << x3 << " " << x4 << endl;
  return 0;
}
