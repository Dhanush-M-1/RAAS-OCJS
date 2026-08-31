#include <bits/stdc++.h>
int main() {
  int n, m, sum = 0;
  scanf("%d%d", &n, &m);
  sum = n;
  while (n >= m) {
    sum += n / m;
    n = n / m + n % m;
  }
  printf("%d", sum);
  return 0;
}
