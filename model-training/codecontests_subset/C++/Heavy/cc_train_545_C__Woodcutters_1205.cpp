#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  long long int pos[n], ht[n];
  long long int dp[n][3];
  for (int i = 0; i < n; i++) {
    cin >> pos[i] >> ht[i];
  }
  dp[0][0] = 1;
  dp[0][1] = 1;
  dp[0][2] = 0;
  for (int i = 1; i < n; i++) {
    dp[i][0] = 0;
    dp[i][1] = 0;
    dp[i][2] = 0;
    if (pos[i - 1] < pos[i] - ht[i])
      dp[i][0] = max(dp[i][0], max(1 + dp[i - 1][0], 1 + dp[i - 1][2]));
    if (pos[i - 1] + ht[i - 1] < pos[i] - ht[i])
      dp[i][0] = max(dp[i][0], 1 + dp[i - 1][1]);
    if (pos[i - 1] < pos[i])
      dp[i][1] = max(dp[i][1], max(1 + dp[i - 1][0], 1 + dp[i - 1][2]));
    if (pos[i - 1] + ht[i - 1] < pos[i])
      dp[i][1] = max(dp[i][1], 1 + dp[i - 1][1]);
    if (pos[i - 1] < pos[i])
      dp[i][2] = max(dp[i][2], max(dp[i - 1][0], dp[i - 1][2]));
    if (pos[i - 1] + ht[i - 1] < pos[i]) dp[i][2] = max(dp[i][2], dp[i - 1][1]);
  }
  cout << max(dp[n - 1][0], max(dp[n - 1][1], dp[n - 1][2]));
}
