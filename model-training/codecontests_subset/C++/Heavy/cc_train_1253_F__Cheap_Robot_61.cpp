#include <bits/stdc++.h>
using namespace std;
const int maxn = 3e5;
int n, m, k, q;
struct node {
  int v;
  int nxt;
  long long w;
  node() {}
  node(int v, long long w) : v(v), w(w) {}
} edge[maxn * 2 + 10];
struct Node {
  int u;
  int v;
  long long w;
  Node() {}
  Node(int u, int v, long long w) : u(u), v(v), w(w) {}
  bool operator<(const Node &C) const { return w > C.w; }
};
int head[maxn + 10];
bool vis[maxn + 10];
vector<Node> ve[maxn + 10];
priority_queue<Node> Q, P;
int fa[maxn + 10];
int tot;
int f[maxn + 10][25];
long long dis[maxn + 10][25];
int dep[maxn + 10];
long long d[maxn + 10];
void init() {
  tot = 0;
  memset(vis, false, sizeof(vis));
  memset(head, -1, sizeof(head));
  for (int i = 0; i <= n; i++) ve[i].clear();
  while (!Q.empty()) {
    Q.pop();
  }
  while (!P.empty()) {
    P.pop();
  }
  for (int i = 0; i <= n; i++) fa[i] = i;
  memset(dis, 0, sizeof(dis));
  memset(d, 0, sizeof(d));
}
int cha(int u) {
  if (fa[u] != u) {
    fa[u] = cha(fa[u]);
  }
  return fa[u];
}
void addedge(int u, int v, long long w) {
  edge[tot].v = v;
  edge[tot].w = w;
  edge[tot].nxt = head[u];
  head[u] = tot++;
  edge[tot].v = u;
  edge[tot].w = w;
  edge[tot].nxt = head[v];
  head[v] = tot++;
}
void dfs(int u, int pre) {
  dep[u] = dep[pre] + 1;
  f[u][0] = pre;
  for (int i = 1; i <= 20; i++) {
    f[u][i] = f[f[u][i - 1]][i - 1];
    dis[u][i] = max(dis[f[u][i - 1]][i - 1], dis[u][i - 1]);
  }
  for (int i = head[u]; i != -1; i = edge[i].nxt) {
    int v = edge[i].v;
    if (v == pre) continue;
    dep[v] = dep[u] + 1;
    f[v][0] = u;
    dis[v][0] = edge[i].w;
    dfs(v, u);
  }
}
long long lca(int x, int y) {
  if (dep[x] < dep[y]) swap(x, y);
  long long ans = 0;
  for (int i = 20; i >= 0; i--) {
    if (dep[f[x][i]] >= dep[y]) {
      ans = max(ans, dis[x][i]);
      x = f[x][i];
    }
    if (x == y) return ans;
  }
  for (int i = 20; i >= 0; i--) {
    if (f[x][i] != f[y][i]) {
      ans = max(ans, dis[x][i]);
      ans = max(ans, dis[y][i]);
      x = f[x][i];
      y = f[y][i];
    }
  }
  if (x != y) {
    ans = max(ans, dis[x][0]);
    ans = max(ans, dis[y][0]);
  }
  return ans;
}
int main() {
  while (~scanf("%d%d%d%d", &n, &m, &k, &q)) {
    init();
    for (int i = 0; i < m; i++) {
      int u, v;
      long long w;
      scanf("%d%d%lld", &u, &v, &w);
      u--, v--;
      ve[u].push_back(Node(u, v, w));
      ve[v].push_back(Node(v, u, w));
    }
    for (int i = 0; i < k; i++) {
      vis[i] = true;
      d[i] = 0;
      for (int j = 0; j < ve[i].size(); j++) {
        Q.push(Node(ve[i][j].u, ve[i][j].v, ve[i][j].w));
      }
    }
    while (!Q.empty()) {
      Node tmp = Q.top();
      Q.pop();
      int uu = cha(tmp.u);
      int vv = cha(tmp.v);
      if (uu == vv) continue;
      if (vis[tmp.v]) {
        P.push(Node(tmp.u, tmp.v, tmp.w + d[tmp.v]));
        continue;
      }
      fa[uu] = vv;
      addedge(tmp.u, tmp.v, tmp.w);
      vis[tmp.v] = true;
      d[tmp.v] = tmp.w;
      int v = tmp.v;
      for (int i = 0; i < ve[v].size(); i++) {
        Q.push(Node(v, ve[v][i].v, ve[v][i].w + tmp.w));
      }
    }
    while (!P.empty()) {
      Node tmp = P.top();
      P.pop();
      int uu = cha(tmp.u);
      int vv = cha(tmp.v);
      if (uu == vv) continue;
      int v = tmp.v;
      addedge(tmp.u, tmp.v, tmp.w);
      fa[uu] = vv;
    }
    dfs(0, 0);
    for (int i = 0; i < q; i++) {
      int u, v;
      scanf("%d%d", &u, &v);
      u--, v--;
      printf("%lld\n", lca(u, v));
    }
  }
  return 0;
}
