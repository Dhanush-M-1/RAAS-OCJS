#include <bits/stdc++.h>
using namespace std;
const int N = 1000005;
int n, k, ans, e[N], ec, nx[N], fi[N], d[N], f[N], g[N];
bool vis[N];
void adde(int u, int v) {
  e[++ec] = v;
  nx[ec] = fi[u];
  fi[u] = ec;
}
void dfs(int u, int d) {
  g[u] = 1e9;
  if (!vis[u]) {
    g[u] = d;
    f[u] = 1;
  }
  int mx = 0;
  for (int i = fi[u]; i; i = nx[i]) {
    int v = e[i];
    dfs(v, d + 1);
    g[u] = min(g[u], g[v]);
    if (g[v] - d <= k) {
      f[u] += f[v];
      f[v] = 0;
    }
  }
}
int work(int u) {
  int mx = 0;
  for (int i = fi[u]; i; i = nx[i]) mx = max(mx, work(e[i]));
  return f[u] + mx;
}
int main() {
  scanf("%d%d", &n, &k);
  for (int i = 2; i <= n; ++i) {
    int fa;
    scanf("%d", &fa);
    adde(fa, i);
    vis[fa] = true;
  }
  dfs(1, 0);
  printf("%d\n", work(1));
  return 0;
}
