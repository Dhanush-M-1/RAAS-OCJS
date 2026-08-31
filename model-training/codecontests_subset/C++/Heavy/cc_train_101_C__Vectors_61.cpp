#include <bits/stdc++.h>
using namespace std;
int main() {
  long long x0, y0, x, y, x1, y1;
  long long m1, m2, n;
  while (cin >> x0 >> y0) {
    cin >> x >> y;
    cin >> x1 >> y1;
    if (x1 * x1 + y1 * y1 == 0) {
      int i;
      for (i = 0; i < 4; i++) {
        if (x0 == x && y0 == y) break;
        long long temp = x0;
        x0 = y0;
        y0 = -temp;
      }
      if (i < 4)
        cout << "YES" << endl;
      else
        cout << "NO" << endl;
      continue;
    }
    int i;
    for (i = 0; i < 4; i++) {
      m1 = (x - x0) * x1 + (y - y0) * y1;
      if (m1 < 0) m1 = -m1;
      m2 = (x - x0) * y1 - (y - y0) * x1;
      if (m2 < 0) m2 = -m2;
      n = x1 * x1 + y1 * y1;
      if (m1 % n == 0 && m2 % n == 0) break;
      long long temp = x0;
      x0 = y0;
      y0 = -temp;
    }
    if (i < 4)
      cout << "YES" << endl;
    else
      cout << "NO" << endl;
  }
  return 0;
}
