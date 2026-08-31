#include <bits/stdc++.h>
using namespace std;
int n, k;
struct graph {
  int head[1000005], nxt[1000005], to[1000005], ecnt;
  graph() {
    ecnt = 0;
    memset(head, 0, sizeof(head));
    memset(nxt, 0, sizeof(nxt));
    memset(to, 0, sizeof(to));
  }
  void adde(int u, int v) {
    to[++ecnt] = v;
    nxt[ecnt] = head[u];
    head[u] = ecnt;
  }
} t;
int dep[1000005], deg[1000005], dp[1000005], mn[1000005];
void dfs(int x) {
  if (deg[x] == 0) {
    mn[x] = dep[x];
    dp[x] = 1;
    return;
  }
  mn[x] = 0x3f3f3f3f;
  for (int e = t.head[x]; e; e = t.nxt[e]) {
    int y = t.to[e];
    dep[y] = dep[x] + 1;
    dfs(y);
    mn[x] = min(mn[x], mn[y]);
    if (mn[y] - dep[x] <= k) {
      dp[x] += dp[y];
      dp[y] = 0;
    }
  }
}
int mxsum(int x) {
  int mx = 0;
  for (int e = t.head[x]; e; e = t.nxt[e]) {
    mx = max(mx, mxsum(t.to[e]));
  }
  return mx + dp[x];
}
int main() {
  scanf("%d%d", &n, &k);
  for (int i = 2; i <= n; i++) {
    int fa;
    scanf("%d", &fa);
    t.adde(fa, i);
    deg[fa]++;
  }
  dfs(1);
  printf("%d\n", mxsum(1));
  return 0;
}
