#include <bits/stdc++.h>
int main() {
  int a, b;
  scanf("%d %d", &a, &b);
  int count = a;
  while (a >= b) {
    count += a / b;
    a = a / b + a % b;
  }
  printf("%d", count);
  return 0;
}
