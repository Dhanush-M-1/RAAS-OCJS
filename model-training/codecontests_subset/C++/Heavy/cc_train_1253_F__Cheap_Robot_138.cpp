#include <bits/stdc++.h>
using namespace std;
const long long INF = 1e18;
long long dist[300005], ans[300005];
vector<pair<int, long long>> vec[300005];
vector<pair<int, int>> qrs[300005];
int par[300005];
set<int> se[300005];
struct edge {
  int u, v;
  long long c;
  edge(int u, int v, long long c) : u(u), v(v), c(c) {}
  bool operator<(const edge& rhs) const { return c < rhs.c; }
};
int main() {
  int n, m, k, q;
  scanf("%d %d %d %d", &n, &m, &k, &q);
  for (int i = 1; i <= m; i++) {
    int u, v;
    long long w;
    scanf("%d %d %lld", &u, &v, &w);
    vec[u].push_back({v, w});
    vec[v].push_back({u, w});
  }
  for (int i = 1; i <= q; i++) {
    int a, b;
    scanf("%d %d", &a, &b);
    qrs[a].push_back({b, i});
    qrs[b].push_back({a, i});
  }
  for (int i = 1; i <= n; i++) dist[i] = INF;
  priority_queue<pair<long long, int>, vector<pair<long long, int>>,
                 greater<pair<long long, int>>>
      pq;
  for (int i = 1; i <= k; i++) {
    dist[i] = 0;
    pq.push({dist[i], i});
  }
  while (!pq.empty()) {
    pair<long long, int> cur = pq.top();
    pq.pop();
    int u = cur.second;
    if (cur.first > dist[u]) continue;
    for (pair<int, long long> nxt : vec[u]) {
      int v = nxt.first;
      long long c = nxt.second;
      if (dist[v] > dist[u] + c) {
        dist[v] = dist[u] + c;
        pq.push({dist[v], v});
      }
    }
  }
  vector<edge> edges;
  for (int i = 1; i <= n; i++) {
    for (pair<int, long long> p : vec[i]) {
      int v = p.first;
      long long w = p.second;
      edges.push_back(edge(i, v, dist[i] + dist[v] + w));
    }
  }
  sort(edges.begin(), edges.end());
  for (int i = 1; i <= n; i++) {
    par[i] = i;
    se[i].insert(i);
  }
  for (edge e : edges) {
    int u = e.u, v = e.v;
    long long c = e.c;
    if (par[u] == par[v]) continue;
    if (se[par[u]].size() > se[par[v]].size()) swap(u, v);
    int pp = par[u];
    for (int x : se[pp]) {
      for (pair<int, int> p : qrs[x]) {
        int nv = p.first, idx = p.second;
        if (par[nv] == par[v]) ans[idx] = c;
      }
    }
    for (int x : se[pp]) {
      par[x] = par[v];
      se[par[v]].insert(x);
    }
    se[pp].clear();
  }
  for (int i = 1; i <= q; i++) printf("%lld\n", ans[i]);
  return 0;
}
