#include <bits/stdc++.h>
int main() {
  int a, b, sum = 0, c;
  scanf("%d%d", &a, &b);
  sum = a;
  while (1) {
    c = a / b;
    a = c + (a % b);
    sum += c;
    if (a < b) break;
  }
  printf("%d\n", sum);
  return 0;
}
