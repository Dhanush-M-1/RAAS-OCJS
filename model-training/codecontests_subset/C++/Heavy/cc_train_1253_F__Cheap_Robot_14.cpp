#include <bits/stdc++.h>
using namespace std;
const int N = 3e5 + 10, mod = 1e9 + 7;
long long inf = 0x3f3f3f3f3f3f3f3f;
int n, m, k, Q, fa[N], hd[N], ne, mxd[N];
long long d[N], val[N];
struct E {
  int v, c, nxt;
} e[N << 1];
struct E2 {
  int u, v;
  long long c;
  bool operator<(const E2& b) const { return c < b.c; }
} e2[N];
void link(int u, int v, int c) { e[ne] = {v, c, hd[u]}, hd[u] = ne++; }
struct D {
  int u;
  long long g;
  bool operator<(const D& b) const { return g > b.g; }
};
void Dij() {
  priority_queue<D> q;
  memset(d, inf, sizeof d);
  for (int i = 1; i <= k; ++i) q.push({i, d[i] = 0});
  while (q.size()) {
    int u = q.top().u;
    long long g = q.top().g;
    q.pop();
    if (d[u] != g) continue;
    for (int i = hd[u]; ~i; i = e[i].nxt) {
      int v = e[i].v, c = e[i].c;
      if (d[v] > d[u] + c) d[v] = d[u] + c, q.push({v, d[v]});
    }
  }
}
int fd(int x) { return fa[x] ? fd(fa[x]) : x; }
void mg(int x, int y, long long c) {
  int fx = fd(x), fy = fd(y);
  if (fx == fy) return;
  if (mxd[fx] > mxd[fy]) swap(fx, fy);
  fa[fx] = fy, val[fx] = c, mxd[fy] = max(mxd[fy], mxd[fx] + 1);
}
void Kruskal() {
  sort(e2, e2 + m);
  for (int i = 1; i <= n; ++i) mxd[i] = 1, fa[i] = 0;
  for (int i = 0; i < m; ++i) {
    int u = e2[i].u, v = e2[i].v;
    long long c = e2[i].c;
    mg(u, v, c);
  }
}
long long qry(int u, int v) {
  long long ret = 0;
  for (; u != v; u = fa[u]) {
    if (mxd[u] > mxd[v]) swap(u, v);
    ret = max(ret, val[u]);
  }
  return ret;
}
int main() {
  memset(hd, -1, sizeof hd), ne = 0;
  scanf("%d%d%d%d", &n, &m, &k, &Q);
  for (int i = 0; i < m; ++i) {
    int u, v, c;
    scanf("%d%d%d", &u, &v, &c);
    link(u, v, c);
    link(v, u, c);
    e2[i] = {u, v, c};
  }
  Dij();
  for (int i = 0; i < m; ++i) e2[i].c += d[e2[i].u] + d[e2[i].v];
  Kruskal();
  while (Q--) {
    int u, v;
    scanf("%d%d", &u, &v);
    printf("%lld\n", qry(u, v));
  }
  return 0;
}
