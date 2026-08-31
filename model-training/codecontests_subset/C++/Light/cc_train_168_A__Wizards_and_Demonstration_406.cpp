#include <bits/stdc++.h>
int main() {
  int n, x, y;
  scanf("%d%d%d", &n, &x, &y);
  int s = (n * y + 99) / 100;
  printf("%d\n", s > x ? s - x : 0);
}
