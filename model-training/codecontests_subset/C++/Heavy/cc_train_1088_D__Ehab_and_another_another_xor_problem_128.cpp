#include <bits/stdc++.h>
using namespace std;
const int B = 30;
int ask(int c, int d) {
  printf("? %d %d\n", c, d);
  fflush(stdout);
  int resp;
  scanf("%d", &resp);
  if (resp == -2) exit(0);
  return resp;
}
int main() {
  int ma = 0, mb = 0, a = 0, b = 0;
  int state = ask(0, 0);
  for (int i = B - 1; i >= 0; i--) {
    int bit = (1 << i);
    if (state == 0) {
      int resp = ask(ma ^ bit, mb);
      if (resp == -1) {
        a |= bit;
        b |= bit;
      }
    } else {
      int resp = ask(ma ^ bit, mb ^ bit);
      if (resp != state) {
        if (resp == 1) {
          b |= bit;
          mb |= bit;
        } else {
          a |= bit;
          ma |= bit;
        }
        state = ask(ma, mb);
      } else {
        resp = ask(ma ^ bit, mb);
        if (resp == -1) {
          a |= bit;
          b |= bit;
        }
      }
    }
  }
  printf("! %d %d\n", a, b);
  fflush(stdout);
  return 0;
}
