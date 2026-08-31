#include <bits/stdc++.h>
using namespace std;
int main() {
  int r1, r2, c1, c2, d1, d2, x1, x2, y1, y2;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  x1 = (r1 + d1 - c2) / 2;
  x2 = (r1 + d2 - c1) / 2;
  y1 = (r2 + d2 - c2) / 2;
  y2 = (r2 + d1 - c1) / 2;
  if (x1 + x2 == r1 && y1 + y2 == r2 && c1 == x1 + y1 && c2 == x2 + y2 &&
      d1 == x1 + y2 && d2 == x2 + y1 && x1 != x2 && x1 != y1 && x1 != y2 &&
      x2 != y1 && x2 != y2 && y1 != y2 && x1 < 10 && x2 < 10 && y1 < 10 &&
      y2 < 10 && x1 > 0 && x2 > 0 && y1 > 0 && y2 > 0) {
    cout << x1 << " " << x2 << endl;
    cout << y1 << " " << y2 << endl;
  } else
    cout << -1 << endl;
  return 0;
}
