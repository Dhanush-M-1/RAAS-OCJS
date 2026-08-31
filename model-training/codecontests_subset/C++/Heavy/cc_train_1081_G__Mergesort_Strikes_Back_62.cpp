#include <bits/stdc++.h>
using namespace std;
template <class T>
inline void in(T &x) {
  x = 0;
  char c = getchar();
  bool f = 0;
  while (!isdigit(c)) f |= (c == '-'), c = getchar();
  while (isdigit(c)) x = x * 10 + (c ^ '0'), c = getchar();
  f ? x = -x : 0;
}
template <class T>
inline void out(T x, const char c = '\n') {
  static short st[30];
  short m = 0;
  if (x < 0) putchar('-'), x = -x;
  do st[++m] = x % 10, x /= 10;
  while (x);
  while (m) putchar(st[m--] | '0');
  putchar(c);
}
template <class T>
inline void err(const T &x, const char c = '\n') {
  cerr << x << c;
}
template <class T, class... Args>
inline void in(T &x, Args &...args) {
  in(x);
  in(args...);
}
template <class T, class... Args>
inline void out(const T &x, const Args &...args) {
  out(x, ' ');
  out(args...);
}
template <class T, class... Args>
inline void err(const T &x, const Args &...args) {
  err(x, ' ');
  err(args...);
}
template <class T>
inline void prt(T a[], int n) {
  for (register int i = 0; i < n; ++i) out(a[i], i == n - 1 ? '\n' : ' ');
}
template <class T>
inline void clr(T a[], int n) {
  memset(a, 0, sizeof(T) * n);
}
template <class T>
inline void clr(T *a, T *b) {
  memset(a, 0, sizeof(T) * (b - a));
}
template <class T>
inline bool ckmax(T &a, const T &b) {
  return a < b ? a = b, 1 : 0;
}
template <class T>
inline bool ckmin(T &a, const T &b) {
  return a > b ? a = b, 1 : 0;
}
namespace MOD_CALC {
int md;
inline int add(const int a, const int b) {
  return a + b >= md ? a + b - md : a + b;
}
inline int sub(const int a, const int b) {
  return a - b < 0 ? a - b + md : a - b;
}
inline int mul(const int a, const int b) { return (long long)a * b % md; }
inline void inc(int &a, const int b) { (a += b) >= md ? a -= md : 0; }
inline void dec(int &a, const int b) { (a -= b) < 0 ? a += md : 0; }
inline int qpow(int a, int b) {
  int r = 1;
  for (; b; b >>= 1, a = mul(a, a))
    if (b & 1) r = mul(r, a);
  return r;
}
inline int qpow(int a, int b, const int p) {
  int r = 1;
  for (; b; b >>= 1, a = (long long)a * a % p)
    if (b & 1) r = (long long)r * a % p;
  return r;
}
inline int mdinv(const int a) { return qpow(a, md - 2); }
template <class... Args>
inline int add(const int a, const int b, const Args &...args) {
  return add(add(a, b), args...);
}
template <class... Args>
inline int mul(const int a, const int b, const Args &...args) {
  return mul(mul(a, b), args...);
}
}  // namespace MOD_CALC
using namespace MOD_CALC;
namespace i207M {
int iv[200005];
int inv2;
void prework() {
  iv[1] = 1;
  for (register int i = 2; i < 200005; ++i)
    iv[i] = mul(md - md / i, iv[md % i]);
  for (register int i = 2; i < 200005; ++i) inc(iv[i], iv[i - 1]);
}
map<int, int> cnt;
void divide(int l, int r, int h) {
  if (h <= 1 || l == r) {
    ++cnt[r - l + 1];
    return;
  }
  int mid((l + r) / 2);
  divide(l, mid, h - 1);
  divide(mid + 1, r, h - 1);
}
int calc(int a, int b) {
  int res = 0;
  for (register int i = 1; i <= a; ++i) dec(res, sub(iv[i + b], iv[i]));
  inc(res, mul(inv2, mul(a, b)));
  return res;
}
void solve() {
  int ans = 0;
  for (const auto &it : cnt) {
    inc(ans, mul(it.first, it.first - 1, inv2, inv2, it.second));
    inc(ans, mul((long long)it.second * (it.second - 1) / 2 % md,
                 calc(it.first, it.first)));
  }
  for (const auto &it : cnt)
    for (const auto &is : cnt) {
      int x = it.first, y = is.first;
      if (x >= y) continue;
      inc(ans, mul(it.second, is.second, calc(x, y)));
    }
  out(ans);
}
int n, k;
signed main() {
  in(n, k, md);
  inv2 = mdinv(2);
  prework();
  divide(1, n, k);
  solve();
  return 0;
}
}  // namespace i207M
signed main() {
  i207M::main();
  return 0;
}
