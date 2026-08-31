#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using ld = long double;
using ull = unsigned long long;
using vb = vector<bool>;
using vi = vector<int>;
using vvi = vector<vector<int>>;
using vvvi = vector<vector<vector<int>>>;
using vll = vector<ll>;
using vvll = vector<vll>;
using vvvll = vector<vvll>;
using mll = map<long long, long long>;
using pll = pair<long long, long long>;
using qll = queue<long long>;
using sll = set<long long>;
using vpll = vector<pair<long long, long long>>;
template <class T = ll>
using V = vector<T>;
template <class T = ll>
using VV = V<V<T>>;
template <class T = ll>
using VVV = V<V<V<T>>>;
template <class T = ll>
using pqup = priority_queue<T, vector<T>, greater<T>>;
template <class T = ll>
using pqdn = priority_queue<T>;
long long const limLL = 9223372036854775807;
long long const dekai = 3e16;
const long double pi = acos(-1);
const char el = '\n';
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};
int ddx[8] = {-1, -1, -1, 0, 0, 1, 1, 1};
int ddy[8] = {-1, 0, 1, -1, 1, -1, 0, 1};
const int mod = 998244353;
template <class T>
inline bool isin(T x, T lef, T rig) {
  return ((lef <= x) && (x < rig));
}
template <class T>
inline bool chmin(T &a, T b) {
  if (a > b) {
    a = b;
    return true;
  }
  return false;
}
template <class T>
inline bool chmax(T &a, T b) {
  if (a < b) {
    a = b;
    return true;
  }
  return false;
}
void Yes(bool f = 1) { cout << (f ? "Yes" : "No") << "\n"; }
void No() { cout << "No\n"; }
void YES(bool f = 1) { cout << (f ? "YES" : "NO") << "\n"; }
void NO() { cout << "NO\n"; }
template <class T>
void drop(T answer) {
  cout << answer << "\n";
  exit(0);
}
void err() {
  cout << -1 << "\n";
  exit(0);
}
vector<long long> vin(long long n) {
  vector<long long> v(n);
  for (long long i = 0; i < n; i++) {
    cin >> v[i];
  }
  return v;
}
template <class T>
void vout(vector<T> &v, bool tate = 0) {
  if (v.size() > 0) {
    for (auto it = v.begin(); it < v.end(); it++) {
      cout << *it;
      if (it != v.end() - 1) {
        if (tate)
          cout << endl;
        else
          cout << " ";
      }
    }
  }
  cout << endl;
}
template <class T>
void add(vector<T> &v, T val) {
  for (auto &a : v) a += val;
  return;
}
template <class T>
map<T, long long> cntv(vector<T> v) {
  map<T, long long> m;
  for (auto &g : v) {
    if (m.count(g))
      m[g]++;
    else
      m[g] = 1;
  }
  return m;
}
template <class T>
vector<long long> press(vector<T> &v) {
  long long n = v.size();
  vector<long long> w(n);
  map<T, long long> m;
  for (T &p : v) m[p] = 0;
  long long i = 0;
  for (auto &p : m) {
    p.second = i;
    i++;
  }
  for (long long i = 0; i < n; i++) w.at(i) = m[v.at(i)];
  return w;
}
template <class T>
T divup(T a, T b) {
  assert(b != 0);
  T x = abs(a);
  T y = abs(b);
  T z = (x + y - 1) / y;
  if ((a < 0 && b > 0) || (a > 0 && b < 0))
    return -z;
  else if (a == 0)
    return 0;
  else
    return z;
}
long long POW(long long a, long long n) {
  long long res = 1;
  while (n > 0) {
    if (n & 1) res = res * a;
    a = a * a;
    n >>= 1;
  }
  return res;
}
template <class T>
int sgn(T x) {
  if (x < 0) return -1;
  if (x == 0) return 0;
  return 1;
}
long long modpow(long long a, long long n, long long mod) {
  if (mod == 1) return 0LL;
  long long res = 1;
  while (n > 0) {
    if (n & 1) res = res * a % mod;
    a = a * a % mod;
    n >>= 1;
  }
  return res;
}
long long modinv(long long a, long long mod) {
  long long b = mod, u = 1, v = 0;
  while (b) {
    long long t = a / b;
    a -= t * b;
    swap(a, b);
    u -= t * v;
    swap(u, v);
  }
  u %= mod;
  if (u < 0) u += mod;
  return u;
}
vvll comb(100, vll(100, -1));
long long com(long long n, long long k) {
  assert(n < 100 && k < 100);
  if (n < k || k < 0 || n < 0) return 0;
  if (comb[n][k] != -1) return comb[n][k];
  ll res;
  if (n - k < k)
    res = com(n, n - k);
  else if (k == 0)
    res = 1;
  else
    res = com(n - 1, k - 1) + com(n - 1, k);
  comb[n][k] = res;
  return res;
}
const ll MAX = 5100000;
long long fac[MAX], finv[MAX], inv[MAX];
void cominit() {
  fac[0] = fac[1] = 1;
  finv[0] = finv[1] = 1;
  inv[1] = 1;
  for (ll i = 2; i < MAX; i++) {
    fac[i] = fac[i - 1] * i % mod;
    inv[i] = mod - inv[mod % i] * (mod / i) % mod;
    finv[i] = finv[i - 1] * inv[i] % mod;
  }
}
long long commod(ll n, ll k) {
  if (n < k) return 0;
  if (n < 0 || k < 0) return 0;
  return fac[n] * (finv[k] * finv[n - k] % mod) % mod;
}
long long pmod(ll n, ll k) {
  if (n < k) return 0;
  if (n < 0 || k < 0) return 0;
  return fac[n] * finv[n - k] % mod;
}
long long hmod(ll n, ll k) { return commod(n + k - 1, n); }
template <class T>
void scan(T &a) {
  cin >> a;
}
template <class T>
void scan(vector<T> &a) {
  for (auto &i : a) scan(i);
}
template <class T, class L>
void scan(pair<T, L> &p) {
  scan(p.first);
  scan(p.second);
}
void INPUT() {}
template <class Head, class... Tail>
void INPUT(Head &head, Tail &...tail) {
  scan(head);
  INPUT(tail...);
}
template <class T>
inline void print(T x) {
  cout << x << '\n';
}
template <typename T1, typename T2>
istream &operator>>(istream &is, pair<T1, T2> &p) {
  is >> p.first >> p.second;
  return is;
}
template <typename T1, typename T2>
ostream &operator<<(ostream &os, const pair<T1, T2> &p) {
  os << p.first << " " << p.second;
  return os;
}
template <class T>
ostream &operator<<(ostream &os, const vector<T> &v) {
  for (int i = 0; i < (int)v.size(); i++) {
    if (i) os << " ";
    os << v[i];
  }
  return os;
}
template <typename T>
void view(const T e) {
  std::cerr << e;
}
template <typename T, typename U>
void view(const std::pair<T, U> &p) {
  std::cerr << "(";
  view(p.first);
  cerr << ", ";
  view(p.second);
  cerr << ")";
}
template <typename T>
void view(std::set<T> &s) {
  if (s.empty()) {
    cerr << "{ }";
    return;
  }
  std::cerr << "{ ";
  for (auto &t : s) {
    view(t);
    std::cerr << ", ";
  }
  std::cerr << "\b\b }";
}
template <typename T>
void view(const std::vector<T> &v) {
  if (v.empty()) {
    cerr << "{ }";
    return;
  }
  std::cerr << "{ ";
  for (const auto &e : v) {
    view(e);
    std::cerr << ", ";
  }
  std::cerr << "\b\b }";
}
template <typename T>
void view(const std::vector<std::vector<T>> &vv) {
  std::cerr << "{\n";
  for (const auto &v : vv) {
    std::cerr << "\t";
    view(v);
    cerr << "\n";
  }
  std::cerr << "}";
}
template <typename T, typename U>
void view(const std::vector<std::pair<T, U>> &v) {
  std::cerr << "{\n";
  for (const auto &c : v) {
    std::cerr << "\t(";
    view(c.first);
    cerr << ", ";
    view(c.second);
    cerr << ")\n";
  }
  std::cerr << "}";
}
template <typename T, typename U>
void view(const std::map<T, U> &m) {
  std::cerr << "{\n";
  for (auto &t : m) {
    std::cerr << "\t[";
    view(t.first);
    cerr << "] : ";
    view(t.second);
    cerr << "\n";
  }
  std::cerr << "}";
}
struct mint {
  long long x;
  mint(long long x = 0) : x((x % mod + mod) % mod) {}
  mint operator-() const { return mint(-x); }
  mint &operator+=(const mint a) {
    if ((x += a.x) >= mod) x -= mod;
    return *this;
  }
  mint &operator-=(const mint a) {
    if ((x += mod - a.x) >= mod) x -= mod;
    return *this;
  }
  mint &operator*=(const mint a) {
    (x *= a.x) %= mod;
    return *this;
  }
  mint operator+(const mint a) const { return mint(*this) += a; }
  mint operator-(const mint a) const { return mint(*this) -= a; }
  mint operator*(const mint a) const { return mint(*this) *= a; }
  mint pow(long long t) const {
    if (!t) return 1;
    mint a = pow(t >> 1);
    a *= a;
    if (t & 1) a *= *this;
    return a;
  }
  mint inv() const { return pow(mod - 2); }
  mint &operator/=(const mint a) { return *this *= a.inv(); }
  mint operator/(const mint a) const { return mint(*this) /= a; }
};
ostream &operator<<(ostream &os, const mint &a) { return os << a.x; }
int main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  cout << fixed << setprecision(15);
  srand((unsigned)time(NULL));
  int n;
  INPUT(n);
  vector<ll> v(n);
  INPUT(v);
  V<mint> cnt(11);
  vvll keta(n);
  for (long long i = 0; i < (n); i++) {
    ll now = v[i];
    while (now) {
      keta[i].push_back(now % 10);
      now /= 10;
    }
    int k = keta[i].size();
    cnt[k] += 1;
  }
  vector<mint> a(11), b(11);
  for (long long i = 0; i < (n); i++) {
    ll now = v[i];
    vll vec = keta[i];
    int k = vec.size();
    for (long long aite = (1); aite < (11); aite++) {
      vector<int> pla(k);
      pla[0] = 1;
      for (long long i = 0; i < (k - 1); i++) {
        if (i < aite - 1) {
          pla[i + 1] = pla[i] + 2;
        } else {
          pla[i + 1] = pla[i] + 1;
        }
      }
      (void(0));
      for (long long j = 0; j < (k); j++) {
        mint m = modpow(10, pla[j], mod) * vec[j];
        a[aite] += m;
      }
    }
  }
  for (long long i = 0; i < (n); i++) {
    ll now = v[i];
    vll vec = keta[i];
    int k = vec.size();
    for (long long aite = (1); aite < (11); aite++) {
      vector<int> pla(k);
      pla[0] = 0;
      for (long long i = 0; i < (k - 1); i++) {
        if (i <= aite - 1) {
          pla[i + 1] = pla[i] + 2;
        } else {
          pla[i + 1] = pla[i] + 1;
        }
      }
      (void(0));
      for (long long j = 0; j < (k); j++) {
        mint m = modpow(10, pla[j], mod) * vec[j];
        b[aite] += m;
      }
    }
  }
  (void(0));
  (void(0));
  (void(0));
  mint ans = 0;
  for (long long i = (1); i < (11); i++) {
    ans += cnt[i] * (a[i] + b[i]);
  }
  cout << ans << endl;
}
