#include <bits/stdc++.h>
using namespace std;
struct edge {
  int u, v, w, id;
  bool operator<(const edge& q) const { return w > q.w; }
} a[1001000];
int f[1010];
int e[1010];
int find(int a) {
  if (f[a] == a) return a;
  int fa = find(f[a]);
  e[a] = (e[a] + e[f[a]]) & 1;
  return f[a] = fa;
}
int main() {
  int n, q, m;
  scanf("%d%d%d", &n, &m, &q);
  for (int i = 0; i < m; i++) {
    scanf("%d%d%d", &a[i].u, &a[i].v, &a[i].w);
    a[i].id = i + 1;
  }
  sort(a, a + m);
  while (q--) {
    for (int i = 0; i < 1010; i++) f[i] = i, e[i] = 0;
    int l, r, ans = -1;
    scanf("%d%d", &l, &r);
    for (int i = 0; i < m; i++) {
      if (a[i].id >= l && a[i].id <= r) {
        int u = a[i].u, v = a[i].v;
        int fu = find(u), fv = find(v);
        if (fu == fv && (e[u] + e[v]) % 2 == 0) {
          ans = a[i].w;
          break;
        }
        if (fu != fv) {
          f[fu] = fv;
          e[fu] = (e[u] + e[v] + 1) & 1;
        }
      }
    }
    printf("%d\n", ans);
  }
}
