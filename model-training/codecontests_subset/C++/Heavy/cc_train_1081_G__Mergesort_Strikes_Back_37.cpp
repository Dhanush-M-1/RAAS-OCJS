#include <bits/stdc++.h>
using namespace std;
long long n, m, mod, inv[300000], ans, cnt[300000], pre[300000];
void upd(long long &x, long long y) { x = (x + y) % mod; }
void solve(long long x, long long m) {
  if (!m || x == 1) {
    ++cnt[x];
    return;
  }
  solve((x + 1) / 2, m - 1);
  solve(x / 2, m - 1);
}
int main() {
  scanf("%lld%lld%lld", &n, &m, &mod);
  m = min(m - 1, 20LL);
  solve(n, m);
  long long p = max(n, 4LL);
  inv[1] = 1;
  for (long long i = 2; i <= p; ++i)
    inv[i] = (mod - mod / i) * inv[mod % i] % mod;
  for (long long i = 1; i <= p; ++i) pre[i] = (pre[i - 1] + inv[i]) % mod;
  for (long long i : {n >> m, (n >> m) + 1}) {
    upd(ans, cnt[i] * i % mod * (i - 1) % mod * inv[4]);
    for (long long j : {n >> m, (n >> m) + 1}) {
      long long sum = 0;
      for (long long k = 1; k <= i; ++k) {
        upd(sum, (k - 1) * (pre[k + j] - pre[k]));
      }
      sum = sum * inv[2] % mod;
      upd(ans, sum * cnt[i] % mod * (i == j ? cnt[i] - 1 : cnt[j]));
    }
  }
  upd(ans, mod);
  printf("%lld\n", ans);
  return 0;
}
