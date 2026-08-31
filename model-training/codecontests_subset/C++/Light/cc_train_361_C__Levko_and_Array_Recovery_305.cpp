#include <bits/stdc++.h>
using namespace std;
int a[5005], b[5005], c[5005], d[5005], l[5005], r[5005];
int main() {
  int n, m, i, j;
  scanf("%d%d", &n, &m);
  for (i = 1; i <= n; i++) {
    b[i] = 1000000000;
  }
  for (i = 1; i <= m; i++) {
    scanf("%d%d%d%d", &c[i], &l[i], &r[i], &d[i]);
    for (j = l[i]; j <= r[i]; j++) {
      if (c[i] == 1)
        a[j] += d[i];
      else
        b[j] = min(b[j], d[i] - a[j]);
    }
  }
  memset(a, 0, sizeof(a));
  for (i = 1; i <= m; i++) {
    int mm = -1000000000;
    for (j = l[i]; j <= r[i]; j++) {
      if (c[i] == 1)
        a[j] += d[i];
      else
        mm = max(mm, b[j] + a[j]);
    }
    if (c[i] == 2 && mm != d[i]) break;
  }
  if (i > m) {
    printf("YES\n");
    for (i = 1; i < n; i++) {
      printf("%d ", b[i]);
    }
    printf("%d\n", b[n]);
  } else
    printf("NO\n");
  return 0;
}
