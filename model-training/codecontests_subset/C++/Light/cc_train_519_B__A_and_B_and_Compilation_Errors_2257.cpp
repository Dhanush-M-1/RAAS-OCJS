#include <bits/stdc++.h>
int main() {
  int n;
  scanf("%d", &n);
  int sum1 = 0, sum2 = 0, sum3 = 0, num;
  for (int i = 0; i < n; i++) {
    scanf("%d", &num);
    sum1 += num;
  }
  for (int i = 0; i < n - 1; i++) {
    scanf("%d", &num);
    sum2 += num;
  }
  for (int i = 0; i < n - 2; i++) {
    scanf("%d", &num);
    sum3 += num;
  }
  printf("%d\n%d", sum1 - sum2, sum2 - sum3);
  return 0;
}
