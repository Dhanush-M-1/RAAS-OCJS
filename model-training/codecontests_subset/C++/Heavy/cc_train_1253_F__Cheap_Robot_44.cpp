#include <bits/stdc++.h>
using namespace std;
struct E {
  long long w;
  int to, from;
};
const long long INF = 1e18;
const int N = 2e5 + 5;
vector<E> g[N];
int anime[N], from[N];
long long dist[N], ans[N];
set<int> st[N];
int findSet(int x) { return anime[x] < 0 ? x : anime[x] = findSet(anime[x]); }
void un(int a, int b, long long w) {
  a = findSet(a);
  b = findSet(b);
  if (a == b) return;
  if (anime[a] > anime[b]) swap(a, b);
  anime[a] += anime[b];
  anime[b] = a;
  for (int x : st[b]) {
    if (st[a].count(x)) {
      st[a].erase(x);
      ans[x] = w;
    } else {
      st[a].insert(x);
    }
  }
}
signed main() {
  ios_base::sync_with_stdio(0);
  cin.tie(NULL);
  int n, m, k, q;
  cin >> n >> m >> k >> q;
  for (int i = 0; i < m; i++) {
    int a, b, w;
    cin >> a >> b >> w;
    a--, b--;
    g[a].push_back({w, b, a});
    g[b].push_back({w, a, b});
  }
  fill(from, from + n, -1);
  fill(dist, dist + n, INF);
  priority_queue<pair<long long, int>, vector<pair<long long, int>>,
                 greater<pair<long long, int>>>
      pq;
  for (int i = 0; i < k; i++) {
    anime[i] = -1;
    dist[i] = 0;
    from[i] = i;
    pq.push({0, i});
  }
  for (int i = 0; i < q; i++) {
    int x, y;
    cin >> x >> y;
    x--, y--;
    st[x].insert(i);
    st[y].insert(i);
  }
  while (!pq.empty()) {
    int node = pq.top().second;
    long long cd = pq.top().first;
    pq.pop();
    if (cd != dist[node]) {
      continue;
    }
    for (E e : g[node]) {
      if (dist[e.to] > dist[node] + e.w) {
        dist[e.to] = dist[node] + e.w;
        from[e.to] = from[node];
        pq.push({dist[e.to], e.to});
      }
    }
  }
  vector<E> edges;
  for (int i = 0; i < n; i++) {
    for (E e : g[i]) {
      if (e.to > i && from[e.to] != from[i])
        edges.push_back({dist[e.to] + dist[i] + e.w, from[i], from[e.to]});
    }
  }
  sort(edges.begin(), edges.end(),
       [](const E &a, const E &b) { return a.w < b.w; });
  for (E e : edges) {
    un(e.to, e.from, e.w);
  }
  for (int i = 0; i < q; i++) {
    cout << ans[i] << "\n";
  }
  return 0;
}
