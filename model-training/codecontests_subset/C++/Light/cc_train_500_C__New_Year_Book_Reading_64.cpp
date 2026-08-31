#include <bits/stdc++.h>
int main() {
  int n, m;
  while (scanf("%d %d", &n, &m) == 2) {
    int w[n + 1], b[m + 1], c[m + 1];
    w[0] = 0;
    b[0] = 0;
    for (int i = 1; i < n + 1; i++) {
      scanf("%d", &w[i]);
    }
    for (int i = 1; i < m + 1; i++) {
      scanf("%d", &b[i]);
      c[i] = b[i];
    }
    int cnt = 1;
    long long int ans = 0;
    for (int i = 1; i < m + 1; i++) {
      int j;
      for (j = 1; j < i; j++) {
        if (c[i] == c[j]) {
          break;
        }
      }
      if (j == i) {
        c[cnt] = c[i];
        cnt++;
      }
    }
    for (int i = 1; i < m + 1; i++)
      for (int j = 1; j < cnt; j++) {
        if (b[i] == c[j]) {
          for (int p = 1; p < j; p++) {
            ans = ans + (long long int)w[c[p]];
          }
          for (int p = j; p > 0; p--) {
            c[p] = c[p - 1];
          }
          c[1] = b[i];
          break;
        }
      }
    printf("%lld\n", ans);
  }
  return 0;
}
