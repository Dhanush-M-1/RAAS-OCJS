#include <bits/stdc++.h>
using namespace std;
const int maxn = 3e5 + 10;
pair<pair<int, int>, long long> edges[maxn];
pair<int, int> queries[maxn];
long long ans[maxn];
vector<int> Q[maxn];
vector<int> G[maxn];
vector<int> H[maxn];
long long dist[maxn];
int realm[maxn];
vector<int> comp[maxn];
int par[maxn];
int n, m, k, q;
vector<pair<long long, pair<int, int>>> C;
set<pair<long long, int>> prq;
inline int get_other(int i, int v) {
  if (edges[i].first.first == v) return edges[i].first.second;
  return edges[i].first.first;
}
inline int get_other_Q(int i, int x) {
  if (queries[i].first == x) return queries[i].second;
  return queries[i].first;
}
inline void mark(int v, long long d, int r) {
  prq.insert({d, v});
  dist[v] = d;
  realm[v] = r;
}
inline void connect(int v, int u, long long w) {
  int x = realm[v];
  int y = realm[u];
  long long d = dist[v] + dist[u] + w;
  if (x != y) C.push_back({d, {x, y}});
}
inline void dijkstra() {
  for (int i = 0; i < k; i++) {
    mark(i, 0ll, i);
  }
  while (!prq.empty()) {
    int v = prq.begin()->second;
    prq.erase({dist[v], v});
    for (int i : G[v]) {
      int u = get_other(i, v);
      long long w = edges[i].second;
      if (dist[v] + w < dist[u]) {
        prq.erase({dist[u], u});
        mark(u, dist[v] + w, realm[v]);
      }
    }
  }
}
inline void init() {
  memset(dist, 63, sizeof dist);
  for (int i = 0; i < n; i++) {
    comp[i].push_back(i);
    par[i] = i;
  }
}
int main() {
  scanf("%d%d%d%d", &n, &m, &k, &q);
  init();
  for (int i = 0; i < m; i++) {
    int x, y;
    long long w;
    scanf("%d%d%lld", &x, &y, &w);
    x--;
    y--;
    edges[i] = {{x, y}, w};
    G[x].push_back(i);
    G[y].push_back(i);
  }
  dijkstra();
  for (int i = 0; i < m; i++) {
    connect(edges[i].first.first, edges[i].first.second, edges[i].second);
  }
  for (int i = 0; i < q; i++) {
    int x, y;
    scanf("%d%d", &x, &y);
    x--;
    y--;
    queries[i] = {x, y};
    Q[x].push_back(i);
    Q[y].push_back(i);
  }
  sort(C.begin(), C.end());
  for (auto ed : C) {
    long long d = ed.first;
    int v = par[ed.second.first];
    int u = par[ed.second.second];
    if (u == v) continue;
    if (comp[v].size() < comp[u].size()) {
      swap(v, u);
    }
    for (int a : comp[u]) {
      for (int idx : Q[a]) {
        int b = get_other_Q(idx, a);
        if (par[b] == v) {
          ans[idx] = d;
        }
      }
    }
    for (int a : comp[u]) {
      comp[v].push_back(a);
      par[a] = v;
    }
    comp[u].clear();
  }
  for (int i = 0; i < q; i++) {
    printf("%lld\n", ans[i]);
  }
  return 0;
}
