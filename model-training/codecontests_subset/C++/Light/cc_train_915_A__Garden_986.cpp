#include <bits/stdc++.h>
int main() {
  int n, k, hrs = 0, i, j, t;
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
      hrs = (k / a[i]);
      break;
    }
  }
  if (hrs == 0) hrs = k;
  printf("%d", hrs);
}
