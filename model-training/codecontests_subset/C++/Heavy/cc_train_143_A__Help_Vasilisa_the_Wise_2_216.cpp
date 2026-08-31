#include <bits/stdc++.h>
int main() {
  int r1, r2, c1, c2, d1, d2, key[2][2];
  int i1, i2, i3, i4, flag = 0;
  scanf("%d %d %d %d %d %d", &r1, &r2, &c1, &c2, &d1, &d2);
  for (i1 = 1; i1 < 10; i1++) {
    for (i2 = 1; i2 < 10; i2++) {
      for (i3 = 1; i3 < 10; i3++) {
        for (i4 = 1; i4 < 10; i4++) {
          if ((i1 + i2 == r1) && (i3 + i4 == r2) && (i1 + i3 == c1) &&
              (i2 + i4 == c2) && (i1 + i4 == d1) && (i2 + i3 == d2)) {
            flag = 1;
            break;
          }
        }
        if (flag == 1) break;
      }
      if (flag == 1) break;
    }
    if (flag == 1) break;
  }
  if ((i1 != i2) && (i1 != i3) && (i1 != i4) && (i2 != i3) && (i2 != i4) &&
      (i3 != i4))
    flag = 2;
  if (flag == 2)
    printf("%d %d\n%d %d", i1, i2, i3, i4);
  else
    printf("-1");
  return 0;
}
