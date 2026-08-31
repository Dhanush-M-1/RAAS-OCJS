#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e6 + 5;
vector<int> g[maxn];
int n, k, md[maxn], d[maxn], f[maxn], dp[maxn];
void dfs(int u, int dep) {
  md[u] = n;
  d[u] = dep;
  if (g[u].empty()) md[u] = dep;
  for (int i = 0; i < g[u].size(); ++i) {
    int v = g[u][i];
    dfs(v, dep + 1);
    md[u] = min(md[u], md[v]);
  }
}
int dfs2(int u) {
  int as = 0;
  if (g[u].empty()) {
    f[u] = 1;
    dp[u] = 1;
  }
  for (int i = 0; i < g[u].size(); ++i) {
    int v = g[u][i];
    dfs2(v);
    f[u] += f[v];
    dp[u] += f[v];
    as = max(as, dp[v] - f[v]);
  }
  if (md[u] - d[u] > k - 1) f[u] = 0;
  dp[u] += as;
  return dp[u];
}
int main() {
  scanf("%d%d", &n, &k);
  for (int i = 2; i <= n; ++i) {
    int p;
    scanf("%d", &p);
    g[p].push_back(i);
  }
  dfs(1, 0);
  printf("%d\n", dfs2(1));
}
