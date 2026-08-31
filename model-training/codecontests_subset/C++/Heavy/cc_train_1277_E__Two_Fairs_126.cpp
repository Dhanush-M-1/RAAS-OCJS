#include <bits/stdc++.h>
using namespace std;
long long int cnt;
bool chk;
vector<int> temp;
void dfs(vector<int> g[], bool vis[], int u, int x) {
  vis[u] = true;
  cnt++;
  temp.push_back(u);
  if (u == x) {
    chk = true;
  }
  for (auto v : g[u]) {
    if (!vis[v]) {
      dfs(g, vis, v, x);
    }
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t;
  cin >> t;
  while (t--) {
    int n, m, a, b;
    cin >> n >> m >> a >> b;
    bool vis[n + 1];
    vector<int> g[n + 1];
    for (int i = 0; i < m; i++) {
      int u, v;
      cin >> u >> v;
      g[u].push_back(v);
      g[v].push_back(u);
    }
    memset(vis, false, sizeof(vis));
    vis[a] = true;
    long long int aset = 0;
    vector<int> temp1;
    for (auto u : g[a]) {
      if (!vis[u]) {
        cnt = 0;
        chk = false;
        temp.clear();
        dfs(g, vis, u, b);
        if (!chk) {
          aset += cnt;
        } else {
          temp1 = temp;
        }
      }
    }
    for (auto item : temp1) {
      vis[item] = false;
    }
    long long int bset = 0;
    vis[b] = true;
    vis[a] = false;
    for (auto u : g[b]) {
      if (!vis[u]) {
        cnt = 0;
        chk = false;
        dfs(g, vis, u, a);
        if (!chk) {
          bset += cnt;
        }
      }
    }
    long long int ans = (aset) * (bset);
    cout << ans << "\n";
  }
  return 0;
}
