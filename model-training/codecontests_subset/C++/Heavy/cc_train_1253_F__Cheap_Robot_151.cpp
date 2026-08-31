#include <bits/stdc++.h>
using namespace std;
const long long M = 6e5 + 10;
const long long N = 4e5 + 10;
long long read() {
  long long x = 0, f = 1;
  char c = getchar();
  while (c < '0' || c > '9') {
    if (c == '-') f = -1;
    c = getchar();
  }
  while (c >= '0' && c <= '9') {
    x = x * 10 + c - '0';
    c = getchar();
  }
  return f * x;
}
long long n, m, k, t;
struct edge {
  long long u, v, w, nxt;
} e[M << 1], E[M << 1], E2[M << 1];
long long head[M], cnt1;
long long Head[M], cnt2;
struct node {
  long long num, val;
  bool operator<(const node &b) const { return val > b.val; }
};
long long fa[N], dis[N], vis[N];
bool cmp(edge x, edge y) { return x.w < y.w; }
void add_edge(long long u, long long v, long long w) {
  e[++cnt1] = (edge){u, v, w, head[u]}, head[u] = cnt1;
}
void Add_edge(long long u, long long v, long long w) {
  E2[++cnt2] = (edge){u, v, w, Head[u]}, Head[u] = cnt2;
}
long long find(long long x) { return fa[x] == x ? x : fa[x] = find(fa[x]); }
priority_queue<node> q;
void dij() {
  memset(dis, 0x3f, sizeof dis);
  dis[0] = 0;
  q.push((node){0, 0});
  while (!q.empty()) {
    node u = q.top();
    q.pop();
    if (vis[u.num]) continue;
    vis[u.num] = true;
    for (long long i = head[u.num]; i; i = e[i].nxt) {
      long long v = e[i].v;
      if (dis[v] > dis[u.num] + e[i].w) {
        dis[v] = dis[u.num] + e[i].w;
        if (!vis[v]) q.push((node){v, dis[v]});
      }
    }
  }
}
long long cnt;
void kruskal() {
  for (long long i = 1; i <= n; ++i) fa[i] = i;
  for (long long i = 1; i <= m; ++i) {
    long long uf = find(E[i].u), vf = find(E[i].v);
    if (uf != vf) {
      fa[vf] = uf;
      Add_edge(E[i].u, E[i].v, E[i].w), Add_edge(E[i].v, E[i].u, E[i].w);
      cnt++;
      if (cnt == n - 1) return;
    }
  }
}
long long f[N][22], dep[N], maxm[N][22];
void dfs(long long u, long long fa) {
  f[u][0] = fa;
  for (long long i = Head[u]; i; i = E2[i].nxt) {
    long long v = E2[i].v;
    if (v == fa) continue;
    dep[v] = dep[u] + 1;
    maxm[v][0] = E2[i].w;
    dfs(v, u);
  }
}
void init() {
  for (long long i = 1; i <= 20; ++i) {
    for (long long j = 1; j <= n; ++j) {
      f[j][i] = f[f[j][i - 1]][i - 1];
      maxm[j][i] = max(maxm[j][i - 1], maxm[f[j][i - 1]][i - 1]);
    }
  }
}
long long get_max(long long x, long long y) {
  long long ans = 0;
  if (dep[x] < dep[y]) swap(x, y);
  for (long long i = 20; i >= 0; --i) {
    if (dep[f[x][i]] < dep[y]) continue;
    ans = max(ans, maxm[x][i]);
    x = f[x][i];
  }
  if (x == y) return ans;
  for (long long i = 20; i >= 0; --i) {
    if (f[x][i] == f[y][i]) continue;
    ans = max(ans, max(maxm[x][i], maxm[y][i]));
    x = f[x][i];
    y = f[y][i];
  }
  ans = max(ans, max(maxm[x][0], maxm[y][0]));
  return ans;
}
signed main() {
  n = read(), m = read(), k = read(), t = read();
  for (long long i = 1, u, v, w; i <= m; ++i) {
    u = read(), v = read(), w = read();
    add_edge(u, v, w), add_edge(v, u, w);
    E[i].u = u, E[i].v = v, E[i].w = w;
  }
  for (long long i = 1; i <= k; ++i) add_edge(0, i, 0), add_edge(i, 0, 0);
  dij();
  for (long long i = 1; i <= m; ++i) E[i].w += dis[E[i].u] + dis[E[i].v];
  sort(E + 1, E + m + 1, cmp);
  kruskal();
  dep[1] = 1;
  dfs(1, -1);
  init();
  for (long long i = 1, u, v; i <= t; ++i) {
    u = read(), v = read();
    cout << get_max(u, v) << endl;
  }
  return 0;
}
