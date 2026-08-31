#include <bits/stdc++.h>
int main() {
  int n, i, j, k, sum = 0;
  int temp;
  scanf("%d", &n);
  int a[n];
  for (i = 0; i < n; i++) {
    scanf("%d", &a[i]);
  }
  for (i = 0; i < n; i++) {
    sum = sum + a[i];
  }
  for (i = 0; i < n - 1; i++) {
    for (j = i + 1; j < n; j++) {
      if (a[i] < a[j]) {
        temp = a[j];
        a[j] = a[i];
        a[i] = temp;
      }
    }
  }
  k = a[0];
  for (i = 0; i <= a[0] + 2; i++) {
    if (((k * n) - sum) > sum) {
      printf("%d", k);
      break;
    }
    ++k;
  }
}
