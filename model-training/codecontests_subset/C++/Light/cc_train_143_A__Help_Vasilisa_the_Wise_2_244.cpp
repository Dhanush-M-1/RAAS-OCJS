#include <bits/stdc++.h>
using namespace std;
int main() {
  int x, y, z, h, c1, c2, r1, r2, d1, d2;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  y = (r1 - c1 + d2) / 2;
  x = r1 - y;
  z = d2 - y;
  h = c2 - y;
  if (x == y || x == z || x == h || y == z || y == h || z == h || x <= 0 ||
      y <= 0 || z <= 0 || h <= 0 || x > 9 || y > 9 || h > 9 || z > 9)
    cout << -1 << endl;
  else if (x + y == r1 && x + z == c1 && x + h == d1 && y + z == d2 &&
           y + h == c2 && z + h == r2) {
    cout << x << ' ' << y << endl;
    cout << z << ' ' << h << endl;
  } else
    cout << -1 << endl;
  return 0;
}
