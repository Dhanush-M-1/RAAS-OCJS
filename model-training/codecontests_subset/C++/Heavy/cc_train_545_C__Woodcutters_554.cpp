#include <bits/stdc++.h>
using namespace std;
void err() {
  cout << "NO\n";
  exit(0);
}
int main() {
  int n, i, j, a;
  cin >> n;
  if (n == 1 || n == 2) {
    cout << n;
    return 0;
  }
  int arr[n], ht[n];
  for (i = 0; i < n; i++) {
    cin >> arr[i];
    cin >> ht[i];
  }
  int dp[n][3];
  dp[0][0] = 1;
  dp[0][1] = -1e9;
  dp[0][2] = -1e9;
  for (i = 1; i < n - 1; i++) {
    dp[i][1] = max(max(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][2]);
    if (arr[i + 1] > arr[i] + ht[i]) {
      dp[i][2] = dp[i][1] + 1;
    } else
      dp[i][2] = -1e9;
    dp[i][0] = -1e9;
    if (arr[i - 1] < arr[i] - ht[i]) {
      dp[i][0] = max(dp[i - 1][1], dp[i - 1][0]) + 1;
      if ((arr[i - 1] + ht[i - 1]) < arr[i] - ht[i]) {
        dp[i][0] = max(dp[i - 1][2] + 1, dp[i][0]);
      }
    }
  }
  int ans = max(max(dp[n - 2][0], dp[n - 2][1]), dp[n - 2][2]);
  ans++;
  cout << ans;
  return 0;
}
