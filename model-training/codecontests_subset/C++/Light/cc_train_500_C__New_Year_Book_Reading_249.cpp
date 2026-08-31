#include <bits/stdc++.h>
const int N = 1001;
const int M = 5001;
int n, m, k, ans, a[N], b[M], c[M], f[N + 1];
inline int change(int ll) {
  int tp = 0, t = c[ll];
  for (register int i = ll - 1; i > -1; --i) c[i + 1] = c[i], tp += a[c[i]];
  c[0] = t;
  return tp;
}
int main() {
  scanf("%d%d", &n, &m);
  for (register int i = 1; i <= n; ++i) scanf("%d", &a[i]);
  for (register int i = 0; i < m; ++i) scanf("%d", &b[i]);
  c[0] = b[0], f[c[0]] = 1;
  for (register int i = 1; i < m; ++i)
    if (b[i] != c[k] && !f[b[i]]) c[++k] = b[i], f[b[i]] = 1;
  for (register int i = 0; i < m; ++i)
    for (register int j = 0; j <= k; ++j)
      if (b[i] == c[j]) {
        ans += change(j);
        break;
      }
  printf("%d\n", ans);
  return 0;
}
