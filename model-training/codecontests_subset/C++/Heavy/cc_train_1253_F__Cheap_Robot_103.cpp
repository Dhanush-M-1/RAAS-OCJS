#include <bits/stdc++.h>
using namespace std;
struct ed {
  long long u;
  long long v;
  long long cost;
  bool operator<(const ed &e) const { return cost < e.cost; }
};
int n, m, k, q;
long long dist[300004];
int tin[300004], tout[300004], cnt, f[300004], sz[300004];
vector<ed> edges;
vector<pair<long long, long long> > graph[300004];
vector<pair<long long, long long> > mst[300004];
int par[300004][30];
long long wei[300004][30];
int fath(int x) { return (f[x] == x) ? x : fath(f[x]); }
bool is_same_set(int x, int y) {
  int fx = fath(x);
  int fy = fath(y);
  return fx == fy;
}
void join(int x, int y) {
  int fx = fath(x);
  int fy = fath(y);
  if (sz[fy] < sz[fx]) swap(fx, fy);
  sz[fy] += sz[fx];
  f[fx] = fy;
  return;
}
void dijkstra() {
  for (int i = k + 1; i < n + 1; i++) dist[i] = 1e18;
  priority_queue<pair<long long, long long> > pq;
  for (int i = 1; i < k + 1; i++) pq.push(make_pair(0, i));
  while (!pq.empty()) {
    pair<long long, long long> cur = pq.top();
    pq.pop();
    cur.first *= -1;
    if (cur.first > dist[cur.second]) continue;
    for (int i = 0; i < graph[cur.second].size(); i++) {
      int v = graph[cur.second][i].first;
      long long c = graph[cur.second][i].second;
      if (dist[v] > cur.first + c) {
        dist[v] = cur.first + c;
        pq.push(make_pair(-dist[v], v));
      }
    }
  }
  return;
}
void init(int cur, int p) {
  par[cur][0] = p;
  tin[cur] = cnt++;
  for (int i = 0; i < mst[cur].size(); i++) {
    int v = mst[cur][i].first;
    long long c = mst[cur][i].second;
    if (v == p) continue;
    wei[v][0] = c;
    init(v, cur);
  }
  tout[cur] = cnt;
  return;
}
bool is_ancestor(int x, int y) {
  return (tin[x] <= tin[y] && tout[x] >= tout[y]);
}
int get_par(int node, int p) {
  if (par[node][p] != -1) return par[node][p];
  return par[node][p] = get_par(get_par(node, p - 1), p - 1);
}
long long get_wei(int node, int p) {
  if (wei[node][p] != -1) return wei[node][p];
  return wei[node][p] =
             max(get_wei(get_par(node, p - 1), p - 1), get_wei(node, p - 1));
}
int get_lca(int x, int y) {
  if (is_ancestor(x, y)) return x;
  if (is_ancestor(y, x)) return y;
  for (int i = 29; i >= 0; i--) {
    if (!is_ancestor(get_par(x, i), y)) x = get_par(x, i);
  }
  return get_par(x, 0);
}
long long solve(int x, int y) {
  int lca = get_lca(x, y);
  long long ans = 0;
  for (int i = 29; i >= 0; i--) {
    if (!is_ancestor(get_par(x, i), lca)) {
      ans = max(ans, get_wei(x, i));
      x = get_par(x, i);
    }
  }
  if (!is_ancestor(x, lca)) ans = max(ans, get_wei(x, 0));
  for (int i = 29; i >= 0; i--) {
    if (!is_ancestor(get_par(y, i), lca)) {
      ans = max(ans, get_wei(y, i));
      y = get_par(y, i);
    }
  }
  if (!is_ancestor(y, lca)) ans = max(ans, get_wei(y, 0));
  return ans;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cin >> n >> m >> k >> q;
  for (int i = 0; i < m; i++) {
    int a, b;
    long long c;
    cin >> a >> b >> c;
    graph[a].push_back(make_pair(b, c));
    graph[b].push_back(make_pair(a, c));
  }
  dijkstra();
  for (int i = 1; i < n + 1; i++) {
    for (int j = 0; j < graph[i].size(); j++) {
      long long v = graph[i][j].first;
      if (v < i) continue;
      edges.push_back({i, v, dist[i] + dist[v] + graph[i][j].second});
    }
  }
  sort(edges.begin(), edges.end());
  for (int i = 1; i < n + 1; i++) {
    sz[i] = 1;
    f[i] = i;
  }
  for (int i = 0; i < edges.size(); i++) {
    int u = edges[i].u;
    int v = edges[i].v;
    long long cost = edges[i].cost;
    if (!is_same_set(u, v)) {
      join(u, v);
      mst[u].push_back(make_pair(v, cost));
      mst[v].push_back(make_pair(u, cost));
    }
  }
  memset(par, -1, sizeof par);
  memset(wei, -1, sizeof wei);
  wei[1][0] = 0;
  init(1, 1);
  for (int i = 0; i < q; i++) {
    long long a, b;
    cin >> a >> b;
    cout << solve(a, b) << "\n";
  }
  return 0;
}
