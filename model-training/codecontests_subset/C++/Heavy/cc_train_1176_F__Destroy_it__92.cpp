#include <bits/stdc++.h>
using namespace std;
const double EPS = 1e-9;
const long long MOD = 998244353;
const int inf = 1 << 30;
const long long linf = 1LL << 60;
const double PI = 3.14159265358979323846;
int n;
int ho = 0, ge = 1;
long long dp[2][10];
long long len[3];
long long num[3][200000];
int main() {
  scanf("%d", &n);
  for (int i = 1; i < 10; i++) dp[ho][i] = -linf;
  for (int i = 0; i < n; i++) {
    int k;
    scanf("%d", &k);
    for (int j = 0; j < 3; j++) len[j] = 0;
    for (int j = 0; j < k; j++) {
      int c, d;
      scanf("%d%d", &c, &d);
      c--;
      num[c][len[c]++] = d;
    }
    for (int j = 0; j < 3; j++)
      sort(num[j], num[j] + len[j], greater<long long>());
    for (int j = 0; j < 10; j++) dp[ge][j] = dp[ho][j];
    for (int j = 0; j < 9; j++) {
      if (len[0] == 0) continue;
      dp[ge][j + 1] = max(dp[ge][j + 1], dp[ho][j] + num[0][0]);
    }
    if (len[0] != 0) dp[ge][0] = max(dp[ge][0], dp[ho][9] + num[0][0] * 2);
    for (int j = 0; j < 9; j++) {
      if (len[1] == 0) continue;
      dp[ge][j + 1] = max(dp[ge][j + 1], dp[ho][j] + num[1][0]);
    }
    if (len[1] != 0) dp[ge][0] = max(dp[ge][0], dp[ho][9] + num[1][0] * 2);
    for (int j = 0; j < 8; j++) {
      if (len[0] <= 1) continue;
      dp[ge][j + 2] = max(dp[ge][j + 2], dp[ho][j] + num[0][0] + num[0][1]);
    }
    if (len[0] > 1)
      dp[ge][0] = max(dp[ge][0], dp[ho][8] + num[0][0] * 2 + num[0][1]);
    if (len[0] > 1)
      dp[ge][1] = max(dp[ge][1], dp[ho][9] + num[0][0] * 2 + num[0][1]);
    for (int j = 0; j < 9; j++) {
      if (len[2] == 0) continue;
      dp[ge][j + 1] = max(dp[ge][j + 1], dp[ho][j] + num[2][0]);
    }
    if (len[2] != 0) dp[ge][0] = max(dp[ge][0], dp[ho][9] + num[2][0] * 2);
    for (int j = 0; j < 8; j++) {
      if (len[0] == 0 || len[1] == 0) continue;
      dp[ge][j + 2] = max(dp[ge][j + 2], dp[ho][j] + num[0][0] + num[1][0]);
    }
    if (len[0] != 0 && len[1] != 0)
      dp[ge][0] = max(dp[ge][0], dp[ho][8] + num[0][0] + num[1][0] +
                                     max(num[0][0], num[1][0]));
    if (len[0] != 0 && len[1] != 0)
      dp[ge][1] = max(dp[ge][1], dp[ho][9] + num[0][0] + num[1][0] +
                                     max(num[0][0], num[1][0]));
    for (int j = 0; j < 7; j++) {
      if (len[0] <= 2) continue;
      dp[ge][j + 3] =
          max(dp[ge][j + 3], dp[ho][j] + num[0][0] + num[0][1] + num[0][2]);
    }
    if (len[0] > 2)
      dp[ge][0] =
          max(dp[ge][0], dp[ho][7] + num[0][0] * 2 + num[0][1] + num[0][2]);
    if (len[0] > 2)
      dp[ge][1] =
          max(dp[ge][1], dp[ho][8] + num[0][0] * 2 + num[0][1] + num[0][2]);
    if (len[0] > 2)
      dp[ge][2] =
          max(dp[ge][2], dp[ho][9] + num[0][0] * 2 + num[0][1] + num[0][2]);
    swap(ho, ge);
  }
  long long ans = 0;
  for (int i = 0; i < 10; i++) ans = max(ans, dp[ho][i]);
  printf("%lld\n", ans);
}
