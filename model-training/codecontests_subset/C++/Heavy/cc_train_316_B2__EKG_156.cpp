#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m, s[1002], t[1002], pp = 0;
  bool v[1002];
  scanf("%d %d", &n, &m);
  memset(t, 0, sizeof(t));
  memset(v, 0, sizeof(v));
  for (int i = 1; i <= n; i++) scanf("%d", &s[i]), t[s[i]] = i;
  int tmp = m;
  while (tmp != 0) {
    v[tmp] = true;
    tmp = s[tmp];
    pp++;
  }
  int dp[1002][2];
  memset(dp, 0, sizeof(dp));
  dp[0][0] = 1;
  for (int i = 1; i <= n; i++) {
    for (int j = 0; j <= n; j++)
      dp[j][i % 2] = max(dp[j][i % 2], dp[j][(i - 1) % 2]);
    if (!v[i] && s[i] == 0) {
      int tmp = i, k = 1;
      while (t[tmp] != 0) {
        v[tmp] = true;
        tmp = t[tmp];
        ++k;
      }
      for (int j = 0; j <= n - k; j++) {
        if (dp[j][(i - 1) % 2] == 1) dp[j + k][i % 2] = dp[j][i % 2] = 1;
      }
    }
  }
  for (int i = 0; i <= n; i++) {
    if (dp[i][n % 2] == 1) printf("%d\n", i + pp);
  }
  return 0;
}
