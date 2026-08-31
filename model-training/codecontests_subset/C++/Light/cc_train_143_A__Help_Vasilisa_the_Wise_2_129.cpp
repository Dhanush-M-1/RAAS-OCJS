#include <bits/stdc++.h>
using namespace std;
int main() {
  int r1, r2, d1, d2, c1, c2, a, b, c, d;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  a = (c1 + d1 - r2) / 2;
  c = c1 - a;
  b = r1 - a;
  d = r2 - c;
  if (a >= 1 && a <= 9 && b >= 1 && b <= 9 && d >= 1 && d <= 9 && c >= 1 &&
      c <= 9) {
    if (a == b || b == c || c == d || c == a || a == d || b == d) {
      cout << "-1" << endl;
    } else {
      cout << a << " " << b << endl;
      cout << c << " " << d << endl;
    }
  } else {
    cout << "-1" << endl;
  }
  return 0;
}
