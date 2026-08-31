#include <bits/stdc++.h>
struct edge {
  int u, v, id, w;
  bool operator<(edge const &x) const { return w > x.w; }
} p[1000010];
int n, m, q, f[2010];
int find(int x) {
  while (x != f[x]) x = f[x] = f[f[x]];
  return x;
}
int main() {
  scanf("%d%d%d", &n, &m, &q);
  for (int i = 1; i <= m; i++)
    scanf("%d%d%d", &p[i].u, &p[i].v, &p[i].w), p[i].id = i;
  std::sort(p + 1, p + m + 1);
  while (q--) {
    for (int i = 1; i <= n * 2; i++) f[i] = i;
    int l, r, ans = -1;
    scanf("%d%d", &l, &r);
    for (int i = 1; i <= m; i++)
      if (p[i].id <= r && p[i].id >= l) {
        int u = find(p[i].u), v = find(p[i].v);
        if (u == v) {
          ans = p[i].w;
          break;
        } else {
          int fu = find(p[i].u + n), fv = find(p[i].v + n);
          f[fv] = u;
          f[fu] = v;
        }
      }
    printf("%d\n", ans);
  }
  return 0;
}
