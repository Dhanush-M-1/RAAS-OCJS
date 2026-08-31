#include <bits/stdc++.h>
using namespace std;
int ask(int c, int d) {
  int x;
  printf("? %d %d\n", c, d);
  fflush(stdout);
  scanf("%d", &x);
  return x;
}
int main() {
  int a = 0, b = 0, f;
  int c = 0, d = 0, h = 0, k = 0;
  f = ask(c, d);
  for (int i = 29; i >= 0; i--) {
    if (f == 0) {
      c = (1 << i), d = (0 << i);
      if (ask(h | c, k | d) == -1) a |= 1 << i, b |= 1 << i;
      continue;
    }
    c = (1 << i), d = (1 << i);
    if (ask(a | c, b | d) == f) {
      if (f == 1 && ask(a | c, b) == -f) {
        a |= 1 << i;
        b |= 1 << i;
      }
      if (f == -1 && ask(a, b | d) == -f) {
        a |= 1 << i;
        b |= 1 << i;
      }
    } else {
      if (f == 1)
        a |= 1 << i;
      else
        b |= 1 << i;
      f = ask(a, b);
      if (f == 0) h = a, k = b;
    }
  }
  printf("! %d %d\n", a, b);
  fflush(stdout);
  return 0;
}
