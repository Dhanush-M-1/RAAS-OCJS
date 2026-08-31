#include <bits/stdc++.h>
int main(void) {
  int n, x, y, t, r;
  while (scanf("%d%d%d", &n, &x, &y) != EOF) {
    t = (int)(1.0 * n * y / 100);
    r = t;
    if (1.0 * n * y / 100 != (double)r) t++;
    if (t >= x) {
      printf("%d\n", t - x);
    } else
      printf("0\n");
  }
  return 0;
}
