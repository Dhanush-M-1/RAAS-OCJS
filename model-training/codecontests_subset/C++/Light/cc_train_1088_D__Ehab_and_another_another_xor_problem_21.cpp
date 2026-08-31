#include <bits/stdc++.h>
using namespace std;
int ask(int c, int d) {
  printf("? %d %d\n", c, d);
  fflush(stdout);
  int res;
  scanf("%d", &res);
  return res;
}
int main() {
  int cur = ask(0, 0);
  int a = 0, b = 0;
  for (int i = 29; i >= 0; --i) {
    int res1 = ask(a, b | 1 << i);
    int res2 = ask(a | 1 << i, b);
    if (res1 != res2) {
      if (res1 > 0) {
        a |= 1 << i;
        b |= 1 << i;
      }
    } else {
      if (cur > 0) {
        a |= 1 << i;
      } else {
        b |= 1 << i;
      }
      cur = res1;
    }
  }
  printf("! %d %d\n", a, b), fflush(stdout);
  return 0;
}
