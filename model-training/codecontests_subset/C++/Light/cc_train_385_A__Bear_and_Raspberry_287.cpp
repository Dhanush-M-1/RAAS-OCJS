#include <bits/stdc++.h>
int main() {
  int x, i, a[104], n, c, y;
  scanf("%d %d", &n, &c);
  x = 0;
  for (i = 0; i < n; i++) scanf("%d", &a[i]);
  for (i = 0; i < n - 1; i++) {
    y = a[i] - a[i + 1] - c;
    if (y > x) x = y;
  }
  printf("%d\n", x);
  return 0;
}
