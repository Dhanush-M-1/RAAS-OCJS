#include <bits/stdc++.h>
int main() {
  uint32_t a, b, c;
  scanf("%d %d %d", &a, &b, &c);
  printf("%g", ceil((double)(a * c - b * c) / b));
  return 0;
}
