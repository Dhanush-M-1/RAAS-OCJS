#include <bits/stdc++.h>
#pragma GCC optimize("O3")
#pragma comment(linker, "/stack:200000000")
#pragma GCC optimize("unroll-loops")
using namespace std;
long long md = 1000 * 1000 * 1000 + 7;
long long pw(long long a, long long b) {
  long long c = 1, m = a;
  while (b) {
    if (b & 1) c = (c * m) % md;
    m = (m * m) % md;
    b /= 2;
  }
  return c;
}
long long mul(long long a, long long b, long long c, long long d) {
  return (((((a * b) % md) * c) % md) * d) % md;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  ;
  int u, v, i, j, k, l, n, m, f;
  cin >> n >> m;
  int p[n + 1], inv[n + 1], is[n + 1];
  for (i = 1; i < 1 + n; ++i) cin >> p[i], inv[p[i]] = i, is[i] = 0;
  vector<int> adj[n + 1];
  for (i = 0; i < m; ++i) {
    cin >> u >> v;
    adj[inv[u]].push_back(inv[v]);
    if (inv[v] == n) is[inv[u]] = 1;
  }
  for (i = 1; i < n; ++i) sort(adj[i].begin(), adj[i].end());
  vector<int> next(n + 1);
  int ans = 0;
  j = n;
  for (i = n - 1; i >= 1; --i) {
    next[i] = j;
    if (!is[i] || adj[i].empty()) {
      j = i;
      continue;
    }
    int ind = lower_bound(adj[i].begin(), adj[i].end(), i) - adj[i].begin();
    if (adj[i][ind] > j) {
      j = i;
      continue;
    }
    f = 1;
    for (l = ind + 1; l < adj[i].size(); ++l) {
      if (adj[i][l] > next[adj[i][l - 1]]) f = 0;
      if (!f) break;
    }
    if (f)
      ans++;
    else
      j = i;
  }
  cout << ans;
  return 0;
}
