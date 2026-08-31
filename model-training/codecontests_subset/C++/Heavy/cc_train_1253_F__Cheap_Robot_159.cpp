#include <bits/stdc++.h>
using namespace std;
const long long inf = 1e18;
const long long INF = 1e18;
const int md = 1e9 + 7;
const int N = 3e5 + 1;
struct edge {
  int v, u;
  long long w;
  edge() {}
  edge(int v, long long w, int u = -1) : v(v), w(w), u(u) {}
};
vector<edge> g[N];
int p[N];
long long ANS[N];
vector<pair<int, int>> Q[N];
void make(int v) { p[v] = v; }
void add_q(int a, int b, int num) {
  Q[a].push_back({b, num});
  Q[b].push_back({a, num});
}
int fin(int v) {
  if (p[v] == v) return v;
  return p[v] = fin(p[v]);
}
void un(int a, int b, long long W) {
  a = fin(a), b = fin(b);
  if (a == b) return;
  if ((int)(Q[a]).size() < (int)(Q[b]).size()) swap(a, b);
  for (auto u : Q[b]) {
    if (fin(u.first) == a)
      ANS[u.second] = W;
    else
      Q[a].push_back(u);
  }
  p[b] = a;
}
signed main() {
  ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  int n, m, k, q;
  cin >> n >> m >> k >> q;
  vector<edge> edges(m);
  for (int f = 0; f < m; ++f) {
    int u, v, w;
    cin >> u >> v >> w;
    --u, --v;
    g[v].push_back(edge{u, w});
    g[u].push_back(edge{v, w});
    edges[f] = edge{u, w, v};
  }
  vector<long long> d(n, inf);
  auto cmp = [&](int a, int b) { return d[a] < d[b]; };
  priority_queue<pair<long long, int>> DJ;
  for (int f = 0; f < k; ++f) {
    d[f] = 0;
    DJ.push({d[f], f});
  }
  while (!DJ.empty()) {
    int head = DJ.top().second;
    DJ.pop();
    for (auto u : g[head]) {
      if (d[u.v] > d[head] + u.w) {
        d[u.v] = d[head] + u.w;
        DJ.push({-d[u.v], u.v});
      }
    }
  }
  for (int f = 0; f < m; ++f) edges[f].w += d[edges[f].u] + d[edges[f].v];
  vector<int> perm(m);
  for (int i = 0; i < m; ++i) perm[i] = i;
  sort(perm.begin(), perm.end(),
       [&](int a, int b) { return edges[a].w < edges[b].w; });
  for (int f = 0; f < n; ++f) make(f);
  for (int i = 0; i < q; ++i) {
    int a, b;
    cin >> a >> b;
    --a, --b;
    add_q(a, b, i);
  }
  for (int f = 0; f < m; ++f) {
    int curr = perm[f];
    un(edges[curr].u, edges[curr].v, edges[curr].w);
  }
  for (int f = 0; f < q; ++f) cout << ANS[f] << '\n';
  return 0;
}
