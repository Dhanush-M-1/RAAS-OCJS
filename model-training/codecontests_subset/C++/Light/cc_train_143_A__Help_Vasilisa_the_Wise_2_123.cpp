#include <bits/stdc++.h>
using namespace std;
int main() {
  double a, b, c, d, x, r1, r2, c1, c2, d1, d2;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  x = d2 - c1;
  b = (r1 + x) / 2;
  a = r1 - b;
  c = d2 - b;
  d = d1 - a;
  if ((a + b) == r1 && (c + d) == r2 && (a + c) == c1 && (b + d) == c2 &&
      (a + d) == d1 && (c + b) == d2 && a > 0 && b > 0 && c > 0 && d > 0 &&
      a < 10 && b < 10 && c < 10 && d < 10 && a != b && c != d && a != c &&
      b != d && a != d && b != c)
    cout << a << ' ' << b << endl << c << ' ' << d << endl;
  else
    cout << -1 << endl;
  return 0;
}
