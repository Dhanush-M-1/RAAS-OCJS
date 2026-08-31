#include <bits/stdc++.h>
using LL = long long;
const int N = 1000 + 5;
int dsu[N << 1];
int n, m, nq;
int find(int x) { return dsu[x] == x ? x : dsu[x] = find(dsu[x]); }
struct Edge {
  int u, v, w, id;
};
int main() {
  scanf("%d%d%d", &n, &m, &nq);
  std::vector<Edge> es;
  for (int i = 0; i < m; ++i) {
    int a, b, w;
    scanf("%d%d%d", &a, &b, &w);
    a--;
    b--;
    es.push_back(Edge{a, b, w, i});
  }
  std::sort((es).begin(), (es).end(),
            [](const Edge &a, const Edge &b) { return a.w > b.w; });
  for (int i = 0; i < nq; ++i) {
    int l, r;
    scanf("%d%d", &l, &r);
    l--;
    r--;
    std::iota(dsu, dsu + n + n, 0);
    int result = -1;
    for (int i = 0; i < m; ++i) {
      Edge &e = es[i];
      if (e.id < l || e.id > r) continue;
      if (find(e.u << 1) == find(e.v << 1)) {
        result = e.w;
        break;
      }
      dsu[find(e.u << 1)] = find(e.v << 1 | 1);
      dsu[find(e.u << 1 | 1)] = find(e.v << 1);
    }
    printf("%d\n", result);
  }
}
