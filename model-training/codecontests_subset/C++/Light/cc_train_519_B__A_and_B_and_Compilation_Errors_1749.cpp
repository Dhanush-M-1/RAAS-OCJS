#include <bits/stdc++.h>
int main() {
  int n, i, j, k, a[100000], b[100000], c[100000], d, s, S, x = 0, y = 0, z = 0;
  scanf("%d", &n);
  for (i = 0; i < n; i++) {
    scanf("%d", &a[i]);
    x = x + a[i];
  }
  for (i = 0; i < n - 1; i++) {
    scanf("%d", &b[i]);
    y = y + b[i];
  }
  for (i = 0; i < n - 2; i++) {
    scanf("%d", &c[i]);
    z = z + c[i];
  }
  s = x - y;
  S = y - z;
  printf("%d\n %d\n", s, S);
  return 0;
}
