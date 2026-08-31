#include <bits/stdc++.h>
using namespace std;
const int N = 1010, M = 1e6 + 10;
struct edge {
  int u, v, w, ind;
};
int n, m, comp[N], col[N];
vector<int> nodes[N];
edge e[M];
void init() {
  for (int i = 0; i < (int)(n); i++) {
    comp[i] = i;
    col[i] = 0;
    nodes[i] = vector<int>{i};
  }
}
void merge(int x, int y) {
  int a = comp[x], b = comp[y];
  if (((int)(nodes[a]).size()) < ((int)(nodes[y]).size())) {
    swap(x, y);
    swap(a, b);
  }
  bool inv = col[x] == col[y];
  for (auto u : nodes[b]) {
    nodes[a].push_back(u);
    col[u] ^= inv;
    comp[u] = a;
  }
  nodes[b].clear();
}
int main() {
  int q;
  scanf("%d %d %d", &n, &m, &q);
  for (int i = 0; i < (int)(m); i++) {
    int u, v, w;
    scanf("%d %d %d", &u, &v, &w);
    u--;
    v--;
    e[i] = (edge){u, v, w, i + 1};
  }
  sort(e, e + m, [](edge x, edge y) { return x.w > y.w; });
  while (q--) {
    init();
    int l, r;
    scanf("%d %d", &l, &r);
    int ans = -1;
    for (int i = 0; i < (int)(m); i++)
      if (l <= e[i].ind && e[i].ind <= r) {
        int u = e[i].u, v = e[i].v;
        if (comp[u] == comp[v]) {
          if (col[u] == col[v]) {
            ans = e[i].w;
            break;
          }
        } else
          merge(u, v);
      }
    printf("%d\n", ans);
  }
  return 0;
}
