#include <bits/stdc++.h>
int main() {
  int a, b, x, y, ans;
  scanf("%d %d", &a, &b);
  ans = a;
  while (a >= b) {
    x = a / b;
    ans = ans + x;
    y = a % b;
    a = x + y;
  }
  printf("%d", ans);
  return 0;
}
