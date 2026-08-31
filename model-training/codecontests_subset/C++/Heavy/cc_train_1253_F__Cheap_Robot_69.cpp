#include <bits/stdc++.h>
using namespace std;
mt19937 rnd(chrono::high_resolution_clock::now().time_since_epoch().count());
const long long INF = 1e18;
template <class t1, class t2>
bool cmin(t1 &a, const t2 &b) {
  if (a > b) {
    a = b;
    return true;
  }
  return false;
}
template <class t1, class t2>
bool cmax(t1 &a, const t2 &b) {
  if (a < b) {
    a = b;
    return true;
  }
  return false;
}
void UseFiles(const string &s) {
  freopen((s + ".in").c_str(), "r", stdin);
  freopen((s + ".out").c_str(), "w", stdout);
}
void run();
signed main() {
  iostream::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  run();
}
struct dsu {
  vector<long long> l, h;
  dsu(long long n) : l(n), h(n, 1) { iota(l.begin(), l.end(), 0); }
  long long get_root(long long v) {
    if (l[v] == v) {
      return v;
    }
    return l[v] = get_root(l[v]);
  }
  bool Union(long long u, long long v) {
    u = get_root(u);
    v = get_root(v);
    if (u == v) {
      return false;
    }
    if (h[u] > h[v]) {
      swap(u, v);
    }
    l[u] = v;
    if (h[u] == h[v]) {
      ++h[v];
    }
    return true;
  }
};
long long n;
vector<vector<pair<long long, long long>>> g;
vector<long long> color, dst;
vector<tuple<long long, long long, long long>> dijkstra(long long k) {
  priority_queue<pair<long long, long long>, vector<pair<long long, long long>>,
                 greater<pair<long long, long long>>>
      q;
  for (long long i = 0; i < k; ++i) {
    color[i] = i;
    dst[i] = 0;
    q.push({0, i});
  }
  while (((long long)(q).size())) {
    auto [d, v] = q.top();
    q.pop();
    if (dst[v] != d) {
      continue;
    }
    for (auto &[u, w] : g[v]) {
      if (cmin(dst[u], d + w)) {
        color[u] = color[v];
        q.push({dst[u], u});
      }
    }
  }
  map<pair<long long, long long>, long long> m;
  for (long long i = 0; i < n; ++i) {
    for (auto &[v, w] : g[i]) {
      if (color[v] > color[i]) {
        if (m.count({color[i], color[v]})) {
          cmin(m[{color[i], color[v]}], dst[i] + dst[v] + w);
        } else {
          m[{color[i], color[v]}] = dst[i] + dst[v] + w;
        }
      }
    }
  }
  vector<tuple<long long, long long, long long>> edges;
  for (auto &[x, y] : m) {
    edges.push_back({y, x.first, x.second});
  }
  sort(edges.begin(), edges.end());
  return edges;
}
const long long maxlg = 20;
vector<vector<pair<long long, long long>>> tree;
vector<vector<long long>> up, mup;
vector<long long> d;
void dfs(long long v, long long p = -1, long long pw = 0, long long cur_d = 0) {
  d[v] = cur_d;
  mup[v][0] = pw;
  up[v][0] = p;
  if (p == -1) {
    up[v][0] = v;
  }
  for (long long i = 1; i < maxlg; ++i) {
    up[v][i] = up[up[v][i - 1]][i - 1];
    mup[v][i] = max(mup[v][i - 1], mup[up[v][i - 1]][i - 1]);
  }
  for (auto &[u, w] : tree[v]) {
    if (u == p) {
      continue;
    }
    dfs(u, v, w, cur_d + 1);
  }
}
long long lca(long long u, long long v) {
  if (d[u] < d[v]) {
    swap(u, v);
  }
  long long ans = 0;
  for (long long i = maxlg - 1; i >= 0; --i) {
    if (d[up[u][i]] >= d[v]) {
      cmax(ans, mup[u][i]);
      u = up[u][i];
    }
  }
  if (u == v) {
    return ans;
  }
  for (long long i = maxlg - 1; i >= 0; --i) {
    if (up[u][i] != up[v][i]) {
      cmax(ans, mup[u][i]);
      cmax(ans, mup[v][i]);
      u = up[u][i];
      v = up[v][i];
    }
  }
  cmax(ans, mup[v][0]);
  cmax(ans, mup[u][0]);
  return ans;
}
void run() {
  long long m, k, q;
  cin >> n >> m >> k >> q;
  g.resize(n);
  color.resize(n, -1);
  dst.resize(n, INF);
  for (long long i = 0; i < m; ++i) {
    long long u, v, w;
    cin >> u >> v >> w;
    --u, --v;
    g[u].push_back({v, w});
    g[v].push_back({u, w});
  }
  vector<tuple<long long, long long, long long>> edges = dijkstra(k);
  tree.resize(k);
  up.resize(k, vector<long long>(maxlg, -1));
  mup.resize(k, vector<long long>(maxlg, -1));
  d.resize(k, -1);
  dsu D(k);
  for (auto &[w, u, v] : edges) {
    if (D.Union(u, v)) {
      tree[u].push_back({v, w});
      tree[v].push_back({u, w});
    }
  }
  dfs(0);
  for (long long i = 0; i < q; ++i) {
    long long u, v;
    cin >> u >> v;
    --u, --v;
    cout << lca(u, v) << " ";
  }
  cout << endl;
}
