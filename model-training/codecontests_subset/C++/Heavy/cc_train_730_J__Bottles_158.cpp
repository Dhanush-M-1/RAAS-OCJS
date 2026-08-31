#include <bits/stdc++.h>
#pragma GCC optimize("trapv")
#pragma GCC optimize("Ofast")
#pragma GCC optimization("unroll-loops")
#pragma GCC target("avx2")
#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")
using namespace std;
const long long MOD = 1000000007;
const long long MOD2 = 998244353;
const long long BIG = 1197423052705914509LL;
mt19937 rng(
    (long long)std::chrono::steady_clock::now().time_since_epoch().count());
const long long MAXN = 1e5 + 10;
const long long is_query = -BIG;
struct line {
  long long m, b;
  mutable function<const line*()> succ;
  bool operator<(const line& rhs) const {
    if (rhs.b != is_query) return m < rhs.m;
    const line* s = succ();
    if (!s) return 0;
    long long x = rhs.m;
    return b - s->b < (s->m - m) * x;
  }
};
struct dynamic_hull : public multiset<line> {
  const long long inf = BIG;
  bool bad(iterator y) {
    auto z = next(y);
    if (y == begin()) {
      if (z == end()) return 0;
      return y->m == z->m && y->b <= z->b;
    }
    auto x = prev(y);
    if (z == end()) return y->m == x->m && y->b <= x->b;
    long long v1 = (x->b - y->b);
    if (y->m == x->m)
      v1 = x->b > y->b ? inf : -inf;
    else
      v1 /= (y->m - x->m);
    long long v2 = (y->b - z->b);
    if (z->m == y->m)
      v2 = y->b > z->b ? inf : -inf;
    else
      v2 /= (z->m - y->m);
    return v1 >= v2;
  }
  void insert_line(long long m, long long b) {
    auto y = insert({m, b});
    y->succ = [=] { return next(y) == end() ? 0 : &*next(y); };
    if (bad(y)) {
      erase(y);
      return;
    }
    while (next(y) != end() && bad(next(y))) erase(next(y));
    while (y != begin() && bad(prev(y))) erase(prev(y));
  }
  long long eval(long long x) {
    auto l = *lower_bound((line){x, is_query});
    return l.m * x + l.b;
  }
};
struct auxiliary_tree {
  long long n;
  vector<long long> ori[MAXN];
  vector<long long> storelatest;
  long long tin[MAXN], tout[MAXN], dep[MAXN], cor[MAXN];
  bool imp[MAXN];
  long long run = 0;
  vector<long long> euler;
  vector<vector<pair<long long, long long> > > lca_table;
  long long lef[MAXN], rig[MAXN];
  void dfs(long long node, long long prev, long long de) {
    dep[node] = de;
    tin[node] = ++run;
    cor[tin[node]] = node;
    euler.push_back(node);
    for (long long i = 0; i < ori[node].size(); i++) {
      if (ori[node][i] != prev) {
        dfs(ori[node][i], node, de + 1);
        euler.push_back(node);
      }
    }
    tout[node] = ++run;
  }
  void find_all_lcas() {
    long long k = log2(2 * n - 1);
    lca_table.resize(k + 1);
    for (long long i = 0; i < k + 1; i++) {
      lca_table[i].resize(2 * n - 1);
    }
    for (long long i = 0; i < 2 * n - 1; i++) {
      lca_table[0][i] = make_pair(dep[euler[i]], euler[i]);
    }
    for (long long i = 1; i <= k; i++) {
      for (long long j = 0; j < 2 * n - 1; j++) {
        if (j + (1 << (i - 1)) >= 2 * n - 1) continue;
        if (lca_table[i - 1][j].first <
            lca_table[i - 1][j + (1 << (i - 1))].first) {
          lca_table[i][j].first = lca_table[i - 1][j].first;
          lca_table[i][j].second = lca_table[i - 1][j].second;
        } else {
          lca_table[i][j].first = lca_table[i - 1][j + (1 << (i - 1))].first;
          lca_table[i][j].second = lca_table[i - 1][j + (1 << (i - 1))].second;
        }
      }
    }
    for (long long i = 0; i < MAXN; i++) lef[i] = -1;
    for (long long i = 0; i < 2 * n - 1; i++) {
      if (lef[euler[i]] == -1) {
        lef[euler[i]] = i;
      }
      rig[euler[i]] = i;
    }
  }
  bool isParent(long long u, long long v) {
    return tin[u] < tin[v] && tout[v] < tout[u];
  }

 public:
  vector<long long> adj[MAXN];
  long long root;
  long long lcadep(long long x, long long y) {
    if (lef[x] > rig[y]) {
      swap(x, y);
    }
    long long k = log2(rig[y] - lef[x] + 1);
    return min(lca_table[k][lef[x]].first,
               lca_table[k][rig[y] - (1 << k) + 1].first);
  }
  long long lcaidx(long long x, long long y) {
    if (lef[x] > rig[y]) {
      swap(x, y);
    }
    long long k = log2(rig[y] - lef[x] + 1);
    if (lca_table[k][lef[x]].first <
        lca_table[k][rig[y] - (1 << k) + 1].first) {
      return lca_table[k][lef[x]].second;
    } else {
      return lca_table[k][rig[y] - (1 << k) + 1].second;
    }
  }
  void base(long long x, long long rt, vector<long long> y[]) {
    n = x;
    for (long long i = 1; i <= n; i++) {
      ori[i] = y[i];
    }
    dfs(rt, -1, 0);
    find_all_lcas();
  }
  void build(vector<long long> g) {
    for (long long i = 0; i < g.size(); i++) {
      g[i] = tin[g[i]];
    }
    sort(g.begin(), g.end());
    for (long long i = 0; i < g.size(); i++) {
      g[i] = cor[g[i]];
    }
    long long k = g.size();
    for (long long i = 0; i < k - 1; i++) {
      g.push_back(lcaidx(g[i], g[i + 1]));
    }
    for (long long i = 0; i < g.size(); i++) {
      g[i] = tin[g[i]];
    }
    sort(g.begin(), g.end());
    for (long long i = 0; i < g.size(); i++) {
      g[i] = cor[g[i]];
    }
    g.erase(unique(g.begin(), g.end()), g.end());
    for (long long i = 0; i < g.size(); i++) {
      imp[g[i]] = 1;
      storelatest.push_back(g[i]);
    }
    stack<long long> vert;
    vert.push(g[0]);
    for (long long i = 1; i < g.size(); i++) {
      long long u = g[i];
      while (vert.size() > 1 && isParent(vert.top(), u) == 0) {
        long long sto = vert.top();
        vert.pop();
        adj[vert.top()].push_back(sto);
      }
      vert.push(u);
    }
    while (vert.size() > 1) {
      long long sto = vert.top();
      vert.pop();
      adj[vert.top()].push_back(sto);
    }
    root = vert.top();
  }
  void clear() {
    for (long long i = 0; i < storelatest.size(); i++) {
      imp[storelatest[i]] = 0;
      adj[storelatest[i]].clear();
    }
    storelatest.clear();
  }
};
struct custom_hash {
  static uint64_t splitmix64(uint64_t x) {
    x += 0x9e3779b97f4a7c15;
    x = (x ^ (x >> 30)) * 0xbf58476d1ce4e5b9;
    x = (x ^ (x >> 27)) * 0x94d049bb133111eb;
    return x ^ (x >> 31);
  }
  size_t operator()(uint64_t a) const {
    static const uint64_t FIXED_RANDOM =
        chrono::steady_clock::now().time_since_epoch().count();
    return splitmix64(a + FIXED_RANDOM);
  }
  template <class T>
  size_t operator()(T a) const {
    static const uint64_t FIXED_RANDOM =
        chrono::steady_clock::now().time_since_epoch().count();
    hash<T> x;
    return splitmix64(x(a) + FIXED_RANDOM);
  }
  template <class T, class H>
  size_t operator()(pair<T, H> a) const {
    static const uint64_t FIXED_RANDOM =
        chrono::steady_clock::now().time_since_epoch().count();
    hash<T> x;
    hash<H> y;
    return splitmix64(x(a.f) * 37 + y(a.s) + FIXED_RANDOM);
  }
};
template <class T, class H>
using umap = unordered_map<T, H, custom_hash>;
void solve(long long test_case) {
  long long n;
  cin >> n;
  long long s = 0;
  long long a[n + 1], b[n + 1];
  for (long long i = 1; i <= n; i++) {
    cin >> a[i];
    s += a[i];
  }
  priority_queue<long long> kaz;
  for (long long i = 1; i <= n; i++) {
    cin >> b[i];
    kaz.push(b[i]);
  }
  long long s2 = 0, k = 0;
  while (s2 < s) {
    s2 += kaz.top();
    k++;
    kaz.pop();
  }
  cout << k << " ";
  long long dp[2][n + 1][10001];
  for (long long i = 0; i <= n; i++) {
    for (long long j = 1; j < 10001; j++) {
      dp[0][i][j] = -1e9;
    }
    dp[0][i][0] = 0;
  }
  long long t = 1e9;
  for (long long i = 1; i <= n; i++) {
    for (long long j = 0; j <= n; j++) {
      for (long long l = 0; l <= 10000; l++) {
        dp[i & 1][j][l] = dp[(i + 1) & 1][j][l];
        if (j > 0) dp[i & 1][j][l] = max(dp[i & 1][j][l], dp[i & 1][j - 1][l]);
        if (j > 0 && l >= b[j]) {
          dp[i & 1][j][l] =
              max(dp[i & 1][j][l], dp[(i + 1) & 1][j - 1][l - b[j]] + a[j]);
        }
        if (l >= s && i == k) {
          t = min(t, s - dp[i & 1][j][l]);
        }
      }
    }
  }
  cout << t << "\n";
}
int32_t main() {
  time_t t = clock();
  srand(time(NULL));
  ios::sync_with_stdio(0);
  cin.tie(0);
  long long T = 1;
  long long test_case = 1;
  while (T--) {
    solve(test_case);
    test_case++;
  }
  cerr << "Program terminated successfully\n";
  t = clock() - t;
  cerr << "Time used: " << fixed << setprecision(3)
       << (long double)(t * 1.0 / CLOCKS_PER_SEC) << " seconds\n";
}
