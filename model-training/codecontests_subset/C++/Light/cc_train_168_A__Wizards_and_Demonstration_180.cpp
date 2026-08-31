#include <bits/stdc++.h>
int main() {
  int n, x, y;
  scanf("%d %d %d", &n, &x, &y);
  if ((n * y) % 100 == 0)
    y = n * y / 100;
  else
    y = n * y / 100 + 1;
  printf("%d", y - x > 0 ? y - x : 0);
  return 0;
}
