#include <bits/stdc++.h>
int main() {
  int n, x, y, a;
  double m;
  scanf("%d%d%d", &n, &x, &y);
  m = (double)y / 100 * n;
  a = ceil(m - x);
  if (a >= 0)
    printf("%d", a);
  else
    printf("0");
  return 0;
}
