#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 5, LOG = 20;
const long long mod = 1e9 + 7;
int n, q, st[N], fn[N], up[N][LOG], h[N], timer, idx[N];
vector<pair<int, int> > adj[N];
long long dp[N][2], sz[N][2], sum[N][2], d[N];
int add(int a, int b) {
  a += b;
  if (a >= mod) a -= mod;
  if (a < 0) a += mod;
  return a;
}
int mult(int a, int b) {
  int ret = (1LL * a * b) % mod;
  return add(ret, 0);
}
void dfs_down(int v, int p = -1) {
  for (auto e : adj[v]) {
    int u = e.first, w = e.second;
    if (u == p) continue;
    dfs_down(u, v);
    dp[v][0] = add(dp[v][0], add(dp[u][0], add(mult(sz[u][0], mult(w, w)),
                                               mult(2, mult(w, sum[u][0])))));
    sum[v][0] = add(sum[v][0], add(sum[u][0], mult(w, sz[u][0])));
    sz[v][0] += sz[u][0];
  }
  for (auto e : adj[v]) {
    int u = e.first, w = e.second;
    if (u == p) continue;
    int val = add(dp[u][0],
                  add(mult(sz[u][0], mult(w, w)), mult(2, mult(w, sum[u][0]))));
    int tmp = add(sum[u][0], mult(w, sz[u][0]));
    dp[u][1] =
        add(add(dp[v][0], -val), add(mult(w, mult(w, (sz[v][0] - sz[u][0]))),
                                     mult(2, mult(w, add(sum[v][0], -tmp)))));
    sum[u][1] = add(mult(w, sz[v][0] - sz[u][0]), add(sum[v][0], -tmp));
  }
  sz[v][0]++;
}
void dfs_up(int v, int p = -1) {
  sz[v][1] = n + 1 - sz[v][0];
  for (auto e : adj[v]) {
    int u = e.first, w = e.second;
    if (u == p) continue;
    dp[u][1] = add(dp[u][1], add(dp[v][1], add(mult(sz[v][1], mult(w, w)),
                                               mult(2, mult(w, sum[v][1])))));
    sum[u][1] = add(sum[u][1], add(sum[v][1], mult(w, sz[v][1])));
    dfs_up(u, v);
  }
}
void setup(int v, int p = -1) {
  st[v] = timer++;
  idx[st[v]] = v;
  for (int i = 1; i < LOG; i++) up[v][i] = up[up[v][i - 1]][i - 1];
  for (auto e : adj[v]) {
    int u = e.first, w = e.second;
    if (u ^ p) d[u] = add(d[v], w), up[u][0] = v, h[u] = h[v] + 1, setup(u, v);
  }
  fn[v] = timer;
}
bool is_ancestor(int v, int u) { return (st[v] <= st[u]) && (fn[u] <= fn[v]); }
int lca(int v, int u) {
  if (h[v] < h[u]) swap(v, u);
  for (int i = LOG - 1; ~i; i--)
    if (h[up[v][i]] >= h[u]) v = up[v][i];
  if (v == u) return v;
  for (int i = LOG - 1; ~i; i--)
    if (up[v][i] != up[u][i]) v = up[v][i], u = up[u][i];
  return up[v][0];
}
int dist(int v, int u) { return add(d[v], add(d[u], -mult(2, d[lca(v, u)]))); }
int main() {
  ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  cin >> n;
  for (int i = 0; i < n - 1; i++) {
    int v, u, w;
    cin >> v >> u >> w;
    v--, u--;
    adj[v].push_back({u, w});
    adj[u].push_back({v, w});
  }
  dfs_down(0);
  dfs_up(0);
  setup(0);
  cin >> q;
  while (q--) {
    int v, u;
    cin >> v >> u;
    v--, u--;
    long long res = 0, w = dist(v, u);
    if (!is_ancestor(u, v)) {
      res = mult(-1, add(dp[v][0], dp[v][1]));
      res = add(res, mult(2, add(mult(mult(w, w), sz[u][0]),
                                 add(dp[u][0], mult(2, mult(w, sum[u][0]))))));
    } else {
      res = add(res, add(dp[v][0], dp[v][1]));
      res = add(res, -mult(2, add(dp[u][1], add(mult(sz[u][1] - 1, mult(w, w)),
                                                mult(sum[u][1], mult(2, w))))));
    }
    cout << res << "\n";
  }
}
