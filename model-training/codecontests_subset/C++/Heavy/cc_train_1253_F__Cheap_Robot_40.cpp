#include <bits/stdc++.h>
const int MAX_SIZE = 112345;
const int MAX_SIZE_LOG = 20;
int N, M, K, Q;
std::vector<std::pair<int, int>> g[MAX_SIZE];
std::pair<long long int, int> dist[MAX_SIZE];
int parent[MAX_SIZE];
std::vector<std::pair<long long int, std::pair<int, int>>> edges;
std::vector<std::pair<int, long long int>> tree[MAX_SIZE];
int parent_lca[MAX_SIZE][MAX_SIZE_LOG];
long long int mx_lca[MAX_SIZE][MAX_SIZE_LOG];
int depth[MAX_SIZE];
void UNION(const int &x, const int &y) { parent[x] = parent[y]; }
int FIND(const int &x) {
  if (x != parent[x]) {
    parent[x] = FIND(parent[x]);
  }
  return parent[x];
}
void build_dijkstra() {
  for (int i = 0; i < N; i += 1) {
    dist[i] = {LLONG_MAX, -1};
  }
  std::priority_queue<std::pair<long long int, int>> pq;
  for (int i = 0; i < K; i += 1) {
    dist[i] = {0, i};
    pq.push({-dist[i].first, i});
  }
  while (!pq.empty()) {
    const long long int cost = -pq.top().first;
    const int i = pq.top().second;
    pq.pop();
    if (cost > dist[i].first) {
      continue;
    }
    for (const auto &j : g[i]) {
      const long long int nxt = cost + j.second;
      if (nxt < dist[j.first].first) {
        dist[j.first] = {nxt, dist[i].second};
        pq.push({-nxt, j.first});
      }
    }
  }
}
void build_tree() {
  for (int i = 0; i < N; i += 1) {
    for (const auto &j : g[i]) {
      edges.push_back({dist[i].first + dist[j.first].first + j.second,
                       {dist[i].second, dist[j.first].second}});
    }
  }
  std::sort(edges.begin(), edges.end());
  for (int i = 0; i < N; i += 1) {
    parent[i] = i;
  }
  for (const auto &edge : edges) {
    const int &x = FIND(edge.second.first);
    const int &y = FIND(edge.second.second);
    if (x != y) {
      UNION(x, y);
      if (edge.second.first >= K or edge.second.second >= K) {
        continue;
      }
      tree[edge.second.first].push_back({edge.second.second, edge.first});
      tree[edge.second.second].push_back({edge.second.first, edge.first});
    }
  }
}
void dfs(const int &i, const int &p) {
  depth[i] = depth[p] + 1;
  parent_lca[i][0] = p;
  for (int j = 1; j < MAX_SIZE_LOG; j += 1) {
    parent_lca[i][j] = parent_lca[parent_lca[i][j - 1]][j - 1];
    mx_lca[i][j] =
        std::max(mx_lca[i][j - 1], mx_lca[parent_lca[i][j - 1]][j - 1]);
  }
  for (const auto &j : tree[i]) {
    if (j.first == p) {
      continue;
    }
    mx_lca[j.first][0] = j.second;
    dfs(j.first, i);
  }
}
int query_lca(const int &x, const int &y) {
  int a = x;
  int b = y;
  if (depth[a] < depth[b]) {
    std::swap(a, b);
  }
  const int dist = depth[a] - depth[b];
  for (int j = 0; j < MAX_SIZE_LOG; j += 1) {
    if (dist & (1 << j)) {
      a = parent_lca[a][j];
    }
  }
  if (a == b) {
    return a;
  }
  for (int j = MAX_SIZE_LOG - 1; j >= 0; j -= 1) {
    if (parent_lca[a][j] != parent_lca[b][j]) {
      a = parent_lca[a][j];
      b = parent_lca[b][j];
    }
  }
  return parent_lca[a][0];
}
long long int query(const int &vertex, const int &lca) {
  long long int ans = LLONG_MIN;
  const int dist = depth[vertex] - depth[lca];
  for (int i = 0, x = vertex; i < MAX_SIZE_LOG; i += 1) {
    if (dist & (1 << i)) {
      ans = std::max(ans, mx_lca[x][i]);
      x = parent_lca[x][i];
    }
  }
  return ans;
}
int main() {
  std::ios_base::sync_with_stdio(0);
  std::cin.tie(0);
  std::cout.tie(0);
  std::cin >> N >> M >> K >> Q;
  for (int i = 0; i < M; i += 1) {
    int x, y, w;
    std::cin >> x >> y >> w;
    x -= 1;
    y -= 1;
    g[x].push_back({y, w});
    g[y].push_back({x, w});
  }
  build_dijkstra();
  build_tree();
  dfs(0, 0);
  for (int i = 0; i < Q; i += 1) {
    int x, y;
    std::cin >> x >> y;
    x -= 1;
    y -= 1;
    const int lca = query_lca(x, y);
    std::cout << std::max(query(x, lca), query(y, lca)) << std::endl;
  }
  return 0;
}
