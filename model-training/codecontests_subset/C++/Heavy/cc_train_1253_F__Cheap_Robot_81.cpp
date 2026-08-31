#include <bits/stdc++.h>
using namespace std;
const long long LL_INF = (long long)2e18 + 5;
struct edge {
  int node = -1;
  long long weight = LL_INF;
  edge() {}
  edge(int _node, long long _weight) : node(_node), weight(_weight) {}
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
struct ab_edge {
  int a, b;
  long long weight;
  bool operator<(const ab_edge &other) const { return weight < other.weight; }
};
vector<ab_edge> edges;
void compute_real_weights() {
  for (int i = 0; i < N; i++)
    for (edge &e : adj[i]) {
      e.weight += dist[i] + dist[e.node];
      edges.push_back({i, e.node, e.weight});
    }
}
vector<vector<pair<int, int>>> queries;
vector<long long> answers;
vector<vector<int>> groups;
vector<int> owner;
void merge_and_solve(int a, int b, long long weight) {
  a = owner[a];
  b = owner[b];
  if (a == b) return;
  if (groups[a].size() > groups[b].size()) swap(a, b);
  for (int x : groups[a])
    for (pair<int, int> &query : queries[x])
      if (owner[query.first] == b) {
        assert(answers[query.second] < 0);
        answers[query.second] = weight;
      }
  for (int x : groups[a]) {
    owner[x] = b;
    groups[b].push_back(x);
  }
  groups[a].clear();
}
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
  compute_real_weights();
  queries.assign(N, {});
  answers.assign(Q, -1);
  for (int q = 0; q < Q; q++) {
    int a, b;
    cin >> a >> b;
    a--;
    b--;
    queries[a].emplace_back(b, q);
    queries[b].emplace_back(a, q);
  }
  groups.assign(N, {});
  owner.resize(N);
  for (int i = 0; i < N; i++) {
    owner[i] = i;
    groups[i] = {i};
  }
  sort(edges.begin(), edges.end());
  for (ab_edge &e : edges) merge_and_solve(e.a, e.b, e.weight);
  for (int q = 0; q < Q; q++) cout << answers[q] << '\n';
}
