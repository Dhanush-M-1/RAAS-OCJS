#include <bits/stdc++.h>
using namespace std;
signed main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n;
  cin >> n;
  vector<pair<int, int>> a(n);
  for (auto& x : a) cin >> x.first >> x.second;
  vector<vector<int>> dp(n, vector<int>(3));
  dp[0][0] = 0;
  dp[0][1] = 1;
  dp[0][2] = (a[0].first + a[0].second < a[1].first);
  for (int i = 1; i < n; ++i) {
    dp[i][0] = max(max(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][2]);
    if (a[i].first - a[i].second > a[i - 1].first) {
      dp[i][1] = max(dp[i - 1][0], dp[i - 1][1]) + 1;
      if (a[i - 1].first + a[i - 1].second < a[i].first - a[i].second) {
        dp[i][1] = max(dp[i][1], dp[i - 1][2] + 1);
      }
    }
    if (i == n - 1 || a[i].first + a[i].second < a[i + 1].first) {
      dp[i][2] = dp[i][0] + 1;
    }
  }
  cout << max(max(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]);
}
