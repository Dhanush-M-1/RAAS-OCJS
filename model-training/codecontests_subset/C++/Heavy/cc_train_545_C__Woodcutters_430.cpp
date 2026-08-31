#include <bits/stdc++.h>
using namespace std;
long long n, dp[100001][2], x[100001], h[100001];
int main() {
  cin >> n;
  for (int i = 1; i <= n; i++) cin >> x[i] >> h[i];
  dp[1][0] = 1;
  if (x[1] + h[1] < x[2]) dp[1][1] = 1;
  x[n + 1] = 1000000000000009;
  for (int i = 2; i <= n; i++) {
    dp[i][0] = max(dp[i - 1][0], dp[i - 1][1]);
    dp[i][1] = max(dp[i - 1][0], dp[i - 1][1]);
    if (x[i] - h[i] > x[i - 1]) dp[i][0] = max(dp[i][0], dp[i - 1][0] + 1);
    if (x[i] - h[i] > x[i - 1] + h[i - 1])
      dp[i][0] = max(dp[i][0], dp[i - 1][1] + 1);
    if (x[i] + h[i] < x[i + 1]) dp[i][1] = max(dp[i][1], dp[i - 1][0] + 1);
    if (x[i - 1] + h[i - 1] < x[i] && x[i] + h[i] < x[i + 1])
      dp[i][1] = max(dp[i][1], dp[i - 1][1] + 1);
  }
  cout << max(dp[n][0], dp[n][1]) << endl;
  return 0;
}
