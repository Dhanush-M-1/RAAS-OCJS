#include <bits/stdc++.h>
using namespace std;
int main() {
  int n = 0, i = 0;
  cin >> n;
  int x[n + 1], h[n + 1], dp[n + 1][3];
  for (i = 1; i <= n; i++) {
    cin >> x[i] >> h[i];
  }
  x[0] = -2000000000;
  h[0] = 0;
  dp[0][0] = dp[0][1] = dp[0][2] = 0;
  for (i = 1; i <= n; i++) {
    dp[i][0] = 0;
    if (x[i] - h[i] > x[i - 1]) {
      dp[i][0] = max(dp[i - 1][0] + 1, dp[i - 1][1] + 1);
    }
    if (x[i] - h[i] > x[i - 1] + h[i - 1]) {
      dp[i][0] = max(dp[i][0], dp[i - 1][2] + 1);
    }
    dp[i][1] = max(dp[i - 1][0], dp[i - 1][1]);
    if (x[i] > x[i - 1] + h[i - 1]) {
      dp[i][1] = max(dp[i][1], dp[i - 1][2]);
    }
    dp[i][2] = max(dp[i - 1][0] + 1, dp[i - 1][1] + 1);
    if (x[i] > x[i - 1] + h[i - 1]) {
      dp[i][2] = max(dp[i][2], dp[i - 1][2] + 1);
    }
  }
  cout << max(max(dp[n][0], dp[n][1]), dp[n][2]);
  return 0;
}
