#include <bits/stdc++.h>
using namespace std;
int n, m;
int tot;
int head[1000050], edge[1000050], nxt[1000050];
int fa[21][1000050];
void join(int u, int v) {
  edge[tot] = v;
  nxt[tot] = head[u];
  head[u] = tot++;
}
void init() {
  tot = 0;
  memset(head, -1, sizeof(head));
  scanf("%d%d", &n, &m);
  for (int i = 2; i <= n; ++i) {
    scanf("%d", &fa[0][i]);
    join(fa[0][i], i);
  }
}
int Fk(int v) {
  for (int i = 0; i < 21; ++i)
    if (m >> i & 1) v = fa[i][v];
  return v;
}
int dep[1000050] = {1000050};
int leaf[1000050];
int dp[1000050][2];
int Min(int i, int j) { return dep[i] < dep[j] ? i : j; }
int dfs(int i) {
  for (int j = 1; fa[j - 1][i]; ++j) fa[j][i] = fa[j - 1][fa[j - 1][i]];
  int mx = 0;
  for (int k = head[i]; ~k; k = nxt[k]) {
    int j = edge[k];
    dep[j] = dep[i] + 1;
    dfs(j);
    if (dep[leaf[j]] - dep[i] <= m) {
      dp[i][0] += dp[j][0];
      mx = max(mx, dp[j][1] - dp[j][0]);
      leaf[i] = Min(leaf[j], leaf[i]);
    } else
      mx = max(mx, dp[j][1]);
  }
  if (!~head[i]) leaf[i] = i, dp[i][0] = 1;
  dp[i][1] = max(dp[i][1], dp[i][0] + mx);
  return leaf[i];
}
void solve() {
  dfs(1);
  printf("%d\n", dp[1][1]);
}
int main() {
  init();
  solve();
  return 0;
}
