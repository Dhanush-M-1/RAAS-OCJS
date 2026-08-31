#include <bits/stdc++.h>
int main() {
  int n, k, p;
  scanf("%d %d", &n, &k);
  if ((n <= 100) && (k <= 100)) {
    int A[n];
    int i, j, min;
    int B[n];
    for (i = 0; i < n; i++) {
      scanf("%d", &A[i]);
      if (A[i] > 100) {
        goto label;
      }
    }
    j = 0;
    for (i = 0; i < n; i++) {
      p = A[i];
      if ((k % p) == 0) {
        B[j] = k / p;
        j++;
      }
    }
    min = B[0];
    for (i = 0; i < j; i++) {
      if (B[i] < min) {
        min = B[i];
      }
    }
    printf("%d\n", min);
  }
label:
  return 0;
}
