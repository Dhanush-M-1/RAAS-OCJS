#include <bits/stdc++.h>
using namespace std;
constexpr int inf32 = 0x3f3f3f3f;
constexpr long long inf64 = 0x3f3f3f3f3f3f3f3f;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0), cout.tie(0);
  int n, m;
  cin >> n >> m;
  vector<long long> a(n);
  for (int u = 0; u < (n); ++u) cin >> a[u];
  vector<vector<int> > adj(n);
  for (int i = 0; i < (m); ++i) {
    int u, v;
    cin >> u >> v, --u, --v;
    adj[u].push_back(v);
  }
  int k = 1;
  vector<int> g(n, 0), vis(n, 0);
  function<void(int)> dfs = [&](int u) {
    if (vis[u]) return;
    vis[u] = true;
    for (const int &v : adj[u]) dfs(v);
    vector<int> use(k, 0);
    for (const int &v : adj[u]) use[g[v]] = true;
    while (g[u] < k && use[g[u]]) ++g[u];
    if (g[u] >= k) ++k;
  };
  for (int u = 0; u < (n); ++u) dfs(u);
  vector<long long> f(k, 0);
  for (int u = 0; u < (n); ++u) f[g[u]] ^= a[u];
  int mx = -1;
  for (int i = 0; i < (k); ++i)
    if (f[i]) mx = i;
  if (!~mx) return !(cout << "LOSE\n");
  cout << "WIN\n";
  for (int u = 0; u < (n); ++u)
    if (g[u] == mx && (a[u] ^ f[mx]) < a[u]) {
      a[u] ^= f[mx], f[mx] = 0;
      for (const int &v : adj[u]) a[v] ^= f[g[v]], f[g[v]] = 0;
      break;
    }
  for (int u = 0; u < (n); ++u) cout << a[u] << ' ';
  cout << '\n';
  return 0;
}
