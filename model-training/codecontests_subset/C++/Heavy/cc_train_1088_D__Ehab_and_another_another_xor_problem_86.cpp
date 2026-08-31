#include <bits/stdc++.h>
using namespace std;
int a, b, st, zero;
int d = (1 << 30) - 1;
int main() {
  a = 0, b = 0;
  puts("? 0 0");
  fflush(stdout);
  scanf("%d", &zero);
  for (int i = 29; i >= 0; --i) {
    if (zero == 0) {
      printf("? %d %d\n", a | (1 << i), b);
      fflush(stdout);
      scanf("%d", &st);
      if (st == -1) a |= 1 << i, b |= 1 << i;
    } else {
      printf("? %d %d\n", a | (1 << i), b | (1 << i));
      fflush(stdout);
      scanf("%d", &st);
      if (st == zero) {
        printf("? %d %d\n", a | (1 << i), b);
        fflush(stdout);
        scanf("%d", &st);
        if (st == -1) a |= 1 << i, b |= 1 << i;
      } else {
        if (st == 1)
          b |= 1 << i;
        else
          a |= 1 << i;
        printf("? %d %d\n", a, b);
        fflush(stdout);
        scanf("%d", &zero);
      }
    }
  }
  printf("! %d %d\n", a, b);
  fflush(stdout);
}
