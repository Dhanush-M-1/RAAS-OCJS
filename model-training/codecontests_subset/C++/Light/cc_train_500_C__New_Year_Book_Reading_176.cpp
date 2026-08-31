#include <bits/stdc++.h>
int w[505], b[1005], s[505], o[505], last[505], r[1005];
long long int sum;
int main() {
  int i, j, k, l, n, m, t;
  while (scanf("%d%d", &n, &m) != EOF) {
    for (i = 1; i <= n; i++) {
      scanf("%d", &w[i]);
      last[i] = 0;
      o[i] = 0;
    }
    for (i = 1; i <= m; i++) {
      scanf("%d", &b[i]);
      r[i] = 0;
    }
    t = 1;
    for (i = 1; i <= m; i++) {
      if (o[b[i]] == 0) {
        o[b[i]] = 1;
        s[t] = b[i];
        t++;
      }
    }
    for (i = 1; i <= m; i++) {
      if (i > last[b[i]] + 1) {
        for (k = 1; k <= n; k++) {
          o[k] = 0;
        }
        o[b[i]] = 1;
        for (j = last[b[i]] + 1; j < i; j++) {
          if (o[b[j]] == 0) {
            r[i] = r[i] + w[b[j]];
            o[b[j]] = 1;
          }
        }
      }
      last[b[i]] = i;
    }
    sum = 0;
    for (i = 1; i <= m; i++) {
      sum = sum + r[i];
    }
    printf("%d\n", sum);
  }
}
