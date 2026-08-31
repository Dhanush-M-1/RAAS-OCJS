#include <bits/stdc++.h>
using namespace std;
const double eps = 1e-8;
const double PI = acos(-1.0);
const int Mod = 1000000007;
const int INF = 0x3f3f3f3f;
const long long LL_INF = 0x3f3f3f3f3f3f3f3f;
const int maxn = 2e5 + 10;
long long dp[maxn][10];
vector<int> v[4];
int main() {
  int n, num;
  scanf("%d", &n);
  memset(dp, -1, sizeof(dp));
  dp[0][0] = 0;
  for (int i = 1; i <= n; i++) {
    scanf("%d", &num);
    for (int j = 1; j <= 3; j++) v[j].clear();
    for (int j = 1; j <= num; j++) {
      int x, y;
      scanf("%d%d", &x, &y);
      v[x].push_back(y);
    }
    for (int j = 1; j <= 3; j++) sort(v[j].begin(), v[j].end(), greater<int>());
    for (int j = 0; j <= 9; j++) {
      dp[i][j] = dp[i - 1][j];
      if (dp[i - 1][(j - 1 + 10) % 10] != -1 && (int)v[3].size() >= 1) {
        if (j == 0)
          dp[i][j] =
              max(dp[i][j], dp[i - 1][(j - 1 + 10) % 10] + 2LL * v[3][0]);
        else
          dp[i][j] = max(dp[i][j], dp[i - 1][(j - 1 + 10) % 10] + v[3][0]);
      }
      if (dp[i - 1][(j - 1 + 10) % 10] != -1 && (int)v[1].size() >= 1) {
        if (j == 0)
          dp[i][j] =
              max(dp[i][j], dp[i - 1][(j - 1 + 10) % 10] + 2LL * v[1][0]);
        else
          dp[i][j] = max(dp[i][j], dp[i - 1][(j - 1 + 10) % 10] + v[1][0]);
      }
      if (dp[i - 1][(j - 1 + 10) % 10] != -1 && (int)v[2].size() >= 1) {
        if (j == 0)
          dp[i][j] =
              max(dp[i][j], dp[i - 1][(j - 1 + 10) % 10] + 2LL * v[2][0]);
        else
          dp[i][j] = max(dp[i][j], dp[i - 1][(j - 1 + 10) % 10] + v[2][0]);
      }
      if (dp[i - 1][(j - 2 + 10) % 10] != -1 && (int)v[1].size() >= 1 &&
          (int)v[2].size() >= 1) {
        if (j == 0 || j == 1)
          dp[i][j] =
              max(dp[i][j], dp[i - 1][(j - 2 + 10) % 10] +
                                max(v[1][0], v[2][0]) + v[1][0] + v[2][0]);
        else
          dp[i][j] =
              max(dp[i][j], dp[i - 1][(j - 2 + 10) % 10] + v[1][0] + v[2][0]);
      }
      if (dp[i - 1][(j - 2 + 10) % 10] != -1 && (int)v[1].size() >= 2) {
        if (j == 0 || j == 1)
          dp[i][j] = max(
              dp[i][j], dp[i - 1][(j - 2 + 10) % 10] + 2LL * v[1][0] + v[1][1]);
        else
          dp[i][j] =
              max(dp[i][j], dp[i - 1][(j - 2 + 10) % 10] + v[1][0] + v[1][1]);
      }
      if (dp[i - 1][(j - 3 + 10) % 10] != -1 && (int)v[1].size() >= 3) {
        if (j == 0 || j == 1 || j == 2)
          dp[i][j] = max(dp[i][j], dp[i - 1][(j - 3 + 10) % 10] +
                                       2LL * v[1][0] + v[1][1] + v[1][2]);
        else
          dp[i][j] = max(dp[i][j], dp[i - 1][(j - 3 + 10) % 10] + v[1][0] +
                                       v[1][1] + v[1][2]);
      }
    }
  }
  long long ans = 0;
  for (int i = 0; i <= 9; i++) ans = max(ans, dp[n][i]);
  printf("%lld\n", ans);
  return 0;
}
