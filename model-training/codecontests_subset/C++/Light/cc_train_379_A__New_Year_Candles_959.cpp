#include <bits/stdc++.h>
int main() {
  int a, b;
  while (scanf("%d%d", &a, &b) == 2) {
    int ans = 0, tmp = 0;
    while (a > 0) {
      ans += a;
      tmp += a;
      a = tmp / b;
      tmp %= b;
    }
    printf("%d\n", ans);
  }
  return 0;
}
