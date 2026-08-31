#include <bits/stdc++.h>
using namespace std;
vector<int> g[100005];
int find(int v, int* parent) {
  if (parent[v] == v) {
    return v;
  }
  return find(parent[v], parent);
}
int vis[100005];
int dp[100005];
int dfs(int u) {
  vis[u] = 1;
  for (int i = 0; i < g[u].size(); i++) {
    int v = g[u][i];
    if (!vis[v]) dfs(v);
  }
}
int main() {
  int n;
  cin >> n;
  for (int i = 0; i < n - 1; i++) {
    int u, v;
    cin >> u >> v;
    g[u].push_back(v);
    g[v].push_back(u);
  }
  for (int i = 1; i <= n; i++) {
    if (g[i].size() == 2) {
      cout << "NO";
      return 0;
    }
  }
  cout << "YES";
  return 0;
}
