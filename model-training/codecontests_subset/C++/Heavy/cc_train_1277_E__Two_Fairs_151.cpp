#include <bits/stdc++.h>
using namespace std;
const double EPS = 1e-10;
using ll = long long;
using Pi = pair<int, int>;
using Pl = pair<ll, ll>;
void dfs(int s, int u, int a, int b, vector<vector<int>> &G, set<int> &k,
         vector<bool> &visited) {
  k.insert(u);
  visited[u] = true;
  if (s == a && u == b) return;
  if (s == b && u == a) return;
  for (int v : G[u]) {
    if (!visited[v]) dfs(s, v, a, b, G, k, visited);
  }
}
int main() {
  int t;
  cin >> t;
  while (t--) {
    int n, m, a, b;
    cin >> n >> m >> a >> b;
    a--;
    b--;
    vector<vector<int>> G(n);
    for (int i = (int)(0); i < (int)(m); i++) {
      int u, v;
      cin >> u >> v;
      u--;
      v--;
      G[u].push_back(v);
      G[v].push_back(u);
    }
    set<int> k1, k2;
    vector<bool> visited1(n, false), visited2(n, false);
    dfs(a, a, a, b, G, k1, visited1);
    dfs(b, b, a, b, G, k2, visited2);
    ll ans1 = n - k1.size(), ans2 = n - k2.size();
    cout << ans1 * ans2 << endl;
  }
}
