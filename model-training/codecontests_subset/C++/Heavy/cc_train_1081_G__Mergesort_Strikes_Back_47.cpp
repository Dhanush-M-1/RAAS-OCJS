#include <bits/stdc++.h>
using namespace std;
long long mod = 0;
inline long long pls(long long a, long long b) {
  return a + b < mod ? a + b : a + b - mod;
}
inline long long dec(long long a, long long b) {
  return a >= b ? a - b : a - b + mod;
}
int len1 = 0, len2 = 0, c1 = 0, c2 = 0;
void dfs(int L, int R, int h) {
  if (L > R) return;
  if (h <= 1 || L == R) {
    int len = R - L + 1;
    if (len1 == 0) {
      len1 = len;
      c1 = 1;
    } else if (len1 == len)
      ++c1;
    else if (len2 == 0) {
      len2 = len;
      c2 = 1;
    } else
      ++c2;
    return;
  }
  int mid = (L + R) >> 1;
  dfs(L, mid, h - 1);
  dfs(mid + 1, R, h - 1);
}
long long inv[100003], sum[100003];
void pre() {
  inv[1] = inv[0] = 1;
  for (int i = 2; i <= 100000; ++i)
    inv[i] = (mod - mod / i) * inv[mod % i] % mod;
  for (int i = 1; i <= 100000; ++i) sum[i] = pls(sum[i - 1], inv[i]);
}
long long calc(int A, int B) {
  if (A == 0 || B == 0) return 0;
  long long ret = (long long)A * B % mod * inv[2] % mod;
  for (int i = 1; i <= A; ++i) ret = dec(ret, dec(sum[i + B], sum[i]));
  return ret;
}
int main() {
  int n = 0, k = 0;
  scanf("%d %d %lld", &n, &k, &mod);
  dfs(1, n, k);
  pre();
  long long ans =
      pls((long long)len1 * (len1 - 1ll) % mod * inv[4] % mod * c1 % mod,
          (long long)len2 * (len2 - 1ll) % mod * inv[4] % mod * c2 % mod);
  ans = pls(ans, calc(len1, len1) * c1 % mod * (c1 - 1ll) % mod * inv[2] % mod);
  ans = pls(ans, calc(len2, len2) * c2 % mod * (c2 - 1ll) % mod * inv[2] % mod);
  ans = pls(ans, calc(len1, len2) * c1 % mod * c2 % mod);
  printf("%lld", ans);
  return 0;
}
