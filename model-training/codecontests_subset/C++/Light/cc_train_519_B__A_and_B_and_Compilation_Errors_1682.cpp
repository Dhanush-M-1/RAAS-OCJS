#include <bits/stdc++.h>
int main() {
  long long n;
  scanf("%lld", &n);
  long long int a[n], a1[n - 1], a2[n - 2], i, sum = 0, sum1 = 0, sum2 = 0;
  for (i = 0; i < n; i++) {
    scanf("%lld", &a[i]);
    sum += a[i];
  }
  for (i = 0; i < n - 1; i++) {
    scanf("%lld", &a1[i]);
    sum1 += a1[i];
  }
  for (i = 0; i < n - 2; i++) {
    scanf("%lld", &a2[i]);
    sum2 += a2[i];
  }
  printf("%d\n", sum - sum1);
  printf("%d\n", sum1 - sum2);
}
