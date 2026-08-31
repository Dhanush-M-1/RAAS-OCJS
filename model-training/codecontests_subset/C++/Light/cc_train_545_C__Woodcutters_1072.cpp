#include <bits/stdc++.h>
int main() {
  int n;
  scanf("%d", &n);
  if (n == 1) {
    printf("%d", 1);
    return 0;
  }
  int x[100000], h[100000];
  for (int i = 0; i < n; ++i) scanf("%d %d", &x[i], &h[i]);
  int count = 2;
  int left = x[0];
  for (int i = 1; i < n - 1; ++i) {
    if (left < x[i] - h[i]) {
      left = x[i];
      ++count;
    } else if (x[i] + h[i] < x[i + 1]) {
      left = x[i] + h[i];
      ++count;
    } else {
      left = x[i];
    }
  }
  printf("%d", count);
  return 0;
}
