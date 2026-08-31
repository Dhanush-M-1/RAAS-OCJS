#include <bits/stdc++.h>
using namespace std;
long long int mod = 1e9 + 7;
using namespace std::chrono;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long int n, y;
  cin >> n;
  long long int x[n], h[n];
  for (int i = 0; i < n; i++) cin >> x[i] >> h[i];
  long long int dp[n][3];
  memset(dp, 0, sizeof(dp));
  dp[0][0] = dp[0][2] = 1;
  dp[0][1] = 0;
  for (int i = 1; i < n; i++) {
    if (x[i] - h[i] > x[i - 1]) {
      dp[i][0] = max(dp[i - 1][0], dp[i - 1][1]) + 1;
      if (x[i - 1] + h[i - 1] < x[i] - h[i])
        dp[i][0] = max(dp[i][0], dp[i - 1][2] + 1);
    }
    dp[i][1] = max(dp[i - 1][0], dp[i - 1][1]);
    if (x[i - 1] + h[i - 1] < x[i]) dp[i][1] = max(dp[i][1], dp[i - 1][2]);
    if (i == n - 1)
      dp[i][2] = dp[i][1] + 1;
    else if (x[i] + h[i] < x[i + 1])
      dp[i][2] = dp[i][1] + 1;
  }
  cout << max({dp[n - 1][0], dp[n - 1][1], dp[n - 1][2]});
  return 0;
}
