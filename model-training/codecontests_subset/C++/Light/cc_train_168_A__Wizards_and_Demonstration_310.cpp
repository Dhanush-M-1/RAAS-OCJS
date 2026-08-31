#include <bits/stdc++.h>
int main() {
  float n, x, y, res, p;
  scanf("%f%f%f", &n, &x, &y);
  if (ceil((n * y) / 100) > x) {
    p = ((n * y) / 100) - int((n * y) / 100);
    if ((p > 0) && (p < 0.1))
      res = ((n * y) / 100) + 1 - x;
    else
      res = ceil((n * y) / 100) - x;
    printf("%.0f", res);
  } else
    printf("0");
  return (0);
}
