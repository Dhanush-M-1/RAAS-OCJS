#include <bits/stdc++.h>
#pragma GCC optimize "03"
using namespace std;
const long long int N = 1e5 + 5;
const long long int mod = 1e9 + 7;
const long long int inf = 1e18 + 9;
long long int dis[N], par[N], dep[N], p[N][18], dp[N][18];
vector<pair<long long int, long long int> > g[N], h[N];
vector<pair<pair<long long int, long long int>, long long int> > ed;
vector<pair<long long int, pair<long long int, long long int> > > mst;
long long int root(long long int x) {
  return (par[x] == x) ? x : par[x] = root(par[x]);
}
void merge(long long int x, long long int y) {
  x = root(x);
  y = root(y);
  par[x] = y;
}
void dfs(long long int u, long long int pp) {
  dep[u] = dep[pp] + 1;
  for (auto i : h[u]) {
    if (i.first == pp) continue;
    p[i.first][0] = u;
    dp[i.first][0] = i.second;
    dfs(i.first, u);
  }
}
long long int query(long long int a, long long int b) {
  if (dep[a] <= dep[b]) swap(a, b);
  long long int ans = 0;
  for (long long int i = 17; i >= 0; i--) {
    if (dep[p[a][i]] >= dep[b]) ans = max(ans, dp[a][i]), a = p[a][i];
  }
  if (a == b) return ans;
  for (long long int i = 17; i >= 0; i--) {
    if (p[a][i] == p[b][i]) continue;
    ans = max(ans, dp[a][i]);
    ans = max(ans, dp[b][i]);
    a = p[a][i];
    b = p[b][i];
  }
  ans = max(ans, dp[a][0]);
  ans = max(ans, dp[b][0]);
  return ans;
}
signed main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long int n, mm, k, q;
  cin >> n >> mm >> k >> q;
  for (long long int i = 1; i <= mm; i++) {
    long long int u, v, w;
    cin >> u >> v >> w;
    g[u].push_back({v, w});
    g[v].push_back({u, w});
    ed.push_back({{u, v}, w});
  }
  multiset<pair<long long int, pair<long long int, long long int> > > m;
  for (long long int i = 1; i <= n; i++) {
    if (i <= k)
      m.insert({0, {i, i}}), dis[i] = 0;
    else
      dis[i] = inf;
  }
  while (!m.empty()) {
    auto x = *m.begin();
    m.erase(m.begin());
    if (dis[x.second.first] != x.first) continue;
    par[x.second.first] = x.second.second;
    for (auto i : g[x.second.first]) {
      if (dis[i.first] > dis[x.second.first] + i.second) {
        dis[i.first] = dis[x.second.first] + i.second;
        m.insert({dis[i.first], {i.first, x.second.second}});
      }
    }
  }
  for (auto i : ed) {
    if (par[i.first.first] == par[i.first.second]) continue;
    mst.push_back({dis[i.first.first] + dis[i.first.second] + i.second,
                   {par[i.first.first], par[i.first.second]}});
  }
  for (long long int i = 1; i <= k; i++) par[i] = i;
  sort(mst.begin(), mst.end());
  for (auto i : mst) {
    if (root(i.second.first) == root(i.second.second)) continue;
    merge(i.second.first, i.second.second);
    h[i.second.first].push_back({i.second.second, i.first});
    h[i.second.second].push_back({i.second.first, i.first});
  }
  dfs(1, 0);
  for (long long int j = 1; j < 18; j++) {
    for (long long int i = 1; i <= k; i++) {
      p[i][j] = p[p[i][j - 1]][j - 1];
      dp[i][j] = max(dp[i][j - 1], dp[p[i][j - 1]][j - 1]);
    }
  }
  while (q--) {
    long long int a, b;
    cin >> a >> b;
    cout << query(a, b) << '\n';
  }
  return 0;
}
