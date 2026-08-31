#include <bits/stdc++.h>
int main() {
  int a, b, c;
  scanf("%d %d %d", &a, &b, &c);
  printf("%d", a * c / b + ((a * c) % b == 0 ? 0 : 1) - c);
  return 0;
}
