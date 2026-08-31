#include <bits/stdc++.h>
using namespace std;
template <class t>
inline t read(t &x) {
  char c = getchar();
  bool f = 0;
  x = 0;
  while (!isdigit(c)) f |= c == '-', c = getchar();
  while (isdigit(c)) x = (x << 1) + (x << 3) + (c ^ 48), c = getchar();
  if (f) x = -x;
  return x;
}
template <class t, class... A>
inline void read(t &x, A &...a) {
  read(x);
  read(a...);
}
template <class t>
inline void write(t x) {
  if (x < 0)
    putchar('-'), write(-x);
  else {
    if (x > 9) write(x / 10);
    putchar('0' + x % 10);
  }
}
const long long N = 1e5 + 5;
long long ans, a1, a2, b1, b2, n, k, inv[N << 1], mod;
long long fpow(long long x, long long y) {
  long long res = 1;
  for (; y; y >>= 1, x = x * x % mod)
    if (y & 1) res = res * x % mod;
  return res;
}
void dico(long long l, long long r, long long h) {
  if (h == 1 || l == r) {
    l = r - l + 1;
    if (!a1)
      a1 = l, b1 = 1;
    else if (a1 == l)
      b1++;
    else
      a2 = l, b2++;
    return;
  }
  long long mid = l + r >> 1;
  dico(l, mid, h - 1);
  dico(mid + 1, r, h - 1);
}
long long calc(long long n, long long m) {
  long long res = 0;
  for (long long i = 2; i <= n + m; i++)
    res = (res + inv[i] * min(i - 1, n + m - i + 1) % mod) % mod;
  return mod - res;
}
void init(long long n) {
  inv[1] = 1;
  for (long long i = 2; i <= n; i++)
    inv[i] = (mod - mod / i) * inv[mod % i] % mod;
}
signed main() {
  read(n, k, mod);
  ans = n * (n - 1) / 2 * (mod + 1 >> 1) % mod;
  init(n << 1);
  dico(1, n, k);
  ans = (ans + b1 * (b1 - 1) / 2 * calc(a1, a1) % mod) % mod;
  if (a2) {
    ans = (ans + b2 * (b2 - 1) / 2 * calc(a2, a2) % mod) % mod;
    ans = (ans + b1 * b2 % mod * calc(a1, a2) % mod) % mod;
  }
  write(ans);
}
