#include <bits/stdc++.h>
int a[999999];
int b[999999];
int c[999999];
int main() {
  int n, i, j, k, sum1, sum2, sum3;
  while (scanf("%d", &n) != EOF) {
    sum1 = 0;
    sum2 = 0;
    sum3 = 0;
    for (i = 1; i <= n; i++) {
      scanf("%d", &a[i]);
    }
    for (i = 1; i <= n; i++) {
      sum1 += a[i];
    }
    for (j = 1; j <= n - 1; j++) {
      scanf("%d", &b[j]);
    }
    for (j = 1; j <= n - 1; j++) {
      sum2 += b[j];
    }
    for (k = 1; k <= n - 2; k++) {
      scanf("%d", &c[k]);
    }
    for (k = 1; k <= n - 2; k++) {
      sum3 += c[k];
    }
    printf("%d\n%d\n", sum1 - sum2, sum2 - sum3);
  }
  return 0;
}
