#include <bits/stdc++.h>
long long mo(long long x) { return x % 1000000007ll; }
struct edge {
  int to, nex;
  long long v;
} e[200010];
long long dsum[100010], dsum2[100010], alld[100010], alld2[100010], siz[100010],
    dis[100010];
int h[100010], fa[100010][17], dep[100010], tot, n;
void add(int a, int b, long long c) {
  tot++;
  e[tot].to = b;
  e[tot].v = c;
  e[tot].nex = h[a];
  h[a] = tot;
}
void dfs(int x) {
  siz[x] = 1;
  for (int i = h[x]; i; i = e[i].nex) {
    if (e[i].to != fa[x][0]) {
      dis[e[i].to] = mo(dis[x] + e[i].v);
      fa[e[i].to][0] = x;
      dep[e[i].to] = dep[x] + 1;
      dfs(e[i].to);
      siz[x] += siz[e[i].to];
      dsum[x] = mo(dsum[x] + dsum[e[i].to] + siz[e[i].to] * e[i].v);
      dsum2[x] = mo(dsum2[x] + mo(e[i].v * e[i].v) * siz[e[i].to] +
                    2ll * e[i].v * dsum[e[i].to] + dsum2[e[i].to]);
    }
  }
}
void dfs2(int x) {
  for (int i = h[x]; i; i = e[i].nex) {
    if (e[i].to != fa[x][0]) {
      alld[e[i].to] = mo(alld[x] + (n - 2ll * siz[e[i].to]) * e[i].v);
      alld2[e[i].to] =
          mo(alld2[x] +
             2ll * e[i].v *
                 mo(alld[x] - 2ll * dsum[e[i].to] - siz[e[i].to] * e[i].v) +
             (n - 2ll * siz[e[i].to]) * mo(e[i].v * e[i].v));
      dfs2(e[i].to);
    }
  }
}
void swap(int& a, int& b) {
  int c = a;
  a = b;
  b = c;
}
int lca(int x, int y) {
  if (dep[x] < dep[y]) swap(x, y);
  int i;
  for (i = 16; i >= 0; i--) {
    if (dep[fa[x][i]] >= dep[y]) x = fa[x][i];
  }
  if (x == y) return x;
  for (i = 16; i >= 0; i--) {
    if (fa[x][i] != fa[y][i]) {
      x = fa[x][i];
      y = fa[y][i];
    }
  }
  return fa[x][0];
}
int main() {
  int q, i, j, u, v, uv;
  long long w;
  scanf("%d", &n);
  for (i = 1; i < n; i++) {
    scanf("%d%d%I64d", &u, &v, &w);
    add(u, v, w);
    add(v, u, w);
  }
  dep[1] = 1;
  dfs(1);
  alld[1] = dsum[1];
  alld2[1] = dsum2[1];
  dfs2(1);
  for (j = 1; j < 17; j++) {
    for (i = 1; i <= n; i++) fa[i][j] = fa[fa[i][j - 1]][j - 1];
  }
  scanf("%d", &q);
  while (q--) {
    scanf("%d%d", &u, &v);
    uv = lca(u, v);
    if (uv == v) {
      w = mo(dis[u] - dis[v]);
      w = mo((n - siz[v]) * mo(w * w) + 2ll * w * (alld[v] - dsum[v]) +
             alld2[v] - dsum2[v]);
      w = mo(alld2[u] - 2ll * w);
    } else {
      w = mo(dis[u] + dis[v] - 2ll * dis[uv]);
      w = mo(siz[v] * mo(w * w) + 2ll * w * dsum[v] + dsum2[v]);
      w = mo(2ll * w - alld2[u]);
    }
    printf("%I64d\n", mo(w + 1000000007ll));
  }
}
