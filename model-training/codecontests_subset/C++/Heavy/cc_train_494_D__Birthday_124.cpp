#include <bits/stdc++.h>
using namespace std;
const int maxn = 100050, maxb = 18, mod = 1e9 + 7;
inline int Add(int x, int y) { return (x += y) >= mod ? x - mod : x; }
inline int Dec(int x, int y) { return (x -= y) < 0 ? x + mod : x; }
inline int Mul(int x, int y) { return 1LL * x * y % mod; }
struct Element {
  int siz;
  long long sum, sum2;
  Element(int siz = 0, int sum = 0, int sum2 = 0)
      : siz(siz), sum(sum), sum2(sum2) {}
  Element operator+(Element yy) {
    return Element(siz + yy.siz, Add(sum, yy.sum), Add(sum2, yy.sum2));
  }
  Element operator-(Element yy) {
    return Element(siz - yy.siz, Dec(sum, yy.sum), Dec(sum2, yy.sum2));
  }
  Element calc(int c) {
    return Element(siz, Add(sum, Mul(c, siz)),
                   Add(sum2, Mul(c, Add(Mul(2, sum), Mul(c, siz)))));
  }
};
int n, q;
int es = 0, he[maxn], ne[maxn * 2], to[maxn * 2], w[maxn * 2];
int dep[maxn], fa[maxn][maxb];
int d[maxn][maxb];
Element v[maxn], vv[maxn][maxb];
void ins(int x, int y, int z) {
  ne[++es] = he[x], he[x] = es, to[es] = y, w[es] = z;
}
void dfs(int x) {
  int i, y, f0 = fa[x][0];
  dep[x] = dep[f0] + 1;
  for (i = 0; fa[x][i]; i++) {
    fa[x][i + 1] = fa[fa[x][i]][i];
    d[x][i + 1] = Add(d[x][i], d[fa[x][i]][i]);
  }
  v[x].siz = 1;
  for (i = he[x]; i; i = ne[i])
    if ((y = to[i]) != f0) {
      fa[y][0] = x;
      d[y][0] = w[i];
      dfs(y);
      v[x] = v[x] + v[y].calc(w[i]);
    }
}
void dfs2(int x) {
  int i, y, f0 = fa[x][0], d0 = d[x][0];
  if (x != 1) vv[x][0] = (v[f0] - v[x].calc(d0)).calc(d0);
  for (i = 0; fa[x][i + 1]; i++)
    vv[x][i + 1] = vv[x][i] + vv[fa[x][i]][i].calc(d[x][i]);
  for (i = he[x]; i; i = ne[i])
    if ((y = to[i]) != f0) dfs2(y);
}
int LCA(int x, int y) {
  if (dep[x] < dep[y]) swap(x, y);
  int i;
  for (i = maxb - 1; i >= 0; i--)
    if (dep[x] - dep[y] >= 1 << i) x = fa[x][i];
  if (x == y) return x;
  for (i = maxb - 1; i >= 0; i--)
    if (fa[x][i] != fa[y][i]) x = fa[x][i], y = fa[y][i];
  return fa[x][0];
}
int get_dis(int x, int f) {
  int i, k = dep[x] - dep[f], s = 0;
  for (i = maxb - 1; i >= 0; i--)
    if (k >= 1 << i) k -= 1 << i, s = Add(s, d[x][i]), x = fa[x][i];
  return s;
}
Element get(int x, int f) {
  int i, k = dep[x] - dep[f], d0 = 0;
  Element s;
  for (i = maxb - 1; i >= 0; i--)
    if (k >= 1 << i)
      k -= 1 << i, s = s + vv[x][i].calc(d0), d0 = Add(d0, d[x][i]),
                   x = fa[x][i];
  return s;
}
int query(int x, int y) {
  int lca = LCA(x, y), dx = get_dis(x, lca), dy = get_dis(y, lca), s = 0;
  if (lca == x) {
    int t = v[y].calc(dy).sum2;
    s = Dec(t, Add(get(x, 1).sum2, Dec(v[x].sum2, t)));
  } else if (lca == y)
    s = Dec(Add(get(x, y).sum2, v[x].sum2), get(y, 1).calc(dx).sum2);
  else {
    int t = v[y].calc(Add(dx, dy)).sum2;
    s = Dec(t, Add(v[x].sum2, Dec(get(x, 1).sum2, t)));
  }
  return s;
}
int main() {
  int i, x, y, z;
  scanf("%d", &n);
  for (i = 1; i < n; i++)
    scanf("%d%d%d", &x, &y, &z), ins(x, y, z), ins(y, x, z);
  dfs(1);
  dfs2(1);
  scanf("%d", &q);
  while (q--) {
    scanf("%d%d", &x, &y);
    printf("%d\n", query(x, y));
  }
  return 0;
}
