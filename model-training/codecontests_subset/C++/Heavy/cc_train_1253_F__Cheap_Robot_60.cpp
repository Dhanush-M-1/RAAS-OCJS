#include <bits/stdc++.h>
using namespace std;
const int maxn = (int)1e5 + 100;
const int mod = (int)1e9 + 7;
const long long INF = (long long)1ll << 61;
int n, m, k, q, fa[maxn];
long long dis[maxn], ans[maxn * 6];
vector<pair<int, long long> > g[maxn * 6];
vector<pair<int, int> > que[maxn];
vector<tuple<long long, int, int> > e;
set<int> ele[maxn];
void dij() {
  priority_queue<pair<long long, int>, vector<pair<long long, int> >,
                 greater<pair<long long, int> > >
      Q;
  for (int i = (1); i <= (n); ++i) {
    if (i <= k)
      Q.push({0, i});
    else
      dis[i] = INF;
  }
  while (!Q.empty()) {
    int u = Q.top().second, d = Q.top().first;
    Q.pop();
    if (d > dis[u]) continue;
    for (auto [v, w] : g[u]) {
      if (dis[u] + w < dis[v]) {
        dis[v] = dis[u] + w;
        Q.push({dis[v], v});
      }
    }
  }
}
void init() {
  for (int i = (1); i <= (n); ++i) fa[i] = i, ele[i].insert(i);
}
int find(int x) { return x == fa[x] ? x : fa[x] = find(fa[x]); }
int main() {
  scanf("%d%d%d%d", &n, &m, &k, &q);
  for (int i = (1); i <= (m); ++i) {
    int u, v;
    long long w;
    scanf("%d%d%lld", &u, &v, &w);
    g[u].push_back({v, w});
    g[v].push_back({u, w});
  }
  dij();
  for (int u = (1); u <= (n); ++u)
    for (auto [v, w] : g[u])
      if (u < v) e.push_back({dis[u] + dis[v] + w, u, v});
  sort(e.begin(), e.end());
  for (int i = (1); i <= (q); ++i) {
    int u, v;
    scanf("%d%d", &u, &v);
    que[u].push_back({v, i});
    que[v].push_back({u, i});
  }
  init();
  for (auto [w, x, y] : e) {
    x = find(x);
    y = find(y);
    if (x == y) continue;
    if (ele[x].size() < ele[y].size()) swap(x, y);
    fa[y] = x;
    for (auto u : ele[y])
      for (auto [v, id] : que[u])
        if (ele[x].count(v)) ans[id] = w;
    for (auto u : ele[y]) ele[x].insert(u);
  }
  for (int i = (1); i <= (q); ++i) printf("%lld\n", ans[i]);
}
