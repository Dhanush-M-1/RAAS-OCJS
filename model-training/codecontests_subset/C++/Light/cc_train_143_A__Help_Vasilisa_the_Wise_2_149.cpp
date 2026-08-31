#include <bits/stdc++.h>
int main() {
  int a, b, c, d, e, f, flag = 1, q, w, i, j;
  scanf("%d%d", &a, &b);
  scanf("%d%d", &c, &d);
  scanf("%d%d", &e, &f);
  for (i = 1; i <= 9; i++) {
    for (j = 1; j <= 9; j++) {
      q = a - i;
      w = b - j;
      if (i + j == c && q + w == d && i + w == e && q + j == f && i != j &&
          i != q && i != w && j != q && j != w && q != w && q >= 1 && w >= 1 &&
          q <= 9 && w <= 9) {
        printf("%d %d\n", i, q);
        printf("%d %d\n", j, w);
        flag = 0;
        break;
      }
    }
  }
  if (flag == 1) printf("-1\n");
  return 0;
}
