#include <bits/stdc++.h>
int main() {
  int a, b, d, e, c, f;
  scanf("%d%d", &a, &b);
  d = a;
  while (a >= b) {
    d = d + a / b;
    a = a / b + a % b;
  }
  printf("%d\n", d);
  return 0;
}
