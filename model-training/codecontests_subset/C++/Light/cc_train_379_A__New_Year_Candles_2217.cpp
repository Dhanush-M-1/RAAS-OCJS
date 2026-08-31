#include <bits/stdc++.h>
int main() {
  int a, b, h, left;
  scanf("%d%d", &a, &b);
  left = h = a;
  while (left >= b) {
    left -= b;
    h++;
    left++;
  }
  printf("%d\n", h);
}
