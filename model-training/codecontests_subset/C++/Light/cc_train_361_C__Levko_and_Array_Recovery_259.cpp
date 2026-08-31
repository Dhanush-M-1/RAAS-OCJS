#include <bits/stdc++.h>
int mayor(int a, int b);
int men[5001], opt[5001], aux[5001], t[5001], l[5001], r[5001], d[5001];
int main() {
  int n, m, i, j, ban, max;
  scanf("%d%d", &n, &m);
  for (i = 1; i <= n; i++) {
    men[i] = -100000000;
  }
  for (i = 1; i <= m; i++) {
    scanf("%d%d%d%d", &t[i], &l[i], &r[i], &d[i]);
  }
  ban = 0;
  for (i = m; i >= 1; i--) {
    if (t[i] == 1) {
      for (j = l[i]; j <= r[i]; j++) {
        men[j] -= d[i];
      }
    } else {
      for (j = l[i]; j <= r[i]; j++) {
        if (opt[j] && men[j] < d[i]) {
          continue;
        }
        men[j] = d[i];
        opt[j] = 1;
      }
    }
  }
  for (i = 1; i <= n; i++) {
    aux[i] = men[i];
  }
  for (i = 1; i <= m; i++) {
    if (t[i] == 1) {
      for (j = l[i]; j <= r[i]; j++) {
        men[j] += d[i];
      }
    } else {
      max = -100000000;
      for (j = l[i]; j <= r[i]; j++) {
        max = mayor(max, men[j]);
      }
      if (max != d[i]) {
        ban = 1;
      }
    }
  }
  if (ban) {
    printf("NO\n");
  } else {
    printf("YES\n");
    for (i = 1; i <= n; i++) {
      printf("%d%c", aux[i], i == n ? '\n' : ' ');
    }
  }
  return 0;
}
int mayor(int a, int b) {
  if (a > b) {
    return a;
  }
  return b;
}
