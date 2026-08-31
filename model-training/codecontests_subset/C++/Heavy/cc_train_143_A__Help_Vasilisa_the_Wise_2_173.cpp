#include <bits/stdc++.h>
using namespace std;
int main() {
  int r1, r2, c1, c2, d1, d2;
  while (cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2) {
    int a, b, c, d;
    b = (r1 - c1 + d2) / 2;
    a = r1 - b;
    c = c1 - a;
    d = c2 - b;
    if (a + b != r1 or c + d != r2 or a + c != c1 or b + d != c2 or
        a + d != d1 or b + c != d2) {
      cout << -1 << endl;
      continue;
    }
    if (a == b || a == c or a == d or b == c or b == d or c == d or a < 1 or
        b < 1 or c < 1 or d < 1 or a > 9 or b > 9 or c > 9 or d > 9)
      cout << -1 << endl;
    else
      cout << a << ' ' << b << endl << c << ' ' << d << endl;
  }
  return 0;
}
