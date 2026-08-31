#include <bits/stdc++.h>
using namespace std;
const int mod = 1e9 + 7;
const int maxn = 1e5 + 5;
int n, head[maxn];
struct Edge {
  int next, to, len;
} ed[maxn * 2];
int ecnt;
inline void addedge(int u, int v, int l) {
  ed[ecnt].next = head[u];
  ed[ecnt].to = v;
  ed[ecnt].len = l;
  head[u] = ecnt++;
}
inline void add(long long &x, long long v) {
  x += v;
  if (x >= mod) x -= mod;
}
inline long long sqr(long long x) { return x * x % mod; }
int fa[maxn][20], dep[maxn], sz[maxn];
long long dis[maxn], down[maxn], qdown[maxn];
void dfs1(int u, int father) {
  fa[u][0] = father;
  for (int i = 1; i < 20; ++i) fa[u][i] = fa[fa[u][i - 1]][i - 1];
  sz[u] = 1;
  for (int e = head[u]; ~e; e = ed[e].next) {
    int v = ed[e].to;
    if (v == father) continue;
    dep[v] = dep[u] + 1;
    dis[v] = dis[u] + ed[e].len;
    dfs1(v, u);
    sz[u] += sz[v];
    add(down[u], (down[v] + 1LL * ed[e].len * sz[v]) % mod);
    add(qdown[u], (qdown[v] + sqr(ed[e].len) * sz[v] % mod +
                   2 * ed[e].len * down[v] % mod) %
                      mod);
  }
}
long long all[maxn], up[maxn], qup[maxn];
void dfs2(int u, int father) {
  for (int e = head[u]; ~e; e = ed[e].next) {
    int v = ed[e].to;
    if (v == father) continue;
    qup[v] = (qup[u] + sqr(ed[e].len) * (n - sz[u] + 1) % mod +
              2 * ed[e].len * up[u] % mod) %
             mod;
    long long t1 = qdown[u] - (qdown[v] + sqr(ed[e].len) * sz[v] % mod +
                               2 * ed[e].len * down[v] % mod) %
                                  mod;
    if (t1 < 0) t1 += mod;
    long long t2 = down[u] - (down[v] + 1LL * ed[e].len * sz[v]) % mod;
    if (t2 < 0) t2 += mod;
    add(qup[v], (t1 + sqr(ed[e].len) * (sz[u] - sz[v] - 1) % mod +
                 2 * ed[e].len * t2 % mod) %
                    mod);
    up[v] = (up[u] + 1LL * ed[e].len * (n - sz[u] + 1)) % mod;
    add(up[v], (t2 + 1LL * ed[e].len * (sz[u] - sz[v] - 1)) % mod);
    dfs2(v, u);
  }
}
inline int lca(int u, int v) {
  if (dep[u] < dep[v]) swap(u, v);
  for (int i = 19; i >= 0; --i)
    if (dep[fa[u][i]] >= dep[v]) u = fa[u][i];
  if (u == v) return u;
  for (int i = 19; i >= 0; --i)
    if (fa[u][i] != fa[v][i]) {
      u = fa[u][i];
      v = fa[v][i];
    }
  return fa[u][0];
}
inline long long D(int u, int v) {
  return dis[u] + dis[v] - 2 * dis[lca(u, v)];
}
int main() {
  memset(head, -1, sizeof(head));
  scanf("%d", &n);
  for (int i = 1; i < n; ++i) {
    int u, v, c;
    scanf("%d%d%d", &u, &v, &c);
    addedge(u, v, c);
    addedge(v, u, c);
  }
  dfs1(1, 1);
  dfs2(1, 1);
  for (int i = 1; i <= n; ++i) all[i] = (qdown[i] + qup[i]) % mod;
  int q;
  scanf("%d", &q);
  while (q--) {
    int u, v;
    scanf("%d%d", &u, &v);
    if (u == v) {
      printf("%I64d\n", (qdown[u] - qup[u] + mod) % mod);
      continue;
    }
    long long ans = 0, DIS = D(u, v);
    if (dis[u] != dis[v] + DIS) {
      DIS %= mod;
      ans = (qdown[v] + sqr(DIS) * sz[v] % mod + 2 * DIS * down[v] % mod) % mod;
      ans += ans - all[u];
      ans %= mod;
      if (ans < 0) ans += mod;
    } else {
      DIS %= mod;
      ans =
          (qup[v] + sqr(DIS) * (n - sz[v]) % mod + 2 * DIS * up[v] % mod) % mod;
      ans = all[u] - 2 * ans;
      ans %= mod;
      if (ans < 0) ans += mod;
    }
    printf("%I64d\n", ans);
  }
  return 0;
}
