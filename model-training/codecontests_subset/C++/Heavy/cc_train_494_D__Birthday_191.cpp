#include <bits/stdc++.h>
using namespace std;
inline long long max(long long x, long long y) { return x > y ? x : y; }
inline long long min(long long x, long long y) { return x > y ? y : x; }
inline long long read() {
  long long x = 0, f = 1;
  char ch = getchar();
  while (!isdigit(ch)) {
    if (ch == '-') f = -1;
    ch = getchar();
  }
  while (isdigit(ch)) {
    x = x * 10 + ch - 48;
    ch = getchar();
  }
  return x * f;
}
const long long N = 1e5 + 10;
const long long mod = 1e9 + 7;
long long n, head[N], cnt, fa[N][37], dep[N], dis[N], sz[N];
long long f[N], g[N], ff[N], gg[N];
struct node {
  long long to, next, dis;
} edge[N << 1];
inline void add(long long u, long long v, long long w) {
  edge[++cnt] = {v, head[u], w};
  head[u] = cnt;
}
inline long long div(long long x) { return (x % mod + mod) % mod; }
inline void build(long long u, long long pre) {
  fa[u][0] = pre, dep[u] = dep[pre] + 1, sz[u] = 1;
  for (long long i = 0; fa[u][i]; i++) fa[u][i + 1] = fa[fa[u][i]][i];
  for (long long i = head[u]; i; i = edge[i].next) {
    long long v = edge[i].to, w = edge[i].dis;
    if (v == pre) continue;
    dis[v] = (dis[u] + w) % mod;
    build(v, u);
    sz[u] += sz[v];
    f[u] = div(f[u] + f[v] + sz[v] * w) % mod;
    g[u] =
        div(div(g[u] + g[v] + f[v] * w % mod * 2) + sz[v] * w % mod * w % mod);
  }
}
inline void dfs(long long u, long long fa) {
  for (long long i = head[u]; i; i = edge[i].next) {
    long long v = edge[i].to, w = edge[i].dis % mod;
    if (v == fa) continue;
    ff[v] = div(ff[u] + (n - 2 * sz[v]) * w);
    gg[v] = div(gg[u] + (g[u] - g[v]) % mod - sz[v] * w % mod * w % mod -
                2 * w * f[v] % mod);
    gg[v] = div(gg[v] + 2 * w * div(ff[u] - f[v] - sz[v] * w) % mod +
                w * w % mod * (n - sz[v]) % mod);
    dfs(v, u);
  }
}
inline long long LCA(long long u, long long v) {
  if (dep[u] > dep[v]) swap(u, v);
  for (long long i = 30; i >= 0; i--)
    if (dep[v] - (1 << i) >= dep[u]) v = fa[v][i];
  if (u == v) return u;
  for (long long i = 30; i >= 0; i--)
    if (fa[v][i] != fa[u][i]) v = fa[v][i], u = fa[u][i];
  return fa[u][0];
}
signed main() {
  n = read();
  long long u, v, w;
  for (long long i = 1; i < n; i++) {
    u = read(), v = read(), w = read();
    add(u, v, w);
    add(v, u, w);
  }
  build(1, 0);
  for (long long i = 1; i <= n; i++) ff[i] = f[i];
  dfs(1, 0);
  long long q = read(), ans = 0, lca, d;
  for (long long i = 1; i <= q; i++) {
    u = read(), v = read();
    lca = LCA(u, v);
    d = div(dis[u] + dis[v] - 2 * dis[lca]);
    ans = 0;
    if (lca == v) {
      ans = div(ans + g[u] + gg[u] - gg[v] - (n - sz[v]) * d % mod * d % mod -
                2 * d * (ff[v] - f[v]) % mod);
      ans = div(ans - div(gg[v] + d * d % mod * (n - sz[v]) +
                          2 * d * (ff[v] - f[v])));
    } else {
      ans = div(ans + d * d % mod * sz[v] + 2 * f[v] * d % mod + g[v]);
      ans = div(ans - div(gg[u] + g[u] - g[v] - d * d % mod * sz[v] % mod -
                          2 * f[v] * d % mod));
    }
    printf("%lld\n", ans);
  }
}
