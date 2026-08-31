#include <bits/stdc++.h>
int main() {
  int a, b, m, s = 0;
  scanf("%d %d", &a, &b);
  s = a;
  while (1) {
    m = a / b;
    a = m + (a % b);
    s += m;
    if (a < b) break;
  }
  printf("%d", s);
  return 0;
}
