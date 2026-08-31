#include <bits/stdc++.h>
using namespace std;
const int maxn = 3e5 + 10;
const long long INF = 0x3f3f3f3f3f3f;
struct Edge {
  int from, to;
  long long cost;
  Edge(int u, int v, long long cost) : from(u), to(v), cost(cost) {}
};
vector<int> G[maxn];
vector<Edge> edges;
void add_edges(int u, int v, long long cost) {
  edges.push_back(Edge(u, v, cost));
  edges.push_back(Edge(v, u, cost));
  int sz = edges.size();
  G[u].push_back(sz - 2);
  G[v].push_back(sz - 1);
}
int vis[maxn];
long long dis[maxn];
int belong[maxn];
int n, m, k, q;
struct HeapNode {
  int u;
  long long d;
  HeapNode(int _u, long long _d) : u(_u), d(_d) {}
  bool operator<(const HeapNode &rhs) const { return d > rhs.d; }
};
void Dijkstra() {
  memset(vis, 0, sizeof(vis));
  for (int i = 0; i <= n; i++) {
    dis[i] = INF;
  }
  priority_queue<HeapNode> Q;
  for (int i = 1; i <= k; i++) {
    Q.push(HeapNode(i, 0));
    dis[i] = 0;
    belong[i] = i;
  }
  while (Q.size()) {
    HeapNode x = Q.top();
    Q.pop();
    int u = x.u;
    if (vis[u]) continue;
    vis[u] = 1;
    for (int i = 0; i < G[u].size(); i++) {
      Edge &e = edges[G[u][i]];
      if (dis[e.to] > dis[u] + e.cost) {
        dis[e.to] = dis[u] + e.cost;
        belong[e.to] = belong[u];
        Q.push(HeapNode(e.to, dis[e.to]));
      }
    }
  }
}
namespace MST {
vector<int> g[maxn];
vector<Edge> E;
const int POW = 20;
long long dis[maxn][POW + 2];
int fa[maxn][POW + 2];
int dep[maxn];
void add_edges(int u, int v, long long cost) {
  E.push_back(Edge(u, v, cost));
  E.push_back(Edge(v, u, cost));
  int sz = E.size();
  g[u].push_back(sz - 2);
  g[v].push_back(sz - 1);
}
void dfs(int u, int f) {
  for (int i = 0; i < g[u].size(); i++) {
    Edge &e = E[g[u][i]];
    int v = e.to;
    if (v == f) continue;
    dep[v] = dep[u] + 1;
    fa[v][0] = u;
    dis[v][0] = e.cost;
    dfs(v, u);
  }
}
void initLCA() {
  fa[1][0] = -1;
  dep[1] = 0;
  dfs(1, -1);
  for (int k = 0; k < POW; k++) {
    for (int v = 1; v <= n; v++) {
      if (fa[v][k] < 0)
        fa[v][k + 1] = -1;
      else
        fa[v][k + 1] = fa[fa[v][k]][k],
                  dis[v][k + 1] = max(dis[v][k], dis[fa[v][k]][k]);
    }
  }
}
long long query(int u, int v) {
  if (dep[u] > dep[v]) swap(u, v);
  long long re = -1;
  for (int k = 0; k < POW; k++) {
    if ((dep[v] - dep[u]) >> k & 1) re = max(re, dis[v][k]), v = fa[v][k];
  }
  if (u == v) return re;
  for (int k = POW - 1; k >= 0; k--) {
    if (fa[u][k] != fa[v][k]) {
      re = max(re, dis[v][k]), re = max(re, dis[u][k]);
      u = fa[u][k], v = fa[v][k];
    }
  }
  re = max(re, dis[u][0]);
  re = max(re, dis[v][0]);
  return re;
}
}  // namespace MST
namespace Graph {
int tot;
struct EEdge {
  int from, to;
  long long cost;
} edges[(signed)6e5 + 10];
int fa[maxn];
int find_set(int x) { return fa[x] == x ? fa[x] : fa[x] = find_set(fa[x]); }
void add_edges(int u, int v, long long cost) {
  edges[tot].from = u;
  edges[tot].to = v;
  edges[tot].cost = cost;
  tot++;
}
int cmp(const EEdge a, const EEdge b) { return a.cost < b.cost; }
void kruskal() {
  sort(edges, edges + tot, cmp);
  for (int i = 0; i < tot; i++) {
    EEdge &e = edges[i];
    int fx = find_set(e.from), fy = find_set(e.to);
    if (fx != fy) {
      if (fx > fy) {
        fa[fy] = fx;
      } else {
        fa[fx] = fy;
      }
      MST::add_edges(e.from, e.to, e.cost);
    }
  }
}
}  // namespace Graph
signed main() {
  scanf("%d%d%d%d", &n, &m, &k, &q);
  for (int i = 1; i <= m; i++) {
    int u, v;
    long long cost;
    scanf("%d%d%I64d", &u, &v, &cost);
    add_edges(u, v, cost);
  }
  Dijkstra();
  for (int u = 1; u <= n; u++) {
    for (int i = 0; i < G[u].size(); i++) {
      Edge &e = edges[G[u][i]];
      if (belong[u] != belong[e.to]) {
        Graph::add_edges(belong[u], belong[e.to], dis[u] + dis[e.to] + e.cost);
      }
    }
  }
  for (int i = 1; i <= n; i++) Graph::fa[i] = i;
  Graph::kruskal();
  MST::initLCA();
  while (q--) {
    int x, y;
    scanf("%d%d", &x, &y);
    printf("%I64d\n", MST::query(x, y));
  }
  return 0;
}
