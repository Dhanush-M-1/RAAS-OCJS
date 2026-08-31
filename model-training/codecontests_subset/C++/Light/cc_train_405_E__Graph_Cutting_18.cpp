#include <bits/stdc++.h>
using namespace std;
const int MAX = 1e5 + 10, mod = 1e9 + 7, base = 41, INF = 99999999999, sq = 502;
int q, n, m, h[MAX];
vector<pair<int, pair<int, int> > > ans;
bool used[MAX], mark[MAX];
vector<int> adj[MAX];
inline void hdfs(int v) {
  mark[v] = 1;
  for (int i = 0; i < adj[v].size(); i++) {
    int u = adj[v][i];
    if (!mark[u]) {
      h[u] = h[v] + 1;
      hdfs(u);
    }
  }
}
inline void dfs(int v, int p) {
  mark[v] = 1;
  queue<int> second;
  for (int i = 0; i < adj[v].size(); i++) {
    int u = adj[v][i];
    if (!mark[u]) {
      dfs(u, v);
    }
    if (u != p && !used[u]) second.push(u);
  }
  while (second.size() > 1) {
    int x = second.front();
    second.pop();
    int y = second.front();
    used[x] = (h[x] > h[v]), used[y] = (h[y] > h[v]);
    second.pop();
    ans.push_back({x, {v, y}});
  }
  if (second.size()) {
    int x = second.front();
    used[x] = (h[x] > h[v]);
    ans.push_back({x, {v, p}});
    used[v] = 1;
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> m;
  if (m & 1) return cout << "No solution", -0;
  for (int u, v, i = 0; i < m; i++) {
    cin >> u >> v;
    adj[v].push_back(u), adj[u].push_back(v);
  }
  hdfs(1);
  memset(mark, 0, sizeof(mark));
  dfs(1, -1);
  for (int i = 0; i < ans.size(); i++) {
    cout << ans[i].first << ' ' << ans[i].second.first << ' '
         << ans[i].second.second << '\n';
  }
  return -0;
}
