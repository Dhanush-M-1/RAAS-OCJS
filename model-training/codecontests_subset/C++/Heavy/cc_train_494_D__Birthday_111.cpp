#include <bits/stdc++.h>
using namespace std;
const int maxv = 120000, maxe = maxv * 2;
const int maxq = 120000;
const int mod = 1000000007;
struct {
  int v, w, next;
} graph[maxe];
int head[maxv], top;
int n, q;
void addedge(int x, int y, int w = 1) {
  graph[top].v = y;
  graph[top].w = w;
  graph[top].next = head[x];
  head[x] = top++;
}
int rdist[maxv];
long long csum[3][maxv];
int ord[maxv], t, seq[maxv * 2], seqlen, first[maxv];
void dfs(int p = 1, int prev = 0) {
  int ct = t++;
  ord[ct] = p;
  seq[first[p] = seqlen++] = ct;
  csum[0][p] = 1;
  csum[1][p] = csum[2][p] = 0;
  for (int i = head[p]; ~i; i = graph[i].next) {
    int np = graph[i].v;
    if (np == prev) continue;
    rdist[np] = (rdist[p] + graph[i].w) % mod;
    dfs(np, p);
    seq[seqlen++] = ct;
    csum[0][p] += csum[0][np];
    csum[1][p] += csum[1][np] + csum[0][np] * graph[i].w;
    csum[2][p] += csum[2][np] + 2 * csum[1][np] * graph[i].w +
                  ((csum[0][np] * graph[i].w) % mod) * graph[i].w;
    for (int j = 0; j < 3; ++j) csum[j][p] %= mod;
  }
}
long long asum[3][maxv];
void bfs(int p = 1) {
  queue<int> q;
  q.push(p);
  for (int i = 0; i < 3; ++i) asum[i][p] = csum[i][p];
  while (!q.empty()) {
    int cp = q.front();
    q.pop();
    for (int i = head[cp]; ~i; i = graph[i].next) {
      int np = graph[i].v, nd = graph[i].w;
      if (asum[0][np]) continue;
      asum[0][np] = n;
      asum[1][np] = asum[1][cp] + (n - 2 * csum[0][np]) * graph[i].w;
      asum[2][np] =
          asum[2][cp] -
          (csum[2][np] + 2 * csum[1][np] * graph[i].w +
           ((csum[0][np] * graph[i].w) % mod) * graph[i].w) +
          (((n - csum[0][np]) * graph[i].w) % mod) * graph[i].w +
          2 * ((asum[1][cp] - csum[1][np] - csum[0][np] * graph[i].w) % mod) *
              graph[i].w +
          csum[2][np];
      for (int j = 0; j < 3; ++j) asum[j][np] %= mod;
      q.push(np);
    }
  }
}
int minst[maxv * 2][20];
void init_st() {
  for (int i = 0; i < 2 * n; ++i) minst[i][0] = seq[i];
  for (int i = 1, ii = 2; ii <= 2 * n; ++i, ii <<= 1)
    for (int j = 0; j <= 2 * n - ii; ++j)
      minst[j][i] = min(minst[j][i - 1], minst[j + (ii >> 1)][i - 1]);
}
inline int log2(int p) { return (int)(log(p + 0.5) / log(2.0)); }
inline int lca(int x, int y) {
  int l = first[x], r = first[y];
  if (l > r) swap(l, r);
  int pos = log2(r - l + 1), len = 1 << pos;
  return ord[min(minst[l][pos], minst[r - len + 1][pos])];
}
inline long long dist(int x, int y) {
  return ((long long)rdist[x] + rdist[y] - 2 * rdist[lca(x, y)]) % mod;
}
int main() {
  memset(head, -1, sizeof(head));
  scanf("%d", &n);
  for (int i = 0; i < n - 1; ++i) {
    int x, y, z;
    scanf("%d%d%d", &x, &y, &z);
    addedge(x, y, z);
    addedge(y, x, z);
  }
  dfs();
  bfs();
  init_st();
  scanf("%d", &q);
  while (q--) {
    int u, v;
    scanf("%d%d", &u, &v);
    int fa = lca(u, v);
    long long ans;
    if (fa != v)
      ans = 2 * (csum[2][v] + 2 * csum[1][v] * dist(u, v) +
                 ((csum[0][v] * dist(u, v)) % mod) * dist(u, v)) -
            asum[2][u];
    else
      ans = asum[2][u] -
            2 * ((asum[2][v] - csum[2][v]) +
                 2 * (asum[1][v] - csum[1][v]) * dist(u, v) +
                 (((n - csum[0][v]) * dist(u, v)) % mod) * dist(u, v));
    printf("%I64d\n", (ans % mod + mod) % mod);
  }
  return 0;
}
