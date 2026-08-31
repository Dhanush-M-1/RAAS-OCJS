#include <bits/stdc++.h>
template <typename Arg1>
void __f(const char* name, Arg1&& arg1) {
  std::cerr << name << " : " << arg1 << std::endl;
}
template <typename Arg1, typename... Args>
void __f(const char* names, Arg1&& arg1, Args&&... args) {
  const char* comma = strchr(names + 1, ',');
  std::cerr.write(names, comma - names) << " : " << arg1 << " | ";
  __f(comma + 1, args...);
}
using namespace std;
const int N = 200001;
const int LN = 20;
struct T {
  int u, v;
  int64_t c;
  bool operator<(const T& a) const { return c > a.c; }
};
struct E {
  int u;
  int64_t c;
  bool operator<(const E& a) const { return c < a.c; }
} d[N];
unordered_map<int, unordered_map<int, int64_t>> mp;
vector<E> gr[N], tr[N];
E st[N][LN];
int p[N], dep[N];
bool v[N];
void dfs(int node, int p, int64_t c, int depth) {
  dep[node] = depth;
  st[node][0].u = p;
  st[node][0].c = c;
  for (E it : tr[node])
    if (it.u != p) dfs(it.u, node, it.c, depth + 1);
}
void initLca(int n) {
  for (int j = 1; j < LN; j++) {
    for (int i = 1; i <= n; i++) {
      st[i][j].u = st[st[i][j - 1].u][j - 1].u;
      st[i][j].c = max(st[i][j - 1].c, st[st[i][j - 1].u][j - 1].c);
    }
  }
}
int64_t lca(int u, int v) {
  int64_t ans = 0;
  if (dep[u] < dep[v]) swap(u, v);
  for (int i = LN - 1; i >= 0; i--) {
    if (dep[st[u][i].u] >= dep[v]) {
      ans = max(ans, st[u][i].c);
      u = st[u][i].u;
    }
  }
  if (u == v) return ans;
  for (int i = LN - 1; i >= 0; i--) {
    if (st[u][i].u != st[v][i].u) {
      ans = max(ans, max(st[u][i].c, st[v][i].c));
      u = st[u][i].u;
      v = st[v][i].u;
    }
  }
  return max(ans, max(st[u][0].c, st[v][0].c));
}
int par(int node) { return (p[node] < 0 ? node : p[node] = par(p[node])); }
void merge(int u, int v, int64_t d) {
  int pu = par(u);
  int pv = par(v);
  if (pu != pv) {
    if (p[pu] < p[pv]) {
      p[pu] += p[pv];
      p[pv] = pu;
    } else {
      p[pv] += p[pu];
      p[pu] = pv;
    }
    tr[u].push_back({v, d});
    tr[v].push_back({u, d});
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  memset(p, -1, sizeof p);
  int n, m, k, q;
  cin >> n >> m >> k >> q;
  for (int i = 0, u, v, c; i < m; i++) {
    cin >> u >> v >> c;
    gr[u].push_back({v, c});
    gr[v].push_back({u, c});
  }
  priority_queue<T> Q;
  for (int i = 1; i <= k; i++) Q.push({i, i, 0});
  while (!Q.empty()) {
    int node = Q.top().u;
    int v = Q.top().v;
    int64_t c = Q.top().c;
    Q.pop();
    if (::v[node]) {
      int64_t& x = mp[d[node].u][v];
      if (x)
        x = min(x, c + d[node].c);
      else
        x = c + d[node].c;
      continue;
    }
    ::v[node] = true;
    d[node] = {v, c};
    for (E it : gr[node]) Q.push({it.u, v, it.c + c});
  }
  for (int i = 1; i <= k; i++)
    for (auto it : mp[i]) Q.push({i, it.first, it.second});
  while (!Q.empty()) {
    merge(Q.top().u, Q.top().v, Q.top().c);
    Q.pop();
  }
  dfs(1, 0, 0, 1);
  initLca(k);
  while (q--) {
    int u, v;
    cin >> u >> v;
    cout << lca(u, v) << endl;
  }
  return 0;
}
