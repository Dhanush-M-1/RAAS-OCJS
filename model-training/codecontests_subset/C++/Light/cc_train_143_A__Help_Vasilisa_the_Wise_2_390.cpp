#include <bits/stdc++.h>
using namespace std;
int main() {
  int r1, r2, c1, c2, d1, d2;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  int a, b, c, d;
  c = (c1 + r2 - d1) / 2;
  a = c1 - c;
  b = r1 - a;
  d = r2 - c;
  if ((c1 + r2 - d1) % 2 == 0)
    if (a != b and a != c and a != d and b != c and b != d and c != d)
      if (a < 10 and b < 10 and c < 10 and d < 10)
        if (a > 0 and b > 0 and c > 0 and d > 0) {
          cout << a << " " << b << endl << c << " " << d << endl;
          return 0;
        }
  cout << -1 << endl;
  return 0;
}
