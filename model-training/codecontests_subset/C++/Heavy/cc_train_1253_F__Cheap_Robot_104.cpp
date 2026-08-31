#include <bits/stdc++.h>
using namespace std;
const int INF = 1e9 + 5;
const int MOD = 1e9 + 7;
const int MAXN = 300005;
struct Edge {
  int u, v;
  long long w;
  bool operator<(const Edge &e) const { return w > e.w; }
};
int N, M, K, Q, vis[MAXN];
long long ans[MAXN], dist[MAXN];
vector<Edge> es, G[MAXN];
int pa[MAXN], sz[MAXN], root1[MAXN], root2[MAXN];
vector<int> qid[MAXN];
void init() {
  for (int i = 1; i <= N; i++) {
    pa[i] = i;
    sz[i] = 1;
  }
}
int find_root(int x) { return x == pa[x] ? x : pa[x] = find_root(pa[x]); }
void merge(Edge e) {
  int u = find_root(e.u), v = find_root(e.v);
  if (u == v) return;
  if (sz[u] < sz[v]) swap(u, v);
  pa[v] = u;
  sz[u] += sz[v];
  for (int q : qid[v]) {
    if (root1[q] == u || root2[q] == u) {
      root1[q] = root2[q] = -1;
      ans[q] = e.w;
    } else if (root1[q] != -1) {
      if (root1[q] == v) root1[q] = u;
      if (root2[q] == v) root2[q] = u;
      qid[u].push_back(q);
    }
  }
  qid[v].clear();
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin >> N >> M >> K >> Q;
  for (int i = 0; i < M; i++) {
    int u, v, w;
    cin >> u >> v >> w;
    es.push_back({u, v, w});
    G[u].push_back({u, v, w});
    G[v].push_back({v, u, w});
  }
  priority_queue<Edge> pq;
  for (int i = 1; i <= K; i++) {
    pq.push({-1, i, 0});
  }
  while (!pq.empty()) {
    Edge e = pq.top();
    pq.pop();
    if (vis[e.v]) continue;
    vis[e.v] = 1;
    dist[e.v] = e.w;
    for (Edge e2 : G[e.v]) {
      if (!vis[e2.v]) {
        pq.push({-1, e2.v, e.w + e2.w});
      }
    }
  }
  for (int i = 0; i < Q; i++) {
    int u, v;
    cin >> u >> v;
    qid[u].push_back(i);
    qid[v].push_back(i);
    root1[i] = u;
    root2[i] = v;
  }
  for (Edge &e : es) {
    e.w += dist[e.u] + dist[e.v];
  }
  sort(es.begin(), es.end());
  init();
  for (int i = (int)es.size() - 1; i >= 0; i--) {
    merge(es[i]);
  }
  for (int i = 0; i < Q; i++) {
    cout << ans[i] << "\n";
  }
  return 0;
}
