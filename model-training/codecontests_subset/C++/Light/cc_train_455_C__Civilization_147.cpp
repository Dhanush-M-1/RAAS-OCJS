#include <bits/stdc++.h>
using namespace std;
const int maxn = 300100;
int head[maxn], nxt[maxn << 1], ver[maxn << 1], tot;
void addedge(int a, int b) {
  nxt[++tot] = head[a];
  ver[tot] = b;
  head[a] = tot;
  nxt[++tot] = head[b];
  ver[tot] = a;
  head[b] = tot;
}
int f[maxn], getlen;
void treedp(int x, int fat) {
  f[x] = 0;
  int mx = 0, sm = 0;
  for (int i = head[x]; i; i = nxt[i]) {
    int y = ver[i];
    if (y == fat) continue;
    treedp(y, x);
    int F = f[y] + 1;
    f[x] = max(f[x], F);
    if (F >= mx)
      sm = mx, mx = F;
    else if (F > sm)
      sm = F;
  }
  getlen = max(getlen, mx + sm);
}
int getpath(int x) {
  getlen = 0;
  treedp(x, 0);
  return getlen;
}
int v[maxn], fa[maxn];
int find(int x) { return x == fa[x] ? x : fa[x] = find(fa[x]); }
int main() {
  int n, m, q;
  scanf("%d%d%d", &n, &m, &q);
  for (int i = 1; i <= n; i++) fa[i] = i;
  for (int i = 1; i <= m; i++) {
    int a, b;
    scanf("%d%d", &a, &b);
    addedge(a, b);
    fa[find(a)] = find(b);
  }
  for (int i = 1; i <= n; i++)
    if (find(i) == i) v[i] = getpath(i);
  for (int i = 1; i <= q; i++) {
    int opt, a, b;
    scanf("%d", &opt);
    if (opt == 1)
      scanf("%d", &a), printf("%d\n", v[find(a)]);
    else {
      scanf("%d%d", &a, &b);
      a = find(a);
      b = find(b);
      if (a == b) continue;
      v[b] = max(max(v[a], v[b]), ((v[a] + 1) >> 1) + ((v[b] + 1) >> 1) + 1);
      fa[a] = b;
    }
  }
  return 0;
}
