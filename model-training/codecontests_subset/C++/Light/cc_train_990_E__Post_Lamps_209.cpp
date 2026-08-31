#include <bits/stdc++.h>
using namespace std;
bool isrange(int second, int first, int n, int m) {
  if (0 <= second && second < n && 0 <= first && first < m) return true;
  return false;
}
int dy[4] = {1, 0, -1, 0}, dx[4] = {0, 1, 0, -1},
    ddy[8] = {1, 0, -1, 0, 1, 1, -1, -1}, ddx[8] = {0, 1, 0, -1, 1, -1, 1, -1};
long long int val[1111111], dp[1111111];
int main(void) {
  int n, m, k, diff = 0, ll = -1, vv = 0;
  long long int ans = 1e18;
  scanf("%d%d%d", &n, &m, &k);
  for (int e = 0; e < m; e++) {
    int s;
    scanf("%d", &s);
    dp[s] = 1;
    if (ll == -1) {
      ll = s;
      vv = 1;
      diff = max(diff, vv);
    } else {
      if (ll + 1 == s) {
        vv++;
      } else
        vv = 1;
      ll = s;
      diff = max(diff, vv);
    }
  }
  for (int e = 1; e <= k; e++) scanf("%lld", &val[e]);
  for (int e = 1; e < n; e++) {
    if (dp[e])
      dp[e] = dp[e - 1];
    else
      dp[e] = e;
  }
  if (dp[0] || diff + 1 > k) {
    printf("-1");
  } else {
    for (int e = diff + 1; e <= k; e++) {
      long long int tot = 0;
      for (int p = 0;;) {
        p += e;
        tot++;
        if (p >= n) break;
        p = dp[p];
      }
      ans = min(ans, val[e] * tot);
    }
    printf("%lld", ans);
  }
  return 0;
}
