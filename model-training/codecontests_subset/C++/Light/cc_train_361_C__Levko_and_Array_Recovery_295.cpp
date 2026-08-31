#include <bits/stdc++.h>
using namespace std;
int d[5555], l[5555], r[5555], s[5555], ans[5555], f[5555];
int i, j, k, n;
int main() {
  scanf("%d %d", &n, &k);
  for (i = 1; i <= k; i++) scanf("%d %d %d %d", d + i, l + i, r + i, s + i);
  for (i = 1; i <= n; i++) ans[i] = 1e9;
  for (i = 1; i <= k; i++) {
    if (d[i] == 1)
      for (j = l[i]; j <= r[i]; j++) f[j] += s[i];
    else
      for (j = l[i]; j <= r[i]; j++) ans[j] = min(ans[j], s[i] - f[j]);
  }
  bool ok = 1;
  for (i = 1; i <= n; i++) f[i] = ans[i];
  for (i = 1; i <= k; i++) {
    if (d[i] == 1)
      for (j = l[i]; j <= r[i]; j++) f[j] += s[i];
    else {
      bool k = 0;
      for (j = l[i]; j <= r[i]; j++)
        if (f[j] == s[i]) k = 1;
      if (!k) ok = 0;
    }
  }
  for (i = 1; i <= n; i++)
    if (ans[i] < -1e9 || ans[i] > 1e9) ok = 0;
  if (!ok)
    puts("NO");
  else {
    puts("YES");
    for (i = 1; i <= n; i++) printf("%d ", ans[i]);
  }
  return 0;
}
