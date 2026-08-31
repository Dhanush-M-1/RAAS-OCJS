#include <bits/stdc++.h>
using namespace std;
const int MAXN = 1000 * 100 + 10;
int dp[4][MAXN];
long long int x[MAXN];
long long int h[MAXN];
long long int mod = 1000 * 1000 * 1000 + 7;
int main() {
  ios_base::sync_with_stdio(false), cin.tie(0), cout.tie(0);
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> x[i] >> h[i];
  }
  x[n] = 1e18;
  dp[0][0] = 0;
  dp[2][0] = 1;
  if (x[0] + h[0] < x[1]) dp[1][0] = 1;
  for (int i = 1; i < n; i++) {
    dp[0][i] = max(dp[0][i - 1], max(dp[1][i - 1], dp[2][i - 1]));
    if (x[i] + h[i] < x[i + 1]) {
      dp[1][i] = dp[0][i] + 1;
    }
    if (x[i] - h[i] > x[i - 1]) {
      dp[2][i] = max(dp[0][i - 1] + 1, dp[2][i - 1] + 1);
      if (x[i - 1] + h[i - 1] < x[i] - h[i])
        dp[2][i] = max(dp[2][i], dp[1][i - 1] + 1);
    }
  }
  cout << max(dp[1][n - 1], max(dp[0][n - 1], dp[2][n - 1])) << endl;
  return 0;
}
