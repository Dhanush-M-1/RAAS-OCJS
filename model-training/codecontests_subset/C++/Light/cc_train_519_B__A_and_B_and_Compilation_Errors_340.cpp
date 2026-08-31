#include <bits/stdc++.h>
int main() {
  int a, i, sum1 = 0, sum2 = 0, sum3 = 0, n;
  scanf("%d", &n);
  for (i = 1; i <= n; i++) {
    scanf("%d", &a);
    sum1 += a;
  }
  for (i = 1; i <= n - 1; i++) {
    scanf("%d", &a);
    sum2 += a;
  }
  for (i = 1; i <= n - 2; i++) {
    scanf("%d", &a);
    sum3 += a;
  }
  printf("%d\n%d", sum1 - sum2, sum2 - sum3);
}
