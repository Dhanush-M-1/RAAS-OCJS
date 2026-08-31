#include <bits/stdc++.h>
#pragma GCC optimize("O2")
using namespace std;
const int N = 1e5 + 10;
const long long mod = 1e9 + 7;
const long long inf = 8e18;
const int LOG = 17;
long long par[LOG][N], sub[N], sumsub[N], sumout[N], H[N], dp_down[N], dp_up[N],
    St[N], Fi[N], ptr, n;
long long dis[N];
vector<pair<long long, long long> > G[N];
inline long long zarb(long long a, long long b) { return (a * b) % mod; }
inline long long jam(long long a, long long b) {
  long long tot = a + b;
  return tot % mod;
}
inline long long taf(long long a, long long b) {
  long long ans = (a - b + 10 * mod) % mod;
  return ans;
}
inline long long P2(long long x) { return x * x % mod; }
void dfs_down(int v, int P) {
  St[v] = ++ptr;
  sub[v] = 1;
  H[v] = H[P] + 1;
  par[0][v] = P;
  for (int T = 1; T < LOG; T++) {
    par[T][v] = par[T - 1][par[T - 1][v]];
  }
  for (auto y : G[v]) {
    long long u = y.first, cost = y.second, x = P2(cost);
    if (u == P) continue;
    dis[u] = dis[v] + cost;
    dfs_down(u, v);
    sub[v] += sub[u];
    dp_down[v] = jam(dp_down[v], dp_down[u]);
    dp_down[v] = jam(dp_down[v], zarb(x, sub[u]));
    dp_down[v] = jam(dp_down[v], zarb(2 * cost, sumsub[u]));
    sumsub[v] = jam(sumsub[v], jam(sumsub[u], zarb(sub[u], cost)));
  }
  Fi[v] = ptr;
}
void dfs_up(int v, int P = 0) {
  for (auto y : G[v]) {
    long long u = y.first, cost = y.second, x = P2(cost);
    if (u == P) continue;
    long long cu = jam(dp_up[v], dp_down[v]);
    cu = taf(cu, dp_down[u]);
    cu = taf(cu, zarb(x, sub[u]));
    cu = taf(cu, zarb(2 * cost, sumsub[u]));
    long long M = jam(sumsub[u], zarb(sub[u], cost));
    sumout[u] = taf(jam(sumsub[v], sumout[v]), M);
    sumout[u] = jam(sumout[u], zarb(cost, n - sub[u]));
    cu = jam(cu, zarb(n - sub[u], x));
    cu = jam(cu, zarb(2 * cost, taf(sumout[u], zarb(n - sub[u], cost))));
    dp_up[u] = cu;
    dfs_up(u, v);
  }
}
long long LCA(long long v, long long u) {
  if (H[v] > H[u]) {
    swap(u, v);
  }
  long long del = H[u] - H[v];
  for (int T = 0; T < LOG; T++) {
    if (del & (1 << T)) {
      u = par[T][u];
    }
  }
  if (v == u) return v;
  for (int T = LOG - 1; ~T; T--) {
    if (par[T][v] != par[T][u]) {
      u = par[T][u];
      v = par[T][v];
    }
  }
  return par[0][v];
}
inline long long dist(int v, int u) {
  return dis[v] + dis[u] - 2 * dis[LCA(u, v)];
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  ;
  cin >> n;
  for (int i = 1; i < n; i++) {
    long long a, b, c;
    cin >> a >> b >> c;
    G[a].push_back(make_pair(b, c));
    G[b].push_back(make_pair(a, c));
  }
  sub[0] = n;
  dfs_down(1, 0);
  dfs_up(1, 0);
  int q;
  cin >> q;
  while (q--) {
    int v, u;
    cin >> u >> v;
    if (St[v] <= St[u] && Fi[v] >= Fi[u]) {
      long long kol = dp_down[u] + dp_up[u];
      long long cu = dp_down[u] + dp_up[u];
      long long masir = (dis[u] - dis[v]) % mod;
      long long kam = (dp_up[v] + zarb(P2(masir), (n - sub[v])) +
                       zarb(zarb(2, masir), sumout[v])) %
                      mod;
      cu = (cu - kam + mod) % mod;
      cout << (2 * cu - kol + 3 * mod) % mod << "\n";
    } else {
      long long kol = (dp_down[u] + dp_up[u]) % mod;
      long long masir = dist(u, v) % mod;
      long long cu =
          (dp_down[v] + zarb(P2(masir), sub[v]) + 2 * zarb(masir, sumsub[v])) %
          mod;
      cout << (2 * cu - kol + 3 * mod) % mod << "\n";
    }
  }
  return 0;
}
