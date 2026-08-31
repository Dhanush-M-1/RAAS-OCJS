#include <bits/stdc++.h>
using namespace std;
const int mod = 1e9 + 7;
const int maxn = 2e5 + 10;
pair<int, int> edge[maxn];
map<pair<int, int>, int> mp;
vector<int> g[maxn];
int vis[maxn];
queue<int> q;
int du[maxn];
int ans[maxn];
int main() {
  std::ios::sync_with_stdio(false);
  int n, m, k;
  cin >> n >> m >> k;
  for (int i = 1; i <= m; i++) {
    int u, v;
    cin >> u >> v;
    edge[i].first = u;
    edge[i].second = v;
    du[u]++;
    du[v]++;
    g[u].push_back(v);
    g[v].push_back(u);
  }
  for (int i = 1; i <= n; i++) {
    if (du[i] < k) {
      vis[i] = 1;
      q.push(i);
    }
  }
  while (!q.empty()) {
    int u = q.front();
    du[u]--;
    q.pop();
    for (int i = 0; i < g[u].size(); i++) {
      int v = g[u][i];
      mp[make_pair(u, v)] = 1;
      mp[make_pair(v, u)] = 1;
      du[v]--;
      if (vis[v] == 0 && du[v] < k) {
        q.push(v);
        vis[v] = 1;
      }
    }
  }
  for (int i = 1; i <= n; i++) {
    if (vis[i] == 0) ans[m]++;
  }
  for (int i = m - 1; i >= 1; i--) {
    ans[i] = ans[i + 1];
    int x = edge[i + 1].first;
    int y = edge[i + 1].second;
    if (mp[make_pair(x, y)] == 1 || mp[make_pair(x, y)] == 1) {
      continue;
    }
    mp[make_pair(x, y)] = 1;
    mp[make_pair(x, y)] = 1;
    du[x]--;
    du[y]--;
    if (vis[x] == 0 && du[x] < k) {
      q.push(x);
      vis[x] = 1;
      ans[i]--;
    }
    if (vis[y] == 0 && du[y] < k) {
      q.push(y);
      vis[y] = 1;
      ans[i]--;
    }
    while (!q.empty()) {
      int u = q.front();
      q.pop();
      for (int t = 0; t < g[u].size(); t++) {
        int v = g[u][t];
        if (mp[make_pair(u, v)] == 1 || mp[make_pair(v, u)] == 1) {
          continue;
        }
        mp[make_pair(u, v)] = 1;
        mp[make_pair(v, u)] = 1;
        du[v]--;
        du[u]--;
        if (vis[v] == 0 && du[v] < k) {
          q.push(v);
          vis[v] = 1;
          ans[i]--;
        }
      }
    }
  }
  for (int i = 1; i <= m; i++) {
    cout << ans[i] << endl;
  }
  return 0;
}
