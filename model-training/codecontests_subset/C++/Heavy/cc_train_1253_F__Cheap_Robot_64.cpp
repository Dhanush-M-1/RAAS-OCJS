#include <bits/stdc++.h>
using namespace std;
using P = pair<int, long long>;
using LL = long long;
const int Maxn = 1e5 + 20, Maxm = (3e5 + 20) * 3;
const LL inf = 0x3f3f3f3f;
struct edge {
  int next, from, to;
  LL cost;
  bool operator<(const edge& val) const { return cost < val.cost; }
} es[Maxm];
int head[Maxn], cnt;
void addedge(int u, int v, LL w) {
  es[cnt].next = head[u];
  es[cnt].from = u;
  es[cnt].to = v;
  es[cnt].cost = w;
  head[u] = cnt++;
}
int n, m, k, q;
int last[Maxn];
LL dis[Maxn];
void dijkstra() {
  memset(dis, inf, sizeof(dis));
  priority_queue<P, vector<P>, greater<P>> que;
  for (int i = 1; i <= k; ++i) {
    dis[i] = 0;
    last[i] = i;
    que.push(P(0, i));
  }
  while (!que.empty()) {
    P tmp = que.top();
    que.pop();
    int u = tmp.second;
    if (dis[u] < tmp.first) continue;
    for (int i = head[u]; ~i; i = es[i].next) {
      int v = es[i].to;
      LL w = es[i].cost;
      if (dis[v] > dis[u] + w) {
        dis[v] = dis[u] + w;
        last[v] = last[u];
        que.push(P(dis[v], v));
      }
    }
  }
  for (int i = 0; i < cnt; ++i) {
    es[i].cost += dis[es[i].from] + dis[es[i].to];
    es[i].from = last[es[i].from];
    es[i].to = last[es[i].to];
  }
}
int Par[Maxn], Rank[Maxn];
int Find(int x) {
  if (Par[x] == -1) return x;
  return Par[x] = Find(Par[x]);
}
void Unite(int x, int y) {
  x = Find(x), y = Find(y);
  if (x == y) return;
  if (Rank[x] < Rank[y]) {
    Par[x] = y;
  } else {
    Par[y] = x;
    if (Rank[x] == Rank[y]) Rank[x]++;
  }
}
bool isSame(int x, int y) {
  if (Find(x) == Find(y)) return true;
  return false;
}
vector<P> vs[Maxn];
void Kruskal() {
  sort(es, es + cnt);
  int u, v;
  for (int i = 0; i < cnt; ++i) {
    int u = es[i].from, v = es[i].to;
    LL w = es[i].cost;
    if (!isSame(u, v)) {
      Unite(u, v);
      vs[u].push_back(P(v, w));
      vs[v].push_back(P(u, w));
    }
  }
}
int anc[Maxn][21], dep[Maxn];
LL cost[Maxn][21];
void preLCA(int u = 1, int fa = 0) {
  for (int i = 1; (1 << i) <= dep[u]; ++i) {
    anc[u][i] = anc[anc[u][i - 1]][i - 1];
    cost[u][i] = max(cost[u][i - 1], cost[anc[u][i - 1]][i - 1]);
  }
  for (auto tmp : vs[u]) {
    int v = tmp.first;
    if (v == fa) continue;
    dep[v] = dep[u] + 1;
    anc[v][0] = u;
    cost[v][0] = tmp.second;
    preLCA(v, u);
  }
}
int LCA(int a, int b) {
  if (dep[a] > dep[b]) swap(a, b);
  for (int i = 20; i >= 0; --i) {
    if (dep[a] <= dep[b] - (1 << i)) b = anc[b][i];
  }
  if (a == b) return a;
  for (int i = 20; i >= 0; --i) {
    if (anc[a][i] == anc[b][i])
      continue;
    else
      a = anc[a][i], b = anc[b][i];
  }
  return anc[b][0];
}
LL getMax(int u, int sta) {
  LL res = 0;
  for (int i = 0; i <= 20; ++i) {
    if (sta & (1 << i)) res = max(res, cost[u][i]), u = anc[u][i];
  }
  return res;
}
void init() {
  cnt = 0;
  memset(head, -1, sizeof(head));
  memset(Par, -1, sizeof(Par));
  memset(Rank, 0, sizeof(Rank));
  memset(anc, 0, sizeof(anc));
}
int main() {
  init();
  scanf("%d%d%d%d", &n, &m, &k, &q);
  int u, v;
  LL w;
  for (int i = 0; i < m; ++i) {
    scanf("%d%d%lld", &u, &v, &w);
    addedge(u, v, w);
    addedge(v, u, w);
  }
  dijkstra();
  Kruskal();
  preLCA();
  int x, y;
  int lca;
  while (q--) {
    scanf("%d%d", &x, &y);
    lca = LCA(x, y);
    printf("%lld\n",
           max(getMax(x, dep[x] - dep[lca]), getMax(y, dep[y] - dep[lca])));
  }
  return 0;
}
