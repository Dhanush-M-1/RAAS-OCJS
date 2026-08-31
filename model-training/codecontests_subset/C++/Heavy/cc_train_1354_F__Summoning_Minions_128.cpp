#include <bits/stdc++.h>
using namespace std;
clock_t start;
mt19937_64 rng(chrono::system_clock::now().time_since_epoch().count());
template <typename T>
void _F(const char *name, T arg1) {
  cerr << name << " = " << arg1 << '\n';
}
template <typename T, typename... Args>
void _F(const char *names, T arg1, Args... args) {
  const char *name = strchr(names, ',');
  cerr.write(names, name - names) << " = " << arg1 << '\n';
  _F(name + 2, args...);
}
template <typename T1, typename T2>
istream &operator>>(istream &in, pair<T1, T2> &q) {
  in >> q.first >> q.second;
  return in;
}
template <typename T1, typename T2>
ostream &operator<<(ostream &out, pair<T1, T2> &q) {
  out << q.first << " " << q.second;
  return out;
}
template <typename T1, typename T2>
pair<T1, T2> operator+(pair<T1, T2> p1, pair<T1, T2> p2) {
  return {p1.first + p2.first, p1.second + p2.second};
}
template <typename T1, typename T2>
pair<T1, T2> operator-(pair<T1, T2> p1, pair<T1, T2> p2) {
  return {p1.first - p2.first, p1.second - p2.second};
}
const int N = 75 * 2 + 10;
struct MinCostFlow {
  struct Edge {
    int u, c, f;
    Edge *nex;
    Edge *rev;
    Edge(int _u, int _c, int _f, Edge *_nex) : u(_u), c(_c), f(_f), nex(_nex) {}
  };
  std::vector<Edge *> g;
  MinCostFlow() { g.resize(N); }
  void AddEdge(int v, int u, int f, int c) {
    g[v] = new Edge(u, c, f, g[v]);
    g[u] = new Edge(v, -c, 0, g[u]);
    g[v]->rev = g[u];
    g[u]->rev = g[v];
  }
  pair<int, int> Flow(int src, int sink) {
    int flow = 0, cost = 0;
    while (true) {
      std::vector<int> dis(N, (int)(2e9));
      std::vector<bool> vis(N, 0);
      std::vector<Edge *> par(N);
      std::vector<int> mn(N, 0);
      queue<int> q;
      q.push(src);
      vis[src] = 1;
      mn[src] = (int)(2e9);
      dis[src] = 0;
      while (!q.empty()) {
        int v = q.front();
        q.pop();
        vis[v] = 0;
        for (auto e = g[v]; e; e = e->nex) {
          if (e->f <= 0) continue;
          if (dis[e->u] > dis[v] + e->c) {
            dis[e->u] = dis[v] + e->c;
            mn[e->u] = min(mn[v], e->f);
            par[e->u] = e;
            if (!vis[e->u]) {
              vis[e->u] = 1;
              q.push(e->u);
            }
          }
        }
      }
      if (dis[sink] == (int)(2e9)) break;
      cost += dis[sink];
      int cur = sink;
      flow += mn[sink];
      while (cur != src) {
        Edge *e = par[cur];
        e->f -= mn[sink];
        e->rev->f += mn[sink];
        cur = e->rev->u;
      }
    }
    return make_pair(flow, cost);
  }
  int Find(int x) {
    for (auto e = g[x]; e; e = e->nex) {
      if (e->f == 1) {
        return e->u;
      }
    }
    return -1;
  }
  void Erase() {
    while ((int)((g).size())) g.pop_back();
    g.resize(N);
  }
} Mcf;
void solve() {
  int n, k;
  cin >> n >> k;
  int a[n], b[n];
  for (int i = 0; i < n; i++) {
    cin >> a[i] >> b[i];
  }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      if (j < k - 1)
        Mcf.AddEdge(n + i, j, 1, -a[i] - j * b[i]);
      else if (j < n - 1)
        Mcf.AddEdge(n + i, j, 1, -(k - 1) * b[i]);
      else
        Mcf.AddEdge(n + i, j, 1, -a[i] - (k - 1) * b[i]);
    }
    Mcf.AddEdge(i, N - 2, 1, 0);
    Mcf.AddEdge(N - 1, i + n, 1, 0);
  }
  Mcf.Flow(N - 1, N - 2);
  cout << k + (n - k) * 2 << '\n';
  for (int i = 0; i < k - 1; i++) {
    cout << Mcf.Find(i) - n + 1 << " ";
  }
  for (int i = k - 1; i < n - 1; i++) {
    cout << Mcf.Find(i) - n + 1 << " ";
    cout << -(Mcf.Find(i) - n + 1) << " ";
  }
  cout << (Mcf.Find(n - 1) - n + 1) << '\n';
  Mcf.Erase();
}
signed main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int t = 1;
  start = clock();
  cout << fixed << setprecision(20);
  cin >> t;
  for (int i = 1; i <= t; ++i) {
    solve();
  }
  return 0;
}
