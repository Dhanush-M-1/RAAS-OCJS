#include <bits/stdc++.h>
using namespace std;
int main() {
  int r1, r2, c1, c2, d1, d2;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  int a, b, c, d;
  a = (r1 + c1 - d2) / 2;
  b = r1 - a;
  c = d2 - b;
  d = r2 - c;
  int x = c1 + c2 - d1 - d2;
  int y = d1 + d2 - r1 - r2;
  if (a <= 0 || b <= 0 || c <= 0 || d <= 0 || a == b || b == c || c == d ||
      d == a || a == c || b == d || a > 9 || b > 9 || c > 9 || d > 9 || x < 0 ||
      y < 0)
    cout << "-1";
  else
    cout << a << " " << b << "\n" << c << " " << d;
  return 0;
}
