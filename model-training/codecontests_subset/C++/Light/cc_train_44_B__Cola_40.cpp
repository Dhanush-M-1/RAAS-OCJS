#include <bits/stdc++.h>
int dp[30000];
int f[30000];
int num[5];
int main() {
  int i, j, k;
  int n;
  int a[5];
  num[0] = 1, num[1] = 2, num[2] = 4;
  while (scanf("%d%d%d%d", &n, &a[0], &a[1], &a[2]) != EOF) {
    for (i = 0; i <= 2 * n; i++) dp[i] = 0;
    dp[0] = 1;
    for (i = 0; i < 3; i++) {
      int tmp = 2 * n;
      for (j = 0; j <= tmp; j++) f[j] = 0;
      for (k = 0; k <= a[i]; k++) {
        for (j = tmp; j >= k * num[i]; j--) {
          f[j] += dp[j - k * num[i]];
        }
      }
      for (j = 0; j <= tmp; j++) dp[j] = f[j];
    }
    printf("%d\n", dp[2 * n]);
  }
  return 0;
}
