#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
#pragma GCC target("sse,sse2,sse3,ssse3,sse4,avx,avx2")
int a[100003], b[100003], arr[100003];
int dp[100003], res, n, k, x, i;
int main() {
  scanf("%d%d", &n, &k);
  dp[0] = 1;
  for (int j = 1; j <= n; j++) {
    res += dp[j - 1];
    if (res >= 998244353) res -= 998244353;
    scanf("%d", &x);
    for (i = a[x] + 1; i + 2 <= b[x]; i += 3) {
      if (arr[i] == k + 1) {
        res += dp[i - 1];
        if (res >= 998244353) res -= 998244353;
      }
      if (arr[i + 1] == k + 1) {
        res += dp[i];
        if (res >= 998244353) res -= 998244353;
      }
      if (arr[i + 2] == k + 1) {
        res += dp[i + 1];
        if (res >= 998244353) res -= 998244353;
      }
      arr[i]--;
      arr[i + 1]--;
      arr[i + 2]--;
    }
    for (; i <= b[x]; i++) {
      if (arr[i] == k + 1) {
        res += dp[i - 1];
        if (res >= 998244353) res -= 998244353;
      }
      arr[i]--;
    }
    for (i = b[x] + 1; i + 2 <= j; i += 3) {
      if (arr[i] == k) {
        res -= dp[i - 1];
        if (res < 0) res += 998244353;
      }
      if (arr[i + 1] == k) {
        res -= dp[i];
        if (res < 0) res += 998244353;
      }
      if (arr[i + 2] == k) {
        res -= dp[i + 1];
        if (res < 0) res += 998244353;
      }
      arr[i]++;
      arr[i + 1]++;
      arr[i + 2]++;
    }
    for (; i <= j; i++) {
      if (arr[i] == k) {
        res -= dp[i - 1];
        if (res < 0) res += 998244353;
      }
      arr[i]++;
    }
    a[x] = b[x];
    b[x] = j;
    dp[j] = res;
  }
  printf("%d\n", dp[n]);
  return 0;
}
