#include <bits/stdc++.h>
using namespace std;
const int INF = 0x3f3f3f3f;
struct Edge {
  int src, dst, rev;
  int weight;
  Edge(int src, int dst, int weight = 1, int rev = -1)
      : src(src), dst(dst), weight(weight), rev(rev) {}
};
bool operator<(const Edge &e, const Edge &f) {
  return e.weight != f.weight ? e.weight > f.weight
         : e.src != f.src     ? e.src < f.src
                              : e.dst < f.dst;
}
void addBiEdge(vector<vector<Edge> > &g, int from, int to, int w = 1) {
  while (g.size() < max(from, to) + 1) g.push_back(vector<Edge>());
  g[from].push_back(Edge(from, to, w, g[to].size()));
  g[to].push_back(Edge(to, from, w, g[from].size() - 1));
}
void addEdge(vector<vector<Edge> > &g, int from, int to, int w = 1) {
  while (g.size() < from + 1) g.push_back(vector<Edge>());
  g[from].push_back(Edge(from, to, w));
}
struct IO {
} io;
IO &operator>>(IO &io, int &n) {
  scanf("%d", &n);
  return io;
}
IO &operator>>(IO &io, unsigned int &n) {
  scanf("%u", &n);
  return io;
}
IO &operator>>(IO &io, long long &n) {
  scanf("%lld", &n);
  return io;
}
IO &operator>>(IO &io, unsigned long long &n) {
  scanf("%llu", &n);
  return io;
}
IO &operator>>(IO &io, double &n) {
  scanf("%lf", &n);
  return io;
}
IO &operator>>(IO &io, long double &n) {
  scanf("%Lf", &n);
  return io;
}
IO &operator>>(IO &io, char *c) {
  scanf("%s", c);
  return io;
}
IO &operator<<(IO &io, const int &n) {
  printf("%d", n);
  return io;
}
IO &operator<<(IO &io, const unsigned int &n) {
  printf("%u", n);
  return io;
}
IO &operator<<(IO &io, const long long &n) {
  printf("%lld", n);
  return io;
}
IO &operator<<(IO &io, const unsigned long long &n) {
  printf("%llu", n);
  return io;
}
IO &operator<<(IO &io, const double &n) {
  printf("%lf", n);
  return io;
}
IO &operator<<(IO &io, const long double &n) {
  printf("%Lf", n);
  return io;
}
IO &operator<<(IO &io, const char c[]) {
  printf("%s", c);
  return io;
}
template <class T>
IO &operator>>(IO &io, vector<T> &v) {
  int n;
  scanf("%d", &n);
  for (int i = 0; i < (int)(n); ++i) {
    T t;
    io >> t;
    v.push_back(t);
  }
}
int n;
vector<vector<Edge> > g;
int parent[3010], dist[3010], cparent[3010], cdist[3010];
int cycle_pos[3010];
bool vis[3010];
vector<int> v[3010];
vector<int> c;
void find_cycle(int u = 0, int d = 0, int p = -1) {
  if (vis[u]) {
    int p0 = p, p1 = parent[u];
    vector<int> c0, c1;
    while (p0 != p1) {
      if (dist[p0] > dist[p1]) {
        c0.push_back(p0);
        p0 = parent[p0];
      } else {
        c1.push_back(p1);
        p1 = parent[p1];
      }
    }
    reverse((c1).begin(), (c1).end());
    c.clear();
    c.push_back(u);
    c.insert(c.end(), (c0).begin(), (c0).end());
    c.push_back(p0);
    c.insert(c.end(), (c1).begin(), (c1).end());
    return;
  }
  vis[u] = true;
  parent[u] = p;
  dist[u] = d;
  for (typeof((g[u]).begin()) e = (g[u]).begin(); e != (g[u]).end(); ++e) {
    if (e->dst == p) continue;
    find_cycle(e->dst, d + 1, u);
  }
}
double ans = 0.0L;
void dfs(int u, int anc, int p = -1, int d = 0) {
  cparent[u] = anc;
  cdist[u] = d;
  for (typeof((g[u]).begin()) e = (g[u]).begin(); e != (g[u]).end(); ++e) {
    if (e->dst == p or cycle_pos[e->dst] >= 0) continue;
    dfs(e->dst, anc, u, d + 1);
  }
}
void dfs2(int u, int anc, int p = -1, int d = 0) {
  ans += 1 / (double)(d + 1);
  for (typeof((g[u]).begin()) e = (g[u]).begin(); e != (g[u]).end(); ++e) {
    if (e->dst == p or (cycle_pos[e->dst] >= 0 and e->dst != anc)) continue;
    dfs2(e->dst, anc, u, d + 1);
  }
}
int main() {
  io >> n;
  g.assign(n, vector<Edge>());
  for (int i = 0; i < (int)(n); ++i) {
    int a, b;
    io >> a >> b;
    addBiEdge(g, a, b);
  }
  memset((vis), 0, sizeof(vis));
  memset((cycle_pos), -1, sizeof(cycle_pos));
  find_cycle();
  for (int i = 0; i < (int)(c.size()); ++i) cycle_pos[c[i]] = i;
  for (int i = 0; i < (int)(c.size()); ++i) dfs(c[i], c[i]);
  for (int u = 0; u < (int)(n); ++u) {
    int u0 = cparent[u];
    for (int v = 0; v < (int)(n); ++v) {
      int v0 = cparent[v];
      if (u0 == v0) continue;
      int A = abs(cycle_pos[u0] - cycle_pos[v0]), B = c.size() - A;
      A--;
      B--;
      int s = cdist[u] + cdist[v] + c.size();
      ans += 1 / (double)(s - A) + 1 / (double)(s - B) - 1 / (double)s;
    }
  }
  for (int u = 0; u < (int)(n); ++u) dfs2(u, cparent[u]);
  printf("%.10lf\n", ans);
}
