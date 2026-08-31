#include <bits/stdc++.h>
using namespace std;
int n;
long long x[100005], h[100005];
int dp[100005][4];
int main() {
  memset(dp, -1, sizeof dp);
  scanf("%d", &n);
  for (int i = 1; i <= n; ++i) {
    scanf("%lld %lld", &x[i], &h[i]);
  }
  x[n + 1] = 1000000000000;
  dp[1][1] = 1;
  dp[1][2] = 1;
  dp[1][3] = 1;
  for (int i = 2; i <= n; ++i) {
    if (x[i] + h[i] < x[i + 1]) {
      dp[i][3] = max(dp[i - 1][1], max(dp[i - 1][2], dp[i - 1][3])) + 1;
    } else
      dp[i][3] = max(dp[i - 1][1], max(dp[i - 1][2], dp[i - 1][3]));
    if (x[i] - h[i] > x[i - 1]) {
      dp[i][1] = max(dp[i - 1][2] + 1, dp[i - 1][1] + 1);
      if (x[i] - h[i] > x[i - 1] + h[i - 1])
        dp[i][1] = max(dp[i - 1][3] + 1, dp[i][1]);
    } else
      dp[i][1] = max(dp[i - 1][1], max(dp[i - 1][2], dp[i - 1][3]));
    dp[i][2] = max(dp[i - 1][1], max(dp[i - 1][2], dp[i - 1][3]));
  }
  printf("%d\n", dp[n][3]);
  return 0;
}
