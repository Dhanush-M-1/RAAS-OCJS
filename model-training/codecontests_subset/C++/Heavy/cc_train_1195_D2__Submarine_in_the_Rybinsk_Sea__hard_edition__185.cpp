#include <bits/stdc++.h>
using namespace std;
const int mod = 998244353;
char str[1001];
int n;
int ans = 0, sum[101], len;
int f[100005][12], g[100005][12];
int m[101];
int c[100005];
int main() {
  scanf("%d", &n);
  m[0] = 1;
  for (int i = 1; i <= 25; i++) m[i] = 1LL * m[i - 1] * 10 % mod;
  for (int i = 1; i <= n; i++) {
    scanf("%s", str + 1);
    len = (int)strlen(str + 1);
    for (int j = 1; j <= 10; j++) {
      if (j > len) {
        for (int k = 1; k <= len; k++)
          f[i][j] = (1LL * f[i][j] * 100 + str[k] - '0') % mod;
        f[i][j] = 10LL * f[i][j] % mod;
      } else if (j < len) {
        for (int k = 1; k <= len - j; k++)
          f[i][j] = (1LL * f[i][j] * 10 + str[k] - '0') % mod;
        f[i][j] = 1LL * f[i][j] * m[2 * j] % mod;
        int tmp = 0;
        for (int k = len - j + 1; k <= len; k++)
          tmp = (1LL * tmp * 100 + str[k] - '0') % mod;
        f[i][j] += 10LL * tmp % mod;
        f[i][j] %= mod;
      } else {
        for (int k = 1; k <= 2 * len; k++)
          f[i][j] = (1LL * f[i][j] * 10 + str[(k + 1) / 2] - '0') % mod;
      }
    }
    for (int j = 1; j <= 10; j++) {
      if (j > len) {
        for (int k = 1; k <= len; k++)
          g[i][j] = (1LL * g[i][j] * 100 + str[k] - '0') % mod;
      } else if (j < len) {
        for (int k = 1; k <= len - j; k++)
          g[i][j] = (1LL * g[i][j] * 10 + str[k] - '0') % mod;
        g[i][j] = 1LL * g[i][j] * m[2 * j] % mod;
        int tmp = 0;
        for (int k = len - j + 1; k <= len; k++)
          tmp = (1LL * tmp * 100 + str[k] - '0') % mod;
        g[i][j] += tmp;
        g[i][j] %= mod;
      } else {
        g[i][j] = 0;
      }
      f[i][j] += g[i][j];
      f[i][j] %= mod;
    }
    sum[len]++;
    c[i] = len;
  }
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= 10; j++) {
      ans += 1LL * f[i][j] * sum[j] % mod;
      ans %= mod;
    }
  }
  printf("%d\n", ans);
  return 0;
}
