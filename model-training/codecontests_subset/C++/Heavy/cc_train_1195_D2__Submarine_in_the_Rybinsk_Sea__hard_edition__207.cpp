#include <bits/stdc++.h>
using namespace std;
long long a[100010], b[100010], p[100010], sum[100010];
long long cnt[100010];
long long n;
long long ans;
long long f(long long x) {
  long long ret = 0;
  while (x) {
    cnt[ret] += x % 10;
    ret++;
    x /= 10;
  }
  return ret;
}
signed main() {
  cin >> n;
  p[0] = 1;
  for (long long i = 1; i <= 100000; i++) p[i] = p[i - 1] * 10 % 998244353;
  for (long long i = 1; i <= n; i++) cin >> a[i], b[i] = f(a[i]);
  for (long long j = 31; j >= 0; j--) {
    for (long long i = 1; i <= n; i++) {
      if (b[i] > j)
        ans =
            (ans + p[j * 2] * 11 % 998244353 * cnt[j] % 998244353) % 998244353;
      else
        ans = (ans + p[b[i] + j] * 2 % 998244353 * cnt[j] % 998244353) %
              998244353;
    }
  }
  cout << ans << endl;
  return 0;
}
