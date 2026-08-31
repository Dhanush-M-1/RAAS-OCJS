#include <bits/stdc++.h>
using namespace std;
long long mod = 1e9 + 7;
long long min(long long a, long long b) { return (a < b) ? a : b; }
long long max(long long a, long long b) { return (a > b) ? a : b; }
long long fp(long long a, long long b) {
  if (b == 0) return 1;
  long long x = fp(a, b / 2);
  x = (x * x) % mod;
  if (b & 1) x = (x * a) % mod;
  return x;
}
const long long N = 1e6 + 5;
long long a[N], blk[N] = {0}, prv[N];
long long n;
long long solve(long long k, long long c) {
  long long cur = 0, tot = 0;
  while (1) {
    long long x = cur + k;
    tot += c;
    if (x >= n) return tot;
    x = prv[x];
    if (x <= cur) {
      return 1e18;
    }
    cur = x;
  }
  return 1e18;
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long m, k, x;
  cin >> n >> m >> k;
  for (long long i = 1; i <= m; i++) {
    cin >> x;
    blk[x] = 1;
  }
  prv[0] = 0;
  for (long long i = 1; i < N; i++) {
    if (blk[i])
      prv[i] = prv[i - 1];
    else
      prv[i] = i;
  }
  if (blk[0]) {
    cout << -1;
    return 0;
  }
  long long ans = 1e18;
  for (long long i = 1; i <= k; i++) {
    cin >> x;
    ans = min(ans, solve(i, x));
  }
  if (ans == 1e18) ans = -1;
  cout << ans;
}
