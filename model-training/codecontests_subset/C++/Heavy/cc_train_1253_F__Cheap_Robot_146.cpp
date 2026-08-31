#include <bits/stdc++.h>
using namespace std;
const int N = 3e5 + 5;
struct edge {
  int to;
  long long cost;
};
struct path {
  int node;
  long long cost;
  bool operator<(const path &other) const { return cost > other.cost; }
};
bool known[N];
long long dist[N];
int par[N], p[N], we[N];
vector<edge> adj[N];
set<int> queries[N];
long long ans[N];
int n, m, k, q;
void Dijkstra() {
  priority_queue<path> pq;
  memset(known, 0, sizeof known);
  memset(dist, 63, sizeof dist);
  for (int i = 0; i < int(k); i++) {
    pq.push({i, 0});
    dist[i] = 0;
    par[i] = i;
  }
  while (pq.size()) {
    int node = pq.top().node;
    long long cost = pq.top().cost;
    pq.pop();
    if (known[node]) continue;
    known[node] = 1;
    for (auto &c : adj[node]) {
      if (dist[c.to] > dist[node] + c.cost) {
        dist[c.to] = dist[node] + c.cost;
        par[c.to] = par[node];
        pq.push({c.to, dist[c.to]});
      }
    }
  }
}
int f(int u) {
  if (u == p[u]) return u;
  return p[u] = f(p[u]);
}
bool is_connected(int a, int b) { return f(a) == f(b); }
void connect(int a, int b, long long w) {
  a = f(a);
  b = f(b);
  if (a == b) return;
  if (we[a] < we[b]) swap(a, b);
  we[a] += we[b];
  p[b] = a;
  if (int(queries[a].size()) < int(queries[b].size()))
    queries[a].swap(queries[b]);
  for (auto idx : queries[b]) {
    if (queries[a].count(idx)) {
      queries[a].erase(idx);
      ans[idx] = w;
    } else {
      queries[a].insert(idx);
    }
  }
}
void init() {
  for (int i = 0; i < N; i++) p[i] = i, we[i] = 1;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int a, b, w;
  cin >> n >> m >> k >> q;
  for (int i = 0; i < int(m); i++) {
    cin >> a >> b >> w;
    a--, b--;
    adj[a].push_back({b, w});
    adj[b].push_back({a, w});
  }
  Dijkstra();
  vector<pair<long long, pair<int, int> > > edges;
  for (int i = 0; i < int(n); i++) {
    for (auto e : adj[i]) {
      if (par[e.to] != par[i]) {
        edges.push_back({dist[e.to] + dist[i] + e.cost, {par[e.to], par[i]}});
      }
    }
  }
  sort(edges.begin(), edges.end());
  init();
  for (int i = 0; i < int(q); i++) {
    cin >> a >> b;
    --a, --b;
    queries[a].insert(i);
    queries[b].insert(i);
  }
  for (auto e : edges) {
    int u = e.second.first, v = e.second.second;
    long long W = e.first;
    if (is_connected(u, v)) continue;
    connect(u, v, W);
  }
  for (int i = 0; i < int(q); i++) cout << ans[i] << '\n';
  return 0;
}
