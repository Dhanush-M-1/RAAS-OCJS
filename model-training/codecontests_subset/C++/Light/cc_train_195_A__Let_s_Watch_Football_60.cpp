#include <bits/stdc++.h>
int main() {
  int a, b, c, rest = 0;
  scanf("%d %d %d", &a, &b, &c);
  rest = a * c - b * c;
  a = rest % b ? (rest / b) + 1 : rest / b;
  printf("%d", a);
  return 0;
}
