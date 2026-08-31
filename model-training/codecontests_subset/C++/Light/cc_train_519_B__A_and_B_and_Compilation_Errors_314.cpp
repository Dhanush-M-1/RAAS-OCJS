#include <bits/stdc++.h>
int main() {
  int i, j, k, l, sum1 = 0, sum2 = 0, sum3 = 0, n;
  scanf("%d", &n);
  int ara[n];
  int ar[n - 1];
  int a[n - 2];
  for (i = 0; i < n; i++) {
    scanf("%d", &ara[i]);
    sum1 = sum1 + ara[i];
  }
  for (i = 0; i < n - 1; i++) {
    scanf("%d", &ar[i]);
    sum2 = sum2 + ar[i];
  }
  for (i = 0; i < n - 2; i++) {
    scanf("%d", &a[i]);
    sum3 = sum3 + a[i];
  }
  printf("%d\n", (sum1 - sum2));
  printf("%d", (sum2 - sum3));
  return 0;
}
