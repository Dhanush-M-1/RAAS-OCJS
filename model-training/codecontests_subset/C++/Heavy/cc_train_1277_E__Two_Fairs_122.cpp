#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int t;
  cin >> t;
  while (t--) {
    int n, m, a, b;
    cin >> n >> m >> a >> b;
    a--;
    b--;
    vector<vector<int> > graph(n);
    for (int i = 0; i < m; i++) {
      int u, v;
      cin >> u >> v;
      u--;
      v--;
      graph[u].push_back(v);
      graph[v].push_back(u);
    }
    int x = 0;
    vector<bool> vis(n);
    function<void(int)> dfs = [&](int u) {
      vis[u] = true;
      for (int v : graph[u]) {
        if (vis[v] || v == x) continue;
        dfs(v);
      }
    };
    x = b;
    dfs(a);
    int cnta = count(vis.begin(), vis.end(), false) - 1;
    fill(vis.begin(), vis.end(), false);
    x = a;
    dfs(b);
    int cntb = count(vis.begin(), vis.end(), false) - 1;
    cout << (long long)cnta * cntb << '\n';
  }
  return 0;
}
