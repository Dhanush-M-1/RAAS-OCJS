#include <bits/stdc++.h>
using namespace std;
int main() {
  long long x, y, ax, ay, bx, by, cx, cy, dx, dy, Cx, Cy;
  int i, j, k, m, n;
  while (cin >> ax >> ay >> bx >> by >> cx >> cy) {
    for (i = 0; i < 4; i++) {
      x = ay;
      y = -ax;
      ax = x;
      ay = y;
      dx = bx - ax;
      dy = by - ay;
      Cx = cy;
      Cy = -cx;
      if (cx || cy) {
        if ((dx * cy - dy * cx) % (Cx * cy - Cy * cx) == 0 &&
            (dx * Cy - dy * Cx) % (cx * Cy - cy * Cx) == 0) {
          puts("YES");
          break;
        }
      } else {
        if (!dx && !dy) {
          puts("YES");
          break;
        }
      }
    }
    if (i == 4) puts("NO");
  }
}
