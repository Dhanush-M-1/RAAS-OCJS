#include <bits/stdc++.h>
const int maxn = 3010;
const int maxm = 6010;
using namespace std;
int ter[maxm], nxt[maxm], lnk[maxn], d[maxn];
int n, m, e, tot, opt[maxn], pos[maxn], dis[maxn], bel[maxn], fa[maxn][20];
bool cir[maxn], vis[maxn];
void add(int x, int y) {
  ter[++e] = y, nxt[e] = lnk[x], lnk[x] = e;
  ter[++e] = x, nxt[e] = lnk[y], lnk[y] = e;
  ++d[x], ++d[y];
}
void dfs(int p) {
  cir[p] = false;
  for (int i = lnk[p]; i; i = nxt[i])
    if (cir[ter[i]]) pos[ter[i]] = pos[p] + 1, dfs(ter[i]);
}
void _dfs(int p, int fat) {
  bel[p] = fat;
  for (int i = lnk[p]; i; i = nxt[i])
    if (vis[ter[i]]) {
      vis[ter[i]] = false;
      dis[ter[i]] = dis[p] + 1;
      fa[ter[i]][0] = p;
      _dfs(ter[i], fat);
    }
}
void pre() {
  memset(cir, true, sizeof(cir));
  int he = 0, ta = 0;
  for (int i = 1; i <= n; ++i)
    if (d[i] == 1) opt[++ta] = i;
  while (he != ta) {
    ++he;
    int u = opt[he];
    cir[u] = false;
    for (int i = lnk[u]; i; i = nxt[i]) {
      --d[ter[i]];
      if (d[ter[i]] == 1) opt[++ta] = ter[i];
    }
  }
  tot = 0;
  for (int i = 1; i <= n; ++i) tot += cir[i];
  for (int i = 1; i <= n; ++i)
    if (cir[i]) {
      pos[i] = 1;
      dfs(i);
      break;
    }
  memset(vis, true, sizeof(vis));
  for (int i = 1; i <= n; ++i)
    if (pos[i]) dis[i] = 0, vis[i] = false;
  for (int i = 1; i <= n; ++i)
    if (pos[i]) _dfs(i, i);
}
int lca(int x, int y) {
  if (dis[x] < dis[y]) swap(x, y);
  int tmp = dis[x] - dis[y];
  for (int i = 15; i >= 0; --i)
    if ((tmp >> i) & 1) x = fa[x][i];
  if (x == y) return x;
  for (int i = 15; i >= 0; --i)
    if (fa[x][i] != fa[y][i]) x = fa[x][i], y = fa[y][i];
  return fa[x][0];
}
int main() {
  scanf("%d", &n);
  int x, y;
  for (int i = 1; i <= n; ++i) scanf("%d%d", &x, &y), ++x, ++y, add(x, y);
  pre();
  for (int j = 1; (1 << j) <= n; ++j)
    for (int i = 1; i <= n; ++i) fa[i][j] = fa[fa[i][j - 1]][j - 1];
  double ans = n;
  for (int i = 1; i <= n; ++i)
    for (int j = 1; j <= n; ++j)
      if (i != j) {
        if (bel[i] == bel[j])
          ans += 1.0 / (dis[i] + dis[j] - 2.0 * dis[lca(i, j)] + 1);
        else {
          double A = dis[i] + dis[j] + 2,
                 B = abs(pos[bel[i]] - pos[bel[j]]) - 1,
                 C = tot - abs(pos[bel[i]] - pos[bel[j]]) - 1;
          ans += 1.0 / (A + B) + 1.0 / (A + C) - 1.0 / (A + B + C);
        }
      }
  printf("%.10lf", ans);
  return 0;
}
