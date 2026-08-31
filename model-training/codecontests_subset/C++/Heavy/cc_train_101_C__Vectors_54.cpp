#include <bits/stdc++.h>
using namespace std;
int main() {
  long long x1, x2, x3, y1, y2, y3, t, s1, s2, s;
  int i;
  while (cin >> x1 >> y1 >> x2 >> y2 >> x3 >> y3) {
    if (x3 == 0 && y3 == 0) {
      for (i = 0; i < 4; i++) {
        if (x1 == x2 && y1 == y2) break;
        t = x1;
        x1 = y1;
        y1 = -t;
      }
      if (i < 4)
        cout << "YES" << endl;
      else
        cout << "NO" << endl;
      continue;
    }
    for (i = 0; i < 4; i++) {
      s1 = (x2 - x1) * x3 + (y2 - y1) * y3;
      if (s1 < 0) s1 = -s1;
      s2 = (x2 - x1) * y3 - (y2 - y1) * x3;
      if (s2 < 0) s2 = -s2;
      s = x3 * x3 + y3 * y3;
      if (s1 % s == 0 && s2 % s == 0) break;
      t = x1;
      x1 = y1;
      y1 = -t;
    }
    if (i < 4)
      cout << "YES" << endl;
    else
      cout << "NO" << endl;
  }
}
