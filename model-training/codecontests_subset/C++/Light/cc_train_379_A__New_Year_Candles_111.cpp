#include <bits/stdc++.h>
int main() {
  int n, m, sum;
  while (scanf("%d%d", &n, &m) != EOF) {
    sum = n;
    while (n / m != 0) {
      sum = sum + n / m;
      n = n / m + n % m;
    }
    printf("%d\n", sum);
  }
  return 0;
}
