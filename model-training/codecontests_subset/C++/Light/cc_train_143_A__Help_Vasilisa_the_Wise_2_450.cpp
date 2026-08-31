#include <bits/stdc++.h>
using namespace std;
int main() {
  int r1, r2, c1, c2, d1, d2;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  int a, b, c, d;
  a = (d1 + c1 - r2) / 2;
  b = r1 - a;
  c = c1 - a;
  d = c2 - b;
  if (a != b && a != c && a != d && b != c && b != d && c != d && a <= 9 &&
      b <= 9 && c <= 9 && d <= 9 && a + d == d1 && b + c == d2 && a && b && c &&
      d) {
    cout << a << " " << b << endl;
    cout << c << " " << d << endl;
  } else
    cout << -1;
  return 0;
}
