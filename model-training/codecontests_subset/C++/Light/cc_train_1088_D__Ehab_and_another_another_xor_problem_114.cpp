#include <bits/stdc++.h>
using namespace std;
bool fl;
int a, b;
int ask(int x, int y) {
  printf("? %d %d\n", x, y);
  fflush(stdout);
  int res = 0;
  scanf("%d", &res);
  return res;
}
int main() {
  a = b = 0;
  fl = 1;
  if (ask(a, b) < 0) fl = 0;
  for (int i = 29; i >= 0; i--) {
    int qa = a ^ (1 << i), qb = b ^ (1 << i);
    int x = ask(qa, b), y = ask(a, qb);
    if (x == y) {
      if (fl)
        a ^= (1 << i);
      else
        b ^= (1 << i);
      fl = (x == 1);
    } else if (x == -1 && y == 1)
      a ^= (1 << i), b ^= (1 << i);
  }
  printf("! %d %d\n", a, b);
  return 0;
}
