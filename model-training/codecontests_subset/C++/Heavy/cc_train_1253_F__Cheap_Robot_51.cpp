#include <bits/stdc++.h>
using namespace std;
struct UnionFindPersistent {
  vector<int> par;
  vector<int64_t> time;
  vector<vector<pair<int64_t, int>>> sz;
  const int64_t INF = 1e18;
  UnionFindPersistent(int n = 0) {
    if (n > 0) initialize(n);
  }
  void initialize(int n) {
    par.resize(n);
    time.resize(n);
    sz.resize(n);
    for (int i = 0; i < n; i++) {
      par[i] = i;
      time[i] = INF;
      sz[i].push_back({-1, 1});
    }
  }
  int find(int x, int64_t t) {
    if (time[x] > t) {
      return x;
    } else {
      return find(par[x], t);
    }
  }
  int size(int x, int64_t t) {
    x = find(x, t);
    return (*(lower_bound(sz[x].begin(), sz[x].end(), make_pair(t + 1, 0)) - 1))
        .second;
  }
  void unite(int x, int y, int64_t t) {
    x = find(x, t);
    y = find(y, t);
    if (x == y) return;
    int new_sz = sz[x].back().second + sz[y].back().second;
    if (sz[x].back().second > sz[y].back().second) swap(x, y);
    par[x] = y;
    time[x] = t;
    sz[y].push_back({t, new_sz});
  }
  bool same(int x, int y, int64_t t) { return find(x, t) == find(y, t); }
};
int main() {
  int N, M, K, Q;
  cin >> N >> M >> K >> Q;
  vector<pair<int64_t, int64_t>> edges[100000];
  for (int i = 0; i < M; i++) {
    int a, b, c;
    scanf("%d %d %d", &a, &b, &c);
    a--;
    b--;
    edges[a].emplace_back(b, c);
    edges[b].emplace_back(a, c);
  }
  vector<pair<int64_t, int64_t>> dist(N);
  pair<int64_t, int64_t> INFP = {1e18, 1e18};
  priority_queue<vector<int64_t>, vector<vector<int64_t>>,
                 greater<vector<int64_t>>>
      que;
  for (int i = 0; i < K; i++) {
    dist[i] = {0, i};
    que.push({0, i, i});
  }
  for (int i = K; i < N; i++) dist[i] = INFP;
  while (que.size()) {
    auto p = que.top();
    que.pop();
    int64_t d = p[0], i = p[1], s = p[2];
    if (dist[i].first < d) continue;
    for (auto& e : edges[i]) {
      int64_t j = e.first, d2 = d + e.second;
      if (dist[j].first > d2) {
        dist[j] = {d2, s};
        que.push({d2, j, s});
      }
    }
  }
  vector<vector<int64_t>> es;
  for (int i = 0; i < N; i++)
    for (auto& e : edges[i]) {
      int j = e.first, c = e.second;
      es.push_back(
          {dist[i].first + dist[j].first + c, dist[i].second, dist[j].second});
    }
  sort(es.begin(), es.end());
  UnionFindPersistent uf(N);
  for (auto& e : es) uf.unite(e[1], e[2], e[0]);
  for (int i = 0; i < Q; i++) {
    int a, b;
    scanf("%d %d", &a, &b);
    a--;
    b--;
    int64_t ok = 1e18, ng = -1;
    while (ok - ng > 1) {
      int64_t mid = (ok + ng) / 2;
      (uf.same(a, b, mid) ? ok : ng) = mid;
    }
    printf("%lld\n", ok);
  }
  return 0;
}
