#include <bits/stdc++.h>
int main() {
  int n, m;
  scanf("%d %d", &n, &m);
  int i, q, r, sum, days = (n / m) * m;
  for (i = 1; i <= 10000; i++) {
    q = n / m;
    r = n % m;
    sum = q + r;
    n = sum;
    days = days + (sum / m) * m;
    if (sum / m == 0) {
      days = days + sum % m;
      break;
    }
  }
  printf("%d", days);
}
