#include <bits/stdc++.h>
using namespace std;
int main() {
  int r1, r2, c1, c2, d1, d2;
  int a, b, c, d;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  a = (r1 - d2 + c1) / 2;
  b = r1 - a;
  c = c1 - a;
  d = c2 - b;
  if (a < 1 || b < 1 || c < 1 || d < 1 || a > 9 || b > 9 || c > 9 || d > 9) {
    cout << "-1";
  } else if (a == b || b == d || b == c || a == d || c == d || a == c ||
             c + d != r2) {
    cout << "-1";
  } else {
    cout << a << " " << b << "\n" << c << " " << d;
  }
  return 0;
}
