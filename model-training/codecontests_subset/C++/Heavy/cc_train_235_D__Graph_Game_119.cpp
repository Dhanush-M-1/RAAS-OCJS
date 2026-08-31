#include <bits/stdc++.h>
using namespace std;
inline int read() {
  int x = 0;
  char ch = getchar();
  while (!isdigit(ch)) ch = getchar();
  while (isdigit(ch)) x = x * 10 + ch - '0', ch = getchar();
  return x;
}
int tot = 1;
int fir[3010], nex[3010 << 1], got[3010 << 1];
inline void AddEdge(int x, int y) {
  nex[++tot] = fir[x], fir[x] = tot, got[tot] = y;
}
int vis[3010], cir[3010], siz;
int ins[3010], stk[3010], top;
inline int find(int x, int fa) {
  if (ins[x]) {
    int v;
    do {
      vis[cir[++siz] = v = stk[top--]] = true;
    } while (v != x);
    return true;
  }
  ins[stk[++top] = x] = true;
  for (int i = fir[x]; i; i = nex[i]) {
    if (got[i] == fa) continue;
    if (find(got[i], x)) return true;
  }
  ins[stk[top--]] = false;
  return false;
}
int col[3010], par[3010][21], dep[3010];
inline int lca(int x, int y) {
  if (dep[x] < dep[y]) swap(x, y);
  for (int i = 20; i >= 0; i--)
    if (dep[par[x][i]] >= dep[y]) x = par[x][i];
  if (x == y) return x;
  for (int i = 20; i >= 0; i--)
    if (par[x][i] != par[y][i]) x = par[x][i], y = par[y][i];
  return par[x][0];
}
inline void dfs(int x, int fa, int c) {
  col[x] = c, par[x][0] = fa, dep[x] = dep[fa] + 1;
  for (int i = 1; i <= 20; i++) par[x][i] = par[par[x][i - 1]][i - 1];
  for (int i = fir[x]; i; i = nex[i])
    if (got[i] != fa && !vis[got[i]]) dfs(got[i], x, c);
}
inline int dis(int x, int y) {
  return dep[x] + dep[y] - 2 * dep[lca(x, y)] + 1;
}
int main() {
  int n = read();
  for (int i = 1; i <= n; i++) {
    int x = read() + 1, y = read() + 1;
    AddEdge(x, y), AddEdge(y, x);
  }
  find(1, 0);
  double ans = 0;
  for (int i = 1; i <= siz; i++) dfs(cir[i], 0, i);
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= n; j++) {
      if (col[i] == col[j])
        ans += 1.0 / dis(i, j);
      else {
        int x = dep[i] + dep[j], y = abs(col[i] - col[j]) - 1, z = siz - y - 2;
        ans += 1.0 / (x + y) + 1.0 / (x + z) - 1.0 / (x + y + z);
      }
    }
  printf("%0.10lf\n", ans);
  return 0;
}
