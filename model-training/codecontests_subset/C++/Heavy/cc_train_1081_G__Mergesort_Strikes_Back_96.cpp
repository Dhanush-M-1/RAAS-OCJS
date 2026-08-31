#include <bits/stdc++.h>
using namespace std;
long long n, m, mod, sum[200005], inv[200005], ans, s1, s2, num1, num2;
void split(long long l, long long r, long long dep) {
  if (l > r) return;
  if (dep == 1 || l == r) {
    if (!s1) s1 = r - l + 1;
    if (s1 == r - l + 1)
      num1++;
    else {
      if (!s2) s2 = r - l + 1;
      if (s2 == r - l + 1) num2++;
    }
    ans = (ans + (r - l + 1) * (r - l) % mod * inv[4]) % mod;
    return;
  }
  long long mid = l + r >> 1;
  split(l, mid, dep - 1);
  split(mid + 1, r, dep - 1);
}
int main() {
  scanf("%lld%lld%lld", &n, &m, &mod);
  inv[0] = inv[1] = 1;
  for (long long i = 2; i <= n + 10; i++)
    inv[i] = (mod - mod / i) * inv[mod % i] % mod;
  for (long long i = 1; i <= n + 10; i++) sum[i] = (sum[i - 1] + inv[i]) % mod;
  split(1, n, m);
  if (s1 && s2) {
    long long nw = 0;
    for (long long i = 1; i <= s1; i++) {
      nw = (nw + inv[2] * s1 - sum[i + s1] + sum[i] + mod) % mod;
    }
    ans = (ans + num1 * (num1 - 1) % mod * inv[2] % mod * nw) % mod;
    nw = 0;
    for (long long i = 1; i <= s1; i++) {
      nw = (nw + inv[2] * s2 - sum[i + s2] + sum[i] + mod) % mod;
    }
    ans = (ans + num1 * num2 % mod * nw) % mod;
    nw = 0;
    for (long long i = 1; i <= s2; i++) {
      nw = (nw + inv[2] * s2 - sum[i + s2] + sum[i] + mod) % mod;
    }
    ans = (ans + num2 * (num2 - 1) % mod * inv[2] % mod * nw) % mod;
  } else {
    long long nw = 0;
    for (long long i = 1; i <= s1; i++) {
      nw = (nw + inv[2] * s1 - sum[i + s1] + sum[i] + mod) % mod;
    }
    ans = (ans + num1 * (num1 - 1) % mod * inv[2] % mod * nw) % mod;
  }
  printf("%lld", ans);
}
