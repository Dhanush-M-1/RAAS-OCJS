#include <bits/stdc++.h>
int main() {
  int t, a, b, c, sum = 0;
  scanf("%d", &t);
  while (t--) {
    sum = 0;
    scanf("%d %d %d", &a, &b, &c);
    while (c >= 2 && b >= 1) {
      sum += 3;
      c = c - 2;
      b--;
    }
    while (b >= 2 && a >= 1) {
      sum += 3;
      b -= 2;
      a--;
    }
    printf("%d\n", sum);
  }
  return 0;
}
