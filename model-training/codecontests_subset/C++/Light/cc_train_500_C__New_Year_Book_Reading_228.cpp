#include <bits/stdc++.h>
int n, m, x, i, j, t, ans, a[1001], w[501];
bool f[501];
int main() {
  scanf("%d%d", &n, &m);
  for (i = 1; i <= n; ++i) scanf("%d", w + i);
  for (i = 1; i <= m; ++i) {
    scanf("%d", a + i);
    memset(f, 0, sizeof f);
    for (j = i - 1, t = 0; j && a[j] != a[i]; --j)
      if (!f[a[j]]) {
        f[a[j]] = 1;
        t += w[a[j]];
      }
    ans += t;
  }
  printf("%d\n", ans);
  return 0;
}
