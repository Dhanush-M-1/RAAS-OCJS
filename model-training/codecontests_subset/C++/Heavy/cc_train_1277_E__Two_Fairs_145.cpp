#include <bits/stdc++.h>
using namespace std;
const int MX = 200002;
vector<vector<int>> g;
bool vis[MX];
int dfs(int u, int b) {
  vis[u] = 1;
  int cnt = 0;
  for (int i = 0; i < g[u].size(); i++) {
    if (!vis[g[u][i]] && g[u][i] != b) cnt += dfs(g[u][i], b);
  }
  return cnt + 1;
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int t;
  cin >> t;
  while (t--) {
    int n, m, a, b;
    cin >> n >> m >> a >> b;
    g.resize(n + 1);
    --a;
    --b;
    for (int i = 0; i < m; i++) {
      int u, v;
      cin >> u >> v;
      --u;
      --v;
      g[u].push_back(v);
      g[v].push_back(u);
    }
    fill(vis, vis + n, 0);
    long long ans1 = n - 1 - dfs(a, b);
    fill(vis, vis + n, 0);
    long long ans2 = n - 1 - dfs(b, a);
    cout << ans1 * ans2 << "\n";
    g.clear();
  }
  return 0;
}
