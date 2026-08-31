#include <bits/stdc++.h>
int main() {
  int n, i, j, g = 0;
  scanf("%d", &n);
  int h[n], a[n];
  for (i = 0; i < n; i++) {
    scanf("%d%d", &h[i], &a[i]);
  }
  for (i = 0; i < n; i++) {
    for (j = 0; j < n; j++) {
      if (i == j) {
        continue;
      } else if (h[i] == a[j]) {
        g++;
      }
    }
  }
  printf("%d", g);
  return 0;
}
