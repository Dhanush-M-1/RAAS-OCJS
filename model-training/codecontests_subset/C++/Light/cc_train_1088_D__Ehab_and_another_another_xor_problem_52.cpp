#include <bits/stdc++.h>
int ask(int a, int b) {
  printf("? %d %d\n", a, b);
  fflush(stdout);
  scanf("%d", &a);
  return a;
}
int main(void) {
  int i, a, b, big, f1, f2;
  for (a = b = 0, big = ask(0, 0), i = 29; i >= 0; i--) {
    f1 = ask(a | (1 << i), b);
    f2 = ask(a, b | (1 << i));
    if (f1 == f2) {
      if (big == 1)
        a |= 1 << i;
      else
        b |= 1 << i;
      big = f1;
    } else {
      if (f1 == -1) {
        a |= 1 << i;
        b |= 1 << i;
      }
    }
  }
  printf("! %d %d\n", a, b);
  return 0;
}
