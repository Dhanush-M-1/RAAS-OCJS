#include <bits/stdc++.h>
using namespace std;
long long dp[100001][3], a[100001], h[100001];
int main() {
  int n, i;
  cin >> n;
  for (i = 0; i < n; i++) cin >> a[i] >> h[i];
  if (n == 1) {
    cout << 1 << endl;
    return 0;
  }
  dp[0][2] = 0;
  dp[0][0] = 1;
  if (a[1] - h[0] > a[0]) dp[0][1] = 1;
  for (i = 1; i < n; i++) {
    dp[i][2] = max(dp[i - 1][0], max(dp[i - 1][1], dp[i - 1][2]));
    if (a[i - 1] + h[i] < a[i]) {
      dp[i][0] = max(dp[i - 1][0], dp[i - 1][2]) + 1;
      if (a[i - 1] + h[i - 1] + h[i] < a[i])
        dp[i][0] = max(dp[i][0], dp[i - 1][1] + 1);
    }
    if (i == n - 1 || a[i] + h[i] < a[i + 1])
      dp[i][1] = max(dp[i - 1][0], max(dp[i - 1][1], dp[i - 1][2])) + 1;
  }
  cout << dp[n - 1][1] << endl;
}
