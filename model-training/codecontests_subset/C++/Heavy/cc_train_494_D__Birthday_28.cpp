#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")
#pragma GCC optimize("-ffloat-store")
using namespace std;
clock_t time_p = clock();
void aryanc403() {}
const long long int INF = 0xFFFFFFFFFFFFFFFL;
long long int seed;
mt19937 rng(seed = chrono::steady_clock::now().time_since_epoch().count());
inline long long int rnd(long long int l = 0, long long int r = INF) {
  return uniform_int_distribution<long long int>(l, r)(rng);
}
class CMP {
 public:
  bool operator()(pair<long long int, long long int> a,
                  pair<long long int, long long int> b) {
    return !(a.first < b.first || (a.first == b.first && a.second <= b.second));
  }
};
void add(map<long long int, long long int>& m, long long int x,
         long long int cnt = 1) {
  auto jt = m.find(x);
  if (jt == m.end())
    m.insert({x, cnt});
  else
    jt->second += cnt;
}
void del(map<long long int, long long int>& m, long long int x,
         long long int cnt = 1) {
  auto jt = m.find(x);
  if (jt->second <= cnt)
    m.erase(jt);
  else
    jt->second -= cnt;
}
bool cmp(const pair<long long int, long long int>& a,
         const pair<long long int, long long int>& b) {
  return a.first < b.first || (a.first == b.first && a.second < b.second);
}
const long long int mod = 1000000007L;
const long long int N = 100000L;
template <class T>
struct RMQ {
  vector<vector<T>> jmp;
  RMQ(const vector<T>& V) : jmp(1, V) {
    for (int pw = 1, k = 1; pw * 2 <= (long long int)(V).size(); pw *= 2, ++k) {
      jmp.emplace_back((long long int)(V).size() - pw * 2 + 1);
      for (int j = 0; j < ((long long int)(jmp[k]).size()); ++j)
        jmp[k][j] = min(jmp[k - 1][j], jmp[k - 1][j + pw]);
    }
  }
  T query(int a, int b) {
    assert(a < b);
    int dep = 31 - __builtin_clz(b - a);
    return min(jmp[dep][a], jmp[dep][b - (1 << dep)]);
  }
};
struct LCA {
  int T = 0;
  vector<long long int> time, path, ret;
  vector<long long> dist;
  RMQ<long long int> rmq;
  LCA(vector<vector<pair<long long int, long long int>>>& C)
      : time((long long int)(C).size()),
        dist((long long int)(C).size()),
        rmq((dfs(C), ret)) {}
  void dfs(vector<vector<pair<long long int, long long int>>>& C, int v = 0,
           int p = -1, long long di = 0) {
    time[v] = T++, dist[v] = di;
    for (auto& e : C[v])
      if (e.first != p) {
        path.push_back(v), ret.push_back(time[v]);
        dfs(C, e.first, v, di + e.second);
      }
  }
  int query(int a, int b) {
    if (a == b) return a;
    tie(a, b) = minmax(time[a], time[b]);
    return path[rmq.query(a, b)];
  }
  long long distance(int a, int b) {
    int lca = query(a, b);
    return dist[a] + dist[b] - 2 * dist[lca];
  }
};
long long int T, n, i, j, k, in, cnt, l, r, u, v, x, y;
long long int m;
string s;
vector<long long int> cst0, cst1, cst2;
vector<long long int> scst0, scst1, scst2;
vector<long long int> ucst1, ucst2;
vector<vector<pair<long long int, long long int>>> e;
vector<long long int> tin, tout, hei;
void dfs(long long int u, long long int p, long long int h) {
  hei[u] = h;
  tin[u] = ++T;
  for (auto x : e[u]) {
    const long long int v = x.first, w = x.second;
    if (v == p) continue;
    dfs(v, u, (h + w) % mod);
    cst2[u] = (cst2[u] + cst2[v] + 2 * w * cst1[v] % mod +
               cst0[v] * (w * w % mod) % mod) %
              mod;
    cst1[u] = (cst1[u] + cst1[v] % mod + cst0[v] * w % mod) % mod;
    cst0[u] += cst0[v];
  }
  cst0[u]++;
  tout[u] = ++T;
}
void dfs2(long long int u, long long int p,
          pair<long long int, long long int> up) {
  cst2[u] = (cst2[u] + up.second) % mod;
  cst1[u] = (cst1[u] + up.first) % mod;
  ucst2[u] = up.second % mod;
  ucst1[u] = up.first % mod;
  for (auto x : e[u]) {
    const long long int v = x.first, w = x.second;
    if (v == p) continue;
    long long int h2 = cst2[u], h1 = cst1[u], h0 = n - cst0[v];
    h2 -= cst0[v] * (w * w % mod) % mod + (2 * w * cst1[v]) % mod + cst2[v];
    h1 -= cst0[v] * w + cst1[v];
    h1 %= mod;
    h2 %= mod;
    h2 += 2 * w * h1 % mod;
    h2 += (w * w % mod) * h0 % mod;
    h1 += w * h0 % mod;
    h1 %= mod;
    h2 %= mod;
    dfs2(v, u, {h1, h2});
  }
}
long long int query(long long int u, long long int y) {
  y %= mod;
  long long int h0 = scst0[u];
  long long int h1 = scst1[u];
  long long int h2 = scst2[u];
  h2 += 2 * y * h1 % mod;
  h2 += (y * y % mod) * h0 % mod;
  return h2;
}
long long int queryu(long long int u, long long int y) {
  y %= mod;
  long long int h0 = n - scst0[u];
  long long int h1 = ucst1[u];
  long long int h2 = ucst2[u];
  h2 += 2 * y * h1 % mod;
  h2 += (y * y % mod) * h0 % mod;
  return h2;
}
int main(void) {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  {
    cin >> n;
    e.resize(n + 1);
    cst0.resize(n + 1);
    cst1.resize(n + 1);
    cst2.resize(n + 1);
    ucst1.resize(n + 1);
    ucst2.resize(n + 1);
    tin.resize(n + 1);
    tout.resize(n + 1);
    hei.resize(n + 1);
    for (i = 0; i < (n - 1); ++i) {
      long long int w;
      cin >> u >> v >> w;
      e[u].push_back({v, w});
      e[v].push_back({u, w});
    }
    dfs(1, -1, 0);
    scst0 = cst0;
    scst1 = cst1;
    scst2 = cst2;
    dfs2(1, -1, {0, 0});
    e[0].push_back({1, 0});
    e[1].push_back({0, 0});
    LCA lca(e);
    long long int q;
    cin >> q;
    while (q--) {
      cin >> u >> v;
      long long int ans = 0;
      if (tin[v] <= tin[u] && tout[u] <= tout[v]) {
        ans += cst2[u];
        ans -= queryu(v, lca.distance(u, v));
      } else {
        ans += query(v, lca.distance(u, v));
      }
      ans *= 2;
      ans -= cst2[u];
      ans %= mod;
      ans += mod;
      ans %= mod;
      cout << ans << "\n";
    }
  }
  aryanc403();
  return 0;
}
