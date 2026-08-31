#include <bits/stdc++.h>
int main() {
  int n, x, y, rp;
  scanf("%d%d%d", &n, &x, &y);
  if ((n * y) % 100 == 0) {
    rp = (n * y) / 100;
  } else {
    rp = (n * y) / 100 + 1;
  }
  if (rp > x)
    printf("%d", rp - x);
  else
    printf("0");
  return 0;
}
