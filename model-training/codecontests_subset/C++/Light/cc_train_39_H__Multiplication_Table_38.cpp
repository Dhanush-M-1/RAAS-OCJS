#include <bits/stdc++.h>
int tran(int a, int b) {
  int t;
  int res = 0;
  int pow = 1;
  do {
    t = a / b;
    res += pow * (a - (a / b) * b);
    a = t;
    pow *= 10;
  } while (t >= b);
  res += pow * t;
  return res;
}
int main() {
  int b, i, j;
  scanf("%d", &b);
  for (i = 1; i < b; i++) {
    for (j = 1; j < b; j++) {
      printf("%d ", tran(i * j, b));
    }
    printf("\n");
  }
  return 0;
}
