#include <bits/stdc++.h>
using namespace std;
const int MOD = (int)1e9 + 7;
const int FFTMOD = 119 << 23 | 1;
const int INF = (int)1e9 + 23111992;
const long long LINF = (long long)1e18 + 23111992;
const long double PI = acos((long double)-1);
const long double EPS = 1e-9;
inline long long gcd(long long a, long long b) {
  long long r;
  while (b) {
    r = a % b;
    a = b;
    b = r;
  }
  return a;
}
inline long long lcm(long long a, long long b) { return a / gcd(a, b) * b; }
inline long long fpow(long long n, long long k, int p = MOD) {
  long long r = 1;
  for (; k; k >>= 1) {
    if (k & 1) r = r * n % p;
    n = n * n % p;
  }
  return r;
}
template <class T>
inline int chkmin(T& a, const T& val) {
  return val < a ? a = val, 1 : 0;
}
template <class T>
inline int chkmax(T& a, const T& val) {
  return a < val ? a = val, 1 : 0;
}
inline unsigned long long isqrt(unsigned long long k) {
  unsigned long long r = sqrt(k) + 1;
  while (r * r > k) r--;
  return r;
}
inline long long icbrt(long long k) {
  long long r = cbrt(k) + 1;
  while (r * r * r > k) r--;
  return r;
}
inline void addmod(int& a, int val, int p = MOD) {
  if ((a = (a + val)) >= p) a -= p;
}
inline void submod(int& a, int val, int p = MOD) {
  if ((a = (a - val)) < 0) a += p;
}
inline int mult(int a, int b, int p = MOD) { return (long long)a * b % p; }
inline int inv(int a, int p = MOD) { return fpow(a, p - 2, p); }
inline int sign(long double x) { return x < -EPS ? -1 : x > +EPS; }
inline int sign(long double x, long double y) { return sign(x - y); }
mt19937 mt(chrono::high_resolution_clock::now().time_since_epoch().count());
inline int mrand() { return abs((int)mt()); }
void solve() {
  int n, m, k, q;
  cin >> n >> m >> k >> q;
  vector<vector<pair<int, int>>> adj(n);
  for (int i = (0); i < (m); ++i) {
    int u, v, w;
    cin >> u >> v >> w;
    u--, v--;
    adj[u].push_back({v, w});
    adj[v].push_back({u, w});
  }
  vector<tuple<long long, int, int>> edges;
  map<pair<int, int>, long long> d;
  vector<int> ids(n, -1);
  priority_queue<tuple<long long, int, int>> heap;
  for (int u = (0); u < (k); ++u) {
    d[make_pair(u, u)] = 0, ids[u] = u, heap.push({-d[make_pair(u, u)], u, u});
  }
  while (int((heap).size())) {
    long long t;
    int u, v;
    tie(t, u, v) = heap.top();
    t = -t;
    heap.pop();
    if (d[make_pair(u, v)] ^ t) continue;
    if (ids[u] != -1 && ids[u] != v) {
      edges.push_back({d[make_pair(u, ids[u])] + t, ids[u], v});
    } else {
      ids[u] = v;
      for (auto e : adj[u]) {
        int nu = e.first;
        int w = e.second;
        if (!d.count(make_pair(nu, v))) d[make_pair(nu, v)] = LINF;
        if (chkmin(d[make_pair(nu, v)], d[make_pair(u, v)] + w)) {
          heap.push({-d[make_pair(nu, v)], nu, v});
        }
      }
    }
  }
  sort((edges).begin(), (edges).end());
  vector<int> dj(n);
  function<int(int)> find = [&](int u) {
    return dj[u] == u ? dj[u] : dj[u] = find(dj[u]);
  };
  auto join = [&](int u, int v) {
    u = find(u);
    v = find(v);
    if (u ^ v) {
      dj[u] = v;
      return 1;
    }
    return 0;
  };
  for (int u = (0); u < (n); ++u) dj[u] = u;
  vector<vector<pair<int, long long>>> adj2(k);
  for (auto e : edges) {
    int u, v;
    long long w;
    tie(w, u, v) = e;
    if (join(u, v)) {
      adj2[u].push_back({v, w});
      adj2[v].push_back({u, w});
    }
  }
  int logn = 20;
  vector<int> lev(n);
  vector<vector<int>> par(logn, vector<int>(n));
  vector<vector<long long>> val(logn, vector<long long>(n));
  function<void(int, int)> dfs = [&](int u, int p) {
    for (int i = (1); i < (logn); ++i) {
      par[i][u] = par[i - 1][par[i - 1][u]];
      val[i][u] = max(val[i - 1][u], val[i - 1][par[i - 1][u]]);
    }
    for (auto e : adj2[u]) {
      int v = e.first;
      long long w = e.second;
      if (v ^ p) {
        lev[v] = lev[u] + 1;
        par[0][v] = u;
        val[0][v] = w;
        dfs(v, u);
      }
    }
  };
  auto query = [&](int u, int v) {
    if (lev[u] < lev[v]) swap(u, v);
    long long res = 0;
    for (int i = (logn)-1; i >= (0); --i) {
      if (lev[v] <= lev[par[i][u]]) {
        chkmax(res, val[i][u]);
        u = par[i][u];
      }
    }
    if (u == v) return res;
    for (int i = (logn)-1; i >= (0); --i) {
      if (par[i][u] ^ par[i][v]) {
        chkmax(res, val[i][u]);
        chkmax(res, val[i][v]);
        u = par[i][u];
        v = par[i][v];
      }
    }
    chkmax(res, val[0][u]);
    chkmax(res, val[0][v]);
    return res;
  };
  dfs(0, -1);
  while (q--) {
    int u, v;
    cin >> u >> v;
    u--, v--;
    cout << query(u, v) << "\n";
  }
}
int main(int argc, char* argv[]) {
  ios_base::sync_with_stdio(0), cin.tie(0);
  if (argc > 1) {
    assert(freopen(argv[1], "r", stdin));
  }
  if (argc > 2) {
    assert(freopen(argv[2], "wb", stdout));
  }
  solve();
  cerr << "\nTime elapsed: " << 1000 * clock() / CLOCKS_PER_SEC << "ms\n";
  return 0;
}
