#include <bits/stdc++.h>
using namespace std;
inline int read() {
  char c = getchar();
  int x = 0, f = 1;
  while (c < '0' || c > '9') {
    if (c == '-') f = -1;
    c = getchar();
  }
  while (c >= '0' && c <= '9') {
    x = x * 10 + c - '0';
    c = getchar();
  }
  return x * f;
}
const int maxn = 1e5 + 10;
const long long inf = (long long)1e15;
int n, m, k, q;
struct enode {
  int v, nxt;
  long long w;
} edge[maxn * 6];
struct dnode {
  int u, v;
  long long w;
} a[maxn * 3];
bool cmp(dnode& a, dnode& b) { return a.w < b.w; }
int head[maxn], tot;
void add(int u, int v, long long w) {
  edge[++tot].v = v;
  edge[tot].w = w;
  edge[tot].nxt = head[u];
  head[u] = tot;
}
long long dis[maxn];
int fro[maxn];
bool vis[maxn];
void dijkstra() {
  priority_queue<pair<long long, int> > pq;
  for (int i = 1; i <= k; ++i) {
    dis[i] = 0;
    fro[i] = i;
    pq.push(make_pair(0, i));
  }
  for (int i = k + 1; i <= n; ++i) dis[i] = inf;
  while (!pq.empty()) {
    int u = pq.top().second;
    pq.pop();
    if (vis[u]) continue;
    vis[u] = true;
    for (int i = head[u]; i; i = edge[i].nxt) {
      int v = edge[i].v, w = edge[i].w;
      if (dis[u] + w < dis[v]) {
        dis[v] = dis[u] + w;
        fro[v] = fro[u];
        pq.push(make_pair(-dis[v], v));
      }
    }
  }
}
int fa[maxn];
int sz[maxn];
long long val[maxn];
int find(int x) {
  if (x == fa[x]) return x;
  return find(fa[x]);
}
long long query(int u, int v) {
  long long ans = 0;
  while (u != v) {
    if (sz[u] > sz[v]) swap(u, v);
    ans = max(ans, val[u]);
    u = fa[u];
  }
  return ans;
}
int main() {
  n = read(), m = read(), k = read(), q = read();
  for (int i = 0; i < m; ++i) {
    int u = read(), v = read();
    long long w;
    scanf("%lld", &w);
    add(u, v, w);
    add(v, u, w);
  }
  dijkstra();
  for (int i = 1; i <= m; ++i) {
    a[i].u = fro[edge[i * 2 - 1].v];
    a[i].v = fro[edge[i * 2].v];
    a[i].w = dis[edge[i * 2 - 1].v] + dis[edge[i * 2].v] + edge[i * 2].w;
  }
  sort(a + 1, a + 1 + m, cmp);
  for (int i = 1; i <= n; ++i) {
    sz[i] = 1;
    fa[i] = i;
  }
  for (int i = 1; i <= m; ++i) {
    int u = find(a[i].u), v = find(a[i].v);
    if (u == v) continue;
    if (sz[u] > sz[v]) swap(u, v);
    fa[u] = fa[v];
    sz[v] += sz[u];
    val[u] = a[i].w;
  }
  while (q--) {
    int u = read(), v = read();
    printf("%lld\n", query(u, v));
  }
  return 0;
}
