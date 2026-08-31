#include <bits/stdc++.h>
int main() {
  int n, k = 1, sum = 0, e, i, j, max = 0;
  scanf("%d", &n);
  int ara[n];
  for (i = 0; i < n; i++) {
    scanf("%d", &ara[i]);
    if (ara[i] > max) max = ara[i];
    sum = sum + ara[i];
  }
  k = max;
  while (1) {
    e = 0;
    for (i = 0; i < n; i++) {
      e = e + k - ara[i];
    }
    if (e > sum) break;
    k++;
  }
  printf("%d", k);
}
