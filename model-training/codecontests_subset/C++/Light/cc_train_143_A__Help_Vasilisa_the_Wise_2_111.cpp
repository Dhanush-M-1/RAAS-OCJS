#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c, d;
  int r1, r2, c1, c2, d1, d2;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  b = (r2 - c1 + d1) / 2;
  a = r2 - b;
  c = c2 - b;
  d = d1 - b;
  if (a != b && a != c && a != d && b != c && b != d && c != d && a > 0 &&
      a <= 9 && b > 0 && b <= 9 && c > 0 && c <= 9 && d > 0 && d <= 9 &&
      a + c == d2) {
    cout << d << " " << c << endl;
    cout << a << " " << b << endl;
  } else
    cout << -1;
  return 0;
}
