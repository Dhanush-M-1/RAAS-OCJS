#include <bits/stdc++.h>
using namespace std;
int n, m, k, mi = 1e9, x2, y2, i, j, ma = 0, ma2 = -1e9, x, y, z, nom, f, r, l,
             b[410000], d[410000], ans;
int a[5211][5211];
char c;
int main() {
  scanf("%d", &n);
  for (i = 1; i <= n; i++) {
    scanf("%c", &c);
    for (j = 1; j <= n / 4; j++) {
      scanf("%c", &c);
      if (c >= 'A' && c <= 'F')
        x = 10 + (c - 'A');
      else
        x = (c - '0');
      for (k = 1; k <= 4; k++) {
        a[i][j * 4 - k + 1] = x % 2;
        x /= 2;
      }
    }
  }
  for (i = 1; i <= n; i++) {
    for (j = 1; j <= n; j++) {
      a[i][j] += a[i - 1][j] + a[i][j - 1] - a[i - 1][j - 1];
    }
  }
  ans = 1;
  for (i = n; i >= 2; i--) {
    if (n % i == 0) {
      f = 0;
      j = i * i;
      for (x = i; x <= n; x += i) {
        for (y = i; y <= n; y += i) {
          if (a[x][y] % j != 0) {
            f = 1;
            break;
          }
        }
        if (f) break;
      }
      if (!f) {
        ans = i;
        break;
      }
    }
  }
  printf("%d", ans);
}
