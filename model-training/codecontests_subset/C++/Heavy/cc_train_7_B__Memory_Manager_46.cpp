#include <bits/stdc++.h>
using namespace std;
int n, m;
int l[12000], r[12000];
int v[1200];
int now = 0;
int main() {
  int i, j, k;
  scanf("%d%d", &m, &n);
  memset(l, -1, sizeof(l));
  memset(r, -1, sizeof(r));
  while (m--) {
    char s[11];
    scanf("%s", s);
    if (strcmp(s, "alloc") == 0) {
      scanf("%d", &k);
      int go = 0;
      for (i = 1; i + k - 1 <= n; i++) {
        for (j = i; j <= i + k - 1; j++) {
          if (v[j]) break;
        }
        if (j == i + k) {
          go = 1;
          ++now;
          for (j = i; j <= i + k - 1; j++) {
            v[j] = now;
          }
          l[now] = i;
          r[now] = i + k - 1;
          break;
        }
      }
      if (!go) {
        puts("NULL");
      } else {
        printf("%d\n", now);
      }
    } else if (strcmp(s, "erase") == 0) {
      scanf("%d", &k);
      if (k < 1 || k > now || l[k] == -1) {
        puts("ILLEGAL_ERASE_ARGUMENT");
        continue;
      }
      for (i = 1; i <= n; i++) {
        if (v[i] == k) v[i] = 0;
      }
      l[k] = r[k] = -1;
    } else {
      int go = 1;
      while (go) {
        go = 0;
        for (i = 1; i <= n; i++) {
          if (v[i]) continue;
          for (j = i + 1; j <= n; j++) {
            if (v[j]) break;
          }
          if (j == n + 1) continue;
          go = 1;
          for (j = 1; j <= now; j++) {
            if (l[j] > i) {
              --l[j];
              --r[j];
            }
          }
          memset(v, 0, sizeof(v));
          for (j = 1; j <= now; j++) {
            if (l[j] == -1) continue;
            for (k = l[j]; k <= r[j]; k++) {
              v[k] = j;
            }
          }
          break;
        }
      }
    }
  }
  return 0;
}
