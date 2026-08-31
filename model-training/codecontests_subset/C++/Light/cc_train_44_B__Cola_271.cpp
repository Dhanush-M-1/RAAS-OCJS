#include <bits/stdc++.h>
int main() {
  int n, a, b, c, i, j, res, N, rem;
  while (scanf("%d%d%d%d", &n, &a, &b, &c) == 4) {
    res = 0;
    rem = 0;
    N = 2 * n;
    for (i = 0; i <= b; i++) {
      for (j = 0; j <= c; j++) {
        rem = N - 2 * i - 4 * j;
        if (rem >= 0 && rem <= a) res++;
      }
    }
    printf("%d\n", res);
  }
  return 0;
}
