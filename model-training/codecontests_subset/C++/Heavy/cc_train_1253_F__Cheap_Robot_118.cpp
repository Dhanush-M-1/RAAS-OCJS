#include <bits/stdc++.h>
using namespace std;
using ll = long long;
template <class T>
using V = vector<T>;
template <int NV>
class Dsu {
  vector<int> ancestor;

 public:
  Dsu() {
    ancestor.resize(NV);
    init();
  }
  inline void init(int n = NV) {
    iota(ancestor.begin(), next(ancestor.begin(), n), 0);
  }
  inline int find(int x) {
    if (x == ancestor[x]) return x;
    return ancestor[x] = find(ancestor[x]);
  }
  inline bool unite(int u, int v) {
    int a = find(u), b = find(v);
    if (a == b) return false;
    return (ancestor[b] = a), true;
  }
};
struct edge {
  int v;
  ll w;
};
Dsu<202020> D;
int n, m, k, q;
bool vis[202020];
V<edge> G[202020];
V<tuple<ll, int, int>> E;
int anc[202020][20], dep[202020];
ll dis[202020], weight[202020][20];
void dfs(int u, int f) {
  anc[u][0] = f;
  for (int i = 1; i < 20; i++) {
    anc[u][i] = anc[anc[u][i - 1]][i - 1];
    weight[u][i] = max(weight[u][i - 1], weight[anc[u][i - 1]][i - 1]);
  }
  for (auto& e : G[u]) {
    if (e.v != f) {
      dep[e.v] = dep[u] + 1;
      weight[e.v][0] = e.w;
      dfs(e.v, u);
    }
  }
}
ll getans(int x, int y) {
  ll ret = 0;
  if (dep[x] < dep[y]) swap(x, y);
  for (int i = 19; i >= 0; i--) {
    if (dep[anc[x][i]] >= dep[y]) {
      ret = max(ret, weight[x][i]);
      x = anc[x][i];
    }
  }
  if (x == y) return ret;
  for (int i = 19; i >= 0; i--) {
    if (anc[x][i] != anc[y][i]) {
      ret = max({ret, weight[x][i], weight[y][i]});
      x = anc[x][i], y = anc[y][i];
    }
  }
  return max({ret, weight[x][0], weight[y][0]});
}
int main() {
  ios::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr);
  cin >> n >> m >> k >> q;
  for (int i = 1; i <= m; i++) {
    int x, y, z;
    cin >> x >> y >> z;
    G[x].push_back({y, z}), G[y].push_back({x, z});
  }
  priority_queue<pair<ll, int>> Q;
  for (int i = 1; i <= n; i++) {
    if (i <= k) {
      dis[i] = 0, Q.push({0, i});
    } else {
      dis[i] = 1ll << 60;
    }
  }
  while (!Q.empty()) {
    int u = Q.top().second;
    Q.pop();
    if (vis[u]) {
      continue;
    }
    vis[u] = 1;
    for (auto& e : G[u]) {
      if (!vis[e.v] && dis[e.v] > dis[u] + e.w) {
        dis[e.v] = dis[u] + e.w;
        Q.push({-dis[e.v], e.v});
      }
    }
  }
  for (int u = 1; u <= n; u++) {
    for (auto& e : G[u]) {
      if (u < e.v) {
        E.push_back({dis[u] + dis[e.v] + e.w, u, e.v});
      }
    }
    G[u].clear();
  }
  sort(E.begin(), E.end());
  for (int i = 0; i < ((int)E.size()); i++) {
    ll z;
    int x, y;
    tie(z, x, y) = E[i];
    if (D.unite(x, y)) {
      G[x].push_back({y, z}), G[y].push_back({x, z});
    }
  }
  dfs(1, 0);
  while (q--) {
    int x, y;
    cin >> x >> y;
    cout << getans(x, y) << "\n";
  }
}
