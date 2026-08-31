#include <bits/stdc++.h>
#pragma GCC optimize("fast-math")
#pragma GCC optimize("Ofast")
#pragma GCC optimize("unroll-loops")
#pragma GCC diagnostic ignored "-Woverflow"
using namespace std;
const short INF16 = ~(1 << 15);
const int INF32 = 2e9 + 11;
const int SZ = (1 << 19);
const int SZ2 = int(1e6 + 11);
const int mod = 998244353;
const int mod2 = 998244353;
const int PIVO = 5e5 + 11;
const long long INF64 = 8e18;
const long long P1 = 53;
const long long P2 = 47;
const long double eps = 1e-10;
const long double PI = acosl(-1);
inline long long MOD(long long x) {
  x %= mod, x += mod;
  return x % mod;
}
inline long long MOD(long long x, long long m) {
  x %= m, x += m;
  return x % m;
}
inline long long T(int x) { return 1ll * x * (x + 1) >> 1; }
inline long long TT(int x) { return 1ll * x * (x + 1) * (x + 2) / 6; }
inline long long gcd(long long a, long long b) { return b ? gcd(b, a % b) : a; }
inline long long lcm(long long a, long long b) { return a * b / gcd(a, b); }
long long fpow(long long a, long long b, long long mod) {
  if (!b) return 1;
  if (b == 1) return a % mod;
  if (b & 1) return fpow(a, b ^ 1, mod) * a % mod;
  long long d = fpow(a, b >> 1, mod);
  return d * d % mod;
}
long long fpow(long long a, long long b) {
  if (!b) return 1;
  if (b == 1) return a;
  if (b & 1) return fpow(a, b ^ 1) * a;
  long long d = fpow(a, b >> 1);
  return d * d;
}
long long n;
pair<long long, long long> t[SZ << 1];
pair<long long, long long> operator+(pair<long long, long long> a,
                                     pair<long long, long long> b) {
  return {a.first + b.first, a.second + b.second};
}
void Biuld(long long v, long long l, long long r) {
  if (r - l == 1) return;
  long long mid = (l + r) >> 1;
  Biuld(v << 1, l, mid);
  Biuld(v << 1 | 1, mid, r);
  t[v] = t[v << 1] + t[v << 1 | 1];
}
void upd(long long v, long long l, long long r, long long k, long long x) {
  if (r - l == 1) {
    t[v] = {x, 0};
    return;
  }
  long long mid = (l + r) >> 1;
  if (k < mid)
    upd(v << 1, l, mid, k, x);
  else
    upd(v << 1 | 1, mid, r, k, x);
  t[v] = t[v << 1] + t[v << 1 | 1];
}
pair<long long, long long> get(long long v, long long l, long long r,
                               long long ql, long long qr) {
  if (qr <= l || r <= ql) return {0, 0};
  if (ql <= l && r <= qr) return t[v];
  long long mid = (l + r) >> 1;
  return get(v << 1, l, mid, ql, qr) + get(v << 1 | 1, mid, r, ql, qr);
}
bool cmp(pair<pair<long long, long long>, long long> &a,
         pair<pair<long long, long long>, long long> &b) {
  if (a.first.second != b.first.second) return a.first.second < b.first.second;
  return a.first.first < b.first.first;
}
void Solve(long long num_test) {
  cin >> n;
  vector<pair<pair<long long, long long>, long long>> v(n);
  for (auto &i : v) cin >> i.first.first;
  for (auto &i : v) cin >> i.first.second;
  sort(v.begin(), v.end(), cmp);
  for (long long i = 0; i < n; i++) {
    t[SZ + i] = {v[i].first.first, 1};
    v[i].second = i;
  }
  Biuld(1, 0, SZ);
  sort(v.begin(), v.end());
  long long ans = 0;
  for (long long i = 0; i < n; i++) {
    long long id = v[i].second;
    ans += get(1, 0, SZ, id, n).first -
           get(1, 0, SZ, id, n).second * v[i].first.first;
    upd(1, 0, SZ, id, 0);
  }
  cout << ans << endl;
}
signed main() {
  ios_base::sync_with_stdio(NULL);
  cin.tie(NULL);
  cout.tie(NULL);
  cout << fixed << setprecision(10);
  srand(time(NULL));
  long long test = 1;
  for (long long i = 1; i <= test; i++) Solve(i);
}
