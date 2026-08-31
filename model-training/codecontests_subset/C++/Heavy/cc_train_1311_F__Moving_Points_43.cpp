#include <bits/stdc++.h>
#pragma GCC optimize(2)
using namespace std;
const int inf = 0x3f3f3f3f;
const int MOD = 1e9 + 7;
const double eps = 1e-4;
const double pi = acos(-1.0);
void debug() { cerr << '\n'; }
template <typename T, typename... Ts>
void debug(T x, Ts... y) {
  cerr << "\033[31m" << x << "\033[0m";
  if (sizeof...(y) > 0) cerr << ' ';
  debug(y...);
}
template <typename T>
void debug(const T &a, int l, int r, char c) {
  for (int i = l; i <= r; ++i)
    cerr << "\033[31m" << a[i] << "\033[0m" << (i == r ? '\n' : c);
}
template <typename T>
void debug(vector<T> a) {
  for (int i = 0; i < (int)a.size(); ++i)
    cerr << "\033[31m" << a[i] << "\033[31m"
         << " \n"[i == ((int)a.size() - 1)];
}
long long gcd(long long a, long long b) { return b == 0 ? a : gcd(b, a % b); }
long long lcm(long long a, long long b) { return a / gcd(a, b) * b; }
long long qpow(long long x, long long y) {
  long long ans = 1;
  for (; y > 0; y >>= 1) {
    if (y & 1) ans *= x;
    x *= x;
  }
  return ans;
}
long long qpow(long long x, long long y, int MOD) {
  long long ans = 1;
  for (; y > 0; y >>= 1) {
    if (y & 1) ans = ans * x % MOD;
    x = x * x % MOD;
  }
  return ans;
}
void exgcd(long long a, long long b, long long &x, long long &y) {
  if (!b) {
    x = 1;
    y = 0;
    return;
  }
  exgcd(b, a % b, x, y);
  long long X = x;
  x = y;
  y = X - a / b * y;
}
long long inv(long long x, int mod = MOD) { return qpow(x, mod - 2, mod); }
long long m_m(long long a, int mod = MOD) { return (a % mod + mod) % mod; }
const int N = 2e5 + 5;
vector<pair<long long, int>> tr(N + 1);
int tot;
int lsh[N];
void add(int x, int v) {
  for (; x <= tot; x += -x & x) tr[x].first += v, ++tr[x].second;
}
pair<long long, int> qy(int x) {
  pair<long long, int> ans;
  for (; x > 0; x -= -x & x)
    ans.first += tr[x].first, ans.second += tr[x].second;
  return ans;
}
signed main() {
  ios::sync_with_stdio(false), cin.tie(0), cout.tie(0);
  int n;
  cin >> n;
  vector<pair<int, int>> a(n + 1);
  for (int i = (1); i < (n + 1); ++i) cin >> a[i].first;
  for (int i = (1); i < (n + 1); ++i) {
    cin >> a[i].second;
    lsh[i] = a[i].second;
  }
  sort(a.begin(), a.end());
  sort(lsh + 1, lsh + n + 1);
  tot = unique(lsh + 1, lsh + n + 1) - lsh;
  long long ans = 0;
  for (int i = (1); i < (n + 1); ++i) {
    int j = lower_bound(lsh + 1, lsh + tot, a[i].second) - lsh;
    pair<long long, int> t = qy(j);
    ans += 1ll * a[i].first * t.second - t.first;
    add(j, a[i].first);
  }
  cout << ans;
  return 0;
}
