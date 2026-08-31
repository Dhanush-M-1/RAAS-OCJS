#include <bits/stdc++.h>
using namespace std;
const int maxn = 1100;
int fa[maxn * 2];
int n, m, q;
struct Edge {
  int u, v, w, id;
  friend bool operator<(const Edge n1, const Edge n2) { return n1.w > n2.w; }
} edge[maxn * maxn];
int findset(int x) { return fa[x] == x ? x : fa[x] = findset(fa[x]); }
void Union(int x, int y) {
  int fx = findset(x);
  int fy = findset(y);
  if (fx != fy) {
    fa[fx] = fy;
  }
}
int main() {
  cin >> n >> m >> q;
  for (int i = 1; i <= m; i++) {
    scanf("%d%d%d", &edge[i].u, &edge[i].v, &edge[i].w);
    edge[i].id = i;
  }
  sort(edge + 1, edge + m + 1);
  while (q--) {
    bool flag = false;
    int l, r;
    scanf("%d%d", &l, &r);
    for (int i = 1; i <= 2 * n; i++) fa[i] = i;
    int ans = 0x3f3f3f3f;
    for (int i = 1; i <= m; i++) {
      if (edge[i].id < l || edge[i].id > r) continue;
      int u = edge[i].u, v = edge[i].v;
      int fu = findset(u), fv = findset(v);
      if (fu != fv) {
        Union(edge[i].u, edge[i].v + n);
        Union(edge[i].u + n, edge[i].v);
      } else {
        printf("%d\n", edge[i].w);
        flag = true;
        break;
      }
    }
    if (!flag) printf("-1\n");
  }
  return 0;
}
