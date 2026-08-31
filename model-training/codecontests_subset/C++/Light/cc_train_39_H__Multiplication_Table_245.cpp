#include <bits/stdc++.h>
int main() {
  int x;
  scanf("%d", &x);
  for (long r = 1; r < x; r++) {
    for (long c = 1; c < x; c++) {
      long mul = r * c;
      if (mul >= x) {
        mul = 10 * (mul / x) + (mul % x);
      }
      printf("%ld ", mul);
    }
    puts("");
  }
  return 0;
}
