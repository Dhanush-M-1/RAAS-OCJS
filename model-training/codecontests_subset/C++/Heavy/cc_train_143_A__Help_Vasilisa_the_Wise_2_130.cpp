#include <bits/stdc++.h>
using namespace std;
int main() {
  int r1, r2, c1, c2, d1, d2;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  int a, b, c, d;
  if ((c1 + r1 - d2) % 2 != 0 || (c1 + r1 - d2) / 2 > 9 ||
      (c1 + r1 - d2) / 2 < 1) {
    cout << -1 << endl;
    return 0;
  } else {
    a = (c1 + r1 - d2) / 2;
  }
  if ((r1 - a) > 9 || (r1 - a) < 1) {
    cout << -1 << endl;
    return 0;
  } else {
    b = (r1 - a);
  }
  if ((c2 - b) > 9 || (c2 - b) < 1) {
    cout << -1 << endl;
    return 0;
  } else {
    d = c2 - b;
  }
  if ((r2 - d) > 9 || (r2 - d) < 1) {
    cout << -1 << endl;
    return 0;
  } else {
    c = (r2 - d);
  }
  if ((a != b && a != c && a != d && b != c && b != d && c != d) &&
      (a + b == r1) && (c + d == r2) && (a + c == c1) && (b + d == c2) &&
      (a + d == d1) && (b + c == d2)) {
    cout << a << " " << b << endl;
    cout << c << " " << d << endl;
  } else
    cout << -1 << endl;
}
