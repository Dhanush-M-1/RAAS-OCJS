#include <bits/stdc++.h>
using namespace std;
const int maxn = 1005;
struct ed {
  int x, y, w, id;
} e[maxn * maxn];
bool cmp(ed a, ed b) { return a.w > b.w; }
int fa[maxn], en[maxn];
int find(int x) { return fa[x] == x ? x : fa[x] = find(fa[x]); }
void Merge(int x, int y) {
  int f = find(y);
  fa[f] = find(x);
}
int main() {
  int n, m, q;
  scanf("%d%d%d", &n, &m, &q);
  for (int i = 1; i <= m; i++) {
    scanf("%d%d%d", &e[i].x, &e[i].y, &e[i].w);
    e[i].id = i;
  }
  sort(e + 1, e + m + 1, cmp);
  while (q--) {
    memset(en, -1, sizeof(en));
    for (int i = 1; i <= n; i++) fa[i] = i;
    int l, r, ans = -1;
    scanf("%d%d", &l, &r);
    for (int i = 1; i <= m; i++)
      if (e[i].id >= l && e[i].id <= r) {
        if (find(e[i].x) == find(e[i].y)) {
          ans = e[i].w;
          break;
        }
        if (en[e[i].x] != -1)
          Merge(en[e[i].x], e[i].y);
        else
          en[e[i].x] = e[i].y;
        if (en[e[i].y] != -1)
          Merge(en[e[i].y], e[i].x);
        else
          en[e[i].y] = e[i].x;
      }
    printf("%d\n", ans);
  }
  return 0;
}
