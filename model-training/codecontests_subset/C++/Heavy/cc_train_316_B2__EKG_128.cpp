#include <bits/stdc++.h>
using namespace std;
const int N = 1000;
int color[N], now;
vector<int> G[N], parts[N], path, d;
bool dp[N + 1];
void dfs(int v) {
  path.push_back(v);
  if (G[v].empty()) {
    reverse(path.begin(), path.end());
    for (int i = 0; i < path.size(); i++) color[path[i]] = now;
    parts[now++] = path;
    path.clear();
    return;
  }
  for (int i = 0; i < G[v].size(); i++) {
    int u = G[v][i];
    if (color[u] != -1) {
      reverse(path.begin(), path.end());
      for (int j = 0; j < path.size(); j++) {
        color[path[j]] = color[u];
        parts[color[u]].push_back(path[j]);
      }
      path.clear();
      return;
    }
    dfs(u);
  }
}
int main() {
  int n, x, u, cnt = 0;
  cin >> n >> x;
  x--;
  for (int i = 0; i < n; i++) {
    cin >> u;
    if (u) G[i].push_back(u - 1);
  }
  for (int i = 0; i < n; i++) color[i] = -1;
  for (int i = 0; i < n; i++)
    if (color[i] == -1) dfs(i);
  int pos = -1;
  for (int i = 0; i < now; i++) {
    bool good = 0;
    for (int j = 0; j < parts[i].size(); j++)
      if (parts[i][j] == x) {
        pos = j + 1;
        good = 1;
        break;
      }
    if (!good) d.push_back(parts[i].size());
  }
  dp[0] = 1;
  for (int i = 0; i < d.size(); i++)
    for (int j = N - d[i]; j >= 0; j--)
      if (dp[j]) dp[j + d[i]] = 1;
  for (int i = 0; i <= N; i++)
    if (dp[i]) cout << i + pos << endl;
  return 0;
}
