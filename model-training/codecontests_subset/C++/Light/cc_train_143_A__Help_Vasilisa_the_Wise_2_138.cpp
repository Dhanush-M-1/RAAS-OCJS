#include <bits/stdc++.h>
using namespace std;
int main() {
  int r1, r2, c1, c2, d1, d2;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  int a, b, c, d, m = 1;
  for (int i = 1; i < 10; i++) {
    a = i;
    b = r1 - a;
    d = d1 - a;
    c = c1 - a;
    if (b != a && b != c && b != d && c != d && c != a && d != a && a < 10 &&
        b < 10 && c < 10 && d < 10 && a > 0 && b > 0 && c > 0 && d > 0) {
      if (r2 == c + d && c2 == b + d && d2 == b + c) {
        break;
      }
    }
    m++;
  }
  if (a < 0 || b < 0 || c < 0 || d < 0 || m >= 10) {
    cout << "-1";
  } else
    cout << a << " " << b << endl << c << " " << d;
  return 0;
}
