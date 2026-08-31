#include <bits/stdc++.h>
using namespace std;
using ll = long long;
const int N = 6e5 + 10, LG = 21;
int n, m, k, t;
int p[N], in[N], out[N], L[N][LG];
vector<vector<int>> tree(N, vector<int>());
int find_set(int x) { return x == p[x] ? x : p[x] = find_set(p[x]); }
void add_edge(int u, int v) {
  tree[u].push_back(v);
  tree[v].push_back(u);
}
void dfs(int x, int p) {
  static int timer = 0;
  in[x] = ++timer;
  if (~p) L[x][0] = p;
  for (int i = 1; i < LG; ++i) {
    L[x][i] = L[L[x][i - 1]][i - 1];
  }
  for (int to : tree[x]) {
    if (to != p) {
      dfs(to, x);
    }
  }
  out[x] = ++timer;
}
bool isAnc(int x, int y) { return !x || (in[x] <= in[y] && out[x] >= out[y]); }
int LCA(int x, int y) {
  if (isAnc(x, y)) return x;
  if (isAnc(y, x)) return y;
  for (int i = LG - 1; i >= 0; --i) {
    if (!isAnc(L[x][i], y)) {
      x = L[x][i];
    }
  }
  return L[x][0];
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cin >> n >> m >> k >> t;
  vector<vector<pair<int, int>>> edges(n + 1, vector<pair<int, int>>());
  for (int i = 1; i <= m; ++i) {
    int u, v, w;
    cin >> u >> v >> w;
    edges[u].push_back({v, w});
    edges[v].push_back({u, w});
  }
  priority_queue<vector<ll>> q;
  for (int i = 1; i <= k; ++i) {
    q.push(vector<ll>{0, i, i});
  }
  vector<bool> vis(n + 1);
  vector<ll> dist(n + 1), cent(n + 1);
  while (!q.empty()) {
    vector<ll> p = q.top();
    q.pop();
    ll distance = -p[0];
    ll cur_vertex = p[1];
    ll central = p[2];
    if (vis[cur_vertex]) continue;
    vis[cur_vertex] = 1;
    dist[cur_vertex] = distance;
    cent[cur_vertex] = central;
    for (pair<int, int> p : edges[cur_vertex]) {
      vector<ll> next = {-distance - p.second, p.first,
                         p.first <= k ? p.first : central};
      q.push(next);
    }
  }
  vector<vector<ll>> v;
  for (int i = 1; i <= n; ++i) {
    for (pair<int, int> p : edges[i]) {
      int to = p.first;
      if (cent[i] != cent[to]) {
        v.push_back(
            vector<ll>{dist[i] + dist[to] + p.second, cent[i], cent[to]});
      }
    }
  }
  sort(v.begin(), v.end());
  for (int i = 0; i < N; ++i) p[i] = i;
  int fake = n + 1;
  vector<ll> weight;
  for (vector<ll> edge : v) {
    int u = edge[1];
    int v = edge[2];
    ll cost = edge[0];
    u = find_set(u);
    v = find_set(v);
    if (u == v) continue;
    weight.push_back(cost);
    add_edge(u, fake);
    add_edge(v, fake);
    p[u] = p[v] = fake;
    ++fake;
  }
  dfs(fake - 1, -1);
  for (int i = 0; i < t; ++i) {
    int a, b;
    cin >> a >> b;
    int th = LCA(a, b) - n - 1;
    cout << weight[th] << '\n';
  }
}
