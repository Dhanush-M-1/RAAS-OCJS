#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e6 + 10;
const int mod = 1e9 + 7;
const long long inf = 1e18;
int n, K;
vector<int> gg[maxn];
int a[maxn], c[maxn];
int par[maxn][20], h[maxn];
vector<int> g[maxn], g1[maxn], bg[maxn];
int com[maxn];
void dfs_par(int v) {
  for (int i = 1; (1 << i) <= h[v]; i++) par[v][i] = par[par[v][i - 1]][i - 1];
  for (auto u : gg[v])
    if (u != par[v][0]) {
      par[u][0] = v;
      h[u] = h[v] + 1;
      g[v].push_back(u);
      bg[u].push_back(v);
      dfs_par(u);
    }
}
int get_par(int v, int he) {
  he = min(he, h[v]);
  int i = 0;
  while (he) {
    if (he & 1) v = par[v][i];
    i++;
    he >>= 1;
  }
  return v;
}
vector<int> ord;
bool mark[maxn];
void dfs(int v) {
  mark[v] = 1;
  for (auto u : g[v])
    if (!mark[u]) dfs(u);
  ord.push_back(v);
}
void bdfs(int v, int k) {
  mark[v] = 1;
  com[v] = k;
  for (auto u : bg[v])
    if (!mark[u]) bdfs(u, k);
}
void dfs_topol(int v) {
  mark[v] = 1;
  for (auto u : g1[v])
    if (!mark[u]) dfs_topol(u);
  ord.push_back(v);
}
int mx[maxn];
void get_scc() {
  for (int v = 1; v <= n; v++)
    if (!mark[v]) dfs(v);
  memset(mark, 0, sizeof mark);
  int k = 0;
  while (ord.size()) {
    int v = ord.back();
    ord.pop_back();
    if (!mark[v]) {
      k++;
      bdfs(v, k);
    }
  }
  memset(mark, 0, sizeof mark);
  for (int v = 1; v <= n; v++) {
    for (auto u : g[v])
      if (com[v] != com[u]) g1[com[v]].push_back(com[u]);
    c[com[v]] += a[v];
  }
  for (int v = 1; v <= k; v++)
    if (!mark[v]) dfs_topol(v);
  int ans = 0;
  for (auto v : ord) {
    mx[v] = c[v];
    for (auto u : g1[v]) mx[v] = max(mx[v], mx[u] + c[v]);
  }
  cout << mx[com[1]];
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> K;
  for (int u = 2; u <= n; u++) {
    int v;
    cin >> v;
    gg[u].push_back(v);
    gg[v].push_back(u);
  }
  dfs_par(1);
  for (int v = 1; v <= n; v++) {
    if (gg[v].size() != 1) continue;
    if (v != 1) a[v] = 1;
    int u = get_par(v, K);
    g[v].push_back(u);
    bg[u].push_back(v);
  }
  get_scc();
}
