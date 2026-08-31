#include <bits/stdc++.h>
using namespace std;
struct Edge {
  int u, v, w, id;
  Edge() {}
  Edge(int _u, int _v, int _w, int _id) : u(_u), v(_v), w(_w), id(_id) {}
  inline bool operator<(const Edge &rhs) const { return w > rhs.w; }
};
vector<Edge> e;
int n, m, q, l, r, f[2005], rnk[2005];
inline int gf(int x) { return x == f[x] ? x : f[x] = gf(f[x]); }
inline void merge(int x, int y) {
  x = gf(x), y = gf(y);
  if (x == y) return;
  if (rnk[x] < rnk[y])
    f[x] = y;
  else {
    f[y] = x;
    if (rnk[x] == rnk[y]) rnk[x]++;
  }
}
inline int query() {
  for (int i = 1; i <= n + n; i++) {
    f[i] = i;
    rnk[i] = 0;
  }
  for (unsigned i = 0; i < e.size(); i++) {
    if (e[i].id < l || e[i].id > r) continue;
    int u = e[i].u, v = e[i].v, fu = gf(u), fv = gf(v);
    if (fu != fv) {
      merge(u, v + n);
      merge(v, u + n);
    } else
      return e[i].w;
  }
  return -1;
}
int main() {
  scanf("%d%d%d", &n, &m, &q);
  for (int i = 1, x, y, z; i <= m; i++) {
    scanf("%d%d%d", &x, &y, &z);
    e.push_back(Edge(x, y, z, i));
  }
  sort(e.begin(), e.end());
  while (q--) {
    scanf("%d%d", &l, &r);
    printf("%d\n", query());
  }
  return 0;
}
