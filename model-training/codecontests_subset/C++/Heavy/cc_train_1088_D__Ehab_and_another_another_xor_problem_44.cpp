#include <bits/stdc++.h>
using namespace std;
int a, b, c, d, tot, pw, t;
int ask(int x, int y) {
  printf("? %d %d\n", x, y);
  fflush(stdout);
  int res = 0;
  scanf("%d", &res);
  return res;
}
int main() {
  t = ask(0, 0);
  for (int i = 29; i >= 0; i--) {
    int fi, se;
    pw = (1 << i);
    fi = c + pw;
    se = d + pw;
    tot = ask(fi, se);
    if (tot == t) {
      int re = ask(c, se);
      if (re == 1) {
        a |= pw;
        b |= pw;
        c |= pw;
        d |= pw;
      }
    } else {
      if (t == -1) {
        b |= pw;
        c |= pw;
      } else {
        a |= pw;
        d |= pw;
      }
      t = ask(c, d);
    }
  }
  printf("! %d %d\n", a, b);
}
