#include <bits/stdc++.h>
using namespace std;
const long long N = 1e5 + 10, M = 10 * N;
const long long INF = 1e18;
long long n, m, k, q;
long long h[N], ht[N], e[M], ne[M], w[M], idx;
long long fa[N];
long long fat[N][25], depth[N], d[N][25];
long long dist[N];
bool st[N];
vector<pair<long long, pair<long long, long long>>> edge;
void add(long long h[], long long a, long long b, long long c) {
  e[idx] = b, w[idx] = c, ne[idx] = h[a], h[a] = idx++;
}
long long find(long long x) {
  if (fa[x] == x) return x;
  return fa[x] = find(fa[x]);
}
void dijkstra() {
  priority_queue<pair<long long, long long>, vector<pair<long long, long long>>,
                 greater<pair<long long, long long>>>
      heap;
  for (long long i = 1; i <= n; i++) {
    dist[i] = INF;
    fa[i] = i;
  }
  for (long long i = 1; i <= k; i++) {
    dist[i] = 0;
    heap.push({0, i});
  }
  while (heap.size()) {
    long long t = heap.top().second;
    heap.pop();
    if (st[t]) continue;
    st[t] = true;
    for (long long i = h[t]; ~i; i = ne[i]) {
      long long p = e[i];
      if (dist[p] > dist[t] + w[i]) {
        dist[p] = dist[t] + w[i];
        fa[p] = find(t);
        heap.push({dist[p], p});
      }
    }
  }
}
void build() {
  for (long long i = 1; i <= n; i++) {
    for (long long j = h[i]; ~j; j = ne[j]) {
      long long p = e[j];
      long long a = find(i);
      long long b = find(p);
      if (a == b) continue;
      edge.push_back({dist[i] + dist[p] + w[j], {a, b}});
    }
  }
  sort(edge.begin(), edge.end());
  for (auto x : edge) {
    long long a = x.second.first;
    long long b = x.second.second;
    if (find(a) == find(b)) continue;
    add(ht, a, b, x.first);
    add(ht, b, a, x.first);
    fa[find(a)] = find(b);
  }
}
void bfs(long long h[]) {
  queue<long long> q;
  q.push(1);
  memset(depth, 0x3f, sizeof depth);
  depth[0] = 0;
  depth[1] = 1;
  while (q.size()) {
    auto t = q.front();
    q.pop();
    for (long long i = h[t]; ~i; i = ne[i]) {
      long long p = e[i];
      if (depth[p] > depth[t] + 1) {
        depth[p] = depth[t] + 1;
        q.push(p);
        fat[p][0] = t;
        d[p][0] = w[i];
        for (long long j = 1; j <= 20; j++) {
          fat[p][j] = fat[fat[p][j - 1]][j - 1];
          d[p][j] = max(d[p][j - 1], d[fat[p][j - 1]][j - 1]);
        }
      }
    }
  }
}
long long lca(long long a, long long b) {
  long long res = 0;
  if (depth[a] < depth[b]) swap(a, b);
  for (long long i = 20; i >= 0; i--)
    if (depth[fat[a][i]] >= depth[b]) {
      res = max(res, d[a][i]);
      a = fat[a][i];
    }
  if (a == b) return res;
  for (long long i = 20; i >= 0; i--)
    if (fat[a][i] != fat[b][i]) {
      res = max(res, d[a][i]);
      res = max(res, d[b][i]);
      a = fat[a][i];
      b = fat[b][i];
    }
  res = max(res, d[a][0]);
  res = max(res, d[b][0]);
  return res;
}
signed main() {
  ios ::sync_with_stdio(false);
  cin.tie(0);
  memset(h, -1, sizeof h);
  memset(ht, -1, sizeof ht);
  cin >> n >> m >> k >> q;
  while (m--) {
    long long a, b, c;
    cin >> a >> b >> c;
    add(h, a, b, c);
    add(h, b, a, c);
  }
  dijkstra();
  build();
  bfs(ht);
  while (q--) {
    long long a, b;
    cin >> a >> b;
    cout << lca(a, b) << endl;
  }
  return 0;
}
