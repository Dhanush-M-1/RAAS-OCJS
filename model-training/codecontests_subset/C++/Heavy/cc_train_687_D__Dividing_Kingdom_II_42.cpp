#include <bits/stdc++.h>
using namespace std;
struct Edge {
  int u, v, w;
  int id;
  bool operator<(const Edge& o) const { return w > o.w; }
} edges[500000];
int n, m, q;
int r[1111];
int p[1111];
bool vis[1111];
void init() {
  memset(vis, 0, sizeof(vis));
  for (int i = 1; i <= n; i++) {
    p[i] = i;
    r[i] = 0;
  }
}
pair<int, int> Find(int u) {
  if (u == p[u]) {
    return make_pair(u, 0);
  }
  pair<int, int> pp = Find(p[u]);
  r[u] = r[p[u]] ^ r[u];
  p[u] = pp.first;
  return make_pair(p[u], r[u]);
}
void Union(int u, int v, int relation) {
  pair<int, int> fu = Find(u);
  pair<int, int> fv = Find(v);
  p[fu.first] = fv.first;
  r[fu.first] = relation ^ r[u] ^ r[v];
}
int Relation(int u, int v) { return r[u] ^ r[v]; }
int main() {
  cin >> n >> m >> q;
  for (int i = 1; i <= m; i++) {
    scanf("%d %d %d", &edges[i].u, &edges[i].v, &edges[i].w);
    edges[i].id = i;
  }
  sort(edges + 1, edges + m + 1);
  for (int i = 1; i <= q; i++) {
    int ans = -1;
    int l, r;
    scanf("%d %d", &l, &r);
    init();
    for (int j = 1; j <= m; j++) {
      if (edges[j].id < l || edges[j].id > r) {
        continue;
      }
      int u = edges[j].u;
      int v = edges[j].v;
      if (vis[u] && vis[v]) {
        if (Find(u).first != Find(v).first) {
          Union(u, v, 1);
        } else {
          if (Relation(u, v) == 0) {
            ans = edges[j].w;
            break;
          }
        }
      } else if (vis[u] && !vis[v]) {
        Union(v, u, 1);
        vis[v] = 1;
      } else if (!vis[u] && vis[v]) {
        Union(u, v, 1);
        vis[u] = 1;
      } else {
        Union(u, v, 1);
        vis[u] = vis[v] = 1;
      }
    }
    printf("%d\n", ans);
  }
  return 0;
}
