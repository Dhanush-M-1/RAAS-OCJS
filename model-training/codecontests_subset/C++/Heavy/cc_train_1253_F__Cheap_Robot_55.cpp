#include <bits/stdc++.h>
using namespace std;
const int maxn = 100007;
const int maxq = 300007;
vector<int> head[maxn];
int n, m, q, k;
struct rev {
  int from;
  int to;
  long long we;
  rev(int uu = 0, int vv = 0, long long ww = -1) {
    from = uu, to = vv, we = ww;
  }
  bool operator<(const rev& b) const {
    if (we != b.we) return we < b.we;
    if (to != b.to) return to < b.to;
    return from < b.from;
  }
};
vector<rev> edge;
int id[maxq << 1];
long long ans[maxq << 1];
inline void add_edge(int u, int v, int w) {
  head[u].push_back(edge.size()), edge.push_back(rev(u, v, w));
}
vector<int> has[maxn];
int fa[maxn];
int sz[maxn];
int fd(int x) {
  while (fa[x] != x) x = fa[x];
  return x;
}
void merge(int x, int y, long long slack) {
  int fx, fy;
  fx = fd(x), fy = fd(y);
  if (fx == fy) return;
  if (sz[fx] > sz[fy]) swap(fx, fy);
  fa[fx] = fy, sz[fy] += sz[fx];
  for (auto o : has[fx]) {
    has[fy].push_back(o);
    if (fd(id[o ^ 1]) == fy) {
      if (ans[min(o, o ^ 1)] == -1) ans[min(o, o ^ 1)] = slack;
    }
  }
}
long long dis[maxn];
void dij() {
  priority_queue<pair<long long, int>, vector<pair<long long, int> >,
                 greater<pair<long long, int> > >
      q;
  for (int i = (1); i <= (n); ++i) {
    if (i <= k)
      q.push({0LL, i});
    else
      dis[i] = -1;
  }
  while (!q.empty()) {
    auto tp = q.top();
    q.pop();
    int u = tp.second;
    long long slack = tp.first;
    if (slack != dis[u]) continue;
    for (auto i : head[u]) {
      auto e = edge[i];
      int v = e.to;
      long long we = e.we;
      if (dis[v] == -1 || we + slack < dis[v])
        dis[v] = we + slack, q.push({dis[v], v});
    }
  }
}
int main(void) {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cin >> n >> m >> k >> q;
  for (int i = (0); i < (m); ++i) {
    int u, v, w;
    cin >> u >> v >> w;
    add_edge(u, v, w), add_edge(v, u, w);
  }
  int now = 0;
  for (int i = (0); i < (q); ++i) {
    int a, b;
    cin >> a >> b;
    has[a].push_back(now), has[b].push_back(now + 1);
    id[now++] = a, id[now++] = b;
  }
  for (int i = (0); i < (2 * q); ++i) ans[i] = -1;
  dij();
  vector<rev> es;
  for (int i = 0; i < 2 * m; i += 2) {
    auto e = edge[i];
    int u, v;
    u = e.from, v = e.to;
    long long we = dis[u] + dis[v] + e.we;
    es.push_back(rev(u, v, we));
  }
  sort((es).begin(), (es).end());
  for (int i = (1); i <= (n); ++i) {
    fa[i] = i, sz[i] = 1;
  }
  for (auto e : es) merge(e.from, e.to, e.we);
  for (int i = 0; i < 2 * q; i += 2) cout << ans[i] << "\n";
  return 0;
}
