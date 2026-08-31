#include <bits/stdc++.h>
using namespace std;
int Pow[35];
int main() {
  int a = 0, b = 0, x, y, i, how;
  Pow[0] = 1;
  for (i = 1; i <= 29; i++) Pow[i] = Pow[i - 1] * 2;
  printf("? 0 0\n");
  fflush(stdout);
  scanf("%d", &how);
  for (i = 29; i >= 0; i--) {
    printf("? %d %d\n", a + Pow[i], b);
    fflush(stdout);
    scanf("%d", &x);
    printf("? %d %d\n", a, b + Pow[i]);
    fflush(stdout);
    scanf("%d", &y);
    if (x > y) {
      a += 0;
      b += 0;
    } else if (x < y) {
      a += Pow[i];
      b += Pow[i];
    } else {
      if (how == 1)
        a += Pow[i];
      else
        b += Pow[i];
      how = x;
    }
  }
  printf("! %d %d\n", a, b);
  fflush(stdout);
  return 0;
}
