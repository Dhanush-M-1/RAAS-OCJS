#include <bits/stdc++.h>
const int MAXN = 1e5 + 10;
const int MOD = 1e9 + 7;
int n, q;
struct Edge {
  int v, w, next;
} edge[MAXN << 1];
int head[MAXN], tail;
void insert(int u, int v, int w) {
  edge[++tail] = (Edge){v, w, head[u]};
  head[u] = tail;
}
namespace {
inline int add(int x) { return x >= MOD ? x - MOD : x; }
inline int sub(int x) { return x < 0 ? x + MOD : x; }
inline int mul(int x, int y) { return (long long)x * y % MOD; }
}  // namespace
namespace solver1 {
int son_w2[MAXN], son_w[MAXN], up_w2[MAXN], up_w[MAXN], sz[MAXN];
int anc[MAXN][21], len[MAXN], dep[MAXN];
void dfs(int u, int fa) {
  dep[u] = dep[fa] + 1;
  sz[u] = 1;
  anc[u][0] = fa;
  for (int i = 1; i <= 20; i++) anc[u][i] = anc[anc[u][i - 1]][i - 1];
  for (int i = head[u]; i; i = edge[i].next) {
    int v = edge[i].v;
    if (v == fa) continue;
    len[v] = add(len[u] + edge[i].w);
    dfs(v, u);
    sz[u] += sz[v];
    son_w2[u] =
        add(son_w2[u] +
            add(son_w2[v] + add(mul(edge[i].w * 2, son_w[v]) +
                                mul(mul(edge[i].w, edge[i].w), sz[v]))));
    son_w[u] = add(son_w[u] + add(son_w[v] + mul(edge[i].w, sz[v])));
  }
}
void dfs2(int u, int fa, int w2, int w) {
  up_w2[u] = w2;
  up_w[u] = w;
  for (int i = head[u]; i; i = edge[i].next) {
    int v = edge[i].v;
    if (v == fa) continue;
    int ww2 = add(
        w2 + sub(son_w2[u] -
                 add(son_w2[v] + add(mul(edge[i].w * 2, son_w[v]) +
                                     mul(mul(edge[i].w, edge[i].w), sz[v])))));
    int ww = add(w + sub(son_w[u] - add(son_w[v] + mul(edge[i].w, sz[v]))));
    dfs2(v, u,
         add(ww2 + add(mul(edge[i].w * 2, ww) +
                       mul(mul(edge[i].w, edge[i].w), n - sz[v]))),
         add(ww + mul(edge[i].w, n - sz[v])));
  }
}
int lca(int x, int y) {
  if (dep[x] < dep[y]) std::swap(x, y);
  int k = dep[x] - dep[y];
  for (int i = 20; i >= 0; i--) {
    if (k & (1 << i)) {
      x = anc[x][i];
    }
  }
  if (x == y) return x;
  for (int i = 20; i >= 0; i--) {
    if (anc[x][i] != anc[y][i]) {
      x = anc[x][i];
      y = anc[y][i];
    }
  }
  return anc[x][0];
}
void main() {
  dfs(1, 0);
  dfs2(1, 0, 0, 0);
  while (q--) {
    int u, v;
    scanf("%d%d", &u, &v);
    int l = lca(u, v);
    int w = sub(add(len[u] + len[v]) - add(len[l] + len[l]));
    int part2 = add(son_w2[u] + up_w2[u]), part1;
    if (l != v) {
      part1 =
          add(son_w2[v] + add(mul(w * 2, son_w[v]) + mul(mul(w, w), sz[v])));
    } else {
      part1 = sub(
          add(son_w2[u] + up_w2[u]) -
          add(add(mul(mul(w, w), n - sz[v]) + up_w2[v]) + mul(w * 2, up_w[v])));
    }
    printf("%d\n", sub(add(part1 * 2) - part2));
  }
}
}  // namespace solver1
int main() {
  scanf("%d", &n);
  for (int i = 1; i < n; i++) {
    int u, v, w;
    scanf("%d%d%d", &u, &v, &w);
    insert(u, v, w);
    insert(v, u, w);
  }
  scanf("%d", &q);
  solver1::main();
}
