#include <bits/stdc++.h>
using namespace std;
int fa[2010], siz[2010], id[1000010], x[1000010], y[1000010], z[1000010];
int n, m, q;
int cmp(int x, int y) { return z[x] > z[y]; }
int find(int x) {
  if (x == fa[x]) return x;
  return fa[x] = find(fa[x]);
}
void merge(int x, int y) {
  int dx = find(x), dy = find(y);
  if (siz[dx] > siz[dy]) swap(dx, dy);
  siz[dy] += siz[dx];
  fa[dx] = dy;
}
int read() {
  int ans = 0;
  char ch = getchar();
  while (ch < '0' || ch > '9') ch = getchar();
  while (ch >= '0' && ch <= '9')
    ans = (ans << 1) + (ans << 3) + ch - '0', ch = getchar();
  return ans;
}
int main() {
  scanf("%d%d%d", &n, &m, &q);
  for (int i = 1; i <= m; i++) x[i] = read(), y[i] = read(), z[i] = read();
  for (int i = 1; i <= m; i++) id[i] = i;
  sort(id + 1, id + m + 1, cmp);
  while (q--) {
    int dl = read(), dr = read();
    int flag = 1;
    for (int i = 1; i <= n + n; i++) fa[i] = i, siz[i] = 1;
    for (int i = 1; i <= m; i++)
      if (id[i] >= dl && id[i] <= dr) {
        if (find(x[id[i]]) == find(y[id[i]])) {
          flag = 0;
          printf("%d\n", z[id[i]]);
          break;
        } else
          merge(x[id[i]], y[id[i]] + n), merge(x[id[i]] + n, y[id[i]]);
      }
    if (flag) printf("-1\n");
  }
}
