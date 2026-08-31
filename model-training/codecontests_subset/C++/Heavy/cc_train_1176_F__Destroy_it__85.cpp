#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 10;
long long q, m;
long long dp[maxn][10];
int main() {
  scanf("%I64d", &q);
  memset(dp, -1, sizeof(dp));
  dp[0][0] = 0;
  long long mmax = 0;
  int n;
  for (int i = 1; i <= q; i++) {
    scanf("%d", &n);
    if (n == 1) {
      int w, v;
      scanf("%d%d", &v, &w);
      for (int j = 0; j < 10; j++) {
        dp[i][j] = dp[i - 1][j];
        if (j == 0) {
          if (dp[i - 1][9] == -1) continue;
          dp[i][j] = max(dp[i][j], dp[i - 1][9] + 2 * w);
        } else {
          if (dp[i - 1][j - 1] == -1) continue;
          dp[i][j] = max(dp[i][j], dp[i - 1][j - 1] + w);
        }
        mmax = max(mmax, dp[i][j]);
      }
      continue;
    }
    long long d[2][4][4];
    memset(d, -1, sizeof(d));
    d[0][0][0] = 0;
    for (int k = 0; k < n; k++) {
      long long v, w;
      scanf("%I64d%I64d", &v, &w);
      for (int k1 = 2; k1 >= 0; k1--) {
        for (int k2 = 3 - v; k2 >= 0; k2--) {
          if (d[0][k1][k2] != -1) {
            d[0][k1 + 1][k2 + v] = max(d[0][k1 + 1][k2 + v], d[0][k1][k2] + w);
            d[1][k1 + 1][k2 + v] =
                max(d[1][k1 + 1][k2 + v], d[0][k1][k2] + 2 * w);
          }
          if (d[1][k1][k2] != 1) {
            d[1][k1 + 1][k2 + v] = max(d[1][k1 + 1][k2 + v], d[1][k1][k2] + w);
          }
        }
      }
    }
    for (int k = 0; k < 4; k++) {
      for (int j = 1; j < 4; j++) {
        d[0][k][0] = max(d[0][k][0], d[0][k][j]);
        d[1][k][0] = max(d[1][k][0], d[1][k][j]);
      }
    }
    for (int j = 0; j < 10; j++) {
      for (int l = 0; l <= min(3, n); l++) {
        int u = (j - l + 10) % 10;
        if (dp[i - 1][u] == -1) continue;
        if (u > j) {
          dp[i][j] = max(dp[i][j], dp[i - 1][u] + d[1][l][0]);
        } else {
          dp[i][j] = max(dp[i][j], dp[i - 1][u] + d[0][l][0]);
        }
      }
      mmax = max(mmax, dp[i][j]);
    }
  }
  printf("%I64d\n", mmax);
  return 0;
}
