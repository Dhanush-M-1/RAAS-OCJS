#include <bits/stdc++.h>
using namespace std;
const int maxn = 3000;
vector<int> g[maxn + 50];
queue<int> q;
int d[maxn + 50], d1[maxn + 50];
bool vis[maxn + 50];
int x, y, n, l = 0;
double ans = 0.0;
void dfs(int k) {
  vis[k] = 1;
  for (int i = 0; i < g[k].size(); ++i)
    if (!vis[g[k][i]]) {
      d[g[k][i]] = d[k] + 1;
      if (!d1[g[k][i]])
        d1[g[k][i]] = d[g[k][i]], ans += 1.0 / d[g[k][i]];
      else
        ans += 1.0 / d[g[k][i]] - 2.0 / (d[g[k][i]] + d1[g[k][i]] + l - 2);
      dfs(g[k][i]);
    }
  vis[k] = 0;
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; ++i) g[i].clear();
  memset(d, 0, sizeof(d));
  for (int i = 1; i <= n; ++i)
    scanf("%d%d", &x, &y), ++x, ++y, g[x].push_back(y), g[y].push_back(x),
        ++d[x], ++d[y];
  while (!q.empty()) q.pop();
  for (int i = 1; i <= n; ++i)
    if (d[i] == 1) q.push(i);
  l = n;
  while (!q.empty()) {
    --l;
    int u = q.front();
    q.pop();
    for (int i = 0; i < g[u].size(); ++i)
      if (--d[g[u][i]] == 1) q.push(g[u][i]);
  }
  for (int i = 1; i <= n; ++i) {
    memset(d1, 0, sizeof(d1));
    memset(d, 0, sizeof(d));
    memset(vis, 0, sizeof(vis));
    d1[i] = d[i] = 1;
    dfs(i);
  }
  printf("%.10f", ans + n);
  return 0;
}
