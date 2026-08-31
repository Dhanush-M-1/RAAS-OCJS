#include <bits/stdc++.h>
using namespace std;
const int N = 3e5 + 10;
int n, m, q, u, v, op;
int cnt, len, t;
int head[N], fa[N], dis[N], clr[N];
struct edge {
  int nxt, to;
} e[N << 1];
inline void add(int u, int v) {
  e[++cnt] = edge{head[u], v};
  head[u] = cnt;
}
int find(int x) { return fa[x] == x ? x : fa[x] = find(fa[x]); }
inline void merge(int x, int y) {
  if (find(x) == find(y)) return;
  fa[fa[x]] = fa[y];
}
void dfs(int u, int c, int l) {
  if (clr[u] == c) return;
  if (len < l) {
    len = l;
    t = u;
  }
  clr[u] = c;
  for (int i = head[u]; i; i = e[i].nxt) {
    int v = e[i].to;
    merge(u, v);
    dfs(v, c, l + 1);
  }
}
int main() {
  scanf("%d%d%d", &n, &m, &q);
  for (int i = 1; i <= n; i++) fa[i] = i;
  for (int i = 1; i <= m; i++) {
    scanf("%d%d", &u, &v);
    add(u, v);
    add(v, u);
  }
  for (int i = 1; i <= n; i++)
    if (!clr[i]) {
      len = 0, t = i;
      dfs(i, i, 0);
      len = 0;
      dfs(t, t, 0);
      dis[find(i)] = len;
    }
  for (; q--;) {
    scanf("%d", &op);
    if (op == 1) {
      scanf("%d", &u);
      printf("%d\n", dis[find(u)]);
    } else {
      scanf("%d%d", &u, &v);
      u = find(u), v = find(v);
      if (u == v) continue;
      fa[u] = v;
      dis[v] =
          max((dis[u] + 1 >> 1) + (dis[v] + 1 >> 1) + 1, max(dis[u], dis[v]));
    }
  }
  return 0;
}
