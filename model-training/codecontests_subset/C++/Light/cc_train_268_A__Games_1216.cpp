#include <bits/stdc++.h>
int main() {
  int n, a[30], b[30], i, j, k = 0;
  scanf("%d", &n);
  for (i = 0; i < n; i++) scanf("%d%d", &a[i], &b[i]);
  for (i = 0; i < n; i++) {
    for (j = 0; j < n; j++) {
      if (a[i] == b[j]) k++;
    }
  }
  printf("%d", k);
  return 0;
}
