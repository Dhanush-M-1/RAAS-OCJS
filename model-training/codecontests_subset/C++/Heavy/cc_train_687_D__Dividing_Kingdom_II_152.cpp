#include <bits/stdc++.h>
using namespace std;
struct Edge {
  int u, v, w, id;
  Edge() {}
  Edge(int u, int v, int w, int id) : u(u), v(v), w(w), id(id) {}
  bool operator<(const Edge &e) const { return w > e.w; }
} edge[(1010) * (1010)];
int fa[(1010) << 1], dep[(1010) << 1];
int n, m, q;
int getfather(int x) {
  int root = x;
  while (root != fa[root]) root = fa[root];
  while (x != root) {
    int temp = fa[x];
    fa[x] = root;
    x = temp;
  }
  return root;
}
void union_set(int u, int v) {
  u = getfather(u);
  v = getfather(v);
  if (u == v) return;
  if (dep[u] < dep[v])
    fa[v] = u;
  else {
    fa[u] = v;
    if (dep[u] == dep[v]) dep[v]++;
  }
}
int main() {
  scanf("%d%d%d", &n, &m, &q);
  for (int i = 1; i <= m; ++i) {
    int u, v, w;
    scanf("%d%d%d", &u, &v, &w);
    edge[i] = Edge(u, v, w, i);
  }
  sort(edge + 1, edge + m + 1);
  for (int i = 1; i <= q; ++i) {
    int l, r;
    scanf("%d%d", &l, &r);
    for (int j = 1; j <= (n << 1); ++j) fa[j] = j, dep[j] = 1;
    bool have_odd_cycle = 1;
    for (int j = 1; j <= m; ++j) {
      if (edge[j].id < l || edge[j].id > r) continue;
      int fu = getfather(edge[j].u);
      int fv = getfather(edge[j].v);
      if (fu == fv) {
        printf("%d\n", edge[j].w);
        have_odd_cycle = 0;
        break;
      } else {
        union_set(edge[j].u, edge[j].v + n);
        union_set(edge[j].v, edge[j].u + n);
      }
    }
    if (have_odd_cycle) printf("-1\n");
  }
  return 0;
}
