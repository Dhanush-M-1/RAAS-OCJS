#include <bits/stdc++.h>
using namespace std;
const int maxn = 600005;
long long n, m, k, q;
struct Edge {
  int u, v;
  long long c;
  bool operator<(const Edge x) const { return c < x.c; }
} e[maxn];
struct Node {
  int v;
  long long c;
  Node *next;
} * h[maxn], pool[maxn];
int tot;
void addEdge(int u, int v, long long c) {
  Node *p = &pool[++tot];
  p->v = v;
  p->c = c;
  p->next = h[u];
  h[u] = p;
}
struct Que {
  int v;
  long long dis;
  bool operator<(const Que a) const { return a.dis < dis; }
};
priority_queue<Que> pq;
void push(int v, long long dis) {
  Que temp;
  temp.v = v;
  temp.dis = dis;
  pq.push(temp);
}
long long vis[maxn], dis[maxn];
void dij() {
  memset(dis, 0x3f, sizeof(dis));
  for (int i = 1; i <= k; i++) {
    dis[i] = 0;
    push(i, 0);
  }
  while (!pq.empty()) {
    int u = pq.top().v;
    pq.pop();
    if (vis[u] == 1) continue;
    vis[u] = 1;
    for (Node *p = h[u]; p; p = p->next) {
      if (dis[p->v] > dis[u] + p->c) {
        dis[p->v] = dis[u] + p->c;
        if (vis[p->v] == 0) push(p->v, dis[p->v]);
      }
    }
  }
}
int fa[maxn];
int getfather(int x) {
  if (fa[x] == x)
    return x;
  else
    return fa[x] = getfather(fa[x]);
}
void Merge(int x, int y) {
  int fx = getfather(x);
  int fy = getfather(y);
  if (fx == fy) return;
  fa[fx] = fy;
}
long long f[maxn][25], b[maxn][25];
int dep[maxn];
void dfs(int u, int fa) {
  for (Node *p = h[u]; p; p = p->next) {
    if (p->v == fa) continue;
    f[p->v][0] = u;
    b[p->v][0] = p->c;
    dep[p->v] = dep[u] + 1;
    dfs(p->v, u);
  }
}
long long query(int u, int v) {
  long long ans = 0;
  if (dep[u] < dep[v]) swap(u, v);
  int t = dep[u] - dep[v];
  for (int i = 0; i < 24; i++) {
    if ((1 << i) & t) {
      ans = max(ans, b[u][i]);
      u = f[u][i];
    }
  }
  if (u == v) return ans;
  for (int i = 23; i >= 0; i--) {
    if (f[u][i] != f[v][i]) {
      ans = max(ans, max(b[u][i], b[v][i]));
      u = f[u][i];
      v = f[v][i];
    }
  }
  return max(ans, max(b[v][0], b[u][0]));
}
int main() {
  memset(f, -1, sizeof(f));
  cin >> n >> m >> k >> q;
  int x, y, z;
  for (int i = 1; i <= m; i++) {
    scanf("%d %d %d", &e[i].u, &e[i].v, &e[i].c);
    addEdge(e[i].u, e[i].v, e[i].c);
    addEdge(e[i].v, e[i].u, e[i].c);
  }
  dij();
  for (int i = 1; i <= m; i++) {
    e[i].c = e[i].c + dis[e[i].u] + dis[e[i].v];
  }
  sort(e + 1, e + m + 1);
  int tc = 0;
  memset(h, NULL, sizeof(h));
  tot = 0;
  for (int i = 1; i <= n; i++) fa[i] = i;
  for (int i = 1; i <= m; i++) {
    if (getfather(e[i].u) != getfather(e[i].v)) {
      Merge(e[i].u, e[i].v);
      addEdge(e[i].u, e[i].v, e[i].c);
      addEdge(e[i].v, e[i].u, e[i].c);
      tc++;
      if (tc == n - 1) break;
    }
  }
  dfs(1, -1);
  for (int i = 1; i <= 23; i++) {
    for (int j = 1; j <= n; j++) {
      if (f[j][i - 1] != -1) {
        f[j][i] = f[f[j][i - 1]][i - 1];
        b[j][i] = max(b[j][i - 1], b[f[j][i - 1]][i - 1]);
      }
    }
  }
  for (int i = 1; i <= q; i++) {
    scanf("%d %d", &x, &y);
    printf("%lld\n", query(x, y));
  }
  return 0;
}
