#include <bits/stdc++.h>
using namespace std;
const long long mxn = 1e5 + 5;
long long n, m;
long long a[mxn], b[mxn];
long double c[mxn];
vector<pair<long long, long long> > g[mxn];
long long ord[mxn], cur;
long long fa[mxn], kk[mxn];
inline void dfs(long long x, long long par = 0, long long tk = 0) {
  fa[x] = par;
  kk[x] = tk;
  for (long long i = 0; i < g[x].size(); ++i) {
    long long y = g[x][i].first, t = g[x][i].second;
    if (y == par) continue;
    dfs(y, x, t);
  }
  ord[++cur] = x;
}
inline void solve() {
  cin >> n;
  for (long long i = 1; i <= n; ++i) cin >> b[i];
  for (long long i = 1; i <= n; ++i) cin >> a[i], c[i] = b[i] - a[i];
  for (long long i = 2; i <= n; ++i) {
    long long x, d;
    cin >> x >> d;
    g[x].push_back(make_pair(i, d));
    g[i].push_back(make_pair(x, d));
  }
  dfs(1);
  for (long long ti = 1; ti < n; ++ti) {
    long long i = ord[ti];
    long long p = fa[i];
    if (c[i] > 0)
      c[p] += c[i];
    else
      c[p] += c[i] * kk[i];
    if (c[p] < -400000000000000000ll) {
      cout << "NO\n";
      exit(0);
    }
  }
  if (c[1] >= 0)
    printf("YES");
  else
    printf("NO");
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0), cout.tie(0);
  long long T = 1;
  for (; T--;) solve();
}
