#include <bits/stdc++.h>
int main() {
  int n, k, x, sum = 0;
  while (scanf("%d%d", &n, &k) == 2) {
    sum = n;
    while (n >= k) {
      x = n / k;
      n = x + n % k;
      sum += x;
    }
    printf("%d\n", sum);
  }
  return 0;
}
