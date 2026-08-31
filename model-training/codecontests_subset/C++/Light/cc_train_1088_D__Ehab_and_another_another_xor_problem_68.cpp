#include <bits/stdc++.h>
using namespace std;
int query(int c, int d, int ret = 0) {
  printf("? %d %d\n", c, d);
  fflush(stdout);
  scanf("%d", &ret);
  return ret;
}
int main() {
  int a = 0, b = 0;
  int aIsBigger = 1;
  if (query(0, 0) < 0) aIsBigger = 0;
  for (int i = 29; i >= 0; i--) {
    int x = query(a ^ (1 << i), b), y = query(a, b ^ (1 << i));
    if (x == y) {
      if (aIsBigger)
        a ^= (1 << i);
      else
        b ^= (1 << i);
      aIsBigger = (x == 1);
    } else if (x == -1 && y == 1) {
      a ^= (1 << i);
      b ^= (1 << i);
    }
  }
  printf("! %d %d\n", a, b);
  return 0;
}
