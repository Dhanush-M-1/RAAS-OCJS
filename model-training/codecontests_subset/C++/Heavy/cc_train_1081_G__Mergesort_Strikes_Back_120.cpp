#include <bits/stdc++.h>
using namespace std;
const long long N = 1e6 + 5;
long long n, k, gs, ans, mod, len[N], jc[N], inv[N], sum[N], ycl[2005][2005];
inline long long read() {
  long long res = 0, f = 1;
  char c = getchar();
  while (!isdigit(c)) {
    if (c == '-') f = -1;
    c = getchar();
  }
  while (isdigit(c)) {
    res = res * 10 + c - 48;
    c = getchar();
  }
  return res * f;
}
void build(long long l, long long r, long long h) {
  if (h <= 1 || l == r) {
    len[++gs] = r - l + 1;
    return;
  }
  long long mid = (l + r) / 2;
  build(l, mid, h - 1);
  build(mid + 1, r, h - 1);
}
long long C(long long n, long long m) {
  if (n < 0 || m < 0 || n < m) return 0;
  return jc[n] * inv[m] % mod * inv[n - m] % mod;
}
signed main() {
  n = read();
  k = read();
  mod = read();
  jc[0] = jc[1] = inv[0] = inv[1] = 1;
  for (long long i = 2; i <= 100000; i++) jc[i] = jc[i - 1] * i % mod;
  for (long long i = 2; i <= 100000; i++)
    inv[i] = (mod - mod / i) * inv[mod % i] % mod;
  build(1, n, k);
  for (long long i = 1; i <= gs; i++) {
    ans = (ans + len[i] * (len[i] - 1) % mod * inv[4] % mod) % mod;
  }
  sort(len + 1, len + gs + 1);
  long long x = 0;
  for (long long i = 1; i <= gs; i++)
    if (len[i] == len[i - 1])
      sum[x]++;
    else {
      len[++x] = len[i];
      sum[x] = 1;
    }
  gs = x;
  for (long long i = 1; i <= gs; i++)
    for (long long j = 1; j <= i; j++) {
      long long res = 0;
      res = len[i] * len[j] % mod * inv[2] % mod;
      for (long long a = 1; a <= len[i] + len[j]; a++) {
        long long l = max(1ll, a - len[j]), r = min(a - 1, len[i]);
        res = (res - inv[a] * (r - l + 1) % mod + mod) % mod;
      }
      if (i == j)
        ans = (ans +
               res * sum[i] % mod * (sum[i] - 1 + mod) % mod * inv[2] % mod) %
              mod;
      else
        ans = (ans + res * sum[i] % mod * sum[j] % mod) % mod;
    }
  cout << ans % mod;
  return 0;
}
