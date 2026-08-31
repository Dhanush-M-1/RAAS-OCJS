#include <bits/stdc++.h>
using namespace std;
char ss[1 << 17], *A = ss, *B = ss;
inline char gc() {
  if (A == B) {
    B = (A = ss) + fread(ss, 1, 1 << 17, stdin);
    if (A == B) return EOF;
  }
  return *A++;
}
template <class T>
inline void read(T& x) {
  static char c;
  static int y;
  for (c = gc(), x = 0, y = 1; c < 48 || 57 < c; c = gc())
    if (c == '-') y = -1;
  for (; 48 <= c && c <= 57; c = gc()) x = ((x + (x << 2)) << 1) + (c ^ '0');
  x *= y;
}
const int mod = 1e9 + 7;
struct node {
  int next, to, z;
} w[200001];
int cnt, head[100001], f[100001][3], g[100001][3], ans, q;
int top[100001], fa[100001], deep[100001], n, hs[100001];
int dis[100001];
inline int add(int x, int y) { return x + y >= mod ? x + y - mod : x + y; }
inline int dec(int x, int y) { return x - y < 0 ? x - y + mod : x - y; }
inline int mul(int x, int y) { return 1ll * x * y - 1ll * x * y / mod * mod; }
inline void add_v(int x, int y, int z) {
  w[++cnt].next = head[x];
  w[cnt].to = y;
  head[x] = cnt;
  w[cnt].z = z;
}
void dfs1(int x, int da) {
  f[x][0] = 1;
  fa[x] = da;
  for (int i = head[x]; i; i = w[i].next) {
    if (w[i].to == da) continue;
    deep[w[i].to] = add(deep[x], w[i].z);
    dis[w[i].to] = dis[x] + 1;
    dfs1(w[i].to, x);
    f[x][0] += f[w[i].to][0];
    f[x][1] = add(add(f[x][1], f[w[i].to][1]), mul(f[w[i].to][0], w[i].z));
    f[x][2] = add(add(f[x][2], f[w[i].to][2]),
                  add(mul(w[i].z * 2 % mod, f[w[i].to][1]),
                      mul(mul(w[i].z, w[i].z), f[w[i].to][0])));
    if (f[w[i].to][0] > f[hs[x]][0]) hs[x] = w[i].to;
  }
}
void dfs2(int x, int tp) {
  top[x] = tp;
  if (hs[x]) dfs2(hs[x], tp);
  for (int i = head[x]; i; i = w[i].next)
    if (w[i].to != fa[x] && w[i].to != hs[x]) dfs2(w[i].to, w[i].to);
}
void dfs3(int x) {
  for (int i = head[x]; i; i = w[i].next) {
    int v = w[i].to;
    if (v == fa[x]) continue;
    g[v][0] = g[x][0] - f[v][0];
    g[v][1] = dec(g[x][1], add(mul(f[v][0], w[i].z), f[v][1]));
    g[v][2] = dec(g[x][2], add(f[v][2], add(mul(f[v][0], mul(w[i].z, w[i].z)),
                                            mul(f[v][1], w[i].z * 2 % mod))));
    g[v][2] = add(g[v][2], add(mul(mul(w[i].z, w[i].z), g[v][0]),
                               mul(w[i].z * 2 % mod, g[v][1])));
    g[v][1] = add(g[v][1], mul(w[i].z, g[v][0]));
    g[v][0] = add(g[v][0], f[v][0]);
    g[v][1] = add(g[v][1], f[v][1]);
    g[v][2] = add(g[v][2], f[v][2]);
    dfs3(v);
  }
}
inline int lca(int x, int y) {
  while (top[x] != top[y]) {
    if (dis[top[x]] < dis[top[y]]) swap(x, y);
    x = fa[top[x]];
  }
  if (dis[x] < dis[y]) swap(x, y);
  return y;
}
int main() {
  int x, y, z;
  read(n);
  for (int i = 1; i < n; i++) {
    read(x), read(y), read(z);
    add_v(x, y, z);
    add_v(y, x, z);
  }
  dfs1(1, 0);
  dfs2(1, 1);
  g[1][0] = f[1][0], g[1][1] = f[1][1], g[1][2] = f[1][2];
  dfs3(1);
  read(q);
  while (q--) {
    read(x), read(y);
    int l = lca(x, y);
    if (l == y) {
      z = dec(deep[x], deep[y]);
      ans = mul(mul(z, z), dec(g[y][0], f[y][0]));
      ans = add(ans, dec(g[y][2], f[y][2]));
      ans = add(ans, mul(z * 2 % mod, dec(g[y][1], f[y][1])));
      ans = dec(g[x][2], ans * 2 % mod);
      printf("%d\n", ans);
    } else {
      z = dec(add(deep[x], deep[y]), deep[l] * 2 % mod);
      ans = add(mul(f[y][0], mul(z, z)), mul(f[y][1], z * 2 % mod));
      ans = add(ans, f[y][2]);
      ans = dec(ans * 2 % mod, g[x][2]);
      printf("%d\n", ans);
    }
  }
  return 0;
}
