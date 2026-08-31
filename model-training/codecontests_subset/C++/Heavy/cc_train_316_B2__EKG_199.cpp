#include <bits/stdc++.h>
using namespace std;
int last[1010], c[1010], n, x;
int a[1010], m;
bool ex[1010];
int main() {
  int i, j, pos, tt;
  while (~scanf("%d%d", &n, &x)) {
    for (i = 1; i <= n; i++) scanf("%d", &c[i]);
    m = 0;
    for (i = 0; i <= n; i++) last[i] = -1;
    for (i = 1; i <= n; i++) {
      if (c[i] == 0) continue;
      last[c[i]] = i;
    }
    for (i = 1; i <= n; i++) {
      if (c[i] != 0) continue;
      j = i;
      c[j] = ++m;
      int t = 1;
      if (x == j) pos = t;
      while (last[j] != -1) {
        j = last[j];
        c[j] = m;
        t++;
        if (x == j) pos = t;
      }
    }
    for (i = 0; i <= m; i++) a[i] = 0;
    for (i = 1; i <= n; i++) a[c[i]]++;
    for (i = 0; i <= 1000; i++) ex[i] = 0;
    ex[0] = 1;
    for (j = 1; j <= m; j++) {
      if (j == c[x]) continue;
      for (i = n; i >= 1; i--) {
        if (i - a[j] < 0) break;
        ex[i] |= ex[i - a[j]];
      }
    }
    for (i = 0; i <= n; i++)
      if (ex[i]) printf("%d\n", i + pos);
  }
  return 0;
}
