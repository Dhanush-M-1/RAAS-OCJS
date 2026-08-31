#include <bits/stdc++.h>
using namespace std;
const int N = 1e5;
int n, dp[N + 1][3];
long long int arr[N + 2][2], ans;
void solve() {
  cin >> n;
  ans = 0;
  for (long long int i = 0; i < n; i++) {
    cin >> arr[i + 1][0] >> arr[i + 1][1];
    for (long long int j = 0; j < 3; j++) dp[i][j] = 0;
  }
  for (long long int j = 0; j < 3; j++) dp[n][j] = 0;
  arr[0][0] = arr[0][1] = -2e10;
  arr[n + 1][0] = 2e10;
  for (int i = 1; i <= n; i++) {
    if (arr[i - 1][0] < arr[i][0] - arr[i][1]) {
      dp[i][0] = max(dp[i - 1][0], dp[i - 1][1]) + 1;
      if (arr[i - 1][0] + arr[i - 1][1] < arr[i][0] - arr[i][1]) {
        dp[i][0] = max(dp[i][0], dp[i - 1][2] + 1);
      }
    }
    dp[i][1] = max(dp[i - 1][0], max(dp[i - 1][1], dp[i - 1][2]));
    if (arr[i][0] + arr[i][1] < arr[i + 1][0]) {
      dp[i][2] = max(dp[i - 1][0], max(dp[i - 1][1], dp[i - 1][2])) + 1;
    }
    ans = max(dp[i][0], max(dp[i][1], dp[i][2]));
  }
  cout << ans << '\n';
}
int main() {
  cin.tie(0);
  ios::sync_with_stdio(0);
  int T = 1;
  while (T--) {
    solve();
  }
  return 0;
}
