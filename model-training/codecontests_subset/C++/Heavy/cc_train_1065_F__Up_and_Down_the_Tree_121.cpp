#include <bits/stdc++.h>
using namespace std;
const int MAXN = 1e6;
int n, k, tot, head[MAXN + 5], f[MAXN + 5], g[MAXN + 5], closest[MAXN + 5];
bool vis[MAXN + 5];
struct Edge {
  int next, to;
} e[MAXN + 5];
inline void addEdge(int u, int v) {
  e[++tot] = (Edge){head[u], v};
  head[u] = tot;
}
void dfs(int u) {
  if (!vis[u]) {
    f[u] = g[u] = 1;
    return;
  }
  closest[u] = n;
  for (int v, i = head[u]; v = e[i].to, i; i = e[i].next) {
    dfs(v);
    closest[u] = min(closest[u], closest[v] + 1);
    if (closest[v] + 1 > k) g[v] = 0;
    g[u] += g[v];
    f[u] = max(f[u], f[v] - g[v]);
  }
  f[u] += g[u];
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cin >> n >> k;
  for (int x, i = 1; i < n; ++i) {
    cin >> x;
    addEdge(x, i + 1);
    vis[x] = 1;
  }
  dfs(1);
  cout << f[1] << '\n';
  return 0;
}
