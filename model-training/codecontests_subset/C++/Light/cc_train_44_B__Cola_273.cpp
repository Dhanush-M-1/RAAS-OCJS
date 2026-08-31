#include <bits/stdc++.h>
using namespace std;
int dp[4][2 * 10005];
int num[4];
int l[4] = {0, 1, 2, 4};
int main() {
  int n;
  while (scanf("%d", &n) == 1) {
    for (int i = 1; i <= 3; i++) scanf("%d", num + i);
    memset(dp, 0, sizeof(dp));
    dp[1][0] = 1;
    dp[2][0] = 1;
    for (int i = 1; i <= num[1]; i++) dp[1][i] = 1;
    for (int i = 2; i <= 3; i++) {
      for (int j = 1; j <= 2 * n; j++) {
        for (int k = 0; k <= num[i] && k * l[i] <= j; k++)
          dp[i][j] += dp[i - 1][j - k * l[i]];
      }
    }
    cout << dp[3][2 * n] << endl;
  }
  return 0;
}
