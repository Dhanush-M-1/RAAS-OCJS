#include <bits/stdc++.h>
int main() {
  int a = 0, sum = 0, b, i, n, sum1, x;
  scanf("%d", &n);
  for (i = 1; i <= n; i++) {
    scanf("%d", &x);
    sum += x;
  }
  sum1 = sum;
  for (i = 1; i <= n - 1; i++) {
    scanf("%d", &x);
    sum -= x;
  }
  for (i = 1; i <= n - 2; i++) {
    scanf("%d", &x);
    sum1 -= x;
  }
  sum1 = sum1 - sum;
  printf("%d\n%d", sum, sum1);
  return 0;
}
