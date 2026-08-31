#include <bits/stdc++.h>
int main() {
  int n, x, y, a;
  scanf("%d%d%d", &n, &x, &y);
  a = n * y;
  if (a <= x * 100)
    printf("0\n");
  else
    printf("%d\n", (a - x * 100) / 100 + ((a - x * 100) % 100 ? 1 : 0));
  return 0;
}
