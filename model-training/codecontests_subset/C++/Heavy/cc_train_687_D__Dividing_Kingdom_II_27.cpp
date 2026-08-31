#include <bits/stdc++.h>
using namespace std;
int n, m, q, l, r;
int fa[1100], dis[1100];
struct edge {
  int x, y, v, pos;
  friend bool operator<(const edge &r1, const edge &r2) { return r1.v < r2.v; };
} a[1100 * 1100];
int find(int x) {
  if (fa[x] == x) return x;
  int t = find(fa[x]);
  dis[x] += dis[fa[x]];
  return fa[x] = t;
}
int check(int x, int y) {
  if (find(x) == find(y)) return (dis[x] + dis[y]) & 1;
  int t = find(x);
  fa[t] = find(y);
  dis[t] = 1 - (dis[x] + dis[y]) % 2;
  return 1;
}
int main() {
  scanf("%d%d%d", &n, &m, &q);
  for (int i = 1; i <= m; i++) {
    scanf("%d%d%d", &a[i].x, &a[i].y, &a[i].v);
    a[i].pos = i;
  }
  sort(a + 1, a + 1 + m);
  while (q--) {
    scanf("%d%d", &l, &r);
    int flag = 0;
    for (int i = 1; i <= n; i++) fa[i] = i;
    memset(dis, 0, sizeof(dis));
    for (int i = m; i; i--)
      if (a[i].pos >= l && a[i].pos <= r) {
        if (!check(a[i].x, a[i].y)) {
          printf("%d\n", a[i].v);
          flag = 1;
          break;
        }
      }
    if (!flag) puts("-1");
  }
  return 0;
}
