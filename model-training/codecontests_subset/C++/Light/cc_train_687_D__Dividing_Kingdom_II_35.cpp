#include <bits/stdc++.h>
using namespace std;
const int N = 2e3 + 5;
const int M = 1e6 + 5;
struct DSU {
  int fa[N];
  int find(int x) { return (x == fa[x]) ? x : (fa[x] = find(fa[x])); }
  void init(int n) {
    for (int i = 0; i <= n; i++) fa[i] = i;
  }
  void joint(int u, int v) {
    u = find(u), v = find(v);
    if (u != v) fa[u] = v;
  }
  bool same(int u, int v) { return find(u) == find(v); }
};
struct Edge {
  int id, u, v, w;
  bool operator<(const Edge &o) const { return w > o.w; }
};
int n, m, q, l, r, u, v;
DSU dsu;
Edge e[M];
int solve() {
  dsu.init(2 * n);
  scanf("%d%d", &l, &r);
  for (int i = 0; i < m; i++) {
    if (e[i].id < l || e[i].id > r) continue;
    u = e[i].u, v = e[i].v;
    if (dsu.same(u, v)) {
      return e[i].w;
    } else {
      dsu.joint(u, v + n);
      dsu.joint(v, u + n);
    }
  }
  return -1;
}
int main() {
  while (scanf("%d%d%d", &n, &m, &q) == 3) {
    for (int i = 0; i < m; i++) {
      scanf("%d%d%d", &e[i].u, &e[i].v, &e[i].w);
      e[i].id = i + 1;
    }
    sort(e, e + m);
    for (int i = 0; i < q; i++) {
      printf("%d\n", solve());
    }
  }
  return 0;
}
