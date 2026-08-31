#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
using namespace std;
const int N = 2e5 + 10;
int mark[N];
vector<int> g[N];
vector<pair<int, pair<int, int> > > ans;
bool dfs(int v, int par = 0) {
  mark[v] = 1;
  vector<int> V;
  for (auto u : g[v]) {
    if (!mark[u]) {
      if (dfs(u, v)) {
        V.push_back(u);
      }
    } else if (u != par && mark[u] == 1)
      V.push_back(u);
  }
  mark[v] = 2;
  for (int i = 1; i < V.size(); i += 2) {
    ans.push_back({V[i], {v, V[i - 1]}});
  }
  if (V.size() % 2 != 0 && par != 0) {
    ans.push_back({V[V.size() - 1], {v, par}});
    return 0;
  }
  return 1;
}
int main() {
  ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  int n, m;
  cin >> n >> m;
  if (m % 2 == 1) return cout << "No solution", 0;
  for (int i = 0; i < m; i++) {
    int u, v;
    cin >> u >> v;
    g[u].push_back(v);
    g[v].push_back(u);
  }
  for (int i = 1; i <= n; i++)
    if (!mark[i]) dfs(i);
  for (auto e : ans) {
    cout << e.first << ' ' << e.second.first << ' ' << e.second.second << "\n";
  }
}
