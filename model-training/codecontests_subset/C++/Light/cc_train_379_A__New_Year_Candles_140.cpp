#include <bits/stdc++.h>
int main() {
  int a, b, sum;
  scanf("%d %d", &a, &b);
  sum = a;
  int r = 0;
  int n = a;
  while (n > 0) {
    r = r + n % b;
    n = n / b;
    sum = sum + n;
  }
  while (r >= b) {
    n = r;
    r = 0;
    while (n > 0) {
      r = r + n % b;
      n = n / b;
      sum = sum + n;
    }
  }
  printf("%d", sum);
  return 0;
}
