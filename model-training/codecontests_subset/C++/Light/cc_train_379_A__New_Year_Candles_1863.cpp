#include <bits/stdc++.h>
int main() {
  int a, b, t = 0;
  scanf("%d%d", &a, &b);
  t = a;
  while (a >= b) {
    t += a / b;
    a = a % b + a / b;
  }
  printf("%d", t);
  return 0;
}
