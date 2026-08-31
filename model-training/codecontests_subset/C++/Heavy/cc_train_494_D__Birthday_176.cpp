#include <bits/stdc++.h>
using namespace std;
const int N = 214514;
const int mod = 1e9 + 7;
struct edge {
  int v, nt;
  long long w;
} e[N << 1];
long long sz[N], f1[N], f2[N], g1[N], g2[N], d[N];
int hd[N], s[N], in[N], fa[N], tp[N], de[N];
long long Z(long long x) { return (x % mod + mod) % mod; }
int tot, n, q, po;
void add(int x, int y, long long z) {
  e[++tot] = {y, hd[x], z};
  hd[x] = tot;
}
void dfs1(int x, int f) {
  sz[x] = 1;
  fa[x] = f;
  long long z;
  de[x] = de[f] + 1;
  for (int i = hd[x], to; i; i = e[i].nt) {
    to = e[i].v, z = e[i].w;
    if (to == f) continue;
    d[to] = d[x] + z;
    dfs1(to, x);
    sz[x] += sz[to];
    f1[x] = (f1[x] + sz[to] * z + f1[to]);
    f2[x] = (f2[x] + z * z % mod * sz[to] % mod + 2 * z % mod * f1[to] % mod +
             f2[to]);
    f1[x] = Z(f1[x]), f2[x] = Z(f2[x]);
    if (sz[s[x]] < sz[to]) s[x] = to;
  }
}
void dfs2(int x, int tf) {
  tp[x] = tf;
  long long z;
  in[x] = ++po;
  for (int i = hd[x], to; i; i = e[i].nt)
    if (e[i].v != fa[x]) {
      to = e[i].v, z = e[i].w;
      g1[to] = (g1[x] + (n - 2 * sz[to]) * z);
      g2[to] = (g2[x] + (g1[x] - 2 * f1[to]) * 2 * z % mod +
                (n - 4 * sz[to]) * z % mod * z % mod);
      g1[to] = Z(g1[to]), g2[to] = Z(g2[to]);
      if (to == s[x])
        dfs2(to, tf);
      else
        dfs2(to, to);
    }
}
int lca(int x, int y) {
  while (tp[x] != tp[y]) {
    if (de[tp[x]] < de[tp[y]]) swap(x, y);
    x = fa[tp[x]];
  }
  return de[x] < de[y] ? x : y;
}
int main() {
  scanf("%d", &n);
  long long z;
  for (int i = 1, x, y; i < n; i++)
    scanf("%d%d%lld", &x, &y, &z), add(x, y, z), add(y, x, z);
  dfs1(1, 0);
  g1[1] = f1[1], g2[1] = f2[1], dfs2(1, 1);
  scanf("%d", &q);
  for (int i = 1, x, y; i <= q; i++) {
    scanf("%d%d", &x, &y);
    int f = lca(x, y);
    z = (d[x] + d[y] - 2 * d[f] + mod) % mod;
    if (f == y)
      printf("%lld\n",
             Z(g2[x] - 2ll * (g2[y] - f2[y] + (g1[y] - f1[y]) * z * 2ll % mod +
                              z * z % mod * (n - sz[y]))));
    else
      printf("%lld\n", Z(2ll * (f2[y] + 2ll * f1[y] % mod * z +
                                z * z % mod * sz[y] % mod) -
                         g2[x]));
  }
}
