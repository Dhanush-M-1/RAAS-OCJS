#include <bits/stdc++.h>
using std::max;
using std::min;
using std::sort;
using std::swap;
const int maxn = 100007;
const int maxm = 200007;
const int mod = 1e9 + 7;
struct E {
  int v, w;
} e[maxm];
int first[maxn], nt[maxm], ES;
inline void addE(int u, int v, int w) {
  e[++ES] = (E){v, w};
  nt[ES] = first[u];
  first[u] = ES;
  return;
}
int N, Q;
int fa[maxn], dep[maxn], sz[maxn], dfn[maxn], ix, son[maxn];
long long dis[maxn], sumd[maxn], sumd2[maxn], F[maxn][2], f[maxn][2];
void dfs(int u) {
  sz[u] = 1;
  dfn[u] = ++ix;
  for (int v, i = first[u]; i; i = nt[i]) {
    v = e[i].v;
    if (v == fa[u]) continue;
    dep[v] = dep[u] + 1;
    dis[v] = dis[u] + e[i].w;
    if (dis[v] >= mod) dis[v] -= mod;
    fa[v] = u;
    dfs(v);
    F[u][1] =
        ((F[u][1] + F[v][1]) % mod + 1ll * sz[v] * e[i].w % mod * e[i].w % mod +
         2ll * e[i].w * F[v][0] % mod) %
        mod;
    F[u][0] = (F[u][0] + F[v][0] + 1ll * sz[v] * e[i].w % mod) % mod;
    sz[u] += sz[v];
    if (sz[v] > sz[son[u]]) son[u] = v;
  }
  return;
}
int top[maxn];
void dfs(int u, int tp) {
  top[u] = tp;
  if (son[u]) dfs(son[u], tp);
  for (int v, i = first[u]; i; i = nt[i]) {
    v = e[i].v;
    if (v == fa[u] || v == son[u]) continue;
    dfs(v, v);
  }
  return;
}
int LCA(int x, int y) {
  while (top[x] ^ top[y]) {
    if (dep[top[x]] < dep[top[y]]) swap(x, y);
    x = fa[top[x]];
  }
  return dep[x] < dep[y] ? x : y;
}
void dfs2(int u) {
  long long d1, d2;
  for (int v, i = first[u]; i; i = nt[i]) {
    v = e[i].v;
    if (v == fa[u]) continue;
    f[v][0] = (f[u][0] + 1ll * (N - 2 * sz[v]) * e[i].w % mod) % mod;
    d1 = (F[v][0] + 1ll * sz[v] * e[i].w % mod) % mod;
    d2 = (F[v][1] + 1ll * sz[v] * e[i].w % mod * e[i].w % mod +
          2ll * e[i].w * F[v][0] % mod) %
         mod;
    f[v][1] =
        ((f[u][1] - d2 + 1ll * (N - sz[v]) * e[i].w % mod * e[i].w % mod) %
             mod +
         (2ll * e[i].w * (f[u][0] - d1) % mod + F[v][1]) % mod) %
        mod;
    dfs2(v);
  }
  return;
}
int main() {
  scanf("%d", &N);
  int u, v, w;
  for (int i = 1; i < N; i++)
    scanf("%d%d%d", &u, &v, &w), addE(u, v, w), addE(v, u, w);
  dep[1] = 1;
  dfs(1);
  dfs(1, 1);
  f[1][1] = F[1][1];
  f[1][0] = F[1][0];
  dfs2(1);
  for (int i = 1; i <= N; i++)
    (sumd[dfn[i]] += dis[i]) %= mod,
        (sumd2[dfn[i]] += dis[i] * dis[i] % mod) %= mod;
  for (int i = 1; i <= N; i++)
    (sumd[i] += sumd[i - 1]) %= mod, (sumd2[i] += sumd2[i - 1]) %= mod;
  scanf("%d", &Q);
  int lca;
  long long re, sumv, sumv1, sumv2;
  while (Q--) {
    scanf("%d%d", &u, &v);
    re = 0;
    lca = LCA(u, v);
    if (u == v) {
      re = F[u][1];
      re = 2 * re - f[u][1];
      re %= mod;
      if (re < 0) re += mod;
      printf("%lld\n", re);
      continue;
    } else if (lca == v) {
      sumv = N - sz[v];
      sumv1 = f[v][0] - F[v][0];
      sumv2 = f[v][1] - F[v][1];
      w = dis[u] - dis[v];
      sumv2 = (sumv2 + 2ll * w * sumv1 % mod + sumv * w % mod * w % mod) % mod;
      re = f[u][1] - sumv2;
      re %= mod;
      if (re < 0) re += mod;
      re = 2 * re - f[u][1];
      re %= mod;
      if (re < 0) re += mod;
      printf("%lld\n", re);
      continue;
    }
    sumv = sz[v];
    sumv1 = sumd[dfn[v] + sz[v] - 1] - sumd[dfn[v] - 1];
    if (sumv1 < 0) sumv1 += mod;
    sumv2 = sumd2[dfn[v] + sz[v] - 1] - sumd2[dfn[v] - 1];
    if (sumv2 < 0) sumv2 += mod;
    re =
        (sumv * dis[u] % mod * dis[u] % mod + sumv2 + 2 * dis[u] * sumv1 % mod +
         4 * sumv * dis[lca] % mod * dis[lca] % mod -
         4 * (sumv * dis[u] % mod + sumv1) % mod * dis[lca] % mod) %
        mod;
    if (re < 0) re += mod;
    re = 2 * re - f[u][1];
    re %= mod;
    if (re < 0) re += mod;
    printf("%lld\n", re);
  }
  return 0;
}
