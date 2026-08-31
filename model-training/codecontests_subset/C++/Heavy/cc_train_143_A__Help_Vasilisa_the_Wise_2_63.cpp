#include <bits/stdc++.h>
int main() {
  int r1, r2, c1, c2, d1, d2;
  scanf("%d%d%d%d%d%d", &r1, &r2, &c1, &c2, &d1, &d2);
  int flag = 0;
  for (int a = 1; a <= 9; a++) {
    for (int b = 1; b <= 9; b++) {
      for (int c = 1; c <= 9; c++) {
        for (int d = 1; d <= 9; d++) {
          if (a + b == r1 && c + d == r2 && a + c == c1 && b + d == c2 &&
              a + d == d1 && b + c == d2 && a != b && a != c && a != d &&
              b != c && b != d && c != d) {
            printf("%d %d\n", a, b);
            printf("%d %d\n", c, d);
            flag = 1;
            break;
          }
        }
      }
    }
  }
  if (flag != 1) printf("-1\n");
  return 0;
}
