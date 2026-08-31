#include <bits/stdc++.h>
int main() {
  int a, b, c, d, i, j, k, l, count = 0;
  scanf("%d %d", &a, &b);
  if (a < b) {
    printf("%d", a);
    exit(0);
  }
  k = a;
  while (k >= b) {
    c = k / b;
    d = k % b;
    count += c;
    k = c + d;
  }
  printf("%d", (count + a));
}
