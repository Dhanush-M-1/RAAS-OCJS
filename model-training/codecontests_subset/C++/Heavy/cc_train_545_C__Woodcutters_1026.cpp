#include <bits/stdc++.h>
using namespace std;
int a[100005];
int h[100005];
int dp[100005][3];
int main() {
  int n;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> a[i] >> h[i];
  }
  for (int i = n; i >= 1; i--) {
    if (i == 1 || a[i - 1] < a[i] - h[i]) {
      if (h[i + 1] >= a[i + 1] - a[i])
        dp[i][1] = max(1 + dp[i + 1][0], 1 + dp[i + 1][2]);
      else
        dp[i][1] = 1 + dp[i + 1][1];
    } else
      dp[i][1] = -1000000000;
    if (i == n || a[i + 1] > a[i] + h[i]) {
      if (a[i + 1] - h[i + 1] > a[i] + h[i])
        dp[i][2] = 1 + dp[i + 1][1];
      else
        dp[i][2] = max(1 + dp[i + 1][0], 1 + dp[i + 1][2]);
    } else
      dp[i][2] = -1000000000;
    if (a[i] < a[i + 1] - h[i + 1])
      dp[i][0] = dp[i + 1][1];
    else
      dp[i][0] = max(dp[i + 1][0], dp[i + 1][2]);
  }
  cout << dp[1][1];
  return 0;
}
