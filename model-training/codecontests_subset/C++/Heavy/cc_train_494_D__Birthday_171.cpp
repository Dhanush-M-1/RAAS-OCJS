#include <bits/stdc++.h>
using namespace std;
#pragma comment(linker, "/STACK:102400000,102400000")
int fst[(200000 + 20)], vv[(400000 + 10)], nxt[(400000 + 10)],
    cost[(400000 + 10)], e;
int n;
void init() {
  memset(fst, -1, sizeof fst);
  e = 0;
}
void add(int u, int v, int w) {
  vv[e] = v, cost[e] = w, nxt[e] = fst[u], fst[u] = e++;
}
int dep[(200000 + 20)], s[(200000 + 20)], f[(200000 + 20)], ss[(200000 + 20)],
    fs[(200000 + 20)], sz[(200000 + 20)];
int dis[(200000 + 20)];
int fa[(200000 + 20)][30];
void add(int &u, int v) {
  u += v;
  if (u >= 1000000007) u -= 1000000007;
}
int update(int s, int ss, int dis, int sz) {
  int ret = s;
  add(ret, (long long)2 * dis * ss % 1000000007);
  add(ret, (long long)sz * dis % 1000000007 * dis % 1000000007);
  return ret;
}
void dfs1(int u, int p) {
  fa[u][0] = p;
  dep[u] = dep[p] + 1;
  ss[u] = 0, s[u] = 0;
  sz[u] = 1;
  for (int i = fst[u]; ~i; i = nxt[i]) {
    int v = vv[i];
    if (v == p) continue;
    add(dis[v], (dis[u] + cost[i]) % 1000000007);
    dfs1(v, u);
    sz[u] += sz[v];
    add(ss[u], ((long long)ss[v] + (long long)cost[i] * sz[v]) % 1000000007);
    add(s[u], update(s[v], ss[v], cost[i], sz[v]));
  }
}
void dfs2(int u, int p) {
  for (int i = fst[u]; ~i; i = nxt[i]) {
    int v = vv[i];
    if (v == p) continue;
    int tmp = ((long long)ss[v] + (long long)cost[i] * sz[v]) % 1000000007;
    tmp = (1LL * ss[u] - tmp + 1000000007) % 1000000007;
    add(tmp, fs[u]);
    add(fs[v],
        ((long long)tmp + (long long)cost[i] * (n - sz[v]) % 1000000007) %
            1000000007);
    int tmp2 =
        (1LL * f[u] + s[u] - update(s[v], ss[v], cost[i], sz[v])) % 1000000007;
    tmp2 = (tmp2 + 1000000007) % 1000000007;
    add(f[v], update(tmp2, tmp, cost[i], n - sz[v]));
    dfs2(v, u);
  }
}
void lca_init() {
  for (int i = 1; i <= 20; ++i) {
    for (int j = 1; j <= n; ++j) {
      fa[j][i] = fa[fa[j][i - 1]][i - 1];
    }
  }
}
int lca(int u, int v) {
  if (dep[u] < dep[v]) swap(u, v);
  int d = dep[u] - dep[v];
  for (int j = 20; j >= 0; --j) {
    if (d & (1 << j)) u = fa[u][j];
  }
  if (u == v) return u;
  for (int j = 20; j >= 0; --j) {
    if (fa[u][j] != fa[v][j]) u = fa[u][j], v = fa[v][j];
  }
  return fa[u][0];
}
void debug() {
  for (int i = 1; i <= n; ++i) {
    printf("i %d sz %d s %d ss %d f %d fs %d dis %d\n", i, sz[i], s[i], ss[i],
           f[i], fs[i], dis[i]);
  }
}
int main() {
  scanf("%d", &n);
  int u, v, w;
  init();
  for (int i = 1; i < n; ++i) {
    scanf("%d%d%d", &u, &v, &w);
    add(u, v, w);
    add(v, u, w);
  }
  dfs1(1, 0);
  dfs2(1, 0);
  lca_init();
  int q;
  scanf("%d", &q);
  while (q--) {
    scanf("%d%d", &u, &v);
    int p = lca(u, v);
    if (p == u) {
      int len = (dis[v] - dis[u] + 1000000007) % 1000000007;
      int ans1 = update(s[v], ss[v], len, sz[v]);
      int ans2 = (1LL * f[u] + s[u] - ans1) % 1000000007;
      ans2 = (ans2 + 1000000007) % 1000000007;
      add(ans1, 1000000007 - ans2);
      printf("%d\n", ans1 % 1000000007);
    } else if (p == v) {
      int len = dis[u];
      add(len, 1000000007 - dis[v]);
      int ans2 = update(f[v], fs[v], len, n - sz[v]);
      int ans1 = (1LL * f[u] + s[u] - ans2) % 1000000007;
      ans1 = (ans1 + 1000000007) % 1000000007;
      add(ans1, 1000000007 - ans2);
      printf("%d\n", ans1 % 1000000007);
    } else {
      int len = dis[u];
      add(len, dis[v]);
      add(len, 1000000007 - (long long)2 * dis[p] % 1000000007);
      int ans1 = update(s[v], ss[v], len, sz[v]);
      int ans2 = (1LL * s[u] + f[u] - ans1) % 1000000007;
      ans2 = (ans2 + 1000000007) % 1000000007;
      add(ans1, 1000000007 - ans2);
      printf("%d\n", ans1 % 1000000007);
    }
  }
}
