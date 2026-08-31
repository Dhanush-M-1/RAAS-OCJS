#include <bits/stdc++.h>
using namespace std;
long long ax, ay, bx, by, cx, cy, dx, dy;
long long a1, b1, c1, a2, b2, c2, d;
int main() {
  cin >> ax >> ay >> bx >> by >> cx >> cy;
  for (int i = 0; i < 4; i++, swap(ax, ay), ax = -ax) {
    dx = bx - ax;
    dy = by - ay;
    a1 = cx;
    b1 = cy;
    c1 = -dx;
    a2 = cy;
    b2 = -cx;
    c2 = -dy;
    d = a1 * b2 - a2 * b1;
    if (dx * dx + dy * dy == 0 ||
        d && (b1 * c2 - b2 * c1) % d == 0 && (c1 * a2 - c2 * a1) % d == 0) {
      puts("YES");
      return 0;
    }
  }
  puts("NO");
  return 0;
}
