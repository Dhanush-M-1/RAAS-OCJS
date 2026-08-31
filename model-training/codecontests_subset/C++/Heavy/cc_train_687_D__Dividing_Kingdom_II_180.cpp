#include <bits/stdc++.h>
using namespace std;
int n, m, q;
struct node {
  int from, to, val;
  int id;
} edge[1002 * 1002];
int fa[1002 * 1002];
inline int getfa(int x) {
  if (fa[x] == x) return x;
  return fa[x] = getfa(fa[x]);
}
inline void uni(int x, int y) {
  if (getfa(x) != getfa(y)) fa[getfa(x)] = getfa(y);
}
inline bool cmp(node x, node y) { return x.val > y.val; }
int main() {
  cin >> n >> m >> q;
  for (int i = 1; i <= m; i++) {
    int u, v, w;
    cin >> u >> v >> w;
    edge[i].from = u;
    edge[i].id = i;
    edge[i].to = v;
    edge[i].val = w;
  }
  sort(edge + 1, edge + m + 1, cmp);
  for (int i = 1; i <= q; i++) {
    int l, r, ans = -1;
    cin >> l >> r;
    for (int i = 1; i <= n * n; i++) fa[i] = i;
    for (int j = 1; j <= m; j++) {
      if (edge[j].id >= l && edge[j].id <= r) {
        if (getfa(edge[j].from) == getfa(edge[j].to)) {
          ans = edge[j].val;
          break;
        } else {
          uni(edge[j].from, edge[j].to + n);
          uni(edge[j].from + n, edge[j].to);
        }
      }
    }
    cout << ans << endl;
  }
}
