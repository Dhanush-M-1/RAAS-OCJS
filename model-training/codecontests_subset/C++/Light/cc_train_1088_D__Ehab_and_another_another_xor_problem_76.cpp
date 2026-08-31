#include <bits/stdc++.h>
using namespace std;
const int MAXN = 1e2 + 10;
int ask(int c, int d) {
  printf("? %d %d\n", c, d);
  fflush(stdout);
  int res;
  scanf("%d", &res);
  return res;
}
int main() {
  int a = 0, b = 0;
  int last = ask(a, b);
  for (int i = 29; i >= 0; i--) {
    int res1 = ask(a | (1 << i), b), res2 = ask(a, b | (1 << i));
    if (res1 == res2) {
      if (last == 1)
        a |= (1 << i);
      else
        b |= (1 << i);
      last = res1;
    } else if (res1 == -1) {
      a |= (1 << i);
      b |= (1 << i);
    }
  }
  printf("! %d %d\n", a, b);
  fflush(stdout);
  return 0;
}
