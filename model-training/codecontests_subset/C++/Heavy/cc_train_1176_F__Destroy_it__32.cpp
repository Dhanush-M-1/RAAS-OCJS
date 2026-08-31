#include <bits/stdc++.h>
using namespace std;
int n, k, c[200010], d[200010];
long long f[200010][12], ans, g[5][5], h[12];
int main() {
  memset(f, 0xc0, sizeof f);
  f[0][0] = 0;
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &k);
    memset(g, 0xc0, sizeof g);
    memset(h, 0xc0, sizeof h);
    for (int j = 1; j <= k; j++) {
      scanf("%d%d", &c[j], &d[j]);
      if (c[j] == 1) {
        if (d[j] > g[1][1]) {
          g[1][3] = g[1][2];
          g[1][2] = g[1][1];
          g[1][1] = d[j];
        } else if (d[j] > g[1][2]) {
          g[1][3] = g[1][2];
          g[1][2] = d[j];
        } else if (d[j] > g[1][3])
          g[1][3] = d[j];
      } else if (c[j] == 2) {
        if (d[j] > g[2][1]) g[2][1] = d[j];
      } else {
        if (d[j] > g[3][1]) g[3][1] = d[j];
      }
      for (int l = 0; l < 10; l++) {
        if (f[i - 1][l] < 0) continue;
        if (g[1][1] > 0) {
          if (g[1][2] > 0) {
            if (g[1][3] > 0) {
              if (l > 6)
                h[l - 7] = max(
                    h[l - 7], f[i - 1][l] + (g[1][1] << 1) + g[1][2] + g[1][3]);
              else
                h[l + 3] =
                    max(h[l + 3], f[i - 1][l] + g[1][1] + g[1][2] + g[1][3]);
            }
            if (l > 7)
              h[l - 8] = max(h[l - 8], f[i - 1][l] + (g[1][1] << 1) + g[1][2]);
            else
              h[l + 2] = max(h[l + 2], f[i - 1][l] + g[1][1] + g[1][2]);
          }
          if (g[2][1] > 0) {
            if (l > 7)
              h[l - 8] = max(h[l - 8], f[i - 1][l] + g[1][1] + g[2][1] +
                                           max(g[1][1], g[2][1]));
            else
              h[l + 2] = max(h[l + 2], f[i - 1][l] + g[1][1] + g[2][1]);
          }
          if (l > 8)
            h[l - 9] = max(h[l - 9], f[i - 1][l] + (g[1][1] << 1));
          else
            h[l + 1] = max(h[l + 1], f[i - 1][l] + g[1][1]);
        }
        if (g[2][1] > 0) {
          if (l > 8)
            h[l - 9] = max(h[l - 9], f[i - 1][l] + (g[2][1] << 1));
          else
            h[l + 1] = max(h[l + 1], f[i - 1][l] + g[2][1]);
        }
        if (g[3][1] > 0) {
          if (l > 8)
            h[l - 9] = max(h[l - 9], f[i - 1][l] + (g[3][1] << 1));
          else
            h[l + 1] = max(h[l + 1], f[i - 1][l] + g[3][1]);
        }
      }
    }
    for (int j = 0; j < 10; j++) {
      f[i][j] = max(h[j], f[i - 1][j]);
    }
  }
  for (int i = 0; i < 10; i++) ans = max(ans, f[n][i]);
  printf("%lld\n", ans);
  return 0;
}
