#include <bits/stdc++.h>
int main() {
  int i, j, n, a[100][100], m = 0;
  scanf("%d", &n);
  for (i = 0; i < n; i++) {
    for (j = 0; j < 2; j++) {
      scanf("%d", &a[i][j]);
    }
  }
  for (i = 0; i < n; i++) {
    for (j = 0; j < n; j++) {
      if (a[i][0] != a[j][1] && i != j) m++;
    }
  }
  printf("%d", n * (n - 1) - m);
  return 0;
}
