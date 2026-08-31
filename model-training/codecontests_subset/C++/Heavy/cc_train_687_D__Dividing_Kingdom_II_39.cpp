#include <bits/stdc++.h>
using namespace std;
const int N = 5e5 + 5;
int fa[N], relation[N];
struct Edge {
  int u, v, w, id;
  bool operator<(const Edge &rhs) const { return w > rhs.w; }
} p[N];
int find(int x) {
  if (x == fa[x]) return x;
  int fx = find(fa[x]);
  relation[x] ^= relation[fa[x]];
  return fa[x] = fx;
}
bool Union(int u, int v) {
  int fx = find(u), fy = find(v);
  if (fx == fy) {
    if (relation[u] == relation[v]) return false;
    return true;
  }
  fa[fx] = fy;
  relation[fx] = relation[u] ^ relation[v] ^ 1;
  return true;
}
int main() {
  int n, m, q;
  scanf("%d%d%d", &n, &m, &q);
  for (int i = 1; i <= m; ++i) {
    scanf("%d%d%d", &p[i].u, &p[i].v, &p[i].w);
    p[i].id = i;
  }
  sort(p + 1, p + 1 + m);
  while (q--) {
    int l, r, ret = -1;
    scanf("%d%d", &l, &r);
    for (int i = 1; i <= n; ++i) fa[i] = i, relation[i] = 0;
    for (int i = 1; i <= m; ++i) {
      if (p[i].id < l || p[i].id > r) continue;
      if (!Union(p[i].u, p[i].v)) {
        ret = p[i].w;
        break;
      }
    }
    printf("%d\n", ret);
  }
  return 0;
}
