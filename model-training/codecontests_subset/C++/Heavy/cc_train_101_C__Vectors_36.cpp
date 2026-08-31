#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:100000000")
using namespace std;
long long x, y, xx, yy, dx, dy, n;
bool res;
bool F() {
  long long d1 = -dx * (y - yy) - dy * (xx - x);
  long long d2 = dx * dx + dy * dy;
  if (d2 == 0) return false;
  if (d1 % d2 != 0) return false;
  long long k2 = d1 / d2;
  d1 = xx - x + k2 * dy;
  d2 = dx;
  if (d2 == 0) return false;
  return (d1 % d2 == 0);
}
int main() {
  cin >> x >> y;
  cin >> xx >> yy;
  cin >> dx >> dy;
  res = false;
  if (x == xx && y == yy)
    res = true;
  else {
    for (int(j) = (0); (j) < (4); ++(j)) {
      long long xx_new, yy_new;
      xx_new = -yy;
      yy_new = xx;
      xx = xx_new;
      yy = yy_new;
      for (int(i) = (0); (i) < (4); ++(i)) {
        long long dx_new, dy_new;
        dx_new = -dy;
        dy_new = dx;
        dx = dx_new;
        dy = dy_new;
        if (F()) res = true;
      }
      if (dx == 0 || dy == 0)
        if (xx == x && yy == y) res = true;
    }
  }
  cout << (res == true ? "YES" : "NO") << endl;
}
