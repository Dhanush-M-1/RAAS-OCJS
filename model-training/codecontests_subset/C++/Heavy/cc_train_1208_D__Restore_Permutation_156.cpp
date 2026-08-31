#include <bits/stdc++.h>
using namespace std;
const long long maxn = 1000005;
const long long inf = 0x3f3f3f3f3f3f3f3f;
const long long MOD = 100000007;
const double eps = 1e-10;
long long qpow(long long a, long long b) {
  long long tmp = a % MOD, ans = 1;
  while (b) {
    if (b & 1) {
      ans *= tmp, ans %= MOD;
    }
    tmp *= tmp, tmp %= MOD, b >>= 1;
  }
  return ans;
}
long long lowbit(long long x) { return x & -x; }
long long max(long long a, long long b) { return a > b ? a : b; }
long long min(long long a, long long b) { return a < b ? a : b; }
long long mmax(long long a, long long b, long long c) {
  return max(a, max(b, c));
}
long long mmin(long long a, long long b, long long c) {
  return min(a, min(b, c));
}
void mod(long long &a) {
  a += MOD;
  a %= MOD;
}
bool chk(long long now) {}
long long half(long long l, long long r) {
  while (l <= r) {
    long long m = (l + r) / 2;
    if (chk(m))
      r = m - 1;
    else
      l = m + 1;
  }
  return l;
}
long long ll(long long p) { return p << 1; }
long long rr(long long p) { return p << 1 | 1; }
long long mm(long long l, long long r) { return (l + r) / 2; }
long long lg(long long x) {
  if (x == 0) return 1;
  return (long long)log2(x) + 1;
}
bool smleql(double a, double b) {
  if (a < b || fabs(a - b) <= eps) return true;
  return false;
}
double len(double a, double b, double c, double d) {
  return sqrt((a - c) * (a - c) + (b - d) * (b - d));
}
bool isp(long long x) {
  if (x == 1) return false;
  if (x == 2) return true;
  for (long long i = 2; i * i <= x; ++i)
    if (x % i == 0) return false;
  return true;
}
long long n;
long long s[maxn], h[maxn], a[maxn];
long long mx[maxn], mn[maxn];
long long tag[maxn];
void up(long long p) {
  mx[p] = max(mx[ll(p)], mx[rr(p)]);
  mn[p] = min(mn[ll(p)], mn[rr(p)]);
}
void down(long long p, long long l, long long r) {
  if (tag[p]) {
    long long m = mm(l, r);
    tag[ll(p)] += tag[p];
    tag[rr(p)] += tag[p];
    mx[ll(p)] += tag[p];
    mx[rr(p)] += tag[p];
    mn[ll(p)] += tag[p];
    mn[rr(p)] += tag[p];
    tag[p] = 0;
  }
}
pair<long long, long long> ask(long long p, long long l, long long r,
                               long long L, long long R) {
  if (L <= l && r <= R) {
    return make_pair(mn[p], mx[p]);
  }
  down(p, l, r);
  pair<long long, long long> le = make_pair(inf, -1), ri = make_pair(inf, -1);
  long long m = mm(l, r);
  if (L <= m) le = ask(ll(p), l, m, L, R);
  if (R > m) ri = ask(rr(p), m + 1, r, L, R);
  up(p);
  return make_pair(min(le.first, ri.first), max(le.second, ri.second));
}
void change(long long p, long long l, long long r, long long L, long long R,
            long long v) {
  if (L <= l && r <= R) {
    mx[p] += v;
    mn[p] += v;
    tag[p] += v;
    return;
  }
  down(p, l, r);
  long long m = mm(l, r);
  if (L <= m) change(ll(p), l, m, L, R, v);
  if (R > m) change(rr(p), m + 1, r, L, R, v);
  up(p);
}
void build(long long p = 1, long long l = 1, long long r = n) {
  if (l == r) {
    mx[p] = h[l];
    mn[p] = h[l];
    return;
  }
  long long m = mm(l, r);
  build(ll(p), l, m);
  build(rr(p), m + 1, r);
  up(p);
}
long long get(long long l, long long r, long long v) {
  if (l == r) return l;
  long long m = mm(l, r);
  pair<long long, long long> le = make_pair(inf, -1), ri = make_pair(inf, -1);
  if (l <= m) le = ask(1, 1, n, l, m);
  if (le.first <= v && le.second >= v)
    return get(l, m, v);
  else
    return get(m + 1, r, v);
}
signed main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0), cout.tie(0);
  cin >> n;
  for (long long i = 1; i <= 200000; ++i) h[i] = i * (i - 1) / 2;
  for (long long i = 1; i <= n; ++i) cin >> s[i];
  build();
  for (long long i = n; i >= 1; --i) {
    a[i] = get(1, n, s[i]);
    if (a[i] < n) change(1, 1, n, a[i] + 1, n, -a[i]);
    change(1, 1, n, a[i], a[i], -10000000);
  }
  for (long long i = 1; i <= n; ++i) cout << a[i] << ' ';
  return 0;
}
