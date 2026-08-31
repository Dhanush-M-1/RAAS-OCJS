#include <bits/stdc++.h>
using namespace std;
int n;
vector<int> edge[3100];
int cir[3100], vi[3100], cirlen;
int _lca[3100][3100], fa[3100], dep[3100];
void dfs2(int x) {
  dep[x] = dep[fa[x]] + 1;
  vi[x] = 1;
  for (typeof((edge[x]).begin()) y = (edge[x]).begin(); y != (edge[x]).end();
       y++)
    if (*y != fa[x]) {
      if (vi[*y]) {
        if (dep[*y] < dep[x]) {
          for (int p = x; p != fa[*y]; p = fa[p]) cir[p] = ++cirlen;
        }
      } else
        fa[*y] = x, dfs2(*y);
    }
}
int lca(int x, int y) {
  if (_lca[x][y]) return _lca[x][y];
  if (x == y) return _lca[x][y] = x;
  if (dep[x] < dep[y]) swap(x, y);
  return _lca[x][y] = lca(fa[x], y);
}
void dfs(int x, int f) {
  if (vi[x]) return;
  vi[x] = 1;
  fa[x] = f;
  dep[x] = dep[f] + 1;
  for (typeof((edge[x]).begin()) y = (edge[x]).begin(); y != (edge[x]).end();
       y++)
    if (!cir[*y]) cir[*y] = cir[x], dfs(*y, x);
}
int main() {
  cin >> n;
  for (int _ = (1); _ <= (n); _++) {
    int x, y;
    scanf("%d%d", &x, &y);
    x++, y++;
    edge[x].push_back(y);
    edge[y].push_back(x);
  }
  dfs2(1);
  memset(vi, 0, sizeof vi);
  for (int x = (1); x <= (n); x++)
    if (cir[x]) dfs(x, 0);
  double ans = 0;
  for (int x = (1); x <= (n); x++)
    for (int y = (1); y <= (n); y++)
      if (cir[x] != cir[y]) {
        int X = dep[x] + dep[y], mn = min(cir[x], cir[y]),
            mx = max(cir[x], cir[y]), Y = mx - mn - 1, Z = cirlen - mx + mn - 1;
        ans += 1.0 / (X + Y) + 1.0 / (X + Z) - 1.0 / (X + Y + Z);
      } else {
        int f = lca(x, y);
        ans += 1.0 / (dep[x] + dep[y] - dep[f] * 2 + 1);
      }
  printf("%.7lf\n", ans);
  return 0;
}
