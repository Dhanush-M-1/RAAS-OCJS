#include <bits/stdc++.h>
using namespace std;
const int MaxN = 100010;
const int MOD = 1000000007;
struct Node {
  int v;
  long long c;
  Node *nxt;
} pool[MaxN << 1], *tail = pool, *g[MaxN];
struct Pack {
  long long s, s2, cnt;
  Pack() {}
  Pack(long long _s, long long _s2, long long _cnt)
      : s(_s), s2(_s2), cnt(_cnt) {}
  Pack operator*(long long t) {
    t %= MOD;
    return Pack(s + cnt * t % MOD,
                (s2 + 2 * s * t % MOD + cnt * t % MOD * t) % MOD, cnt);
  }
  Pack operator+(const Pack &t) {
    return Pack((s + t.s) % MOD, (s2 + t.s2) % MOD, cnt + t.cnt);
  }
  Pack operator-(const Pack &t) {
    return Pack((s - t.s) % MOD, (s2 - t.s2) % MOD, cnt - t.cnt);
  }
  Pack operator+=(const Pack &t) { return *this = *this + t; }
  Pack operator-=(const Pack &t) { return *this = *this - t; }
} d[MaxN], up[MaxN];
int n, q;
int h[MaxN];
long long len[MaxN];
int fa[20][MaxN];
void dfs(int u) {
  d[u].cnt = 1;
  for (Node *p = g[u]; p; p = p->nxt)
    if (p->v != fa[0][u])
      fa[0][p->v] = u, h[p->v] = h[u] + 1, len[p->v] = len[u] + p->c, dfs(p->v),
      d[u] += d[p->v] * p->c;
}
void dfs2(int u) {
  for (Node *p = g[u]; p; p = p->nxt)
    if (p->v != fa[0][u])
      up[p->v] = (d[u] - d[p->v] * p->c + up[u]) * p->c, dfs2(p->v);
}
int lca(int u, int v) {
  if (h[u] < h[v]) u ^= v ^= u ^= v;
  for (int i = 19; i >= 0; i--)
    if (h[fa[i][u]] >= h[v]) u = fa[i][u];
  if (u == v) return u;
  for (int i = 19; i >= 0; i--)
    if (fa[i][u] != fa[i][v]) u = fa[i][u], v = fa[i][v];
  return fa[0][u];
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i < n; i++) {
    int u, v, c;
    scanf("%d%d%d", &u, &v, &c);
    tail->v = v;
    tail->c = c;
    tail->nxt = g[u];
    g[u] = tail++;
    tail->v = u;
    tail->c = c;
    tail->nxt = g[v];
    g[v] = tail++;
  }
  h[1] = 1;
  dfs(1);
  dfs2(1);
  for (int i = 1; i < 20; i++)
    for (int j = 1; j <= n; j++) fa[i][j] = fa[i - 1][fa[i - 1][j]];
  scanf("%d", &q);
  for (int i = 1; i <= q; i++) {
    int u, v;
    scanf("%d%d", &u, &v);
    int w = lca(u, v);
    long long tl = len[u] + len[v] - len[w] * 2;
    Pack s1 = up[u] + d[u], s2 = w == v ? d[u] + up[u] - up[v] * tl : d[v] * tl;
    printf("%I64d\n", ((s2.s2 * 2 - s1.s2) % MOD + MOD) % MOD);
  }
  return 0;
}
