#include <bits/stdc++.h>
using namespace std;
const long long MAXN = 3e5 + 7;
const long long INF = 1e18 + 7;
vector<pair<long long, long long>> adj[MAXN];
vector<long long> v[MAXN];
long long p[MAXN], sz[MAXN], mp[2 * MAXN];
long long ans[MAXN];
long long n, m, k, q;
struct Edge {
  long long u, v, w;
};
vector<long long> djk() {
  vector<long long> dist(n);
  priority_queue<pair<long long, long long>, vector<pair<long long, long long>>,
                 greater<pair<long long, long long>>>
      pq;
  for (long long i = 0; i < n; i++) {
    if (i < k) {
      pq.push(pair<long long, long long>(0, i));
      dist[i] = 0;
    } else {
      dist[i] = INF;
    }
  }
  while (!pq.empty()) {
    long long d = pq.top().first, u = pq.top().second;
    pq.pop();
    if (dist[u] < d) continue;
    for (pair<long long, long long> x : adj[u]) {
      long long v = x.first, w = x.second;
      if (dist[v] > dist[u] + w) {
        dist[v] = dist[u] + w;
        pq.push(pair<long long, long long>(dist[v], v));
      }
    }
  }
  return dist;
}
long long find(long long a) {
  if (p[a] == a) return a;
  return p[a] = find(p[a]);
}
void merge(long long a, long long b, long long w) {
  a = find(a);
  b = find(b);
  if (a == b) return;
  if (sz[a] > sz[b]) swap(a, b);
  for (long long tk1 : v[a]) {
    long long tk2 = tk1 ^ 1;
    if (find(mp[tk2]) == b) {
      long long idx = tk1 / 2;
      ans[idx] = w;
    }
    v[b].push_back(tk1);
  }
  v[a].resize(0);
  sz[b] += sz[a];
  p[a] = b;
}
int32_t main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cin >> n >> m >> k >> q;
  for (long long i = 0; i < MAXN; i++) {
    p[i] = i;
    sz[i] = 1;
  }
  vector<Edge> edges;
  for (long long i = 0; i < m; i++) {
    long long u, v, w;
    cin >> u >> v >> w;
    u--;
    v--;
    adj[u].push_back(pair<long long, long long>(v, w));
    adj[v].push_back(pair<long long, long long>(u, w));
    edges.push_back({u, v, w});
  }
  vector<long long> dist = djk();
  for (long long i = 0; i < q; i++) {
    long long a, b;
    cin >> a >> b;
    a--;
    b--;
    long long tk1 = 2 * i, tk2 = tk1 + 1;
    mp[tk1] = a;
    mp[tk2] = b;
    v[a].push_back(tk1);
    v[b].push_back(tk2);
  }
  for (Edge &e : edges) {
    e.w += dist[e.u] + dist[e.v];
  }
  sort(edges.begin(), edges.end(), [](Edge a, Edge b) { return a.w < b.w; });
  for (long long i = 0; i < m; i++) {
    merge(edges[i].u, edges[i].v, edges[i].w);
  }
  for (long long i = 0; i < q; i++) {
    cout << ans[i] << '\n';
  }
  return 0;
}
