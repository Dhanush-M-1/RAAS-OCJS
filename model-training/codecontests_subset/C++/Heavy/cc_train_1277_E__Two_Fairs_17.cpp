#include <bits/stdc++.h>
using namespace std;
long long int fast_expo(long long int x, long long int p) {
  if (p == 0)
    return 1;
  else if (p % 2 == 0) {
    long long int t = fast_expo(x, p / 2) % 998244353;
    return (t * t) % 998244353;
  } else
    return (x * (fast_expo(x, p - 1)) % 998244353) % 998244353;
}
vector<int> adj[200005];
int vis[200005];
int ans;
void dfs(int u, int no) {
  vis[u] = 1;
  ans++;
  for (auto v : adj[u]) {
    if (!vis[v] && v != no) dfs(v, no);
  }
}
int main() {
  int t;
  cin >> t;
  while (t--) {
    int n, m, a, b;
    cin >> n >> m >> a >> b;
    for (int i = 0; i <= n; i++) adj[i].clear(), vis[i] = 0;
    int u, v;
    for (int i = 0; i < m; i++) {
      cin >> u >> v;
      adj[u].push_back(v);
      adj[v].push_back(u);
    }
    ans = 0;
    dfs(a, b);
    long long int val1 = n - 1 - ans;
    for (int i = 0; i <= n; i++) {
      vis[i] = 0;
    }
    ans = 0;
    dfs(b, a);
    long long int val2 = n - 1 - ans;
    cout << val1 * val2 << '\n';
  }
}
