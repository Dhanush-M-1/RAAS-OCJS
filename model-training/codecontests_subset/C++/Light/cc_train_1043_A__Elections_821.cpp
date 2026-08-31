#include <bits/stdc++.h>
int n, sum(0), s, x, maxx = 0;
int main() {
  scanf("%d", &n);
  register int i, k;
  for (i = 1; i <= n; ++i) {
    scanf("%d", &x);
    maxx = maxx < x ? x : maxx;
    sum += x;
  }
  for (k = maxx; k < 1000; ++k) {
    if (n * k - sum > sum) {
      printf("%d", k);
      return 0;
    }
  }
  return 0;
}
