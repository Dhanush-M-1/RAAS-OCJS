#include <bits/stdc++.h>
using namespace std;
const int inf = 1e9;
const int NN = 3011;
inline int read() {
  int t = 0, f = 1;
  char ch = getchar();
  while (ch < '0' || ch > '9') f = (ch == '-') ? -1 : 1, ch = getchar();
  while (ch >= '0' && ch <= '9') t = t * 10 + ch - '0', ch = getchar();
  return t * f;
}
double ans = 0;
int n, tot = 0, a[NN << 1], num[NN], fa[NN];
bool huan[NN], vt[NN];
int cc = 1, to[NN << 1], nex[NN << 1], o[NN];
inline void add(int x, int y) {
  to[++cc] = y, nex[cc] = o[x], o[x] = cc;
  to[++cc] = x, nex[cc] = o[y], o[y] = cc;
}
bool dfs(int x, int pre) {
  vt[x] = 1;
  for (int k = o[x]; k; k = nex[k]) {
    if ((k ^ 1) == pre) continue;
    int y = to[k];
    if (vt[y]) {
      a[++tot] = y, huan[y] = 1;
      while (x != y) huan[x] = 1, a[++tot] = x, x = fa[x];
      return 1;
    }
    fa[y] = x;
    if (dfs(y, k)) return 1;
  }
  return 0;
}
void work(int x, int t1, int t2) {
  vt[x] = 1;
  if (t2 < 0)
    ans += 1.0 / t1;
  else
    ans += 1.0 / t1 + 1.0 / t2 - 1.0 / ((t1 + t2 - 2 - tot) / 2 + tot);
  if (huan[x] && t2 < 0 && tot > 1) {
    int now = num[x];
    for (int i = now + 1; i <= now + tot - 1; i++) vt[a[i]] = 1;
    for (int i = 1; i <= tot - 1; i++) work(a[now + i], t1 + i, t1 + tot - i);
  }
  for (int k = o[x]; k; k = nex[k]) {
    int y = to[k];
    if (vt[y]) continue;
    work(y, t1 + 1, t2 + 1);
  }
}
int main() {
  n = read();
  for (int i = 1; i <= n; i++) add(read() + 1, read() + 1);
  dfs(1, 0);
  for (int i = 1; i <= tot; i++) a[tot + i] = a[i], num[a[i]] = i;
  for (int i = 1; i <= n; i++) {
    memset(vt, 0, sizeof(bool) * (n + 10));
    work(i, 1, -inf);
  }
  printf("%.10lf\n", ans);
  return 0;
}
