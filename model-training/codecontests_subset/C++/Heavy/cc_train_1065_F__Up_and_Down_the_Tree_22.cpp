#include <bits/stdc++.h>
using namespace std;
struct edge {
  int des;
  int next;
} e[1000005 << 1];
int cnt;
int head[1000005];
void ins(int u, int v) {
  ++cnt;
  e[cnt].des = v;
  e[cnt].next = head[u];
  head[u] = cnt;
}
int n;
int k;
int g[1000005];
int f[1000005];
int low[1000005];
int depth[1000005];
void dfs1(int u, int ff) {
  depth[u] = depth[ff] + 1;
  low[u] = 0x3f3f3f3f;
  if (head[u] == 0) {
    low[u] = depth[u];
    g[u] = 1;
    f[u] = 1;
    return;
  }
  for (int i = head[u]; i; i = e[i].next) {
    int v = e[i].des;
    dfs1(v, u);
    if (low[v] - depth[u] <= k) {
      low[u] = min(low[u], low[v]);
      g[u] += g[v];
    }
  }
}
void dfs2(int u) {
  for (int i = head[u]; i; i = e[i].next) {
    int v = e[i].des;
    dfs2(v);
    if (low[v] - depth[u] <= k)
      f[u] = max(f[u], g[u] - g[v] + f[v]);
    else
      f[u] = max(f[u], g[u] + f[v]);
  }
}
int main() {
  scanf("%d %d", &n, &k);
  for (int i = 2; i <= n; ++i) {
    int f;
    scanf("%d", &f);
    ins(f, i);
  }
  dfs1(1, 0);
  dfs2(1);
  printf("%d\n", f[1]);
  return 0;
}
