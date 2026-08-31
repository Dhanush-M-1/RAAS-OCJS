#include <bits/stdc++.h>
using namespace std;
const int MOD = 1e9 + 7;
int main() {
  int n;
  cin >> n;
  int x[n], h[n];
  for (int i = 0; i < n; ++i) cin >> x[i] >> h[i];
  vector<vector<int>> dp(3, vector<int>(n, 0));
  dp[0][0] = 1, dp[1][0] = 0, dp[2][0] = 0;
  if ((n > 1 && x[0] + h[0] < x[1] || n == 1)) dp[2][0] = 1;
  for (int i = 1; i < n; ++i) {
    if (x[i] - h[i] > x[i - 1]) {
      if (x[i - 1] + h[i - 1] < x[i] - h[i])
        dp[0][i] = 1 + max({dp[0][i - 1], dp[1][i - 1], dp[2][i - 1]});
      else
        dp[0][i] = 1 + max(dp[0][i - 1], dp[1][i - 1]);
    }
    dp[1][i] = max({dp[0][i - 1], dp[1][i - 1], dp[2][i - 1]});
    if (i == n - 1 || x[i] + h[i] < x[i + 1])
      dp[2][i] = 1 + max({dp[0][i - 1], dp[1][i - 1], dp[2][i - 1]});
  }
  cout << max({dp[0][n - 1], dp[1][n - 1], dp[2][n - 1]});
  return 0;
}
