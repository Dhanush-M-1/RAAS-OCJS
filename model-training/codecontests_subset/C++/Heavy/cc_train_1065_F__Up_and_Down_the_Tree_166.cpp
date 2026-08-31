#include <bits/stdc++.h>
using namespace std;
const int M = 998244353, INF = 1 << 30, N = 1000005;
int n, m, i, j, u, v, head[N], Next[N], adj[N], k, vis[N], dfn[N], low[N],
    dep[N], siz[N];
void Push(int u, int v) {
  Next[++k] = head[u];
  head[u] = k;
  adj[k] = v;
}
void dfs2(int i, int d) {
  dep[i] = d;
  int j;
  low[i] = 1 << 30;
  if (vis[i] == 0) low[i] = d;
  for (j = head[i]; j != 0; j = Next[j]) {
    dfs2(adj[j], d + 1);
    low[i] = min(low[i], low[adj[j]]);
  }
}
void dfs3(int i) {
  int j;
  if (vis[i] == 0) siz[i] = 1;
  for (j = head[i]; j != 0; j = Next[j]) {
    dfs3(adj[j]);
    if (low[adj[j]] - dep[i] <= m) {
      siz[i] += siz[adj[j]];
      siz[adj[j]] = 0;
    }
  }
}
int dfs(int i) {
  int j, s = 0;
  for (j = head[i]; j != 0; j = Next[j]) s = max(s, dfs(adj[j]));
  return s + siz[i];
}
int main() {
  scanf("%d %d", &n, &m);
  for (i = 2; i <= n; i++) {
    scanf("%d", &u);
    Push(u, i);
    vis[u] = 1;
  }
  dfs2(1, 0);
  dfs3(1);
  printf("%d", dfs(1));
}
