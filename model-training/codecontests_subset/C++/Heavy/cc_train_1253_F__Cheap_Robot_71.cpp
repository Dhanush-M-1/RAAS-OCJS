#include <bits/stdc++.h>
using namespace std;
long long n, m, x, y, k, q, z, dist[100020], ans[300005], p[100005],
    src[100020];
vector<pair<long long, long long>> adj[100005];
set<long long> s[100020];
vector<pair<long long, pair<long long, long long>>> edges;
void dijkstra() {
  priority_queue<pair<long long, pair<long long, long long>>,
                 vector<pair<long long, pair<long long, long long>>>,
                 greater<pair<long long, pair<long long, long long>>>>
      pq;
  for (int i = 1; i <= k; ++i) pq.push({0, {i, i}});
  for (int i = 1; i <= n; ++i) dist[i] = 1e16;
  while (pq.size()) {
    int u = pq.top().second.first, sorc = pq.top().second.second;
    long long w = pq.top().first;
    pq.pop();
    if (dist[u] < w) continue;
    dist[u] = w, src[u] = sorc;
    for (auto i : adj[u]) {
      if (dist[u] + i.second >= dist[i.first]) continue;
      pq.push({dist[u] + i.second, {i.first, sorc}});
    }
  }
}
int fnd(int i) {
  if (p[i] == i) return i;
  return p[i] = fnd(p[i]);
}
void uni(int i, int j, long long w) {
  i = fnd(i), j = fnd(j);
  if (i == j) return;
  ;
  if (s[i].size() > s[j].size()) swap(i, j);
  p[i] = j;
  for (auto u : s[i]) {
    if (s[j].count(u))
      s[j].erase(u), ans[u] = w;
    else
      s[j].insert(u);
  }
  s[i].clear();
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  cin >> n >> m >> k >> q;
  for (int i = 0; i < m; ++i)
    cin >> x >> y >> z, adj[x].push_back({y, z}), adj[y].push_back({x, z});
  dijkstra();
  for (int i = 1; i <= n; p[i] = i, ++i)
    for (auto j : adj[i])
      if (src[i] != src[j.first])
        edges.push_back(
            {dist[i] + dist[j.first] + j.second, {src[i], src[j.first]}});
  for (int i = 0; i < q; ++i) cin >> x >> y, s[x].insert(i), s[y].insert(i);
  sort(edges.begin(), edges.end());
  for (auto i : edges) uni(i.second.first, i.second.second, i.first);
  for (int i = 0; i < q; ++i) cout << ans[i] << endl;
}
