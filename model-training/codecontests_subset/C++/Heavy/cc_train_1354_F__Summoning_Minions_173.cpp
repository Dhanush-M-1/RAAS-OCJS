#include <bits/stdc++.h>
using namespace std;
template <typename T>
inline void read(T &x) {
  static char _c;
  static bool _f;
  x = 0;
  _f = 0;
  _c = getchar();
  while (_c < '0' || '9' < _c) {
    if (_c == '-') _f = true;
    _c = getchar();
  }
  while ('0' <= _c && _c <= '9') {
    x = (x << 1) + (x << 3) + (_c & 15);
    _c = getchar();
  }
  if (_f) x = -x;
}
template <typename T, typename... Args>
inline void read(T &x, Args &...args) {
  read(x);
  read(args...);
}
template <typename T>
inline void Min(T &x, T y) {
  if (y < x) x = y;
}
template <typename T>
inline void Max(T &x, T y) {
  if (x < y) x = y;
}
const int INF = 0x3f3f3f3f;
const long long LINF = 0x3f3f3f3f3f3f3f3f;
const double pi = (double)acos(-1.0);
const double eps = (double)1e-8;
const int e5 = (int)1e5 + 5;
const int MOD = (int)1000000007;
template <typename T0, typename T1>
inline void depair(T0 &x, T1 &y, pair<T0, T1> &p) {
  x = p.first, y = p.second;
}
inline int sig(double x) { return x < -eps ? -1 : eps < x; }
long long fp(long long a, long long n, long long mod = MOD) {
  if (n < 0) a = fp(a, mod - 2, mod), n = -n;
  long long res = 1;
  for (; n; n >>= 1, a = a * a % mod)
    if (n & 1) res = res * a % mod;
  return res;
}
struct Mint {
  int x;
  Mint() { x = 0; }
  Mint(int _x) : x(_x) {
    if (x < 0 || x >= MOD) x = (x % MOD + MOD) % MOD;
  }
  Mint(long long _x) : x(_x) {
    if (x < 0 || x >= MOD) x = (x % MOD + MOD) % MOD;
  }
  Mint operator-() const { return Mint(MOD - x); }
  Mint operator+(const Mint &rhs) const {
    return Mint(x + rhs.x >= MOD ? x + rhs.x - MOD : x + rhs.x);
  }
  Mint operator-(const Mint &rhs) const {
    return Mint(x - rhs.x < 0 ? x - rhs.x + MOD : x - rhs.x);
  }
  Mint operator*(const Mint &rhs) const {
    return Mint((long long)x * rhs.x % MOD);
  }
  Mint operator/(const Mint &rhs) const {
    return Mint(x * fp(rhs.x, -1) % MOD);
  }
  Mint &operator+=(const Mint &rhs) {
    x += rhs.x;
    if (x >= MOD) x -= MOD;
    return *this;
  }
  Mint &operator*=(const Mint &rhs) {
    x = ((long long)x * rhs.x) % MOD;
    return *this;
  }
  bool operator==(const Mint &rhs) const { return x == rhs.x; }
  bool operator!=(const Mint &rhs) const { return x != rhs.x; }
  friend ostream &operator<<(ostream &out, const Mint &rhs) {
    return out << rhs.x;
  }
  friend istream &operator>>(istream &in, Mint &rhs) { return in >> rhs.x; }
};
const int maxn = (int)2e5 + 20;
const int maxm = (int)1e6 + 20;
void work() {
  int n, k;
  cin >> n >> k;
  vector<tuple<int, int, int> > a(n);
  for (int i = 0; i < n; i++) {
    int x, y;
    cin >> x >> y;
    a[i] = make_tuple(x, y, i);
  }
  sort(a.begin(), a.end(),
       [](tuple<int, int, int> lhs, tuple<int, int, int> rhs) {
         return get<1>(lhs) < get<1>(rhs);
       });
  vector<vector<int> > dp(n + 1, vector<int>(k + 1, -INF));
  dp[0][0] = 0;
  for (int i = 0; i < n; i++) {
    int x, y, id;
    tie(x, y, id) = a[i];
    for (int j = 0; j <= k; j++) {
      Max(dp[i + 1][j], dp[i][j] + (k - 1) * y);
      if (j != k) Max(dp[i + 1][j + 1], dp[i][j] + x + j * y);
    }
  }
  vector<int> sta(n, -1);
  int ni = n, nj = k;
  int cnt = k;
  while (ni) {
    int x, y, id;
    tie(x, y, id) = a[ni - 1];
    if (nj && dp[ni - 1][nj - 1] + (nj - 1) * y + x == dp[ni][nj]) {
      sta[id] = cnt--;
      nj--;
    }
    ni--;
  }
  vector<int> opt;
  for (int i = 1; i <= k; i++) {
    if (i == k) {
      for (int j = 0; j < n; j++)
        if (sta[j] == -1) opt.push_back(j + 1), opt.push_back(-j - 1);
    }
    for (int j = 0; j < n; j++)
      if (sta[j] == i) opt.push_back(j + 1);
  }
  cout << opt.size() << endl;
  for (int i = 0; i < opt.size(); i++) {
    cout << opt[i];
    if (i != opt.size() - 1) cout << " ";
  }
  cout << endl;
}
int main(int argc, char **argv) {
  int tc = 1;
  read(tc);
  for (int ca = 1; ca <= tc; ca++) {
    work();
  }
  return 0;
}
