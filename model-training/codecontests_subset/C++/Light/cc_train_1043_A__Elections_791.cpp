#include <bits/stdc++.h>
int main() {
  int n, i, j, k, aSum, eSum, max;
  while (scanf("%d", &n) != EOF) {
    int a[n];
    for (i = 0; i < n; i++) scanf("%d", &a[i]);
    eSum = 0;
    max = -1;
    for (i = 0; i < n; i++) {
      eSum += a[i];
      if (max < a[i]) max = a[i];
    }
    k = max;
    for (;; k++) {
      aSum = 0;
      for (j = 0; j < n; j++) {
        aSum += (k - a[j]);
      }
      if (aSum > eSum) {
        printf("%d\n", k);
        break;
      }
    }
  }
  return 0;
}
