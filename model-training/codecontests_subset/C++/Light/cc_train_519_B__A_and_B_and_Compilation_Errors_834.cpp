#include <bits/stdc++.h>
int main() {
  int n, i, sum1, sum2, sum3;
  scanf("%d", &n);
  sum1 = 0;
  for (i = 0; i < n; i++) {
    int a;
    scanf("%d", &a);
    sum1 ^= a;
  }
  sum2 = 0;
  for (i = 0; i < n - 1; i++) {
    int b;
    scanf("%d", &b);
    sum2 ^= b;
  }
  sum3 = 0;
  for (i = 0; i < n - 2; i++) {
    int c;
    scanf("%d", &c);
    sum3 ^= c;
  }
  printf("%d\n%d\n", sum1 ^ sum2, sum2 ^ sum3);
  return 0;
}
