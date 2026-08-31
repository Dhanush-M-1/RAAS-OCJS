#include <bits/stdc++.h>
long long mod = 998244353;
using namespace std;
const long long N = 1e5 + 5;
vector<long long> g[N];
long long n;
void fail() {
  cout << "NO\n";
  exit(0);
}
long long cnt = 1;
void dfs(long long node, long long p = 0) {
  if (g[node].size() == 2) cnt = 0;
  for (long long nx : g[node]) {
    if (nx == p) continue;
    dfs(nx, node);
  }
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cin >> n;
  if (n == 2) {
    cout << "YES\n";
    return 0;
  }
  if (n == 3) fail();
  for (long long i = 1, u, v; i < n; i++) {
    cin >> u >> v;
    g[u].push_back(v);
    g[v].push_back(u);
  }
  dfs(1);
  if (cnt)
    cout << "YES";
  else
    cout << "NO";
  return 0;
}
