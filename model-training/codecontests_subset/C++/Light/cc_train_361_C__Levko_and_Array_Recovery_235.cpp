#include <bits/stdc++.h>
int q[5005], l[5005], r[5005], k[5005], add[5005], sx[5005];
int main() {
  int n, m, i, j, ok;
  while (~scanf("%d%d", &n, &m)) {
    for (i = 1; i <= n; i++) {
      sx[i] = 1000000000;
      add[i] = 0;
    }
    for (i = 0; i < m; i++) {
      scanf("%d%d%d%d", &q[i], &l[i], &r[i], &k[i]);
      if (q[i] == 1) {
        for (j = l[i]; j <= r[i]; j++) add[j] += k[i];
      } else {
        for (j = l[i]; j <= r[i]; j++)
          if (sx[j] > k[i] - add[j]) sx[j] = k[i] - add[j];
      }
    }
    for (i = 1; i <= n; i++) {
      add[i] = 0;
    }
    ok = 1;
    for (i = 0; i < m; i++) {
      if (q[i] == 1) {
        for (j = l[i]; j <= r[i]; j++) add[j] += k[i];
      } else {
        for (j = l[i]; j <= r[i]; j++)
          if (sx[j] == k[i] - add[j]) break;
        if (j > r[i]) {
          ok = 0;
          break;
        }
      }
    }
    if (!ok)
      printf("NO\n");
    else {
      printf("YES\n");
      for (i = 1; i <= n; i++) {
        printf("%d", sx[i]);
        if (i != n) printf(" ");
      }
    }
  }
  return 0;
}
