#include <bits/stdc++.h>
using namespace std;
const long long inf = 1e16;
const int maxn = 1e5 + 10;
const int maxm = 3e5 + 10;
const int L = 18;
int n, m, k, q;
vector<pair<int, long long> > e[maxn];
struct Edge {
  int u, v;
  long long w;
  Edge(int _u = 0, int _v = 0, long long _w = 0) {
    u = _u;
    v = _v;
    w = _w;
  }
  bool operator<(const Edge &other) const { return w < other.w; }
} edge[maxm];
long long dis[maxn];
priority_queue<pair<long long, int>, vector<pair<long long, int> >,
               greater<pair<long long, int> > >
    pq;
bool vis[maxn];
int fa[maxn], sz[maxn], dep[maxn], f[maxn][L];
long long g[maxn][L];
inline int read() {
  int x = 0, f = 1, ch = getchar();
  while (ch < '0' || ch > '9') {
    if (ch == '-') f = -1;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') {
    x = (x << 3) + (x << 1) + (ch - '0');
    ch = getchar();
  }
  return f == 1 ? x : -x;
}
void print(int a[], int n, int st = 0) {
  for (int i = 0; i < n; i++) {
    if (i != 0) printf(" ");
    printf("%d", a[i + st]);
  }
  printf("\n");
}
void init() {
  n = read();
  m = read();
  k = read();
  q = read();
  for (int i = 1; i <= m; i++) {
    int u = read(), v = read(), w = read();
    e[u].push_back(make_pair(v, w));
    e[v].push_back(make_pair(u, w));
  }
}
inline void dijkstra() {
  for (int i = 1; i <= k; i++) dis[i] = 0, pq.push(make_pair(0, i));
  for (int i = k + 1; i <= n; i++) dis[i] = inf;
  while (!pq.empty()) {
    int u = pq.top().second;
    long long d = pq.top().first;
    pq.pop();
    if (vis[u]) continue;
    vis[u] = true;
    for (int i = 0; i < e[u].size(); i++) {
      int v = e[u][i].first;
      long long w = e[u][i].second;
      if (d + w < dis[v]) {
        dis[v] = d + w;
        pq.push(make_pair(dis[v], v));
      }
    }
  }
}
inline int root(int x) { return x == fa[x] ? x : fa[x] = root(fa[x]); }
inline void merge(int x, int y) {
  x = root(x);
  y = root(y);
  if (x != y) {
    if (sz[x] > sz[y]) swap(x, y);
    sz[y] += sz[x];
    fa[x] = y;
  }
}
inline void dfs(int u, int pa) {
  fa[u] = f[u][0] = pa;
  dep[u] = dep[pa] + 1;
  for (int i = 0; i < e[u].size(); i++) {
    int v = e[u][i].first;
    long long w = e[u][i].second;
    if (v == pa) continue;
    dfs(v, u);
    g[v][0] = w;
  }
}
inline int getlca(int u, int v) {
  if (dep[u] < dep[v]) swap(u, v);
  for (int diff = dep[u] - dep[v], i = 0; i < L; i++)
    if ((diff >> i) & 1) u = f[u][i];
  if (u == v) return u;
  for (int i = L - 1; i >= 0; i--)
    if (f[u][i] != f[v][i]) u = f[u][i], v = f[v][i];
  return f[u][0];
}
inline long long lift(int u, int len) {
  if (len <= 0) return 0;
  long long ret = 0;
  for (int i = 0; i < L; i++)
    if ((len >> i) & 1) ret = max(ret, g[u][i]), u = f[u][i];
  return ret;
}
void doit() {
  dijkstra();
  m = 0;
  for (int u = 1; u <= n; u++)
    for (int i = 0; i < e[u].size(); i++) {
      int v = e[u][i].first;
      if (v < u) continue;
      edge[++m] = Edge(u, v, dis[u] + dis[v] + e[u][i].second);
    }
  sort(edge + 1, edge + m + 1);
  for (int i = 1; i <= n; i++) e[i].clear();
  for (int i = 1; i <= n; i++) fa[i] = i, sz[i] = 1;
  for (int i = 1; i <= m; i++)
    if (root(edge[i].u) != root(edge[i].v)) {
      merge(edge[i].u, edge[i].v);
      e[edge[i].u].push_back(make_pair(edge[i].v, edge[i].w));
      e[edge[i].v].push_back(make_pair(edge[i].u, edge[i].w));
    }
  dfs(1, 0);
  for (int j = 1; j < L; j++)
    for (int i = 1; i <= n; i++)
      f[i][j] = f[f[i][j - 1]][j - 1],
      g[i][j] = max(g[i][j - 1], g[f[i][j - 1]][j - 1]);
  while (q--) {
    int x = read(), y = read(), lca = getlca(x, y);
    long long ans = max(lift(x, dep[x] - dep[lca]), lift(y, dep[y] - dep[lca]));
    printf("%lld\n", ans);
  }
}
int main() {
  init();
  doit();
  return 0;
}
