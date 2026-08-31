#include <bits/stdc++.h>
using namespace std;
int p[5001], o[5001], ans[5001];
int t[5001], l[5001], r[5001], d[5001];
int main() {
  int n, m, i, j, flag, maxz;
  scanf("%d%d", &n, &m);
  for (i = 1; i <= n; i++) p[i] = -10000000;
  for (i = 1; i <= m; i++) {
    scanf("%d%d%d%d", &t[i], &l[i], &r[i], &d[i]);
  }
  flag = 0;
  for (i = m; i >= 1; i--) {
    if (t[i] == 1) {
      for (j = l[i]; j <= r[i]; j++) p[j] -= d[i];
    } else {
      for (j = l[i]; j <= r[i]; j++) {
        if (o[j] && p[j] < d[i]) continue;
        p[j] = d[i];
        o[j] = 1;
      }
    }
  }
  for (i = 1; i <= n; i++) ans[i] = p[i];
  for (i = 1; i <= m; i++) {
    if (t[i] == 1) {
      for (j = l[i]; j <= r[i]; j++) p[j] += d[i];
    } else {
      maxz = -1000000000;
      for (j = l[i]; j <= r[i]; j++) {
        maxz = max(maxz, p[j]);
      }
      if (maxz != d[i]) flag = 1;
    }
  }
  if (flag)
    printf("NO\n");
  else {
    printf("YES\n");
    for (i = 1; i <= n; i++) {
      if (i == 1)
        printf("%d", ans[i]);
      else
        printf(" %d", ans[i]);
    }
    printf("\n");
  }
  return 0;
}
