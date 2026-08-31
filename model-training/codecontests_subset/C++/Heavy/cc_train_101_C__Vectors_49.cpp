#include <bits/stdc++.h>
using namespace std;
bool ok(long long x1, long long y1, long long x2, long long y2) {
  long long t;
  if (y2 == 0 && x2 == 0) return (x1 == 0 && y1 == 0);
  long long d1, d2;
  d1 = (x1 * x2 + y1 * y2) % (x2 * x2 + y2 * y2);
  t = x2, x2 = y2, y2 = -t;
  d2 = (x1 * x2 + y1 * y2) % (x2 * x2 + y2 * y2);
  if (d1 == 0 && d2 == 0) return true;
  return false;
}
int main(void) {
  long long ax, ay, bx, by, cx, cy;
  long long t;
  int i, j;
  bool f;
  while (cin >> ax >> ay >> bx >> by >> cx >> cy) {
    f = 0;
    for (i = 0; i < 4; i++) {
      t = ax, ax = ay, ay = -t;
      f |= ok(bx - ax, by - ay, cx, cy);
    }
    if (f)
      printf("YES\n");
    else
      printf("NO\n");
  }
  return 0;
}
