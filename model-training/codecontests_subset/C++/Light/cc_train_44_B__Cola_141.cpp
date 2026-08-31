#include <bits/stdc++.h>
int main() {
  int n = 0, a = 0, b = 0, c = 0;
  scanf("%d%d%d%d", &n, &a, &b, &c);
  int ans = 0;
  for (int i = 0; i <= a; i += 2) {
    for (int j = 0; j <= b; ++j) {
      int k = n - i / 2 - j;
      if (0 <= k && k % 2 == 0 && k / 2 <= c) {
        ++ans;
      }
    }
  }
  printf("%d\n", ans);
  return 0;
}
