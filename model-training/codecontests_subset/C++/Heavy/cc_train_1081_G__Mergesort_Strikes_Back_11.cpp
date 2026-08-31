#include <bits/stdc++.h>
using namespace std;
long long inv[100005], n, k, p, cnt[3], len[3], sum[100005], ans;
void gb(long long l, long long r, long long h) {
  if (h <= 1 || l == r) {
    if (!len[1] || len[1] == r - l + 1)
      len[1] = r - l + 1, cnt[1]++;
    else
      len[2] = r - l + 1, cnt[2]++;
    return;
  }
  long long mid = l + r >> 1;
  gb(l, mid, h - 1), gb(mid + 1, r, h - 1);
}
inline long long work(long long x, long long y) {
  long long s = inv[2] * x % p * y % p;
  for (long long i = 1; i <= x; i++) s = (s - sum[i + y] + sum[i]) % p;
  return (s + p) % p;
}
signed main() {
  cin >> n >> k >> p;
  inv[1] = 1;
  for (long long i = 2; i <= max(n, 4ll); i++)
    inv[i] = inv[p % i] * (p - p / i) % p;
  for (long long i = 1; i <= n; i++) sum[i] = (sum[i - 1] + inv[i]) % p;
  gb(1, n, k);
  ans = (len[1] * (len[1] - 1) % p * cnt[1] % p * inv[4] +
         len[2] * (len[2] - 1) % p * cnt[2] % p * inv[4]) %
        p;
  ans =
      (ans + cnt[1] * (cnt[1] - 1) % p * inv[2] % p * work(len[1], len[1])) % p;
  ans =
      (ans + cnt[2] * (cnt[2] - 1) % p * inv[2] % p * work(len[2], len[2])) % p;
  ans = (ans + cnt[1] * cnt[2] % p * work(len[1], len[2])) % p;
  printf("%lld", ans);
}
