#include <bits/stdc++.h>
int main() {
  int a, b, c, k;
  scanf("%d%d%d", &a, &b, &c);
  k = ((a - b) * c + b - 1) / b;
  printf("%d\n", k);
  return 0;
}
