#include <bits/stdc++.h>
using namespace std;
const int maxlog = 13;
const int maxn = 3003;
int n;
vector<int> g[maxn];
bool vis[maxn], mark[maxn];
int pos[maxn], cnt;
int dis[maxn], r[maxn], d[maxn][maxlog];
long double ans;
void go(int v, int u) {
  if (mark[v]) return;
  for (int i = 0; v != d[u][0]; i++) {
    mark[v] = true;
    cnt++;
    pos[v] = i;
    v = d[v][0];
  }
}
void find_cycle(int v, int par = -1) {
  d[v][0] = par;
  vis[v] = true;
  for (int u : g[v])
    if (u != par)
      if (vis[u])
        go(v, u);
      else
        find_cycle(u, v);
}
void dfs(int v, int par = -1, int root = -1) {
  if (par == -1) par = root = v;
  dis[v] = dis[par] + 1;
  r[v] = root;
  d[v][0] = par;
  for (int i = 1; i < maxlog; i++) d[v][i] = d[d[v][i - 1]][i - 1];
  for (int u : g[v])
    if (!mark[u] and u != par) dfs(u, v, root);
}
int dad(int v, int h) {
  for (int i = maxlog; i--;)
    if (dis[d[v][i]] >= h) v = d[v][i];
  return v;
}
int lca(int v, int u) {
  if (dis[v] > dis[u]) swap(v, u);
  u = dad(u, dis[v]);
  if (v == u) return v;
  for (int i = maxlog; i--;)
    if (d[v][i] != d[u][i]) v = d[v][i], u = d[u][i];
  return d[v][0];
}
int pv, pu, l, l1, l2;
long double f(int v, int u) {
  pv = pos[r[v]], pu = pos[r[u]];
  if (pv == pu) {
    l = dis[v] + dis[u] - 2 * dis[lca(v, u)];
    return 1.0 / (l + 1);
  } else {
    l = cnt;
    l1 = dis[v] + dis[u] - 2 + (pv - pu + l) % l;
    l2 = dis[v] + dis[u] - 2 + (pu - pv + l) % l;
    return 1.0 / (l1 + 1) + 1.0 / (l2 + 1) - 1.0 / (l + dis[v] + dis[u] - 2);
  }
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cin >> n;
  for (int v, u, i = 0; i < n; i++) {
    cin >> v >> u;
    g[v].push_back(u);
    g[u].push_back(v);
  }
  find_cycle(0);
  for (int i = 0; i < n; i++)
    if (mark[i]) dfs(i);
  for (int i = 0; i < n; i++)
    for (int j = i + 1; j < n; j++) ans += f(i, j);
  ans = ans + ans + n;
  cout << setprecision(15) << fixed << ans << endl;
  return 0;
}
