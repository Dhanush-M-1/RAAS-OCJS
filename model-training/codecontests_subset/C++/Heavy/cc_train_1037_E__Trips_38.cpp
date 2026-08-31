#include <bits/stdc++.h>
using namespace std;
const long long N = 5e5;
const long long INF = 1e18;
const long long mod = 1e9 + 7;
set<long long> g[N], st;
long long i, j, n, m, k, ans[N], u[N], v[N];
void dfs(long long x) {
  auto it = st.lower_bound(x);
  if (*it != x || g[x].size() >= k) return;
  st.erase(it);
  for (auto to : g[x]) {
    g[to].erase(x);
    dfs(to);
  }
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin >> n >> m >> k;
  for (i = 0; i < m; ++i) {
    cin >> u[i] >> v[i];
    g[u[i]].insert(v[i]);
    g[v[i]].insert(u[i]);
  }
  for (i = 1; i <= n; ++i) st.insert(i);
  for (i = 1; i <= n; ++i) dfs(i);
  for (i = m - 1; i >= 0; --i) {
    long long x = u[i], y = v[i];
    ans[i] = st.size();
    g[x].erase(y);
    g[y].erase(x);
    dfs(x);
    dfs(y);
  }
  for (i = 0; i < m; ++i) cout << ans[i] << "\n";
}
