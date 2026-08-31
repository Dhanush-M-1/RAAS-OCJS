#include <bits/stdc++.h>
using namespace std;
const int mod = 1e9 + 7;
const long long N = 100005;
long long cnt, head[N], u, v, n, q, w, ff[N][22], Dfn, in[N], out[N], dis[N],
    dep[N], val[N];
struct node {
  long long to, next, w;
} num[N << 1];
struct func {
  long long a, b, c;
} f[N], g[N];
void up(long long &x, long long y) {
  x = x - mod + y;
  x = (x < 0) ? x + mod : x;
}
void add(long long x, long long y, long long w) {
  num[++cnt].to = y;
  num[cnt].next = head[x];
  num[cnt].w = w;
  head[x] = cnt;
}
void dfs(long long x, long long fa) {
  in[x] = ++Dfn;
  for (long long i = head[x]; i; i = num[i].next)
    if (num[i].to != fa) {
      ff[num[i].to][0] = x;
      dis[num[i].to] = ((long long)dis[x] + num[i].w) % mod;
      dep[num[i].to] = dep[x] + 1;
      dfs(num[i].to, x);
      long long a = f[num[i].to].a, b = f[num[i].to].b, c = f[num[i].to].c;
      up(f[x].a, a);
      up(f[x].b,
         ((long long)b + (long long)2 * a % mod * num[i].w % mod) % mod);
      up(f[x].c,
         ((long long)c + (long long)a * num[i].w % mod * num[i].w % mod +
          (long long)b * num[i].w % mod) %
             mod);
    }
  up(f[x].a, 1);
  out[x] = Dfn;
}
void dfs1(long long x, long long fa) {
  if (fa) {
    long long a = f[x].a, b = f[x].b, c = f[x].c, w = val[x];
    g[x].a = ((long long)f[fa].a - a + mod) % mod;
    g[x].b =
        (((long long)f[fa].b - b - (long long)2 * a % mod * w % mod) % mod +
         mod) %
        mod;
    g[x].c = (((long long)f[fa].c - c - (long long)a * w % mod * w % mod -
               (long long)b * w % mod) %
                  mod +
              mod) %
             mod;
    a = g[fa].a, b = g[fa].b, c = g[fa].c;
    w = val[fa];
    up(g[x].a, a);
    up(g[x].b, ((long long)b + (long long)2 * a % mod * w % mod) % mod);
    up(g[x].c, ((long long)c + (long long)a * w % mod * w % mod +
                (long long)b * w % mod) %
                   mod);
  }
  for (long long i = head[x]; i; i = num[i].next)
    if (num[i].to != fa) val[num[i].to] = num[i].w, dfs1(num[i].to, x);
}
void init() {
  for (long long j = 1; j <= 20; j++)
    for (long long i = 1; i <= n; i++) ff[i][j] = ff[ff[i][j - 1]][j - 1];
}
long long lca(long long x, long long y) {
  if (dep[x] < dep[y]) swap(x, y);
  long long del = dep[x] - dep[y];
  for (long long i = 0; i <= 20; i++)
    if (del & (1 << i)) x = ff[x][i];
  if (x == y) return x;
  for (long long i = 20; i >= 0; i--)
    if (ff[x][i] != ff[y][i]) x = ff[x][i], y = ff[y][i];
  return ff[x][0];
}
long long dist(long long x, long long y) {
  return ((long long)dis[x] + dis[y] - (long long)2 * dis[lca(x, y)] % mod +
          mod) %
         mod;
}
long long qry_F(long long x, long long y) {
  return ((long long)x * x % mod * f[y].a % mod + (long long)x * f[y].b % mod +
          f[y].c) %
         mod;
}
long long qry_G(long long x, long long y) {
  return ((long long)x * x % mod * g[y].a % mod + (long long)x * g[y].b % mod +
          g[y].c) %
         mod;
}
long long D(long long u, long long v) {
  if (in[v] <= in[u] && in[u] <= out[v]) {
    return (((long long)qry_F(0, u) + qry_G(val[u], u) -
             qry_G(((long long)dis[u] - dis[ff[v][0]] + mod) % mod, v)) %
                mod +
            mod) %
           mod;
  } else {
    return qry_F(dist(u, v), v);
  }
}
signed main() {
  scanf("%lld", &n);
  for (long long i = 1; i < n; i++)
    scanf("%lld%lld%lld", &u, &v, &w), add(u, v, w), add(v, u, w);
  dfs(1, 0);
  dfs1(1, 0);
  init();
  scanf("%lld", &q);
  while (q--) {
    scanf("%d%d", &u, &v);
    printf("%lld\n", ((long long)2 * D(u, v) % mod - D(u, 1) + mod) % mod);
  }
  return 0;
}
