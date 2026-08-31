#include <bits/stdc++.h>
using namespace std;
int dp[110000][3];
long long dist[110000], ht[110000];
int main() {
  int n;
  cin >> n;
  dp[0][0] = dp[0][1] = dp[0][2] = 0;
  dist[0] = -1e10;
  ht[0] = 0;
  dist[n + 1] = 1e10;
  ht[n + 1] = 0;
  for (int i = 1; i <= n; i++) cin >> dist[i] >> ht[i];
  for (int i = 1; i <= n; i++) {
    int mx = max(dp[i - 1][0], dp[i - 1][1]);
    mx = max(mx, dp[i - 1][2]);
    if (dist[i] + ht[i] < dist[i + 1])
      dp[i][2] = mx + 1;
    else if (dist[i] + ht[i] >= dist[i + 1])
      dp[i][2] = 0;
    dp[i][1] = mx;
    if (dist[i] - ht[i] > dist[i - 1])
      dp[i][0] = max(dp[i - 1][1], dp[i - 1][0]) + 1;
    if (dist[i] - ht[i] > dist[i - 1] + ht[i - 1])
      dp[i][0] = max(dp[i][0], dp[i - 1][2] + 1);
  }
  int ans = max(dp[n][0], dp[n][1]);
  cout << max(ans, dp[n][2]);
  return 0;
}
