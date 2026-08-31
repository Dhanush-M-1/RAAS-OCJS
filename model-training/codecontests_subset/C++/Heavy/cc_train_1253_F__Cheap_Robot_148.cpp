#include <bits/stdc++.h>
using namespace std;
const long long INF = 8e18 + 5;
const int maxn = 1e5 + 5;
const int maxm = 3e5 + 5;
struct edge {
  int v, nex, w;
} e[maxm << 1];
int n, m, k, Q, tot;
int head[maxn], par[maxn], deep[maxn], fa[maxn][21];
long long dis[maxn], va[maxn][21];
;
vector<pair<long long, int> > E[maxn];
bool vis[maxn];
int find(int x) { return par[x] == x ? x : par[x] = find(par[x]); }
void add(int u, int v, int w) {
  e[++tot] = {v, head[u], w}, head[u] = tot;
  e[++tot] = {u, head[v], w}, head[v] = tot;
}
void dfs(int u, int gg, long long d) {
  par[u] = gg;
  for (int i = head[u]; i; i = e[i].nex) {
    int v = e[i].v, w = e[i].w;
    long long now = d + w;
    if (now == dis[v]) dfs(v, gg, now);
  }
}
void getdeep(int u, int pre, int d) {
  deep[u] = d;
  for (auto &v : E[u])
    if (v.second != pre) {
      fa[v.second][0] = u, va[v.second][0] = v.first;
      getdeep(v.second, u, d + 1);
    }
}
void LCAinit() {
  getdeep(1, 0, 0);
  for (int i = 1; i <= 20; ++i) {
    for (int j = 1; j <= k; ++j) {
      if (deep[j] - (1 << i) < 0) continue;
      fa[j][i] = fa[fa[j][i - 1]][i - 1];
      va[j][i] = max(va[j][i - 1], va[fa[j][i - 1]][i - 1]);
    }
  }
}
long long query(int x, int y) {
  long long res = 0;
  if (deep[x] < deep[y]) swap(x, y);
  for (int k = 0; k < 21; ++k) {
    if (deep[x] - deep[y] >> k & 1) res = max(res, va[x][k]), x = fa[x][k];
  }
  if (x == y) return res;
  for (int k = 20; k >= 0; --k) {
    if (fa[x][k] != fa[y][k]) {
      res = max({res, va[x][k], va[y][k]});
      x = fa[x][k], y = fa[y][k];
    }
  }
  res = max({res, va[x][0], va[y][0]});
  return res;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cin >> n >> m >> k >> Q;
  for (int i = 1; i <= n; ++i) dis[i] = INF;
  for (int i = 0; i < m; ++i) {
    int u, v, w;
    cin >> u >> v >> w;
    add(u, v, w);
  }
  for (int i = 1; i <= n; ++i) par[i] = i;
  priority_queue<pair<long long, int> > q;
  for (int i = 1; i <= k; ++i) q.push({0, i}), dis[i] = 0;
  while (!q.empty()) {
    auto now = q.top();
    q.pop();
    int u = now.second;
    if (vis[u]) continue;
    vis[u] = 1;
    for (int i = head[u]; i; i = e[i].nex) {
      int v = e[i].v, w = e[i].w;
      if (!vis[v] && dis[v] > w - now.first) {
        dis[v] = w - now.first;
        q.push({-w + now.first, v});
      }
    }
  }
  for (int i = 1; i <= k; ++i) dfs(i, i, 0);
  vector<pair<long long, pair<int, int> > > a;
  for (int u = 1; u <= n; ++u) {
    for (int i = head[u]; i; i = e[i].nex) {
      int v = e[i].v;
      if (par[v] != par[u]) {
        a.push_back({dis[u] + dis[v] + e[i].w, {par[u], par[v]}});
      }
    }
  }
  sort(a.begin(), a.end());
  for (auto &x : a) {
    int u = x.second.first, v = x.second.second;
    u = find(u), v = find(v);
    if (u == v) continue;
    par[u] = par[v];
    E[u].push_back({x.first, v});
    E[v].push_back({x.first, u});
  }
  LCAinit();
  while (Q--) {
    int x, y;
    cin >> x >> y;
    cout << query(x, y) << '\n';
  }
  return 0;
}
