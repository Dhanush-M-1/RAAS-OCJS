#include <bits/stdc++.h>
using namespace std;
int lg(long long n) {
  assert(n > 0);
  int ans = -1;
  while (n) {
    ans++;
    n >>= 1;
  }
  return ans;
}
struct DSU {
  vector<int> fa, sz;
  DSU() {}
  DSU(int n) {
    fa.resize(n);
    iota(fa.begin(), fa.end(), 0);
    sz.assign(n, 1);
  }
  bool join(int x, int y) {
    int a = find(x), b = find(y);
    if (a != b) {
      if (sz[a] < sz[b]) swap(a, b);
      sz[a] += sz[b];
      fa[b] = a;
      return true;
    }
    return false;
  }
  int find(int x) {
    if (x == fa[x]) return x;
    return fa[x] = find(fa[x]);
  }
};
void solve() {
  int n, m, k, q;
  cin >> n >> m >> k >> q;
  vector<tuple<int, int, int>> edges(m);
  vector<vector<pair<int, int>>> adj(n);
  for (int i = 0; i < m; i++) {
    int u, v, w;
    cin >> u >> v >> w;
    u--, v--;
    edges[i] = make_tuple(u, v, w);
    adj[u].emplace_back(v, w);
    adj[v].emplace_back(u, w);
  }
  const long long INF = 9e18;
  set<pair<long long, int>> qu;
  vector<long long> d(n, INF);
  for (int i = 0; i < k; i++) {
    d[i] = 0;
    qu.insert({0, i});
  }
  while (!qu.empty()) {
    int v = qu.begin()->second;
    qu.erase(qu.begin());
    for (auto [to, len] : adj[v]) {
      if (d[v] + len < d[to]) {
        qu.erase({d[to], to});
        d[to] = d[v] + len;
        qu.insert({d[to], to});
      }
    }
  }
  vector<tuple<long long, int, int>> newedge(m);
  for (int i = 0; i < m; i++) {
    auto [u, v, w] = edges[i];
    newedge[i] = make_tuple(d[u] + d[v] + w, u, v);
  }
  sort(newedge.begin(), newedge.end());
  vector<pair<int, int>> queries(q);
  vector<long long> ans(q);
  vector<vector<int>> tokens(n);
  vector<int> where(q * 2);
  for (int i = 0; i < q; i++) {
    int u, v;
    cin >> u >> v;
    u--, v--;
    queries[i] = make_pair(u, v);
    tokens[u].push_back(2 * i);
    tokens[v].push_back(2 * i + 1);
    where[2 * i] = u;
    where[2 * i + 1] = v;
  }
  DSU dsu(n);
  for (auto [w, u, v] : newedge) {
    u = dsu.find(u);
    v = dsu.find(v);
    if (u == v) continue;
    if (dsu.sz[u] < dsu.sz[v]) {
      swap(u, v);
    }
    for (int t : tokens[v]) {
      if (dsu.find(where[t ^ 1]) == u) {
        assert(ans[t / 2] == 0);
        ans[t / 2] = w;
      }
      tokens[u].push_back(t);
    }
    dsu.join(u, v);
    tokens[v].clear();
  }
  for (int i = 0; i < q; i++) {
    cout << ans[i] << '\n';
  }
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int t = 1;
  while (t--) solve();
  return 0;
}
