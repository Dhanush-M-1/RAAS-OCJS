#include <bits/stdc++.h>
using namespace std;
const long long MOD = 1000000007;
const int MAXN = 100010;
int n;
struct edge {
  int t;
  long long w;
  edge *next;
} epool[MAXN * 2], *e[MAXN];
int psz;
int dep[MAXN], fa[MAXN][21];
long long dis[MAXN];
struct S {
  long long size, sum, sum2;
  S() {}
  S(long long size, long long sum, long long sum2)
      : size(size), sum(sum), sum2(sum2) {}
  S operator+(long long d) const {
    return S(size, (sum + d * size % MOD) % MOD,
             (sum2 + 2 * d * sum % MOD + d * d % MOD * size % MOD) % MOD);
  }
  S &operator+=(const S &b) {
    size += b.size, sum += b.sum, sum2 += b.sum2;
    size %= MOD, sum %= MOD, sum2 %= MOD;
    return *this;
  }
  S &operator-=(const S &b) {
    size += MOD - b.size, sum += MOD - b.sum, sum2 += MOD - b.sum2;
    size %= MOD, sum %= MOD, sum2 %= MOD;
    return *this;
  }
} f[MAXN], g[MAXN];
void addedge(int u, int v, long long w) {
  epool[psz] = (edge){v, w, e[u]};
  e[u] = epool + psz++;
}
void init() {
  psz = 0, memset(e, 0, sizeof(e));
  scanf("%d", &n);
  for (int i = 1; i < n; ++i) {
    int u, v, w;
    scanf("%d%d%d", &u, &v, &w);
    addedge(u, v, w % MOD);
    addedge(v, u, w % MOD);
  }
}
void dfs1(int u) {
  f[u] = S(1, 0, 0);
  for (int i = 0; i < 20; ++i) fa[u][i + 1] = fa[fa[u][i]][i];
  for (edge *i = e[u]; i; i = i->next) {
    int v = i->t;
    if (v == fa[u][0]) continue;
    fa[v][0] = u;
    dep[v] = dep[u] + 1;
    dis[v] = (dis[u] + i->w) % MOD;
    dfs1(v);
    f[u] += f[v] + i->w;
  }
}
void dfs2(int u) {
  for (edge *i = e[u]; i; i = i->next) {
    int v = i->t;
    if (v == fa[u][0]) continue;
    g[v] = g[u] + i->w;
    g[v] += f[u] + i->w;
    g[v] -= f[v] + i->w * 2 % MOD;
    dfs2(v);
  }
}
int lca(int u, int v) {
  if (dep[u] < dep[v]) swap(u, v);
  for (int i = 20; i >= 0; --i) {
    if (dep[fa[u][i]] >= dep[v]) u = fa[u][i];
  }
  if (u == v) return u;
  for (int i = 20; i >= 0; --i) {
    if (fa[u][i] != fa[v][i]) u = fa[u][i], v = fa[v][i];
  }
  return fa[u][0];
}
void solve() {
  int q;
  scanf("%d", &q);
  while (q--) {
    int u, v;
    scanf("%d%d", &u, &v);
    int w = lca(u, v);
    long long d = ((dis[u] + dis[v] - dis[w] * 2) % MOD + MOD) % MOD;
    S s1, s2;
    if (w == v) {
      s2 = g[v] + d;
      s1 = f[u];
      s1 += g[u];
      s1 -= s2;
    } else {
      s1 = f[v] + d;
      s2 = f[u];
      s2 += g[u];
      s2 -= s1;
    }
    s1 -= s2;
    printf("%d\n", (int)s1.sum2);
  }
}
int main() {
  init();
  dep[1] = 1, dis[1] = 0;
  dfs1(1);
  dfs2(1);
  solve();
}
