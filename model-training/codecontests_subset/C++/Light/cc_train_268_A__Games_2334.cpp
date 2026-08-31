#include <bits/stdc++.h>
int main() {
  int i = 0, j = 0, n, count = 0;
  scanf("%d", &n);
  int h[n], g[n];
  for (i = 0; i < n; i++) {
    scanf("%d%d", &h[i], &g[i]);
  }
  for (i = 0; i < n; i++) {
    for (j = 0; j < n; j++) {
      if (h[i] == g[j]) {
        count++;
      }
    }
  }
  printf("%d\n", count);
  return 0;
}
