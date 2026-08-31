#include <bits/stdc++.h>
int main() {
  int n, x, y, k;
  scanf("%d %d %d", &n, &x, &y);
  k = ceil((y / 100.0) * n);
  if (k - x >= 0) {
    printf("%d\n", k - x);
  } else {
    printf("0\n");
  }
  return 0;
}
