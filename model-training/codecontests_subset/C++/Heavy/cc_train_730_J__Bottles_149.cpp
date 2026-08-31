#include <bits/stdc++.h>
using namespace std;
int dp[2][105][105 * 105];
int n;
int a[105], b[105];
void solve() {
  int v = 0, soda = 0;
  for (int i = 1; i <= n; i++) {
    scanf("%d", &a[i]);
    soda += a[i];
  }
  for (int i = 1; i <= n; i++) {
    scanf("%d", &b[i]);
    v += b[i];
  }
  for (int i = 0; i <= n; i++) {
    for (int j = 0; j <= v; j++) dp[0][i][j] = dp[1][i][j] = -1e9;
  }
  int ans1 = 1e9, ans2 = 1e9;
  dp[0][0][0] = 0;
  for (int i = 1; i <= n; i++) {
    for (int j = 0; j <= n; j++) {
      for (int k = 0; k <= v; k++) dp[i & 1][j][k] = -1e9;
    }
    dp[i & 1][0][0] = 0;
    for (int j = 1; j <= n; j++) {
      for (int k = 0; k <= v; k++) {
        if (k >= b[i])
          dp[i & 1][j][k] =
              max(dp[i & 1][j][k], dp[(i + 1) & 1][j - 1][k - b[i]] + a[i]);
        dp[i & 1][j][k] = max(dp[i & 1][j][k], dp[(i + 1) & 1][j][k]);
      }
    }
    for (int j = 1; j <= n; j++) {
      for (int k = 0; k <= v; k++) {
        if (dp[i & 1][j][k] < 0) continue;
        if (k < soda) continue;
        if (j < ans1 || (j == ans1 && dp[i & 1][j][k] > ans2)) {
          ans1 = j;
          ans2 = dp[i & 1][j][k];
        }
      }
    }
  }
  printf("%d %d\n", ans1, soda - ans2);
}
int main() {
  while (scanf("%d", &n) != EOF) solve();
  return 0;
}
