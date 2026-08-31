#include <bits/stdc++.h>
int main() {
  int n, m, a[111], k, t, i, j, o;
  while (~scanf("%d %d", &n, &m)) {
    for (i = 1; i <= m; i++) {
      a[i] = 0;
    }
    for (i = 0; i < n; i++) {
      scanf("%d", &k);
      while (k--) {
        scanf("%d", &t);
        a[t] = 1;
      }
    }
    o = 1;
    for (i = 1; i <= m; i++) {
      if (a[i] == 0) {
        o = 0;
        break;
      }
    }
    if (o)
      printf("YES\n");
    else
      printf("NO\n");
  }
  return 0;
}
