#include <bits/stdc++.h>
int main() {
  int n, k, x, z, y, t, a, s;
  scanf("%d %d", &n, &k);
  s = n;
  while (n >= k) {
    s = s + (n / k);
    n = n / k + n % k;
  }
  printf("%d", s);
}
