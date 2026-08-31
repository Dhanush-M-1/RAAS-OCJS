#include <bits/stdc++.h>
using namespace std;
int n, dp[100005][3];
pair<int, int> t[100005];
int main() {
  cin >> n;
  for (int i = 1; i <= n; i++) cin >> t[i].first >> t[i].second;
  sort(t + 1, t + n + 1);
  for (int i = 1; i <= n; i++) {
    dp[i][0] = max(dp[i - 1][0], max(dp[i - 1][1], dp[i - 1][2]));
    if (t[i - 1].first < t[i].first - t[i].second || i == 1)
      dp[i][1] = 1 + max(dp[i - 1][0], dp[i - 1][1]);
    if (t[i - 1].first + t[i - 1].second < t[i].first - t[i].second)
      dp[i][1] = max(dp[i][1], 1 + dp[i - 1][2]);
    if (t[i + 1].first > t[i].first + t[i].second || i == n)
      dp[i][2] = 1 + dp[i][0];
  }
  int ans = max(dp[n][0], max(dp[n][1], dp[n][2]));
  cout << ans;
}
