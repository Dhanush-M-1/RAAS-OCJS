#include <bits/stdc++.h>
int n, a, b, c;
int main() {
  scanf("%d %d %d %d", &n, &a, &b, &c);
  int x, y, z;
  int res = 0;
  int d;
  for (z = (n - b - a / 2) / 2, z >= 0; z <= n / 2, z <= c; z++)
    for (y = n - 2 * z - a / 2; (y <= b) && (y <= n - 2 * z); y++) {
      if (y < 0)
        y = -1;
      else if (z < 0)
        z = -1;
      else {
        d = n - 2 * z - y;
        if ((d >= 0) && (2 * d <= a)) res++;
      }
    }
  printf("%d\n", res);
}
