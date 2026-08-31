#include <bits/stdc++.h>
using namespace std;
const long long mod = 1000000007;
const long long INF = (long long)1000000007 * 1000000007;
const long double eps = 1e-8;
const long double pi = acos(-1.0);
int dx[4] = {1, -1, 0, 0};
int dy[4] = {0, 0, 1, -1};
template <class T>
bool chmax(T &a, const T &b) {
  if (a < b) {
    a = b;
    return 1;
  }
  return 0;
}
template <class T>
bool chmin(T &a, const T &b) {
  if (b < a) {
    a = b;
    return 1;
  }
  return 0;
}
template <class Cap, class Cost>
struct MinCostFlow {
 public:
  MinCostFlow() {}
  MinCostFlow(int n) : _n(n), g(n) {}
  int add_edge(int from, int to, Cap cap, Cost cost) {
    assert(0 <= from && from < _n);
    assert(0 <= to && to < _n);
    int m = int(pos.size());
    pos.push_back({from, int(g[from].size())});
    g[from].push_back(_edge{to, int(g[to].size()), cap, cost});
    g[to].push_back(_edge{from, int(g[from].size()) - 1, 0, -cost});
    return m;
  }
  struct edge {
    int from, to;
    Cap cap, flow;
    Cost cost;
  };
  edge get_edge(int i) {
    int m = int(pos.size());
    assert(0 <= i && i < m);
    auto _e = g[pos[i].first][pos[i].second];
    auto _re = g[_e.to][_e.rev];
    return edge{
        pos[i].first, _e.to, _e.cap + _re.cap, _re.cap, _e.cost,
    };
  }
  std::vector<edge> edges() {
    int m = int(pos.size());
    std::vector<edge> result(m);
    for (int i = 0; i < m; i++) {
      result[i] = get_edge(i);
    }
    return result;
  }
  std::pair<Cap, Cost> flow(int s, int t) {
    return flow(s, t, std::numeric_limits<Cap>::max());
  }
  std::pair<Cap, Cost> flow(int s, int t, Cap flow_limit) {
    return slope(s, t, flow_limit).back();
  }
  std::vector<std::pair<Cap, Cost>> slope(int s, int t) {
    return slope(s, t, std::numeric_limits<Cap>::max());
  }
  std::vector<std::pair<Cap, Cost>> slope(int s, int t, Cap flow_limit) {
    assert(0 <= s && s < _n);
    assert(0 <= t && t < _n);
    assert(s != t);
    std::vector<Cost> dual(_n, 0), dist(_n);
    std::vector<int> pv(_n), pe(_n);
    std::vector<bool> vis(_n);
    auto dual_ref = [&]() {
      std::fill(dist.begin(), dist.end(), std::numeric_limits<Cost>::max());
      std::fill(pv.begin(), pv.end(), -1);
      std::fill(pe.begin(), pe.end(), -1);
      std::fill(vis.begin(), vis.end(), false);
      struct Q {
        Cost key;
        int to;
        bool operator<(Q r) const { return key > r.key; }
      };
      std::priority_queue<Q> que;
      dist[s] = 0;
      que.push(Q{0, s});
      while (!que.empty()) {
        int v = que.top().to;
        que.pop();
        if (vis[v]) continue;
        vis[v] = true;
        if (v == t) break;
        for (int i = 0; i < int(g[v].size()); i++) {
          auto e = g[v][i];
          if (vis[e.to] || !e.cap) continue;
          Cost cost = e.cost - dual[e.to] + dual[v];
          if (dist[e.to] - dist[v] > cost) {
            dist[e.to] = dist[v] + cost;
            pv[e.to] = v;
            pe[e.to] = i;
            que.push(Q{dist[e.to], e.to});
          }
        }
      }
      if (!vis[t]) {
        return false;
      }
      for (int v = 0; v < _n; v++) {
        if (!vis[v]) continue;
        dual[v] -= dist[t] - dist[v];
      }
      return true;
    };
    Cap flow = 0;
    Cost cost = 0, prev_cost = -1;
    std::vector<std::pair<Cap, Cost>> result;
    result.push_back({flow, cost});
    while (flow < flow_limit) {
      if (!dual_ref()) break;
      Cap c = flow_limit - flow;
      for (int v = t; v != s; v = pv[v]) {
        c = std::min(c, g[pv[v]][pe[v]].cap);
      }
      for (int v = t; v != s; v = pv[v]) {
        auto &e = g[pv[v]][pe[v]];
        e.cap -= c;
        g[v][e.rev].cap += c;
      }
      Cost d = -dual[s];
      flow += c;
      cost += c * d;
      if (prev_cost == d) {
        result.pop_back();
      }
      result.push_back({flow, cost});
      prev_cost = cost;
    }
    return result;
  }

 private:
  int _n;
  struct _edge {
    int to, rev;
    Cap cap;
    Cost cost;
  };
  std::vector<std::pair<int, int>> pos;
  std::vector<std::vector<_edge>> g;
};
using edge = MinCostFlow<int, int>::edge;
const int inf = 10000000;
int n, k;
vector<int> a(n), b(n);
void solve() {
  MinCostFlow<int, int> mcf(n + k + 5);
  int ans = inf * n;
  int S = n + k + 1;
  for (int i = 0; i < n; i++) {
    mcf.add_edge(i, n + k, 1, inf - (k - 1) * b[i]);
    for (int j = 0; j < k; j++) {
      mcf.add_edge(i, n + j, 1, inf - a[i] - j * b[i]);
    }
  }
  for (int i = 0; i < n; i++) {
    mcf.add_edge(S, i, 1, 0);
  }
  for (int j = 0; j < k; j++) {
    mcf.add_edge(n + j, S + 1, 1, 0);
  }
  mcf.add_edge(n + k, S + 1, n - k, 0);
  pair<int, int> p = mcf.flow(S, S + 1);
  auto es = mcf.edges();
  vector<int> v(k);
  vector<bool> used(n);
  for (auto e : es) {
    if (e.to - n < 0 || e.to - n >= k) continue;
    if (e.flow == 1) {
      v[e.to - n] = e.from;
      used[e.from] = true;
    }
  }
  printf("%d\n", 2 * n - k);
  for (int i = 0; i < k - 1; i++) {
    printf("%d ", v[i] + 1);
  }
  for (int i = 0; i < n; i++) {
    if (!used[i]) {
      printf("%d %d ", i + 1, -i - 1);
    }
  }
  printf("%d\n", v[k - 1] + 1);
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout << fixed << setprecision(50);
  int t;
  scanf("%d", &t);
  for (int i = 0; i < t; i++) {
    scanf("%d%d", &n, &k);
    a.resize(n);
    b.resize(n);
    for (int i = 0; i < n; i++) scanf("%d%d", &a[i], &b[i]);
    solve();
  }
}
