#include <bits/stdc++.h>
int main() {
  int a[100], b[100], n, l, i, k = 0, max = 0;
  scanf("%d%d", &n, &l);
  for (i = 0; i < n; i++) {
    scanf("%d", &a[i]);
    if (l % a[i] == 0) {
      b[k] = a[i];
      k++;
    }
  }
  max = b[0];
  for (i = 0; i < k; i++) {
    if (b[i] > max) {
      max = b[i];
    }
  }
  printf("%d", (l / max));
  return 0;
}
