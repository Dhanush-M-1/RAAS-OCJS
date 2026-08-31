#include <bits/stdc++.h>
#pragma comment(linker, "/stack:200000000")
#pragma GCC optimize("O3")
#pragma GCC optimize("unroll-loops")
#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")
using namespace std;
using ll = long long;
using ull = unsigned long long;
using pii = pair<int, int>;
using pll = pair<ll, ll>;
const ll INF = static_cast<ll>(1e18);
struct FlowEdge {
  int v, u;
  long long cap, flow = 0;
  FlowEdge(int v, int u, long long cap) : v(v), u(u), cap(cap) {}
};
struct Dinic {
  const long long flow_inf = 1e18;
  vector<FlowEdge> edges;
  vector<vector<int>> adj;
  int n, m = 0;
  int s, t;
  vector<int> level, ptr;
  queue<int> q;
  Dinic(int n, int s, int t) : n(n), s(s), t(t) {
    adj.resize(n);
    level.resize(n);
    ptr.resize(n);
  }
  void add_edge(int v, int u, long long cap) {
    edges.emplace_back(v, u, cap);
    edges.emplace_back(u, v, 0);
    adj[v].push_back(m);
    adj[u].push_back(m + 1);
    m += 2;
  }
  bool bfs() {
    while (!q.empty()) {
      int v = q.front();
      q.pop();
      for (int id : adj[v]) {
        if (edges[id].cap - edges[id].flow < 1) continue;
        if (level[edges[id].u] != -1) continue;
        level[edges[id].u] = level[v] + 1;
        q.push(edges[id].u);
      }
    }
    return level[t] != -1;
  }
  long long dfs(int v, long long pushed) {
    if (pushed == 0) return 0;
    if (v == t) return pushed;
    for (int& cid = ptr[v]; cid < (int)adj[v].size(); cid++) {
      int id = adj[v][cid];
      int u = edges[id].u;
      if (level[v] + 1 != level[u] || edges[id].cap - edges[id].flow < 1)
        continue;
      long long tr = dfs(u, min(pushed, edges[id].cap - edges[id].flow));
      if (tr == 0) continue;
      edges[id].flow += tr;
      edges[id ^ 1].flow -= tr;
      return tr;
    }
    return 0;
  }
  long long flow() {
    long long f = 0;
    while (true) {
      fill(level.begin(), level.end(), -1);
      level[s] = 0;
      q.push(s);
      if (!bfs()) break;
      fill(ptr.begin(), ptr.end(), 0);
      while (long long pushed = dfs(s, flow_inf)) {
        f += pushed;
      }
    }
    return f;
  }
};
template <typename T>
struct FenwickTree {
  vector<T> bit;
  FenwickTree(int sz) : bit(sz + 1) {}
  void update(int x, T delta) {
    for (int i = ++x; i < bit.size(); i += i & -i) bit[i] += delta;
  }
  T query(int x) {
    T ans{};
    for (int i = ++x; i > 0; i -= i & -i) ans += bit[i];
    return ans;
  }
};
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  srand(time(nullptr));
  int n;
  cin >> n;
  vector<pair<int, int>> P(n);
  for (int i = 0; i < n; i++) cin >> P[i].first;
  set<int> speeds, pos;
  for (int i = 0; i < n; i++) {
    cin >> P[i].second;
    speeds.insert(P[i].second);
    pos.insert(P[i].first);
  }
  int cnt = 0;
  map<int, int> mp;
  for (int s : speeds) mp[s] = cnt++;
  sort(P.begin(), P.end());
  ll tot = 0, pt = 0;
  for (int i = 0; i < n; i++) {
    tot += 1LL * i * P[i].first - pt;
    pt += P[i].first;
  }
  const int MAXS = cnt + 10;
  FenwickTree<ll> fenw(MAXS);
  FenwickTree<int> fpos(MAXS);
  for (int i = 0; i < n; i++) {
    ll times = fpos.query(MAXS - 1) - fpos.query(mp[P[i].second]);
    tot -= (1LL * P[i].first * times);
    tot += fenw.query(MAXS - 1) - fenw.query(mp[P[i].second]);
    fenw.update(mp[P[i].second], P[i].first);
    fpos.update(mp[P[i].second], +1);
  }
  cout << tot << '\n';
  return 0;
}
