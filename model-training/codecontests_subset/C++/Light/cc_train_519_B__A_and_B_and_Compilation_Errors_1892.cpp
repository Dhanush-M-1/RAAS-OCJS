#include <bits/stdc++.h>
int main(void) {
  int i, j, n, x;
  long long sums[3] = {0};
  scanf("%d", &n);
  for (i = 0; i < sizeof sums / sizeof *sums; ++i) {
    for (j = 0; j < n - i; ++j) {
      scanf("%d", &x);
      sums[i] += x;
    }
  }
  for (i = 1; i < sizeof sums / sizeof *sums; ++i) {
    printf("%d\n", sums[i - 1] - sums[i]);
  }
  return 0;
}
