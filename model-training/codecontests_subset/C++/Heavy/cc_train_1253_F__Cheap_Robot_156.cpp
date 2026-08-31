#include <bits/stdc++.h>
using namespace std;
const int A = 1e5 + 11;
const int B = 1e6 + 11;
const int mod = 1e9 + 7;
const int inf = 0x3f3f3f3f;
inline int read() {
  char c = getchar();
  int x = 0, f = 1;
  for (; !isdigit(c); c = getchar())
    if (c == '-') f = -1;
  for (; isdigit(c); c = getchar()) x = x * 10 + (c ^ 48);
  return x * f;
}
struct edgexx {
  int v, nxt, w;
} edge[B];
struct edgex {
  int v, nxt;
} edge_[B];
struct node {
  long long d;
  int id;
  bool operator<(const node &a) const { return d > a.d; }
};
struct xxs {
  int u, v;
  long long w;
  bool operator<(const xxs &e) const { return w < e.w; }
} e[B];
int n, cnt, js, k, c, t, head[B], m, q, head2[B], fa[B], u_fa[B];
long long dis[B], wnd[B];
int sz[B], son[B], top[B], dep[B];
priority_queue<node> pq;
void add1(int u, int v, int w) {
  edge[++cnt].nxt = head[u];
  edge[cnt].v = v;
  edge[cnt].w = w;
  head[u] = cnt;
}
void add2(int u, int v) {
  edge_[++js].nxt = head2[u];
  edge_[js].v = v;
  head2[u] = js;
}
int find(int x) {
  if (x == u_fa[x]) return x;
  return u_fa[x] = find(u_fa[x]);
}
void dfs1(int u, int f) {
  sz[u] = 1;
  dep[u] = dep[fa[u] = f] + 1;
  for (int i = head2[u]; i; i = edge_[i].nxt) {
    int v = edge_[i].v;
    if (v == f) continue;
    dfs1(v, u);
    sz[u] += sz[v];
    if (sz[v] > sz[son[u]]) son[u] = v;
  }
}
void dfs2(int u, int topf) {
  top[u] = topf;
  if (son[u]) dfs2(son[u], topf);
  for (int i = head2[u]; i; i = edge_[i].nxt) {
    int v = edge_[i].v;
    if (v == fa[u] || v == son[u]) continue;
    dfs2(v, v);
  }
}
int lca(int u, int v) {
  while (top[u] != top[v]) {
    if (dep[top[u]] < dep[top[v]]) swap(u, v);
    u = fa[top[u]];
  }
  return dep[u] < dep[v] ? u : v;
}
int main() {
  cin >> n >> m >> k >> q;
  for (int i = 1; i <= m; i++) {
    int x = read(), y = read(), z = read();
    add1(x, y, z);
    add1(y, x, z);
    e[i] = (xxs){x, y, z};
  }
  memset(dis, 0x3f, sizeof(dis));
  for (int i = 1; i <= k; i++) pq.push((node){dis[i] = 0, i});
  while (!pq.empty()) {
    long long d = pq.top().d;
    int u = pq.top().id;
    pq.pop();
    if (d != dis[u]) continue;
    for (int i = head[u]; i; i = edge[i].nxt) {
      int v = edge[i].v;
      if (dis[v] > d + edge[i].w) pq.push((node){dis[v] = d + edge[i].w, v});
    }
  }
  for (int i = 1; i <= m; i++) e[i].w += dis[e[i].u] + dis[e[i].v];
  sort(e + 1, e + 1 + m);
  for (int i = 1; i <= 2 * n; i++) u_fa[i] = i;
  cnt = n;
  for (int i = 1; i <= m; i++) {
    int u = e[i].u, v = e[i].v;
    long long w = e[i].w;
    u = find(u);
    v = find(v);
    if (u == v) continue;
    u_fa[u] = u_fa[v] = ++cnt;
    wnd[cnt] = w;
    add2(cnt, u);
    add2(cnt, v);
  }
  dfs1(cnt, 0);
  dfs2(cnt, cnt);
  while (q--) {
    int u = read(), v = read();
    printf("%lld\n", wnd[lca(u, v)]);
  }
  return 0;
}
