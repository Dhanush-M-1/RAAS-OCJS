#include <bits/stdc++.h>
using namespace std;
long long int m, n, c, d, j, k, l, r, x, t, y, u, z, i, e, f, g, h, a = 1, b;
int main() {
  cin >> n >> a >> b >> c;
  if ((a / 2 + b + c * 2) >= n) {
    for (i = 0; i <= a; i += 2) {
      for (j = 0; j <= b; j++) {
        d = n - i / 2 - j;
        if (d < 0 || d & 1) continue;
        if (d <= c * 2) e++;
      }
    }
  }
  cout << e;
}
