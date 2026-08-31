#include <bits/stdc++.h>
using namespace std;
pair<int, int> edge[200009];
set<int> g[200009];
int vis[200009];
int ar[200009];
int ans;
int n, m, k;
void dfs(int v) {
  if (g[v].size() >= k || vis[v] == 1) return;
  --ans;
  vis[v] = 1;
  for (auto u : g[v]) {
    g[u].erase(v);
    dfs(u);
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  cin >> n >> m >> k;
  int x, y;
  ans = n;
  for (int i = 0; i < m; ++i) {
    cin >> x >> y;
    edge[i] = {x, y};
    g[x].insert(y);
    g[y].insert(x);
  }
  for (int i = 1; i <= n; ++i) dfs(i);
  for (int i = m - 1; i >= 0; --i) {
    ar[i] = ans;
    g[edge[i].first].erase(edge[i].second);
    g[edge[i].second].erase(edge[i].first);
    dfs(edge[i].first);
    dfs(edge[i].second);
  }
  for (int i = 0; i < m; ++i) cout << ar[i] << "\n";
}
