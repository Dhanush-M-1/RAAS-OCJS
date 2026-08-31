#include <bits/stdc++.h>
using namespace std;
const int maxn = 1000 * 100 + 10;
vector<pair<int, bool> > g[maxn];
vector<int> ans[maxn];
int deg[2][maxn], mark[maxn];
int n, m;
void input() {
  cin >> n >> m;
  for (int i = 0; i < m; i++) {
    int u, v;
    cin >> u >> v;
    u--, v--;
    g[u].push_back(make_pair(v, 1));
    g[v].push_back(make_pair(u, 0));
    deg[1][u]++, deg[0][v]++;
  }
}
int dfs(int v, int par) {
  int res = 0;
  mark[v] = 1;
  for (int i = 0; i < g[v].size(); i++) {
    pair<int, bool> u = g[v][i];
    if (par == u.first) res = i;
    if (!mark[u.first]) {
      int x = dfs(u.first, v);
      if (deg[1][u.first] % 2) {
        deg[u.second][v]--, deg[!u.second][v]++;
        g[v][i].second = !u.second, g[u.first][x].second = u.second;
      }
    }
  }
  return res;
}
int main() {
  input();
  if (m % 2) {
    cout << "No solution";
    return 0;
  }
  dfs(0, -1);
  for (int i = 0; i < n; i++)
    for (auto &u : g[i])
      if (u.second) ans[i].push_back(u.first);
  for (int i = 0; i < n; i++)
    for (int j = 0; j < ans[i].size() / 2; j++)
      cout << ans[i][j * 2] + 1 << " " << i + 1 << " " << ans[i][j * 2 + 1] + 1
           << endl;
  return 0;
}
