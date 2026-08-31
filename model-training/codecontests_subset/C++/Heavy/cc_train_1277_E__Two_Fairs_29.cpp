#include <bits/stdc++.h>
using namespace std;
const long long int M = 2e5 + 1;
vector<vector<long long int>> g(M);
vector<bool> vis(M);
vector<long long int> s(M);
void dfs(long long int u) {
  vis[u] = true;
  for (auto x : g[u]) {
    if (vis[x]) continue;
    dfs(x);
  }
}
void dfs1(long long int u) {
  s[u] = 1;
  vis[u] = true;
  for (auto x : g[u]) {
    if (vis[x]) continue;
    dfs1(x);
    s[u] += s[x];
  }
}
void solve() {
  long long int n, m, a, b;
  cin >> n >> m >> a >> b;
  for (long long int i = 0; i < m; i++) {
    long long int u, v;
    cin >> u >> v;
    g[u].push_back(v);
    g[v].push_back(u);
  }
  vector<long long int> v(n + 1, 0);
  vis[a] = true;
  dfs(b);
  bool fl1 = true;
  for (long long int i = 1; i <= n; i++) {
    v[i] += (vis[i]);
    if (vis[i] == false) {
      fl1 = false;
    }
    vis[i] = false;
  }
  vis[b] = true;
  dfs(a);
  bool fl2 = true;
  for (long long int i = 1; i <= n; i++) {
    v[i] += (vis[i]);
    if (vis[i] == false) {
      fl2 = false;
    }
    vis[i] = false;
  }
  if (fl1 || fl2) {
    cout << 0 << '\n';
    ;
  } else {
    for (long long int i = 1; i <= n; i++) {
      vis[i] = (v[i] == 2);
    }
    dfs1(a);
    long long int sa = s[a];
    for (long long int i = 1; i <= n; i++) {
      s[i] = 0;
      vis[i] = (v[i] == 2);
    }
    dfs1(b);
    long long int sb = s[b];
    cout << (sa - 1) * (sb - 1) << '\n';
    ;
  }
  for (long long int i = 1; i <= n; i++) {
    vis[i] = false;
    s[i] = 0;
    g[i].clear();
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int tc;
  tc = 1;
  cin >> tc;
  for (int i = 1; i <= tc; i++) {
    solve();
  }
  return 0;
}
