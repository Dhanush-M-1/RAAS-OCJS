#include <bits/stdc++.h>
int main() {
  int a, b, c;
  scanf("%d%d%d", &a, &b, &c);
  if (a * c / 100 * 100 == a * c)
    printf("%d\n", a * c / 100 - b >= 0 ? a * c / 100 - b : 0);
  else
    printf("%d\n", a * c / 100 + 1 - b >= 0 ? a * c / 100 + 1 - b : 0);
  return 0;
}
