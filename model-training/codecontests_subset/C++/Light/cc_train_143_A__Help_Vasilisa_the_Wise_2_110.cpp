#include <bits/stdc++.h>
using namespace std;
int main() {
  int r1, r2, c1, c2, d1, d2;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  int z = (r2 + c1 - d1) / 2, x = c1 - z, y = d2 - z, l = r2 - z;
  if (z == x ||
      ((r1 + r2) != (c1 + c2) || (r1 + r2) != (d1 + d2) ||
       (d1 + d2) != (c1 + c2)) ||
      x == y || x == l || y == l || y == z || z == l || x > 9 || y > 9 ||
      z > 9 || l > 9 || x <= 0 || y <= 0 || z <= 0 || l <= 0) {
    cout << -1 << endl;
  } else
    cout << x << " " << y << endl << z << " " << l << endl;
  return 0;
}
