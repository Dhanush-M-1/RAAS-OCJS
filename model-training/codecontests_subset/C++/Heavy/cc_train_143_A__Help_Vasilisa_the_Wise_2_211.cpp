#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int a, b, c, d, e, f, g, i, j, k, t, x, y, z, m, n;
  int flag = 0;
  cin >> a >> b >> c >> d >> e >> f;
  for (x = 1; x < 10; x++) {
    for (y = 1; y < 10; y++) {
      for (m = 1; m < 10; m++) {
        for (n = 1; n < 10; n++) {
          if (x + y == a && m + n == b && x + m == c && y + n == d &&
              x + n == e && y + m == f && x != y && x != m && x != n &&
              y != m && y != n && m != n) {
            cout << x << " " << y << endl << m << " " << n;
            flag = 1;
          }
        }
      }
    }
  }
  if (flag == 0) cout << -1;
  return 0;
}
