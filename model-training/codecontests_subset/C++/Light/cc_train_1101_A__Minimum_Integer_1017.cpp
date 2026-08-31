#include <bits/stdc++.h>
int main() {
  int a, b, c, n, i, m, x;
  scanf("%d", &n);
  for (i = 1; i <= n; i++) {
    scanf("%d%d%d", &a, &b, &c);
    if (c < a)
      printf("%d\n", c);
    else {
      m = b + 1;
      if (m % c == 0)
        printf("%d\n", m);
      else {
        x = m / c;
        printf("%d\n", (x + 1) * c);
      }
    }
  }
}
