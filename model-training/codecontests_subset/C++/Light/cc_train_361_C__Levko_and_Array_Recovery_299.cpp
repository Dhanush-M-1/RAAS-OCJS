#include <bits/stdc++.h>
using namespace std;
const int Maxn = 5010;
int n, m, t[Maxn], l[Maxn], r[Maxn], p[Maxn], ans[Maxn], d[Maxn];
bool sat[Maxn];
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= m; i++) scanf("%d%d%d%d", &t[i], &l[i], &r[i], &p[i]);
  for (int i = 1; i <= n; i++) ans[i] = 1e9;
  for (int i = 1; i <= m; i++)
    if (t[i] == 1)
      for (int j = l[i]; j <= r[i]; j++) d[j] += p[i];
    else
      for (int j = l[i]; j <= r[i]; j++) ans[j] = min(ans[j], p[i] - d[j]);
  memset(d, 0, sizeof(d));
  bool flag = true;
  for (int i = 1; i <= m; i++)
    if (t[i] == 1)
      for (int j = l[i]; j <= r[i]; j++) d[j] += p[i];
    else {
      int tmp = ans[l[i]] + d[l[i]];
      for (int j = l[i] + 1; j <= r[i]; j++) tmp = max(tmp, ans[j] + d[j]);
      if (tmp != p[i]) flag = false;
    }
  if (!flag)
    printf("NO\n");
  else {
    printf("YES\n");
    for (int i = 1; i < n; i++) printf("%d ", ans[i]);
    printf("%d\n", ans[n]);
  }
  return 0;
}
