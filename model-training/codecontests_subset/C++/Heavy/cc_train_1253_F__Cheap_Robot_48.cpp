#include <bits/stdc++.h>
using namespace std;
class edge {
 public:
  int u, v;
  long long w;
  edge() {}
  edge(int u, int v, long long w) : u(u), v(v), w(w) {}
  bool operator<(const edge& other) const { return w < other.w; }
};
class node {
 public:
  int n;
  long long w;
  node() {}
  node(int n, long long w) : n(n), w(w) {}
  bool operator<(const node& other) const { return other.w < w; }
};
const int MAXN = 3e5;
const int LOG = 19;
vector<edge> g[MAXN + 10];
long long D[MAXN + 10];
int n, m, k, q;
edge E[MAXN + 10];
int P[MAXN + 10];
int find(int x) {
  if (x == P[x]) return x;
  return P[x] = find(P[x]);
}
void join(int x, int y) { P[find(x)] = find(y); }
void dijkstra() {
  priority_queue<node> pq;
  for (int i = 1; i <= k; i++) {
    pq.push(node(i, 0LL));
    D[i] = 0;
  }
  for (int i = k + 1; i <= n; i++) D[i] = LLONG_MAX;
  while (!pq.empty()) {
    node aux = pq.top();
    pq.pop();
    int cur = aux.n;
    long long w = aux.w;
    for (int i = 0; i < (int)g[cur].size(); i++) {
      int next = g[cur][i].v;
      long long nw = w + g[cur][i].w;
      if (D[next] <= nw) continue;
      D[next] = nw;
      pq.push(node(next, nw));
    }
  }
}
int p[LOG][MAXN + 10];
int d[MAXN + 10];
long long M[LOG][MAXN + 10];
void dfs(int cur, int prev, int depth = 0, long long w = 0) {
  p[0][cur] = prev;
  M[0][cur] = w;
  d[cur] = depth;
  for (int i = 0; i < (int)g[cur].size(); i++) {
    int next = g[cur][i].v;
    if (next == prev) continue;
    dfs(next, cur, depth + 1, g[cur][i].w);
  }
}
void pre() {
  for (int i = 1; i < LOG; i++) {
    for (int j = 1; j <= n; j++) {
      p[i][j] = p[i - 1][p[i - 1][j]];
      M[i][j] = max(M[i - 1][j], M[i - 1][p[i - 1][j]]);
    }
  }
}
long long query(int u, int v) {
  long long worst = 0;
  if (d[u] > d[v]) swap(u, v);
  int logi;
  for (logi = 0; (1 << logi) <= d[v]; logi++)
    ;
  logi--;
  for (int i = logi; i >= 0; i--) {
    if (d[v] - (1 << i) >= d[u]) {
      worst = max(worst, M[i][v]);
      v = p[i][v];
    }
  }
  if (u == v) return worst;
  for (int i = logi; i >= 0; i--) {
    if (p[i][u] != p[i][v]) {
      worst = max(worst, max(M[i][u], M[i][v]));
      u = p[i][u];
      v = p[i][v];
    }
  }
  worst = max(worst, max(M[0][u], M[0][v]));
  return worst;
}
int main() {
  scanf("%d %d %d %d", &n, &m, &k, &q);
  for (int i = 0; i < m; i++) {
    int u, v;
    long long w;
    scanf("%d %d %lld", &u, &v, &w);
    E[i] = edge(u, v, w);
    g[u].push_back(edge(u, v, w));
    g[v].push_back(edge(v, u, w));
  }
  dijkstra();
  for (int i = 0; i < m; i++) {
    int u = E[i].u, v = E[i].v;
    E[i].w += D[u] + D[v];
  }
  sort(E, E + m);
  for (int i = 1; i <= m; i++) g[i].clear();
  for (int i = 1; i <= n; i++) P[i] = i;
  for (int i = 0; i < m; i++) {
    int u = E[i].u, v = E[i].v;
    if (find(u) == find(v)) continue;
    join(u, v);
    g[u].push_back(edge(u, v, E[i].w));
    g[v].push_back(edge(v, u, E[i].w));
  }
  dfs(1, 1);
  pre();
  for (int i = 0; i < q; i++) {
    int u, v;
    scanf("%d %d", &u, &v);
    printf("%lld\n", query(u, v));
  }
  return 0;
}
