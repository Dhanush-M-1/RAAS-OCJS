#include <bits/stdc++.h>
using namespace std;
const int N = 6000, MAX = 0x7FFFFFF;
int n, m, i, j, ans, a[N], b[N], k[N], l[N], r[N], d[N];
bool ok = true;
int main() {
  scanf("%d%d", &n, &m);
  for (i = 1; i <= n; i++) a[i] = MAX;
  for (i = 1; i <= m; i++) scanf("%d%d%d%d", k + i, l + i, r + i, d + i);
  for (i = m; i > 0; i--)
    if (k[i] == 1) {
      for (j = l[i]; j <= r[i]; j++)
        if (a[j] != MAX) a[j] -= d[i];
    } else
      for (j = l[i]; j <= r[i]; j++) a[j] = min(d[i], a[j]);
  for (i = 1; i <= n; i++) b[i] = (a[i] == MAX) ? 0 : a[i];
  for (i = 1; i <= m; i++)
    if (k[i] == 2) {
      ans = -MAX;
      for (j = l[i]; j <= r[i]; j++) ans = max(ans, a[j]);
      if (ans != d[i]) ok = false;
    } else
      for (j = l[i]; j <= r[i]; j++) a[j] += d[i];
  if (ok) {
    printf("YES\n%d", b[1]);
    for (i = 2; i <= n; i++) printf(" %d", b[i]);
    printf("\n");
  } else
    printf("NO\n");
  return 0;
}
