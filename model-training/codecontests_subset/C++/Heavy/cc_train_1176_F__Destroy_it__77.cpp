#include <bits/stdc++.h>
using namespace std;
long long dp[200005][10], mx1, mx2, mx3, mx4, mx5;
int n, m;
int main() {
  memset(dp, -60, sizeof(dp));
  dp[0][0] = 0;
  scanf("%d", &n);
  for (int i = 1; i <= n; ++i) {
    scanf("%d", &m);
    mx1 = mx2 = mx3 = mx4 = mx5 = 0;
    for (int j = 1; j <= m; ++j) {
      int opt;
      long long v;
      scanf("%d%lld", &opt, &v);
      if (opt == 1) {
        if (v >= mx1)
          mx3 = mx2, mx2 = mx1, mx1 = v;
        else if (v >= mx2)
          mx3 = mx2, mx2 = v;
        else if (v >= mx3)
          mx3 = v;
      } else if (opt == 2)
        mx4 = max(mx4, v);
      else if (opt == 3)
        mx5 = max(mx5, v);
    }
    for (int j = 0; j <= 9; ++j) dp[i][j] = dp[i - 1][j];
    for (int j = 1; j <= 3; ++j) {
      for (int k = 0; k <= 9; ++k) {
        if (j == 1 && dp[i - 1][k] >= 0) {
          if (mx1)
            dp[i][(k + 1) % 10] =
                max(dp[i][(k + 1) % 10], dp[i - 1][k] + mx1 * (1 + (k == 9)));
        } else if (j == 2 && dp[i - 1][k] >= 0) {
          if (mx1 && mx2) {
            dp[i][(k + 2) % 10] = max(
                dp[i][(k + 2) % 10], dp[i - 1][k] + mx1 * (1 + (k >= 8)) + mx2);
          }
          if (mx4) {
            dp[i][(k + 1) % 10] =
                max(dp[i][(k + 1) % 10], dp[i - 1][k] + mx4 * (1 + (k == 9)));
          }
        } else if (j == 3 && dp[i - 1][k] >= 0) {
          if (mx1 && mx2 && mx3) {
            dp[i][(k + 3) % 10] =
                max(dp[i][(k + 3) % 10],
                    dp[i - 1][k] + mx1 * (1 + (k >= 7)) + mx2 + mx3);
          }
          if (mx1 && mx4) {
            dp[i][(k + 2) % 10] = max(
                dp[i][(k + 2) % 10],
                dp[i - 1][k] + max(mx1, mx4) * (1 + (k >= 8)) + min(mx1, mx4));
          }
          if (mx5) {
            dp[i][(k + 1) % 10] =
                max(dp[i][(k + 1) % 10], dp[i - 1][k] + mx5 * (1 + (k >= 9)));
          }
        }
      }
    }
  }
  long long ans = 0;
  for (int i = 0; i <= 9; ++i) ans = max(ans, dp[n][i]);
  printf("%lld\n", ans);
  return 0;
}
