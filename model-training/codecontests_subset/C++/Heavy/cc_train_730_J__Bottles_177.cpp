#include <bits/stdc++.h>
using namespace std;
const long long mod = 1000000007;
long long powmod(long long a, long long b) {
  long long res = 1;
  a %= mod;
  assert(b >= 0);
  for (; b; b >>= 1) {
    if (b & 1) res = res * a % mod;
    a = a * a % mod;
  }
  return res;
}
const int N = 110;
int n, a[N], b[N], dp[N][N * N], pd[N][N * N];
int main() {
  scanf("%d", &n);
  for (int i = 0; i < n; i++) scanf("%d", a + i);
  for (int i = 0; i < n; i++) scanf("%d", b + i);
  dp[0][0] = 0;
  int sa = 0, sb = 0;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j <= i; j++)
      for (int k = 0; k <= sb; k++) pd[j][k] = dp[j][k];
    for (int j = 0; j <= i; j++)
      for (int k = 0; k <= sb + b[i]; k++) dp[j][k] = -(1 << 20);
    for (int j = 0; j <= i; j++)
      for (int k = 0; k <= sb; k++) {
        dp[j][k] = max(dp[j][k], pd[j][k]);
        dp[j + 1][k + b[i]] = max(dp[j + 1][k + b[i]], pd[j][k] + a[i]);
      }
    sa += a[i], sb += b[i];
  }
  int ret = 0;
  for (int j = 0; j <= n; j++) {
    for (int k = sa; k <= sb; k++) ret = max(ret, dp[j][k]);
    if (ret > 0) {
      printf("%d %d\n", j, sa - ret);
      return 0;
    }
  }
}
