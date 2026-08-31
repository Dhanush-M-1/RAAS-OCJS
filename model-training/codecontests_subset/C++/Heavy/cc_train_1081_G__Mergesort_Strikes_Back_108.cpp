#include <bits/stdc++.h>
std::map<long long, long long> mp;
long long p, inv[200005], sum[200005];
inline long long read() {
  register long long x = 0, f = 1;
  register char s = getchar();
  while (s > '9' || s < '0') {
    if (s == '-') f = -1;
    s = getchar();
  }
  while (s >= '0' && s <= '9') {
    x = x * 10 + s - '0';
    s = getchar();
  }
  return x * f;
}
inline long long max(const long long &x, const long long &y) {
  return x > y ? x : y;
}
inline void simulate(long long l, long long r, long long k) {
  if (k == 1 || l == r) {
    std::map<long long, long long>::iterator it = mp.find(r - l + 1);
    if (it != mp.end())
      ++it->second;
    else
      mp.insert(std::make_pair(r - l + 1, 1));
    return;
  }
  long long mid = l + r >> 1;
  simulate(l, mid, k - 1);
  simulate(mid + 1, r, k - 1);
}
inline long long calc(long long len1, long long len2) {
  long long res = 0;
  for (register long long i = 1; i <= len1; ++i) {
    (res += (inv[2] * 1ll * len2 % p - (sum[i + len2] - sum[i]) % p) % p) %= p;
  }
  return res;
}
signed main() {
  long long ans = 0;
  long long n = read(), k = read();
  p = read();
  inv[1] = 1;
  for (register long long i = 2; i <= max(n, 4); ++i)
    inv[i] = (p - (p / i)) * 1ll * inv[p % i] % p;
  for (register long long i = 1; i <= n; ++i)
    sum[i] = (sum[i - 1] + inv[i]) % p;
  simulate(1, n, k);
  for (std::map<long long, long long>::iterator it = mp.begin(); it != mp.end();
       ++it) {
    long long len = it->first, cnt = it->second;
    (ans += cnt * ((len - 1) * 1ll * len % p) % p * inv[4] % p) %= p;
  }
  for (std::map<long long, long long>::iterator it1 = mp.begin();
       it1 != mp.end(); ++it1) {
    for (std::map<long long, long long>::iterator it2 = mp.begin();
         it2 != mp.end(); ++it2) {
      if (it1->first == it2->first) {
        long long len = it1->first,
                  cnt = (it1->second - 1) * 1ll * (it1->second) / 2 % p;
        (ans += cnt * 1ll * calc(len, len) % p) %= p;
      } else if (it1->first < it2->first) {
        long long cnt = (it2->second) * 1ll * (it1->second) % p;
        (ans += cnt * 1ll * calc(it1->first, it2->first) % p) %= p;
      }
    }
  }
  printf("%lld\n", (ans + p) % p);
  return 0;
}
