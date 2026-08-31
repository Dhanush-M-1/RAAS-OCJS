#include <bits/stdc++.h>
using namespace std;
struct edge {
  int u, v, w, idx;
  inline bool operator<(const edge &a) const { return w > a.w; }
} arr[1000005];
int fa[1005], bit[1005];
int getfa(int u) {
  if (u == fa[u]) return u;
  int res = getfa(fa[u]);
  bit[u] ^= bit[fa[u]];
  fa[u] = res;
  return fa[u] = res;
}
inline bool unite(int u, int v) {
  int x = getfa(u), y = getfa(v);
  if (x == y) return bit[u] != bit[v];
  fa[x] = y;
  bit[x] = bit[u] ^ bit[v] ^ 1;
  return true;
}
int main() {
  int n, m, q;
  scanf("%d%d%d", &n, &m, &q);
  for (int i = 0; i < m; i++) {
    scanf("%d%d%d", &arr[i].u, &arr[i].v, &arr[i].w);
    arr[i].u--;
    arr[i].v--;
    arr[i].idx = i;
  }
  sort(arr, arr + m);
  while (q--) {
    int l, r;
    scanf("%d%d", &l, &r);
    l--;
    r--;
    for (int i = 0; i < n; i++) {
      fa[i] = i;
      bit[i] = 0;
    }
    bool f = false;
    for (int i = 0; i < m && !f; i++) {
      if (arr[i].idx < l || arr[i].idx > r) continue;
      if (!unite(arr[i].u, arr[i].v)) {
        printf("%d\n", arr[i].w);
        f = true;
      }
    }
    if (!f) printf("-1\n");
  }
  return 0;
}
