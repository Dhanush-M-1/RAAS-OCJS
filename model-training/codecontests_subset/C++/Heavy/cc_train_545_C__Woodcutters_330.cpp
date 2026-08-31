#include <bits/stdc++.h>
using namespace std;
int main() {
  std::ios::sync_with_stdio(false);
  long long x[123456] = {0}, h[123456] = {0}, dp[123456][3] = {0};
  long long n, ans = 0;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> x[i] >> h[i];
  }
  x[0] = x[1] - h[1] - 1;
  x[n + 1] = x[n] + h[n] + 1;
  for (int i = 1; i <= n; i++) {
    dp[i][0] = max(dp[i - 1][0], max(dp[i - 1][1], dp[i - 1][2]));
    dp[i][1] = dp[i][2] = -1;
    if (x[i] - h[i] > x[i - 1]) dp[i][1] = max(dp[i - 1][0], dp[i - 1][1]) + 1;
    if (x[i] - h[i] > x[i - 1] + h[i - 1])
      dp[i][1] = max(dp[i][1], dp[i - 1][2] + 1);
    if (x[i] + h[i] < x[i + 1]) {
      dp[i][2] = max(dp[i - 1][0], dp[i - 1][1]) + 1;
      if (x[i - 1] + h[i - 1] < x[i])
        dp[i][2] = max(dp[i][2], dp[i - 1][2] + 1);
    }
    ans = max(ans, max(dp[i][0], max(dp[i][1], dp[i][2])));
  }
  cout << ans << endl;
}
