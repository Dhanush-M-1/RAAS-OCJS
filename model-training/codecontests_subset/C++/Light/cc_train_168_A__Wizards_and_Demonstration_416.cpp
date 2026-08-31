#include <bits/stdc++.h>
int main() {
  int n, x, y, ans;
  scanf("%d%d%d", &n, &x, &y);
  if ((n * y) % 100 == 0) {
    ans = (n * y) / 100 - x;
  } else {
    ans = (n * y) / 100 + 1 - x;
  }
  if (ans < 0) {
    ans = 0;
  }
  printf("%d", ans);
  return 0;
}
