#include <bits/stdc++.h>
using namespace std;
int a[101], b[101], dp[101][101 * 101], inf = 1E9;
int main() {
  int n, m, i, j, k;
  pair<int, int> ans = make_pair(inf, inf);
  scanf("%d", &n);
  for (i = 1; i <= n; i++) scanf("%d", &a[i]);
  for (i = 1; i <= n; i++) scanf("%d", &b[i]);
  for (i = 0; i < 101; i++)
    for (j = 0; j < 101 * 101; j++) dp[i][j] = -inf;
  dp[0][0] = 0;
  for (k = 1, m = 0; k <= n; k++) {
    b[k] -= a[k];
    m += a[k];
    for (i = k; i > 0; i--)
      for (j = m; j >= a[k]; j--)
        dp[i][j] = max(dp[i][j], dp[i - 1][j - a[k]] + b[k]);
  }
  for (i = 1; i <= n; i++)
    for (j = 1; j <= m; j++)
      if (j + dp[i][j] >= m) ans = min(ans, make_pair(i, m - j));
  printf("%d %d\n", ans.first, ans.second);
  return 0;
}
