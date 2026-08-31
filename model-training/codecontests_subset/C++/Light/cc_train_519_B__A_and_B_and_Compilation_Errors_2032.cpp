#include <bits/stdc++.h>
int main() {
  int n;
  scanf("%d", &n);
  int errors[n], errors2[n - 1], errors3[n - 2], sum1 = 0, sum2 = 0, sum3 = 0;
  int cnt = 0;
  for (int i = 0; i < n; i++) {
    scanf("%d", &errors[i]);
    sum1 += errors[i];
  }
  for (int i = 0; i < n - 1; i++) {
    scanf("%d", &errors2[i]);
    sum2 += errors2[i];
  }
  for (int i = 0; i < n - 2; i++) {
    scanf("%d", &errors3[i]);
    sum3 += errors3[i];
  }
  printf("%d\n", abs(sum2 - sum1));
  printf("%d\n", abs(sum3 - sum2));
}
