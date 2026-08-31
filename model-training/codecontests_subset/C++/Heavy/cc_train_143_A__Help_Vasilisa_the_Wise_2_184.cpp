#include <bits/stdc++.h>
int main() {
  int r1, r2, c1, c2, d1, d2;
  while (scanf("%d%d%d%d%d%d", &r1, &r2, &c1, &c2, &d1, &d2) != EOF) {
    int n = 0;
    int a, b, c, d;
    for (a = 1; a <= 9; a++) {
      for (b = 1; b <= 9; b++) {
        for (c = 1; c <= 9; c++) {
          for (d = 1; d <= 9; d++) {
            if (a + b == r1 && c + d == r2 && a + c == c1 && b + d == c2 &&
                a + d == d1 && b + c == d2 && a != b && a != c && a != d &&
                b != c && b != d && c != d) {
              printf("%d %d\n%d %d\n", a, b, c, d);
              n++;
            }
          }
        }
      }
    }
    if (n == 0) printf("-1\n");
  }
}
