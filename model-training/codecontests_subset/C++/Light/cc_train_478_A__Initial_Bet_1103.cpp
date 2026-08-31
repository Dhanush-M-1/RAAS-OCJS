#include <bits/stdc++.h>
int main() {
  int a, b, c, d, e, s;
  scanf("%d%d%d%d%d", &a, &b, &c, &d, &e);
  s = a + b + c + d + e;
  if (s > 0 && s % 5 == 0) {
    printf("%d", s / 5);
  } else {
    printf("-1");
  }
  return 0;
}
