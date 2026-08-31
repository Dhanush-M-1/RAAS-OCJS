#include <bits/stdc++.h>
int main() {
  int r1, r2, c1, c2, d1, d2, x1, x2, x3, x4;
  scanf("%d%d%d%d%d%d", &r1, &r2, &c1, &c2, &d1, &d2);
  x1 = (d1 + r1 - c2) / 2;
  x2 = (c2 + r1 - d1) / 2;
  x3 = (2 * r2 + r1 - d1 - c2) / 2;
  x4 = (d1 + c2 - r1) / 2;
  bool ind = 1;
  if (x1 == x2 || x1 == x3 || x1 == x4 || x2 == x3 || x2 == x4 || x3 == x4) {
    ind = 0;
  }
  if (x1 > 9 || x1 < 1 || x2 > 9 || x2 < 1 || x3 > 9 || x3 < 1 || x4 > 9 ||
      x4 < 1) {
    ind = 0;
  }
  if (c2 + c1 != r1 + r2 || d1 + d2 != r1 + r2) {
    ind = 0;
  }
  if (ind) {
    printf("%d %d\n%d %d\n", x1, x2, x3, x4);
  } else {
    printf("%d\n", -1);
  }
  return 0;
}
