#include <bits/stdc++.h>
using namespace std;
int n;
long long par[111111][25], d[3][111111][25], child[111111], up[111111][3],
    down[111111][3];
int depth[111111], in[111111], out[111111];
int logarit[111111];
int cnt = 0;
vector<vector<pair<int, int> > > adj;
long long mod = 1000000007;
void dfs_1(int u, int p) {
  in[u] = cnt++;
  depth[u] = depth[p] + 1;
  for (int i = 0, _n = adj[u].size(); i < _n; i++) {
    int v = adj[u][i].first;
    int w = adj[u][i].second;
    if (v == p) continue;
    par[v][0] = u;
    d[0][v][0] = w;
    d[1][v][0] = 1ll * w * w % mod;
    dfs_1(v, u);
    child[u] += child[v];
    down[u][0] = (down[u][0] + down[v][0] + 1ll * child[v] * w % mod) % mod;
    down[u][1] = (down[u][1] + down[v][1] + d[1][v][0] * child[v] % mod +
                  1ll * down[v][0] * 2 * w % mod) %
                 mod;
  }
  out[u] = cnt++;
}
void init_logarit() {
  logarit[1] = 0;
  for (int i = 2, _b = n; i <= _b; i++) {
    if ((1 << (logarit[i - 1] + 1)) == i)
      logarit[i] = logarit[i - 1] + 1;
    else
      logarit[i] = logarit[i - 1];
  }
}
void init_lca() {
  for (int i = 1, _b = n; i <= _b; i++) child[i] = 1;
  init_logarit();
  memset(par, -1, sizeof par);
  dfs_1(1, 0);
  for (int j = 1, _b = logarit[n]; j <= _b; j++)
    for (int i = 1, _b = n; i <= _b; i++)
      if (par[i][j - 1] != -1) {
        par[i][j] = par[par[i][j - 1]][j - 1];
        d[0][i][j] = (d[0][i][j - 1] + d[0][par[i][j - 1]][j - 1]) % mod;
      }
}
void dfs_2(int u, int p, int w) {
  if (u != 1) {
    up[u][0] = (up[p][0] + down[p][0] - down[u][0] +
                1ll * (n - 2 * child[u] + 2 * mod) * w + mod) %
               mod;
    up[u][1] =
        (up[p][1] + down[p][1] - down[u][1] +
         1ll * (n - 4 * child[u] + 4 * mod) * (1ll * w * w % mod) % mod +
         2ll * w * (up[p][0] + down[p][0] - 2 * down[u][0] + 2 * mod) % mod +
         mod) %
        mod;
  }
  for (int i = 0, _n = adj[u].size(); i < _n; i++) {
    int v = adj[u][i].first;
    if (v == p) continue;
    dfs_2(v, u, adj[u][i].second);
  }
}
void init() {
  init_lca();
  dfs_2(1, 0, 0);
}
long long find_lca(int u, int v) {
  if (depth[u] < depth[v]) swap(u, v);
  long long res = 0;
  for (int i = logarit[depth[u]]; i >= 0; i--)
    if (depth[u] - (1 << i) >= depth[v] && par[u][i] != -1) {
      res = (res + d[0][u][i]) % mod;
      u = par[u][i];
    }
  if (u == v) return res;
  for (int i = logarit[depth[u]]; i >= 0; i--)
    if (par[v][i] != -1 && par[u][i] != -1 && par[v][i] != par[u][i]) {
      res = (res + d[0][u][i] + d[0][v][i]) % mod;
      u = par[u][i], v = par[v][i];
    }
  res = (res + d[0][u][0] + d[0][v][0]) % mod;
  return res;
}
void Query(int u, int v) {
  long long tmp = find_lca(u, v);
  if (in[v] <= in[u] && out[u] <= out[v]) {
    long long res = (down[u][1] + up[u][1]) % mod;
    long long x = 2ll *
                  (up[v][1] + 2ll * up[v][0] * tmp % mod +
                   (tmp * tmp % mod) * (1ll * n - child[v]) % mod) %
                  mod;
    res = (res - x + mod) % mod;
    printf("%d\n", (int)res);
    return;
  }
  long long res = (down[v][1] + (tmp * tmp) % mod * child[v] % mod +
                   2ll * down[v][0] * tmp % mod) %
                  mod;
  long long x = (down[u][1] + up[u][1]) % mod;
  res = (2 * res - x + mod) % mod;
  printf("%d\n", (int)res);
}
int main() {
  int u, v, w, Q;
  scanf("%d", &n);
  adj.assign(n + 1, vector<pair<int, int> >());
  for (int i = 0, _n = n - 1; i < _n; i++) {
    scanf("%d%d%d", &u, &v, &w);
    adj[u].push_back(pair<int, int>(v, w));
    adj[v].push_back(pair<int, int>(u, w));
  }
  init();
  scanf("%d", &Q);
  while (Q--) {
    scanf("%d%d", &u, &v);
    Query(u, v);
  }
  return 0;
}
