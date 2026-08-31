#include <bits/stdc++.h>
using namespace std;
int main() {
  int r1, r2, c1, c2, d1, d2;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  int p, q, r, s;
  p = ((d1 + r1 + c1) - (d2 + c2 + r2) / 2) / 3;
  q = r1 - p;
  r = c1 - p;
  s = d1 - p;
  if (p != q && p != r && p != s && q != r && q != s && r != s) {
    if ((p > 0 && p < 10) && (q > 0 && q < 10) && (r > 0 && r < 10) &&
        (s > 0 && s < 10)) {
      if ((p + q == r1) && (r + s == r2) && (p + r == c1) && (q + s == c2) &&
          (p + s == d1) && (q + r == d2)) {
        cout << p << " " << q << endl << r << " " << s;
      } else
        cout << -1;
    } else
      cout << -1;
  } else
    cout << -1;
  return 0;
}
