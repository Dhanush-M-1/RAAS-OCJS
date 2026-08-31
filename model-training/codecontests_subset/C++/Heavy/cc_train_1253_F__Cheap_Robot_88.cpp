#include <bits/stdc++.h>
using namespace std;
const double pi = acos(-1);
const long long mod = 1e9 + 7;
inline long long read() {
  long long x = 0, f = 1;
  char ch = getchar();
  while (ch > '9' || ch < '0') {
    if (ch == '-') f = -1;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') {
    x = x * 10 + ch - '0';
    ch = getchar();
  }
  return x * f;
}
int n, m, k, q;
int inde[100005], tot;
long long dis[100005];
struct p {
  int u, v, w, nxt;
} e[600005 * 4];
void add(int u, int v, int w) { e[++tot] = {u, v, w, inde[u]}, inde[u] = tot; }
priority_queue<pair<long long, int>, vector<pair<long long, int>>,
               greater<pair<long long, int>>>
    Q;
bool vis[100005];
void bfs() {
  int i, v, u;
  Q.push({0, 0});
  while (!Q.empty()) {
    pair<long long, int> tp = Q.top();
    Q.pop();
    u = tp.second;
    if (dis[u] != tp.first) continue;
    for (i = inde[u]; i; i = e[i].nxt) {
      v = e[i].v;
      if (dis[v] > dis[u] + e[i].w) {
        dis[v] = dis[u] + e[i].w;
        Q.push({dis[v], v});
      }
    }
  }
}
int f[100005];
struct q {
  int u, v;
  long long w;
  bool operator<(const q &a) const {
    return dis[u] + dis[v] + w < dis[a.u] + dis[a.v] + a.w;
  }
} edge[600005];
int getf(int x) { return x == f[x] ? x : f[x] = getf(f[x]); }
struct pp {
  int u, v, id;
} qe[600005];
long long ans[600005];
vector<int> g[100005];
int main() {
  int i, j, u, v, w;
  n = read(), m = read(), k = read(), q = read();
  for (i = 1; i <= m; i++) {
    u = read(), v = read(), w = read();
    edge[i] = {u, v, w};
    add(u, v, w);
    add(v, u, w);
  }
  for (i = 1; i <= n; i++) dis[i] = 0x3f3f3f3f3f3f3f3f;
  for (i = 1; i <= k; i++) add(0, i, 0);
  bfs();
  tot = 0;
  for (i = 1; i <= n; i++) f[i] = i;
  for (i = 1; i <= q; i++) {
    u = read(), v = read();
    qe[i] = pp{u, v, i};
    g[u].push_back(i);
    g[v].push_back(i);
  }
  sort(edge + 1, edge + m + 1);
  for (i = 1; i <= m; i++) {
    u = edge[i].u, v = edge[i].v, w = edge[i].w;
    int f1 = getf(u), f2 = getf(v);
    if (f1 == f2) continue;
    if (g[f1].size() < g[f2].size()) swap(f1, f2);
    f[f2] = f1;
    for (j = 0; j < g[f2].size(); j++) {
      int x = qe[g[f2][j]].u, y = qe[g[f2][j]].v;
      if (getf(x) == getf(y)) {
        if (!ans[g[f2][j]]) ans[g[f2][j]] = edge[i].w + dis[u] + dis[v];
      } else
        g[f1].push_back(g[f2][j]);
    }
  }
  for (i = 1; i <= q; i++) printf("%lld\n", ans[i]);
  return 0;
}
