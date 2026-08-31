#include <bits/stdc++.h>
using namespace std;
long long a[100005][2];
int dp[100005][3];
enum direction {
  n,
  l,
  r,
};
int main() {
  int N;
  cin >> N;
  for (size_t i = 1; i <= N; i++) {
    cin >> a[i][0] >> a[i][1];
    dp[i][n] = dp[i][l] = dp[i][r] = 0;
  }
  a[0][0] = -1e18;
  a[0][1] = 0;
  dp[0][l] = dp[0][r] = dp[0][n] = 0;
  a[N + 1][0] = 1e18;
  a[N + 1][1] = 0;
  for (size_t i = 0; i <= N; i++) {
    if (a[i + 1][0] - a[i][0] > a[i + 1][1] + a[i][1]) {
      dp[i + 1][l] = 1 + max(max(dp[i][l], dp[i][r]), dp[i][n]);
      dp[i + 1][n] = max(max(dp[i][l], dp[i][r]), dp[i][n]);
    } else if (a[i + 1][0] - a[i][0] > a[i + 1][1]) {
      dp[i + 1][l] = 1 + max(dp[i][l], dp[i][n]);
      dp[i + 1][n] = max(dp[i][l], max(dp[i][n], dp[i][r]));
    }
    if (a[i + 2][0] - a[i + 1][0] > a[i + 2][1] + a[i + 1][1]) {
      dp[i + 1][r] = 1 + max(max(dp[i][l], dp[i][r]), dp[i][n]);
      dp[i + 1][n] = max(max(dp[i][l], dp[i][r]), dp[i][n]);
    } else if (a[i + 2][0] - a[i + 1][0] > a[i + 1][1]) {
      dp[i + 1][r] = 1 + max(dp[i][r], max(dp[i][n], dp[i][l]));
      dp[i + 1][n] = max(max(dp[i][n], dp[i][r]), dp[i][l]);
    }
    if (!(a[i + 2][0] - a[i + 1][0] > a[i + 1][1]) &&
        !(a[i + 1][0] - a[i][0] > a[i + 1][1])) {
      dp[i + 1][n] = max(max(dp[i][l], dp[i][r]), dp[i][n]);
    }
  }
  cout << max(max(dp[N][1], dp[N][0]), dp[N][2]);
}
