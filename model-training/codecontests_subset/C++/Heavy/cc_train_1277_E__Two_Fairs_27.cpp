#include <bits/stdc++.h>
using namespace std;
void bfs(long long int start, vector<vector<long long int>>& adj,
         vector<long long int>& vis) {
  vis[start] = 1;
  queue<long long int> bfs;
  bfs.push(start);
  while (!bfs.empty()) {
    long long int cur = bfs.front();
    bfs.pop();
    for (auto x : adj[cur]) {
      if (!vis[x]) {
        vis[x] = 1;
        bfs.push(x);
      }
    }
  }
}
void solve() {
  long long int n, m, a, b;
  cin >> n >> m >> a >> b;
  vector<vector<long long int>> adj(n);
  vector<vector<long long int>> adj2(n);
  vector<long long int> wt(n);
  vector<long long int> vis(n);
  vector<long long int> vis2(n);
  a--, b--;
  for (long long int i = 0; i < m; i++) {
    long long int x, y;
    cin >> x >> y;
    x--, y--;
    if (x != a && y != a) {
      adj[x].push_back(y);
      adj[y].push_back(x);
    }
    if (x != b && y != b) {
      adj2[x].push_back(y);
      adj2[y].push_back(x);
    }
  }
  bfs(b, adj, vis);
  bfs(a, adj2, vis2);
  map<long long int, long long int> rep;
  for (long long int i = 0; i < n; i++) {
    if (vis[i] && vis2[i]) rep[i] = 1;
  }
  long long int a1 = 0, a2 = 0;
  for (long long int i = 0; i < n; i++) {
    if (vis[i] && i != b && rep[i] == 0) a1++;
    if (vis2[i] && i != a && rep[i] == 0) a2++;
  }
  cout << a1 * a2 << endl;
}
signed main() {
  long long int t;
  cin >> t;
  while (t--) solve();
}
