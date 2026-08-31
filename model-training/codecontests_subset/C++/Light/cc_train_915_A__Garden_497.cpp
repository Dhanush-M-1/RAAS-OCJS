#include <bits/stdc++.h>
int main() {
  int n, k, a[100], i, t = 0, min, array[100], j = 0, swap, d, c;
  scanf("%d%d", &n, &k);
  for (i = 0; i < n; i++) {
    scanf("%d", &a[i]);
  }
  for (i = 1; i <= n; i++) {
    if (k % a[i - 1] == 0) array[j++] = k / a[i - 1];
  }
  for (c = 0; c < (j - 1); c++) {
    for (d = 0; d < j - c - 1; d++) {
      if (array[d] > array[d + 1]) {
        swap = array[d];
        array[d] = array[d + 1];
        array[d + 1] = swap;
      }
    }
  }
  printf("%d", array[0]);
}
