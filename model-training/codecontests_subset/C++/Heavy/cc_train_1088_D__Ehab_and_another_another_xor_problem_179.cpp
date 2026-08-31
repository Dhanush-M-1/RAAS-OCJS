#include <bits/stdc++.h>
using namespace std;
int main() {
  int a = 0, b = 0;
  int res, mask1 = 0, mask2 = 0;
  printf("? 0 0\n");
  fflush(stdout);
  scanf("%d", &res);
  int asli = res;
  for (int i = 29; i >= 0; i--) {
    mask1 = mask1 | (1 << i);
    mask2 = mask2 | (1 << i);
    printf("? %d %d\n", mask1, mask2);
    fflush(stdout);
    scanf("%d", &res);
    if (res != asli) {
      if (asli > 0) {
        a = a | (1 << i);
        mask2 = mask2 ^ (1 << i);
      } else {
        b = b | (1 << i);
        mask2 = mask2 ^ (1 << i);
      }
      printf("? %d %d\n", mask1, mask2);
      fflush(stdout);
      scanf("%d", &res);
      asli = res;
    }
  }
  for (int i = 29; i >= 0; i--) {
    if ((mask2 & (1 << i))) {
      int c = mask1;
      int d = mask2 ^ (1 << i);
      printf("? %d %d\n", c, d);
      fflush(stdout);
      scanf("%d", &res);
      if (res < 0) a = a | (1 << i), b = b | (1 << i);
    }
  }
  printf("! %d %d\n", a, b);
  fflush(stdout);
  return 0;
}
