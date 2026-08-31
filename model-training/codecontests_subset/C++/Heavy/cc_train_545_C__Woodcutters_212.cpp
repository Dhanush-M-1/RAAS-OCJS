#include <bits/stdc++.h>
using namespace std;
const long long INF = 1000000007;
const int N = 2e5 + 10;
const double eps = 1e-6;
int dp[N][3];
long long x[N];
long long h[N];
int main() {
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) cin >> x[i] >> h[i];
  memset((dp), (0), sizeof(dp));
  dp[0][1] = 1;
  dp[0][2] = 1;
  for (int i = 1; i < n; i++) {
    if (x[i - 1] + h[i - 1] >= x[i]) {
      dp[i][2] = dp[i][0] = max(dp[i - 1][0], dp[i - 1][1]);
      dp[i][2]++;
    } else {
      dp[i][2] = dp[i][0] = max(dp[i - 1][0], max(dp[i - 1][1], dp[i - 1][2]));
      dp[i][2]++;
    }
    if (x[i - 1] + h[i] < x[i]) {
      dp[i][1] = max(dp[i - 1][0], dp[i - 1][1]);
      if (x[i - 1] + h[i - 1] + h[i] < x[i])
        dp[i][1] = max(dp[i][1], dp[i - 1][2]);
      dp[i][1]++;
    }
  }
  cout << max(dp[n - 1][0], max(dp[n - 1][1], dp[n - 1][2])) << endl;
  return 0;
}
