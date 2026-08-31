#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 7;
bool vis[maxn][2];
vector<int> G[maxn];
int n, m, a, b;
void dfs(int pos, int type) {
  for (int i = 0; i < G[pos].size(); i++) {
    int v = G[pos][i];
    if (vis[v][type]) continue;
    if (v != a && v != b) {
      vis[v][type] = true;
      dfs(v, type);
    }
  }
}
int main() {
  int t, u, v;
  cin >> t;
  while (t--) {
    memset(vis, false, sizeof(vis));
    cin >> n >> m >> a >> b;
    for (int i = 1; i <= n; i++) G[i].clear();
    for (int i = 0; i < m; i++) {
      cin >> u >> v;
      G[u].push_back(v);
      G[v].push_back(u);
    }
    dfs(a, 0);
    dfs(b, 1);
    long long first = 0;
    long long second = 0;
    for (int i = 1; i <= n; i++) {
      if (vis[i][0] && !vis[i][1]) first++;
      if (!vis[i][0] && vis[i][1]) second++;
    }
    cout << first * second << endl;
  }
  return 0;
}
