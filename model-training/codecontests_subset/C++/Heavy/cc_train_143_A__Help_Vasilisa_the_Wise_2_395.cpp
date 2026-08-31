#include <bits/stdc++.h>
using namespace std;
int main() {
  int r1, r2, c1, c2, d1, d2, i, x1, x2, x3, x4;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  for (i = 1; i <= 9; i++) {
    x1 = i;
    x4 = d1 - x1;
    x2 = r1 - x1;
    x3 = r2 - x4;
    if (x4 > 9 || x2 > 9 || x3 > 9) continue;
    if (x2 == x4 || x1 == x2 || x2 == x3 || x3 == x4 || x3 == x1 || x4 == x1 ||
        x4 <= 0 || x2 <= 0 || x3 <= 0)
      continue;
    if (x2 != (d2 - x3) || x2 != (c2 - x4)) continue;
    if (x3 != (d2 - x2) || x3 != (c1 - x1)) continue;
    if (x4 != (c2 - x2)) continue;
    if (x1 != (c1 - x3)) continue;
    break;
  }
  if (i <= 9) {
    cout << x1 << " " << x2 << endl;
    cout << x3 << " " << x4 << endl;
  } else
    cout << -1 << endl;
  return 0;
}
