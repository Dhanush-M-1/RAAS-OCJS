#include <bits/stdc++.h>
int main() {
  int n, x, y, t = 0;
  double perc, ratio;
  scanf("%d%d%d", &n, &x, &y);
  perc = y * 0.01;
  ratio = (double)x / n;
  while (ratio < perc) {
    t++;
    ratio = (double)(x + t) / n;
  }
  printf("%d\n", t);
  return 0;
}
