#include <bits/stdc++.h>
using namespace std;
const int mod = 1e9 + 7;
long double pi = acosl(-1);
const long long infl = 1e17 + 100;
const int inf = 1e9 + 100;
const int nmax = 3000 + 10;
const int MAXLG = log2(nmax) + 1;
vector<int> g[nmax];
int depth[nmax];
int par[nmax];
int LCA[nmax][nmax];
int recc(int u, int v) {
  if (u == v) return u;
  if (LCA[u][v] != 0) return LCA[u][v];
  if (depth[u] < depth[v]) swap(u, v);
  if (depth[u] != depth[v]) return LCA[u][v] = recc(par[u], v);
  return LCA[u][v] = recc(par[u], par[v]);
}
int dist(int u, int v) {
  int w = recc(u, v);
  if (w < 0) {
    cout << "jahmela fr " << u << " " << v << endl;
  }
  return -depth[w] + depth[u] - depth[w] + depth[v];
}
int cycnod[nmax];
int getrut[nmax];
void dfs(int u, int level, int rut, int p = -1) {
  depth[u] = level;
  par[u] = p;
  getrut[u] = rut;
  for (int v : g[u])
    if (v != p and !cycnod[v]) dfs(v, level + 1, rut, u);
}
bool vis[nmax];
vector<int> saicel;
bool done;
void dfs0(int u, int p = -1) {
  vis[u] = true;
  par[u] = p;
  for (int v : g[u])
    if (v != p) {
      if (vis[v]) {
        int cur = u;
        cycnod[v] = true;
        saicel.push_back(v);
        while (cur != v)
          cycnod[cur] = true, saicel.push_back(cur), cur = par[cur];
        done = true;
      } else
        dfs0(v, u);
      if (done) return;
    }
}
int D[nmax][nmax];
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int n;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    int u, v;
    cin >> u >> v;
    g[u].push_back(v);
    g[v].push_back(u);
  }
  long double ans = 0.0;
  dfs0(0);
  for (int i = 0; i < saicel.size(); i++)
    for (int j = 0; j < saicel.size(); j++)
      D[saicel[i]][saicel[j]] = abs(i - j);
  for (int i = 0; i < n; i++)
    if (cycnod[i]) dfs(i, 0, i);
  for (int i = 0; i < n; i++)
    for (int j = 0; j < n; j++) {
      if (getrut[i] == getrut[j]) {
        ans += 1.0 / (dist(i, j) + 1);
      } else {
        double X = depth[i] + depth[j] + 2;
        int ri = getrut[i], rj = getrut[j];
        double Y = D[ri][rj];
        double Z = (int)saicel.size() - Y;
        Y -= 1.0, Z -= 1.0;
        ans += 1.0 / (X + Y) + 1.0 / (X + Z) - 1.0 / (X + Y + Z);
      }
    }
  cout << fixed << setprecision(12) << ans << endl;
}
