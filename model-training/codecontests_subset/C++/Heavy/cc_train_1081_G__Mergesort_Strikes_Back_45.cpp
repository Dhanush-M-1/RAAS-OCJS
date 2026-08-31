#include <bits/stdc++.h>
using namespace std;
template <typename T>
inline bool chkmin(T &x, T y) {
  return (y < x) ? (x = y, 1) : 0;
}
template <typename T>
inline bool chkmax(T &x, T y) {
  return (y > x) ? (x = y, 1) : 0;
}
inline int read() {
  int x;
  char c;
  int f = 1;
  while ((c = getchar()) != '-' && (c > '9' || c < '0'))
    ;
  if (c == '-') f = -1, c = getchar();
  x = c ^ '0';
  while ((c = getchar()) >= '0' && c <= '9')
    x = (x << 1) + (x << 3) + (c ^ '0');
  return x * f;
}
inline long long readll() {
  long long x;
  char c;
  int f = 1;
  while ((c = getchar()) != '-' && (c > '9' || c < '0'))
    ;
  if (c == '-') f = -1, c = getchar();
  x = c ^ '0';
  while ((c = getchar()) >= '0' && c <= '9')
    x = (x << 1ll) + (x << 3ll) + (c ^ '0');
  return x * f;
}
int n, m, mod, ans;
int ksm(int x, int y) {
  int res = 1;
  while (y) {
    if (y & 1) res = (long long)res * x % mod;
    x = (long long)x * x % mod;
    y >>= 1;
  }
  return res;
}
int main() {
  n = read(), m = read() - 1, mod = read();
  for (register int i = 1, iend = m; i <= iend; ++i)
    if (n / (1 << i) == 0) return printf("0\n"), 0;
  int u = n / (1 << m), v = u + 1;
  int t2 = n - ((n / (1 << m)) << m), t1 = (1 << m) - t2;
  ans =
      (ans + (long long)u * (u - 1) / 2 % mod * (mod + 1) / 2 % mod * t1) % mod;
  ans =
      (ans + (long long)v * (v - 1) / 2 % mod * (mod + 1) / 2 % mod * t2) % mod;
  for (register int i = 2, iend = u + v; i <= iend; ++i)
    ans =
        (ans + (long long)t1 * t2 % mod * (min(i - 1, u) - max(1, i - v) + 1) %
                   mod * (i - 2) % mod * ksm(i * 2, mod - 2)) %
        mod;
  for (register int i = 2, iend = u * 2; i <= iend; ++i)
    ans = (ans + (long long)t1 * (t1 - 1) / 2 % mod *
                     (min(i - 1, u) - max(1, i - u) + 1) % mod * (i - 2) % mod *
                     ksm(i * 2, mod - 2)) %
          mod;
  t1 = t2, u = v;
  for (register int i = 2, iend = u * 2; i <= iend; ++i)
    ans = (ans + (long long)t1 * (t1 - 1) / 2 % mod *
                     (min(i - 1, u) - max(1, i - u) + 1) % mod * (i - 2) % mod *
                     ksm(i * 2, mod - 2)) %
          mod;
  printf("%d\n", ans);
  return 0;
}
