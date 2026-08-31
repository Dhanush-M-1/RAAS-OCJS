#include <bits/stdc++.h>
using std::vector;
const int maxn = 1e5 + 1;
template <class T>
inline void read(T &x) {
  T f = 1;
  x = 0;
  char s = getchar();
  while (s < '0' || s > '9') {
    if (s == '-') f = -1;
    s = getchar();
  }
  while (s >= '0' && s <= '9') {
    x = (x * 10) + (s & 15);
    s = getchar();
  }
  x *= f;
}
const long long p = 1e9 + 7;
struct Edge {
  long long u, v, w;
} e[maxn << 1];
long long head[maxn], ecnt;
inline void addedge(long long u, long long v, long long w) {
  e[++ecnt].v = v;
  e[ecnt].w = w;
  e[ecnt].u = head[u];
  head[u] = ecnt;
}
inline void add(long long u, long long v, long long w) {
  addedge(u, v, w);
  addedge(v, u, w);
}
long long f1[maxn], f[maxn], g[maxn], g1[maxn], siz[maxn], dfn[maxn], idx,
    top[maxn], fq[maxn], son[maxn], dis[maxn], n, q, a, b, c, ans, dep[maxn];
inline void dfs1(long long x, long long fa) {
  dfn[x] = (++idx);
  siz[x] = 1;
  f[x] = 0;
  fq[x] = fa;
  f1[x] = 0;
  dis[x] %= p;
  for (long long i = head[x], v; i && (v = e[i].v); i = e[i].u) {
    if (v == fa) continue;
    dis[v] = dis[x] + e[i].w;
    dep[v] = dep[x] + 1;
    dfs1(v, x);
    siz[x] += siz[v];
    if (siz[v] > siz[son[x]]) son[x] = v;
    f1[x] += (f1[v] + e[i].w * siz[v] % p);
    f1[x] %= p;
    f[x] +=
        (f[v] + f1[v] * 2 % p * e[i].w % p + siz[v] * e[i].w % p * e[i].w % p);
    f[x] %= p;
  }
}
inline void dfs2(long long x, long long topf) {
  top[x] = topf;
  if (!son[x]) return;
  dfs2(son[x], topf);
  for (long long i = head[x], v; i && (v = e[i].v); i = e[i].u) {
    if (v == son[x] || v == fq[x]) continue;
    dfs2(v, v);
  }
}
inline void dfs2(long long x) {
  for (long long i = head[x], v; i && (v = e[i].v); i = e[i].u) {
    if (v == fq[x]) continue;
    g1[v] = (g1[x] - e[i].w * siz[v] % p + e[i].w * (n - siz[v]) % p);
    g1[v] %= p;
    g[v] = ((f[v] + (g[x] - ((f[v] + 2 * e[i].w % p * f1[v] % p) % p +
                             siz[v] * e[i].w % p * e[i].w % p) %
                                p) %
                        p) %
                p +
            ((g1[x] - f1[v] - siz[v] * e[i].w % p) % p * 2 * e[i].w % p +
             (n - siz[v]) * e[i].w % p * e[i].w % p) %
                p);
    g[v] %= p;
    dfs2(v);
  }
}
inline long long LCA(long long x, long long y) {
  while (top[x] != top[y])
    (dep[top[x]] > dep[top[y]]) ? (x = fq[top[x]]) : (y = fq[top[y]]);
  return dep[x] < dep[y] ? x : y;
}
inline long long Dis(long long x, long long y) {
  return dis[x] + dis[y] - (dis[LCA(x, y)] << 1);
}
signed main() {
  read(n);
  for (long long i = 1; i <= n - 1; i++) {
    read(a);
    read(b);
    read(c);
    add(a, b, c);
  }
  dfs1(1, 0);
  dfs2(1, 1);
  g[1] = f[1];
  g1[1] = f1[1];
  dfs2(1);
  read(q);
  for (long long i = 1; i <= q; i++) {
    read(a);
    read(b);
    if ((dfn[a] >= dfn[b]) && (dfn[a] <= (dfn[b] + siz[b] - 1))) {
      long long add = (dis[a] - dis[b]), X = (g[b] - f[b]), Ans;
      Ans = (X + 2 * add % p * (g1[b] - f1[b]) % p +
             (n - siz[b]) * add % p * add) %
            p;
      Ans = (g[a] - (Ans * 2) % p);
      Ans %= p;
      printf("%lld\n", ((Ans + p) % p));
    } else {
      long long add = (Dis(a, b)) % p, X = f[b], Ans;
      Ans = (X + 2 * add % p * f1[b] % p + siz[b] * add % p * add % p);
      (Ans += p) %= p;
      Ans = ((Ans << 1) - g[a]);
      Ans %= p;
      printf("%lld\n", ((Ans + p) % p));
    }
  }
}
