#include <bits/stdc++.h>
using namespace std;
int flag, n, q, m, rl[1010], fa[1010];
struct data {
  int u, v, w, id;
  bool operator<(const data &rhs) const { return w < rhs.w; }
} ed[1001000];
void Init() {
  flag = 0;
  for (int i = 1; i <= n; i++) fa[i] = i, rl[i] = 0;
}
int find(int k) {
  if (fa[k] == k) return k;
  int f = find(fa[k]);
  rl[k] ^= rl[fa[k]];
  return fa[k] = f;
}
bool Unite(int x, int y) {
  int fx = find(x), fy = find(y);
  if (fx == fy && rl[x] == rl[y]) return 0;
  if (fx != fy) {
    fa[fx] = fy;
    rl[fx] = rl[x] ^ rl[y] ^ 1;
  }
  return 1;
}
int main() {
  scanf("%d%d%d", &n, &m, &q);
  for (int i = 1; i <= m; i++)
    scanf("%d%d%d", &ed[i].u, &ed[i].v, &ed[i].w), ed[i].id = i;
  sort(ed + 1, ed + m + 1);
  while (q--) {
    int l, r;
    scanf("%d%d", &l, &r);
    Init();
    for (int i = m; i >= 1; i--)
      if (ed[i].id >= l && ed[i].id <= r)
        if (!Unite(ed[i].u, ed[i].v)) {
          flag = 1;
          printf("%d\n", ed[i].w);
          break;
        }
    if (!flag) puts("-1");
  }
}
