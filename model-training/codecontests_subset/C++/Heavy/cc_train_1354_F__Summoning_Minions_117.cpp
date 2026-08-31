#include <bits/stdc++.h>
using namespace std;
int f[505][505], g[505][505], a[505], b[505], id[505], xinyue, n, m, vis[505],
    ed;
int cmp(int x, int y) { return b[x] < b[y]; }
void dfs(int n, int m) {
  if (!n) return;
  if (g[n][m] == 1) vis[n] = 1, m--;
  dfs(n - 1, m);
}
int main() {
  scanf("%d", &xinyue);
  while (xinyue--) {
    scanf("%d%d", &n, &m);
    for (int i = 0; i <= n; i++) {
      for (int t = 0; t <= m; t++) {
        f[i][t] = -1;
      }
    }
    f[0][0] = 0;
    memset(g, 0, sizeof(g));
    for (int i = 1; i <= n; i++) scanf("%d%d", &a[i], &b[i]), id[i] = i;
    sort(id + 1, id + n + 1, cmp);
    for (int i = 1; i <= n; i++) {
      for (int t = 0; t <= min(i, m); t++) {
        if (f[i - 1][t] != -1) f[i][t] = f[i - 1][t] + b[id[i]] * (m - 1);
        g[i][t] = 0;
        if (t && f[i - 1][t - 1] + a[id[i]] + b[id[i]] * (t - 1) > f[i][t] &&
            f[i - 1][t - 1] != -1) {
          f[i][t] = f[i - 1][t - 1] + a[id[i]] + b[id[i]] * (t - 1);
          g[i][t] = 1;
        }
      }
    }
    memset(vis, 0, sizeof(vis));
    dfs(n, m);
    printf("%d\n", m + (n - m) * 2);
    ed = 0;
    for (int i = 1; i <= n; i++) {
      if (vis[i]) {
        ed++;
        if (ed == m) {
          ed = id[i];
          break;
        }
        printf("%d ", id[i]);
      }
    }
    for (int i = 1; i <= n; i++) {
      if (!vis[i]) {
        printf("%d %d ", id[i], -id[i]);
      }
    }
    printf("%d\n", ed);
  }
}
