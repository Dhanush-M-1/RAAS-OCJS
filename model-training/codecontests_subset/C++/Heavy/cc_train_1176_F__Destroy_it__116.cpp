#include <bits/stdc++.h>
using namespace std;
const int maxn = 2000005;
const double pi = acos(-1.0);
const long long mod = 1000000007;
int n;
long long dp[2][15] = {0};
int a[3], b, c;
int main() {
  int i, j;
  scanf("%d", &n);
  int cur = 0, ct;
  memset(dp, -1, sizeof(dp));
  dp[0][0] = 0;
  for (i = 0; i < n; i++) {
    int m;
    scanf("%d", &m);
    ct = 1 - cur;
    a[0] = a[1] = a[2] = b = c = 0;
    for (j = 0; j < 10; j++) dp[ct][j] = dp[cur][j];
    for (j = 0; j < m; j++) {
      int x, y;
      scanf("%d %d", &x, &y);
      if (x == 2)
        b = max(b, y);
      else if (x == 3)
        c = max(c, y);
      else {
        if (a[0] <= y)
          a[2] = a[1], a[1] = a[0], a[0] = y;
        else if (a[1] <= y)
          a[2] = a[1], a[1] = y;
        else if (a[2] <= y)
          a[2] = y;
      }
    }
    for (j = 0; j < 10; j++) {
      if (dp[cur][j] == -1) continue;
      if (j == 9) {
        dp[ct][(j + 1) % 10] =
            max(dp[ct][(j + 1) % 10], dp[cur][j] + 2 * max(a[0], max(b, c)));
      } else {
        dp[ct][(j + 1) % 10] =
            max(dp[ct][(j + 1) % 10], dp[cur][j] + max(a[0], max(b, c)));
      }
      if (j == 8 || j == 9) {
        if (a[1] > 0)
          dp[ct][(j + 2) % 10] =
              max(dp[ct][(j + 2) % 10], dp[cur][j] + a[0] * 2 + a[1]);
        if (a[0] > 0 && b > 0)
          dp[ct][(j + 2) % 10] =
              max(dp[ct][(j + 2) % 10],
                  dp[cur][j] + max(a[0], b) * 2 + min(a[0], b));
      } else {
        if (a[1] > 0)
          dp[ct][(j + 2) % 10] =
              max(dp[ct][(j + 2) % 10], dp[cur][j] + a[0] + a[1]);
        if (a[0] > 0 && b > 0)
          dp[ct][(j + 2) % 10] =
              max(dp[ct][(j + 2) % 10], dp[cur][j] + a[0] + b);
      }
      if (j == 7 || j == 8 || j == 9) {
        if (a[2] > 0)
          dp[ct][(j + 3) % 10] =
              max(dp[ct][(j + 3) % 10], dp[cur][j] + a[0] * 2 + a[1] + a[2]);
      } else {
        if (a[2] > 0)
          dp[ct][(j + 3) % 10] =
              max(dp[ct][(j + 3) % 10], dp[cur][j] + a[0] + a[1] + a[2]);
      }
    }
    cur = ct;
  }
  long long ans = 0;
  for (i = 0; i < 10; i++) ans = max(ans, dp[cur][i]);
  printf("%I64d\n", ans);
  return 0;
}
