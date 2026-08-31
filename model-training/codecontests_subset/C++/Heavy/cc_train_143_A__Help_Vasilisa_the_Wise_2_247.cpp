#include <bits/stdc++.h>
int main() {
  int x1, x2, x3, x4, num, a, b, c, d, e, f, g, h, i, j;
  while (scanf("%d%d%d%d%d%d", &a, &b, &c, &d, &e, &f) != EOF) {
    num = 0;
    for (g = 1; g <= 9; g++) {
      for (h = 1; h <= 9; h++) {
        if (h == g) {
          continue;
        } else {
          for (i = 1; i <= 9; i++) {
            if (i == g || i == h) {
              continue;
            } else {
              for (j = 1; j <= 9; j++) {
                if (j == g || j == h || j == i) {
                  continue;
                } else {
                  if ((a == g + h) && (b == i + j) && (e == g + j) &&
                      (c == g + i) && (d == h + j) && (f == h + i)) {
                    num = num + 1;
                    x1 = g;
                    x2 = h;
                    x3 = i;
                    x4 = j;
                  }
                }
              }
            }
          }
        }
      }
    }
    if (num == 0) {
      printf("-1\n");
    } else {
      printf("%d %d\n", x1, x2);
      printf("%d %d\n", x3, x4);
    }
  }
  return 0;
}
