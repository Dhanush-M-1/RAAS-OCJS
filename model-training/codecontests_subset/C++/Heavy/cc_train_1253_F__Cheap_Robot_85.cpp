#include <bits/stdc++.h>
using namespace std;
int n, m, k, q, vis[100005], cd[100005], etot, fa[100005];
int ffa[100005][24], dep[100005], lg[100005];
long long dis[100005], mma[100005][24];
struct edge {
  int to;
  long long w;
  edge() {}
  edge(int to, long long w) : to(to), w(w) {}
};
struct node {
  int x, y;
  long long w;
  node() {}
  node(int x, int y, long long w) : x(x), y(y), w(w) {}
} ee[1000005];
vector<edge> e[100005], e2[100005];
bool cmp(node a, node b) { return a.w < b.w; }
int _find(int x) { return fa[x] == x ? x : fa[x] = _find(fa[x]); }
void _merge(int x, int y) {
  x = _find(x), y = _find(y);
  fa[x] = y;
}
void dij() {
  for (int i = 1; i <= n + 1; i++) dis[i] = 0x3f3f3f3f3f3f3f3fll;
  dis[n + 1] = 0;
  priority_queue<pair<long long, long long>, vector<pair<long long, long long>>,
                 greater<pair<long long, long long>>>
      q;
  q.emplace(0, n + 1);
  while (!q.empty()) {
    int now = q.top().second;
    q.pop();
    if (vis[now]) continue;
    vis[now] = 1;
    for (auto it : e[now])
      if (dis[it.to] > dis[now] + it.w) {
        dis[it.to] = dis[now] + it.w;
        if (now != n + 1) cd[it.to] = cd[now];
        q.emplace(dis[it.to], it.to);
      }
  }
}
void mst() {
  for (int i = 1; i <= n; i++) fa[i] = i;
  sort(ee, ee + etot, cmp);
  for (int i = 0; i < etot; i++)
    if (_find(ee[i].x) != _find(ee[i].y)) {
      _merge(ee[i].x, ee[i].y);
      e2[ee[i].x].emplace_back(ee[i].y, ee[i].w);
      e2[ee[i].y].emplace_back(ee[i].x, ee[i].w);
    }
}
void dfs(int now, int pa, long long dd) {
  dep[now] = dep[pa] + 1;
  ffa[now][0] = pa;
  mma[now][0] = dd;
  for (int i = 1; (1 << i) <= dep[now]; i++) {
    ffa[now][i] = ffa[ffa[now][i - 1]][i - 1];
    mma[now][i] = max(mma[now][i - 1], mma[ffa[now][i - 1]][i - 1]);
  }
  for (auto it : e2[now])
    if (it.to != pa) dfs(it.to, now, it.w);
}
long long lca(int x, int y) {
  long long ret = 0;
  if (dep[x] < dep[y]) swap(x, y);
  while (dep[x] > dep[y]) {
    ret = max(ret, mma[x][lg[dep[x] - dep[y]] - 1]);
    x = ffa[x][lg[dep[x] - dep[y]] - 1];
  }
  if (x == y) return ret;
  for (int i = lg[dep[x]] - 1; i >= 0; i--)
    if (ffa[x][i] != ffa[y][i]) {
      ret = max(ret, mma[x][i]);
      ret = max(ret, mma[y][i]);
      x = ffa[x][i], y = ffa[y][i];
    }
  return max(ret, max(mma[y][0], mma[x][0]));
}
int main() {
  scanf("%d%d%d%d", &n, &m, &k, &q);
  for (int i = 1; i <= n + 1; i++) lg[i] = lg[i - 1] + (1 << lg[i - 1] == i);
  for (int i = 1, x, y, w; i <= m; i++) {
    scanf("%d%d%d", &x, &y, &w);
    e[x].emplace_back(y, w);
    e[y].emplace_back(x, w);
  }
  for (int i = 1; i <= k; i++) e[n + 1].emplace_back(i, 0), cd[i] = i;
  dij();
  for (int i = 1; i <= n; i++)
    for (auto it : e[i]) {
      if (cd[i] != cd[it.to])
        ee[etot++] = node(cd[i], cd[it.to], dis[i] + it.w + dis[it.to]);
      else
        ee[etot++] = node(i, it.to, it.w);
    }
  mst();
  dfs(1, 0, 0);
  while (q--) {
    int x, y;
    scanf("%d%d", &x, &y);
    printf("%lld\n", lca(x, y));
  }
  return 0;
}
