#include <bits/stdc++.h>
using namespace std;
const int maxn = 300500;
vector<int> g[maxn];
int n, m, q, x, y, op, f[maxn], len[maxn], path[maxn];
void dfs(int u, int rt) {
  f[u] = rt;
  for (auto v : g[u]) {
    if (!f[v]) {
      dfs(v, rt);
      path[u] = max(path[u], path[v]);
      path[u] = max(path[u], len[u] + len[v] + 1);
      len[u] = max(len[u], len[v] + 1);
    }
  }
}
int find(int x) {
  if (f[x] == x) return x;
  return f[x] = find(f[x]);
}
int main() {
  scanf("%d%d%d", &n, &m, &q);
  for (int i = 1; i <= m; i++) {
    scanf("%d%d", &x, &y);
    g[x].push_back(y);
    g[y].push_back(x);
  }
  for (int i = 1; i <= n; i++)
    if (!f[i]) dfs(i, i);
  for (int i = 1; i <= q; i++) {
    scanf("%d", &op);
    if (op == 1) {
      scanf("%d", &x);
      printf("%d\n", path[find(x)]);
    } else {
      scanf("%d%d", &x, &y);
      if (find(x) != find(y)) {
        int mx = max(path[find(x)], path[find(y)]);
        mx = max(mx, (path[find(x)] + 1) / 2 + (path[find(y)] + 1) / 2 + 1);
        f[find(x)] = find(y);
        path[find(x)] = mx;
      }
    }
  }
  return 0;
}
