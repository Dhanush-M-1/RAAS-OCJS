#include <bits/stdc++.h>
using namespace std;
const int N = 3e5 + 5;
int n, m, q, opt, u, v, xx, yy, p, ans;
int f[N], d[N];
int cnt, head[N];
struct edge {
  int next, to;
} e[N << 1];
inline void add(int u, int v) {
  cnt++;
  e[cnt].next = head[u];
  e[cnt].to = v;
  head[u] = cnt;
}
int find(int x) {
  if (f[x] == x) return x;
  return f[x] = find(f[x]);
}
void dfs(int u, int fa, int now) {
  if (now > ans) ans = now, p = u;
  for (register int i = head[u]; i; i = e[i].next)
    if (e[i].to != fa) dfs(e[i].to, u, now + 1);
}
int main() {
  scanf("%d%d%d", &n, &m, &q);
  for (register int i = 1; i <= n; ++i) f[i] = i;
  for (register int i = 1; i <= m; ++i) {
    scanf("%d%d", &u, &v), add(u, v), add(v, u);
    xx = find(u);
    yy = find(v);
    if (xx != yy) f[xx] = yy;
  }
  for (register int i = 1; i <= n; ++i)
    if (find(i) == i) {
      ans = 0;
      p = i;
      dfs(p, 0, 0);
      ans = 0;
      dfs(p, 0, 0);
      d[i] = ans;
    }
  while (q--) {
    scanf("%d", &opt);
    if (opt == 1) {
      scanf("%d", &u);
      xx = find(u);
      printf("%d\n", d[xx]);
    } else {
      scanf("%d%d", &u, &v);
      xx = find(u);
      yy = find(v);
      if (xx == yy) continue;
      f[xx] = yy;
      d[yy] = max((d[xx] + 1) / 2 + (d[yy] + 1) / 2 + 1, max(d[xx], d[yy]));
    }
  }
  return 0;
}
