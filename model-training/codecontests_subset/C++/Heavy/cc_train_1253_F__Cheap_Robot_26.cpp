#include <bits/stdc++.h>
using namespace std;
int A[600006], B[600006], D[600006], F[100001], G[100001], a[100001], b[600006],
    c[600006], d[600006], e[100001], i, j, k, m, n, o[600006], q, s, t;
long long C[600006], E[100001], f[100001], p[600006];
bool g[100001];
inline bool cmp(int u, int v) { return C[u] < C[v]; }
inline int find(int u) {
  while (F[u]) u = F[u];
  return u;
}
inline void merge(int u, int v, long long w) {
  if ((u = find(u)) == (v = find(v))) return;
  if (G[u] < G[v]) swap(u, v);
  G[F[v] = u] += G[v], E[v] = w;
}
inline long long query(int u, int v) {
  long long w = 0;
  while (u != v)
    G[u] < G[v] ? w = max(w, E[u]), u = F[u] : (w = max(w, E[v]), v = F[v]);
  return w;
}
inline void put(int v, long long w) {
  int u = ++s;
  while (1 < u && w < p[u >> 1]) o[u] = o[u >> 1], p[u] = p[u >> 1], u >>= 1;
  o[u] = v, p[u] = w;
}
inline int get() {
  int u = 1, v = 2, w = o[1];
  for (o[1] = o[s], p[1] = p[s--]; v <= s;
       swap(o[u], o[v]), swap(p[u], p[v]), u = v, v = u << 1) {
    if (v < s && p[v | 1] < p[v]) v++;
    if (p[u] <= p[v]) return w;
  }
  return w;
}
inline void del() {
  while (s && g[o[1]]) get();
}
int u, v, w;
int main() {
  scanf("%d%d%d%d", &n, &m, &k, &q);
  for (i = 1; i <= k; G[i++] = 1) put(e[i] = i, f[i] = 0ll);
  for (; i <= n; G[i++] = 1) f[i] = 0x7fffffffffffffff;
  for (i = 1; i <= m; i++)
    scanf("%d%d%d", &u, &v, &w),
        b[i << 1] = a[u], c[a[u] = i << 1] = v, b[i << 1 | 1] = a[v],
               c[a[v] = i << 1 | 1] = u, d[i << 1] = d[i << 1 | 1] = w;
  while (del(), s) {
    for (i = a[u = get()], g[u] = 1; i; i = b[i])
      if (f[u] + d[i] < f[c[i]])
        e[c[i]] = e[u], put(c[i], f[c[i]] = f[u] + d[i]);
      else if (g[c[i]] && e[u] != e[c[i]])
        A[++t] = e[u], B[t] = e[c[i]], C[D[t] = t] = f[u] + f[c[i]] + d[i];
  }
  for (sort(D + 1, D + t + 1, cmp), i = 1; i <= t; i++)
    merge(A[D[i]], B[D[i]], C[D[i]]);
  for (i = 1; i <= q; i++) scanf("%d%d", &u, &v), printf("%lld\n", query(u, v));
  return 0;
}
