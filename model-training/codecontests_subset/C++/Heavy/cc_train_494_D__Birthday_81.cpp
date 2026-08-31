#include <bits/stdc++.h>
using namespace std;
const int MAXN = 100 * 1000 + 23, D = 1000 * 1000 * 1000 + 7, MXLN = 17 + 3;
int mul() { return 1; }
template <typename... T>
int mul(int x, T... a) {
  return 1ll * x * mul(a...) % D;
}
int add() { return 0; }
template <typename... T>
int add(int x, T... a) {
  return (x + add(a...)) % D;
}
int n, e[MAXN], w[MAXN], sum[MAXN], sum2[MAXN], up[MAXN], up2[MAXN], sz[MAXN],
    h[MAXN], par[MXLN][MAXN], dis[MAXN], q;
vector<int> g[MAXN];
void dfs(int v = 0, int p = -1) {
  for (auto i : g[v]) {
    int u = v ^ e[i];
    if (u == p) continue;
    h[u] = h[v] + 1;
    dis[u] = add(dis[v], w[i]);
    par[0][u] = v;
    dfs(u, v);
    sz[v] += sz[u];
    sum[v] = add(sum[v], sum[u], mul(sz[u], w[i]));
    sum2[v] =
        add(sum2[v], mul(w[i], w[i], sz[u]), sum2[u], mul(2, w[i], sum[u]));
  }
  sz[v]++;
}
void ufs(int v = 0, int p = -1) {
  int tmp = up[v], tmp2 = up2[v];
  for (auto i : g[v]) {
    int u = v ^ e[i];
    if (u == p) continue;
    tmp = add(tmp, sum[u], mul(sz[u], w[i]));
    tmp2 = add(tmp2, mul(w[i], w[i], sz[u]), sum2[u], mul(2, w[i], sum[u]));
  }
  for (auto i : g[v]) {
    int u = v ^ e[i];
    if (u == p) continue;
    up[u] = add(tmp, D - sum[u], D - mul(sz[u], w[i]), mul(w[i], (n - sz[u])));
    up2[u] = add(tmp2, D - mul(w[i], w[i], sz[u]), D - sum2[u],
                 D - mul(2, w[i], sum[u]), mul(w[i], w[i], n - sz[u]),
                 mul(2, w[i], add(tmp, D - sum[u], D - mul(sz[u], w[i]))));
    ufs(u, v);
  }
}
int lca(int u, int v) {
  if (h[u] < h[v]) swap(u, v);
  for (int i = MXLN - 1; ~i; i--)
    if (h[par[i][u]] >= h[v]) u = par[i][u];
  if (u == v) return v;
  for (int i = MXLN - 1; ~i; i--)
    if (par[i][u] != par[i][v]) {
      u = par[i][u];
      v = par[i][v];
    }
  return par[0][v];
}
int main() {
  cin >> n;
  for (int i = 1; i < n; i++) {
    int a, b, c;
    cin >> a >> b >> c;
    g[--a].push_back(i), g[--b].push_back(i);
    e[i] = a ^ b;
    w[i] = c;
  }
  dfs(), ufs();
  for (int i = 1; i < MXLN; i++)
    for (int j = 0; j < n; j++) par[i][j] = par[i - 1][par[i - 1][j]];
  cin >> q;
  while (q--) {
    int u, v;
    cin >> u >> v;
    int x = lca(--u, --v);
    if (x == v) {
      int fas = add(dis[u], D - dis[v]),
          tmp = D - add(up2[v], mul(fas, fas, (n - sz[v])), mul(2, fas, up[v]));
      cout << add(sum2[u], up2[u], tmp, tmp) << '\n';
    } else {
      int fas = ((x == u) ? add(dis[v], D - dis[u])
                          : add(dis[u], dis[v], D - dis[x], D - dis[x])),
          tmp = add(mul(fas, fas, sz[v]), sum2[v], mul(2, fas, sum[v]));
      cout << add(tmp, D - sum2[u], D - up2[u], tmp) << '\n';
    }
  }
}
