#include <bits/stdc++.h>
using namespace std;
int main() {
  int r1, r2, c1, c2, d1, d2;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  int a, b, c, d;
  a = (r1 + c1 - d2);
  if (a % 2 != 0) {
    cout << "-1" << endl;
    return 0;
  } else {
    a = a / 2;
  }
  b = r1 - a;
  c = c1 - a;
  d = c2 - b;
  if (c + d == r2 && a + d == d1 && a != b && a != c && a != d && b != c &&
      b != d && c != d && a > 0 && a < 10 && b > 0 && b < 10 && c > 0 &&
      c < 10 && d > 0 && d < 10) {
    cout << a << " " << b << endl << c << " " << d << endl;
  } else {
    cout << "-1 " << endl;
  }
  return 0;
}
