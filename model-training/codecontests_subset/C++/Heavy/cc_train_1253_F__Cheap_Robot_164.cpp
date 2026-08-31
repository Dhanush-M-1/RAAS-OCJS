#include <bits/stdc++.h>
using namespace std;
const long long MAXN = 2e6 + 8, mod = 1e9 + 8, inf = 1ll << 50;
struct E {
  int x, y, nt;
  long long v;
  bool operator<(const E& b) const { return v < b.v; }
} e[MAXN];
int head[MAXN], cnt;
inline void add(int x, int y, long long v) {
  e[++cnt].nt = head[x];
  head[x] = cnt;
  e[cnt].v = v;
  e[cnt].x = x;
  e[cnt].y = y;
}
struct Node {
  int y, nt;
} node[MAXN << 1];
int Nodehead[MAXN << 1], Nodecnt;
inline void addNode(int x, int y) {
  node[++Nodecnt].nt = Nodehead[x];
  node[Nodecnt].y = y;
  Nodehead[x] = Nodecnt;
}
int n, m, k, q;
long long dis[MAXN];
bool vis[MAXN];
void dijkstra() {
  priority_queue<pair<long long, int>> que;
  for (int i = 1; i <= k; ++i) que.emplace(0, i);
  for (int i = k + 1; i <= n; ++i) dis[i] = inf;
  int x, y;
  long long v;
  while (!que.empty()) {
    x = que.top().second;
    que.pop();
    if (vis[x]) continue;
    vis[x] = 1;
    for (int i = head[x]; i; i = e[i].nt) {
      y = e[i].y, v = e[i].v;
      if (dis[y] > dis[x] + v) {
        dis[y] = dis[x] + v;
        que.emplace(-dis[y], y);
      }
    }
  }
}
int deep[MAXN << 1], son[MAXN << 1], fa[MAXN << 1], tot[MAXN << 1];
void dfs1(int x, int f) {
  deep[x] = deep[f] + 1, tot[x] = 1, fa[x] = f;
  int max_son = -1;
  for (int i = Nodehead[x]; i; i = node[i].nt) {
    int y = node[i].y;
    if (tot[y]) continue;
    dfs1(y, x);
    tot[x] += tot[y];
    if (max_son < tot[y]) son[x] = y, max_son = tot[y];
  }
}
int top[MAXN << 1];
void dfs2(int x, int tp) {
  top[x] = tp;
  if (son[x])
    dfs2(son[x], tp);
  else
    return;
  for (int i = Nodehead[x]; i; i = node[i].nt) {
    int y = node[i].y;
    if (top[y]) continue;
    dfs2(y, y);
  }
}
int lca(int x, int y) {
  while (top[x] ^ top[y]) {
    if (deep[top[x]] < deep[top[y]])
      y = fa[top[y]];
    else
      x = fa[top[x]];
  }
  if (deep[x] > deep[y]) return y;
  return x;
}
int find(int x) { return x ^ fa[x] ? (fa[x] = find(fa[x])) : x; }
long long val[MAXN << 1];
void kruskal() {
  int id = n;
  sort(e + 1, e + 1 + cnt);
  for (int i = 0; i < n * 2 + 2; ++i) fa[i] = i;
  for (int i = 1; i <= cnt; ++i) {
    int fx = find(e[i].x), fy = find(e[i].y);
    if (fx ^ fy) {
      val[++id] = e[i].v;
      fa[fx] = fa[fy] = id;
      addNode(id, fx);
      addNode(fx, id);
      addNode(id, fy);
      addNode(fy, id);
    }
  }
  dfs1(id, 0);
  dfs2(id, id);
}
int main() {
  cin >> n >> m >> k >> q;
  for (int i = 0; i < m; ++i) {
    int x, y;
    long long v;
    scanf("%d%d%lld", &x, &y, &v);
    add(x, y, v);
    add(y, x, v);
  }
  dijkstra();
  for (int i = 1; i <= n; ++i)
    for (int j = head[i]; j; j = e[j].nt) {
      e[j].v += dis[e[j].x] + dis[e[j].y];
    }
  kruskal();
  while (q--) {
    int x, y;
    scanf("%d%d", &x, &y);
    printf("%lld\n", val[lca(x, y)]);
  }
}
