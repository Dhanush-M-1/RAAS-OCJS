#include <bits/stdc++.h>
int main() {
  int a, b, sum = 0;
  scanf("%d %d", &a, &b);
  getchar();
  sum = a;
  while (b <= a) {
    sum += (a / b);
    a = (a / b) + (a % b);
  }
  printf("%d\n", sum);
}
