#include <bits/stdc++.h>
using namespace std;
int n, m, head[100000 + 5], cnt = 0, fa[100000 + 5], ans, dep[100000 + 5],
                            f[20][100000 + 5];
long long g[20][100000 + 5], d[100000 + 5];
struct node {
  int uu, vv;
  long long w;
} a[300000 + 5];
struct edge {
  int end, next;
  long long val;
} e[700000 + 5];
struct node1 {
  int id;
  long long dis;
  bool operator<(const node1& x) const { return x.dis < dis; }
};
bool vis[100000 + 5];
bool cmp(node A, node B) { return A.w < B.w; }
void add_edge(int u, int v, long long c) {
  e[++cnt].end = v;
  e[cnt].val = c;
  e[cnt].next = head[u];
  head[u] = cnt;
}
priority_queue<node1> Q;
void dijkstra() {
  while (!Q.empty()) {
    node1 now = Q.top();
    Q.pop();
    int u = now.id;
    if (vis[u]) continue;
    vis[u] = true;
    for (int i = head[u]; i > 0; i = e[i].next)
      if (d[e[i].end] > d[u] + e[i].val) {
        int v = e[i].end;
        d[v] = d[u] + e[i].val;
        node1 b;
        b.id = v;
        b.dis = d[v];
        Q.push(b);
      }
  }
}
int get(int x) {
  if (fa[x] == x) return x;
  return fa[x] = get(fa[x]);
}
void merge(int u, int v) { fa[get(v)] = get(u); }
void kruskal() {
  int t = 0;
  for (int i = 1; i <= m; i++)
    if (get(a[i].uu) != get(a[i].vv)) {
      t++;
      ans += a[i].w;
      add_edge(a[i].uu, a[i].vv, a[i].w);
      add_edge(a[i].vv, a[i].uu, a[i].w);
      merge(a[i].uu, a[i].vv);
      if (t == n - 1) return;
    }
}
void dfs(int u) {
  int i, v;
  for (i = head[u]; i > 0; i = e[i].next) {
    v = e[i].end;
    if (v == f[0][u]) continue;
    f[0][v] = u;
    g[0][v] = e[i].val;
    dep[v] = dep[u] + 1;
    dfs(v);
  }
}
long long lca(int u, int v) {
  int i;
  long long ans = 0;
  if (dep[u] > dep[v]) swap(u, v);
  for (i = 18; i >= 0; i--)
    if (dep[u] <= dep[f[i][v]]) {
      ans = max(ans, g[i][v]);
      v = f[i][v];
    }
  if (u == v) return ans;
  for (i = 18; i >= 0; i--)
    if (f[i][u] != f[i][v]) {
      ans = max(ans, max(g[i][u], g[i][v]));
      u = f[i][u];
      v = f[i][v];
    }
  ans = max(ans, max(g[0][u], g[0][v]));
  return ans;
}
int main() {
  int k, q, i, j, u, v;
  scanf("%d%d%d%d", &n, &m, &k, &q);
  for (i = 1; i <= m; i++) {
    scanf("%d%d%lld", &a[i].uu, &a[i].vv, &a[i].w);
    add_edge(a[i].uu, a[i].vv, a[i].w);
    add_edge(a[i].vv, a[i].uu, a[i].w);
  }
  for (i = 1; i <= k; i++) add_edge(0, i, 0);
  for (i = 1; i <= n; i++) d[i] = 1e16;
  node1 now;
  now.dis = 0;
  now.id = 0;
  d[0] = 0;
  Q.push(now);
  dijkstra();
  for (i = 1; i <= m; i++) {
    a[i].w = a[i].w + d[a[i].uu] + d[a[i].vv];
  }
  sort(a + 1, a + m + 1, cmp);
  memset(e, 0, sizeof(e));
  memset(head, 0, sizeof(head));
  cnt = 0;
  for (i = 1; i <= n; i++) fa[i] = i;
  kruskal();
  f[0][1] = 1;
  dep[1] = 1;
  dfs(1);
  for (i = 1; i <= 18; i++)
    for (j = 1; j <= n; j++) {
      f[i][j] = f[i - 1][f[i - 1][j]];
      g[i][j] = max(g[i - 1][j], g[i - 1][f[i - 1][j]]);
    }
  for (i = 1; i <= q; i++) {
    scanf("%d%d", &u, &v);
    printf("%lld\n", lca(u, v));
  }
}
