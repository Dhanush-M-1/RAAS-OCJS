#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a, b, c, i, j, k, x = 0;
  scanf("%d%d%d%d", &n, &a, &b, &c);
  for (i = min(c, n / 2); i >= 0; i--) {
    if (i * 2 + b + a / 2 < n) break;
    for (j = min(b, n - 2 * i); j >= 0; j--) {
      if (i * 2 + j + a / 2 < n) break;
      for (k = min(a - a % 2, (n - 2 * i - j) * 2); k >= 0; k = k - 2) {
        if (i * 2 + j + k / 2 < n) break;
        if (n == i * 2 + j + k / 2) x++;
      }
    }
  }
  printf("%d", x);
  return 0;
}
