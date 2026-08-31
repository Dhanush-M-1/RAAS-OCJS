#include <bits/stdc++.h>
struct disjoint_set {
  std::vector<int> p;
  disjoint_set(int n) : p(n, -1) {}
  int root(int u) { return p[u] < 0 ? u : p[u] = root(p[u]); }
  bool merge(int u, int v) {
    if ((u = root(u)) == (v = root(v))) return false;
    if (p[u] > p[v]) std::swap(u, v);
    p[u] += p[v];
    p[v] = u;
    return true;
  }
  void reset() { std::fill(p.begin(), p.end(), -1); }
};
class FCheapRobot {
 public:
  void solve(std::istream& in, std::ostream& out) {
    int n, m, k, q;
    in >> n >> m >> k >> q;
    using ll = long long;
    std::vector<std::vector<std::pair<int, int>>> g(n);
    std::vector<std::tuple<int, int, ll>> edges;
    for (int i = 0; i < m; ++i) {
      int u, v, w;
      in >> u >> v >> w;
      --u, --v;
      g[u].emplace_back(v, w);
      g[v].emplace_back(u, w);
      edges.emplace_back(u, v, w);
    }
    using node = std::pair<ll, int>;
    std::priority_queue<node, std::vector<node>, std::greater<node>> pq;
    std::vector<ll> dist(n, std::numeric_limits<ll>::max());
    for (int i = 0; i < k; ++i) pq.emplace(dist[i] = 0, i);
    while (!pq.empty()) {
      int u;
      ll d;
      std::tie(d, u) = pq.top();
      pq.pop();
      if (dist[u] < d) continue;
      for (auto e : g[u])
        if (dist[e.first] > d + e.second)
          pq.emplace(dist[e.first] = d + e.second, e.first);
    }
    for (auto& e : edges) {
      int u, v;
      ll w;
      std::tie(u, v, w) = e;
      w += dist[u] + dist[v];
      e = std::make_tuple(u, v, w);
    }
    std::sort(edges.begin(), edges.end(),
              [](const std::tuple<int, int, ll>& a,
                 const std::tuple<int, int, ll>& b) {
                return std::get<2>(a) < std::get<2>(b);
              });
    std::vector<int> u(q), v(q), ord;
    for (int i = 0; i < q; ++i) in >> u[i] >> v[i], --u[i], --v[i];
    std::vector<int> lo(q), hi(q, m - 1), mid(q);
    disjoint_set ds(n);
    while (true) {
      ord.clear();
      for (int i = 0; i < q; ++i) {
        if (lo[i] == hi[i]) continue;
        mid[i] = (lo[i] + hi[i]) / 2;
        ord.emplace_back(i);
      }
      if (ord.empty()) break;
      std::sort(ord.begin(), ord.end(),
                [&mid](int x, int y) { return mid[x] < mid[y]; });
      ds.reset();
      for (int i = 0, j = 0; i < (int)ord.size(); ++i) {
        ll w = std::get<2>(edges[mid[ord[i]]]);
        for (; j < m && std::get<2>(edges[j]) <= w; ++j)
          ds.merge(std::get<0>(edges[j]), std::get<1>(edges[j]));
        if (ds.root(u[ord[i]]) == ds.root(v[ord[i]]))
          hi[ord[i]] = mid[ord[i]];
        else
          lo[ord[i]] = mid[ord[i]] + 1;
      }
    }
    for (int i = 0; i < q; ++i) out << std::get<2>(edges[lo[i]]) << '\n';
  }
};
int main() {
  std::ios_base::sync_with_stdio(0);
  std::istream& in(std::cin);
  std::ostream& out(std::cout);
  in.tie(0);
  FCheapRobot solver;
  solver.solve(in, out);
  return 0;
}
