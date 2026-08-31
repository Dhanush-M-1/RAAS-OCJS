#include <bits/stdc++.h>
using namespace std;
template <typename T>
inline T gi() {
  T f = 1, x = 0;
  char c = getchar();
  while (c < '0' || c > '9') {
    if (c == '-') f = -1;
    c = getchar();
  }
  while (c >= '0' && c <= '9') x = x * 10 + c - '0', c = getchar();
  return f * x;
}
const int INF = 0x3f3f3f3f, N = 100003, M = N << 1;
int n, k, mod;
pair<int, int> p[2];
long long inv[N], sum[N];
inline long long qpow(long long a, long long b) {
  long long res = 1;
  while (b) {
    if (b & 1) res = res * a % mod;
    a = a * a % mod, b >>= 1;
  }
  return res;
}
inline void pre() {
  for (int i = 1; i <= max(n, 4); i += 1)
    inv[i] = qpow(i, mod - 2), sum[i] = (sum[i - 1] + inv[i]) % mod;
  return;
}
inline long long solve(long long len1, long long len2) {
  long long res = 0;
  for (int i = 1; i <= len1; i += 1)
    res = ((res + len2 * inv[2] % mod - (sum[i + len2] - sum[i]) % mod) % mod +
           mod) %
          mod;
  return res;
}
int main() {
  n = gi<int>(), k = gi<int>(), mod = gi<int>();
  --k;
  if (k > 20) k = 20;
  int u = min(n, 1 << k);
  int a = n / u, b = a + 1, cnta = b * u - n, cntb = u - cnta;
  p[0] = {a, cnta}, p[1] = {b, cntb};
  pre();
  long long ans = 0;
  for (int i = 0; i <= 1; i += 1) {
    int len = p[i].first, cnt = p[i].second;
    ans = (ans + 1ll * cnt * len % mod * (len - 1) % mod * inv[4] % mod) % mod;
  }
  for (int i = 0; i <= 1; i += 1)
    for (int j = 0; j <= 1; j += 1) {
      if (i == j) {
        long long len = p[i].first,
                  cnt = 1ll * p[i].second * (p[i].second - 1) / 2 % mod;
        ans = (ans + 1ll * cnt * solve(len, len) % mod) % mod;
      } else if (p[i].first < p[j].first) {
        long long len1 = p[i].first, len2 = p[j].first,
                  cnt = 1ll * p[i].second * p[j].second % mod;
        ans = (ans + 1ll * cnt * solve(len1, len2) % mod) % mod;
      }
    }
  printf("%lld\n", ans);
  return 0;
}
