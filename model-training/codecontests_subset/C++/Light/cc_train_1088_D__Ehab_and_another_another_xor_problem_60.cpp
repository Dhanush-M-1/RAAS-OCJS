#include <bits/stdc++.h>
int A, B;
void ask(int x, int y) {
  printf("? %d %d\n", x, y);
  fflush(stdout);
}
void succ(int x, int y) {
  printf("! %d %d\n", x, y);
  fflush(stdout);
  exit(0);
}
int main() {
  ask(0, 0);
  int cmp;
  scanf("%d", &cmp);
  for (int i = 29; ~i; --i) {
    ask(1 << i | A, 1 << i | B);
    int x;
    scanf("%d", &x);
    if (x == cmp) {
      ask(1 << i | A, B);
      scanf("%d", &x);
      if (x == -1) A |= 1 << i, B |= 1 << i;
    } else {
      if (cmp == 1)
        A |= 1 << i;
      else
        B |= 1 << i;
      ask(A, B);
      scanf("%d", &cmp);
    }
  }
  succ(A, B);
}
