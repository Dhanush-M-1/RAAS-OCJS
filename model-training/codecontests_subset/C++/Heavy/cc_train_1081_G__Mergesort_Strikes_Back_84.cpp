#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 5;
inline int read() {
  int x = 0;
  char ch = getchar();
  while (ch < '0' || ch > '9') ch = getchar();
  while ('0' <= ch && ch <= '9') x = x * 10 + ch - '0', ch = getchar();
  return x;
}
int n, k, mod;
long long inv[N], sum[N], ans;
map<long long, long long> m;
void solve(int l, int r, int dep) {
  if (l == r || !dep) {
    m[r - l + 1]++;
    return;
  }
  int mid = (l + r) >> 1;
  solve(l, mid, dep - 1), solve(mid + 1, r, dep - 1);
}
void init() {
  inv[0] = inv[1] = 1;
  for (register int i = 2; i <= n; i++)
    inv[i] = (mod - mod / i) * inv[mod % i] % mod,
    sum[i] = (sum[i - 1] + inv[i]) % mod;
}
long long cal(long long x, long long y) {
  long long res = x * y;
  for (register int i = 1; i <= x; i++)
    (res += mod - (sum[i + y] - sum[i] + mod) % mod * 2 % mod) %= mod;
  return res;
}
void work() {
  for (map<long long, long long>::iterator it = m.begin(); it != m.end();
       it++) {
    long long len = it->first, cnt = it->second;
    (ans += len * (len - 1) % mod * inv[2] % mod * cnt % mod) %= mod;
    (ans += cnt * (cnt - 1) % mod * inv[2] % mod * cal(len, len)) %= mod;
  }
  for (map<long long, long long>::iterator it1 = m.begin(); it1 != m.end();
       it1++) {
    for (map<long long, long long>::iterator it2 = m.begin(); it2 != m.end();
         it2++) {
      long long x = it1->first, y = it2->first;
      if (x < y)
        (ans += cal(x, y) * it1->second % mod * it2->second % mod) %= mod;
    }
  }
}
int main() {
  n = read(), k = read() - 1, mod = read();
  init();
  solve(1, n, k);
  work();
  printf("%lld", ans * inv[2] % mod);
}
