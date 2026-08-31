#include <bits/stdc++.h>
int main() {
  int a, b, c, d, sum = 0;
  scanf("%d%d", &a, &b);
  sum += a;
  while (a >= b) {
    sum = sum + a / b;
    c = a / b;
    d = a % b;
    a = c + d;
  }
  printf("%d", sum);
  return 0;
}
