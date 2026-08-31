#include <bits/stdc++.h>
using namespace std;
const long long MAXN = 4e5 + 5;
const long long MAXM = 6e5 + 5;
const long long INF = 1e9 + 7;
const long long mod = 1e9 + 7;
struct edge {
  long long from, to, w, nxt;
} e[MAXM << 2], E[MAXM], E2[MAXM << 1];
long long head[MAXN], num_edge = 0;
long long Head[MAXN], Num_edge = 0;
struct node {
  long long bh, val;
  bool operator<(const node &b) const { return val > b.val; }
};
long long n, m, k, Q, cnt;
long long dis[MAXN], fa[MAXN], f[MAXN][22], dep[MAXN], maxm[MAXN][22];
bool vis[MAXN];
priority_queue<node> q;
long long read() {
  long long s = 0, f = 0;
  char ch = getchar();
  while (!isdigit(ch)) f |= (ch == '-'), ch = getchar();
  while (isdigit(ch)) s = (s << 1) + (s << 3) + ch - '0', ch = getchar();
  return f ? -s : s;
}
bool cmp(edge x, edge y) { return x.w < y.w; }
void add_edge(long long from, long long to, long long w) {
  e[++num_edge] = (edge){from, to, w, head[from]}, head[from] = num_edge;
}
void Add_edge(long long from, long long to, long long w) {
  E2[++Num_edge] = (edge){from, to, w, Head[from]}, Head[from] = Num_edge;
}
long long find(long long x) { return fa[x] == x ? x : fa[x] = find(fa[x]); }
void dij() {
  memset(dis, 0x3f, sizeof dis);
  dis[0] = 0;
  q.push((node){0, 0});
  while (!q.empty()) {
    node u = q.top();
    q.pop();
    if (vis[u.bh]) continue;
    vis[u.bh] = true;
    for (long long i = head[u.bh]; i; i = e[i].nxt) {
      long long v = e[i].to;
      if (dis[v] > dis[u.bh] + e[i].w) {
        dis[v] = dis[u.bh] + e[i].w;
        if (!vis[v]) q.push((node){v, dis[v]});
      }
    }
  }
}
void kruskal() {
  for (long long i = 1; i <= n; ++i) fa[i] = i;
  for (long long i = 1; i <= m; ++i) {
    long long uf = find(E[i].from), vf = find(E[i].to);
    if (uf != vf) {
      fa[vf] = uf;
      Add_edge(E[i].from, E[i].to, E[i].w),
          Add_edge(E[i].to, E[i].from, E[i].w);
      cnt++;
      if (cnt == n - 1) return;
    }
  }
}
void dfs(long long u, long long fa) {
  f[u][0] = fa;
  for (long long i = Head[u]; i; i = E2[i].nxt) {
    long long v = E2[i].to;
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
  n = read(), m = read(), k = read(), Q = read();
  for (long long i = 1, u, v, w; i <= m; ++i) {
    u = read(), v = read(), w = read();
    add_edge(u, v, w), add_edge(v, u, w);
    E[i].from = u, E[i].to = v, E[i].w = w;
  }
  for (long long i = 1; i <= k; ++i) {
    add_edge(0, i, 0), add_edge(i, 0, 0);
  }
  dij();
  for (long long i = 1; i <= m; ++i) {
    E[i].w += dis[E[i].from] + dis[E[i].to];
  }
  sort(E + 1, E + m + 1, cmp);
  kruskal();
  dep[1] = 1;
  dfs(1, -1);
  init();
  for (long long i = 1, u, v; i <= Q; ++i) {
    u = read(), v = read();
    cout << get_max(u, v) << endl;
  }
  return 0;
}
