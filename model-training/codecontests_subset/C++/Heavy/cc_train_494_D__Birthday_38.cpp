#include <bits/stdc++.h>
using namespace std;
inline int getint() {
  int c, l = 0, x;
  for (; !isdigit(c = getchar()); l = c)
    if (c == EOF) return 1 << 31;
  for (x = c - '0'; isdigit(c = getchar()); x = x * 10 + c - '0')
    if (c == EOF) break;
  return l == '-' ? -x : x;
}
int buf[100];
inline int putint(int x) {
  int i = 0;
  x = x < 0 ? putchar('-'), -x : x;
  for (; buf[i++] = x % 10, x; x /= 10)
    ;
  for (i = i - 1 ? i - 1 : 1; i--; putchar(buf[i] + '0'))
    ;
  putchar(10);
  return 1;
}
const int N = 200100;
const int mod = 1000000007;
int K, n, m, q, tp[N], sz[N], hc[N], fa[N], clk, ne[N * 2], to[N * 2],
    da[N * 2], G[N], xb;
long long dp[N], dg[N];
struct poly {
  int a[4];
  poly() { memset(a, 0, sizeof a); }
  poly operator+(const poly& b) {
    poly c;
    for (int i = 0; i <= K; i++) c.a[i] = (a[i] + b.a[i]) % mod;
    return c;
  }
  poly operator-(const poly& b) {
    poly c;
    for (int i = 0; i <= K; i++) c.a[i] = (a[i] - b.a[i] + mod) % mod;
    return c;
  }
  poly operator<<(const long long& tt) {
    long long t = (tt % mod + mod) % mod;
    poly c;
    for (int i = K; i >= 0; i--) {
      for (int j = K; j; j--) c.a[j] = (t * c.a[j] + c.a[j - 1]) % mod;
      c.a[0] = (t * c.a[0] + a[i]) % mod;
    }
    return c;
  }
  int operator()(const long long& x) {
    long long ans = 0, s = x % mod;
    for (int i = K; i >= 0; i--) ans = (ans * s + a[i]) % mod;
    return ans;
  }
} g[N], f[N];
void add(int x, int y, long long z) {
  ne[xb] = G[x];
  to[xb] = y;
  da[xb] = z;
  G[x] = xb++;
}
int lca(int x, int y) {
  for (; tp[x] != tp[y]; x = fa[tp[x]])
    if (dp[tp[x]] < dp[tp[y]]) swap(x, y);
  return dp[x] < dp[y] ? x : y;
}
int dfn[N], dft[N];
bool is(int x, int y) { return dfn[x] <= dfn[y] && dfn[y] <= dft[x]; }
long long dst(int x, int y) {
  int z = lca(x, y);
  return dp[x] + dp[y] - 2 * dp[z];
}
void dfs2(int x) {
  f[x].a[K] = 1;
  for (int i = G[x]; ~i; i = ne[i])
    if (to[i] != fa[x]) {
      int u = to[i], v = da[i];
      dp[u] = dp[x] + v;
      fa[u] = x;
      dfs2(u);
      f[x] = f[x] + (f[u] << v);
      sz[x] += sz[u];
      if (sz[u] > sz[hc[x]]) hc[x] = u;
    }
  if (!sz[x]) sz[x] = 1;
}
void dfs3(int x, int y) {
  for (int i = G[x]; ~i; i = ne[i])
    if (to[i] != fa[x]) {
      int u = to[i];
      g[u] = (f[x] << -dp[x]) - (f[u] << dp[u] - 2 * dp[x]) + g[x];
    }
  dfn[x] = ++clk;
  tp[x] = y;
  if (hc[x]) dfs3(hc[x], y);
  for (int i = G[x]; ~i; i = ne[i])
    if (!dfn[to[i]]) dfs3(to[i], to[i]);
  dft[x] = clk;
}
int calc(int u, int v) {
  if (is(u, v)) {
    poly a = g[v] - g[u];
    return (f[v](0) + a(dp[v])) % mod;
  } else {
    poly a = f[u];
    return a(dst(v, u));
  }
}
int main() {
  n = getint();
  K = 2;
  m = n - 1;
  memset(G, -1, sizeof G);
  for (int i = 1; i <= m; i++) {
    int x = getint(), y = getint(), z = getint();
    add(x, y, z);
    add(y, x, z);
  }
  dfs2(1);
  dfs3(1, 1);
  q = getint();
  while (q--) {
    int u, v;
    v = getint();
    u = getint();
    putint(((2 * calc(u, v) - calc(1, v)) % mod + mod) % mod);
  }
}
