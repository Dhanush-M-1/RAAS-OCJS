#include <bits/stdc++.h>
using namespace std;
const long double pi = 3.1415926535897932384626433832795l;
template <typename T>
inline auto sqr(T x) -> decltype(x * x) {
  return x * x;
}
template <typename T1, typename T2>
inline bool umx(T1& a, T2 b) {
  if (a < b) {
    a = b;
    return 1;
  }
  return 0;
}
template <typename T1, typename T2>
inline bool umn(T1& a, T2 b) {
  if (b < a) {
    a = b;
    return 1;
  }
  return 0;
}
const int N = 100100;
struct Input {
  int n, q;
  vector<pair<int, int> > a[N];
  int l[N], r[N];
  bool read() {
    if (scanf("%d", &n) != 1) return 0;
    for (int i = int(0); i < int(n - 1); ++i) {
      int u, v, c;
      scanf("%d%d%d", &u, &v, &c);
      u--, v--;
      a[u].push_back(make_pair(v, c));
      a[v].push_back(make_pair(u, c));
    }
    cin >> q;
    for (int i = int(0); i < int(q); ++i) {
      scanf("%d%d", &l[i], &r[i]);
      l[i]--, r[i]--;
    }
    return 1;
  }
  void init(const Input& input) { *this = input; }
};
const long long mod = 1000000007;
struct Data : Input {
  long long ans[N];
  void write() {
    for (int i = int(0); i < int(q); ++i) {
      cout << ans[i] % mod;
      puts("");
    }
  }
  virtual void solve() {}
  virtual void clear() { *this = Data(); }
};
struct Solution : Data {
  long long sz[N];
  int tw[20][N];
  long long sum[20][N];
  int h[N];
  long long d1[N];
  long long d2[N];
  long long tot[N];
  long long totd1[N];
  int dfs(int v, int pr, int c, int h1) {
    sz[v] = 1;
    tw[0][v] = pr;
    sum[0][v] = c;
    h[v] = h1;
    for (int i = int(0); i < int(((int)(a[v]).size())); ++i) {
      int to = a[v][i].first;
      if (to != pr) {
        sz[v] += dfs(to, v, a[v][i].second, h1 + 1);
      }
    }
    return sz[v];
  }
  pair<int, long long> up(int v, int h) {
    long long res = 0;
    for (int i = int(0); i < int(20); ++i) {
      if (h & (1 << i)) {
        (res += sum[i][v]) %= mod;
        v = tw[i][v];
      }
    }
    return make_pair(v, res);
  }
  int get_lca(int u, int v) {
    if (h[u] > h[v]) swap(u, v);
    v = up(v, h[v] - h[u]).first;
    if (u == v) return u;
    for (int i = int(20) - 1; i >= int(0); --i) {
      if (tw[i][v] != tw[i][u]) {
        u = tw[i][u], v = tw[i][v];
      }
    }
    return tw[0][u];
  }
  long long get_v(int v, long long c) { return get_d2(sz[v], d1[v], d2[v], c); }
  long long get_d2(long long sz, long long d1, long long d2, long long c) {
    return (d2 + 2 * d1 * c % mod + c * c % mod * sz) % mod;
  }
  void calc_in(int v) {
    d2[v] = 0ll;
    d1[v] = 0ll;
    for (int i = int(0); i < int(((int)(a[v]).size())); ++i) {
      int to = a[v][i].first;
      if (to != tw[0][v]) {
        calc_in(to);
        (d2[v] += get_v(to, a[v][i].second)) %= mod;
        (d1[v] += d1[to] + sz[to] * a[v][i].second) %= mod;
      }
    }
  }
  void calc_tot(int v, long long dst1, long long dst2) {
    tot[v] = (dst2 + d2[v]) % mod;
    totd1[v] = (dst1 + d1[v]) % mod;
    for (int i = int(0); i < int(((int)(a[v]).size())); ++i) {
      int to = a[v][i].first;
      if (to != tw[0][v]) {
        long long ndst2 = dst2;
        ndst2 += d2[v];
        ndst2 -= get_v(to, a[v][i].second);
        (ndst2 += mod) %= mod;
        long long ndst1 = dst1;
        ndst1 += d1[v];
        ndst1 -= d1[to] + sz[to] * a[v][i].second % mod;
        (ndst1 += 2 * mod) %= mod;
        calc_tot(to, (ndst1 + (n - sz[to]) * a[v][i].second) % mod,
                 get_d2(n - sz[to], ndst1, ndst2, a[v][i].second));
      }
    }
  }
  long long get_sum(int u, int v) {
    int lca = get_lca(u, v);
    return up(u, h[u] - h[lca]).second + up(v, h[v] - h[lca]).second;
  }
  void solve() {
    dfs(0, 0, 0, 0);
    for (int i = int(1); i < int(20); ++i) {
      for (int j = int(0); j < int(n); ++j) {
        tw[i][j] = tw[i - 1][tw[i - 1][j]];
        (sum[i][j] = sum[i - 1][j] + sum[i - 1][tw[i - 1][j]]) %= mod;
      }
    }
    calc_in(0);
    calc_tot(0, 0ll, 0ll);
    for (int i = int(0); i < int(q); ++i) {
      int u = l[i], v = r[i];
      int lca = get_lca(u, v);
      if (lca != v) {
        (ans[i] = tot[u] - 2 * get_v(v, get_sum(u, v)) + 2 * mod) %= mod;
        ans[i] = (mod - ans[i]) % mod;
      } else {
        (ans[i] = 2 * get_d2(n - sz[v], totd1[v] - d1[v] + mod,
                             tot[v] - d2[v] + mod, get_sum(u, v)) -
                  (tot[u] - d2[u] + mod) % mod - d2[u] + 2 * mod) %= mod;
        ans[i] = (mod - ans[i]) % mod;
      }
    }
  }
  void print1() {
    ;
    ;
    ;
    ;
    ;
  }
  void print2() {
    ;
    ;
  }
  void print3() { ; }
  void clear() { *this = Solution(); }
};
Solution sol;
int main() {
  cout.setf(ios::showpoint | ios::fixed);
  cout.precision(20);
  sol.read();
  sol.solve();
  sol.write();
  return 0;
}
