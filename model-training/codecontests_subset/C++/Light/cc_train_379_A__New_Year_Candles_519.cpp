#include <bits/stdc++.h>
int main() {
  int a, b, c = 0, ans = 0;
  scanf("%d%d", &a, &b);
  while (a) {
    ans += a;
    c += (a % b);
    a /= b;
    if (a == 0 && c >= b) a = (c / b), c = c % b;
  }
  printf("%d\n", ans);
  return 0;
}
