#include <bits/stdc++.h>
using namespace std;
int main() {
  unsigned long a = (1 << 30), b = (1 << 30);
  unsigned long ansa = 0x0, ansb = 0x0;
  int diff, q1, q;
  printf("? 0 0\n");
  fflush(stdout);
  scanf("%d", &diff);
  for (int k = 1; k <= 30; k++) {
    a = (ansa)&0xffffffff;
    b = (ansb)&0xffffffff;
    a |= (1 << (30 - k));
    printf("? %lu %lu\n", a, b);
    fflush(stdout);
    scanf("%d", &q);
    b |= (1 << (30 - k));
    a ^= (1 << (30 - k));
    printf("? %lu %lu\n", a, b);
    fflush(stdout);
    scanf("%d", &q1);
    if (q != q1) {
      if (q == -1) {
        ansa |= (1 << (30 - k));
        ansb |= (1 << (30 - k));
      }
    } else {
      if (diff == 1) {
        ansa |= (1 << (30 - k));
      } else {
        ansb |= (1 << (30 - k));
      }
      diff = q;
    }
  }
  printf("! %ld %ld", ansa, ansb);
  return 0;
}
