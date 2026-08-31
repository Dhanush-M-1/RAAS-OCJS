#include <bits/stdc++.h>
using namespace std;
template <class I>
inline void ckMax(I& p, I q) {
  p = (p > q ? p : q);
}
template <class I>
inline void ckMin(I& p, I q) {
  p = (p < q ? p : q);
}
template <class I>
inline I Min(I p, I q) {
  return p < q ? p : q;
}
template <class I>
inline I Max(I p, I q) {
  return p > q ? p : q;
}
template <class I>
inline void sp(I& p, I& q) {
  I x = p;
  p = q, q = x;
}
const int N = 1000005;
int n, h[N], nxt[N], adj[N], t, k, fa[N], f[N], g[N], a[N], d[N];
inline void add(const int u, const int v) {
  nxt[++t] = h[u], h[u] = t, adj[t] = v;
};
inline void dfs(const int x) {
  if (!h[x]) return f[x] = a[x] = 1, d[x] = 0, void();
  d[x] = 1e9;
  for (register int i = h[x], j; i; i = nxt[i])
    dfs(j = adj[i]), ckMin(d[x], d[j] + 1), ckMax(f[x], f[j] - a[j]),
        a[x] += a[j];
  f[x] += a[x];
  if (d[x] >= k) a[x] = 0;
}
int main() {
  scanf("%d%d", &n, &k);
  register int i;
  for (i = 2; i <= n; ++i) scanf("%d", &fa[i]), add(fa[i], i);
  dfs(1), printf("%d", f[1]);
  return 0;
}
