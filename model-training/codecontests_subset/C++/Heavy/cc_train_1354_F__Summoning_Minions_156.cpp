#include <bits/stdc++.h>
using namespace std;
template <typename flow_type, typename cost_type>
struct min_cost_max_flow {
  struct edge {
    size_t src, dst, rev;
    flow_type flow, cap;
    cost_type cost;
  };
  int n;
  vector<vector<edge>> adj;
  min_cost_max_flow(int n) : n(n), adj(n), potential(n), dist(n), back(n) {}
  void add_edge(size_t src, size_t dst, flow_type cap, cost_type cost) {
    adj[src].push_back({src, dst, adj[dst].size(), 0, cap, cost});
    if (src == dst) adj[src].back().rev++;
    adj[dst].push_back({dst, src, adj[src].size() - 1, 0, 0, -cost});
  }
  vector<cost_type> potential;
  inline cost_type rcost(const edge &e) {
    return e.cost + potential[e.src] - potential[e.dst];
  }
  void bellman_ford(int source) {
    for (int k = 0; k < n; ++k)
      for (int u = 0; u < n; ++u)
        for (edge &e : adj[u])
          if (e.cap > 0 && rcost(e) < 0) potential[e.dst] += rcost(e);
  }
  const cost_type oo = numeric_limits<cost_type>::max();
  vector<cost_type> dist;
  vector<edge *> back;
  cost_type dijkstra(int source, int sink) {
    fill(dist.begin(), dist.end(), oo);
    priority_queue<pair<cost_type, int>, vector<pair<cost_type, int>>,
                   greater<pair<cost_type, int>>>
        pq;
    for (pq.push({dist[source] = 0, source}); !pq.empty();) {
      pair<cost_type, int> p = pq.top();
      pq.pop();
      if (dist[p.second] < p.first) continue;
      if (p.second == sink) break;
      for (edge &e : adj[p.second])
        if (e.flow < e.cap && dist[e.dst] > dist[e.src] + rcost(e)) {
          back[e.dst] = &e;
          pq.push({dist[e.dst] = dist[e.src] + rcost(e), e.dst});
        }
    }
    return dist[sink];
  }
  pair<flow_type, cost_type> max_flow(int source, int sink) {
    flow_type flow = 0;
    cost_type cost = 0;
    for (int u = 0; u < n; ++u)
      for (edge &e : adj[u]) e.flow = 0;
    potential.assign(n, 0);
    dist.assign(n, 0);
    back.assign(n, nullptr);
    bellman_ford(source);
    while (dijkstra(source, sink) < oo) {
      for (int u = 0; u < n; ++u)
        if (dist[u] < dist[sink]) potential[u] += dist[u] - dist[sink];
      flow_type first = numeric_limits<flow_type>::max();
      for (edge *e = back[sink]; e; e = back[e->src])
        first = min(first, e->cap - e->flow);
      for (edge *e = back[sink]; e; e = back[e->src])
        e->flow += first, adj[e->dst][e->rev].flow -= first;
      flow += first;
      cost += first * (potential[sink] - potential[source]);
    }
    return {flow, cost};
  }
};
int ai[105], bi[105];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int t;
  cin >> t;
  while (t--) {
    long long n, k, a, b;
    cin >> n >> k;
    min_cost_max_flow<int, int> g(4 + k + n);
    g.add_edge(0, n + 1, k, 0);
    g.add_edge(0, n + 2, n - k, 0);
    for (int i = 0; i < k; i++) g.add_edge(n + 1, n + 4 + i, 1, 0);
    for (int i = 0; i < n; i++) {
      cin >> a >> b;
      ai[i] = a;
      bi[i] = b;
      g.add_edge(n + 2, i + 1, 1, -((k - 1) * b));
      for (int j = 0; j < k; j++)
        g.add_edge(n + 4 + j, i + 1, 1, -(a + (j * b)));
      g.add_edge(i + 1, n + 3, 1, 0);
    }
    long long x = -(g.max_flow(0, n + 3).second);
    vector<pair<long long, long long>> ks;
    set<int> af;
    for (int i = 0; i < n; i++) af.insert(i);
    for (int i = 0; i < k; i++)
      for (auto edge : g.adj[n + 4 + i])
        if (edge.flow == 1) {
          ks.push_back(
              pair<long long, long long>(bi[edge.dst - 1], edge.dst - 1));
          af.erase(edge.dst - 1);
        }
    sort((ks).begin(), (ks).end());
    vector<int> res;
    for (int i = 0; i < k - 1; i++) res.push_back(ks[i].second + 1);
    for (auto y : af) {
      res.push_back(y + 1);
      res.push_back(-(y + 1));
    }
    res.push_back(ks[k - 1].second + 1);
    cout << (res.size()) << '\n';
    for (auto y : res) cout << y << ' ';
    cout << '\n';
  }
  return 0;
}
