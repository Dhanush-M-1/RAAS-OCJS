#include <bits/stdc++.h>
using namespace std;
#pragma GCC diagnostic ignored "-Wmissing-declarations"
inline int safe_mul(int x, int y) __attribute__((warn_unused_result));
int const maxn = 1003;
int parent[maxn];
int val[maxn];
struct Edge {
  int index;
  int cost;
  int u;
  int v;
};
inline bool operator<(const Edge& a, const Edge& b) { return a.cost > b.cost; }
Edge edges[maxn * maxn / 2];
int temp[maxn];
inline int get_parent(int v) {
  int cur = v;
  temp[0] = v;
  int top = 0;
  while (cur != parent[cur]) {
    cur = parent[cur];
    temp[++top] = cur;
  }
  int curval = 0;
  for (int i = top - 1; i >= 0; --i) {
    curval ^= val[temp[i]];
    val[temp[i]] = curval;
    parent[temp[i]] = cur;
  }
  return cur;
}
int main() {
  int n, m, q;
  scanf("%d %d %d", &n, &m, &q);
  for (int i = 0; i < m; ++i) {
    scanf("%d %d %d", &edges[i].u, &edges[i].v, &edges[i].cost);
    edges[i].index = i + 1;
  }
  sort(edges, edges + m);
  for (int tst = 0; tst < q; ++tst) {
    int l, r;
    scanf("%d %d", &l, &r);
    for (int i = 1; i <= n; ++i) parent[i] = i;
    fill(val, val + maxn, 0);
    int ans = -1;
    for (int i = 0; i < m; ++i) {
      if (edges[i].index >= l && edges[i].index <= r) {
        int x = get_parent(edges[i].v);
        int y = get_parent(edges[i].u);
        int valx = val[edges[i].v] ^ val[x];
        int valy = val[edges[i].u] ^ val[y];
        if (x == y) {
          if (valx == valy) {
            ans = edges[i].cost;
            break;
          }
        } else {
          if (valx == valy) val[x] ^= 1;
          parent[x] = y;
        }
      }
    }
    printf("%d\n", ans);
  }
}
