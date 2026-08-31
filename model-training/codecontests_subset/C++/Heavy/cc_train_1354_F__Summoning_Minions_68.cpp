#include <bits/stdc++.h>
using namespace std;
constexpr long double m_pi = 3.1415926535897932L;
constexpr long long MOD = 1000000007;
constexpr long long INF = 1LL << 61;
constexpr long double EPS = 1e-10;
template <typename T>
using vector2 = vector<vector<T>>;
template <typename T>
using vector3 = vector<vector2<T>>;
string operator*(const string& s, int k) {
  if (k == 0) return "";
  string p = (s + s) * (k / 2);
  if (k % 2 == 1) p += s;
  return p;
}
template <class T>
inline bool chmin(T& a, T b) {
  if (a > b) {
    a = b;
    return true;
  }
  return false;
}
template <class T>
inline bool chmax(T& a, T b) {
  if (a < b) {
    a = b;
    return true;
  }
  return false;
}
struct Edge {
  int to, rev;
  long long cap;
  Edge(int _to, long long _cap, int _rev) {
    to = _to;
    cap = _cap;
    rev = _rev;
  }
};
void add_edge(vector<vector<Edge>>& G, int from, int to, long long cap,
              bool revFlag, long long revCap) {
  G[from].push_back(Edge(to, cap, (long long)G[to].size()));
  if (revFlag)
    G[to].push_back(Edge(from, revCap, (long long)G[from].size() - 1));
}
long long max_flow_dfs(vector<vector<Edge>>& G, long long v, long long t,
                       long long f, vector<bool>& used) {
  if (v == t) return f;
  used[v] = true;
  for (int i = 0; i < G[v].size(); ++i) {
    Edge& e = G[v][i];
    if (!used[e.to] && e.cap > 0) {
      long long d = max_flow_dfs(G, e.to, t, min(f, e.cap), used);
      if (d > 0) {
        e.cap -= d;
        G[e.to][e.rev].cap += d;
        return d;
      }
    }
  }
  return 0;
}
long long max_flow(vector<vector<Edge>>& G, long long s, long long t) {
  long long flow = 0;
  for (;;) {
    vector<bool> used(G.size());
    for (long long(i) = (long long)(0); i < (long long)(used.size()); i++)
      used[i] = false;
    long long f = max_flow_dfs(G, s, t, INF, used);
    if (f == 0) {
      return flow;
    }
    flow += f;
  }
}
void BellmanFord(vector<vector<Edge>>& G, long long s, vector<long long>& d,
                 vector<long long>& negative) {
  d.resize(G.size());
  negative.resize(G.size());
  for (long long(i) = (long long)(0); i < (long long)(d.size()); i++)
    d[i] = INF;
  for (long long(i) = (long long)(0); i < (long long)(d.size()); i++)
    negative[i] = false;
  d[s] = 0;
  for (long long(k) = (long long)(0); k < (long long)(G.size() - 1); k++) {
    for (long long(i) = (long long)(0); i < (long long)(G.size()); i++) {
      for (long long(j) = (long long)(0); j < (long long)(G[i].size()); j++) {
        if (d[i] != INF && d[G[i][j].to] > d[i] + G[i][j].cap) {
          d[G[i][j].to] = d[i] + G[i][j].cap;
        }
      }
    }
  }
  for (long long(k) = (long long)(0); k < (long long)(G.size() - 1); k++) {
    for (long long(i) = (long long)(0); i < (long long)(G.size()); i++) {
      for (long long(j) = (long long)(0); j < (long long)(G[i].size()); j++) {
        if (d[i] != INF && d[G[i][j].to] > d[i] + G[i][j].cap) {
          d[G[i][j].to] = d[i] + G[i][j].cap;
          negative[G[i][j].to] = true;
        }
        if (negative[i] == true) negative[G[i][j].to] = true;
      }
    }
  }
}
void Dijkstra(vector<vector<Edge>>& G, long long s, vector<long long>& d) {
  d.resize(G.size());
  for (long long(i) = (long long)(0); i < (long long)(d.size()); i++)
    d[i] = INF;
  d[s] = 0;
  priority_queue<pair<long long, long long>, vector<pair<long long, long long>>,
                 greater<pair<long long, long long>>>
      q;
  q.push(make_pair(0, s));
  while (!q.empty()) {
    pair<long long, long long> a = q.top();
    q.pop();
    if (d[a.second] < a.first) continue;
    for (long long(i) = (long long)(0); i < (long long)(G[a.second].size());
         i++) {
      Edge e = G[a.second][i];
      if (d[e.to] > d[a.second] + e.cap) {
        d[e.to] = d[a.second] + e.cap;
        q.push(make_pair(d[e.to], e.to));
      }
    }
  }
}
void WarshallFloyd(vector<vector<Edge>>& G, vector<vector<long long>>& d) {
  d.resize(G.size());
  for (long long(i) = (long long)(0); i < (long long)(d.size()); i++)
    d[i].resize(G.size());
  for (long long(i) = (long long)(0); i < (long long)(d.size()); i++) {
    for (long long(j) = (long long)(0); j < (long long)(d[i].size()); j++) {
      d[i][j] = ((i != j) ? INF : 0);
    }
  }
  for (long long(i) = (long long)(0); i < (long long)(G.size()); i++) {
    for (long long(j) = (long long)(0); j < (long long)(G[i].size()); j++) {
      chmin(d[i][G[i][j].to], G[i][j].cap);
    }
  }
  for (long long(i) = (long long)(0); i < (long long)(G.size()); i++) {
    for (long long(j) = (long long)(0); j < (long long)(G.size()); j++) {
      for (long long(k) = (long long)(0); k < (long long)(G.size()); k++) {
        chmin(d[j][k], d[j][i] + d[i][k]);
      }
    }
  }
}
bool tsort(vector<vector<Edge>>& graph, vector<long long>& order) {
  int n = graph.size(), k = 0;
  vector<long long> in(n);
  for (auto& es : graph)
    for (auto& e : es) in[e.to]++;
  priority_queue<long long, vector<long long>, greater<long long>> que;
  for (long long(i) = (long long)(0); i < (long long)(n); i++)
    if (in[i] == 0) que.push(i);
  while (que.size()) {
    int v = que.top();
    que.pop();
    order.push_back(v);
    for (auto& e : graph[v])
      if (--in[e.to] == 0) que.push(e.to);
  }
  if (order.size() != n)
    return false;
  else
    return true;
}
class Lca {
 public:
  const int n = 0;
  const int log2_n = 0;
  std::vector<std::vector<int>> parent;
  std::vector<int> depth;
  Lca() {}
  Lca(const vector<vector<Edge>>& g, int root)
      : n(g.size()),
        log2_n(log2(n) + 1),
        parent(log2_n, std::vector<int>(n)),
        depth(n) {
    dfs(g, root, -1, 0);
    for (int k = 0; k + 1 < log2_n; k++) {
      for (int v = 0; v < (int)g.size(); v++) {
        if (parent[k][v] < 0)
          parent[k + 1][v] = -1;
        else
          parent[k + 1][v] = parent[k][parent[k][v]];
      }
    }
  }
  void dfs(const vector<vector<Edge>>& g, int v, int p, int d) {
    parent[0][v] = p;
    depth[v] = d;
    for (auto& e : g[v]) {
      if (e.to != p) dfs(g, e.to, v, d + 1);
    }
  }
  int get(int u, int v) {
    if (depth[u] > depth[v]) std::swap(u, v);
    for (int k = 0; k < log2_n; k++) {
      if ((depth[v] - depth[u]) >> k & 1) {
        v = parent[k][v];
      }
    }
    if (u == v) return u;
    for (int k = log2_n - 1; k >= 0; k--) {
      if (parent[k][u] != parent[k][v]) {
        u = parent[k][u];
        v = parent[k][v];
      }
    }
    return parent[0][u];
  }
};
void visit(const vector<vector<Edge>>& g, int v, vector<vector<int>>& scc,
           stack<int>& S, vector<int>& inS, vector<int>& low, vector<int>& num,
           int& time) {
  low[v] = num[v] = ++time;
  S.push(v);
  inS[v] = true;
  for (decltype((g[v]).begin()) e = (g[v]).begin(); e != (g[v]).end(); ++e) {
    int w = e->to;
    if (num[w] == 0) {
      visit(g, w, scc, S, inS, low, num, time);
      low[v] = min(low[v], low[w]);
    } else if (inS[w])
      low[v] = min(low[v], num[w]);
  }
  if (low[v] == num[v]) {
    scc.push_back(vector<int>());
    while (1) {
      int w = S.top();
      S.pop();
      inS[w] = false;
      scc.back().push_back(w);
      if (v == w) break;
    }
  }
}
void stronglyConnectedComponents(const vector<vector<Edge>>& g,
                                 vector<vector<int>>& scc) {
  const int n = g.size();
  vector<int> num(n), low(n);
  stack<int> S;
  vector<int> inS(n);
  int time = 0;
  for (long long(u) = (long long)(0); u < (long long)(n); u++)
    if (num[u] == 0) visit(g, u, scc, S, inS, low, num, time);
}
class UnionFind {
  vector<int> data;
  long long num;

 public:
  UnionFind(int size) : data(size, -1), num(size) {}
  bool unite(int x, int y) {
    x = root(x);
    y = root(y);
    if (x != y) {
      if (data[y] < data[x]) swap(x, y);
      data[x] += data[y];
      data[y] = x;
    }
    num -= (x != y);
    return x != y;
  }
  bool findSet(int x, int y) { return root(x) == root(y); }
  int root(int x) { return data[x] < 0 ? x : data[x] = root(data[x]); }
  long long size(int x) { return -data[root(x)]; }
  long long numSet() { return num; }
};
template <typename T, typename F>
class SegmentTree {
 private:
  T identity;
  F merge;
  long long n;
  vector<T> dat;

 public:
  SegmentTree(F f, T id, vector<T> v) : merge(f), identity(id) {
    int _n = v.size();
    n = 1;
    while (n < _n) n *= 2;
    dat.resize(2 * n - 1, identity);
    for (long long(i) = (long long)(0); i < (long long)(_n); i++)
      dat[n + i - 1] = v[i];
    for (int i = n - 2; i >= 0; i--)
      dat[i] = merge(dat[i * 2 + 1], dat[i * 2 + 2]);
  }
  SegmentTree(F f, T id, int _n) : merge(f), identity(id) {
    n = 1;
    while (n < _n) n *= 2;
    dat.resize(2 * n - 1, identity);
  }
  void set_val(int i, T x) {
    i += n - 1;
    dat[i] = x;
    while (i > 0) {
      i = (i - 1) / 2;
      dat[i] = merge(dat[i * 2 + 1], dat[i * 2 + 2]);
    }
  }
  T query(int l, int r) {
    T left = identity, right = identity;
    l += n - 1;
    r += n - 1;
    while (l < r) {
      if ((l & 1) == 0) left = merge(left, dat[l]);
      if ((r & 1) == 0) right = merge(dat[r - 1], right);
      l = l / 2;
      r = (r - 1) / 2;
    }
    return merge(left, right);
  }
};
template <typename T>
class FenwickTree {
  vector<T> data;
  int n;
  int p;

 public:
  FenwickTree(int n) : n(n) {
    data.resize(n + 1LL, 0);
    p = 1;
    while (p < data.size()) p *= 2;
  }
  T sum(int k) {
    T ret = 0;
    for (; k > 0; k -= k & -k) ret += data[k];
    return (ret);
  }
  T sum(int a, int b) { return sum(b) - sum(a); }
  void add(int k, T x) {
    for (++k; k <= n; k += k & -k) data[k] += x;
  }
  int lower_bound(long long w) {
    if (w <= 0) return -1;
    int x = 0;
    for (int k = p / 2; k > 0; k /= 2) {
      if (x + k <= n && data[x + k] < w) w -= data[x + k], x += k;
    }
    return x;
  }
};
void divisor(long long n, vector<long long>& ret) {
  for (long long i = 1; i * i <= n; i++) {
    if (n % i == 0) {
      ret.push_back(i);
      if (i * i != n) ret.push_back(n / i);
    }
  }
  sort(ret.begin(), ret.end());
}
void prime_factorization(long long n, vector<pair<long long, long long>>& ret) {
  for (long long i = 2; i * i <= n; i++) {
    if (n % i == 0) {
      ret.push_back({i, 0});
      while (n % i == 0) {
        n /= i;
        ret[ret.size() - 1].second++;
      }
    }
  }
  if (n != 1) ret.push_back({n, 1});
}
long long mod_pow(long long x, long long n, long long mod) {
  long long res = 1;
  while (n > 0) {
    if (n & 1) res = res * x % mod;
    x = x * x % mod;
    n >>= 1;
  }
  return res;
}
long long mod_inv(long long x, long long mod) {
  return mod_pow(x, mod - 2, mod);
}
class Combination {
 public:
  vector<long long> fact;
  vector<long long> inv;
  long long mod;
  long long mod_inv(long long x) {
    long long n = mod - 2LL;
    long long res = 1LL;
    while (n > 0) {
      if (n & 1) res = res * x % mod;
      x = x * x % mod;
      n >>= 1;
    }
    return res;
  }
  long long nCr(long long n, long long r) {
    if (n < r) return 0;
    if (n < mod) return ((fact[n] * inv[r] % mod) * inv[n - r]) % mod;
    long long ret = 1;
    while (n || r) {
      long long _n = n % mod, _r = r % mod;
      n /= mod;
      r /= mod;
      (ret *= nCr(_n, _r)) %= mod;
    }
    return ret;
  }
  long long nPr(long long n, long long r) {
    return (fact[n] * inv[n - r]) % mod;
  }
  long long nHr(long long n, long long r) { return nCr(r + n - 1, r); }
  Combination(long long _n, long long _mod) {
    mod = _mod;
    long long n = min(_n + 1, mod);
    fact.resize(n);
    fact[0] = 1;
    for (long long(i) = (long long)(0); i < (long long)(n - 1); i++) {
      fact[i + 1] = (fact[i] * (i + 1LL)) % mod;
    }
    inv.resize(n);
    inv[n - 1] = mod_inv(fact[n - 1]);
    for (int i = n - 1; i > 0; i--) {
      inv[i - 1] = inv[i] * i % mod;
    }
  }
};
long long popcount(long long x) {
  x = (x & 0x5555555555555555) + (x >> 1 & 0x5555555555555555);
  x = (x & 0x3333333333333333) + (x >> 2 & 0x3333333333333333);
  x = (x & 0x0F0F0F0F0F0F0F0F) + (x >> 4 & 0x0F0F0F0F0F0F0F0F);
  x = (x & 0x00FF00FF00FF00FF) + (x >> 8 & 0x00FF00FF00FF00FF);
  x = (x & 0x0000FFFF0000FFFF) + (x >> 16 & 0x0000FFFF0000FFFF);
  x = (x & 0x00000000FFFFFFFF) + (x >> 32 & 0x00000000FFFFFFFF);
  return x;
}
void solve() {
  long long n, k;
  cin >> n >> k;
  using T = tuple<long long, long long, long long>;
  vector<T> m(n);
  for (long long(i) = (long long)(0); i < (long long)(n); i++) {
    long long a, b;
    cin >> a >> b;
    m[i] = {b, a, i + 1};
  }
  sort((m).begin(), (m).end());
  vector3<long long> dp(
      n + 1, vector2<long long>(k + 1, vector<long long>(n - k + 1, -INF)));
  dp[0][0][0] = 0;
  for (long long(i) = (long long)(0); i < (long long)(n); i++) {
    auto [b, a, num] = m[i];
    for (long long(j) = (long long)(0); j < (long long)(k + 1); j++) {
      for (long long(l) = (long long)(0); l < (long long)(n - k + 1); l++) {
        if (dp[i][j][l] == -INF) continue;
        if (l != n - k) chmax(dp[i + 1][j][l + 1], dp[i][j][l] + (k - 1) * b);
        if (j != k) chmax(dp[i + 1][j + 1][l], dp[i][j][l] + j * b + a);
      }
    }
  }
  cout << 2 * n - k << "\n";
  pair<long long, long long> now = {k, n - k};
  vector<long long> s, t;
  for (int i = n - 1; i >= 0; i--) {
    auto [b, a, num] = m[i];
    auto [j, l] = now;
    if (l && dp[i + 1][j][l] == dp[i][j][l - 1] + (k - 1) * b) {
      t.push_back(num);
      now.second--;
    } else {
      s.push_back(num);
      now.first--;
    }
  }
  reverse((s).begin(), (s).end());
  for (long long(i) = (long long)(0); i < (long long)(k - 1); i++)
    cout << s[i] << " ";
  for (long long(i) = (long long)(0); i < (long long)(n - k); i++)
    cout << t[i] << " " << -1 * t[i] << " ";
  cout << s.back() << "\n";
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long n;
  cin >> n;
  while (n--) solve();
  return 0;
}
