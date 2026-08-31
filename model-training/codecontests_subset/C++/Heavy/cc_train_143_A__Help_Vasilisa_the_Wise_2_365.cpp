#include <bits/stdc++.h>
using namespace std;
int x[41];
int main() {
  int a, b, c, d, r1, r2, c1, c2, d1, d2, i, l, m;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  l = d1 + d2;
  m = r1 + r2 + c1 + c2;
  if (2 * l != m)
    cout << "-1", exit(0);
  else {
    a = (c1 + r1 - d2) / 2;
    b = c2 + d2 - r2, b = b / 2;
    c = c1 - a;
    d = c2 - b;
    x[a]++;
    x[b]++;
    x[c]++;
    x[d]++;
    for (i = 0; i <= 40; i++) {
      if (x[i] > 1) cout << "-1", exit(0);
    }
    if (a > 0 && a < 10 && b > 0 && b < 10 && c > 0 && c < 10 && d > 0 &&
        d < 10) {
      cout << a << " " << b << "\n";
      cout << c << " " << d;
    } else
      cout << "-1";
  }
  return 0;
}
