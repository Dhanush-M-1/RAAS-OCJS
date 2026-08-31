#include <bits/stdc++.h>
int main() {
  int n, n2, m, i, j, k = 0, a[10000], count = 0;
  scanf("%d %d", &n, &m);
  for (i = 0; i < n; i++) {
    scanf("%d", &n2);
    for (j = 0; j < n2; j++) {
      scanf("%d", &a[k]);
      k++;
    }
  }
  for (i = 1; i <= m; i++) {
    for (j = 0; j < k; j++) {
      if (a[j] == i) {
        count++;
        break;
      }
    }
  }
  if (count == m)
    printf("YES");
  else
    printf("NO");
}
