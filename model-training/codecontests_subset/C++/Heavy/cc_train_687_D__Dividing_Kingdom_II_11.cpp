#include <bits/stdc++.h>
using namespace std;
const int N = 1e6 + 10, inf = 2e9, mod = 1e9 + 7;
int n, m, q, fa[N];
struct ss {
  int u, v, w, id;
} s[N];
bool cmp(ss s1, ss s2) { return s1.w > s2.w; }
int finds(int x) { return x == fa[x] ? x : fa[x] = finds(fa[x]); }
int main() {
  scanf("%d%d%d", &n, &m, &q);
  for (int i = 1; i <= m; i++) {
    scanf("%d%d%d", &s[i].u, &s[i].v, &s[i].w);
    s[i].id = i;
  }
  sort(s + 1, s + m + 1, cmp);
  while (q--) {
    int f = 0, l, r;
    scanf("%d%d", &l, &r);
    for (int i = 1; i <= n * 3; i++) fa[i] = i;
    for (int i = 1; i <= m; i++) {
      if (s[i].id >= l && s[i].id <= r) {
        int fx = finds(s[i].u), fy = finds(s[i].v);
        if (fx == fy) {
          f = 1;
          printf("%d\n", s[i].w);
          break;
        } else {
          fa[fx] = finds(s[i].v + n);
          fa[fy] = finds(s[i].u + n);
        }
      }
    }
    if (!f) printf("%d\n", -1);
  }
  return 0;
}
