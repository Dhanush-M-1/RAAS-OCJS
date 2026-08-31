#include <bits/stdc++.h>
using namespace std;
const long long N = 1e5 + 300;
const long long mod = 1e9 + 7;
const long long NN = 20 + 1;
vector<pair<long long, long long> > a[N];
long long p[N][NN], t[N], dp[N], dp2[N], sum[N], h[N], dp3[N], dp4[N], n;
void dfs2(long long v, long long par = -1, long long col = -1) {
  dp3[v] = dp[v];
  dp4[v] = dp2[v];
  if (par != -1) {
    dp4[v] = 0;
    dp3[v] = (dp3[par] + ((n - 2 * t[v] + 2 * mod) * col) % mod) % mod;
    dp4[v] = (dp4[par] + (((col * col) % mod) * (n - 1)) % mod +
              2 * (col * dp3[par]) % mod) %
             mod;
    dp4[v] += 2 * mod - (4 * dp[v] * col) % mod -
              (t[v] * 4 * ((col * col) % mod)) % mod + (col * col) % mod;
    dp4[v] %= mod;
  }
  for (long long i = 0, u, c; i < a[v].size(); i++) {
    u = a[v][i].first, c = a[v][i].second;
    if (u != par) {
      dfs2(u, v, c);
    }
  }
}
void dfs(long long v, long long par = -1) {
  p[v][0] = par;
  for (long long i = 1; i < NN; i++) {
    if (p[v][i - 1] != -1) p[v][i] = p[p[v][i - 1]][i - 1];
  }
  t[v] = 1;
  for (long long i = 0, u, c; i < a[v].size(); i++) {
    u = a[v][i].first, c = a[v][i].second;
    if (u != par) {
      sum[u] = (sum[v] + c) % mod;
      h[u] = h[v] + 1;
      dfs(u, v);
      t[v] += t[u];
      dp[v] += (dp[u] + c * t[u]) % mod;
      dp[v] %= mod;
      dp2[v] += (dp2[u] + (t[u] * ((c * c) % mod)) % mod) % mod;
      dp2[v] %= mod;
      dp2[v] += 2 * ((c * dp[u]) % mod);
      dp2[v] %= mod;
    }
  }
}
long long getp(long long v, long long k) {
  for (long long i = 0; i < NN; i++) {
    if ((k & (1 << i)) != 0) v = p[v][i];
  }
  return v;
}
long long lca(long long v, long long u) {
  if (h[u] > h[v]) swap(u, v);
  v = getp(v, h[v] - h[u]);
  if (u == v) return v;
  for (long long i = NN - 1; i >= 0; i--) {
    if (p[u][i] != p[v][i]) u = p[u][i], v = p[v][i];
  }
  return p[u][0];
}
int32_t main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  memset(p, -1, sizeof(p));
  cin >> n;
  for (long long i = 0, u, v, c; i < n - 1; i++) {
    cin >> u >> v >> c;
    u--;
    v--;
    a[u].push_back(make_pair(v, c));
    a[v].push_back(make_pair(u, c));
  }
  dfs(0);
  dfs2(0);
  long long m;
  cin >> m;
  for (long long _ = 0, u, v; _ < m; _++) {
    cin >> u >> v;
    u--;
    v--;
    long long l = lca(u, v);
    long long x = sum[u] + sum[v] - 2 * sum[l] + 2 * mod;
    x %= mod;
    long long ans =
        dp2[v] + (t[v] * ((x * x) % mod)) % mod + 2 * ((dp[v] * x) % mod);
    if (v == l) {
      long long h = (dp4[v] - dp2[v] + mod) % mod +
                    ((n - t[v]) * ((x * x) % mod)) % mod +
                    (2 * (((dp3[v] - dp[v]) * x) % mod) % mod);
      h %= mod;
      ans = dp4[u] - h + mod;
    }
    ans %= mod;
    ans *= 2;
    ans += mod - dp4[u];
    ans %= mod;
    cout << ans << "\n";
  }
  return 0;
}
