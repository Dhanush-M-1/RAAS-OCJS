#include <bits/stdc++.h>
using namespace std;
const int nmax = 2e5 + 5;
const int mod = 1e9 + 7;
vector<int> g[nmax];
int destroyed;
pair<int, int> ej[nmax];
int deg[nmax], ans[nmax];
bool vis[nmax];
map<pair<int, int>, int> mp;
void dhongsho(int u, int k, int p) {
  if (vis[u]) return;
  vis[u] = true;
  destroyed++;
  for (auto v : g[u]) {
    if (v == p or vis[v]) continue;
    if (mp[{u, v}] == 0) continue;
    deg[v]--;
    if (deg[v] < k) dhongsho(v, k, u);
  }
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int n, m, k, u, v;
  cin >> n >> m >> k;
  for (int i = 1; i <= m; i++) {
    cin >> u >> v;
    g[u].push_back(v), g[v].push_back(u);
    ej[i] = {u, v};
    mp[{u, v}] = mp[{v, u}] = 1;
    deg[u]++, deg[v]++;
  }
  for (int u = 1; u <= n; u++) {
    if (deg[u] < k) dhongsho(u, k, -1);
  }
  for (int i = m; i >= 1; i--) {
    ans[i] = n - destroyed;
    u = ej[i].first, v = ej[i].second;
    if (!vis[u] and !vis[v]) {
      deg[u]--, deg[v]--;
      mp[{u, v}] = mp[{v, u}] = 0;
      if (deg[u] < k) dhongsho(u, k, v);
      if (deg[v] < k) dhongsho(v, k, u);
    }
  }
  for (int i = 1; i <= m; i++) {
    cout << ans[i] << "\n";
  }
  return 0;
}
