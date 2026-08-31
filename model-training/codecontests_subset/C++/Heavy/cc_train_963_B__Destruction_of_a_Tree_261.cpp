#include <bits/stdc++.h>
using namespace std;
int deg[200040], erased[200500], depth[200040];
void dfs(int x, int d, vector<vector<int>>& adj, int pa) {
  for (auto u : adj[x])
    if (u != pa) dfs(u, d + 1, adj, x);
  depth[x] = d;
}
int main() {
  int n;
  cin >> n;
  vector<vector<int>> adj(n + 1);
  int root;
  for (int i = 1; i <= n; i++) {
    int p;
    cin >> p;
    if (p == 0) {
      root = i;
      continue;
    }
    adj[p].push_back(i);
    adj[i].push_back(p);
    deg[i]++;
    deg[p]++;
  }
  dfs(root, 0, adj, 0);
  set<pair<int, int>> S;
  for (int i = 1; i <= n; i++) {
    if (deg[i] % 2 == 0) S.insert({-depth[i], i});
  }
  vector<int> res;
  while (!S.empty()) {
    int x = (*S.begin()).second;
    S.erase({-depth[x], x});
    erased[x] = 1;
    for (auto u : adj[x]) {
      if (erased[u]) continue;
      deg[u]--;
      if (deg[u] % 2 == 0) {
        S.insert({-depth[u], u});
      } else
        S.erase({-depth[u], u});
    }
    res.push_back(x);
  }
  if (res.size() != n) {
    cout << "NO";
    return 0;
  }
  cout << "YES\n";
  for (auto u : res) {
    cout << u << endl;
  }
  return 0;
}
