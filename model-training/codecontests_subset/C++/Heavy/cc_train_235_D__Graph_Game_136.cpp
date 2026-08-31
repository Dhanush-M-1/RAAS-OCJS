#include <bits/stdc++.h>
using namespace std;
const int maxn = 3005;
int n, dep[maxn], point[maxn << 1], nextp[maxn << 1], head[maxn], cir[maxn],
    len, ecnt;
void ins(int u, int v) {
  point[++ecnt] = v;
  nextp[ecnt] = head[u];
  head[u] = ecnt;
}
int dfs(int x, int f) {
  dep[x] = dep[f] + 1;
  int i, to, tmp, res = 0;
  for (i = head[x]; i; i = nextp[i]) {
    to = point[i];
    if (to == f) continue;
    if (dep[to]) {
      if (dep[to] < dep[x])
        len = res = dep[x] - dep[to] + 1;
      else
        continue;
    } else if (tmp = dfs(to, x))
      res = tmp;
  }
  if (res) cir[x] = 1, res--;
  return res;
}
int a[maxn], b[maxn];
void dfs2(int x) {
  int i, to;
  for (i = head[x]; i; i = nextp[i]) {
    to = point[i];
    if (a[to] == -1) {
      a[to] = a[x] + 1 - cir[to];
      b[to] = b[x] + cir[to];
      dfs2(to);
    }
  }
}
double ans;
int main() {
  int i, j, u, v;
  scanf("%d", &n);
  for (i = 1; i <= n; i++) {
    scanf("%d%d", &u, &v);
    ++u;
    ++v;
    ins(u, v);
    ins(v, u);
  }
  dfs(1, 0);
  for (i = 1; i <= n; i++) {
    for (j = 1; j <= n; j++) a[j] = b[j] = -1;
    b[i] = cir[i];
    a[i] = 1 - cir[i];
    dfs2(i);
    for (j = 1; j <= n; j++) {
      ans += 1. / (a[j] + b[j]);
      if (b[j] > 2) {
        ans += 1. / (a[j] + len - b[j] + 2);
        ans -= 1. / (a[j] + len);
      }
    }
  }
  printf("%.10f\n", ans);
  return 0;
}
