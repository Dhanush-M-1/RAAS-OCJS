#include <bits/stdc++.h>
using namespace std;
using LL = long long;
using PLI = pair<LL, int>;
const LL INF = 1e18;
class DSU {
  vector<int> par;
  int find(int u) {
    if (u == par[u]) return u;
    return par[u] = find(par[u]);
  }

 public:
  DSU(int n) : par(n) { iota(par.begin(), par.end(), 0); }
  bool merge(int u, int v) {
    u = find(u), v = find(v);
    if (u == v) return false;
    par[v] = u;
    return true;
  }
};
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n, m, k, q;
  cin >> n >> m >> k >> q;
  vector<vector<PLI>> adj(n);
  vector<tuple<LL, int, int>> edges;
  for (int i = 0; i < m; i++) {
    int u, v, w;
    cin >> u >> v >> w;
    u--, v--;
    edges.emplace_back(w, u, v);
    adj[u].emplace_back(w, v);
    adj[v].emplace_back(w, u);
  }
  vector<LL> dis(n, INF);
  vector<bool> done(n, false);
  vector<int> par(n, -1);
  priority_queue<PLI> heap;
  for (int u = 0; u < k; u++) {
    dis[u] = 0;
    par[u] = u;
    heap.emplace(0, u);
  }
  while (!heap.empty()) {
    int u = heap.top().second;
    heap.pop();
    if (done[u]) continue;
    done[u] = true;
    for (auto [w, v] : adj[u]) {
      if (dis[v] > dis[u] + w) {
        dis[v] = dis[u] + w;
        par[v] = par[u];
        heap.emplace(-dis[v], v);
      }
    }
  }
  vector<tuple<LL, int, int>> sub_edges;
  for (auto [w, u, v] : edges) {
    if (par[u] != par[v]) {
      sub_edges.emplace_back(dis[u] + dis[v] + w, par[u], par[v]);
    }
  }
  sort(sub_edges.begin(), sub_edges.end());
  vector<vector<PLI>> tree(k);
  DSU dsu(k);
  for (auto [w, u, v] : sub_edges) {
    if (dsu.merge(u, v)) {
      tree[u].emplace_back(w, v);
      tree[v].emplace_back(w, u);
    }
  }
  const int LOG = 20;
  vector<vector<int>> anc(k, vector<int>(20, -1));
  vector<vector<LL>> best(k, vector<LL>(20, 0));
  vector<int> dep(k, 0);
  function<void(int, int, LL)> dfs = [&](int u, int p, LL pw) {
    dep[u] = dep[p] + 1;
    anc[u][0] = p;
    best[u][0] = pw;
    for (int i = 1; i < LOG; i++) {
      int v = anc[u][i - 1];
      anc[u][i] = anc[v][i - 1];
      best[u][i] = max(best[u][i - 1], best[v][i - 1]);
    }
    for (auto [w, v] : tree[u]) {
      if (v != p) {
        dfs(v, u, w);
      }
    }
  };
  dfs(0, 0, 0);
  auto compute = [&](int u, int v) {
    if (dep[u] > dep[v]) swap(u, v);
    int diff = dep[v] - dep[u];
    LL res = 0;
    for (int i = 0; i < LOG; i++) {
      if (diff & (1 << i)) {
        res = max(res, best[v][i]);
        v = anc[v][i];
      }
    }
    if (u == v) return res;
    for (int i = LOG - 1; i >= 0; i--) {
      int pu = anc[u][i], pv = anc[v][i];
      if (pu != pv) {
        res = max(res, best[u][i]);
        res = max(res, best[v][i]);
        u = pu, v = pv;
      }
    }
    res = max(res, best[u][0]);
    res = max(res, best[v][0]);
    return res;
  };
  while (q--) {
    int a, b;
    cin >> a >> b;
    cout << compute(a - 1, b - 1) << '\n';
  }
  return 0;
}
