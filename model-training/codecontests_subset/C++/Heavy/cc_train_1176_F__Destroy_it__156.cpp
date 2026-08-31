#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 10;
long long dp[N][10];
long long num1[N][3], cnt1[N];
long long num2[N];
long long num3[N];
int k[N];
bool vis[N][10];
int main() {
  int n;
  scanf("%d", &n);
  memset(num1, 0, sizeof(num1));
  memset(num2, 0, sizeof(num2));
  memset(num3, 0, sizeof(num3));
  memset(cnt1, 0, sizeof(cnt1));
  memset(dp, 0, sizeof(dp));
  memset(vis, 0, sizeof(vis));
  for (int i = 1; i <= n; i++) {
    scanf("%d", &k[i]);
    for (int j = 1; j <= k[i]; j++) {
      int c, d;
      scanf("%d%d", &c, &d);
      if (c == 1) {
        if (d >= num1[i][0]) {
          num1[i][2] = num1[i][1];
          num1[i][1] = num1[i][0];
          num1[i][0] = d;
          cnt1[i]++;
        } else if (d >= num1[i][1]) {
          num1[i][2] = num1[i][1];
          num1[i][1] = d;
          cnt1[i]++;
        } else if (d >= num1[i][2]) {
          num1[i][2] = d;
          cnt1[i]++;
        }
      } else if (c == 2) {
        if (d > num2[i]) num2[i] = d;
      } else if (c == 3) {
        if (d > num3[i]) num3[i] = d;
      }
      if (cnt1[i] > 3) cnt1[i] = 3;
    }
  }
  vis[0][0] = true;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j <= 9; j++) {
      if (!vis[i][j]) continue;
      dp[i + 1][j] = max(dp[i + 1][j], dp[i][j]);
      vis[i + 1][j] = true;
      if (num3[i + 1] != 0) {
        if (j == 9)
          dp[i + 1][0] = max(dp[i + 1][0], dp[i][j] + 2 * num3[i + 1]);
        else
          dp[i + 1][j + 1] = max(dp[i + 1][j + 1], dp[i][j] + num3[i + 1]);
        vis[i + 1][(j + 1) % 10] = true;
      }
      if (num2[i + 1] != 0) {
        if (j == 9)
          dp[i + 1][0] = max(dp[i + 1][0], dp[i][j] + 2 * num2[i + 1]);
        else
          dp[i + 1][j + 1] = max(dp[i + 1][j + 1], dp[i][j] + num2[i + 1]);
        vis[i + 1][(j + 1) % 10] = true;
      }
      if (cnt1[i + 1] > 0) {
        if (j == 9)
          dp[i + 1][0] = max(dp[i + 1][0], dp[i][j] + 2 * num1[i + 1][0]);
        else
          dp[i + 1][j + 1] = max(dp[i + 1][j + 1], dp[i][j] + num1[i + 1][0]);
        vis[i + 1][(j + 1) % 10] = true;
      }
      if (num2[i + 1] != 0 && num1[i + 1][0] != 0) {
        int maxx = max(num2[i + 1], num1[i + 1][0]);
        if (j >= 8)
          dp[i + 1][(j + 2) % 10] =
              max(dp[i + 1][(j + 2) % 10],
                  dp[i][j] + maxx + num2[i + 1] + num1[i + 1][0]);
        else
          dp[i + 1][(j + 2) % 10] =
              max(dp[i + 1][j + 2], dp[i][j] + num2[i + 1] + num1[i + 1][0]);
        vis[i + 1][(j + 2) % 10] = true;
      }
      if (cnt1[i + 1] > 1) {
        if (j >= 8)
          dp[i + 1][(j + 2) % 10] =
              max(dp[i + 1][(j + 2) % 10],
                  dp[i][j] + 2 * num1[i + 1][0] + num1[i + 1][1]);
        else
          dp[i + 1][j + 2] =
              max(dp[i + 1][j + 2], dp[i][j] + num1[i + 1][0] + num1[i + 1][1]);
        vis[i + 1][(j + 2) % 10] = true;
      }
      if (cnt1[i + 1] > 2) {
        if (j >= 7)
          dp[i + 1][(j + 3) % 10] =
              max(dp[i + 1][(j + 3) % 10], dp[i][j] + 2 * num1[i + 1][0] +
                                               num1[i + 1][1] + num1[i + 1][2]);
        else
          dp[i + 1][(j + 3) % 10] =
              max(dp[i + 1][(j + 3) % 10],
                  dp[i][j] + num1[i + 1][0] + num1[i + 1][1] + num1[i + 1][2]);
        vis[i + 1][(j + 3) % 10] = true;
      }
    }
  }
  long long ans = 0;
  for (int i = 0; i < 10; i++) ans = max(ans, dp[n][i]);
  printf("%lld\n", ans);
  return 0;
}
