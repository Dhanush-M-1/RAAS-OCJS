#include <bits/stdc++.h>
using namespace std;
int main() {
  int r1, r2, c1, c2, d1, d2;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  bool ok = 1;
  int a, b, c, d;
  if (!((d2 + r1 - c1) & 1))
    b = (d2 + r1 - c1) / 2;
  else
    ok = 0;
  if (!((d2 - r1 + c1) & 1))
    c = (d2 - r1 + c1) / 2;
  else
    ok = 0;
  a = r1 - b;
  d = c2 - b;
  if (!(a > 0 && a < 10) || !(b > 0 && b < 10) || !(c > 0 && c < 10) ||
      !(d > 0 && d < 10))
    ok = 0;
  if (a == b || c == d || a == c || a == d || b == c || b == d) ok = 0;
  if (r2 != c + d) ok = 0;
  if (d1 != a + d) ok = 0;
  if (ok)
    printf("%d %d\n%d %d\n", a, b, c, d);
  else
    puts("-1");
}
