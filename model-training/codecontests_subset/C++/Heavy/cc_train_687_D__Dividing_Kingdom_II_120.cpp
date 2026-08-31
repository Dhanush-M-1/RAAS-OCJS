#include <bits/stdc++.h>
using namespace std;
int n, m, q, l, r, ans;
int fa[1005], w[1005];
struct Node {
  int x, y, w, id;
} f[1000005];
bool cmp(Node a, Node b) { return a.w > b.w; }
int find1(int x) {
  if (fa[x] == x) return x;
  int fx = find1(fa[x]);
  w[x] = w[x] ^ w[fa[x]];
  fa[x] = fx;
  return fx;
}
bool union1(int x, int y) {
  int fx = find1(x);
  int fy = find1(y);
  if (fx == fy) {
    if (w[x] == w[y])
      return false;
    else
      return true;
  }
  fa[fx] = fy;
  w[fx] = w[x] ^ w[y] ^ 1;
  return true;
}
int main() {
  scanf("%d%d%d", &n, &m, &q);
  for (int i = 1; i <= m; ++i) {
    scanf("%d%d%d", &f[i].x, &f[i].y, &f[i].w);
    f[i].id = i;
  }
  sort(f + 1, f + m + 1, cmp);
  while (q--) {
    ans = -1;
    scanf("%d%d", &l, &r);
    for (int i = 1; i <= n; ++i) fa[i] = i, w[i] = 0;
    for (int i = 1; i <= m; ++i) {
      if (f[i].id >= l && f[i].id <= r) {
        if (!union1(f[i].x, f[i].y)) {
          ans = f[i].w;
          break;
        }
      }
    }
    printf("%d\n", ans);
  }
  return 0;
}
