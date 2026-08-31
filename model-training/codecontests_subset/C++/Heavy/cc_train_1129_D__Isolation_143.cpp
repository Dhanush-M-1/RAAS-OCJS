#include <bits/stdc++.h>
namespace _ {
const int inf = 1e9;
const int mod = 998244353;
const double eps = 1e-8;
namespace IO_IN {
char buf[1 << 23], *p1 = buf, *p2 = buf;
int getc() {
  return p1 == p2 && (p2 = (p1 = buf) + fread(buf, 1, 1 << 23, stdin), p1 == p2)
             ? EOF
             : *p1++;
}
template <class T>
inline T read() {
  char ch;
  bool flag = 0;
  T x = 0;
  while (ch = getc(), !isdigit(ch))
    if (ch == '-') flag = 1;
  while (isdigit(ch)) x = x * 10 + ch - 48, ch = getc();
  return flag ? -x : x;
}
struct {
  inline operator int() { return read<int>(); }
  inline operator long long() { return read<long long>(); }
  template <class T>
  inline void operator()(T &x) {
    x = *this;
  }
  template <class T, class... A>
  inline void operator()(T &x, A &...a) {
    x = *this, this->operator()(a...);
  }
} IN;
}  // namespace IO_IN
using namespace IO_IN;
namespace IO_OUT {
char buf[1 << 23];
int p1 = -1;
const int p2 = (1 << 23) - 1;
void flush() { fwrite(buf, 1, p1 + 1, stdout), p1 = -1; }
void putc(const char &x) {
  if (p1 == p2) flush();
  buf[++p1] = x;
}
template <class T>
inline void print(T x) {
  static char tmp[15];
  static int len = -1;
  if (x >= 0) do {
      tmp[++len] = x % 10 + 48, x /= 10;
    } while (x);
  else {
    putc('-');
    do {
      tmp[++len] = -(x % 10) + 48, x /= 10;
    } while (x);
  }
  while (len >= 0) putc(tmp[len]), --len;
}
template <class T>
inline void print_(T x) {
  print(x), flush(), putchar(' ');
}
template <class T>
inline void _print(T x) {
  print(x), flush(), putchar('\n');
}
}  // namespace IO_OUT
using namespace IO_OUT;
namespace Std_Function {
template <class T>
inline bool chkmax(T &x, T y) {
  x = x > y ? x : y;
  return x == y;
}
template <class T>
inline bool chkmin(T &x, T y) {
  x = x < y ? x : y;
  return x == y;
}
}  // namespace Std_Function
using namespace Std_Function;
namespace Math_Function {
template <class T>
inline bool dcmp(T x, T y) {
  return fabs(x - y) < eps;
}
template <class T>
inline T gcd(T x, T y) {
  return y ? gcd(y, x % y) : x;
}
}  // namespace Math_Function
using namespace Math_Function;
namespace Mod_Function {
inline int mul(int x, int y) { return 1ll * x * y % mod; }
inline int dec(int x, int y) {
  x -= y;
  if (x < 0) x += mod;
  return x;
}
inline int add(int x, int y) {
  x += y;
  if (x >= mod) x -= mod;
  return x;
}
inline void pls(int &x, int y) {
  x += y;
  if (x >= mod) x -= mod;
}
inline void sub(int &x, int y) {
  x -= y;
  if (x < 0) x += mod;
}
inline int modpow(int x, int y, int res = 1) {
  for (; y; y >>= 1, x = mul(x, x))
    if (y & 1) res = mul(res, x);
  return res;
}
}  // namespace Mod_Function
using namespace Mod_Function;
}  // namespace _
using namespace _;
const int N = 1e5 + 5;
const int S = 320;
using namespace std;
int n, k, a[N], dp[N], las[N], pre[N];
int L[S], R[S], bel[N], cnt[N], ans[S], tag[S], sum[S][N];
inline void update(int x, int v) {
  if (cnt[x] + tag[bel[x]] <= k) sub(ans[bel[x]], dp[x]);
  cnt[x] += v, pls(sum[bel[x]][cnt[x]], dp[x]),
      sub(sum[bel[x]][cnt[x] - v], dp[x]);
  if (cnt[x] + tag[bel[x]] <= k) pls(ans[bel[x]], dp[x]);
}
inline void modify(int l, int r, int v) {
  if (l > r) return;
  if (bel[l] == bel[r])
    for (int i = l; i <= r; ++i) update(i, v);
  else {
    for (int i = l; i <= R[bel[l]]; ++i) update(i, v);
    for (int i = L[bel[r]]; i <= r; ++i) update(i, v);
    for (int i = bel[l] + 1; i <= bel[r] - 1; ++i)
      sub(ans[i], (v > 0 && (k - tag[i] >= 0)) ? sum[i][k - tag[i]] : 0),
          tag[i] += v,
          pls(ans[i], (v < 0 && (k - tag[i] >= 0)) ? sum[i][k - tag[i]] : 0);
  }
}
int main() {
  IN(n, k);
  for (int i = 1; i <= n; ++i) IN(a[i]);
  int siz = sqrt(n), id = 1;
  R[0] = L[0] = -1;
  for (int t = 0; t <= n; t += siz) {
    L[id] = t, R[id] = min(t + siz - 1, n);
    for (int i = L[id]; i <= R[id]; ++i) bel[i] = id;
    ++id;
  }
  dp[0] = sum[1][0] = ans[1] = 1;
  for (int i = 1; i <= n; ++i) {
    las[i] = pre[a[i]], pre[a[i]] = i;
    modify(las[las[i]], las[i] - 1, -1), modify(las[i], i - 1, 1);
    int tmp = 0;
    while (R[tmp + 1] < i) pls(dp[i], ans[++tmp]);
    for (int j = R[tmp] + 1; j < i; ++j)
      if (cnt[j] + tag[bel[j]] <= k) pls(dp[i], dp[j]);
    pls(sum[bel[i]][0], dp[i]);
    if (tag[bel[i]] <= k) pls(ans[bel[i]], dp[i]);
  }
  _print(dp[n]);
  return 0;
}
