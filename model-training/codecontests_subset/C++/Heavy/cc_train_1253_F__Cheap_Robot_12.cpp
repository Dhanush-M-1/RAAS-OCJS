#include <bits/stdc++.h>
using namespace std;
template <class T>
bool mmin(T& a, const T& b) {
  return b < a ? a = b, 1 : 0;
}
template <class T>
bool mmax(T& a, const T& b) {
  return a < b ? a = b, 1 : 0;
}
void yesno(bool c) { cout << (c ? "YES" : "NO") << '\n'; }
void yes() { yesno(true); }
void no() { yesno(false); }
void imp() { cout << "-1" << '\n'; }
const int inf = 0x3f3f3f3f;
const long long infl = 0x3f3f3f3f3f3f3f3f;
vector<int> va, vb;
vector<int> aval, bval, wval;
struct base_graph {
  int n, ecnt = 0;
  bool is_wei;
  vector<int> from, to;
  vector<long long> w;
  base_graph(int n, bool is_wei = false) : n(n), is_wei(is_wei) {}
  virtual int add(int a, int b, int ww = 0) = 0;
  int base_add(int a, int b, int ww = 0) {
    from.push_back(a);
    to.push_back(b);
    if (is_wei) w.push_back(ww);
    return ecnt++;
  }
  void readin(int m, bool add_rev = false, int offset = 1) {
    reserve(add_rev ? 2 * m : m);
    for (int i = 0; i < m; i++) {
      int a, b, ww = 0;
      cin >> a >> b;
      a -= offset;
      b -= offset;
      if (is_wei) cin >> ww;
      add(a, b, ww);
      if (add_rev) add(b, a, ww);
    }
  }
  void readin_tree(bool add_rev, int offset = 1) {
    int m = n - 1;
    reserve(add_rev ? 2 * m : m);
    for (int i = 2; i <= m; i++) {
      int p;
      cin >> p;
      int a = i - offset;
      add(a, p);
      if (add_rev) add(p, a);
    }
  }

 protected:
  void reserve(int m) {
    from.reserve(m);
    to.reserve(m);
    if (is_wei) w.reserve(m);
  }
};
struct dir_graph : public base_graph {
  bool has_rev;
  vector<vector<pair<int, int>>> out, in;
  dir_graph(int n, bool has_rev = false, bool is_wei = false)
      : base_graph(n, is_wei), has_rev(has_rev), out(n), in(n) {}
  int add(int a, int b, int ww = 0) {
    int e = base_add(a, b, ww);
    out[a].push_back({e, b});
    in[b].push_back({e, a});
    return e;
  }
  void readin(int m, int offset = 1) { base_graph::readin(m, has_rev, offset); }
  void readin_tree(int offset = 1) { base_graph::readin_tree(has_rev, offset); }
};
struct undir_graph : public base_graph {
  vector<vector<pair<int, int>>> edg;
  undir_graph(int n, bool is_wei = false) : base_graph(n, is_wei), edg(n) {}
  int add(int a, int b, int ww = 0) {
    if (b > a) swap(a, b);
    int e = base_add(a, b, ww);
    edg[a].push_back({e, b});
    edg[b].push_back({e, a});
    return e;
  }
  void readin(int m, int offset = 1) { base_graph::readin(m, false, offset); }
  void readin_tree(int offset = 1) { base_graph::readin_tree(false, offset); }
};
struct dijkstra_vec {
  vector<long long> dist, par;
  dir_graph& g;
  dijkstra_vec(dir_graph& g) : dist(g.n, infl), par(g.n), g(g) {}
  void solve(const vector<int>& s) {
    using P = pair<long long, int>;
    priority_queue<P, vector<P>, greater<P>> q;
    auto upd = [&](int u, int p, long long d) {
      if (mmin(dist[u], d)) {
        par[u] = p;
        q.push({d, u});
      }
    };
    for (int ss : s) upd(ss, -1, 0);
    while (!q.empty()) {
      int u;
      long long d;
      tie(d, u) = q.top();
      q.pop();
      if (d > dist[u]) continue;
      for (auto [e, v] : g.out[u]) {
        long long newd = d + g.w[e];
        upd(v, u, newd);
      }
    }
  }
};
struct dsu {
  int _n;
  std::vector<int> parent_or_size;
  dsu() : _n(0) {}
  dsu(int n) : _n(n), parent_or_size(n, -1) {}
  int merge(int a, int b) {
    assert(0 <= a && a < _n);
    assert(0 <= b && b < _n);
    int x = leader(a), y = leader(b);
    if (x == y) return x;
    if (-parent_or_size[x] < -parent_or_size[y]) std::swap(x, y);
    parent_or_size[x] += parent_or_size[y];
    parent_or_size[y] = x;
    return x;
  }
  bool same(int a, int b) {
    assert(0 <= a && a < _n);
    assert(0 <= b && b < _n);
    return leader(a) == leader(b);
  }
  int leader(int a) {
    assert(0 <= a && a < _n);
    if (parent_or_size[a] < 0) return a;
    return parent_or_size[a] = leader(parent_or_size[a]);
  }
  int size(int a) {
    assert(0 <= a && a < _n);
    return -parent_or_size[leader(a)];
  }
};
int qval;
bool br = false;
struct query_dsu : dsu {
  unordered_map<int, unordered_map<int, vector<int>>> betw;
  undir_graph& g;
  query_dsu(int n, undir_graph& g) : dsu(n), g(g) {
    for (int e = 0; e < g.ecnt; e++) {
      int u = g.from[e], v = g.to[e];
      betw[u][v].push_back(e);
      betw[v][u].push_back(e);
    }
  }
  vector<int>& getbetw(int a, int b) {
    int x = leader(a), y = leader(b);
    return betw[x][y];
  }
  int merge(int a, int b) {
    int x = leader(a), y = leader(b);
    if (x == y) return -1;
    if (br) {
      cout << a << " " << b << " " << x << " " << y << '\n';
      exit(0);
    }
    if (dsu::merge(a, b) != x) swap(x, y);
    betw[x][y].clear();
    betw[y][x].clear();
    for (auto [e, v] : g.edg[y]) {
      v = leader(v);
      if (v == x) continue;
      g.edg[x].push_back({e, v});
      betw[x][v].push_back(e);
      betw[v][x].push_back(e);
    }
    g.edg[y].clear();
    return x;
  }
};
void solve() {
  int n, m, k, q;
  cin >> n >> m >> k >> q;
  qval = q;
  dir_graph g(n, true, true);
  g.readin(m);
  dijkstra_vec dij(g);
  vector<int> s;
  for (int i = 0; i < (k); i++) s.push_back(i);
  dij.solve(s);
  for (int e = 0; e < (g.ecnt); e++) {
    g.w[e] += dij.dist[g.from[e]] + dij.dist[g.to[e]];
  }
  undir_graph qg(n);
  qg.readin(q);
  query_dsu d(n, qg);
  vector<pair<long long, long long>> ws;
  for (int e = 0; e < (g.ecnt); e++) {
    if (e % 2) ws.push_back(make_pair(g.w[e], e));
  }
  sort((ws).begin(), (ws).end());
  vector<long long> ans(q);
  int cnt = 0;
  for (pair<long long, long long> we : ws) {
    cnt++;
    int u = g.from[we.second], v = g.to[we.second];
    for (int qq : d.getbetw(u, v)) ans[qq] = we.first;
    d.merge(u, v);
  }
  for (int qq = 0; qq < (q); qq++) {
    cout << ans[qq] << '\n';
  }
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int tc = 1;
  while (tc--) solve();
  return 0;
}
