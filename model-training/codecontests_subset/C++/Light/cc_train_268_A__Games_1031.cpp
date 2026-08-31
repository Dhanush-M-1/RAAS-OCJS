#include <bits/stdc++.h>
int main() {
  int i, j, k, n, count = 0;
  scanf("%d", &n);
  int a[n][2];
  for (i = 0; i < n; i++) {
    for (j = 0; j < 2; j++) scanf("%d", &a[i][j]);
  }
  for (i = 0; i < n; i++) {
    for (k = 0; k < n; k++) {
      if (i != k) {
        if (a[i][0] == a[k][1]) count++;
      }
    }
  }
  for (i = 0; i < n; i++) {
    for (k = 0; k < n; k++) {
      if (i != k) {
        if (a[i][1] == a[k][0]) count++;
      }
    }
  }
  printf("%d", count / 2);
}
