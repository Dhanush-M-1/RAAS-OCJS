#include <bits/stdc++.h>
using namespace std;
const int inf = 0x3f3f3f3f;
int ask(int c, int d) {
  printf("? %d %d\n", c, d);
  fflush(stdout);
  int lins;
  scanf("%d", &lins);
  return lins;
}
int main() {
  int a = 0, b = 0;
  int cmp = ask(a, b);
  for (int i = 29; i >= 0; i--) {
    int cal_a = ask(a ^ (1 << i), b);
    int cal_b = ask(a, b ^ (1 << i));
    if (cal_a == cal_b) {
      if (cmp == 1) {
        a ^= (1 << i);
      } else {
        b ^= (1 << i);
      }
      cmp = cal_a;
    } else if (cal_b == 1) {
      a ^= (1 << i);
      b ^= (1 << i);
    }
  }
  printf("! %d %d\n", a, b);
  fflush(stdout);
}
