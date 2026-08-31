#include <bits/stdc++.h>
int main() {
  int a, b, n, hour = 0, c;
  scanf("%d%d", &a, &b);
  c = a;
  while (c / b > 0) {
    n = c % b;
    hour = hour + c / b;
    c = c / b;
    c = c + n;
  }
  hour = hour + a;
  printf("%d", hour);
  return 0;
}
