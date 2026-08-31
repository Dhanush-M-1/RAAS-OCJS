#include <bits/stdc++.h>
inline int query(int c, int d) {
  printf("? %d %d\n", c, d);
  fflush(stdout);
  int res;
  scanf("%d", &res);
  return res;
}
void workEqual(int d, int a, int b) {
  for (; ~d; --d) {
    if (query(a | (1 << d), b) == -1) a |= 1 << d, b |= 1 << d;
  }
  printf("! %d %d\n", a, b);
}
int main() {
  int a = 0, b = 0;
  int r = query(a, b);
  if (r == 0) {
    workEqual(29, a, b);
    return 0;
  }
  for (int i = 29; ~i; --i) {
    if (r == 1) {
      int t = query(a, b | (1 << i));
      if (t == 0) {
        a |= 1 << i;
        workEqual(i - 1, a, b);
        return 0;
      } else if (t == 1) {
        a |= 1 << i;
        int t2 = query(a, b);
        if (t2 == -1) b |= 1 << i;
      } else {
        int t2 = query(a | (1 << i), b);
        if (t2 == -1) r = -1, a |= 1 << i;
      }
    } else {
      int t = query(a | (1 << i), b);
      if (t == 0) {
        b |= 1 << i;
        workEqual(i - 1, a, b);
        return 0;
      } else if (t == 1) {
        int t2 = query(a, b | (1 << i));
        if (t2 == 1) r = 1, b |= 1 << i;
      } else {
        b |= 1 << i;
        int t2 = query(a, b);
        if (t2 == 1) a |= 1 << i;
      }
    }
  }
  printf("! %d %d\n", a, b);
  return 0;
}
