#include <bits/stdc++.h>
int main() {
  int n, x, y, i, j, k = 0, p;
  scanf("%d%d%d", &n, &x, &y);
  i = y * n;
  j = i % 100;
  k = i / 100;
  if (j != 0) {
    k++;
  }
  p = k - x;
  if (p < 0) {
    printf("0\n");
  } else {
    printf("%d\n", p);
  }
  return 0;
}
