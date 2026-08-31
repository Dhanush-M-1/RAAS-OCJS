#include <bits/stdc++.h>
int Q(int x, int y) {
  printf("? %d %d\n", x, y);
  fflush(stdout);
  std::cin >> x;
  return x;
}
int32_t main() {
  int a = 0, b = 0, t = Q(0, 0), x, y, i = 1 << 30;
  while (i >>= 1) {
    x = Q(a | i, b);
    y = Q(a, b | i);
    if (x == y) {
      if (t > 0)
        a |= i;
      else
        b |= i;
      t = x;
    } else if (x == -1) {
      a |= i, b |= i;
    }
  }
  printf("! %d %d\n", a, b);
}
