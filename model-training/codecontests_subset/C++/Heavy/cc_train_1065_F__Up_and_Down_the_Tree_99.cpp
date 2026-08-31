#include <bits/stdc++.h>
using namespace std;
int dp[2][1000005], isLeaf[1000005];
vector<int> g[1000005];
int tag[50];
int dfs(int u, int lev, int k) {
  if (g[u].size() == 0) {
    isLeaf[u] = 1;
    return lev;
  }
  int mn = 1000005, ret = 0;
  for (int i = 0; i < g[u].size(); i++) {
    int v = g[u][i];
    mn = min(mn, dfs(v, lev + 1, k));
    if (!isLeaf[v]) {
      dp[1][u] += dp[1][v];
      ret = max(ret, dp[0][v] - dp[1][v]);
    } else
      dp[1][u] += 1;
  }
  dp[0][u] = dp[1][u] + ret;
  dp[1][u] = ((mn - lev) < k) * dp[1][u];
  return mn;
}
int main() {
  int i, j, k, l, m, n;
  scanf("%d %d", &n, &k);
  for (i = 2; i <= n; i++) {
    int p;
    scanf("%d", &p);
    g[p].push_back(i);
  }
  int cnt = 1;
  dfs(1, 0, k);
  int ans = dp[0][1];
  printf("%d\n", ans);
  return 0;
}
