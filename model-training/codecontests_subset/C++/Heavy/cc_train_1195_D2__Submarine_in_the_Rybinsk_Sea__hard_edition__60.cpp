#include <bits/stdc++.h>
using namespace std;
const long long mod = 998244353;
long long n, a[100001], sum[11], tsum[11], tp, p10[21], ans;
int main() {
  p10[0] = 1;
  scanf("%lld", &n);
  for (long long i = 1, t; i <= n; i++) {
    scanf("%lld", &a[i]);
    t = 0;
    for (long long tp = 1; tp <= a[i]; tp *= 10) t++;
    sum[t]++;
    tsum[t]++;
  }
  for (int i = 1; i <= 20; i++) {
    p10[i] = p10[i - 1] * 10;
    if (i <= 10) {
      sum[i] += sum[i - 1];
      tsum[i] = (p10[i] * tsum[i] + tsum[i - 1]) % mod;
    } else
      p10[i] %= mod;
  }
  for (long long i = 1, t; i <= n; i++) {
    for (int j = 0; j <= 9; j++) {
      t = a[i] % p10[j + 1] / p10[j];
      ans = (ans +
             t * ((2 * p10[j] * tsum[j] + (n - sum[j]) * p10[2 * j] * 11))) %
            mod;
    }
  }
  printf("%I64d", ans);
}
