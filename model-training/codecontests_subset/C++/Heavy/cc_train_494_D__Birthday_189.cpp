#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using ld = long double;
using pii = pair<ll, ll>;
ll const N = 1e5 + 20, LG = 20, mod = 1e9 + 7;
ll n, q;
ll sz[N];
ll in1[N], out1[N];
ll in2[N], out2[N];
vector<ll> g[N];
struct edge {
  ll u, v, w;
} e[N];
ll par[LG][N], h[N], d[N];
void pre_dfs(ll v) {
  for (ll i = 1; i < LG; i++)
    if (~par[i - 1][v]) par[i][v] = par[i - 1][par[i - 1][v]];
  for (ll ed : g[v]) {
    ll u = e[ed].u ^ e[ed].v ^ v, w = e[ed].w;
    if (u != par[0][v]) {
      h[u] = h[v] + 1;
      d[u] = (d[v] + w) % mod;
      par[0][u] = v;
      pre_dfs(u);
    }
  }
}
void dfs_down(ll v, ll par = -1) {
  sz[v] = 1;
  for (ll ed : g[v]) {
    ll u = e[ed].u ^ e[ed].v ^ v, w = e[ed].w;
    if (u == par) continue;
    dfs_down(u, v);
    sz[v] += sz[u];
    in1[v] = (in1[v] + (in1[u] + 1ll * sz[u] * w % mod)) % mod;
    in2[v] = (in2[v] + (in2[u] + 1ll * w * w % mod * sz[u] % mod +
                        2ll * w * in1[u] % mod)) %
             mod;
  }
}
void dfs_up(ll v, ll par = -1) {
  for (ll ed : g[v]) {
    ll u = e[ed].u ^ e[ed].v ^ v, w = e[ed].w;
    if (u == par) continue;
    out1[u] = ((in1[v] + out1[v] - (in1[u] + 1ll * sz[u] * w % mod)) +
               1ll * (n - sz[u]) * w % mod) %
              mod;
    out2[u] =
        (out2[v] + in2[v] -
         (in2[u] + 1ll * w * w % mod * sz[u] % mod + 2ll * w * in1[u] % mod)) %
        mod;
    out2[u] =
        (out2[u] + 1ll * w * w % mod * (n - sz[u]) % mod +
         2ll * w * (in1[v] + out1[v] - (in1[u] + 1ll * sz[u] * w % mod))) %
        mod;
    dfs_up(u, v);
  }
}
inline ll lca(ll u, ll v) {
  if (h[u] > h[v]) swap(u, v);
  for (ll i = 0; i < LG; i++)
    if ((h[v] - h[u]) >> i & 1) v = par[i][v];
  if (u == v) return u;
  for (ll i = LG - 1; ~i; i--)
    if (par[i][u] != par[i][v]) {
      u = par[i][u];
      v = par[i][v];
    }
  return par[0][u];
}
int32_t main() {
  ios::sync_with_stdio(false), cin.tie(0), cout.tie(0);
  cin >> n;
  for (ll i = 0; i < n - 1; i++) {
    ll &u = e[i].u, &v = e[i].v;
    cin >> u >> v >> e[i].w;
    u--, v--;
    g[u].push_back(i);
    g[v].push_back(i);
  }
  memset(par, -1, sizeof par);
  pre_dfs(0);
  dfs_down(0);
  dfs_up(0);
  cin >> q;
  while (q--) {
    ll u, v, ans = 0;
    cin >> u >> v;
    u--, v--;
    ll l = lca(u, v);
    ll len = (d[u] + d[v] - 2 * d[l]) % mod;
    if (l == v) {
      ans = (in2[u] + out2[u] -
             (out2[v] + 1ll * len * len % mod * (n - sz[v]) % mod +
              2ll * len * out1[v]) %
                 mod) %
            mod;
      ans = (+ans - (out2[v] + 1ll * len * len % mod * (n - sz[v]) % mod +
                     2ll * len * out1[v] % mod)) %
            mod;
    } else {
      ans = (in2[u] + out2[u] -
             (in2[v] + 1ll * len * len % mod * sz[v] % mod +
              2ll * len * in1[v] % mod)) %
            mod;
      ans = (-ans + (in2[v] + 1ll * len * len % mod * sz[v] % mod +
                     2ll * len * in1[v] % mod)) %
            mod;
    }
    cout << (ans + mod) % mod << '\n';
  }
}
