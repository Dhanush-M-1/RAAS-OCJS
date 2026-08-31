#include <bits/stdc++.h>
int main() {
  long int a, b, c, d, ans;
  int T, i;
  scanf("%d", &T);
  for (i = 1; i <= T; i++) {
    scanf("%ld %ld %ld", &a, &b, &c);
    if (a > c) {
      printf("%ld\n", c);
    } else {
      d = b / c;
      d = d + 1;
      ans = c * d;
      printf("%ld\n", ans);
    }
  }
}
