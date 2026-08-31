#include <bits/stdc++.h>
using namespace std;
struct edge {
  int u, v, w, idx;
  inline bool operator<(const edge &a) const { return w > a.w; }
} arr[1000005];
int fa[1005], col[1005];
int getfa(int u) {
  if (u == fa[u]) return u;
  int res = getfa(fa[u]);
  col[u] ^= col[fa[u]];
  fa[u] = res;
  return res;
}
inline bool same(int u, int v) {
  return getfa(u) == getfa(v) && col[u] == col[v];
}
inline void unite(int u, int v) {
  int x = getfa(u), y = getfa(v);
  if (x != y) {
    col[x] = col[u] ^ col[v] ^ 1;
    fa[x] = y;
  }
}
int main() {
  int n, m, q;
  scanf("%d%d%d", &n, &m, &q);
  for (int i = 0; i < m; i++) {
    scanf("%d%d%d", &arr[i].u, &arr[i].v, &arr[i].w);
    arr[i].idx = i;
    arr[i].u--;
    arr[i].v--;
  }
  sort(arr, arr + m);
  while (q--) {
    int l, r;
    scanf("%d%d", &l, &r);
    l--;
    for (int i = 0; i < n; i++) {
      fa[i] = i;
      col[i] = 0;
    }
    bool f = false;
    for (int i = 0; i < m && !f; i++) {
      if (arr[i].idx < l || arr[i].idx >= r) continue;
      if (same(arr[i].u, arr[i].v)) {
        printf("%d\n", arr[i].w);
        f = true;
      }
      unite(arr[i].u, arr[i].v);
    }
    if (!f) printf("-1\n");
  }
  return 0;
}
