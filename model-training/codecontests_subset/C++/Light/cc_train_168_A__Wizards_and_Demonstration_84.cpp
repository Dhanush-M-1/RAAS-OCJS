#include <bits/stdc++.h>
int n, x, y;
double dpeople;
int ipeople;
int main() {
  scanf("%d %d %d", &n, &x, &y);
  dpeople = (double)n * y / 100;
  if (dpeople <= x) {
    printf("0\n");
    return 0;
  }
  ipeople = dpeople;
  if (ipeople == dpeople)
    printf("%d\n", ipeople - x);
  else
    printf("%d\n", ipeople + 1 - x);
  return 0;
}
