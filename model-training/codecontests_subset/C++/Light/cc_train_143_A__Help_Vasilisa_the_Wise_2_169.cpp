#include <bits/stdc++.h>
using namespace std;
int main() {
  int r1, r2, c1, c2, d1, d2;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  int a, b, c, d;
  a = (r1 + c1 - d2);
  b = (r1 + c2 - d1);
  c = (c1 + r2 - d1);
  d = (r2 + c2 - d2);
  if (((a % 2 - 1) * (b % 2 - 1) * (c % 2 - 1) * (d % 2 - 1) != 0) && a > 0 &&
      a < 19 && b > 0 && b < 19 && c > 0 && c < 19 && d > 0 && d < 19 &&
      (a - b) * (c - d) * (a - c) * (a - d) * (b - d) * (b - c) != 0)
    cout << a / 2 << " " << b / 2 << "\n" << c / 2 << " " << d / 2;
  else
    cout << -1;
  return 0;
}
