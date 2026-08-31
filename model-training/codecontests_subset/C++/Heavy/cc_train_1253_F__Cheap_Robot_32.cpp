#include <bits/stdc++.h>
using namespace std;
inline long long read() {
  long long x = 0, f = 1;
  char ch = getchar();
  while (!isdigit(ch)) {
    if (ch == '-') f = -1;
    char ch = getchar();
  }
  while (isdigit(ch)) {
    x = (x << 1) + (x << 3) + ch - '0';
    ch = getchar();
  }
  return x * f;
}
struct edge {
  int to, nxt, from;
  long long dis;
} g[1010101];
int head[1010101], tot, n, m, K, Q;
inline void made(int from, int to, long long dis) {
  g[++tot].to = to;
  g[tot].nxt = head[from];
  head[from] = tot;
  g[tot].dis = dis;
  g[tot].from = from;
}
int F[1010101], sz[1010101];
long long dis[1010101];
int find(int u) {
  if (F[u] != u) F[u] = find(F[u]);
  return F[u];
}
struct que {
  int x, y;
  int id;
} q[1010101];
long long ans[1010101];
vector<que> G[1010101];
inline bool cmp(edge a, edge b) { return a.dis < b.dis; }
long long NOW;
bool vis[1010101];
int main() {
  n = read(), m = read(), K = read(), Q = read();
  for (int i = 1; i <= m; i++) {
    int x = read(), y = read();
    long long z = read();
    made(x, y, z);
    made(y, x, z);
  }
  for (int i = 1; i <= n; i++) {
    F[i] = i;
    sz[i] = 1;
  }
  priority_queue<pair<long long, int> > dl;
  memset(dis, 0x3f, sizeof dis);
  while (!dl.empty()) dl.pop();
  for (int i = 1; i <= K; i++) dis[i] = 0, dl.push(make_pair(0, i));
  while (!dl.empty()) {
    int u = dl.top().second;
    dl.pop();
    if (vis[u]) continue;
    vis[u] = 1;
    for (int i = head[u]; i; i = g[i].nxt) {
      int v = g[i].to;
      if (dis[v] > dis[u] + g[i].dis) {
        dis[v] = dis[u] + g[i].dis;
        if (!vis[v]) {
          dl.push(make_pair(-dis[v], v));
        }
      }
    }
  }
  for (int i = 1; i <= tot; i++) {
    g[i].dis = g[i].dis + dis[g[i].from] + dis[g[i].to];
  }
  sort(g + 1, g + 1 + tot, cmp);
  for (int i = 1; i <= Q; i++) {
    q[i].id = i;
    q[i].x = read(), q[i].y = read();
    G[q[i].x].push_back(q[i]);
    G[q[i].y].push_back(q[i]);
  }
  for (int i = 1; i <= tot; i++) {
    int u = g[i].from, v = g[i].to;
    NOW = g[i].dis;
    int fu = find(u), fv = find(v);
    if (fu != fv) {
      if (sz[fu] < sz[fv]) {
        swap(fu, fv);
        swap(u, v);
      }
      sz[fu] += sz[fv];
      F[fv] = fu;
      for (auto now : G[fv]) {
        if (find(now.x) == find(now.y)) {
          if (!ans[now.id]) {
            ans[now.id] = NOW;
          }
        } else {
          G[fu].push_back(now);
        }
      }
    }
  }
  for (int i = 1; i <= Q; i++) {
    cout << ans[i] << endl;
  }
  return 0;
}
