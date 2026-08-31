#include <bits/stdc++.h>
using namespace std;
long long dp[3][30010];
int main() {
  int i, n, m, j, a, b, c;
  while (scanf("%d%d%d%d", &n, &a, &b, &c) != EOF) {
    n *= 2;
    memset(dp, 0, sizeof(dp));
    for (i = 1; i <= a; i++) dp[0][i] = 1;
    dp[0][0] = 1;
    for (i = 1; i <= b; i++)
      for (j = n; j >= i * 2; j--) dp[1][j] += dp[0][j - i * 2];
    for (i = 0; i <= n; i++) dp[1][i] += dp[0][i];
    for (i = 0; i <= n; i++) dp[2][i] = dp[1][i];
    for (i = 1; i <= c; i++)
      for (j = n; j >= i * 4; j--) dp[2][j] += dp[1][j - i * 4];
    cout << dp[2][n] << endl;
  }
  return 0;
}
