#include <bits/stdc++.h>
int main() {
  int n, count = 0, i, j;
  scanf("%d", &n);
  int h[n], a[n];
  for (i = 0; i < n; i++) scanf("%d %d", &h[i], &a[i]);
  for (i = 0; i < n; i++) {
    for (j = 0; j < n; j++) {
      if (h[i] == a[j]) count++;
    }
  }
  printf("%d\n", count);
  return 0;
}
