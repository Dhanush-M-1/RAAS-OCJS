#include <bits/stdc++.h>
int main() {
  int n, x[100000], h[100000], count = 0;
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    scanf("%d %d", &x[i], &h[i]);
  }
  int position = -1000000000;
  bool side = false;
  for (int i = 0; i < n; i++) {
    if (side) {
      if (position < x[i] - h[i]) {
        count++;
        side = false;
      } else if (h[i] < x[i + 1] - x[i] || i == n - 1) {
        count++;
        side = true;
        position = x[i] + h[i];
      } else
        side = false;
    } else if (!side) {
      if (h[i] < x[i] - x[i - 1] || i == 0) {
        count++;
      } else if (h[i] < x[i + 1] - x[i] || i == n - 1) {
        count++;
        side = true;
        position = x[i] + h[i];
      }
    }
  }
  printf("%d", count);
  return 0;
}
