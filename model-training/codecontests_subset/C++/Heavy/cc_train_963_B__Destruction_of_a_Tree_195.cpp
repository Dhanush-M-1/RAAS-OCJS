#include <bits/stdc++.h>
using namespace std;
const int MM = 2e5 + 5;
int n, sz[MM];
vector<int> adj[MM];
void dfs(int u, int p) {
  sz[u] = 1;
  for (int v : adj[u])
    if (v != p) {
      dfs(v, u);
      sz[u] += sz[v];
    }
}
void dfs1(int u, int p) {
  for (int v : adj[u])
    if (v != p) {
      if (sz[v] % 2 == 0) dfs1(v, u);
    }
  cout << u << "\n";
  for (int v : adj[u])
    if (v != p) {
      if (sz[v] % 2 == 1) dfs1(v, u);
    }
}
int main() {
  cin.tie(0)->sync_with_stdio(0);
  cin >> n;
  if (n % 2 == 0) {
    cout << "NO\n";
    return 0;
  }
  cout << "YES\n";
  for (int i = 1; i <= n; i++) {
    int x;
    cin >> x;
    if (x == 0) continue;
    adj[x].emplace_back(i);
    adj[i].emplace_back(x);
  }
  dfs(1, 0);
  dfs1(1, 0);
}
