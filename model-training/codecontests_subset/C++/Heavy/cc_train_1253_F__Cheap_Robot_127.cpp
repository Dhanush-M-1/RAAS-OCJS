#include <bits/stdc++.h>
const int N = 3e5 + 5;
struct Edge {
  int u;
  int v;
  long long w;
  int next;
  bool operator<(const Edge& other) const { return w < other.w; }
};
int head[N];
Edge e[2 * N];
struct Node {
  int u;
  long long w;
  Node(int u, long long w) : u(u), w(w) {}
  bool operator<(const Node& other) const { return w > other.w; }
};
long long dis[N];
int fix[N];
int p[N];
int Head[N];
Edge E[2 * N];
long long f[N][19 + 5];
long long w[N][19 + 5];
int Q[N];
void addEdge(int u, int v, long long w, int& size) {
  size++;
  e[size].u = u;
  e[size].v = v;
  e[size].w = w;
  e[size].next = head[u];
  head[u] = size;
}
void dijkstra(int n, int k) {
  std::priority_queue<Node> Q;
  for (int i = 1; i <= n; i++) {
    if (i > k)
      dis[i] = 1e18 + 7;
    else {
      dis[i] = 0;
      Q.push(Node(i, 0));
    }
  }
  while (Q.size()) {
    while (Q.size() && fix[Q.top().u]) Q.pop();
    if (!Q.size()) break;
    int u = Q.top().u;
    dis[u] = Q.top().w;
    fix[u] = 1;
    Q.pop();
    for (int i = head[u]; i; i = e[i].next) {
      int v = e[i].v;
      if (!fix[v] && dis[u] + e[i].w < dis[v]) {
        dis[v] = dis[u] + e[i].w;
        Q.push(Node(v, dis[v]));
      }
    }
  }
}
int find(int u) {
  if (p[u] == u)
    return u;
  else
    return p[u] = find(p[u]);
}
void buildTree(int u, int v, long long w, int& size) {
  size++;
  E[size].u = u, E[size].v = v;
  E[size].w = w;
  E[size].next = Head[u];
  Head[u] = size;
}
long long max(long long a, long long b) { return a > b ? a : b; }
long long lca(int x, int y) {
  if (fix[x] < fix[y]) {
    int t = x;
    x = y;
    y = t;
  }
  long long res = 0;
  for (int i = 17; i >= 0; i--) {
    if (f[x][i] && fix[f[x][i]] >= fix[y]) {
      res = max(res, w[x][i]);
      x = f[x][i];
    }
  }
  if (x == y) return res;
  for (int i = 17; i >= 0; i--) {
    if (f[x][i] != f[y][i]) {
      res = max(res, w[x][i]);
      res = max(res, w[y][i]);
      x = f[x][i], y = f[y][i];
    }
  }
  res = max(res, w[x][0]);
  res = max(res, w[y][0]);
  return res;
}
void initTree(int n, int s) {
  for (int i = 1; i <= n; i++) fix[i] = 0;
  int h = 0, t = -1;
  Q[++t] = s;
  fix[s] = 1;
  while (h <= t) {
    int u = Q[h++];
    for (int i = Head[u]; i; i = E[i].next) {
      int v = E[i].v;
      long long W = E[i].w;
      if (fix[v]) continue;
      fix[v] = fix[u] + 1;
      f[v][0] = u;
      w[v][0] = W;
      Q[++t] = v;
    }
  }
  for (int j = 1; j <= 17; j++) {
    for (int i = 1; i <= n; i++) {
      int middle = f[i][j - 1];
      if (!middle || !f[middle][j - 1]) continue;
      w[i][j] = max(w[i][j - 1], w[middle][j - 1]);
      f[i][j] = f[middle][j - 1];
    }
  }
}
int main() {
  int n, m, k, q;
  scanf("%d%d%d%d", &n, &m, &k, &q);
  int size = 0;
  for (int i = 0; i < m; i++) {
    int u, v;
    long long w;
    scanf("%d%d%lld", &u, &v, &w);
    addEdge(u, v, w, size);
    addEdge(v, u, w, size);
  }
  dijkstra(n, k);
  for (int i = 1; i <= size; i++) {
    int u = e[i].u, v = e[i].v;
    long long w = e[i].w;
    e[i].w = dis[u] + dis[v] + w;
  }
  std::sort(e + 1, e + size + 1);
  for (int i = 1; i <= n; i++) p[i] = i;
  int Size = 0;
  for (int i = 1; i <= size; i++) {
    if (Size == (2 * n - 2)) break;
    int x = find(e[i].u), y = find(e[i].v);
    if (x != y) {
      p[x] = y;
      buildTree(e[i].u, e[i].v, e[i].w, Size);
      buildTree(e[i].v, e[i].u, e[i].w, Size);
    }
  }
  initTree(n, 1);
  while (q--) {
    int u, v;
    scanf("%d%d", &u, &v);
    printf("%lld\n", lca(u, v));
  }
  return 0;
}
