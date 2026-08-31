#include <bits/stdc++.h>
#pragma GCC optimize("O3")
#pragma GCC target("sse4")
using namespace std;
using ii = pair<int, int>;
using ll = long long;
const int N = 1e5 + 5;
const int mod = 1e9 + 7;
void kill() {
  cout << "No solution\n";
  exit(0);
}
int n, m;
set<int> adj[N];
int dfs(int u) {
  vector<int> out;
  while (adj[u].size()) {
    int v = *adj[u].begin();
    adj[v].erase(u);
    adj[u].erase(v);
    int w = dfs(v);
    if (~w) {
      cout << u << ' ' << v << ' ' << w << '\n';
    } else {
      out.push_back(v);
    }
  }
  for (int i = out.size() & 1; i < out.size(); i += 2) {
    cout << out[i] << ' ' << u << ' ' << out[i + 1] << '\n';
  }
  if (out.size() & 1) return out[0];
  return -1;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin >> n >> m;
  if (m & 1) {
    kill();
  }
  for (int i = 0, u, v; i < m; i++) {
    cin >> u >> v;
    adj[u].insert(v);
    adj[v].insert(u);
  }
  dfs(1);
  return 0;
}
