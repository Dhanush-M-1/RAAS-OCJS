#include <bits/stdc++.h>
using namespace std;
int main() {
  long long xa, ya, xb, yb, xc, yc, dx, dy, a, b, c;
  cin >> xa >> ya;
  cin >> xb >> yb;
  cin >> xc >> yc;
  for (int i = 0; i < 4; i++) {
    dx = xb - xa, dy = yb - ya;
    a = dx * xc + dy * yc;
    b = dx * yc - dy * xc;
    c = xc * xc + yc * yc;
    if (dx == 0 && dy == 0) {
      puts("YES");
      return 0;
    }
    if (c != 0 && a % c == 0 && b % c == 0) {
      puts("YES");
      return 0;
    }
    xa = -xa;
    swap(xa, ya);
  }
  puts("NO");
  return 0;
}
