#include <bits/stdc++.h>
using namespace std;
int n, x, K, kk, ans, g[2000005], sz[2000005], dp[2000005], dep[2000005],
    dis[2000005], head[2000005];
struct Tree {
  int nxt, to;
} e[2000005];
inline void link(int x, int y) {
  e[++kk].nxt = head[x];
  e[kk].to = y;
  head[x] = kk;
}
void dfs1(int u, int fa) {
  bool lev = 1;
  sz[u] = 1;
  dis[u] = 1e9;
  for (int i = head[u]; i; i = e[i].nxt) {
    int v = e[i].to;
    if (v == fa) continue;
    dep[v] = dep[u] + 1;
    dfs1(v, u);
    lev = 0;
    sz[u] += sz[v];
    dis[u] = min(dis[u], dis[v]);
  }
  if (lev) dis[u] = dep[u];
}
void dfs2(int u, int fa) {
  dp[u] = (sz[u] == 1);
  if (sz[u] == 1) return;
  for (int i = head[u]; i; i = e[i].nxt) {
    int v = e[i].to;
    if (v == fa) continue;
    dfs2(v, u);
    if (dis[v] - K <= dep[u]) {
      dp[u] += dp[v];
      g[u] = max(g[u], g[v] - dp[v]);
    } else
      g[u] = max(g[u], g[v]);
  }
  g[u] += dp[u];
  ans = max(ans, g[u]);
}
int main() {
  scanf("%d%d", &n, &K);
  for (int i = 2; i <= n; i++) {
    scanf("%d", &x);
    link(x, i);
  }
  dfs1(1, -1);
  dfs2(1, -1);
  printf("%d\n", ans);
  return 0;
}
