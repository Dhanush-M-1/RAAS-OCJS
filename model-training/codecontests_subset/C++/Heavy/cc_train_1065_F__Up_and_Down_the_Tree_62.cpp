#include <bits/stdc++.h>
using namespace std;
const int N = 1E6 + 10;
vector<int> adj[N];
int h[N], f[N], g[N];
int n, k;
void Read_Input() {
  scanf("%d%d", &n, &k);
  for (int u = 2; u <= n; u++) {
    int p;
    scanf("%d", &p);
    adj[p].push_back(u);
  }
}
void preDFS(int u, int p) {
  h[u] = N;
  f[u] = 0;
  for (int i = 0; i < adj[u].size(); i++) {
    int v = adj[u][i];
    if (v == p) continue;
    preDFS(v, u);
    f[u] += f[v];
    h[u] = min(h[u], h[v] + 1);
    g[u] = max(g[u], g[v] - f[v]);
  }
  g[u] += f[u];
  if (adj[u].size() == 0 && p != -1) f[u] = 1, h[u] = 0;
  if (h[u] >= k) f[u] = 0;
}
void DFS(int u, int p) {
  for (int i = 0; i < adj[u].size(); i++) {
    int v = adj[u][i];
    if (v == p) continue;
    DFS(v, u);
    if (h[u] <= k)
      g[u] = max(g[u], f[u] - f[v] + g[v]);
    else
      g[u] = max(g[u], f[u] + g[v]);
  }
  if (adj[u].size() == 0 && p != -1) g[u] = 1;
}
void Solve() {
  preDFS(1, -1);
  printf("%d", g[1]);
}
int main() {
  Read_Input();
  Solve();
  return 0;
}
