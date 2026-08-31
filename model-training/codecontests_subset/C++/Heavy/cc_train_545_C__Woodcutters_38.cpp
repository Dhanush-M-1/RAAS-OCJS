#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 10;
long long dp[N][2];
long long x[N], h[N];
const long long INF = 1e18;
int main() {
  ios_base::sync_with_stdio(false), cin.tie(0), cout.tie(0);
  int n;
  cin >> n;
  for (int i = 1; i <= n; ++i) cin >> x[i] >> h[i];
  x[n + 1] = INF;
  dp[1][0] = 1;
  if (x[1] + h[1] < x[2]) dp[1][1] = 1;
  for (int i = 2; i <= n; ++i) {
    dp[i][0] = max(dp[i - 1][1], dp[i - 1][0]);
    dp[i][1] = max(dp[i - 1][1], dp[i - 1][0]);
    if (x[i] - h[i] > x[i - 1])
      dp[i][0]++;
    else if (x[i] + h[i] < x[i + 1]) {
      x[i] += h[i];
      dp[i][1]++;
    }
  }
  cout << max(dp[n][1], dp[n][0]);
  return 0;
}
