#include <bits/stdc++.h>
using namespace std;
int n;
int a[105], b[105], sum;
int f[105][105 * 105], g[105][105 * 105];
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) scanf("%d", &a[i]);
  for (int i = 1; i <= n; i++) scanf("%d", &b[i]);
  memset(f, 0x3f, sizeof(f));
  f[0][0] = 0;
  for (int i = 1; i <= n; i++) {
    sum += a[i];
    for (int j = 0; j < 105 * 105; j++) {
      f[i][j] = f[i - 1][j];
      g[i][j] = g[i - 1][j];
      if (j - b[i] >= 0) {
        if (f[i][j] > f[i - 1][j - b[i]] + 1) {
          f[i][j] = f[i - 1][j - b[i]] + 1;
          g[i][j] = g[i - 1][j - b[i]] + a[i];
        } else if (f[i][j] == f[i - 1][j - b[i]] + 1) {
          g[i][j] = max(g[i][j], g[i - 1][j - b[i]] + a[i]);
        }
      }
    }
  }
  int x = 1e9, y = 0;
  for (int i = sum; i < 105 * 105; i++) {
    if (f[n][i] < x) {
      x = f[n][i], y = g[n][i];
    } else if (f[n][i] == x) {
      y = max(y, g[n][i]);
    }
  }
  printf("%d %d", x, sum - y);
}
