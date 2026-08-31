#include <bits/stdc++.h>
int main() {
  int ans = 1, j, n, m, i, x, y, a[105] = {0};
  scanf("%d %d", &n, &m);
  for (i = 0; i < n; i++) {
    scanf("%d", &x);
    for (j = 0; j < x; j++) {
      scanf("%d", &y);
      a[y] = 1;
    }
  }
  for (i = 1; i <= m; i++) {
    ans = ans * a[i];
  }
  if (ans == 0)
    printf("NO\n");
  else
    printf("YES\n");
  return 0;
}
