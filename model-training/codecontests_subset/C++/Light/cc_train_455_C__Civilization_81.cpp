#include <bits/stdc++.h>
const int maxN = 5e5 + 10, oo = 23041997;
const double eps = 1e-5;
using namespace std;
int n, m, q, par[maxN], dia[maxN], flag, visited[maxN];
vector<int> adj[maxN];
void dfs(int u, int d, int& max_u, int& max_d) {
  visited[u] = flag;
  if (max_d < d) {
    max_d = d;
    max_u = u;
  }
  for (int i = 0; i < adj[u].size(); ++i) {
    int v = adj[u][i];
    if (visited[v] == flag) continue;
    dfs(v, d + 1, max_u, max_d);
  }
}
int get_root(int u) { return (u == par[u]) ? u : (par[u] = get_root(par[u])); }
void join(int u, int v) {
  u = get_root(u);
  v = get_root(v);
  if (u == v) return;
  par[u] = v;
  int new_dia = (dia[u] + 1) / 2 + (dia[v] + 1) / 2 + 1;
  dia[v] = max(new_dia, max(dia[u], dia[v]));
}
int main() {
  cin >> n >> m >> q;
  for (int i = 1; i <= n; ++i) par[i] = i;
  for (int i = 1; i <= m; ++i) {
    int u, v;
    scanf("%d %d", &u, &v);
    adj[u].push_back(v);
    adj[v].push_back(u);
    join(u, v);
  }
  for (int i = 1; i <= n; ++i)
    if (get_root(i) == i) {
      int u = i, v, d = 0;
      ++flag;
      dfs(i, 0, u, d);
      ++flag;
      dfs(u, 0, v, d);
      dia[i] = d;
    }
  for (int i = 1; i <= q; ++i) {
    int t;
    scanf("%d", &t);
    if (t == 1) {
      int u;
      scanf("%d", &u);
      printf("%d\n", dia[get_root(u)]);
    } else {
      int u, v;
      scanf("%d %d", &u, &v);
      join(u, v);
    }
  }
}
