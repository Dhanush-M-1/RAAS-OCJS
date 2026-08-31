#include <bits/stdc++.h>
int main() {
  int a, b;
  scanf("%d%d", &a, &b);
  int ans = a;
  while (a / b != 0) {
    ans += a / b;
    a = a / b + a % b;
  }
  printf("%d\n", ans);
  return 0;
}
