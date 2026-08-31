#include <bits/stdc++.h>
using namespace std;
int n;
vector<int> adj[200002];
int parent[200002];
int deg[200002];
vector<int> level[200002];
void dfs(int node, int p, int l) {
  parent[node] = p;
  level[l].push_back(node);
  for (long long i = 0; i < adj[node].size(); i++)
    if (adj[node][i] != p) dfs(adj[node][i], node, l + 1);
}
void solve() {
  cin >> n;
  for (long long i = 1; i < n + 1; i++) {
    int x;
    cin >> x;
    if (x != 0) {
      adj[i].push_back(x);
      adj[x].push_back(i);
      deg[i]++;
      deg[x]++;
    }
  }
  dfs(1, 0, 0);
  vector<int> ans;
  for (int i = 200001; i >= 0; i--) {
    if (level[i].size() == 0) continue;
    for (long long j = 0; j < level[i].size(); j++) {
      int node = level[i][j];
      if (deg[node] % 2) {
        continue;
      } else {
        deg[parent[node]] -= 1;
        queue<int> Q;
        Q.push(node);
        while (!Q.empty()) {
          int fro = Q.front();
          Q.pop();
          ans.push_back(fro);
          deg[fro] = -1;
          for (long long k = 0; k < adj[fro].size(); k++) {
            if (adj[fro][k] != parent[fro]) {
              if (deg[adj[fro][k]] != -1) {
                Q.push(adj[fro][k]);
              }
            }
          }
        }
      }
    }
  }
  if (ans.size() != n) {
    cout << "NO" << endl;
    return;
  }
  cout << "YES" << endl;
  for (long long i = 0; i < n; i++) cout << ans[i] << endl;
}
int main() {
  std::ios::sync_with_stdio(false);
  ;
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  ;
  int t = 1;
  while (t--) {
    solve();
  }
  return 0;
}
