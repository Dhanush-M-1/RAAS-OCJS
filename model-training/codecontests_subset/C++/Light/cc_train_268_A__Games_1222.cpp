#include <bits/stdc++.h>
int main() {
  int n, sum = 0;
  scanf("%d", &n);
  int a[n], h[n];
  for (int i = 0; i < n; ++i) {
    scanf("%d%d", &h[i], &a[i]);
  }
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < n; ++j) {
      if (h[i] == a[j]) {
        sum = sum + 1;
      }
    }
  }
  printf("%d", sum);
  return 0;
}
