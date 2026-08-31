#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e3 + 5;
const int maxm = 1e6 + 5;
int readint() {
  int x = 0, f = 1;
  char s = getchar();
  while (s < '0' || s > '9') {
    if (s == '-') f = -1;
    (s = getchar());
  }
  while (s >= '0' && s <= '9') {
    x = (x << 3) + (x << 1) + (s ^ 48);
    (s = getchar());
  }
  return x * f;
}
struct edge {
  int u, v, id, w;
} e[maxm];
bool cmp(const edge &x, const edge &y) { return x.w > y.w; }
int fa[maxn << 1];
int findset(int x) {
  if (x != fa[x]) fa[x] = findset(fa[x]);
  return fa[x];
}
int main() {
  int n = readint(), m = readint(), q = readint();
  for (int i = 1; i <= m; i++) {
    e[i].u = readint(), e[i].v = readint(), e[i].w = readint();
    e[i].id = i;
  }
  sort(e + 1, e + m + 1, cmp);
  while (q--) {
    int ans = -1;
    int l = readint(), r = readint();
    for (int i = 1; i <= (n << 1); i++) {
      fa[i] = i;
    }
    for (int i = 1; i <= m; i++) {
      if (e[i].id < l || e[i].id > r) continue;
      int fu = findset(e[i].u), fv = findset(e[i].v);
      if (fu == fv) {
        ans = e[i].w;
        break;
      } else {
        int fu1 = findset(e[i].u + n), fv1 = findset(e[i].v + n);
        if (fu != fv1) fa[fu] = fv1;
        if (fu1 != fv) fa[fu1] = fv;
      }
    }
    printf("%d\n", ans);
  }
  return 0;
}
