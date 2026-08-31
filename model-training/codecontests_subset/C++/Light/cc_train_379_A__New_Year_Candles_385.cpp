#include <bits/stdc++.h>
int main() {
  int a, b;
  scanf("%d %d", &a, &b);
  int hours = a;
  int surplus;
  int t = 0;
  while (a >= b) {
    surplus = a % b;
    a /= b;
    hours += a;
    a += surplus;
  }
  printf("%d", hours);
  return 0;
}
