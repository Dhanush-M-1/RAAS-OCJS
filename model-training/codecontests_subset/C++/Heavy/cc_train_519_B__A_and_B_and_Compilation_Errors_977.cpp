#include <bits/stdc++.h>
int main() {
  unsigned long long int x[100000], y[100000], z[100000], counter1 = 0,
                                                          counter2 = 0;
  long int n, i;
  scanf("%ld", &n);
  for (i = 0; i < 3 * n - 3; i++) {
    if (i < n)
      scanf("%llu", &x[i]);
    else if (i < 2 * n - 1)
      scanf("%llu", &y[i - n]);
    else
      scanf("%llu", &z[i - 2 * n + 1]);
  }
  for (i = 0; i < n; i++) {
    if (i != n - 1) {
      counter1 += x[i] - y[i];
    } else {
      counter1 += x[i];
    }
    if (i != n - 2 && i != n - 1) {
      counter2 += y[i] - z[i];
    } else if (i == n - 2) {
      counter2 += y[i];
    }
  }
  printf("%llu\n%llu", counter1, counter2);
  return 0;
}
