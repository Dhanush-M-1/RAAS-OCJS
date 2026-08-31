#include <bits/stdc++.h>
int main() {
  int a, b, c, d, e, sum;
  scanf("%d%d%d%d%d", &a, &b, &c, &d, &e);
  sum = a + b + c + d + e;
  printf("%d", (sum % 5 == 0 && sum != 0) ? sum / 5 : -1);
  return 0;
}
