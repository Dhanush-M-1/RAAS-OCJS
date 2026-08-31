#include <bits/stdc++.h>
using namespace std;
const int N = 3e5 + 10, M = 3e5 + 10;
struct Edge {
  int to, next;
} edge[M << 1];
int idx;
int h[N];
void add_edge(int u, int v) {
  edge[++idx] = {v, h[u]};
  h[u] = idx;
}
int len[N], vis[N];
int d[N], f[N];
int fa[N];
int n, m, q;
void init() {
  memset(h, -1, sizeof h);
  for (int i = 1; i <= n; i++) fa[i] = i;
}
int get(int x) {
  if (fa[x] == x) return x;
  return fa[x] = get(fa[x]);
}
void dp(int p) {
  vis[p] = 1;
  for (int i = h[p]; ~i; i = edge[i].next) {
    int to = edge[i].to;
    if (vis[to]) continue;
    dp(to);
    f[p] = max(f[p], d[p] + d[to] + 1);
    d[p] = max(d[p], d[to] + 1);
  }
}
int main() {
  scanf("%d%d%d", &n, &m, &q);
  init();
  for (int i = 1; i <= m; i++) {
    int x, y;
    scanf("%d%d", &x, &y);
    add_edge(x, y);
    add_edge(y, x);
    x = get(x), y = get(y);
    fa[x] = y;
  }
  for (int i = 1; i <= n; i++) {
    if (!vis[i]) dp(get(i));
    int u = get(i);
    len[u] = max(len[u], f[i]);
  }
  while (q--) {
    int tp, x, y;
    scanf("%d%d", &tp, &x);
    if (tp == 1) {
      x = get(x);
      printf("%d\n", len[x]);
      continue;
    }
    scanf("%d", &y);
    x = get(x), y = get(y);
    if (x == y) continue;
    int d1 = len[x], d2 = len[y];
    len[y] = max(d1, d2);
    len[y] = max(len[y], ((d1 + 1) >> 1) + ((d2 + 1) >> 1) + 1);
    fa[x] = y;
  }
  return 0;
}
