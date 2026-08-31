#include <bits/stdc++.h>
int main() {
  int a, b, d, m;
  scanf("%d %d", &a, &b);
  int res = a;
  while (a >= b) {
    d = a / b;
    res += d;
    m = a % b;
    a = d + m;
  }
  printf("%d", res);
  return 0;
}
