#include <bits/stdc++.h>
using namespace std;
struct Edge {
  int u, v;
  long long w;
} e[300010];
struct Query {
  int a, b;
  long long ans;
  Query() { ans = -1; }
} q[300010];
struct data {
  int u;
  long long s;
  data(){};
  data(int a, long long b) { u = a, s = b; }
  bool operator<(const data &a) const { return s > a.s; }
};
int n, m, k, Q;
int fa[100010];
int cnt, head[100010], nxt[300010 << 1], to[300010 << 1], w[300010 << 1];
long long dis[100010];
vector<int> g[100010];
priority_queue<data> que;
void adde(int u, int v, int wi) {
  to[++cnt] = v;
  w[cnt] = wi;
  nxt[cnt] = head[u];
  head[u] = cnt;
}
void dijkstra() {
  memset(dis, 127, sizeof(dis));
  for (int i = 1; i <= k; i++) que.push(data(i, 0)), dis[i] = 0;
  while (!que.empty()) {
    data now = que.top();
    que.pop();
    for (int i = head[now.u]; i; i = nxt[i]) {
      int v = to[i];
      if (dis[now.u] + w[i] <= dis[v]) {
        dis[v] = dis[now.u] + w[i];
        que.push(data(v, dis[v]));
      }
    }
  }
}
bool cmp(Edge a, Edge b) { return a.w < b.w; }
int find(int x) { return x == fa[x] ? x : (fa[x] = find(fa[x])); }
int main() {
  scanf("%d%d%d%d", &n, &m, &k, &Q);
  for (int i = 1; i <= m; i++) {
    scanf("%d%d%lld", &e[i].u, &e[i].v, &e[i].w);
    adde(e[i].u, e[i].v, e[i].w), adde(e[i].v, e[i].u, e[i].w);
  }
  for (int i = 1; i <= Q; i++) {
    scanf("%d%d", &q[i].a, &q[i].b);
    g[q[i].a].push_back(i), g[q[i].b].push_back(i);
  }
  dijkstra();
  for (int i = 1; i <= m; i++) e[i].w = e[i].w + dis[e[i].u] + dis[e[i].v];
  sort(e + 1, e + m + 1, cmp);
  for (int i = 1; i <= n; i++) fa[i] = i;
  for (int i = 1; i <= m; i++) {
    int a = find(e[i].u), b = find(e[i].v);
    if (a != b) {
      if (g[b].size() < g[a].size()) swap(a, b);
      fa[a] = b;
      for (int j = 0, size = g[a].size(); j < size; j++) {
        int x = find(q[g[a][j]].a), y = find(q[g[a][j]].b);
        if (x == y) {
          if (q[g[a][j]].ans == -1) q[g[a][j]].ans = e[i].w;
        } else
          g[b].push_back(g[a][j]);
      }
    }
  }
  for (int i = 1; i <= Q; i++) printf("%lld\n", q[i].ans);
  return 0;
}
