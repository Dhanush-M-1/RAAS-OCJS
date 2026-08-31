#include <bits/stdc++.h>
using namespace std;
const int N = 1000005;
int n, m, h[N], nxt[N], adj[N], rd[N], u, v, t, id[N], mx, q[N], top1, top2;
long long a[N], val[N];
bool vs[N];
inline void add() { nxt[++t] = h[u], h[u] = t, adj[t] = v; }
int main() {
  scanf("%d%d", &n, &m);
  register int i;
  for (i = 1; i <= n; ++i) scanf("%lld", &a[i]);
  while (m--) scanf("%d%d", &u, &v), add(), ++rd[v];
  for (i = 1; i <= n; ++i)
    if (!rd[i]) q[++top2] = i;
  while (top1 < top2)
    for (i = h[u = q[++top1]]; i; i = nxt[i])
      if (!--rd[adj[i]]) q[++top2] = adj[i];
  for (i = n; i; --i) {
    for (v = h[u = q[i]]; v; v = nxt[v]) vs[id[adj[v]]] = 1;
    while (vs[id[u]]) ++id[u];
    id[u] > mx ? mx = id[u] : 0, val[id[u]] ^= a[u];
    for (v = h[u]; v; v = nxt[v]) vs[id[adj[v]]] = 0;
  }
  for (i = mx; ~i; --i)
    if (val[i]) break;
  if (i < 0) return puts("LOSE"), 0;
  puts("WIN"), u = i;
  for (i = 1; i <= n; ++i)
    if (id[i] == u) {
      if ((val[id[i]] ^ a[i]) > a[i]) continue;
      a[i] ^= val[id[i]], val[id[i]] = 0;
      for (v = h[i]; v; v = nxt[v])
        a[adj[v]] ^= val[id[adj[v]]], val[id[adj[v]]] = 0;
    }
  for (i = 1; i <= n; ++i) printf("%lld ", a[i]);
  return 0;
}
