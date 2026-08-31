#include <bits/stdc++.h>
using namespace std;
const int mx = 1e2 + 10;
int a[mx], b[mx], n;
int dp[mx][mx * mx];
int main() {
  scanf("%d", &n);
  int sum = 0, ret = 0;
  memset(dp, 0, sizeof(dp));
  for (int i = 1; i <= n; i++) scanf("%d", a + i), sum += a[i];
  for (int i = 1; i <= n; i++) scanf("%d", b + i), ret += b[i];
  for (int i = 1; i <= n; i++) {
    for (int j = i; j >= 1; j--) {
      for (int k = ret; k > 0; k--) {
        if (dp[j - 1][k])
          dp[j][k + b[i]] = max(dp[j][k + b[i]], dp[j - 1][k] + a[i]);
      }
      if (j == 1) dp[j][b[i]] = max(dp[j][b[i]], a[i]);
    }
  }
  for (int i = 1; i <= n; i++)
    for (int j = ret - 1; j > 0; j--) dp[i][j] = max(dp[i][j], dp[i][j + 1]);
  for (int i = 1; i <= n; i++) {
    if (dp[i][sum]) {
      printf("%d %d\n", i, sum - dp[i][sum]);
      break;
    }
  }
  return 0;
}
