#include <bits/stdc++.h>
using namespace std;
int n, m, q, fa[300005], ans[300005], a1, pos;
int vis[300005];
vector<int> G[300005];
int findset(int x) {
  if (fa[x] != x) fa[x] = findset(fa[x]);
  return fa[x];
}
void dfs(int u, int d, int step) {
  if (vis[u] == d) return;
  vis[u] = d;
  if (step > a1) {
    a1 = step;
    pos = u;
  }
  for (int i = 0; i < G[u].size(); i++) {
    int v = G[u][i];
    if (findset(v) != findset(u)) fa[fa[v]] = fa[u];
    dfs(G[u][i], d, step + 1);
  }
}
int main() {
  scanf("%d%d%d", &n, &m, &q);
  for (int i = 1; i <= n; i++) fa[i] = i;
  for (int i = 1; i <= m; i++) {
    int u, v;
    scanf("%d%d", &u, &v);
    G[u].push_back(v);
    G[v].push_back(u);
  }
  for (int i = 1; i <= n; i++) {
    if (!vis[i]) {
      a1 = 0, pos = i;
      dfs(i, i, 0);
      a1 = 0;
      dfs(pos, pos, 0);
      ans[findset(i)] = a1;
    }
  }
  while (q--) {
    int flag;
    scanf("%d", &flag);
    if (flag == 1) {
      int u;
      scanf("%d", &u);
      printf("%d\n", ans[findset(u)]);
    } else {
      int x, y;
      scanf("%d%d", &x, &y);
      int v1 = findset(x);
      int v2 = findset(y);
      if (v1 != v2) {
        fa[v1] = v2;
        ans[v2] = max(max(ans[v1], ans[v2]),
                      (ans[v1] + 1) / 2 + (ans[v2] + 1) / 2 + 1);
      }
    }
  }
}
