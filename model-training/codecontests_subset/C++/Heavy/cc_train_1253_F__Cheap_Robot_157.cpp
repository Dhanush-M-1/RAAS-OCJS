#include <bits/stdc++.h>
using namespace std;
const int N_MAX = 100002;
const int M_MAX = 300002;
const int Q_MAX = 300002;
const int W_MAX = 1000000001;
const long long INF = 1LL * M_MAX * W_MAX;
int n, m, k, q;
struct Edge {
  int u, v;
  long long w;
  int other(int node) { return this->u + this->v - node; }
};
bool operator<(const Edge &a, const Edge &b) { return a.w < b.w; }
Edge edges[M_MAX];
vector<Edge *> outEdges[N_MAX];
int qa[Q_MAX], qb[Q_MAX];
long long l[Q_MAX], r[Q_MAX], mid[Q_MAX];
int finish;
vector<pair<long long, int> > mids;
int root[N_MAX];
int find_root(int node) {
  if (root[node] == node) return node;
  return root[node] = find_root(root[node]);
}
void join(int u, int v) {
  u = find_root(u);
  v = find_root(v);
  if (u == v) return;
  root[u] = v;
}
long long d[N_MAX];
set<pair<long long, int> > s;
bool visited[N_MAX];
void dijkstra() {
  for (int i = 1; i <= k; i++) s.insert(make_pair(0, i));
  while (!s.empty()) {
    pair<long long, int> f = *s.begin();
    s.erase(s.begin());
    if (visited[f.second] == true) continue;
    visited[f.second] = true;
    d[f.second] = f.first;
    for (Edge *e : outEdges[f.second])
      if (visited[e->other(f.second)] == false)
        s.insert(make_pair(f.first + e->w, e->other(f.second)));
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> m >> k >> q;
  for (int i = 1; i <= m; i++) {
    cin >> edges[i].u >> edges[i].v >> edges[i].w;
    outEdges[edges[i].u].push_back(&edges[i]);
    outEdges[edges[i].v].push_back(&edges[i]);
  }
  for (int i = 1; i <= q; i++) cin >> qa[i] >> qb[i];
  for (int i = 1; i <= n; i++) d[i] = INF;
  dijkstra();
  long long mx = -1;
  for (int i = 1; i <= m; i++) {
    edges[i].w += d[edges[i].u] + d[edges[i].v];
    mx = max(mx, edges[i].w);
  }
  for (int i = 1; i <= q; i++) {
    l[i] = 0;
    r[i] = mx;
  }
  sort(edges + 1, edges + m + 1);
  while (finish < q) {
    mids.clear();
    for (int i = 1; i <= q; i++)
      if (l[i] < r[i]) {
        mid[i] = (l[i] + r[i]) / 2;
        mids.push_back(make_pair(mid[i], i));
      }
    sort(mids.begin(), mids.end());
    int pos = 0;
    for (int i = 1; i <= n; i++) root[i] = i;
    for (int i = 0; i < mids.size(); i++) {
      while (pos < m && edges[pos + 1].w <= mids[i].first) {
        pos++;
        join(edges[pos].u, edges[pos].v);
      }
      if (find_root(qa[mids[i].second]) == find_root(qb[mids[i].second]))
        r[mids[i].second] = mids[i].first;
      else
        l[mids[i].second] = mids[i].first + 1;
      if (l[mids[i].second] >= r[mids[i].second]) finish++;
    }
  }
  for (int i = 1; i <= q; i++) cout << l[i] << "\n";
  return 0;
}
