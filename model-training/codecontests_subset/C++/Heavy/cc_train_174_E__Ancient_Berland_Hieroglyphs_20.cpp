#include <bits/stdc++.h>
using namespace std;
int a[2000000 + 8] = {0};
int b[1000000 + 8] = {0};
int my[1000000 + 8] = {0};
int main() {
  int n = 0, m = 0, i = 0, ans = 0, now = 0, p = 0, pp = 0, qq = 0;
  while (scanf("%d%d", &n, &m) == 2) {
    memset(my, 0, sizeof(my));
    for (i = 1; i <= n; i++) {
      scanf("%d", a + i);
    }
    for (i = 1; i <= m; i++) {
      scanf("%d", b + i);
      my[b[i]] = i;
    }
    for (i = 1; i <= n; i++) {
      a[i] = my[a[i]];
      a[i + n] = a[i];
    }
    ans = 0;
    now = 0;
    p = 0;
    for (i = 1; i <= n + n; i++) {
      if (a[i]) {
        if (p == 0) {
          now = 1;
          p = i;
        } else {
          pp = a[p];
          qq = a[i - 1];
          while (true) {
            if (pp <= qq) {
              if (a[i] < pp || a[i] > qq) {
                break;
              }
            } else {
              if (a[i] > qq && a[i] < pp) {
                break;
              }
            }
            now--;
            p++;
            if (p == i) {
              break;
            }
            pp = a[p];
          }
          now++;
        }
      } else {
        now = 0;
        p = 0;
      }
      if (now > ans) {
        ans = now;
      }
    }
    printf("%d\n", ans);
  }
  return 0;
}
