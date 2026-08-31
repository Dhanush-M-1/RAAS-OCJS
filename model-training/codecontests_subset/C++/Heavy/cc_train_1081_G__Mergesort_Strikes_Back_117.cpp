#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
using namespace std;
template <typename T>
void dprintln(const T &t) {
  cout << t << endl;
}
template <typename T, typename... Args>
void dprintln(const T &t, const Args &...rest) {
  cout << t << ' ';
  dprintln(rest...);
}
template <typename T>
void println(const T &t) {
  cout << t << '\n';
}
template <typename T, typename... Args>
void println(const T &t, const Args &...rest) {
  cout << t << ' ';
  println(rest...);
}
template <typename T>
void print(const T &t) {
  cout << t << ' ';
}
template <typename T, typename... Args>
void print(const T &t, const Args &...rest) {
  cout << t << ' ';
  print(rest...);
}
template <class T>
void scan(T &t) {
  cin >> t;
}
template <class T, class... Args>
void scan(T &a, Args &...rest) {
  cin >> a;
  scan(rest...);
}
using ll = long long;
using vl = vector<ll>;
using vi = vector<int>;
using pii = pair<int, int>;
using vb = vector<bool>;
using vpii = vector<pii>;
auto bet = [](const ll x, const ll y, const ll i) { return x <= i && i <= y; };
template <typename T1, typename T2>
T1 ceil(T1 x, T2 y) {
  return (x + y - 1) / y;
}
inline int h_bit(unsigned int x) { return 31 - __builtin_clz(x); }
inline int h_bitll(unsigned long long x) { return 63 - __builtin_clzll(x); }
template <typename T>
struct bit {
  vector<T> a;
  explicit bit(int n, int v = 0) {
    a.resize(n + 1);
    if (v != 0) {
      for (int i = 1; i <= n; ++i) a[i] = v;
    }
  }
  T sum(T x) {
    T res = 0;
    while (x) {
      res += a[x];
      x -= x & -x;
    }
    return res;
  }
  T sum(int l, int r) {
    if (l > r) return 0;
    return sum(r) - sum(l - 1);
  }
  void add(int x, T v) {
    while (x < a.size()) {
      a[x] += v;
      x += x & -x;
    }
  }
  void clear() { fill(a.begin(), a.end(), 0); }
};
vi get_prime(int n) {
  vi minp(n + 1), p;
  for (int i = 2; i <= n; i++) {
    if (!minp[i]) {
      minp[i] = i;
      p.push_back(i);
    }
    for (auto &x : p) {
      if (x <= minp[i] && x * i <= n)
        minp[x * i] = x;
      else
        break;
    }
  }
  return p;
}
const int mod = 998244353;
inline void add_mod(ll &x, const ll &y) {
  x += y;
  if (x >= mod) x -= mod;
}
inline ll submod(ll x, ll y) { return x >= y ? x - y : x - y + mod; }
void sub_mod(ll &x, const ll y) {
  x -= y;
  if (x < 0) x += mod;
}
template <typename T>
using vv = vector<vector<T>>;
template <typename T1, typename T2 = T1>
using vp = vector<pair<T1, T2>>;
template <typename T, int n>
using va = vector<array<T, n>>;
struct UF {
  vi par;
  explicit UF(int n) {
    par.assign(n + 1, 0);
    for (int i = (1); i < (n + 1); ++i) par[i] = i;
  }
  int find(int x) { return x == par[x] ? x : par[x] = find(par[x]); }
  void unite(int x, int y) { par[find(x)] = find(y); }
};
vi get_popcnt(int n) {
  vi res(n + 1);
  for (int i = (0); i < (n); ++i) {
    if (i * 2 <= n) res[i * 2] = res[i];
    if ((i & 1) == 0) res[i + 1] = res[i] + 1;
  }
  return res;
}
const int N = 30, M = 1005;
int l1 = 0, l2 = 0;
int c1, c2;
void dfs(int a, int h) {
  if (a == 0) return;
  if (h == 1 || a == 1) {
    if (l1 == 0) {
      l1 = a;
      ++c1;
    } else if (a == l1)
      ++c1;
    else {
      if (l2 == 0) l2 = a;
      ++c2;
    }
    return;
  }
  dfs(a / 2, h - 1), dfs(a - a / 2, h - 1);
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  int n, k, q;
  scan(n, k, q);
  vl inv(max(4, n) + 1);
  inv[1] = 1;
  for (int i = (2); i < (max(4, n) + 1); ++i)
    inv[i] = q - ll(q / i) * inv[q % i] % q;
  dfs(n, k);
  ll ans = 0;
  if (c1 > 0) ans += 1LL * c1 * (l1 - 1) % q * l1 % q * inv[4] % q;
  if (c2 > 0) ans += 1LL * c2 * (l2 - 1) % q * l2 % q * inv[4] % q;
  if (c1 > 1) {
    ll sum = 0;
    for (int i = (2); i < (2 * l1 + 1); ++i) {
      int mi = max(1, i - l1);
      int ma = min(l1, i - 1);
      sum += 1LL * (ma - mi + 1) * (inv[2] - inv[i] + q) % q;
    }
    ans += 1LL * c1 * (c1 - 1) / 2 % q * sum % q;
  }
  if (c2 > 1) {
    ll sum = 0;
    for (int i = (2); i < (2 * l2 + 1); ++i) {
      int mi = max(1, i - l2);
      int ma = min(l2, i - 1);
      sum += 1LL * (ma - mi + 1) * (inv[2] - inv[i] + q) % q;
    }
    ans += 1LL * c2 * (c2 - 1) / 2 % q * sum % q;
  }
  if (c1 > 0 && c2 > 0) {
    ll sum = 0;
    for (int i = (2); i < (l1 + l2 + 1); ++i) {
      int mi = max(1, i - l2);
      int ma = min(l1, i - 1);
      sum += 1LL * (ma - mi + 1) * (inv[2] - inv[i] + q) % q;
    }
    ans += 1LL * c1 * c2 % q * sum % q;
  }
  println(ans % q);
  return 0;
}
