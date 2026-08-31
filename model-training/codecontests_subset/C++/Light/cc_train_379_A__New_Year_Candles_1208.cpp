#include <bits/stdc++.h>
int main() {
  int a = 0;
  int b = 0;
  scanf("%d%d", &a, &b);
  int res = a;
  int r = 0;
  while (a + r >= b) {
    int tmp = a;
    a = (a + r) / b;
    r = (tmp + r) % b;
    res = res + a;
  }
  printf("%d", res);
  return 0;
}
