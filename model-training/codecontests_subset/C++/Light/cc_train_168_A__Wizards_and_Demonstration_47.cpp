#include <bits/stdc++.h>
int main() {
  int n, x, y, m;
  scanf("%d %d %d", &n, &x, &y);
  double s;
  s = (y / 100.0) * n;
  if (s == (int)s)
    m = (int)s;
  else
    m = (int)s + 1;
  if (m <= x)
    printf("0\n");
  else
    printf("%d\n", m - x);
  return 0;
}
