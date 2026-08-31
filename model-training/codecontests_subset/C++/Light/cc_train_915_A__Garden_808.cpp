#include <bits/stdc++.h>
int main() {
  int n, k, i, j, t, max = 0;
  scanf("%d%d", &n, &k);
  int a[n];
  for (i = 0; i < n; i++) {
    scanf("%d", &a[i]);
  }
  for (i = 0; i < n; i++) {
    for (j = i + 1; j < n; j++) {
      if (a[i] > a[j]) {
        t = a[i];
        a[i] = a[j];
        a[j] = t;
      }
    }
  }
  for (i = n - 1; i >= 0; i--) {
    if (k % a[i] == 0) {
      max = a[i];
      break;
    }
  }
  printf("%d", k / max);
}
