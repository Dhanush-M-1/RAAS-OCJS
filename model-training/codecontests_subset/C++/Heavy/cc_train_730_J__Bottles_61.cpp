#include <bits/stdc++.h>
using namespace std;
const int MOD = 1e9 + 7;
const int INF = 2e9;
const int magic = 348;
const double eps = 1e-10;
struct bottle {
  int cur, vol;
} a[108];
int n, k, sum;
int dp[2][101][10048];
bool cmp(bottle first, bottle second) { return first.vol > second.vol; }
int main() {
  int i, j, m;
  scanf("%d", &n);
  for (i = 1; i <= n; i++) {
    scanf("%d", &a[i].cur);
    sum += a[i].cur;
  }
  for (i = 1; i <= n; i++) scanf("%d", &a[i].vol);
  sort(a + 1, a + n + 1, cmp);
  int cc = 0;
  for (i = 1; i <= n; i++) {
    cc += a[i].vol;
    if (cc >= sum) break;
  }
  k = i;
  for (i = 0; i <= 1; i++)
    for (j = 0; j <= 100; j++)
      for (m = 0; m <= 10000; m++) dp[i][j][m] = -INF;
  dp[0][0][0] = 0;
  int ans = 0;
  int p0 = 0, p1 = 1;
  for (i = 1; i <= n; i++) {
    for (j = 0; j <= k; j++)
      for (m = 0; m <= 100 * i; m++) {
        dp[p1][j][m] = dp[p0][j][m];
        if (j && m - a[i].vol >= 0)
          dp[p1][j][m] =
              max(dp[p1][j][m], dp[p0][j - 1][m - a[i].vol] + a[i].cur);
        if (i == n && j == k && m >= sum) ans = max(ans, dp[p1][j][m]);
      }
    p0 ^= 1;
    p1 ^= 1;
  }
  printf("%d %d\n", k, sum - ans);
  return 0;
}
