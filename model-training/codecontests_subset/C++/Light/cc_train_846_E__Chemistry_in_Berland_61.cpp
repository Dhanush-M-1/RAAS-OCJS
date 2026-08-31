#include <bits/stdc++.h>
using namespace std;
const long long inf = 1e18;
long long n, a[100005], b[100005], fa[100005], k[100005];
vector<long long> edge[100005];
long long f[100005];
void dfs(long long x) {
  f[x] = a[x];
  for (long long i = 0; i < edge[x].size(); ++i) {
    long long v = edge[x][i];
    dfs(v);
    if (f[v] < 0)
      f[x] += max(1.0 * f[v] * k[v], -1e18);
    else
      f[x] += f[v];
    f[x] = max(f[x], -inf);
  }
}
signed main() {
  ios::sync_with_stdio(0);
  cin >> n;
  for (long long i = 1; i <= n; ++i) cin >> b[i];
  for (long long i = 1; i <= n; ++i) {
    cin >> a[i];
    a[i] = b[i] - a[i];
  }
  for (long long i = 2; i <= n; ++i) {
    cin >> fa[i] >> k[i];
    edge[fa[i]].push_back(i);
  }
  dfs(1);
  puts(f[1] >= 0 ? "YES" : "NO");
  return 0;
}
