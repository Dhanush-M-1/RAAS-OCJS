#include <bits/stdc++.h>
using namespace std;
int n, m;
int a[50010], cnt[50010], d[50010], l[50010], r[50010], op[50010];
int main() {
  int i, j;
  scanf("%d%d", &n, &m);
  memset(a, 0x3f, sizeof(a));
  for (i = 1; i <= m; ++i) {
    scanf("%d%d%d%d", &op[i], &l[i], &r[i], &d[i]);
    if (op[i] == 1) {
      for (j = l[i]; j <= r[i]; ++j) cnt[j] += d[i];
    } else {
      for (j = l[i]; j <= r[i]; ++j) a[j] = min(a[j], d[i] - cnt[j]);
    }
  }
  for (i = 1; i <= n; ++i)
    if (a[i] == 0x3f3f3f3f)
      cnt[i] = a[i] = 0;
    else
      cnt[i] = a[i];
  for (i = 1; i <= m; ++i) {
    if (op[i] == 1)
      for (j = l[i]; j <= r[i]; ++j) cnt[j] += d[i];
    else {
      int maxx = -0x3f3f3f3f;
      for (j = l[i]; j <= r[i]; ++j) maxx = max(maxx, cnt[j]);
      if (maxx != d[i]) {
        printf("NO\n");
        return 0;
      }
    }
  }
  printf("YES\n");
  for (i = 1; i <= n; ++i) printf("%d ", a[i]);
  return 0;
}
