#include <bits/stdc++.h>
int x[111111];
int y[111111];
int main() {
  int i, n, rr = 0, tt = -1e9;
  scanf("%d", &n);
  for (i = 1; i <= n; i++) scanf("%d%d", &x[i], &y[i]);
  x[n + 1] = 2e9 + 222;
  for (i = 1; i <= n; i++) {
    if (x[i] - y[i] > tt) {
      tt = x[i];
      rr++;
      continue;
    }
    tt = x[i];
    if (x[i] + y[i] < x[i + 1]) {
      rr++;
      tt = x[i] + y[i];
    }
  }
  printf("%d", rr);
}
