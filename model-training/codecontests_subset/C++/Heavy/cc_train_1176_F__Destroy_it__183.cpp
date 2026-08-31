#include <bits/stdc++.h>
using namespace std;
int n;
long long dp[200005][15];
void Solve() {
  scanf("%d", &n);
  for (int i = 0; i <= n; i++) {
    for (int j = 0; j < 10; j++) {
      dp[i][j] = -100000000001ll;
    }
  }
  int total = 0;
  dp[0][0] = 0;
  for (int i = 1; i <= n; i++) {
    int k;
    scanf("%d", &k);
    long long a1, a2, a3, a4, a5;
    a1 = a2 = a3 = a4 = a5 = -100000000001ll;
    for (int j = 1; j <= k; j++) {
      int c;
      long long d;
      scanf("%d%I64d", &c, &d);
      if (c == 1) {
        if (d > a1) {
          a3 = a2;
          a2 = a1;
          a1 = d;
        } else if (d > a2) {
          a3 = a2;
          a2 = d;
        } else if (d > a3) {
          a3 = d;
        }
      } else if (c == 2) {
        a4 = max(a4, d);
      } else if (c == 3) {
        a5 = max(a5, d);
      }
    }
    long long dp2[4][2];
    dp2[3][0] = a1 + a2 + a3;
    dp2[3][1] = a1 + a1 + a2 + a3;
    dp2[2][0] = a1 + max(a2, a4);
    dp2[2][1] = a1 + max(a2, a4) + max(a1, max(a2, a4));
    dp2[1][0] = max(a1, max(a4, a5));
    dp2[1][1] = dp2[1][0] << 1;
    for (int j = 0; j < 10; j++) {
      if (j < 3) {
        dp[i][j] = max(dp[i][j], dp[i - 1][j + 7] + dp2[3][1]);
      } else {
        dp[i][j] = max(dp[i][j], dp[i - 1][j - 3] + dp2[3][0]);
      }
      if (j < 2) {
        dp[i][j] = max(dp[i][j], dp[i - 1][j + 8] + dp2[2][1]);
      } else {
        dp[i][j] = max(dp[i][j], dp[i - 1][j - 2] + dp2[2][0]);
      }
      if (j < 1) {
        dp[i][j] = max(dp[i][j], dp[i - 1][j + 9] + dp2[1][1]);
      } else {
        dp[i][j] = max(dp[i][j], dp[i - 1][j - 1] + dp2[1][0]);
      }
      dp[i][j] = max(dp[i][j], dp[i - 1][j]);
    }
  }
  long long ans = 0;
  for (int i = 0; i < 10; i++) {
    ans = max(ans, dp[n][i]);
  }
  printf("%I64d", ans);
}
int main() {
  Solve();
  return 0;
}
