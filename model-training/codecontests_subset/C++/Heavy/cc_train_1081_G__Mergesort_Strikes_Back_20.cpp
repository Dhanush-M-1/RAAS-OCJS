#include <bits/stdc++.h>
using namespace std;
template <class T>
inline void rd(T &x) {
  char ch;
  x = 0;
  bool fl = false;
  while (!isdigit(ch = getchar())) (ch == '-') && (fl = true);
  for (x = (ch ^ '0'); isdigit(ch = getchar()); x = x * 10 + (ch ^ '0'))
    ;
  (fl == true) && (x = -x);
}
template <class T>
inline void output(T x) {
  if (x / 10) output(x / 10);
  putchar(x % 10 + '0');
}
template <class T>
inline void ot(T x) {
  if (x < 0) putchar('-'), x = -x;
  output(x);
  putchar(' ');
}
template <class T>
inline void prt(T a[], int st, int nd) {
  for (register int i = st; i <= nd; ++i) ot(a[i]);
  putchar('\n');
}
namespace Modulo {
int mod;
inline int ad(int x, int y) { return x + y >= mod ? x + y - mod : x + y; }
inline int sub(int x, int y) { return ad(x, mod - y); }
inline int mul(int x, int y) { return (long long)x * y % mod; }
inline void inc(int &x, int y) { x = ad(x, y); }
inline void inc2(int &x, int y) { x = mul(x, y); }
inline int qm(int x, int y = mod - 2) {
  int ret = 1;
  while (y) {
    if (y & 1) ret = mul(x, ret);
    x = mul(x, x);
    y >>= 1;
  }
  return ret;
}
template <class... Args>
inline int ad(const int a, const int b, const Args &...args) {
  return ad(ad(a, b), args...);
}
template <class... Args>
inline int mul(const int a, const int b, const Args &...args) {
  return mul(mul(a, b), args...);
}
}  // namespace Modulo
using namespace Modulo;
namespace Miracle {
const int N = 1e5 + 5;
int n, k;
int iv[N], s[N];
int l1, l2, c1, c2;
void divi(int l, int r, int d) {
  if (d == k || l == r) {
    if (!l1) {
      l1 = r - l + 1;
      ++c1;
    } else if (r - l + 1 == l1)
      ++c1;
    else if (!l2)
      l2 = r - l + 1, ++c2;
    else
      ++c2;
    return;
  }
  int mid = (l + r) >> 1;
  divi(l, mid, d + 1);
  divi(mid + 1, r, d + 1);
}
int calc(int l1, int l2) {
  if (!l1 || !l2) return 0;
  int ret = mul(l1, l2, qm(2));
  for (register int i = 1; i <= l1; ++i) {
    ret = sub(ret, sub(s[i + l2], s[i]));
  }
  return ret;
}
int main() {
  rd(n);
  rd(k);
  rd(mod);
  iv[1] = 1;
  for (register int i = 2; i <= n; ++i) {
    iv[i] = mul(mod - mod / i, iv[mod % i]);
  }
  for (register int i = 1; i <= n; ++i) s[i] = ad(s[i - 1], iv[i]);
  divi(1, n, 1);
  int ans = ad(mul(c1, l1, (l1 - 1), qm(4)), mul(c2, l2, (l2 - 1), qm(4)));
  inc(ans, mul(c1, c1 - 1, qm(2), calc(l1, l1)));
  inc(ans, mul(c2, c2 - 1, qm(2), calc(l2, l2)));
  inc(ans, mul(c1, c2, calc(l1, l2)));
  ot(ans);
  return 0;
}
}  // namespace Miracle
signed main() {
  Miracle::main();
  return 0;
}
