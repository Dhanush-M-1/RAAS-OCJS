#include <bits/stdc++.h>
int main() {
  int n, i, j, counter = 0;
  scanf("%d", &n);
  int a[n][2];
  for (i = 0; i < n; i++) {
    for (j = 0; j < 2; j++) {
      scanf("%d", &a[i][j]);
    }
  }
  for (i = 0; i < n; i++) {
    for (j = 0; j < n; j++) {
      if (a[i][0] == a[j][1]) counter++;
    }
  }
  printf("%d", counter);
  return 0;
}
