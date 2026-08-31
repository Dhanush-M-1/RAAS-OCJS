#include <bits/stdc++.h>
int main() {
  int n, i, sum = 0, sum1 = 0, sum2 = 0;
  scanf("%d", &n);
  int a[n], b[n - 1], c[n - 2];
  for (i = 0; i < n; i++) {
    scanf("%d", &a[i]);
    sum = sum + a[i];
  }
  for (i = 0; i < n - 1; i++) {
    scanf("%d", &b[i]);
    sum1 = sum1 + b[i];
  }
  for (i = 0; i < n - 2; i++) {
    scanf("%d", &c[i]);
    sum2 = sum2 + c[i];
  }
  printf("%d\n%d", sum - sum1, sum1 - sum2);
  return 0;
}
