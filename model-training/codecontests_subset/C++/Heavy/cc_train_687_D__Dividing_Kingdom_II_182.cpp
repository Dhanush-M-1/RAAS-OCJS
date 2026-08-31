#include <bits/stdc++.h>
using namespace std;
const int N = 1010;
struct EDGE {
  int u, v, c, num;
  bool operator<(const EDGE &t) const { return c > t.c; }
} e[N * N];
int n, m, q;
struct VALSET {
  int c[N], fa[N];
  void init() {
    for (int i = 1; i <= n; i++) fa[i] = i, c[i] = 0;
  }
  int finds(int u) {
    if (u == fa[u]) return u;
    int o = finds(fa[u]);
    c[u] = c[u] ^ c[fa[u]];
    return fa[u] = o;
  }
  bool join(int u, int v) {
    int fu = finds(u);
    int fv = finds(v);
    if (fu == fv && c[u] == c[v]) return 0;
    fa[fu] = fv;
    c[fu] = c[u] ^ c[v] ^ 1;
    return 1;
  }
} Valset;
void read_graph() {
  scanf("%d%d%d", &n, &m, &q);
  for (int i = 1; i <= m; i++)
    scanf("%d%d%d", &e[i].u, &e[i].v, &e[i].c), e[i].num = i;
}
void solve() {
  sort(e + 1, e + m + 1);
  while (q--) {
    int l, r;
    bool flag = 0;
    Valset.init();
    scanf("%d%d", &l, &r);
    for (int i = 1; i <= m; i++)
      if (e[i].num >= l && e[i].num <= r)
        if (!Valset.join(e[i].u, e[i].v)) {
          printf("%d\n", e[i].c);
          flag = 1;
          break;
        }
    if (!flag) printf("-1\n");
  }
}
int main() {
  read_graph();
  solve();
  return 0;
}
