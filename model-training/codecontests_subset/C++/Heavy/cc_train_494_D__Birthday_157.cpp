#include <bits/stdc++.h>
inline long long getint() {
  register long long num = 0, sgn = 1;
  register char ch = getchar();
  for (; !isdigit(ch); ch = getchar())
    if (ch == '-') sgn = 0;
  for (; isdigit(ch); ch = getchar()) num = (num << 3) + (num << 1) + ch - '0';
  return sgn ? num : -num;
}
long long n, head[100010], next[100010 << 1], to[100010 << 1], tot = 0,
                                                               val[100010 << 1];
long long anc[100010][17 + 1];
long long dep[100010], ad[100010], ad2[100010], siz[100010], ds[100010],
    ds2[100010], dis[100010];
inline void addedge(long long u, long long v, long long w) {
  next[++tot] = head[u];
  to[tot] = v;
  val[tot] = w;
  head[u] = tot;
  next[++tot] = head[v];
  to[tot] = u;
  val[tot] = w;
  head[v] = tot;
}
inline long long sq(long long x) { return 1LL * x * x % 1000000007; }
void dfs(long long u) {
  siz[u] = 1;
  for (register long long i = head[u], v = to[i]; ~i; v = to[i = next[i]]) {
    if (anc[u][0] == v) continue;
    anc[v][0] = u;
    dep[v] = dep[u] + 1;
    dis[v] = (dis[u] + val[i]) % 1000000007;
    dfs(v);
    siz[u] += siz[v];
    ds[u] = (0LL + ds[u] + ds[v] + 1LL * siz[v] * val[i]) % 1000000007;
    ds2[u] = (0LL + ds2[u] + ds2[v] + (2LL * val[i] * ds[v]) % 1000000007 +
              (1LL * siz[v] * sq(val[i])) % 1000000007) %
             1000000007;
  }
}
void dfs2(long long u) {
  for (register long long i = head[u], v = to[i]; ~i; v = to[i = next[i]]) {
    if (anc[u][0] == v) continue;
    ad[v] = (ad[u] + (n - 2LL * siz[v]) * val[i]) % 1000000007;
    ad2[v] =
        (ad2[u] +
         2LL * val[i] * ((ad[u] - 2LL * ds[v] - siz[v] * val[i]) % 1000000007) +
         (n - 2LL * siz[v]) * ((val[i] * val[i]) % 1000000007)) %
        1000000007;
    dfs2(v);
  }
}
inline void init() {
  dep[1] = 1;
  dfs(1);
  ad[1] = ds[1];
  ad2[1] = ds2[1];
  dfs2(1);
  for (long long i = 1; i <= 17; i++)
    for (long long j = 1; j <= n; j++) anc[j][i] = anc[anc[j][i - 1]][i - 1];
}
inline long long LCA(long long x, long long y) {
  long long _x = x, _y = y;
  if (dep[x] < dep[y]) x ^= y ^= x ^= y;
  for (long long i = 17; ~i; i--)
    if (dep[anc[x][i]] >= dep[y]) x = anc[x][i];
  if (x == y) return x;
  for (long long i = 17; ~i; i--)
    if (anc[x][i] != anc[y][i]) x = anc[x][i], y = anc[y][i];
  return anc[x][0];
}
signed main() {
  n = getint();
  memset(head, -1, sizeof(head));
  for (long long i = 1, u, v, w; i < n; i++) {
    u = getint();
    v = getint();
    w = getint();
    addedge(u, v, w);
  }
  init();
  for (long long q = getint(), u, v, lca; q; q--) {
    u = getint();
    v = getint();
    lca = LCA(u, v);
    long long ans = 0;
    if (lca == v) {
      ans = (dis[u] - dis[v]) % 1000000007;
      ans = (((n - siz[v]) * sq(ans) * 1LL) % 1000000007 +
             2LL * ans * (ad[v] - ds[v]) +
             1LL * ((ad2[v] - ds2[v])) % 1000000007) %
            1000000007;
      ans = (ad2[u] - 2LL * ans) % 1000000007;
    } else {
      ans = (dis[u] + dis[v] - 2LL * dis[lca]) % 1000000007;
      ans = (siz[v] * sq(ans) + 2LL * ans * ds[v] + ds2[v]) % 1000000007;
      ans = (2LL * ans - ad2[u]) % 1000000007;
    }
    printf("%lld\n",
           ((ans + 1000000007) % 1000000007 + 1000000007) % 1000000007);
  }
  return 0;
}
