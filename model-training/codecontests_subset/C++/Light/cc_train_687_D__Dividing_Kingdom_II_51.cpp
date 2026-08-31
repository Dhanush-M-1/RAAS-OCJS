#include <bits/stdc++.h>
using namespace std;
const int maxn = 1005;
struct Edge {
  int u, v, w, id;
  Edge() {}
  Edge(int a, int b, int c, int d) : u(a), v(b), w(c), id(d) {}
  bool operator<(const Edge e) const { return w > e.w; }
} e[maxn * maxn];
int fa[maxn << 1];
int Find(int x) { return fa[x] == x ? fa[x] : (fa[x] = Find(fa[x])); }
void Merge(int a, int b) {
  int x = Find(a);
  int y = Find(b);
  fa[x] = y;
}
int main() {
  int n, m, q;
  while (scanf("%d%d%d", &n, &m, &q) != EOF) {
    int u, v, w;
    for (int i = 0; i < m; i++) {
      scanf("%d %d %d", &u, &v, &w);
      e[i] = Edge(u, v, w, i + 1);
    }
    sort(e, e + m);
    while (q--) {
      int flag = 0;
      for (int i = 1; i <= 2 * n; i++) fa[i] = i;
      scanf("%d%d", &u, &v);
      for (int i = 0; i < m; i++) {
        if (e[i].id < u || e[i].id > v) continue;
        if (Find(e[i].u) == Find(e[i].v)) {
          printf("%d\n", e[i].w);
          flag = 1;
          break;
        } else {
          Merge(e[i].u, e[i].v + n);
          Merge(e[i].v, e[i].u + n);
        }
      }
      if (!flag) printf("-1\n");
    }
  }
  return 0;
}
