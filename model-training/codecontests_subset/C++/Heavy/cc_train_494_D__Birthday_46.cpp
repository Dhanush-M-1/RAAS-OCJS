#include <bits/stdc++.h>
using namespace std;
template <class P, class Q>
inline void smin(P &a, Q b) {
  if (b < a) a = b;
}
template <class P, class Q>
inline void smax(P &a, Q b) {
  if (a < b) a = b;
}
const int mod = 1000000000 + 7;
const int maxn = 100000 + 100;
const int maxlg = 17 + 1;
int n, q;
vector<pair<int, int> > adj[maxn];
int par[maxlg][maxn];
int dep[maxn], dis[maxn];
int dw0[maxn], dw1[maxn], dw2[maxn];
int up0[maxn], up1[maxn], up2[maxn];
inline int fix(int x) {
  while (x < 0) x += mod;
  if (x >= mod) x -= mod;
  return x;
}
inline void addto(int &x, int y) {
  x += y;
  while (x < 0) x += mod;
  if (x >= mod) x -= mod;
}
void dfs(int u, int parent = 0, int depth = 0, int dist = 0) {
  dep[u] = depth;
  dis[u] = dist;
  par[0][u] = parent;
  for (int l = (int)(1), _n = (int)(maxlg); l < _n; l++)
    par[l][u] = par[l - 1][par[l - 1][u]];
  dw0[u] = 1;
  for (int i = 0, _n = (int)((int((adj[u]).size()))); i < _n; i++)
    if (adj[u][i].first != parent) {
      int v = adj[u][i].first, w = adj[u][i].second;
      dfs(adj[u][i].first, u, depth + 1, fix(dist + w));
      dw0[u] += dw0[v];
      addto(dw1[u], (dw1[v] + w * (long long)dw0[v]) % mod);
      addto(dw2[u], (dw2[v] + 2 * (long long)w * dw1[v] +
                     w * (long long)w % mod * dw0[v]) %
                        mod);
    }
}
void dfs_up(int u, int parent = 0, int parw = 0) {
  if (u != 0) {
    up0[u] = n - dw0[u];
    up1[u] = fix((up1[parent] + dw1[parent] + parw * (long long)n - dw1[u] -
                  2 * (long long)parw * dw0[u]) %
                 mod);
    up2[u] = fix((up2[parent] + dw2[parent] +
                  2 * (long long)parw * (up1[parent] + dw1[parent]) +
                  parw * (long long)parw % mod * n) %
                 mod);
    addto(up2[u], -(dw2[u] + 2 * (long long)2 * parw * dw1[u] +
                    4 * (long long)parw * parw % mod * dw0[u]) %
                      mod);
  }
  for (int i = 0, _n = (int)((int((adj[u]).size()))); i < _n; i++)
    if (adj[u][i].first != parent) {
      int v = adj[u][i].first, w = adj[u][i].second;
      dfs_up(v, u, w);
    }
}
int lca(int u, int v) {
  if (dep[u] > dep[v]) swap(u, v);
  for (int l = (int)(maxlg), _x = (int)(0); l-- > _x;)
    if (dep[par[l][v]] >= dep[u]) v = par[l][v];
  if (u == v) return u;
  for (int l = (int)(maxlg), _x = (int)(0); l-- > _x;)
    if (par[l][u] != par[l][v]) u = par[l][u], v = par[l][v];
  return par[0][u];
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cin >> n;
  for (int z = 0, _n = (int)(n - 1); z < _n; z++) {
    int u, v, c;
    cin >> u >> v >> c;
    u--, v--;
    adj[u].push_back(pair<int, int>(v, c));
    adj[v].push_back(pair<int, int>(u, c));
  }
  dfs(0);
  dfs_up(0);
  cin >> q;
  while (q--) {
    int u, v;
    cin >> u >> v;
    u--, v--;
    int t = lca(u, v);
    int d = fix(dis[u] - dis[t] + dis[v] - dis[t]);
    int ans = fix(dw2[u] + up2[u]);
    if (t == v) {
      addto(ans, -2 *
                     (up2[v] + 2 * (long long)d * up1[v] +
                      d * (long long)d % mod * up0[v]) %
                     mod);
    } else {
      addto(ans, -2 *
                     (dw2[v] + 2 * (long long)d * dw1[v] +
                      d * (long long)d % mod * dw0[v]) %
                     mod);
      ans = fix(-ans);
    }
    cout << ans << endl;
  }
  return 0;
}
