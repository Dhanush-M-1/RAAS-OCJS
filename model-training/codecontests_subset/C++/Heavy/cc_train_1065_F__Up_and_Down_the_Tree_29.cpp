#include <bits/stdc++.h>
using namespace std;
const int N = 1e6 + 5;
vector<int> G[N];
int dp[N][2], up[N], n, k;
void dfs(int x) {
  if (G[x].size() == 0) {
    dp[x][0] = dp[x][1] = 1;
    up[x] = k;
  }
  for (int u : G[x]) {
    dfs(u);
    dp[x][0] += dp[u][0];
    up[x] = max(up[x], up[u] - 1);
  }
  int tmp = dp[x][0];
  if (up[x] == 0) {
    dp[x][1] = dp[x][0];
    dp[x][0] = 0;
  }
  for (int u : G[x]) {
    if (up[u]) tmp -= dp[u][0];
    dp[x][1] = max(dp[x][1], tmp + dp[u][1]);
    if (up[u]) tmp += dp[u][0];
  }
}
int main() {
  scanf("%d %d", &n, &k);
  for (int i = 1; i <= n; ++i) up[i] = 0;
  for (int i = 2; i <= n; ++i) {
    int x;
    scanf("%d", &x);
    G[x].push_back(i);
  }
  dfs(1);
  printf("%d\n", max(dp[1][0], dp[1][1]));
}
