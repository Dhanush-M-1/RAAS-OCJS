#include <bits/stdc++.h>
using namespace std;
int a[105], dp[105][10005], b[105];
int np, t, n, i, j, k, sy, v;
int main() {
  scanf("%d", &n);
  for (i = 1; i <= n; i++) {
    scanf("%d", &a[i]);
    sy += a[i];
  }
  for (i = 1; i <= n; i++) {
    scanf("%d", &b[i]);
    v += b[i];
  }
  memset(dp, -1, sizeof(dp));
  dp[0][0] = 0;
  for (i = 1; i <= n; i++) {
    for (j = n; j >= 1; j--) {
      for (k = v; k >= b[i]; k--)
        if (dp[j - 1][k - b[i]] != -1)
          dp[j][k] = max(dp[j][k], dp[j - 1][k - b[i]] + a[i]);
    }
  }
  t = -1;
  for (i = 1; i <= n; i++) {
    for (j = sy; j <= v; j++) t = max(t, dp[i][j]);
    if (t != -1) {
      printf("%d %d", i, sy - t);
      break;
    }
  }
  return 0;
}
