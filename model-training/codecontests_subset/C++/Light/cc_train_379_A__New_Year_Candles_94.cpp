#include <bits/stdc++.h>
int main() {
  int a, b, sum, aa;
  while (~scanf("%d %d", &a, &b)) {
    sum = 0;
    aa = a;
    while (a >= b) {
      sum += a / b;
      a = a % b + a / b;
    }
    printf("%d\n", aa + sum);
  }
}
