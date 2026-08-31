#include <bits/stdc++.h>
using namespace std;
int dp[100500][3];
int x[100500];
int h[100500];
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 0; i < n; i++) scanf("%d%d", x + i, h + i);
  for (int i = 0; i < n; i++) {
    if (i == 0) {
      dp[i][0] = 1;
      if (x[i] + h[i] < x[i + 1]) dp[i][2] = 1;
    } else {
      if (x[i - 1] < x[i] - h[i])
        dp[i][0] = max(dp[i - 1][0], dp[i - 1][1]) + 1;
      if (x[i - 1] + h[i - 1] < x[i] - h[i])
        dp[i][0] = max(dp[i][0], dp[i - 1][2] + 1);
      dp[i][1] = max(dp[i - 1][0], max(dp[i - 1][1], dp[i - 1][2]));
      if (x[i + 1] > x[i] + h[i])
        dp[i][2] = max(dp[i - 1][0], max(dp[i - 1][1], dp[i - 1][2])) + 1;
    }
  }
  dp[n - 1][2] = max(dp[n - 2][0], max(dp[n - 2][1], dp[n - 2][2])) + 1;
  cout << max(dp[n - 1][0], max(dp[n - 1][1], dp[n - 1][2]));
  return 0;
}
