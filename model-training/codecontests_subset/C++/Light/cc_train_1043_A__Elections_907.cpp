#include <bits/stdc++.h>
int main() {
  int i, n, arr[1000];
  scanf("%d", &n);
  for (i = 0; i < n; i++) {
    scanf("%d", &arr[i]);
  }
  int x = 0;
  for (i = 0; i < n; i++) {
    x = x + arr[i];
  }
  int k = (x * 2) + 1;
  while (1) {
    if (k % n != 0) {
      k = k + 1;
    }
    if (k % n == 0) {
      break;
    }
  }
  int res = k / n;
  for (i = 0; i < n; i++) {
    if (res < arr[i]) {
      res = arr[i];
    }
  }
  printf("%d", res);
  return 0;
}
