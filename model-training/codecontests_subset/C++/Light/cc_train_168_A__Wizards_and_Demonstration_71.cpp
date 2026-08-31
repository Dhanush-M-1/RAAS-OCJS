#include <bits/stdc++.h>
int main() {
  int n, x, y;
  while (~scanf("%d%d%d", &n, &x, &y)) {
    int num = ceil(n * (y * 1.0 / 100));
    if (x >= num)
      printf("0\n");
    else
      printf("%d\n", num - x);
  }
  return 0;
}
