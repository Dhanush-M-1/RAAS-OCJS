#include <bits/stdc++.h>
int main() {
  int a, b;
  scanf("%d%d", &a, &b);
  int sum = 0, c;
  sum = a;
  while (1) {
    c = a / b;
    a = c + (a % b);
    sum += c;
    if (a < b) break;
  }
  printf("%d\n", sum);
}
