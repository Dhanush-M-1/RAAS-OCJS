#include <bits/stdc++.h>
using namespace std;
int main() {
  int r1, r2, c1, c2, d1, d2;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  int a = (d1 + c1 - r2) / 2;
  int b = (d2 + c2 - r2) / 2;
  int c = c1 - a;
  int d = c2 - b;
  int x = 0;
  if (a + b == r1) x++;
  if (c + d == r2) x++;
  if (a + c == c1) x++;
  if (b + d == c2) x++;
  if (a + d == d1) x++;
  if (b + c == d2) x++;
  int p = min({a, b, c, d});
  int q = max({a, b, c, d});
  if (p < 1 || q > 9) {
    cout << "-1" << endl;
    return 0;
  }
  if (x != 6 || a == b || b == c || c == d || d == a || a == c || b == d)
    cout << "-1" << endl;
  else {
    cout << a << " " << b << endl;
    cout << c << " " << d << endl;
  }
  return 0;
}
