#include <bits/stdc++.h>
int main() {
  int n, x, y, k;
  scanf("%d%d%d", &n, &x, &y);
  for (k = 0;; k++) {
    if (((100 * x + 100 * k) / (n)) >= y) break;
  }
  printf("%d", k);
  return 0;
}
