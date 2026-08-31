#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
using namespace std;
const long long N = 3e5 + 7;
long long par[N], dp[N], p, l;
vector<long long> di[N];
long long root(long long x) {
  if (x == par[x]) return x;
  return par[x] = root(par[x]);
}
inline void unite(long long x, long long y) {
  x = root(x);
  y = root(y);
  par[y] = x;
}
inline void dfs(long long v, long long parent = -1, long long dis = 0) {
  if (parent == -1) l = 0;
  if (dis >= l) p = v, l = dis;
  for (auto u : di[v])
    if (u != parent) dfs(u, v, dis + 1);
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long n, m, q, i, j, v, u, t;
  cin >> n >> m >> q;
  for (i = 0; i < n; i++) par[i] = i;
  for (i = 0; i < m; i++) {
    cin >> v >> u;
    v--, u--;
    di[v].push_back(u);
    di[u].push_back(v);
    unite(v, u);
  }
  for (i = 0; i < n; i++)
    if (root(i) == i) dfs(i), dfs(p), dp[i] = l;
  while (q--) {
    cin >> t;
    if (t == 1) {
      cin >> v;
      v--;
      cout << dp[root(v)] << '\n';
    } else {
      cin >> v >> u;
      v--, u--;
      v = root(v);
      u = root(u);
      if (v == u) continue;
      unite(v, u);
      dp[v] = max(max(dp[v], dp[u]), ((dp[v] + 1) / 2) + ((dp[u] + 1) / 2) + 1);
    }
  }
  cerr << "\nTime elapsed: " << 1000 * clock() / CLOCKS_PER_SEC << "ms\n";
  return 0;
}
