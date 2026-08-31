#include <bits/stdc++.h>
using namespace std;
const int MAXN = 3000 + 10;
struct Graph {
  int id, next;
} g[MAXN * 2];
int st[MAXN], dep[MAXN], fa[MAXN], bel[MAXN], n, lca[MAXN][MAXN], num[MAXN];
bool vis[MAXN];
vector<int> L;
void Add(int tot, int x, int y) {
  g[tot].id = y, g[tot].next = st[x], st[x] = tot;
}
int find_loop(int x, int fa) {
  vis[x] = true;
  for (int i = st[x]; i != -1; i = g[i].next)
    if (g[i].id != fa) {
      if (vis[g[i].id]) {
        L.push_back(x);
        return dep[g[i].id];
      }
      dep[g[i].id] = dep[x] + 1;
      int y = find_loop(g[i].id, x);
      if (y == -1) continue;
      if (dep[x] >= y) L.push_back(x);
      return y;
    }
  return -1;
}
void DFS(int x, int fat) {
  for (int i = st[x]; i != -1; i = g[i].next)
    if (g[i].id != fat && num[g[i].id] == -1) {
      dep[g[i].id] = dep[x] + 1, bel[g[i].id] = bel[x];
      fa[g[i].id] = x;
      DFS(g[i].id, x);
    }
}
void init() {
  scanf("%d", &n);
  memset(st, -1, sizeof(st));
  for (int i = 1; i <= n; ++i) {
    int x, y;
    scanf("%d%d", &x, &y);
    ++x, ++y;
    Add(i * 2, x, y), Add(i * 2 + 1, y, x);
  }
  find_loop(1, 0);
  memset(num, -1, sizeof(num));
  for (int i = 0; i < (int)L.size(); ++i) num[L[i]] = i;
  for (int i = 0; i < (int)L.size(); ++i) {
    dep[L[i]] = 1, bel[L[i]] = L[i];
    DFS(L[i], 0);
  }
}
int LCA(int x, int y) {
  if (lca[x][y]) return lca[x][y];
  if (x == y) return x;
  if (dep[x] > dep[y]) return (lca[x][y] = LCA(fa[x], y));
  return (lca[x][y] = LCA(x, fa[y]));
}
void solve() {
  double CC = 0;
  for (int i = 1; i <= n; ++i)
    for (int j = 1; j <= n; ++j)
      if (bel[i] == bel[j]) {
        int x = LCA(i, j);
        CC += 1.0 / (dep[i] + dep[j] - dep[x] * 2 + 1);
      } else {
        int x = dep[i] + dep[j],
            y = (num[bel[i]] - num[bel[j]] + L.size()) % L.size() - 1,
            z = (num[bel[j]] - num[bel[i]] + L.size()) % L.size() - 1;
        CC += 1.0 / (x + y) + 1.0 / (x + z) - 1.0 / (x + y + z);
      }
  printf("%.10lf\n", CC);
}
int main() {
  init();
  solve();
  fclose(stdin);
  fclose(stdout);
  return 0;
}
