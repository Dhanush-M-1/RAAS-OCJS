#include <bits/stdc++.h>
int main(void) {
  int r1, r2, c1, c2, d1, d2, i, j, k, l;
  scanf("%d%d", &r1, &r2);
  scanf("%d%d", &c1, &c2);
  scanf("%d%d", &d1, &d2);
  for (i = 1; i <= 9; i++)
    for (j = r1 - i; j <= 9; j++)
      for (k = c1 - i; k <= 9; k++)
        for (l = d1 - i; l <= 9; l++) {
          if (j >= 1 && k >= 1 && l >= 1 && (k + j) == d2 && (k + l) == r2 &&
              (i + k) == c1 && (j + l) == c2) {
            if ((i != j) && (i != k) && (i != l) && (j != k) && (j != l) &&
                (k != l)) {
              printf("%d %d\n%d %d", i, j, k, l);
              return 0;
            }
          }
        }
  printf("-1");
  return 0;
}
