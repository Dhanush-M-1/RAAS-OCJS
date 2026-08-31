#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i, sum1, sum2, sum3, first;
  sum1 = sum2 = sum3 = 0;
  scanf("%d", &n);
  for (i = 1; i <= n; i++) {
    scanf("%d", &first);
    sum1 += first;
  }
  for (i = 1; i < n; i++) {
    scanf("%d", &first);
    sum2 += first;
  }
  for (i = 1; i < n - 1; i++) {
    scanf("%d", &first);
    sum3 += first;
  }
  printf("%d\n%d\n", sum1 - sum2, sum2 - sum3);
  return 0;
}
