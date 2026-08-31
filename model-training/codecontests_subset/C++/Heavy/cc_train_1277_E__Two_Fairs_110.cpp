#include <bits/stdc++.h>
using namespace std;
struct node {
  int pre, to;
} a[500010 << 1];
int head[500010 << 2];
bool vis[500010];
bool flag;
int t, n, m, aa, bb, tot, cnt;
long long suma, sumb;
void addedge(int from, int to) {
  a[++tot].to = to;
  a[tot].pre = head[from];
  head[from] = tot;
}
void dfs(int u, int fa, int tmp) {
  vis[u] = 1;
  for (int i = head[u]; i > 0; i = a[i].pre) {
    int v = a[i].to;
    if (v == fa || vis[v]) continue;
    if (v != tmp) dfs(v, u, tmp);
  }
}
int main() {
  scanf("%d", &t);
  while (t--) {
    scanf("%d%d%d%d", &n, &m, &aa, &bb);
    suma = sumb = tot = 0;
    for (int i = 1; i <= m * 2; ++i) {
      head[i] = -1;
    }
    for (int i = 1; i <= m; ++i) {
      int x, y;
      scanf("%d%d", &x, &y);
      addedge(x, y);
      addedge(y, x);
    }
    dfs(aa, -1, bb);
    for (int i = 1; i <= n; ++i) {
      if (!vis[i] && i != bb) sumb++;
      vis[i] = 0;
    }
    dfs(bb, -1, aa);
    for (int i = 1; i <= n; ++i) {
      if (!vis[i] && i != aa) suma++;
      vis[i] = 0;
    }
    printf("%lld\n", suma * sumb);
  }
  return 0;
}
