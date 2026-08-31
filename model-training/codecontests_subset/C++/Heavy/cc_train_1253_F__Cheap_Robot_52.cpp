#include <bits/stdc++.h>
using namespace std;
long long n, m, k, q;
vector<vector<pair<long long, long long>>> graph;
vector<vector<pair<long long, long long>>> tree;
vector<vector<long long>> edges;
void dijkstra() {
  vector<long long> dist(n, 1e18);
  vector<int> used(n, 0);
  vector<int> prev(n, -1);
  priority_queue<vector<long long>> q;
  for (long long i = 0; i < k; i++) {
    dist[i] = 0;
    q.push({-dist[i], i});
    prev[i] = i;
  }
  while (q.size()) {
    long long v = q.top()[1];
    q.pop();
    if (used[v]) continue;
    used[v] = 1;
    for (auto e : graph[v]) {
      if (dist[e.first] > dist[v] + e.second) {
        prev[e.first] = prev[v];
        dist[e.first] = dist[v] + e.second;
        q.push({-dist[e.first], e.first});
      }
      if (prev[v] - prev[e.first])
        edges.push_back(
            {prev[v], prev[e.first], dist[e.first] + dist[v] + e.second});
    }
  }
}
vector<int> p;
vector<int> sz;
int get(int a) {
  if (a == p[a]) return a;
  return p[a] = get(p[a]);
}
void unite(int a, int b) {
  a = get(a);
  b = get(b);
  if (a == b) return;
  if (sz[a] < sz[b]) swap(a, b);
  sz[a] += sz[b];
  p[b] = a;
}
bool comp(vector<long long> &a, vector<long long> &b) { return (a[2] < b[2]); }
int t = 0, len = 20;
vector<int> tin;
vector<int> tout;
vector<vector<int>> up;
vector<vector<long long>> mx;
void dfs(long long v, long long p) {
  tin[v] = t++;
  up[0][v] = p;
  for (long long i = 1; i < len; i++) {
    up[i][v] = up[i - 1][up[i - 1][v]];
    mx[i][v] = max(mx[i - 1][v], mx[i - 1][up[i - 1][v]]);
  }
  for (auto h : tree[v]) {
    if (h.first == p) continue;
    mx[0][h.first] = h.second;
    dfs(h.first, v);
  }
  tout[v] = t++;
}
int isancestor(long long a, long long b) {
  return (tin[a] <= tin[b] and tout[b] <= tout[a]);
}
int getlca(long long a, long long b) {
  if (isancestor(a, b)) return a;
  if (isancestor(b, a)) return b;
  for (long long i = len - 1; i >= 0; i--) {
    if (!isancestor(up[i][a], b)) a = up[i][a];
  }
  return up[0][a];
}
long long getmx(long long a, long long b) {
  if (a == b) return 0;
  long long ans = 0;
  for (long long i = len - 1; i >= 0; i--) {
    if (!isancestor(up[i][a], b)) {
      ans = max(ans, mx[i][a]);
      a = up[i][a];
    }
  }
  return max(ans, mx[0][a]);
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> m >> k >> q;
  graph.assign(n, vector<pair<long long, long long>>());
  for (long long i = 0; i < m; i++) {
    long long a, b, w;
    cin >> a >> b >> w;
    a--;
    b--;
    graph[a].push_back({b, w});
    graph[b].push_back({a, w});
  }
  dijkstra();
  p.assign(k, 0);
  sz.assign(k, 1);
  tree.assign(k, vector<pair<long long, long long>>());
  for (long long i = 0; i < k; i++) p[i] = i;
  sort(edges.begin(), edges.end(), comp);
  for (auto e : edges) {
    if (get(e[0]) == get(e[1])) continue;
    tree[e[0]].push_back({e[1], e[2]});
    tree[e[1]].push_back({e[0], e[2]});
    unite(e[0], e[1]);
  }
  up.assign(len, vector<int>(k, 0));
  mx.assign(len, vector<long long>(k, 0));
  tin.assign(k, 0);
  tout.assign(k, 0);
  dfs(0, 0);
  for (q; q; q--) {
    int a, b;
    cin >> a >> b;
    a--;
    b--;
    int lca = getlca(a, b);
    long long ans = max(getmx(a, lca), getmx(b, lca));
    cout << ans << '\n';
  }
}
