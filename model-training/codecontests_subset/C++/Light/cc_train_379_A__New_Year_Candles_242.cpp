#include <bits/stdc++.h>
int main() {
  long n, k, x, a, y;
  scanf("%ld %ld", &n, &k);
  a = n;
  x = n;
  while (x >= k) {
    y = x % k;
    x = x / k;
    a = a + x;
    x = x + y;
  }
  printf("%ld\n", a);
  return 0;
}
