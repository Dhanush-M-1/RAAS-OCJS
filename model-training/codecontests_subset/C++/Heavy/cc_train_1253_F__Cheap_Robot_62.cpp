#include <bits/stdc++.h>
using namespace std;
const long long LL_INF = (long long)2e18 + 5;
template <typename T, bool maximum_mode = false>
struct RMQ {
  int n = 0, levels = 0;
  vector<T> values;
  vector<vector<int>> range_low;
  RMQ(const vector<T> &_values = {}) {
    if (!_values.empty()) build(_values);
  }
  static int largest_bit(int x) { return 31 - __builtin_clz(x); }
  int better_index(int a, int b) const {
    return (values[a] < values[b]) ^ maximum_mode ? a : b;
  }
  void build(const vector<T> &_values) {
    values = _values;
    n = values.size();
    levels = largest_bit(n) + 1;
    range_low.resize(levels);
    for (int k = 0; k < levels; k++) range_low[k].resize(n - (1 << k) + 1);
    for (int i = 0; i < n; i++) range_low[0][i] = i;
    for (int k = 1; k < levels; k++)
      for (int i = 0; i <= n - (1 << k); i++)
        range_low[k][i] = better_index(range_low[k - 1][i],
                                       range_low[k - 1][i + (1 << (k - 1))]);
  }
  int query_index(int a, int b) const {
    assert(0 <= a && a < b && b <= n);
    int level = largest_bit(b - a);
    return better_index(range_low[level][a],
                        range_low[level][b - (1 << level)]);
  }
  T query_value(int a, int b) const { return values[query_index(a, b)]; }
};
struct edge {
  int node = -1;
  long long weight = 0;
  edge() {}
  edge(int _node, long long _weight) : node(_node), weight(_weight) {}
};
template <typename T_weight>
struct weighted_LCA {
  int n = 0;
  vector<vector<edge>> adj;
  vector<int> parent, depth, subtree_size;
  vector<T_weight> weighted_depth, up_weight;
  vector<int> euler, first_occurrence;
  vector<int> tour_start, tour_end, tour_list, postorder;
  vector<int> heavy_root;
  RMQ<int> rmq;
  weighted_LCA(int _n = 0) { init(_n); }
  weighted_LCA(const vector<vector<edge>> &_adj) { init(_adj); }
  void init(int _n) {
    n = _n;
    adj.assign(n, {});
    parent.resize(n);
    depth.resize(n);
    subtree_size.resize(n);
    weighted_depth.resize(n);
    up_weight.assign(n, numeric_limits<T_weight>::min());
    first_occurrence.resize(n);
    tour_start.resize(n);
    tour_end.resize(n);
    tour_list.resize(n);
    postorder.resize(n);
    heavy_root.resize(n);
  }
  void init(const vector<vector<edge>> &_adj) {
    init(_adj.size());
    adj = _adj;
  }
  void add_edge(int a, int b, T_weight weight) {
    adj[a].emplace_back(b, weight);
    adj[b].emplace_back(a, weight);
  }
  void erase_edge(int from, int to) {
    for (edge &e : adj[from])
      if (e.node == to) {
        swap(e, adj[from].back());
        adj[from].pop_back();
        return;
      }
    assert(false);
  }
  void dfs(int node, int par, T_weight weight) {
    parent[node] = par;
    depth[node] = par < 0 ? 0 : depth[par] + 1;
    subtree_size[node] = 1;
    weighted_depth[node] = weight;
    if (par >= 0) erase_edge(node, par);
    for (edge &e : adj[node]) {
      up_weight[e.node] = e.weight;
      dfs(e.node, node, weight + e.weight);
      subtree_size[node] += subtree_size[e.node];
    }
    sort(adj[node].begin(), adj[node].end(), [&](const edge &a, const edge &b) {
      return subtree_size[a.node] > subtree_size[b.node];
    });
  }
  int tour, post_tour;
  void tour_dfs(int node, bool heavy) {
    heavy_root[node] = heavy ? heavy_root[parent[node]] : node;
    first_occurrence[node] = euler.size();
    euler.push_back(node);
    tour_list[tour] = node;
    tour_start[node] = tour++;
    bool heavy_child = true;
    for (edge &e : adj[node]) {
      tour_dfs(e.node, heavy_child);
      euler.push_back(node);
      heavy_child = false;
    }
    tour_end[node] = tour;
    postorder[node] = post_tour++;
  }
  void build() {
    parent.assign(n, -1);
    for (int i = 0; i < n; i++)
      if (parent[i] < 0) dfs(i, -1, 0);
    tour = post_tour = 0;
    for (int i = 0; i < n; i++)
      if (parent[i] < 0) {
        tour_dfs(i, false);
        euler.push_back(-1);
      }
    assert((int)euler.size() == 2 * n);
    vector<int> euler_depths;
    for (int node : euler)
      euler_depths.push_back(node < 0 ? node : depth[node]);
    rmq.build(euler_depths);
    build_path_maxes();
  }
  int get_lca(int a, int b) const {
    a = first_occurrence[a];
    b = first_occurrence[b];
    if (a > b) swap(a, b);
    return euler[rmq.query_index(a, b + 1)];
  }
  bool is_ancestor(int a, int b) const {
    return tour_start[a] <= tour_start[b] && tour_start[b] < tour_end[a];
  }
  bool on_path(int x, int a, int b) const {
    int anc = get_lca(a, b);
    return is_ancestor(anc, x) && (is_ancestor(x, a) || is_ancestor(x, b));
  }
  int get_dist(int a, int b) const {
    return depth[a] + depth[b] - 2 * depth[get_lca(a, b)];
  }
  T_weight get_weighted_dist(int a, int b) const {
    return weighted_depth[a] + weighted_depth[b] -
           2 * weighted_depth[get_lca(a, b)];
  }
  int child_ancestor(int a, int b) const {
    assert(a != b);
    assert(is_ancestor(a, b));
    int child =
        euler[rmq.query_index(first_occurrence[a], first_occurrence[b] + 1) +
              1];
    assert(is_ancestor(child, b));
    return child;
  }
  static int largest_bit(int x) { return 31 - __builtin_clz(x); }
  vector<vector<pair<int, T_weight>>> ancestor_max;
  void build_path_maxes() {
    ancestor_max.assign(largest_bit(n) + 1, vector<pair<int, T_weight>>(n));
    for (int i = 0; i < n; i++) ancestor_max[0][i] = {parent[i], up_weight[i]};
    for (int k = 0; k < largest_bit(n); k++)
      for (int i = 0; i < n; i++) {
        int k_anc = ancestor_max[k][i].first;
        T_weight k_max = ancestor_max[k][i].second;
        if (k_anc < 0)
          ancestor_max[k + 1][i] = {-1, k_max};
        else
          ancestor_max[k + 1][i] = {ancestor_max[k][k_anc].first,
                                    max(k_max, ancestor_max[k][k_anc].second)};
      }
  }
  T_weight query_path_max(int a, int b) const {
    int anc = get_lca(a, b);
    int a_dist = depth[a] - depth[anc];
    int b_dist = depth[b] - depth[anc];
    T_weight path_max = numeric_limits<T_weight>::min();
    for (int k = 0; 1 << k <= a_dist; k++)
      if (a_dist >> k & 1) {
        path_max = max(path_max, ancestor_max[k][a].second);
        a = ancestor_max[k][a].first;
      }
    for (int k = 0; 1 << k <= b_dist; k++)
      if (b_dist >> k & 1) {
        path_max = max(path_max, ancestor_max[k][b].second);
        b = ancestor_max[k][b].first;
      }
    return path_max;
  }
};
struct dijkstra_state {
  long long dist;
  int node;
  dijkstra_state() {}
  dijkstra_state(long long _dist, int _node) : dist(_dist), node(_node) {}
  bool operator<(const dijkstra_state &other) const {
    return dist > other.dist;
  }
};
int N, M, K, Q;
vector<vector<edge>> adj;
vector<long long> dist;
void dijkstra_check(priority_queue<dijkstra_state> &pq, int node,
                    long long current_dist) {
  if (current_dist < dist[node]) {
    dist[node] = current_dist;
    pq.emplace(current_dist, node);
  }
}
void dijkstra() {
  dist.assign(N, LL_INF);
  priority_queue<dijkstra_state> pq;
  for (int source = 0; source < K; source++) dijkstra_check(pq, source, 0);
  while (!pq.empty()) {
    dijkstra_state top = pq.top();
    pq.pop();
    if (top.dist > dist[top.node]) continue;
    for (edge &e : adj[top.node])
      dijkstra_check(pq, e.node, top.dist + e.weight);
  }
}
struct union_find {
  vector<int> parent;
  vector<int> size;
  int components = 0;
  union_find(int n = -1) {
    if (n >= 0) init(n);
  }
  void init(int n) {
    parent.resize(n + 1);
    size.assign(n + 1, 1);
    components = n;
    for (int i = 0; i <= n; i++) parent[i] = i;
  }
  int find(int x) { return x == parent[x] ? x : parent[x] = find(parent[x]); }
  bool unite(int x, int y) {
    x = find(x);
    y = find(y);
    if (x == y) return false;
    if (size[x] < size[y]) swap(x, y);
    parent[y] = x;
    size[x] += size[y];
    components--;
    return true;
  }
};
template <typename T>
struct kruskal {
  struct edge {
    int a, b;
    T weight;
    bool in_tree = false;
    edge() {}
    edge(int _a, int _b, T _weight) : a(_a), b(_b), weight(_weight) {}
    bool operator<(const edge &other) const { return weight < other.weight; }
  };
  union_find UF;
  vector<edge> edges;
  kruskal(int n = -1) {
    if (n >= 0) init(n);
  }
  void init(int n) {
    UF.init(n);
    edges = {};
  }
  void add_edge(int a, int b, T weight) { edges.emplace_back(a, b, weight); }
  T solve() {
    sort(edges.begin(), edges.end());
    T total = 0;
    for (edge &e : edges)
      if (UF.unite(e.a, e.b)) {
        total += e.weight;
        e.in_tree = true;
      }
    return total;
  }
};
int main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  cin >> N >> M >> K >> Q;
  adj.assign(N, {});
  for (int i = 0; i < M; i++) {
    int u, v, weight;
    cin >> u >> v >> weight;
    u--;
    v--;
    adj[u].emplace_back(v, weight);
    adj[v].emplace_back(u, weight);
  }
  dijkstra();
  kruskal<long long> mst(N);
  for (int i = 0; i < N; i++)
    for (edge &e : adj[i]) {
      e.weight += dist[i] + dist[e.node];
      mst.add_edge(i, e.node, e.weight);
    }
  mst.solve();
  weighted_LCA<long long> lca(N);
  for (kruskal<long long>::edge &e : mst.edges)
    if (e.in_tree) lca.add_edge(e.a, e.b, e.weight);
  lca.build();
  for (int q = 0; q < Q; q++) {
    int a, b;
    cin >> a >> b;
    a--;
    b--;
    cout << max(lca.query_path_max(a, b), 0LL) << '\n';
  }
}
