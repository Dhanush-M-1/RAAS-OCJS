#include <bits/stdc++.h>
int main() {
  int a, b, c = 0;
  scanf("%d%d", &a, &b);
  int s = 0;
  while (a > 0) {
    s = s + a;
    int xx = a;
    a = (xx + c) / b;
    c = (xx + c) % b;
  }
  printf("%d\n", s);
  return 0;
}
