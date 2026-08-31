#include <bits/stdc++.h>
using namespace std;
const int NR = 1e6 + 10;
void Min(long long& x, long long y) { x = min(x, y); }
void Max(long long& x, long long y) { x = max(x, y); }
int read() {
  int x = 0, f = 1;
  char ch = getchar();
  while (ch < '0' || ch > '9') {
    if (ch == '-') f = -1;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') {
    x = (x << 3) + (x << 1) + (ch ^ 48);
    ch = getchar();
  }
  return x * f;
}
int n, m, k, q, S;
struct Edge {
  int u, v;
  long long w;
  bool operator<(const Edge& A) const { return w < A.w; }
} e[NR];
int to[NR], nxt[NR], head[NR], tot = 1;
long long val[NR];
void add(int x, int y, long long z) {
  to[tot] = y, val[tot] = z, nxt[tot] = head[x], head[x] = tot++;
}
struct Nd {
  int x;
  long long d;
  bool operator<(const Nd& A) const { return d > A.d; }
};
Nd md(int x, long long d) {
  Nd tmp;
  tmp.x = x, tmp.d = d;
  return tmp;
}
bool vis[NR];
long long dis[NR];
void dijkstra() {
  memset(vis, 0, sizeof(vis));
  memset(dis, 0x3f, sizeof(dis));
  priority_queue<Nd> q;
  q.push(md(S, 0));
  dis[S] = 0;
  while (!q.empty()) {
    int x = q.top().x;
    q.pop();
    if (vis[x]) continue;
    vis[x] = 1;
    for (int i = head[x]; i; i = nxt[i]) {
      int y = to[i];
      if (dis[y] > dis[x] + val[i])
        dis[y] = dis[x] + val[i], q.push(md(y, dis[y]));
    }
  }
}
struct bcj {
  int fa[NR];
  void init() {
    for (int i = 1; i <= n; i++) fa[i] = i;
  }
  int find(int x) { return (x == fa[x]) ? x : fa[x] = find(fa[x]); }
  bool merge(int x, int y) {
    int fx = find(x), fy = find(y);
    if (fx == fy) return 0;
    fa[fx] = fy;
    return 1;
  }
} T;
void rebuild() {
  memset(head, 0, sizeof(head));
  tot = 1;
  sort(e + 1, e + m + 1);
  T.init();
  int cnt = 0;
  for (int i = 1; i <= m; i++) {
    if (cnt >= n - 1) return;
    if (T.merge(e[i].u, e[i].v))
      add(e[i].u, e[i].v, e[i].w), add(e[i].v, e[i].u, e[i].w), cnt++;
  }
}
int lg[NR], dep[NR], f[NR][20];
long long g[NR][20];
void dfs(int x, int fa_, long long v) {
  dep[x] = dep[fa_] + 1;
  f[x][0] = fa_;
  g[x][0] = v;
  for (int i = 1; i <= lg[dep[x]]; i++)
    f[x][i] = f[f[x][i - 1]][i - 1],
    g[x][i] = max(g[x][i - 1], g[f[x][i - 1]][i - 1]);
  for (int i = head[x]; i; i = nxt[i])
    if (to[i] != fa_) dfs(to[i], x, val[i]);
}
long long getmx(int x, int y) {
  long long res = 0;
  if (dep[x] < dep[y]) swap(x, y);
  while (dep[x] > dep[y])
    Max(res, g[x][lg[dep[x] - dep[y]] - 1]), x = f[x][lg[dep[x] - dep[y]] - 1];
  if (x == y) return res;
  for (int i = lg[dep[x]]; i >= 0; i--)
    if (f[x][i] ^ f[y][i])
      Max(res, g[x][i]), Max(res, g[y][i]), x = f[x][i], y = f[y][i];
  return max(res, max(g[x][0], g[y][0]));
}
int main() {
  n = read(), m = read(), k = read(), q = read();
  for (int i = 1; i <= m; i++) {
    e[i].u = read(), e[i].v = read(), e[i].w = read();
    add(e[i].u, e[i].v, e[i].w), add(e[i].v, e[i].u, e[i].w);
  }
  for (int i = 1; i <= k; i++) add(S, i, 0);
  dijkstra();
  for (int i = 1; i <= m; i++) e[i].w += dis[e[i].u] + dis[e[i].v];
  for (int i = 1; i <= n; i++) lg[i] = (lg[i - 1] + ((1 << lg[i - 1]) == i));
  rebuild();
  dfs(1, 0, 0);
  for (int i = 1; i <= q; i++) {
    int x = read(), y = read();
    printf("%lld\n", getmx(x, y));
  }
  return 0;
}
