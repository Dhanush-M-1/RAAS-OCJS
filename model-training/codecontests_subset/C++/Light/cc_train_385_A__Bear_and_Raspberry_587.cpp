#include <bits/stdc++.h>
int main() {
  int n, c, x[101], i, max = 0, k = -1;
  scanf("%d %d", &n, &c);
  for (i = 0; i < n; i++) {
    scanf("%d", &x[i]);
    if (i > 0) {
      if (x[i - 1] - x[i] - c > max) {
        max = x[i - 1] - x[i] - c;
        k = i;
      }
    }
  }
  max > 0 ? printf("%d\n", max) : printf("0\n");
  return 0;
}
