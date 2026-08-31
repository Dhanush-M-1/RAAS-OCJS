#include <bits/stdc++.h>
using namespace std;
int n, m, q, par[300010], ans[300010], sz[300010], vis[300010];
vector<int> G[300010];
int maxu, maxd;
int dfs(int u, int c, int d, int color) {
  par[u] = c;
  vis[u] = color;
  if (d > maxd) {
    maxu = u;
    maxd = d;
  }
  int outp = 0;
  for (int i = 0; i < G[u].size(); i++) {
    int v = G[u][i];
    if (vis[v] != color) outp += dfs(v, c, d + 1, color);
  }
  return outp + 1;
}
int findpar(int u) { return (par[u] == u ? u : findpar(par[u])); }
void join(int u, int v) {
  int x = findpar(u), y = findpar(v);
  if (x == y) return;
  if (sz[x] < sz[y]) swap(x, y);
  par[y] = x;
  sz[x] += sz[y];
  ans[x] = max(max(ans[x], ans[y]), (ans[x] + 1) / 2 + (ans[y] + 1) / 2 + 1);
}
int main() {
  int color = 1;
  scanf("%d%d%d", &n, &m, &q);
  int a, b;
  for (int i = 0; i < m; i++) {
    scanf("%d%d", &a, &b);
    a--;
    b--;
    G[a].push_back(b);
    G[b].push_back(a);
  }
  fill(par, par + n, -1);
  for (int i = 0; i < n; i++)
    if (par[i] == -1) {
      maxu = i;
      maxd = 0;
      sz[i] = dfs(i, i, 0, color++);
      maxd = 0;
      dfs(maxu, i, 0, color++);
      ans[i] = maxd;
    }
  for (int i = 0; i < q; i++) {
    int c;
    scanf("%d", &c);
    if (c == 1) {
      scanf("%d", &a);
      a--;
      printf("%d\n", ans[findpar(a)]);
    } else {
      scanf("%d%d", &a, &b);
      a--;
      b--;
      join(a, b);
    }
  }
  return 0;
}
